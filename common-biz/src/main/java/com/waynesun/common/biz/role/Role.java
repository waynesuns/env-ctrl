package com.waynesun.common.biz.role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.waynesun.cache.CacheFactory;
import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.QueryDao;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.dao.query.order.Order;
import com.waynesun.pojo.BaseEntity;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.StringUtils;
import com.waynesun.common.biz.cache.AuthConst;
import com.waynesun.common.biz.config.SystemConfigCacheUtils;
import com.waynesun.common.biz.log.Log;
import com.waynesun.common.biz.log.OperateLog;
import com.waynesun.common.biz.log.OperateLogType;
import com.waynesun.common.biz.resource.Button;
import com.waynesun.common.biz.resource.Menu;
import com.waynesun.common.biz.resource.MenuCategory;
import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.resource.ResourceCacheUtils;
import com.waynesun.common.biz.resource.ResourceQC;
import com.waynesun.common.biz.resource.ResourceUtils;
import com.waynesun.common.biz.user.AbstractDealer;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.biz.user.UserQC;
import com.waynesun.common.biz.user.UserUtils;

/**
 * 角色
 * 
 * @author Administrator
 * 
 */
public class Role extends BaseEntity implements Log {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8146484967109813637L;

	public static final String ROLE_ID_SYSTEM_ADMIN = "1";

	/** 角色名称 */
	private String name;
	/** 该角色对应的菜单 */
	private Set<Resource> resources;
	/** 该角色对应的用户 */
	private Set<AbstractUser> users;
	/**所属经销商编号*/
	private AbstractDealer dealer;

	public Role() {
	}

	public void add() {
		this.update();
	}

	public void add(String[] categoryIds,String[] menuIds, String[] userIds,String[] buttonIds) {
		this.setUsers(new HashSet<AbstractUser>());
		this.setResources(new HashSet<Resource>());
		setResourceAndUser(categoryIds,menuIds, userIds,buttonIds);
		this.update();
	}

	public void modify() {
		setResourceAndUser(null,null, null,null);
		this.update();
	}

	public void modify(String[] categoryIds,String[] menuIds, String[] userIds,String[] buttonIds) {
		this.setUsers(new HashSet<AbstractUser>());
		setResourceAndUser(categoryIds,menuIds, userIds,buttonIds);
		this.update();
		cascadeUpdateRoleState(this);
	}
	
	private void cascadeUpdateRoleState(Role role){
		if(role.getState().equals(PojoState.DELETED)){
			Set<AbstractUser> users=role.getUsers();
			for (AbstractUser abstractUser : users) {
				Set<Role> roles=new HashSet<Role>();
				roles.addAll(abstractUser.getRoles());
				if(roles.contains(role)){
					roles.remove(role);
					abstractUser.update();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void setResourceAndUser(String[] categoryIds, String[] menuIds, String[] userIds, String[] buttonIds) {
		List<Resource> resources = new ArrayList<Resource>();
		List<Button> buttons = null;
		List<AbstractUser> users = null;

		List<Resource> sysResource = (List<Resource>) CacheFactory.getInstance().getCache().get(AuthConst.LOAD_SYS_RESOURCE);
		resources.addAll(sysResource);
		// 更新菜单
		if(categoryIds != null && categoryIds.length > 0) {
			QueryDao dao = DaoFactory.getInstance().getQueryDao();
			List<MenuCategory> menuCategorys = new ArrayList<MenuCategory>();
			for (String id : categoryIds) {
				menuCategorys.add((MenuCategory) dao.get(MenuCategory.class, id, true));
			}
			resources.addAll(menuCategorys);
		}
		if (menuIds != null && menuIds.length > 0) {
			QueryDao dao = DaoFactory.getInstance().getQueryDao();
			List<Resource> list = new ArrayList<Resource>();
			for (String id : menuIds) {
				list.add((Menu) dao.get(Menu.class, id, true));
			}
			resources.addAll(list);
		}
		if (buttonIds != null && buttonIds.length > 0) {
			QueryDao dao = DaoFactory.getInstance().getQueryDao();
			buttons = new ArrayList<Button>();
			for (String id : buttonIds) {
				buttons.add((Button) dao.get(Button.class, id, true));
			}
			resources.addAll(buttons);
		}
		if (resources != null && resources.size() > 0)
			this.setResources(new HashSet<Resource>(resources));
		
		//更新现有用户
		this.updateUsers();
		// 更新用户
		if (userIds != null && userIds.length > 0) {
			QueryDao dao = DaoFactory.getInstance().getQueryDao();
			users = new ArrayList<AbstractUser>();
			for (String id : userIds) {
				users.add((AbstractUser) dao.get(AbstractUser.class, id, true));
			}
			this.setUsers(new HashSet<AbstractUser>(users));
		}
		
		if (users != null && users.size() > 0)
			this.setUsers(new HashSet<AbstractUser>(users));
		
		//更新新增用户
		this.updateUsers();
	}

	private void updateUsers(){
		if(this.getUsers()!=null){
			for(AbstractUser user : this.getUsers()){
				user.update();
			}
		}
	}
	
	/**
	 * 操作日志记录
	 */
	public void update() {
		String idObj = getId();
		super.update();
		if (idObj == null)
			OperateLog.getInstance(this, OperateLogType.ADD).saveOperateLog();
		else
			OperateLog.getInstance(this, OperateLogType.MODIFY).saveOperateLog();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<Resource> getResources()
	{
		return resources;
	}

	public void setResources(Set<Resource> resources)
	{
		this.resources = resources;
	}

	public Set<AbstractUser> getUsers()
	{
		return users;
	}

	public void setUsers(Set<AbstractUser> users)
	{
		this.users = users;
	}
	
	public AbstractDealer getDealer() {
		return dealer;
	}

	public void setDealer(AbstractDealer dealer) {
		this.dealer = dealer;
	}

	public String getResourcesStr()
	{
//		Set<Resource> resources = this.getResources();
//		if (resources == null || resources.size() <= 0)
//			return "";
//		StringBuffer sb = new StringBuffer();
//		int i = 0;
//		for (Resource resource : resources)
//		{
//			if (resource.getState().getState() != 0)
//				continue;
//			if (!(resource instanceof Menu))
//				continue;
//			if (i != 0)
//				sb.append("、");
//			sb.append(resource.getName());
//			i++;
//		}
//		return sb.toString();
		
		Set<Resource> resources = this.getResources();
		if (resources == null || resources.size() <= 0)
			return "";
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for(Resource resource : resources)
		{
			Resource r = ResourceCacheUtils.getResource(resource.getId());
			if (r.getState().getState() != 0)
				continue;
			if (!(r instanceof Menu))
				continue;
			if (i != 0)
				sb.append("、");
			sb.append(r.getName());
			i++;
		}
		return sb.toString();
	}
	
	public String getResourcesIds()
	{
//		Set<Resource> resources = this.getResources();
//		if (resources == null || resources.size() <= 0)
//			return "";
//		StringBuffer sb = new StringBuffer();
//		int i = 0;
//		for (Resource resource : resources)
//		{
//			if (resource.getState().getState() != 0)
//				continue;
//			if (i != 0)
//				sb.append("、");
//			sb.append(resource.getId());
//			i++;
//		}
//		return sb.toString();
		
		Set<Resource> resources = this.getResources();
		if (resources == null || resources.size() <= 0)
			return "";
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for(Resource resource : resources)
		{
			Resource r = ResourceCacheUtils.getResource(resource.getId());
			if (r.getState().getState() != 0)
				continue;
			if (i != 0)
				sb.append("、");
			sb.append(r.getId());
			i++;
		}
		return sb.toString();
	}

	public String getResourcesTitleStr()
	{
//		Set<Resource> resources = this.getResources();
//		StringBuffer sb = new StringBuffer();
//		if (resources == null || resources.size() <= 0)
//			return "";
//		sb.append("<ul>");
//		for (Resource resource : resources)
//		{
//			if (resource.getState().getState() != 0)
//				continue;
//			if (!(resource instanceof Menu))
//				continue;
//			Set<Button> buttons = ((Menu) resource).getButtons();
//			sb.append("<li>");
//			sb.append("<span class='b'>" + StringUtils.escapeHtml(resource.getName()) + "</span>");
//			boolean bool = true;
//			for (Button button : buttons)
//			{
//				Set<Role> roles = button.getRoles();
//				if (roles == null || roles.size() <= 0 || !roles.contains(this) || button.getState().getState() == 1)
//					continue;
//				if(bool)
//					sb.append(":");
//				sb.append("<span class='pl10'>" + StringUtils.escapeHtml(button.getName()) + "</span>");
//				bool = false;
//			}
//			sb.append("</li>");
//		}
//		sb.append("</ul>");
//		return sb.toString();
		
//		Set<Resource> resources = this.getResources();
//		if (resources == null || resources.size() <= 0)
//			return "";
//		StringBuffer sb = new StringBuffer();
//		for(Resource resource : resources)
//		{
//			Resource r = ResourceCacheUtils.getResource(resource.getId());
//			if (r.getState().getState() != 0)
//				continue;
//			if (!(r instanceof Menu))
//				continue;
//			List<Button> buttons = new ArrayList<Button>(((Menu) resource).getButtons());
//			
//			sb.append("<li>");
//			sb.append("<span class='b'>" + StringUtils.escapeHtml(r.getName()) + "</span>");
//			boolean bool = true;
//			for (Button button : buttons)
//			{
//				Set<Role> roles = button.getRoles();
//				if (roles == null || roles.size() <= 0 || !roles.contains(this) || button.getState().getState() == 1)
//					continue;
//				if(bool)
//					sb.append(":");
//				sb.append("<span class='pl10'>" + StringUtils.escapeHtml(button.getName()) + "</span>");
//				bool = false;
//			}
//			sb.append("</li>");
//		}
//		sb.append("</ul>");
//		return sb.toString();

		ResourceQC qc = new ResourceQC();
		qc.setRoles_id(this.getId());
		qc.setRoles_state(PojoState.NORMAL);
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		sq.setOrders(Arrays.asList(Order.asc("level")));
		List<Menu> menus = DaoFactory.getInstance().getQueryDao().list(Menu.class, null, sq, true).getResults();
		List<Button> buttons = DaoFactory.getInstance().getQueryDao().list(Button.class, null, sq, true).getResults();
		List<Resource> list = new ArrayList<Resource>();
		list.addAll(menus);
		list.addAll(buttons);
		Collections.sort(list, new Comparator<Resource>() {

			@Override
			public int compare(Resource o1, Resource o2) {
				return o1.getLevel().compareTo(o2.getLevel());
			}
		});
		Map<String,List<Resource>> map = new LinkedHashMap<String, List<Resource>>();
		for(Resource r : list)
		{
			if(r instanceof Menu)
			{
				List<Resource> l = map.get(r.getId());
				if(l == null)
					l = new ArrayList<Resource>();
				l.add(r);
				map.put(r.getId(), l);
			}
			else if(r instanceof Button)
			{
				List<Resource> l = map.get(((Button) r).getMenu().getId());
				if(l == null)
					l = new ArrayList<Resource>();
				l.add(r);
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<ul style=\"width:325px;\" >");
		for(List<Resource> lr : map.values())
		{
			int length = lr.size();
			int i = 0;
			for(Resource r : lr)
			{
				i++;
				if(r instanceof Menu)
				{
					sb.append("<li>");
					sb.append("<span class=\"b\">");
					sb.append( StringUtils.escapeHtml(r.getName()));
					sb.append("</span>");
					sb.append(":");
				}
				if(r instanceof Button)
				{
					sb.append("<span class=\"pl10\">");
					sb.append(StringUtils.escapeHtml(r.getName()));
					sb.append("</span>");
				}
				if(i == length)
					sb.append("</li>");
			}
		}
		sb.append("</ul>");
		return sb.toString();
	}

	public void addResources(List<Resource> resources,List<Button> buttons)
	{
		Set<Resource> set = this.getResources();
		for (Resource resource : resources)
		{
			if (resource instanceof Menu)
				((Menu) resource).addRole(this,buttons);
		};
		for (Resource resource : set)
		{
			if(!(resource instanceof Menu))
				continue;
			if (!resources.contains(resource))
			{
				((Menu) resource).removeRole(this);
				continue;
			}
			if (resources.contains(resource))
				((Menu) resource).updateButtonRole(this,buttons);
		}
	}

	/**
	 * 启用状态的用户
	 * 
	 * @return
	 */
	public Set<AbstractUser> getUsersByState()
	{
		AbstractUser temp = (AbstractUser) com.waynesun.utils.UserUtils.getUser();
		AbstractUser currerUser = DaoFactory.getInstance().getQueryDao().get(AbstractUser.class, temp.getId(), true);
		String dealerCode = currerUser.getDealer().getDealerCode();
		UserQC qc = new UserQC();
		qc.setRoles_id(this.getId());
		qc.setDealer_dealerCode(dealerCode);
		List<AbstractUser> users = UserUtils.findUsers(qc);
		Set<AbstractUser> newUsers = new HashSet<AbstractUser>();
		for (AbstractUser user : users)
		{
			if (user.getState().getState() != 0)
				continue;
			newUsers.add(user);
		}
		return newUsers;
		
//		StringBuffer hql = new StringBuffer();
//		hql.append("SELECT distinct u FROM AbstractUser u,Role r ");
//		hql.append("WHERE ");
//		hql.append("u.state=? AND u in elements(r.users) AND r.id=? ");
//		Object[] obj = new Object[]{PojoState.NORMAL,this.getId()};
//		List<AbstractUser> list = getDao().find(hql.toString(),obj);
//		return new HashSet<AbstractUser>(list);
		
//		UserQC qc = new UserQC();
//		qc.setState(PojoState.NORMAL);
//		qc.setRoles_id(this.getId());
//		List<AbstractUser> list =getDao().list(AbstractUser.class,null,CriteriaBean.geneateCondition(qc));
		
//		StringBuffer hql = new StringBuffer();
//		hql.append("SELECT la.user FROM LoginAccount la,Role r ");
//		hql.append("WHERE ");
//		hql.append("la.user.state=? AND r in elements(la.user.roles) AND r.id=?");
//		Object[] obj = new Object[]{PojoState.NORMAL,this.getId()};
//		List<AbstractUser> list = getDao().find(hql.toString(),obj);
//		return new HashSet<AbstractUser>(list);
	}

	public List<Resource> getRoleByState()
	{
		ResourceQC qc = new ResourceQC();
		qc.setState_not(PojoState.DELETED);
		qc.setRoles_id(this.getId());
		return ResourceUtils.findResources(qc);
	}

	public List<Resource> getResourceByLevel(Integer level)
	{
		ResourceQC qc = new ResourceQC();
		qc.setLevel(level);
		qc.setState(PojoState.NORMAL);
		return ResourceUtils.findResources(qc, new Order[] { Order.asc("level") });
	}
	
	/**
	 * 取得系统配置中的用户Id
	 * @param config
	 * @return
	 */
	public static String getRoleIdByConfig(String config) {
		return SystemConfigCacheUtils.getCacheSystemConfig(config).getValue();
	}
	
	/**
	 * 取得系统配置中的用户
	 * @param config
	 * @return
	 */
	public static Role getRoleByConfig(String config) {
		String roleId = getRoleIdByConfig(config);
		return DaoFactory.getInstance().getQueryDao().get(Role.class, roleId, true);
	}
	
	public String getUserNames() {
		String userNames = "";
		Set<AbstractUser> users=this.getUsers();
		if(users!=null&&users.size()>0){
			StringBuffer bf=new StringBuffer();
			for (AbstractUser abstractUser : users) {
				bf.append(abstractUser.getName()+",");
			}
			userNames = bf.substring(0, bf.length()-1);
		}
		return userNames;
	}
				
	public String getUsersByStateNames(){
		String userByStateNames = "";
		Set<AbstractUser> userNames = this.getUsersByState();
		if(userNames!=null&&userNames.size()>0){
			StringBuffer bf=new StringBuffer();
			for (AbstractUser abstractUser : userNames) {
				bf.append(abstractUser.getName()+",");
			}
			userByStateNames = bf.substring(0, bf.length()-1);
		}
		return userByStateNames;
	}
	
	public String getUsersByStateIds(){
		String userByStateIds = "";
		Set<AbstractUser> userNames = this.getUsersByState();
		if(userNames!=null&&userNames.size()>0){
			StringBuffer bf=new StringBuffer();
			for (AbstractUser abstractUser : userNames) {
				bf.append(abstractUser.getId()+",");
			}
			userByStateIds = bf.substring(0, bf.length()-1);
		}
		return userByStateIds;
	}
	
	public String getMenus(){
		ResourceQC qc=new ResourceQC();
//		qc.setLevel(0);
		qc.setState_not(PojoState.SYSTEM);
		qc.setRoles_id(this.getId());
//		List<Resource> resources=ResourceUtils.findResourceByQC(qc);
		List<Resource> resources=ResourceUtils.findResources(qc);
		Set<MenuCategory> menuCategorys=new HashSet<MenuCategory>();
		Set<Menu> menus=new HashSet<Menu>();
		Set<Button> buttons=new HashSet<Button>();
		if(resources!=null&&resources.size()>0){
			for (Resource resource : resources) {
				if(resource!=null){
					if(resource instanceof MenuCategory)
						menuCategorys.add((MenuCategory)resource);
					if(resource instanceof Menu)
						menus.add((Menu)resource);
					if(resource instanceof Button)
						buttons.add((Button)resource);
				}
			}
		}
		StringBuffer bf=new StringBuffer();
		if (menuCategorys != null && menuCategorys.size() > 0) {
			for (MenuCategory menuCategory : menuCategorys) {
				bf.append(menuCategory.getName() + ":\r\n");
				for (Menu menu : menus) {
					if (menu.getCategory()!=null&&menu.getCategory().getId()
							.equals(menuCategory.getId())) {
						bf.append("----" + menu.getName() + ":");
						for (Button button : buttons) {
							if (button.getMenu().getId()
									.equals(menu.getId())) {
								bf.append(button.getName() + "、");
							}
						}
					}
					bf.delete(bf.length() - 1, bf.length());
					bf.append("\r\n");
				}
			}
		}
			for (Menu menu : menus) {
				if(menu.getCategory()==null){
				bf.append(menu.getName() + ":");
				for (Button button : buttons) {
					if (button.getMenu().getId().equals(menu.getId())) {
						bf.append(button.getName() + "、");
					}
				}
				bf.delete(bf.length() - 1, bf.length());
				bf.append("\r\n");
				}
			}
		
		return bf.toString();
	}
}

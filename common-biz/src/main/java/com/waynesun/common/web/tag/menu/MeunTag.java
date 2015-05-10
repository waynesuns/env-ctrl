package com.waynesun.common.web.tag.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;
import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.QueryDao;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.CollectionUtil;
import com.waynesun.utils.StringUtils;
import com.waynesun.common.biz.cache.AuthConst;
import com.waynesun.common.biz.resource.Menu;
import com.waynesun.common.biz.resource.MenuCategory;
import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.role.Role;

public class MeunTag extends TagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 43674304632134398L;

	private static Set<Resource> resources = new HashSet<Resource>();
	private static List<Resource> list = new ArrayList<Resource>();

	private static String pojectURL = null;

	@SuppressWarnings("unchecked")
	@Override
	public int doEndTag() throws JspException
	{
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		request.setAttribute("projectName", request.getContextPath());
		setAccessURL(request);
//		AbstractUser user = (AbstractUser) UserUtils.getUser();
//		RoleQC qc = new RoleQC();
//		qc.setUsers_id(user.getId());
//		List<Role> roles = DaoFactory.getInstance().getDao().list(Role.class, null,CriteriaBean.geneateCondition(qc), null);
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		Iterator<GrantedAuthority> iterator = authorities.iterator();
		List<String> roleId = new ArrayList<String>();
		while(iterator.hasNext())
		{
			GrantedAuthority authority = iterator.next();
			String id = authority.getAuthority();
			if(!AuthConst.PUBLIC_AUTHORITY_ROLE_ID.equals(id))
				roleId.add(id);
		}
		List<Role> roles = new ArrayList<Role>();
		if(!CollectionUtil.isEmptyOrZero(roleId))
		{
			String[] ids = (String[]) roleId.toArray(new String[roleId.size()]);
			QueryDao dao = DaoFactory.getInstance().getQueryDao();
			roles = new ArrayList<Role>();
			for (String id : ids) {
				roles.add((Role) dao.get(Role.class, id, true));
			}
		}
		resources = new HashSet<Resource>();
		Cache cache = CacheFactory.getInstance().getCache();
		List<Resource> sysResourceList = (List<Resource>) cache.get(AuthConst.LOAD_SYS_RESOURCE);
		resources.addAll(sysResourceList);
		List<Resource> listSortResource = new ArrayList<Resource>();
		Map<String, Resource> map = new HashMap<String, Resource>();
		for (Resource resource : sysResourceList)
			map.put(resource.getId(), resource);
		for (Role role : roles)
		{
			role = DaoFactory.getInstance().getQueryDao().get(Role.class, role.getId(), true);
			if (PojoState.DELETED.equals(role.getState()))
				continue;
			Set<Resource> set = new HashSet<Resource>();
			List<Resource> resourceLevel = role.getResourceByLevel(0);
			for (Resource resource : resourceLevel)
				map.put(resource.getId(), resource);
			for (Resource resource : role.getResources())
			{
				if (PojoState.DELETED.equals(resource.getState()))
					continue;
				set.add(resource);
			}
			resources.addAll(set);
		}
		for (Resource resource : map.values())
			listSortResource.add(resource);
		for (int i = 0; i < listSortResource.size(); i++)
		{
			Resource r = listSortResource.get(i);
			if (!(r instanceof MenuCategory) && !(r instanceof Menu))
			{
				listSortResource.remove(i);
				i = -1;
			}
		}
		Collections.sort(listSortResource, new Comparator<Resource>()
		{
			@Override
			public int compare(Resource o1, Resource o2)
			{
				return o1.getOrderNumber().compareTo(o2.getOrderNumber());
			}
		});
		list = new ArrayList<Resource>(resources);
		StringBuffer sb = new StringBuffer();
		for (Resource resource : listSortResource)
		{
			String code = "menu_"+resource.getCode();
			if (resource instanceof MenuCategory)
			{
//				code = "menu_"+resource.getCode();
				MenuCategory category = (MenuCategory) resource;
				Set<Menu> menuSet = category.getMenus();
				boolean bool = false;
				for (Menu menu : menuSet)
				{
					if (list.contains(menu))
						bool = true;
				}
				if (bool)
					sb.append(getLiMenuHTMLByCateory(category,code));
			}
			if (resource instanceof Menu)
			{
				if(list.contains(resource))
				{
					Menu menu = (Menu) resource;
					sb.append(getLiMenuHTMLByMenu(menu,code));
				}
			}
		}
		JspWriter out = pageContext.getOut();
		try
		{
			out.print(sb);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException
	{
		return super.doStartTag();
	}

	/**
	 * 顶级类别生成
	 * 
	 * @param category
	 * @return
	 */
	private String getLiMenuHTMLByCateory(MenuCategory category,String code)
	{
		StringBuffer sb = new StringBuffer();
		
    	sb.append("<li id=\""+code+"\" role=\"category\">");
    	sb.append("<a>"+StringUtils.escapeHtml(category.getName())+"<span class=\"fa arrow\"></span></a>");
    	sb.append("<ul class=\"nav nav-second-level\">");
//		sb.append("<li id=\""+code+"\" ><a href=\"javascript:void(0)\">");
//		sb.append(StringUtils.escapeHtml(category.getName()) + "</a>");
//		sb.append("</li><li style=\"height:0;clear:both;\"></li>");
		MenuCategory newCategory = DaoFactory.getInstance().getQueryDao().get(MenuCategory.class, category.getId(), true);
		Set<Menu> menus = newCategory.getMenus();
		for (Menu menu : menus)
		{
			if (!list.contains(menu))
				continue;
			if (!PojoState.DELETED.equals(menu.getState()))
				sb.append(getLiHTMLByMenu(menu,code));
		}
		sb.append("</ul>");
		sb.append("</li>");
		return sb.toString();
	}

	/**
	 * 顶级菜单生成
	 * 
	 * @param menu
	 * @return
	 */
	private String getLiMenuHTMLByMenu(Menu menu,String code)
	{
		StringBuffer sb = new StringBuffer();
		String value=menu.getValue();
		value=value==null?"":value.replaceAll("\\*", "");
     	sb.append("<li id=\""+code+"\" role=\"menu\">");
     	sb.append("<a role=\""+value+"\" href=\"" + pojectURL + menu.getPath() + "\">");
     	sb.append(StringUtils.escapeHtml(menu.getName()) + "</a>");
     	sb.append("</li>");
//		sb.append("<li id=\""+code+"\" ><a href=\"" + pojectURL + menu.getPath() + "\">");
//		sb.append(StringUtils.escapeHtml(menu.getName()) + "</a>");
//		sb.append("</li>");
		return sb.toString();
	}

	/**
	 * 带有类别的菜单生成
	 * 
	 * @param menu
	 * @return
	 */
	private String getLiHTMLByMenu(Menu menu,String code)
	{
		StringBuffer sb = new StringBuffer();
		String value=menu.getValue();
		value=value==null?"":value.replaceAll("\\*", "");
		sb.append("<li id=\""+code+"\" role=\"menu_class\">");
		sb.append("<a role=\""+value+"\" href=\""+pojectURL + menu.getPath()+"\">"+StringUtils.escapeHtml(menu.getName())+"</a>");
//		sb.append("<div class=\""+code+" sub_nav\" class=\""+code+"\" style=\"display:none\" onclick=\"window.location.href='" + pojectURL + menu.getPath() + "'\"><a class=\"cursor\">"
//				+ StringUtils.escapeHtml(menu.getName()) + "</a></div>");
		sb.append("</li>");
		return sb.toString();
	}

	/**
	 * 设置访问的绝对路径
	 * 
	 * @param request
	 */
	private void setAccessURL(HttpServletRequest request)
	{
		pojectURL = request.getContextPath();
//		if (request.getServerPort() == 80)
//			pojectURL = request.getScheme() + "://" + request.getServerName() + request.getContextPath();
//		else
//			pojectURL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}
}

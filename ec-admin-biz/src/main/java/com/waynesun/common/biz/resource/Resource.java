package com.waynesun.common.biz.resource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;
import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.QueryDao;
import com.waynesun.exception.BizException;
import com.waynesun.pojo.BaseEntity;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.CollectionUtil;
import com.waynesun.utils.StringUtils;
import com.waynesun.common.biz.cache.AuthConst;
import com.waynesun.common.biz.role.Role;
import com.waynesun.common.biz.role.RoleQC;
import com.waynesun.common.biz.role.RoleUtils;

@JsonAutoDetect
public class Resource extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3609385300367267862L;

	/** 编号 */
	private String code;
	/** 名称 */
	private String name;
	/** 排序号 */
	private Integer orderNumber;
	/** 菜单图标 */
	private String imgPath;
	/** 跳转URL的UrlMatcher表达式 */
	private String value;
	/** 菜单跳转的URL */
	private String path;
	/** 层级 */
	private Integer level;
	/** 角色 */
	private Set<Role> roles;

	public Resource()
	{
	}

	public void update()
	{
		List<Resource> list = null;
		if (!StringUtils.isEmpty(this.getCode()))
		{
			ResourceQC qc = new ResourceQC();
			qc.setCode(this.getCode());
			list = ResourceUtils.findResources(qc);
		}
		if (list.size() > 0 && !list.get(0).getId().equals(this.getId()))
			throw new BizException("menu.code.presence");
		super.update();
	}

	@Transient
	public String getRoleAuthorities()
	{
		Set<String> roleAuthorities = new HashSet<String>();
		Set<Role> roleSet = this.getRoles();
		if(CollectionUtil.isEmptyOrZero(roleSet))
			return "";

		for (Role role : roleSet)
		{
			if (!role.getState().equals(PojoState.DELETED))
				roleAuthorities.add(role.getId());
		}
//		if(roleAuthorities == null || roleAuthorities.size() <= 0)
//			roleAuthorities.add("-9999");

		return org.apache.commons.lang.StringUtils.join(roleAuthorities.iterator(), ",");
	}

	public Set<Role> getFollowRoles()
	{
		return getRoles();
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getOrderNumber()
	{
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public String getImgPath()
	{
		return imgPath;
	}

	public void setImgPath(String imgPath)
	{
		this.imgPath = imgPath;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public Integer getLevel()
	{
		return level;
	}

	public void setLevel(Integer level)
	{
		this.level = level;
	}

	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}

	public void updateRole(String[] roleIds){}
	
	public String getParentId(){ return null; }

	/**
	 * 重置授权角色
	 * 
	 * @param roleIds
	 */
	@SuppressWarnings("unchecked")
	public void setRole(String[] roleIds)
	{
		this.setRoles(new HashSet<Role>());
		if (roleIds != null && roleIds.length > 0)
		{
			QueryDao dao = DaoFactory.getInstance().getQueryDao();
			List<Role> roles = new ArrayList<Role>();
			for (String id : roleIds) {
				roles.add((Role) dao.get(Role.class, id, true));
			}
			this.getRoles().addAll(roles);
		}
		Cache cache = CacheFactory.getInstance().getCache();
		roles.addAll((List<Role>) cache.get(AuthConst.LOAD_SYS_ROLE));
	}

	/**
	 * 为父级添加授权角色
	 * 
	 * @param resource
	 * @param roleIds
	 */
	@SuppressWarnings("unchecked")
	public void addRoleByParent(Resource resource, String[] roleIds)
	{
		if (resource == null)
			return;
		if(resource instanceof Menu)
			((Menu) resource).updateRole();
		if(resource instanceof MenuCategory)
			((MenuCategory) resource).updateRole();
		Set<Role> set = resource.getRoles();
		if(roleIds == null || roleIds.length <= 0 )
			return;
		QueryDao dao = DaoFactory.getInstance().getQueryDao();
		List<Role> roles = new ArrayList<Role>();
		for (String id : roleIds) {
			roles.add((Role) dao.get(Role.class, id, true));
		}
		if (set == null || set.size() <= 0)
			set = new HashSet<Role>();
		for (Role role : roles)
		{
			if (!set.contains(role))
				set.add(role);
		}
		Cache cache = CacheFactory.getInstance().getCache();
		set.addAll((List<Role>) cache.get(AuthConst.LOAD_SYS_ROLE));
		resource.setRoles(set);
		resource.update();
	}

	/**
	 * 为子级添加授权角色
	 * 
	 * @param resource
	 * @param roleIds
	 */
	@SuppressWarnings("unchecked")
	public void addRoleByChildren(Resource resource, String[] roleIds)
	{
		List<Role> removeList = new ArrayList<Role>();
		if (resource == null)
			return;
		Set<Role> set = resource.getRoles();
		if (set == null || set.size() <= 0)
			set = new HashSet<Role>();
		if (roleIds == null || roleIds.length <= 0)
		{
			resource.setRoles(new HashSet<Role>());
			resource.update();
			return;
		}
		QueryDao dao = DaoFactory.getInstance().getQueryDao();
		List<Role> roles = new ArrayList<Role>();
		for (String id : roleIds) {
			roles.add((Role) dao.get(Role.class, id, true));
		}
		for (Role role : set)
			if (!roles.contains(role))
				removeList.add(role);
		for(Role role : roles)
			if (!set.contains(role))
				set.add(role);
		set.removeAll(removeList);
		Cache cache = CacheFactory.getInstance().getCache();
		set.addAll((List<Role>) cache.get(AuthConst.LOAD_SYS_ROLE));
		resource.setRoles(set);
		resource.update();
	}
	
	
	public String getRoleNameByNormal()
	{
		RoleQC qc = new RoleQC();
		qc.setResources_id(this.getId());
		qc.setState(PojoState.NORMAL);
		List<Role> list = RoleUtils.findRoles(qc);
		List<String> strList = new ArrayList<String>();
		for(Role role : list)
			strList.add(role.getName());
		return org.apache.commons.lang.StringUtils.join(strList.iterator(),"、");
	}
}

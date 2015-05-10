package com.waynesun.common.biz.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.waynesun.exception.BizException;
import com.waynesun.pojo.PojoState;
import com.waynesun.common.biz.role.Role;

/**
 * 菜单类别
 * 
 * @author Administrator
 * 
 */
@JsonAutoDetect
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "menus" })
public class MenuCategory extends Resource {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1034286309083790890L;

	private Set<Menu> menus;

	public MenuCategory() {
	}

	@Override
	public void delete() {
		for (Menu menu : menus)
			menu.delete();
		super.delete();
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
	public String getParentId(){
		return "";
	}

	public void updateState(Integer state) {
		if (state == 1)
			this.disabled();
		if (state == 0)
			this.enabled();
	}

	/**
	 * 菜单类别禁用
	 */
	public void disabled() {
		Set<Menu> set = this.getMenus();
		for (Menu menu : set)
			menu.disabled();
		this.setState(PojoState.DELETED);
	}
	
	/**
	 * 菜单类别启用
	 */
	public void enabled() {
		this.setState(PojoState.NORMAL);
	}

	public String getPath() {
		return "";
	}

	public String getValue() {
		return "";
	}

	/**
	 * 根据关联关系添加授权角色
	 * 
	 * @param roleIds
	 */
	public void updateRole(String[] roleIds) {
		this.setRole(roleIds);
		Set<Menu> menuSet = this.getMenus();
		if ((menuSet == null || menuSet.size() <= 0)&&(roleIds != null && roleIds.length>0))
			throw new BizException("menu.category.roles.empty");
		for (Menu menu : menuSet) {
			addRoleByChildren(menu, roleIds);
			Set<Button> buttonSet = menu.getButtons();
			if (buttonSet == null || buttonSet.size() <= 0)
				continue;
			for (Button button : buttonSet)
				addRoleByChildren(button, roleIds);
		}
	}

	/**
	 * 若子级不存在角色,则删除角色
	 */
	public void updateRole() {
		Set<Menu> set = this.getMenus();
		Set<Role> thisRoles = this.getRoles();
		List<Role> removeList = new ArrayList<Role>();
		List<Role> allList = new ArrayList<Role>();
		for (Menu menu : set)
			allList.addAll(menu.getRoles());
		for (Role role : thisRoles)
			if (!allList.contains(role))
				removeList.add(role);
		thisRoles.removeAll(removeList);
		this.setRoles(thisRoles);
	}

}

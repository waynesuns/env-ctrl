package com.waynesun.common.biz.resource;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.waynesun.dao.DaoFactory;
import com.waynesun.pojo.PojoState;
import com.waynesun.common.biz.role.Role;

/**
 * 按钮
 * 
 * @author Administrator
 * 
 */
@JsonAutoDetect
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Button extends Resource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8002545553673881633L;

	/** 菜单 */
	private Menu menu;
	/** 菜单跳转的URL */
	private String path;
	/** 跳转URL的UrlMatcher表达式 */
	private String value;

	public Button() {
	}

	@Override
	public Set<Role> getFollowRoles() {
		Set<Role> thisRoles = this.getRoles();
		if (menu == null)
			return thisRoles;
		Set<Role> parentRoles = menu.getFollowRoles();
		if (thisRoles == null)
			return parentRoles;
		parentRoles.addAll(thisRoles);
		return parentRoles;
	}

	public void add() {
		this.update();
	}

	public void add(String menuId) {
		Menu menu = DaoFactory.getInstance().getQueryDao().get(Menu.class, menuId, true);
		this.update();
		menu.getButtons().add(this);
		menu.update();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getParentId(){
		if(menu == null)
			return "";
		return menu.getId();
	}
	
	public void updateState(Integer state)
	{
		if (state == 1)
			this.disabled();
		if (state == 0)
			this.enabled();
	}

	/**
	 * 按钮禁用
	 */
	public void disabled()
	{
		this.setState(PojoState.DELETED);
	}
	
	/**
	 * 按钮启用
	 */
	public void enabled() {
		Menu menu = this.getMenu();
		menu.setState(PojoState.NORMAL);
		this.setState(PojoState.NORMAL);
	}

	/**
	 * 根据关联关系添加授权角色
	 * 
	 * @param roleIds
	 */
	public void updateRole(String[] roleIds) {
		this.setRole(roleIds);
		Menu menu = this.getMenu();
		addRoleByParent(menu, roleIds);
		if( menu == null)
			return;
		MenuCategory category = menu.getCategory();
		addRoleByParent(category, roleIds);
	}
	
}
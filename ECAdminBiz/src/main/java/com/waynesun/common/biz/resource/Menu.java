package com.waynesun.common.biz.resource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.waynesun.dao.DaoFactory;
import com.waynesun.exception.BizException;
import com.waynesun.pojo.PojoState;
import com.waynesun.common.biz.role.Role;

/**
 * 菜单
 * 
 * @author Administrator
 * 
 */
@JsonAutoDetect
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "roles", "buttons" })
public class Menu extends Resource
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4322325699450733598L;

	/** 菜单类别 */
	private MenuCategory category;
	/** 该菜单的按钮 */
	private Set<Button> buttons;

	public Menu()
	{
	}

	@Override
	public Set<Role> getFollowRoles()
	{
		Set<Role> thisRoles = this.getRoles();
		if (category == null)
			return thisRoles;
		Set<Role> parentRoles = category.getFollowRoles();
		if(thisRoles == null)
			return parentRoles;
		parentRoles.addAll(thisRoles);
		return parentRoles;
	}

	public void add()
	{
		this.update();
	}

	public void add(String menuCategoryId)
	{
		this.update();
		MenuCategory category = DaoFactory.getInstance().getQueryDao().get(MenuCategory.class, menuCategoryId, true);
		category.getMenus().add(this);
		category.update();
	}

	@Override
	public void delete()
	{
		for (Button button : buttons)
			button.delete();
		super.delete();
	}

	public MenuCategory getCategory()
	{
		return category;
	}

	public void setCategory(MenuCategory category)
	{
		this.category = category;
	}

	public Set<Button> getButtons()
	{
		return buttons;
	}

	public void setButtons(Set<Button> buttons)
	{
		this.buttons = buttons;
	}
	
	public String getParentId(){
		if(category == null)
			return "";
		return category.getId();
	}

	public void updateState(Integer state)
	{
		if (state == 1)
			this.disabled();
		if (state == 0)
			this.enabled();
	}

	/**
	 * 菜单禁用
	 */
	public void disabled()
	{
		Set<Button> set = this.getButtons();
		for (Button button : set)
			button.setState(PojoState.DELETED);
		this.setState(PojoState.DELETED);
	}
	
	/**
	 * 菜单启用
	 */
	public void enabled() {
		MenuCategory category = this.getCategory();
		if(category != null)
			category.setState(PojoState.NORMAL);
		this.setState(PojoState.NORMAL);
	}
	
	
	/**
	 * 根据关联关系添加授权角色
	 * 
	 * @param roleIds
	 */
	public void updateRole(String[] roleIds) {
		this.setRole(roleIds);
		MenuCategory category = this.getCategory();
		addRoleByParent(category, roleIds);
		Set<Button> buttonSet = this.getButtons();
		if(buttonSet == null || buttonSet.size()<=0)
			return;
		for (Button button : buttonSet)
			addRoleByChildren(button, roleIds);
	}
	
	/**
	 * 若子级不存在角色,则删除角色
	 */
	public void updateRole(){
		Set<Button> set = this.getButtons();
		Set<Role> thisRoles = this.getRoles();
		List<Role> removeList = new ArrayList<Role>();
		List<Role> allList = new ArrayList<Role>();
		for(Button button : set)
			allList.addAll(button.getRoles());
		for(Role role : thisRoles)
			if(!allList.contains(role))
				removeList.add(role);
		thisRoles.removeAll(removeList);
		this.setRoles(thisRoles);
	}
	
	/**
	 * 添加一个角色
	 * @param role
	 */
	public void addRole(Role role,List<Button> buttonList){
		if(role == null)
			throw new BizException("role.empty");
		if(this.getRoles() == null || this.getRoles().size()<=0)
			this.setRoles(new HashSet<Role>());
		if(!this.getRoles().contains(role))
		{
			this.getRoles().add(role);
			this.update();
		}
		Set<Button> buttons = this.getButtons();
		for(Button button : buttons){
			if(button.getRoles().contains(this))
				continue;
			if(!buttonList.contains(button))
				continue;
			button.getRoles().add(role);
			button.update();
		}
		MenuCategory category = this.getCategory();
		if(category == null || category.getRoles().contains(this))
			return;
		category.getRoles().add(role);
		category.update();
	}
	
	/**
	 * 删除一个角色
	 * @param role
	 */
	public void removeRole(Role role){
		if(role == null)
			throw new BizException("role.empty");
		if(this.getRoles() == null || this.getRoles().size()<=0)
			this.setRoles(new HashSet<Role>());
		if(!this.getRoles().contains(role))
			return;
		this.getRoles().remove(role);
		Set<Button> buttons = this.getButtons();
		for(Button button : buttons){
			if(!button.getRoles().contains(role))
				continue;
			button.getRoles().remove(role);
			button.update();
		}
		this.update();
		MenuCategory category = this.getCategory();
		if(category == null || !category.getRoles().contains(role))
			return;
		Set<Menu> sets = category.getMenus();
		boolean bool = true;
		for(Menu menu : sets){
			if(menu.getRoles().contains(role))
				bool = false;
		}
		if(!bool)
			return;
		category.getRoles().remove(role);
		category.update();
	}
	
	/**
	 * 更新角色
	 * @param role
	 */
	public void updateButtonRole(Role role,List<Button> buttons)
	{
		if(role == null)
			throw new BizException("role.empty");
		Set<Button> buttonList = this.getButtons();
		if(buttonList == null || buttonList.size() <= 0)
			return;
		for(Button button : buttonList){
			if(buttons.contains(button))
				continue;
			Set<Role> roles = button.getRoles();
			if(roles == null || roles.size() <= 0)
				continue;
			if(!roles.contains(role))
				continue;
			button.getRoles().remove(role);
			button.update();
		}
	}
	
}

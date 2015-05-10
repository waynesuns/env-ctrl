package com.waynesun.common.biz.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.waynesun.utils.StringUtils;

public class ResourceTreeBean implements Serializable{
	public static final String MENUCATEGORY="menucategory";
	public static final String MENU="menu";
	public static final String BUTTON="button";
	/**
	 * 
	 */
	private static final long serialVersionUID = 5073543975253600927L;
	private String name;
	private String id;
	private String parentId;
	private String type;
	private String code;
	private List<ResourceTreeBean> childrens;
	private String path;
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<ResourceTreeBean> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<ResourceTreeBean> childrens) {
		if(childrens.size()==0)
			return;
		this.childrens = childrens;
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
	
	public static List<ResourceTreeBean> transforResourceToTree(List<Resource> resources){
		List<ResourceTreeBean> rtbList=new ArrayList<ResourceTreeBean>();
		Map<String,MenuCategory> categorys=new HashMap<String,MenuCategory>();
		Map<String,List<Menu>> menus=new HashMap<String,List<Menu>>();
		Map<String,List<Button>> buttons=new HashMap<String,List<Button>>();
		for (Resource resource : resources) {
			if(resource instanceof MenuCategory)
				categorys.put(resource.getId(), (MenuCategory)resource);
			if(resource instanceof Menu){
				Menu menu=(Menu)resource;
				if(StringUtils.isEmpty( menu.getParentId())){
					List<Menu> menuList=menus.get("no_parent");
					if(menuList==null){
						menuList=new ArrayList<Menu>();
					}
					menuList.add(menu);
					menus.put("no_parent", menuList);
				}else{
					List<Menu> menuList=menus.get(menu.getParentId());
					if(menuList==null){
						menuList=new ArrayList<Menu>();
					}
					menuList.add(menu);
					menus.put(menu.getParentId(), menuList);
				}
			}
			if(resource instanceof Button){
				List<Button> buttonList=buttons.get(((Button)resource).getParentId());
				if(buttonList==null){
					buttonList=new ArrayList<Button>();
				}
				buttonList.add((Button)resource);
				buttons.put(((Button)resource).getParentId(), buttonList);
			}
		}
		for (Map.Entry<String,MenuCategory> categorySet: categorys.entrySet()) {
			ResourceTreeBean rtb=new ResourceTreeBean();
			MenuCategory menuCategory=categorySet.getValue();
			List<ResourceTreeBean> menusList=new ArrayList<ResourceTreeBean>();
			copyResrouces(rtb,menuCategory);
			rtb.setParentId("");
			rtb.setType(ResourceTreeBean.MENUCATEGORY);
			List<Menu> menuCategory_menus=menus.get(menuCategory.getId());
			if(menuCategory_menus!=null&&menuCategory_menus.size()>0){
				for (Menu menu : menuCategory_menus) {
					List<ResourceTreeBean> buttonsList=new ArrayList<ResourceTreeBean>();
					ResourceTreeBean rtb_menu=new ResourceTreeBean();
					copyResrouces(rtb_menu,menu);
					rtb_menu.setParentId(menuCategory.getId());
					rtb_menu.setType(ResourceTreeBean.MENU);
					List<Button> menu_bottons=buttons.get(menu.getId());
					if(menu_bottons!=null&&menu_bottons.size()>0){
						for (Button button : menu_bottons) {
							ResourceTreeBean rtb_button=new ResourceTreeBean();
							copyResrouces(rtb_button,button);
							rtb_button.setParentId(menu.getId());
							rtb_button.setType(ResourceTreeBean.BUTTON);
							buttonsList.add(rtb_button);
						}
						rtb_menu.setChildrens(buttonsList);
					}
					menusList.add(rtb_menu);
				}
				rtb.setChildrens(menusList);
			}
			rtbList.add(rtb);
		}
		
		for (Menu menu : menus.get("no_parent")) {
			List<ResourceTreeBean> buttonsList = new ArrayList<ResourceTreeBean>();
			ResourceTreeBean rtb_menu = new ResourceTreeBean();
			copyResrouces(rtb_menu, menu);
			rtb_menu.setParentId("");
			rtb_menu.setType(ResourceTreeBean.MENU);
			List<Button> menu_bottons = buttons.get(menu.getId());
			if (menu_bottons != null && menu_bottons.size() > 0) {
				for (Button button : menu_bottons) {
					ResourceTreeBean rtb_button = new ResourceTreeBean();
					copyResrouces(rtb_button, button);
					rtb_button.setParentId(menu.getId());
					rtb_button.setType(ResourceTreeBean.BUTTON);
					buttonsList.add(rtb_button);
				}
				rtb_menu.setChildrens(buttonsList);
			}
			rtbList.add(rtb_menu);
		}
		return rtbList;
	}
	
	private static void copyResrouces(ResourceTreeBean rtb,Resource resource){
		rtb.setCode(resource.getCode());
		rtb.setId(resource.getId());
		rtb.setName(resource.getName());
		rtb.setPath(resource.getPath());
		rtb.setValue(resource.getValue());
	}
}

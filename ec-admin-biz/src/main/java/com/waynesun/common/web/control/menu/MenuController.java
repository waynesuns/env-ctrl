package com.waynesun.common.web.control.menu;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.order.Order;
import com.waynesun.exception.BizException;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.JsonStringUtils;
import com.waynesun.utils.export.param.ExportParam;
import com.waynesun.utils.export.param.vt.BeanPropertyEPVT;
import com.waynesun.utils.export.param.vt.StringEPVT;
import com.waynesun.common.biz.resource.Button;
import com.waynesun.common.biz.resource.Menu;
import com.waynesun.common.biz.resource.MenuCategory;
import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.resource.ResourceQC;
import com.waynesun.common.biz.resource.ResourceUtils;
import com.waynesun.common.biz.role.Role;
import com.waynesun.common.biz.role.RoleQC;
import com.waynesun.common.biz.role.RoleUtils;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.util.datatable.DataTablePages;
import com.waynesun.common.util.reload.ResourceReload;
import com.waynesun.common.web.control.AbstractBindController;

@Controller
@RequestMapping(value = "/menu")
public class MenuController extends AbstractBindController {
	/**
	 * 进入菜单管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/show/home", method = RequestMethod.GET)
	public String showPageView() {
		return ".main~/menu/home.jsp";
	}

	/**
	 * 获取菜单列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/list", method = RequestMethod.POST)
	@ResponseBody
	public String getList(HttpServletResponse response,DataTablePages pages) throws Exception {
		ResourceQC qc = new ResourceQC();
		qc.setState_not(PojoState.SYSTEM);
		List<Resource> list = ResourceUtils.findResources(qc,new Order[] { Order.asc("orderNumber") });
		List<Resource> other = new ArrayList<Resource>();
		for (Resource category : list) {
			if (!(category instanceof MenuCategory))
				continue;
			other.add(category);
			for (Resource menu : ((MenuCategory) category).getMenus()) {
				other.add(menu);
				other.addAll(((Menu) menu).getButtons());
			}
		}
		for (Resource menu : list) {
			if (!(menu instanceof Menu))
				continue;
			if (((Menu) menu).getCategory() != null)
				continue;
			other.add(menu);
			other.addAll(((Menu) menu).getButtons());
		}
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"iTotalRecords\":" + pages.getTotalRow());
		sb.append(",");
		sb.append("\"iTotalDisplayRecords\":" + pages.getTotalRow());
		sb.append(",");
		sb.append("\"sEcho\":" + pages.getsEcho());
		sb.append(",");
		sb.append("\"aaData\":");
		sb.append(JsonStringUtils.generateJSONString(other,getTableHeaders()));
		sb.append("}");
		return sb.toString();
	}

	
	/**
	 * 得到启用状态角色列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/enabled_list", method = RequestMethod.POST)
	@ResponseBody
	public String getRoleListByState(HttpServletResponse response) throws Exception
	{
		
		RoleQC qc = new RoleQC();
		AbstractUser user = getCurrentUser();
		String dealerCode = user.getDealer().getDealerCode();
		qc.setDealer_dealerCode(dealerCode);
		if(user.isAdministrator())
			qc.setState(PojoState.NORMAL);
		else
			qc.setState(PojoState.LIMITED);
		List<Role> list = RoleUtils.findRoles(qc);
		StringBuffer sb = new StringBuffer();
		sb.append(praseJsonByRole(list));
		return sb.toString();
	}
	
	/**
	 * LOAD当前用户
	 * @return
	 */
	private AbstractUser getCurrentUser(){
		AbstractUser temp = (AbstractUser) com.waynesun.utils.UserUtils.getUser();
		return DaoFactory.getInstance().getQueryDao().get(AbstractUser.class, temp.getId(), true);
	}

	/**
	 * 添加菜单类别
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add/category", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doAddCategory(HttpServletRequest request,HttpServletResponse response, MenuCategory category)throws Exception {
		category.setLevel(0);
		setOrderNumber(category);
		category.update();
		ResourceReload.reloadResource();
		return ajaxJsonSuccessMessage("");
	}


	/**
	 * 添加菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add/menu", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doAddMenu(HttpServletRequest request,HttpServletResponse response, Menu menu) throws Exception

	{
		String categoryId = request.getParameter("categoryId");
		menu.setLevel(0);
		if (!StringUtils.isEmpty(categoryId)) {
			MenuCategory category = DaoFactory.getInstance().getQueryDao().get(MenuCategory.class, categoryId, true);
			menu.setState(category.getState());
			menu.setCategory(category);
			menu.setLevel(1);
		}
		setOrderNumber(menu);
		String[] roleIds = request.getParameterValues("roleId");
		menu.updateRole(roleIds);
		menu.update();
		ResourceReload.reloadResource();
		return ajaxJsonSuccessMessage("");
	}

	/**
	 * 添加菜单按钮
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add/button", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doAddButton(HttpServletRequest request,HttpServletResponse response, Button button) throws Exception {
		String menuId = request.getParameter("menuId");
		String[] roleIds = request.getParameterValues("roleId");
		button.setLevel(1);
		if (!StringUtils.isEmpty(menuId)) {
			Menu menu = DaoFactory.getInstance().getQueryDao().get(Menu.class, menuId, true);
			if(menu == null)
				throw new BizException("menu.empty");
			button.setState(menu.getState());
			button.setMenu(menu);
			button.setLevel(2);
		}
		setOrderNumber(button);
		button.updateRole(roleIds);
		button.update();
		ResourceReload.reloadResource();
		return ajaxJsonSuccessMessage("");
	}
	

	/**
	 * 排序号
	 * @param resource
	 */
	private void setOrderNumber(Resource resource)
	{
		ResourceQC qc = new ResourceQC();
		qc.setLevel(resource.getLevel());
		List<Resource> resources = ResourceUtils.findResources(qc);
		resource.setOrderNumber(0);
		if(resources != null && resources.size() > 0)
			resource.setOrderNumber(resources.size());
	}

	/**
	 * 更新菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify/menu", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doUpdateMenu(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Menu menu = getMenu(request.getParameter("menuId"));
		if (!StringUtils.isEmpty(request.getParameter("stateStr")))
			menu.updateState(Integer.parseInt(request.getParameter("stateStr")));
		bindAndValidate(request, menu);
		String[] roleIds = request.getParameterValues("roleId");
		menu.updateRole(roleIds);
		menu.update();
		ResourceReload.reloadResource();
		return ajaxJsonSuccessMessage("");
	}

	/**
	 * 更新类别
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify/category", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doUpdateCategory(HttpServletRequest request,HttpServletResponse response) throws Exception {
		MenuCategory category = DaoFactory.getInstance().getQueryDao().get(MenuCategory.class, request.getParameter("categoryId"), true);
		if (category == null)
			throw new BizException("menu.category.empty");
		if (!StringUtils.isEmpty(request.getParameter("stateStr")))
			category.updateState(Integer.parseInt(request.getParameter("stateStr")));
		bindAndValidate(request, category);
		String[] roleIds = request.getParameterValues("roleId");
		category.updateRole(roleIds);
		category.update();
		ResourceReload.reloadResource();
		return ajaxJsonSuccessMessage("");
	}

	/**
	 * 更新按钮
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify/button", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doUpdateButton(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Button button = DaoFactory.getInstance().getQueryDao().get(Button.class, request.getParameter("buttonId"), true);
		if (button == null)
			throw new BizException("menu.button.empty");
		if (!StringUtils.isEmpty(request.getParameter("stateStr")))
			button.updateState(Integer.parseInt(request.getParameter("stateStr")));
		bindAndValidate(request, button);
		String[] roleIds = request.getParameterValues("roleId");
		button.updateRole(roleIds);
		button.update();
		ResourceReload.reloadResource();
		return ajaxJsonSuccessMessage("");
	}
	
	/**
	 * 根据ID取得菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/get_menu", method = RequestMethod.POST)
	@ResponseBody
	public String getMenuById(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		if(StringUtils.isEmpty(id))
			throw new BizException("menu.empty");
		Menu menu = DaoFactory.getInstance().getQueryDao().get(Menu.class, id, true);
		List<Resource> list = praseList(menu);
		return praseJsonByResource(list);
	}

	/**
	 * 根据ID取得类别
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/get_category", method = RequestMethod.POST)
	@ResponseBody
	public String getCategoryById(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		if(StringUtils.isEmpty(id))
			throw new BizException("menu.category.empty");
		MenuCategory category = DaoFactory.getInstance().getQueryDao().get(MenuCategory.class, id, true);
		List<Resource> list = praseList(category);
		return praseJsonByResource(list);
	}

	/**
	 * 根据ID取得按钮
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/get_button", method = RequestMethod.POST)
	@ResponseBody
	public String getButtonById(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		if(StringUtils.isEmpty(id))
			throw new BizException("menu.button.empty");
		Button button = DaoFactory.getInstance().getQueryDao().get(Button.class, id, true);
		List<Resource> list = praseList(button);
		return praseJsonByResource(list);
	}
	

	private Menu getMenu(String id) {
		if (StringUtils.isEmpty(id))
			throw new BizException("id is null");
		Menu Menu = DaoFactory.getInstance().getQueryDao().get(Menu.class, id, true);
		return Menu;
	}

	private String praseJsonByResource(List<Resource> resources)throws Exception {
		List<ExportParam> tableHeaders = getTableHeaders();
		return JsonStringUtils.generateDataTableJSONString(resources, tableHeaders);
	}
	
	private List<ExportParam> getTableHeaders(){
		List<ExportParam> exportParams = new ArrayList<ExportParam>();
		exportParams.add(new ExportParam(new StringEPVT("name"), new BeanPropertyEPVT("name"), ""));
		exportParams.add(new ExportParam(new StringEPVT("code"), new BeanPropertyEPVT("code"), ""));
		exportParams.add(new ExportParam(new StringEPVT("state"), new BeanPropertyEPVT("state"), ""));
		exportParams.add(new ExportParam(new StringEPVT("className"), new BeanPropertyEPVT("className"), ""));
		exportParams.add(new ExportParam(new StringEPVT("roles"), new BeanPropertyEPVT("roleNameByNormal"), ""));
		exportParams.add(new ExportParam(new StringEPVT("path"), new BeanPropertyEPVT("path"), ""));
		exportParams.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("imgPath"), new BeanPropertyEPVT("imgPath"), ""));
		exportParams.add(new ExportParam(new StringEPVT("value"), new BeanPropertyEPVT("value"), ""));
		exportParams.add(new ExportParam(new StringEPVT("parentId"), new BeanPropertyEPVT("parentId"), ""));
		return exportParams;
	}
	
	private String praseJsonByRole(List<Role> list)throws Exception {
		List<ExportParam> exportParams = new ArrayList<ExportParam>();
		exportParams.add(new ExportParam(new StringEPVT("name"), new BeanPropertyEPVT("name"), ""));
		exportParams.add(new ExportParam(new StringEPVT("stateStr"), new BeanPropertyEPVT("state.state"), ""));
		exportParams.add(new ExportParam(new StringEPVT("state"), new BeanPropertyEPVT("state"), ""));
		exportParams.add(new ExportParam(new StringEPVT("users"), new BeanPropertyEPVT("users"), ""));
		exportParams.add(new ExportParam(new StringEPVT("resources"), new BeanPropertyEPVT("resources"), ""));
		exportParams.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"), ""));
		
		return JsonStringUtils.generateDataTableJSONString(list, exportParams);
	}
	
	private List<Resource> praseList(Resource resource){
		List<Resource> list = new ArrayList<Resource>();
		list.add(resource);
		return list;
	}
	
}

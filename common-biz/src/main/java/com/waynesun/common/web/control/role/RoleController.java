package com.waynesun.common.web.control.role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.dao.query.order.Order;
import com.waynesun.dao.query.pages.ResultPages;
import com.waynesun.dao.query.result.QueryResult;
import com.waynesun.exception.BizException;
import com.waynesun.pojo.Pages;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.JsonStringUtils;
import com.waynesun.utils.StringUtils;
import com.waynesun.utils.export.excel.DataExportUtil;
import com.waynesun.utils.export.param.ExportParam;
import com.waynesun.utils.export.param.excel.ExcelExportParam;
import com.waynesun.utils.export.param.it.ResourceFileEPIT;
import com.waynesun.utils.export.param.vt.BeanPropertyEPVT;
import com.waynesun.utils.export.param.vt.StringEPVT;
import com.waynesun.common.biz.config.SystemConfig;
import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.resource.ResourceCacheUtils;
import com.waynesun.common.biz.resource.ResourceQC;
import com.waynesun.common.biz.resource.ResourceTreeBean;
import com.waynesun.common.biz.resource.ResourceUtils;
import com.waynesun.common.biz.role.Role;
import com.waynesun.common.biz.role.RoleCacheUtils;
import com.waynesun.common.biz.role.RoleQC;
import com.waynesun.common.biz.role.RoleUtils;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.biz.user.UserQC;
import com.waynesun.common.biz.user.UserUtils;
import com.waynesun.common.util.datatable.DataTablePages;
import com.waynesun.common.util.reload.ResourceReload;
import com.waynesun.common.web.control.AbstractBindController;
import com.waynesun.common.web.control.announcement.DateTableAjaxParam;

/**
 * 角色控制层
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends AbstractBindController
{
	/**
	 * 进入角色管理界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/show/home", method = RequestMethod.GET)
	public String showPageView()
	{
		return ".main~/role/home.jsp";
	}

	/**
	 * 得到角色列表
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/show/list", method = RequestMethod.POST)
	@ResponseBody
	public String getRoleList(HttpServletRequest request, HttpServletResponse response,DataTablePages pages,DateTableAjaxParam param) throws Exception
	{
		String name = param.getsSearch_0();
		String state = param.getsSearch_3();
		List<Role> list = new ArrayList<Role>();
		AbstractUser user = getCurrentUser();
		String dealerCode = user.getDealer().getDealerCode();
		RoleQC qc = new RoleQC();
		if(!StringUtils.isEmpty(name))
			qc.setName(name);
		qc.setDealer_dealerCode(dealerCode);
		if(StringUtils.isEmpty(state))
		{
			qc.setState_not(PojoState.SYSTEM);
			qc.setState_not_other(PojoState.LIMITED);
		}
		else
			qc.setState(PojoState.valueOf(Integer.parseInt(state)));

		QueryResult<Role> qr = RoleUtils.findRoles(qc, pages);
		list = qr.getResults();
		ResultPages rp = qr.getPages();
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		if (param.isHaveParam())
		{
			RoleQC tempQC = new RoleQC();
			tempQC.setDealer_dealerCode(dealerCode);
			tempQC.setState_not(PojoState.SYSTEM);
			tempQC.setState_not_other(PojoState.LIMITED);
			SimpleQuery sq = new SimpleQuery();
			QueryConditionAssenble qca = new QueryConditionAssenble();
			qca.setCondition(tempQC);
			sq.setQueryCondtion(qca);
			Pages tempPages = new Pages();
			tempPages.setPageSize(1);
			DaoFactory.getInstance().getQueryDao().list(Role.class, tempPages, sq, true);
			sb.append("\"iTotalRecords\":" + tempPages.getTotalRow());
		}
		else
			sb.append("\"iTotalRecords\":" + rp.getTotalRow());
		sb.append(",");
		sb.append("\"iTotalDisplayRecords\":" + rp.getTotalRow());
		sb.append(",");
		sb.append("\"sEcho\":" + pages.getsEcho());
		sb.append(",");
		sb.append("\"aaData\":");
		sb.append(JsonStringUtils.generateJSONString(list,getTable()));
		sb.append("}");
		return sb.toString();
	}

	/**
	 * 状态为启用的用户列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/show/user_enabled_list", method = RequestMethod.POST)
	public String getUserListByState(HttpServletRequest request, HttpServletResponse response, UserQC qc) throws Exception
	{
		qc.setState(PojoState.NORMAL);
		AbstractUser user = getCurrentUser();
		String dealerCode = user.getDealer().getDealerCode();
		qc.setDealer_dealerCode(dealerCode);
		List<AbstractUser> users = UserUtils.findUsers(qc);
		List<ExportParam> exportParams = new ArrayList<ExportParam>();
		exportParams.add(new ExportParam(new StringEPVT("name"), new BeanPropertyEPVT("name"), ""));
		exportParams.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"), ""));
		return JsonStringUtils.generateDataTableJSONString(users, exportParams);
	}
	
	/**
	 * 获取启用状态的菜单列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/menu_enabled_list", method = RequestMethod.POST)
	@ResponseBody
	public String getMenuListByState(HttpServletResponse response)throws Exception {
		AbstractUser user = getCurrentUser();
		List<Resource> other;
		if(user.isAdministrator())
			other = ResourceCacheUtils.getResourcesByNormal();
		else{
			ResourceQC qc = new ResourceQC();
			qc.setRoles_id(Role.getRoleIdByConfig(SystemConfig.SERVER_ADMINISTRATOR_ID));
			other = ResourceUtils.findResources(qc);
		}
		return parseJsonByResource(other);
	}

	/**
	 * 添加一个角色
	 * 
	 * @param request
	 * @param role
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String doAdd(HttpServletRequest request, HttpServletResponse response, Role role) throws Exception
	{
		String[] menuIds = request.getParameterValues("menuId");
		String[] userIds = request.getParameterValues("userId");
		String[] buttonIds = request.getParameterValues("buttonId");
		String[] categoryIds = request.getParameterValues("categoryId");
		AbstractUser user = getCurrentUser();
		role.setDealer(user.getDealer());
		role.update();
		role.add(categoryIds,menuIds, userIds,buttonIds);
		RoleCacheUtils.addOrUpdateRole(role);
		ResourceReload.reloadRole();
		return null;
	}

	/**
	 * 取得一个角色的最新数据
	 * 
	 * @param request
	 * @param role
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/show/get_role", method = RequestMethod.POST)
	@ResponseBody
	public String getRoleById(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String roleId = request.getParameter("roleId");
		if(StringUtils.isEmpty(roleId))
			throw new BizException("role.empty");
		Role role = DaoFactory.getInstance().getQueryDao().get(Role.class, roleId, true);
		List<Role> list = new ArrayList<Role>();
		list.add(role);
		return JsonStringUtils.generateDataTableJSONString(list,getTable());
	}

	/**
	 * 修改一个角色
	 * 
	 * @param request
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
//	@Transactional
	@ResponseBody
	public String doModify(HttpServletRequest request,HttpServletResponse response, String roleId,String name) throws Exception
	{
		Role role = DaoFactory.getInstance().getQueryDao().get(Role.class, roleId, true);
		AbstractUser currentUser = getCurrentUser();
		if(!(role.getDealer().getId().equals(currentUser.getDealer().getId())))
			throw new BizException("role.dealer.different");
		String[] menuIds = request.getParameterValues("menuId");
		String[] buttonIds = request.getParameterValues("buttonId");
		String[] userIds = request.getParameterValues("userId");
		String[] categoryIds = request.getParameterValues("categoryId");
		if (!StringUtils.isEmpty(request.getParameter("stateStr")))
			role.setState(PojoState.valueOf(Integer.parseInt(request.getParameter("stateStr"))));
		role.setName(name);
		bindAndValidate(request, role);
		role.modify(categoryIds,menuIds, userIds,buttonIds);
		RoleCacheUtils.addOrUpdateRole(role);
		ResourceReload.reloadRole();
		return null;
	}

	/**
	 * LOAD当前用户
	 * @return
	 */
	private AbstractUser getCurrentUser(){
		AbstractUser temp = (AbstractUser) com.waynesun.utils.UserUtils.getUser();
		return DaoFactory.getInstance().getQueryDao().get(AbstractUser.class, temp.getId(), true);
	}

	private List<ExportParam> getTable(){
		List<ExportParam> exportParams = new ArrayList<ExportParam>();
		exportParams.add(new ExportParam(new StringEPVT("name"), new BeanPropertyEPVT("name"), ""));
		exportParams.add(new ExportParam(new StringEPVT("stateStr"), new BeanPropertyEPVT("state.state"), ""));
		exportParams.add(new ExportParam(new StringEPVT("state"), new BeanPropertyEPVT("state.state"), ""));
		exportParams.add(new ExportParam(new StringEPVT("users"), new BeanPropertyEPVT("usersByStateNames"), ""));
		exportParams.add(new ExportParam(new StringEPVT("userIds"), new BeanPropertyEPVT("usersByStateIds"), ""));
		exportParams.add(new ExportParam(new StringEPVT("resources"), new BeanPropertyEPVT("resourcesStr"), ""));
		exportParams.add(new ExportParam(new StringEPVT("resourcesTitleStr"), new BeanPropertyEPVT("resourcesTitleStr"), ""));
		exportParams.add(new ExportParam(new StringEPVT("resourcesIds"), new BeanPropertyEPVT("resourcesIds"), ""));
		exportParams.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"), ""));
		return exportParams;
	}

	private String parseJsonByResource(List<Resource> resources)throws Exception {
		List<ResourceTreeBean> beans=ResourceTreeBean.transforResourceToTree(resources);
		
		System.out.println(JSONArray.fromObject(beans).toString());
		return "{\"aaData\":"+JSONArray.fromObject(beans).toString()+"}";
	}

	private List<ExcelExportParam> downloadParam(){
		List<ExcelExportParam> exportParams = new ArrayList<ExcelExportParam>();
		exportParams.add(new ExcelExportParam(new StringEPVT("name"), new ResourceFileEPIT("role."), new BeanPropertyEPVT("name"), ""));
		exportParams.add(new ExcelExportParam(new StringEPVT("authorize"), new ResourceFileEPIT("user."), new BeanPropertyEPVT("userNames"), ""));
		exportParams.add(new ExcelExportParam(new StringEPVT("list"), new ResourceFileEPIT("menu."), new BeanPropertyEPVT("menus"), ""));
		exportParams.add(new ExcelExportParam(new StringEPVT("state"), new ResourceFileEPIT("user."), new BeanPropertyEPVT("state.state"),new ResourceFileEPIT("common.state."), ""));
		return exportParams;
	}

	@RequestMapping(value="/export",method=RequestMethod.POST)
	public String exportData(HttpServletRequest request,
			HttpServletResponse response,DateTableAjaxParam param)throws Exception{
		String fileName = "角色信息导出文件.xls";
		AbstractUser user = getCurrentUser();
		String dealerCode = user.getDealer().getDealerCode();
		RoleQC qc = new RoleQC();
		qc.setDealer_dealerCode(dealerCode);
		String name = param.getsSearch_0();
		String state = param.getsSearch_3();
		if(!StringUtils.isEmpty(name))
			qc.setName(name);
		qc.setDealer_dealerCode(dealerCode);
		if(StringUtils.isEmpty(state))
		{
			qc.setState_not(PojoState.SYSTEM);
			qc.setState_not_other(PojoState.LIMITED);
		}
		else
			qc.setState(PojoState.valueOf(Integer.parseInt(state)));
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		sq.setOrders(Arrays.asList(Order.asc("name")));
		List<Role> roleList = DaoFactory.getInstance().getQueryDao().list(Role.class, null, sq, true).getResults();
		HSSFWorkbook wk = DataExportUtil.generateExcelFile(downloadParam(), roleList);
		DataExportUtil.exportExceltoclient(wk, fileName, response, request);
		return null;
	}	
}
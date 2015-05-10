package com.waynesun.common.web.control.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.codehaus.jackson.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.QueryDao;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.dao.query.pages.ResultPages;
import com.waynesun.dao.query.result.QueryResult;
import com.waynesun.exception.BizException;
import com.waynesun.pojo.Pages;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.CollectionUtil;
import com.waynesun.utils.JsonStringUtils;
import com.waynesun.utils.MessageReader;
import com.waynesun.utils.StringUtils;
import com.waynesun.utils.export.excel.DataExportUtil;
import com.waynesun.utils.export.param.ExportParam;
import com.waynesun.utils.export.param.excel.ExcelExportParam;
import com.waynesun.utils.export.param.it.DateFormatEPIT;
import com.waynesun.utils.export.param.it.EmptyEPIT;
import com.waynesun.utils.export.param.it.ResourceFileEPIT;
import com.waynesun.utils.export.param.vt.BeanPropertyEPVT;
import com.waynesun.utils.export.param.vt.StringEPVT;
import com.waynesun.common.biz.role.Role;
import com.waynesun.common.biz.role.RoleQC;
import com.waynesun.common.biz.role.RoleUtils;
import com.waynesun.common.biz.user.AbstractDealer;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.biz.user.Employee;
import com.waynesun.common.biz.user.LoginAccount;
import com.waynesun.common.biz.user.LoginAccountQC;
import com.waynesun.common.biz.user.LoginAccountUtils;
import com.waynesun.common.biz.user.UserQC;
import com.waynesun.common.biz.user.UserUtils;
import com.waynesun.common.util.datatable.DataTablePages;
import com.waynesun.common.web.control.AbstractBindController;
import com.waynesun.common.web.control.announcement.DateTableAjaxParam;

/**
 * 
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends AbstractBindController
{

	/**
	 * 用户管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/show/home", method = RequestMethod.GET)
	public String showPageView(HttpServletRequest request)
	{
		RoleQC qc = new RoleQC();
		AbstractUser user = getCurrentUser();
//		if(user.isAdministrator())
//			qc.setState(PojoState.NORMAL);
//		else
//			qc.setState(PojoState.LIMITED);
		qc.setDealer_dealerCode(user.getDealer().getDealerCode());
		qc.setState_not(PojoState.DELETED);
		List<Role> list = RoleUtils.findRoles(qc);
		StringBuffer sb = new StringBuffer();
		if (!CollectionUtil.isEmptyOrZero(list))
		{
			sb.setLength(0);
			sb.append("[");
			for (Role role : list)
			{
				sb.append("{");
				sb.append("value:" + role.getId() + ",");
				sb.append("label:\'" + StringUtils.escapeHtmlJson(role.getName()) + "\'");
				sb.append("}");
				sb.append(",");
			}
			sb.setLength(sb.length() - 1);
			sb.append("]");
			request.setAttribute("rolesStr", sb.toString());
		}
		else
		{
			request.setAttribute("rolesStr", "[]");
		}
		request.setAttribute("roles", list);

		return ".main~/user/home.jsp";
	}

	/**
	 * 用户列表
	 * 
	 * @return
	 * @throws Exception 
	 * @throws IOException
	 * @throws JsonProcessingException
	 */
	@ResponseBody
	@RequestMapping(value = "/show/list", method = RequestMethod.POST)
	public String getUserList(HttpServletRequest request, HttpServletResponse response, UserQC qc, DataTablePages pages, DateTableAjaxParam param)
			throws Exception
	{
		List<AbstractUser> list = null;
		
		// sSearch_0 代表用户姓名
		if(!StringUtils.isEmpty(param.getsSearch_0()))
			qc.setName_search(param.getsSearch_0());
		// sSearch_1 代表角色
		if (!StringUtils.isEmpty(param.getsSearch_1()))
			qc.setRoles_id(param.getsSearch_1());
		// sSearch_2 代表用户登录名
		if(!StringUtils.isEmpty(param.getsSearch_2()))
			qc.setAccount_userName(param.getsSearch_2());
		
		qc.setState(PojoState.NORMAL);
		
		AbstractUser user = getCurrentUser();
		String dealerCode = user.getDealer().getDealerCode();
		qc.setDealer_dealerCode(dealerCode);

		QueryResult<AbstractUser> qr = UserUtils.findUsers(qc, pages);
		list = qr.getResults();
		ResultPages rq = qr.getPages();

		StringBuffer sb = new StringBuffer();
		sb.append("{");
		if (param.isHaveParam())
		{
			UserQC tempQC = new UserQC();
			tempQC.setState(PojoState.NORMAL);
			tempQC.setDealer_dealerCode(dealerCode);
			SimpleQuery sq = new SimpleQuery();
			QueryConditionAssenble qca = new QueryConditionAssenble();
			qca.setCondition(tempQC);
			sq.setQueryCondtion(qca);
			Pages tempPages = new Pages();
			tempPages.setPageSize(1);
			DaoFactory.getInstance().getQueryDao().list(AbstractUser.class, tempPages, sq, true);
			sb.append("\"iTotalRecords\":" + tempPages.getTotalRow());
		}
		else
			sb.append("\"iTotalRecords\":" + rq.getTotalRow());
		sb.append(",");
		sb.append("\"iTotalDisplayRecords\":" + rq.getTotalRow());
		sb.append(",");
		sb.append("\"sEcho\":" + pages.getsEcho());
		sb.append(",");
		sb.append("\"aaData\":");
		sb.append(JsonStringUtils.generateJSONString(list, getTableHeaders()));
		sb.append("}");
		return sb.toString();
	}

	/**
	 * 得到非禁用状态的角色列表
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/show/role", method = RequestMethod.POST)
	@ResponseBody
	public String getRole() throws Exception
	{
		RoleQC qc = new RoleQC();
		AbstractUser user = getCurrentUser();
		String dealerCode = user.getDealer().getDealerCode();
		qc.setDealer_dealerCode(dealerCode);
		qc.setState_not(PojoState.DELETED);
		List<Role> roles = RoleUtils.findRoles(qc);
		List<ExportParam> exportParams = new ArrayList<ExportParam>();
		exportParams.add(new ExportParam(new StringEPVT("name"), new BeanPropertyEPVT("name"), ""));
		exportParams.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"), ""));
		return JsonStringUtils.generateJSONString(roles, exportParams);
	}

	/**
	 * 添加用户
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	@Transactional
	@ResponseBody
	public String doAdd(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		LoginAccount account=new LoginAccount();
		account.setUserName(request.getParameter("userName"));
		Employee user=new Employee();
		user.setName(request.getParameter("name"));
		String[] rolesId = request.getParameterValues("rolesId");
		Set<Role> roles = new HashSet<Role>();
		if (rolesId != null && rolesId.length > 0)
		{
			QueryDao dao = DaoFactory.getInstance().getQueryDao();
			List<Role> role = new ArrayList<Role>();
			for (String id : rolesId) {
				role.add((Role) dao.get(Role.class, id, true));
			}
			roles.addAll(role);
			user.setRoles(roles);
		}
		
		user.setDealer(getCurrentUser().getDealer());
		user.add(account);
		StringBuffer sb = new StringBuffer();
		sb.append("{\"aaData\":");
		JsonStringUtils.appendJSONString(user, getTableHeaders(), true, sb);
		sb.append(",");
		sb.append("\"message\":\"" + StringUtils.escapeHtmlJson(MessageReader.getMessage("register.success")) + "\"");
		sb.append("}");
		return sb.toString();
	}

	@RequestMapping(value = "/show/get", method = RequestMethod.POST)
	@ResponseBody
	public String getUser(HttpServletRequest request, String id) throws Exception
	{
		AbstractUser user = DaoFactory.getInstance().getQueryDao().get(AbstractUser.class, id, true);
		return JsonStringUtils.generateJSONString(user, getTableHeaders());
	}

	/**
	 * 修改用户
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
//	@Transactional
	@ResponseBody
	public String doModify(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		LoginAccount account = DaoFactory.getInstance().getQueryDao().get(LoginAccount.class, request.getParameter("loginId"), true);
		AbstractUser user = DaoFactory.getInstance().getQueryDao().get(AbstractUser.class, request.getParameter("userId"), true);
		AbstractDealer dealer = user.getDealer();
		AbstractUser currentUser = getCurrentUser();
		if(!(dealer.getId().equals(currentUser.getDealer().getId())))
			throw new BizException("user.dealer.different");
		bindAndValidate(request, account);
		String resetPassword = request.getParameter("resetPassword");
		if (!StringUtils.isEmpty(resetPassword))
			account.setPassword(LoginAccount.getDefaultPassword());
		account.updateStateByValidity();
		account.update();
		bindAndValidate(request, user);
		String[] rolesId = request.getParameterValues("rolesId");
		List<Role> sysList = user.getHideRole();
		user.setRoles(null);
		Set<Role> roles = new HashSet<Role>();
		roles.addAll(sysList);
		if (rolesId != null && rolesId.length > 0)
		{
			QueryDao dao = DaoFactory.getInstance().getQueryDao();
			List<Role> role = new ArrayList<Role>();
			for (String id : rolesId) {
				role.add((Role) dao.get(Role.class, id, true));
			}
			roles.addAll(role);
		}
		user.setRoles(roles);
		user.update();
		if("0".equals(dealer.getDealerCode()))
			return ajaxJsonSuccessMessage(MessageReader.getMessage("user.modify.success"));
		String assessor = request.getParameter("assessor");
		if(!StringUtils.isEmpty(assessor)){
			if("0".equals(assessor)){
				dealer.setAssessor(user);
				dealer.update();
			}else if("1".equals(assessor)){
				AbstractUser assessorUser = dealer.getAssessor();
				if(assessorUser != null && assessorUser.getId().equals(user.getId())){
					dealer.setAssessor(null);
					dealer.update();
				}
			}
		}
//		DealerCacheUtils.updateDealerCache(dealer);
		return ajaxJsonSuccessMessage(MessageReader.getMessage("user.modify.success"));
	}

	/**
	 * LOAD当前用户
	 * @return
	 */
	private AbstractUser getCurrentUser(){
		AbstractUser temp = (AbstractUser) com.waynesun.utils.UserUtils.getUser();
		return DaoFactory.getInstance().getQueryDao().get(AbstractUser.class, temp.getId(), true);
	}

	@RequestMapping(value = "/show/username_repeat", method = RequestMethod.POST)
	@ResponseBody
	public String getValidateUserNameRepeat(HttpServletRequest request, LoginAccountQC qc)
	{
		// 去除前后空格
		qc.setUserName(qc.getUserName().trim());
		LoginAccount account = LoginAccountUtils.findLoginAccount(qc);
		if (account == null)
			return String.valueOf(true);
		return String.valueOf(false);
	}

	private List<ExportParam> getTableHeaders()
	{
		List<ExportParam> exportParams = new ArrayList<ExportParam>();
		exportParams.add(new ExportParam(new StringEPVT("name"), new BeanPropertyEPVT("name"), ""));
		exportParams.add(new ExportParam(new StringEPVT("phone"), new BeanPropertyEPVT("phone"), ""));
		exportParams.add(new ExportParam(new StringEPVT("userName"), new BeanPropertyEPVT("account.userName"), ""));
		exportParams.add(new ExportParam(new StringEPVT("accountId"), new BeanPropertyEPVT("account.id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("roleNames"), new BeanPropertyEPVT("roleNames"), ""));
		exportParams.add(new ExportParam(new StringEPVT("roleIds"), new BeanPropertyEPVT("roleIds"), ""));
		exportParams.add(new ExportParam(new StringEPVT("state"),EmptyEPIT.getInstance(), new BeanPropertyEPVT("state.state"),new ResourceFileEPIT("common.state."), ""));
		exportParams.add(new ExportParam(new StringEPVT("startDate"), new BeanPropertyEPVT("account.startDate"),new DateFormatEPIT("yyyy-MM-dd"), null));
		exportParams.add(new ExportParam(new StringEPVT("endDate"), new BeanPropertyEPVT("account.endDate"),new DateFormatEPIT("yyyy-MM-dd"), null));
		exportParams.add(new ExportParam(new StringEPVT("dealerCode"), new BeanPropertyEPVT("dealer.dealerCode"), ""));
		exportParams.add(new ExportParam(new StringEPVT("assessor"), new BeanPropertyEPVT("assessorMessage"), ""));
		exportParams.add(new ExportParam(new StringEPVT("assessorId"), new BeanPropertyEPVT("dealer.assessor.id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"), ""));
		return exportParams;
	}
	
	private List<ExcelExportParam> downloadParam(){
		List<ExcelExportParam> exportParams = new ArrayList<ExcelExportParam>();
		exportParams.add(new ExcelExportParam(new StringEPVT("name"), new ResourceFileEPIT("user."), new BeanPropertyEPVT("name"), ""));
		exportParams.add(new ExcelExportParam(new StringEPVT("name"), new ResourceFileEPIT("user.role."), new BeanPropertyEPVT("roleNames"), ""));
		exportParams.add(new ExcelExportParam(new StringEPVT("userName"), new ResourceFileEPIT("user."), new BeanPropertyEPVT("account.userName"), ""));
		exportParams.add(new ExcelExportParam(new StringEPVT("state"), new ResourceFileEPIT("user."), new BeanPropertyEPVT("state.state"),new ResourceFileEPIT("common.state."), ""));
		return exportParams;
	}

	@RequestMapping(value = "/export", method = RequestMethod.POST)
	public String exportData(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String fileName = "用户信息导出文件.xls";
		UserQC qc=new UserQC();
		AbstractUser user = getCurrentUser();
		String dealerCode = user.getDealer().getDealerCode();
		if(!StringUtils.isEmpty(dealerCode)){
			if(!StringUtils.isEmpty(request.getParameter("userNameSearch")))
				qc.setAccount_userName(request.getParameter("userNameSearch"));
			if(!StringUtils.isEmpty(request.getParameter("nameSearch")))
				qc.setName_search(request.getParameter("nameSearch"));
			if (!StringUtils.isEmpty(request.getParameter("roleSearch")))
				qc.setRoles_id(request.getParameter("roleSearch"));
			qc.setState(PojoState.NORMAL);
			qc.setDealer_dealerCode(dealerCode);
		}
		List<AbstractUser> elist = UserUtils.findUsers(qc, null).getResults();
		HSSFWorkbook wk = DataExportUtil.generateExcelFile(downloadParam(), elist);
		DataExportUtil.exportExceltoclient(wk, fileName, response, request);
		return null;
	}
}

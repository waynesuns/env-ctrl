package com.waynesun.common.web.control.config;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.waynesun.dao.DaoFactory;
import com.waynesun.utils.JsonStringUtils;
import com.waynesun.utils.MessageReader;
import com.waynesun.utils.export.param.ExportParam;
import com.waynesun.utils.export.param.vt.BeanPropertyEPVT;
import com.waynesun.utils.export.param.vt.StringEPVT;
import com.waynesun.common.biz.config.SystemConfig;
import com.waynesun.common.biz.config.SystemConfigCacheUtils;
import com.waynesun.common.util.datatable.DataTablePages;
import com.waynesun.common.web.control.AbstractBindController;
@Controller
@RequestMapping(value = "/sysconfig")
public class SysConfigController extends AbstractBindController{
	/**
	 * 系统配置主页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/show/home", method = RequestMethod.GET)
	public String showPageView(){
		return ".main~/sysconfig/home.jsp";
	}
	
	@RequestMapping(value = "/show/list", method = RequestMethod.POST)
	@ResponseBody
	@SuppressWarnings("all")
	public String getListConfig(HttpServletRequest request,HttpServletResponse response,DataTablePages pages) throws Exception{
		Collection<SystemConfig> list=SystemConfigCacheUtils.getAllSystemConfig();
	    List<SystemConfig> configList=new ArrayList<SystemConfig>(list);
		return JsonStringUtils.generateDataTableJSONString(configList, getTableHeaders());
	}
	private List<ExportParam> getTableHeaders()
	{
		List<ExportParam> exportParams = new ArrayList<ExportParam>();
		exportParams.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("code"), new BeanPropertyEPVT("code"), ""));
		exportParams.add(new ExportParam(new StringEPVT("name"), new BeanPropertyEPVT("name"), ""));
		exportParams.add(new ExportParam(new StringEPVT("value"), new BeanPropertyEPVT("value"), ""));
		return exportParams;
	}
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public String getSysconfig(HttpServletRequest request,HttpServletResponse response,String id)throws Exception{
		SystemConfig config = DaoFactory.getInstance().getQueryDao().get(SystemConfig.class, id, true);
		return JsonStringUtils.generateJSONString(config, getTableHeaders());
	}
	/**
	 * 修改
	 * 
	 * @param request
	 * @param dictionary
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify_item", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doModifyCategory(HttpServletRequest request, String id) throws Exception
	{
		SystemConfig config = DaoFactory.getInstance().getQueryDao().get(SystemConfig.class, id, true);
		config.setName(request.getParameter("name"));
		config.setValue(request.getParameter("value"));
		config.update();
		SystemConfigCacheUtils.modifySystemConfigToCache(config);
		return ajaxJsonSuccessMessage(MessageReader.getMessage("sysconfig.modify.success"));
	}
}

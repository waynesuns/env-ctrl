package com.waynesun.common.web.control.dictionary;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.waynesun.common.biz.dictionary.Dictionary;
import com.waynesun.common.biz.dictionary.DictionaryCategory;
import com.waynesun.common.biz.dictionary.DictionaryQC;
import com.waynesun.common.biz.dictionary.DictionaryUtils;
import com.waynesun.common.web.control.AbstractBindController;

/**
 * 数据字典控制类
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/dictionary")
public class DictionaryController extends AbstractBindController
{
	/**
	 * 进入数据字典页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/show/home", method = RequestMethod.GET)
	public String showPageView()
	{
		return ".main~/dictionary/home.jsp";
	}

	/**
	 * 生成数据字典DataTableJSON数据
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/show/list.do", method = RequestMethod.POST)
	@ResponseBody
	public String getList(HttpServletRequest request, DictionaryQC qc) throws Exception
	{
		List<DictionaryCategory> categories = DictionaryUtils.findDictionaryCategories(qc);
		List<Dictionary> dictionaries = new ArrayList<Dictionary>();
		if (categories != null) {
			dictionaries.addAll(categories);
		}

		return JsonStringUtils.generateDataTableJSONString(dictionaries, getTableHeaders());
	}

	/**
	 * 添加类别
	 * 
	 * @param request
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/add_category", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doAddCategory(HttpServletRequest request, DictionaryCategory category)
	{
		category.update();
		return ajaxJsonSuccessMessage(MessageReader.getMessage("dictionary.add.category.success"));
	}

	/**
	 * 修改字典类别
	 * 
	 * @param request
	 * @param dictionary
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify_category", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doModifyCategory(HttpServletRequest request, String id,String name) throws Exception
	{
		DictionaryCategory category = DaoFactory.getInstance().getQueryDao().get(DictionaryCategory.class, id, true);
//		bindAndValidate(request, category);
		category.setName(name);
		category.update();
		return ajaxJsonSuccessMessage(MessageReader.getMessage("dictionary.modify.category.success"));
	}

	/**
	 * 根据ID查询Dictionary对象
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/show/get.do", method = RequestMethod.POST)
	@ResponseBody
	public String getDictionary(HttpServletRequest request, String id) throws Exception
	{
		Dictionary dictionary = DaoFactory.getInstance().getQueryDao().get(Dictionary.class, id, true);
		return JsonStringUtils.generateJSONString(dictionary, getTableHeaders());
	}

	private List<ExportParam> getTableHeaders()
	{
		List<ExportParam> tableHeaders = new ArrayList<ExportParam>();
		tableHeaders.add(new ExportParam(new StringEPVT("code"), new BeanPropertyEPVT("code"),""));
		tableHeaders.add(new ExportParam(new StringEPVT("name"), new BeanPropertyEPVT("name"),""));
		tableHeaders.add(new ExportParam(new StringEPVT("value"), new BeanPropertyEPVT("value"),""));
		tableHeaders.add(new ExportParam(new StringEPVT("stateStr"), new BeanPropertyEPVT("stateStr"),""));
		tableHeaders.add(new ExportParam(new StringEPVT("state"), new BeanPropertyEPVT("state"),""));
		tableHeaders.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"),""));
		return tableHeaders;
	}
	
	@RequestMapping(value = "/show/code", method = RequestMethod.POST)
	@ResponseBody
	public String getValidateUserNameRepeat(HttpServletRequest request, DictionaryQC qc)
	{
		// 去除前后空格
		qc.setCode(request.getParameter("code"));
		List<Dictionary>  list = DictionaryUtils.findDictionary(qc);
		if (list!=null&&list.size()>0)
			return String.valueOf(false);
		return String.valueOf(true);
	}
}

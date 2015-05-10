package com.waynesun.common.web.control.dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.waynesun.dao.DaoFactory;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.JsonStringUtils;
import com.waynesun.utils.MessageReader;
import com.waynesun.utils.export.param.ExportParam;
import com.waynesun.utils.export.param.vt.BeanPropertyEPVT;
import com.waynesun.utils.export.param.vt.StringEPVT;
import com.waynesun.common.biz.dictionary.Dictionary;
import com.waynesun.common.biz.dictionary.DictionaryCacheUtils;
import com.waynesun.common.biz.dictionary.DictionaryCategory;
import com.waynesun.common.biz.dictionary.DictionaryItem;
import com.waynesun.common.biz.dictionary.DictionaryUtils;
import com.waynesun.common.web.control.AbstractBindController;

/**
 * 数据字典表详情
 * @author zhengnan
 *
 */
@Controller
@RequestMapping(value = "/dictionary/detail")
public class DictionaryDetailController extends AbstractBindController {

	/**
	 * 进入数据字典页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/show/home", method = RequestMethod.GET)
	public String showPageView(HttpServletRequest request, String id, String code, String name) {
		request.setAttribute("id", StringEscapeUtils.unescapeHtml(id));
		request.setAttribute("code", StringEscapeUtils.unescapeHtml(code));
		request.setAttribute("name", StringEscapeUtils.unescapeHtml(name));
		return ".main~/dictionary/detail/home.jsp";
	}

	/**
	 * 生成数据字典DataTableJSON数据
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/list", method = RequestMethod.POST)
	@ResponseBody
	public String getList(HttpServletRequest request, String id) throws Exception {
		List<Dictionary> dictionaries = new ArrayList<Dictionary>();

		DictionaryCategory categorie = DictionaryUtils.findDictionaryCategory(id);
		if (categorie != null) {
			Set<DictionaryItem> items = categorie.getDictionaryItems();
			if (items != null) {
				dictionaries.addAll(items);
			}
		}

		return JsonStringUtils.generateDataTableJSONString(dictionaries, getTableHeaders());
	}

	/**
	 * 添加项
	 * 
	 * @param request
	 * @param item
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "/add_item", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doAddItem(HttpServletRequest request, DictionaryItem item, String categoryId)
	{
		DictionaryCategory category = DaoFactory.getInstance().getQueryDao().get(DictionaryCategory.class, categoryId, true);
		item.setParent(category);
		item.update();
		DictionaryCacheUtils.addDictionary(item);
		return ajaxJsonSuccessMessage(MessageReader.getMessage("dictionary.add.item.success"));
	}

	/**
	 * 修改字典项
	 * 
	 * @param request
	 * @param dictionary
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify_item", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doModifyItem(HttpServletRequest request, String id) throws Exception
	{
		DictionaryItem item = DaoFactory.getInstance().getQueryDao().get(DictionaryItem.class, id, true);
		item.setName(request.getParameter("name"));
		item.setState(PojoState.valueOf(request.getParameter("state")));
		item.update();
		DictionaryCacheUtils.updateDictionaryItem(item);
		return ajaxJsonSuccessMessage(MessageReader.getMessage("dictionary.modify.item.success"));
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

	private List<ExportParam> getTableHeaders() {
		List<ExportParam> tableHeaders = new ArrayList<ExportParam>();
		tableHeaders.add(new ExportParam(new StringEPVT("name"), new BeanPropertyEPVT("name"),""));
		tableHeaders.add(new ExportParam(new StringEPVT("value"), new BeanPropertyEPVT("value"),""));
		tableHeaders.add(new ExportParam(new StringEPVT("stateStr"), new BeanPropertyEPVT("stateStr"),""));
		tableHeaders.add(new ExportParam(new StringEPVT("state"), new BeanPropertyEPVT("state"),""));
		tableHeaders.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"),""));
		return tableHeaders;
	}
}
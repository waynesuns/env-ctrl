package com.waynesun.common.web.control;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.waynesun.utils.MessageReader;
import com.waynesun.utils.StringUtils;

/**
 * @author sunmin
 * 
 */
public abstract class AbstractController
{
	public static final String VIEW = "view";
	public static final String LIST = "list";
	public static final String STATUS = "status";
	public static final String WARN = "warn";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String MESSAGE = "message";
	public static final String CONTENT = "content";

	protected final Log logger = LogFactory.getLog(this.getClass());

	@InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor(true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
		binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, true));
		//binder.registerCustomEditor(Dictionary.class, new DictionaryEditor());
	}

	/**
	 * 根据Map输出JSON
	 * 
	 * @param jsonMap
	 * @return
	 */
	public String ajaxJson(Map<String, ? extends Object> jsonMap)
	{
		JsonConfig config = new JsonConfig();
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);

		JSONObject jsonObject = JSONObject.fromObject(jsonMap, config);
		return jsonObject.toString();
	}

	/**
	 * 输出列表
	 * 
	 * @param jsonList
	 * @return
	 */
	public String ajaxJson(List<? extends Object> jsonList)
	{
		JsonConfig config = new JsonConfig();
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);

		JSONArray jsonArray = JSONArray.fromObject(jsonList, config);
		return jsonArray.toString();
	}

	/**
	 * 输出JSON警告消息
	 * 
	 * @param message
	 * @return
	 */
	public String ajaxJsonWarnMessage(String message)
	{
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, WARN);
		jsonMap.put(MESSAGE, message);
		JSONObject jsonObject = JSONObject.fromObject(jsonMap);
		return jsonObject.toString();
	}

	/**
	 * 输出JSON成功消息
	 * 
	 * @param message
	 * @return
	 */
	public String ajaxJsonSuccessMessage(String message)
	{
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, SUCCESS);
		jsonMap.put(MESSAGE, StringUtils.escapeHtml(message));
		JSONObject jsonObject = JSONObject.fromObject(jsonMap);
		return jsonObject.toString();
	}

	/**
	 * 根据资源文件输出JSON成功消息
	 * 
	 * @param key
	 *            资源文件key
	 * @param params
	 *            资源文件参数
	 * @return JSON成功消息
	 */
	public String ajaxJsonSuccessMessage(String key, String[] params)
	{
		return this.ajaxJsonSuccessMessage(MessageReader.getMessage(key, params));
	}

	/**
	 * 输出JSON错误消息
	 * 
	 * @param message
	 * @return
	 */
	public String ajaxJsonErrorMessage(String message)
	{
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, ERROR);
		jsonMap.put(MESSAGE, StringUtils.escapeHtml(message));
		JSONObject jsonObject = JSONObject.fromObject(jsonMap);
		return jsonObject.toString();
	}

	/**
	 * 根据资源文件输出JSON错误消息
	 * 
	 * @param key
	 *            资源文件key
	 * @param params
	 *            资源文件参数
	 * @return JSON成功消息
	 */
	public String ajaxJsonErrorMessage(String key, String[] params)
	{
		return this.ajaxJsonErrorMessage(MessageReader.getMessage(key, params));
	}
}

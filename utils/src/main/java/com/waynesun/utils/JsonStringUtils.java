package com.waynesun.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.waynesun.utils.export.param.ExportParam;
import com.waynesun.utils.impt.excel.ExcelImportResult;

/**
 * JSON工具类
 * @author wayne
 *
 */
public class JsonStringUtils
{
	/**
	 * 根据传入的数据生成JSON字符串（KEY 为propNames中的元素，VALUE 为其对应的值）
	 * 
	 * @param beanList
	 *            原数据的BEAN LIST
	 * @param propNames
	 *            需要加入JSON的属性名
	 * @return
	 * @throws Exception
	 */
	public static String generateDataTableJSONString(List<? extends Object> beanList, List<ExportParam> exportParams)
			throws Exception
	{
		StringBuffer sb = new StringBuffer();
		sb.append("{\"aaData\":");
		JsonStringUtils.appendJSONString(beanList, exportParams, true, sb);
		sb.append("}");
		return sb.toString();
	}

	/**
	 * 生成JSON字符串
	 * @param beanList 待生成JSON的数据对象列表
	 * @param exportParams 生成参数
	 * @return
	 * @throws Exception
	 */
	public static String generateJSONString(List<? extends Object> beanList, List<ExportParam> exportParams) throws Exception
	{
		return JsonStringUtils.generateJSONString(beanList, exportParams, true);
	}

	/**
	 * 生成JSON字符串
	 * @param bean 待生成JSON的数据对象
	 * @param exportParams 生成参数
	 * @return
	 * @throws Exception
	 */
	public static String generateJSONString(Object bean, List<ExportParam> exportParams) throws Exception
	{
		StringBuffer sb = new StringBuffer();
		JsonStringUtils.appendJSONString(bean, exportParams, true, sb);
		return sb.toString();
	}

	/**
	 * 生成JSON字符串
	 * @param beanList 待生成JSON的数据对象列表
	 * @param exportParams 生成参数
	 * @param isEscapeHtml 是否转义HTML代码
	 * @return
	 * @throws Exception
	 */
	public static String generateJSONString(List<? extends Object> beanList, List<ExportParam> exportParams, boolean isEscapeHtml)
			throws Exception
	{
		StringBuffer sb = new StringBuffer();
		JsonStringUtils.appendJSONString(beanList, exportParams, true, sb);
		return sb.toString();
	}
	/**
	 * 拼接JSON对象字符串
	 * @param beanList 待生成JSON的数据对象列表
	 * @param exportParams 生成参数
	 * @param isEscapeHtml 是否转义HTML代码
	 * @param sb
	 * @throws Exception
	 */
	public static void appendJSONString(List<? extends Object> beanList, List<ExportParam> exportParams, boolean isEscapeHtml, StringBuffer sb)
			throws Exception
	{
		sb.append("[");
		for (Object obj : beanList)
		{
			JsonStringUtils.appendJSONString(obj, exportParams, isEscapeHtml, sb);
			sb.append(",");
		}
		if (beanList.size() > 0)
			sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
	}

	/**
	 * 拼接JSON对象字符串
	 * @param bean 待生成JSON的数据对象
	 * @param exportParams 生成参数
	 * @param isEscapeHtml 是否转义HTML代码
	 * @param sb
	 * @throws Exception
	 */
	public static void appendJSONString(Object bean, List<ExportParam> exportParams, boolean isEscapeHtml, StringBuffer sb)
			throws Exception
	{
		sb.append("{");
		for (ExportParam exportParam : exportParams)
		{
			Object value = exportParam.getValue(bean);
			String valueStr = "";
			if (value != null)
			{
				if (isEscapeHtml)
				{
					valueStr = StringUtils.escapeHtmlJson(value == null ? null : value.toString());
				}
				else
				{
					valueStr = value.toString();
				}
			}
			sb.append("\"").append(exportParam.getTitle(bean)).append("\":\"").append(valueStr).append("\",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("}");
	}
	

	/**
	 * 返回导入文件的JSON信息
	 * @param infoList
	 * @return
	 */
	@SuppressWarnings("all")
	public static  String ajaxJsonImportMessage(ExcelImportResult infoList){
		return ajaxJsonImportMessage(infoList,"btn.import.success");
	}
	/**
	 * <code>
	 * @param infoList</code>
	 * @return
	 */
	@SuppressWarnings("all")
	public static  String ajaxJsonImportMessage(ExcelImportResult infoList,String succesKey,String... params){
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		List<String> errors=infoList.getErrors();
		if(errors!=null&&errors.size()>0){
			jsonMap.put("status", "error");
			jsonMap.put("message",errors);
		}else{
			jsonMap.put("status", "success");
			jsonMap.put("successtitle", MessageReader.getMessage(succesKey,params));
			jsonMap.put("successmessage", infoList.getSuccessInfos());
		}
		JSONObject jsonObject = JSONObject.fromObject(jsonMap);
		return jsonObject.toString();
	}
	
}

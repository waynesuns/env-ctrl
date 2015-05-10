package com.waynesun.common.web.tag.dictionary.adapter;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.beanutils.PropertyUtils;

import com.waynesun.pojo.BaseEntity;
import com.waynesun.utils.StringUtils;

/**
 * 选项标签适配器积累
 * 
 * @author weis
 * 
 */
public class OptionAdapter
{
	private StringBuffer sb;
	/** 选中值 */
	private String selectValue;
	/** option的value所对应的attribute name */
	private String valueName;
	/** option的name所对应的attribute name */
	private String displayName;
	/** 用以生成OPTION的对象 */
	private Object obj;
	/**需要显示的OPTION值*/
	private List<String> validValues;

	public OptionAdapter(Object obj, String valueName, String displayName)
	{
		this(obj, valueName, displayName, null,null);
	}

	public OptionAdapter(Object obj, String valueName, String displayName, String selectValue)
	{
		this(obj, valueName, displayName, selectValue,null);
		
	}
	public OptionAdapter(Object obj, String valueName, String displayName, String selectValue,List<String> validValues)
	{
		this.sb = new StringBuffer();
		this.obj = obj;
		this.valueName = valueName;
		this.displayName = displayName;
		this.selectValue = selectValue;
		this.validValues = validValues;
	}

	public String getHtmlStr() throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		this.appendHtmlStr(obj);
		return sb.toString();
	}

	private void appendHtmlStr(Object obj) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException,
			NoSuchMethodException
	{
		if (obj instanceof List)
		{
			this.appendHtmlStr((List<?>) obj);
		}
		else if (obj instanceof BaseEntity)
		{
			this.appendHtmlStr((BaseEntity) obj);
		}
		else
		{
			throw new RuntimeException("OptionAdapter:invalid obj type");
		}

	}

	private void appendHtmlStr(List<?> list) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException,
			NoSuchMethodException
	{
		for (int i = 0; i < list.size(); i++)
		{
			this.appendHtmlStr(list.get(i));
		}
	}

	private void appendHtmlStr(BaseEntity entity) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException,
			NoSuchMethodException
	{
		if (entity == null)
			return;
		Object key = getProperty(entity, valueName, ".");
		if (key == null)
			key = "";
		Object value = getProperty(entity, displayName, ".");
		if (value == null)
			value = "";
		this.appendHtmlStr(key.toString(), value.toString());
	}

	private void appendHtmlStr(String value, String display)
	{
		if(this.validValues==null || this.validValues.contains(value)){
			sb.append("<option value=\"").append(value).append("\"");
			if (selectValue != null && selectValue.equals(value))
			{
				sb.append("selected=\"selected\"");
			}
			sb.append(">").append(StringUtils.escapeHtml(display)).append("</option>");
		}
	}

	private Object getProperty(Object bean, String propNameChain, String delim) throws NoSuchFieldException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException
	{
		if (bean == null)
			return null;
		StringTokenizer st = new StringTokenizer(propNameChain, delim);
		while (st.hasMoreTokens())
		{
			String s = st.nextToken();
			bean = PropertyUtils.getProperty(bean, s);
			if (bean == null)
				return null;
		}
		return bean;
	}

}

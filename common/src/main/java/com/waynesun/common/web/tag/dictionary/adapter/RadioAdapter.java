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
public class RadioAdapter
{
	private StringBuffer sb;
	/** 选中值 */
	private String selectValue;
	private String valueName;
	private String displayName;
	private String htmlName;
	private String htmlId;
	/** CSS CLASS */
	private String styleClass;
	/** 用以生成OPTION的对象 */
	private Object obj;

	public RadioAdapter(Object obj, String valueName, String displayName)
	{
		this(obj, valueName, displayName, null, null, null, null);
	}

	public RadioAdapter(Object obj, String valueName, String displayName, String selectValue, String htmlId, String htmlName, String styleClass)
	{
		this.sb = new StringBuffer();
		this.obj = obj;
		this.valueName = valueName;
		this.displayName = displayName;
		this.selectValue = selectValue;
		this.htmlId = htmlId;
		this.htmlName = htmlName;
		this.styleClass = styleClass;
	}

	public String getHtmlStr() throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		this.appendHtmlStr(obj);
		return sb.toString();
	}

	private void appendHtmlStr(Object obj) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
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

	private void appendHtmlStr(List<?> list) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		for (int i = 0; i < list.size(); i++)
		{
			this.appendHtmlStr(list.get(i));
		}
	}

	private void appendHtmlStr(BaseEntity entity) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
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
		sb.append("<input type=\"radio\" value=\"").append(value).append("\"").append(" id=\"").append(this.getHtmlId() + "_" + value).append("\"")
				.append(" name=\"").append(this.getHtmlName()).append("\"");
		if (selectValue != null && selectValue.equals(value))
		{
			sb.append("checked=\"checked\"");
		}
		if (styleClass != null)
		{
			sb.append(" class=\"").append(styleClass).append("\"");
		}
		sb.append(" >").append(StringUtils.escapeHtml(display));
	}

	private Object getProperty(Object bean, String propNameChain, String delim) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException,
			NoSuchMethodException
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

	public String getSelectValue()
	{
		return selectValue;
	}

	public void setSelectValue(String selectValue)
	{
		this.selectValue = selectValue;
	}

	public String getValueName()
	{
		return valueName;
	}

	public void setValueName(String valueName)
	{
		this.valueName = valueName;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public String getHtmlName()
	{
		return htmlName;
	}

	public void setHtmlName(String htmlName)
	{
		this.htmlName = htmlName;
	}

	public String getHtmlId()
	{
		return htmlId;
	}

	public void setHtmlId(String htmlId)
	{
		this.htmlId = htmlId;
	}

}

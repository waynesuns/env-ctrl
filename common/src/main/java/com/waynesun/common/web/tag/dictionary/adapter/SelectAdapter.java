package com.waynesun.common.web.tag.dictionary.adapter;

import com.waynesun.utils.StringUtils;

/**
 * 下拉框标签适配器基类
 * 
 * @author weis
 * 
 */
public class SelectAdapter
{
	public static String getStartHtmlStr(String name, String id)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<select name=\"").append(StringUtils.escapeHtml(name));
		if (id != null)
			sb.append("\" id=\"").append(id);
		sb.append("\">");
		return sb.toString();
	}

	public static String getStartHtmlStr(String name, String id, String styleClass, String disabled, String onChange)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<select name=\"").append(StringUtils.escapeHtml(name));
		if (!StringUtils.isEmpty(id))
		{
			sb.append("\" id=\"").append(id);
		}
		if (!StringUtils.isEmpty(styleClass))
		{
			sb.append("\" class=\"").append(styleClass);
		}
		if (!StringUtils.isEmpty(onChange))
		{
			sb.append("\" onChange=\"").append(onChange);
		}
		if (!StringUtils.isEmpty(disabled) && disabled.equals("true"))
		{
			sb.append("\" disabled");
			sb.append(">");
		}
		else
		{
			sb.append("\">");
		}
		return sb.toString();
	}

	public static String getEndHtmlStr()
	{
		return "</select>";
	}
}

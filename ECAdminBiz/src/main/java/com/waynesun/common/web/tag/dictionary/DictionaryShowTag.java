package com.waynesun.common.web.tag.dictionary;

import javax.servlet.jsp.JspException;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import com.waynesun.common.biz.dictionary.DictionaryCacheUtils;

/**
 * 模板类型显示标签
 * 
 * @author weis
 * 
 */
public class DictionaryShowTag extends ShowTag
{
	private static final long serialVersionUID = -5860247657811547377L;
	private String parentCode;
	private String value;

	public Object getResult()
	{
		
		return DictionaryCacheUtils.getDictionaryItem(parentCode, value);
	}

	public String getParentCode()
	{
		return parentCode;
	}

	public void setParentCode(String parentCode) throws JspException
	{
		this.parentCode = (String) ExpressionEvaluatorManager.evaluate("parentCode", parentCode, String.class, pageContext);
	}
	public String getValue()
	{
		return value;
	}

	public void setValue(String value) throws JspException
	{
		this.value = (String) ExpressionEvaluatorManager.evaluate("value", value, String.class, pageContext);
	}
}

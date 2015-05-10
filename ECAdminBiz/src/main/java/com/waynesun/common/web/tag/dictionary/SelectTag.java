package com.waynesun.common.web.tag.dictionary;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import com.waynesun.common.web.tag.dictionary.adapter.SelectAdapter;

/**
 * 下拉框标签
 * 
 * @author weis
 * 
 */
public class SelectTag extends BodyTagSupport
{
	private static final long serialVersionUID = 5562252850386894316L;
	/** html id */
	private String id;
	/** html name */
	private String name;
	/** 选中值 */
	private String selectValue;
	/** CSS CLASS */
	private String styleClass;
	/** 是否禁用 */
	private String disabled;
	/** onchange事件JS方法 */
	private String onChange;
	/**需要显示的OPTION值*/
	private String validValues;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getSelectValue()
	{
		return selectValue;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getStyleClass()
	{
		return styleClass;
	}

	public void setStyleClass(String styleClass)
	{
		this.styleClass = styleClass;
	}

	public String getDisabled()
	{
		return disabled;
	}

	public void setDisabled(String disabled)
	{
		this.disabled = disabled;
	}

	public String getOnChange()
	{
		return onChange;
	}

	public void setOnChange(String onChange) throws JspException
	{
		this.onChange = ExpressionEvaluatorManager.evaluate("onChange", onChange, Object.class, pageContext).toString();
	}

	public void setSelectValue(String selectValue) throws JspException
	{
		this.selectValue = ExpressionEvaluatorManager.evaluate("selectValue", selectValue.toString(), Object.class, pageContext).toString();
	}

	public int doStartTag() throws JspException
	{
		JspWriter writer = pageContext.getOut();
		try
		{
			writer.write(SelectAdapter.getStartHtmlStr(name, id, styleClass, disabled, onChange));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		return BodyTagSupport.EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException
	{
		JspWriter writer = pageContext.getOut();
		try
		{

			writer.write(SelectAdapter.getEndHtmlStr());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		return TagSupport.EVAL_PAGE;
	}

	public String getValidValues() {
		return validValues;
	}

	public void setValidValues(String validValues) {
		this.validValues = validValues;
	}
	
}

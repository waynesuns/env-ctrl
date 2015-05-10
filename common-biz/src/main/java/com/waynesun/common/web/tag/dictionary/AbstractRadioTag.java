package com.waynesun.common.web.tag.dictionary;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import com.waynesun.common.web.tag.dictionary.adapter.RadioAdapter;

public abstract class AbstractRadioTag extends TagSupport{
	private static final long serialVersionUID = 7875584268623654555L;

	private String valueName;
	private String displayName;
	private String htmlName;
	private String htmlId;
	/** 选中值 */
	private String selectValue;
	/** CSS CLASS */
	private String styleClass;

	public abstract Object getResults();

	public int doStartTag() throws JspException
	{
		return TagSupport.SKIP_BODY;
	}

	public int doEndTag() throws JspException
	{
		JspWriter writer = pageContext.getOut();
		try
		{
			writer.write((new RadioAdapter(this.getResults(), valueName, displayName, this.getSelectValue(),this.getHtmlId(),this.getHtmlName(),styleClass)).getHtmlStr());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		return TagSupport.EVAL_PAGE;
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

	public String getHtmlName() {
		return htmlName;
	}

	public void setHtmlName(String htmlName) {
		this.htmlName = htmlName;
	}

	public String getHtmlId() {
		return htmlId;
	}

	public void setHtmlId(String htmlId) {
		this.htmlId = htmlId;
	}
	public String getSelectValue()
	{
		return selectValue;
	}
	public void setSelectValue(String selectValue) throws JspException
	{
		this.selectValue = ExpressionEvaluatorManager.evaluate("selectValue", selectValue.toString(), Object.class, pageContext).toString();
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	
}

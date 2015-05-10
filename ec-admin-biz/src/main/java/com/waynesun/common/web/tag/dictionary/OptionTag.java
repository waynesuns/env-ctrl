package com.waynesun.common.web.tag.dictionary;

import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.waynesun.common.web.tag.dictionary.adapter.OptionAdapter;

/**
 * option 标签
 * 
 * @author weis
 * 
 */
public abstract class OptionTag extends TagSupport
{
	private static final long serialVersionUID = -9054185565245511379L;
	/** option的value所对应的attribute name */
	private String valueName;
	/** option的name所对应的attribute name */
	private String displayName;

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
			SelectTag selectTag = (SelectTag) this.getParent();
			List<String> validValues = null;
			if(selectTag.getValidValues()!=null){
				validValues = Arrays.asList(selectTag.getValidValues().split(","));
			}
			writer.write((new OptionAdapter(this.getResults(), valueName, displayName, selectTag.getSelectValue(),validValues)).getHtmlStr());
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

}

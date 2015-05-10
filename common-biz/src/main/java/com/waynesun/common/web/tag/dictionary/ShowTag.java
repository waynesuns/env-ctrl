package com.waynesun.common.web.tag.dictionary;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.waynesun.utils.StringUtils;

public abstract class ShowTag extends TagSupport
{
	private static final long serialVersionUID = 6736194936901492576L;

	public abstract Object getResult();

	public int doStartTag() throws JspException
	{
		return TagSupport.SKIP_BODY;
	}

	public int doEndTag() throws JspException
	{
		JspWriter writer = pageContext.getOut();	
		try
		{
			Object v = this.getResult();
			if (v == null)
				v = "";
			writer.write(StringUtils.escapeHtml(v.toString()));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		return TagSupport.EVAL_PAGE;
	}
}
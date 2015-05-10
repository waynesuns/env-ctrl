package com.waynesun.common.web.tag.datatable;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.waynesun.exception.BizException;
import com.waynesun.utils.MessageReader;

public class LanguageI18NTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7986315591426575167L;

	@Override
	public int doEndTag() throws JspException
	{
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"sProcessing\":" + MessageReader.getMessage("sProcessing") + ",");
		sb.append("\"sLengthMenu\":" + MessageReader.getMessage("sLengthMenu") + ",");
		sb.append("\"sZeroRecords\":" + MessageReader.getMessage("sZeroRecords") + ",");
		sb.append("\"sInfo\":" + MessageReader.getMessage("sInfo") + ",");
		sb.append("\"sInfoEmpty\":" + MessageReader.getMessage("sInfoEmpty") + ",");
		sb.append("\"sInfoFiltered\":" + MessageReader.getMessage("sInfoFiltered") + ",");
		sb.append("\"sInfoPostFix\":\"\",");
		sb.append("\"sSearch\":" + MessageReader.getMessage("sSearch") + ",");
		sb.append("\"sUrl\":\"\",");
		sb.append("\"oPaginate\":{");
		sb.append("\"sFirst\":" + MessageReader.getMessage("sFirst") + ",");
		sb.append("\"sPrevious\":" + MessageReader.getMessage("sPrevious") + ",");
		sb.append("\"sNext\":" + MessageReader.getMessage("sNext") + ",");
		sb.append("\"sLast\":" + MessageReader.getMessage("sLast") + "");
		sb.append("}");
		sb.append("}");
		JspWriter out = pageContext.getOut();
		try
		{
			out.print(sb);
		}
		catch (IOException e)
		{
			throw new BizException(e);
		}
		return EVAL_PAGE;
	}
}

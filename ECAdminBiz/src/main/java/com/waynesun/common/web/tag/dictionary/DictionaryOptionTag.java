package com.waynesun.common.web.tag.dictionary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import com.waynesun.pojo.PojoState;
import com.waynesun.common.biz.dictionary.DictionaryCacheUtils;
import com.waynesun.common.biz.dictionary.DictionaryItem;

public class DictionaryOptionTag extends OptionTag
{
	private static final long serialVersionUID = 5667532827468195637L;
	private String parentCode;

	public DictionaryOptionTag()
	{
		this.setValueName("value");
		this.setDisplayName("name");
	}

	@Override
	public Object getResults()
	{
		PojoState[] pojoStates = new PojoState[]{PojoState.NORMAL,PojoState.SYSTEM};
		Collection<DictionaryItem> obj = DictionaryCacheUtils.getDictionaryItems(parentCode,pojoStates);
		List<DictionaryItem> list = new ArrayList<DictionaryItem>(obj);
		return list;
	}

	public String getParentCode()
	{
		return parentCode;
	}

	public void setParentCode(String parentCode) throws JspException
	{
		this.parentCode = (String) ExpressionEvaluatorManager.evaluate("parentCode", parentCode, String.class, pageContext);
	}
}

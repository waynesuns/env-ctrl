/**
 * 
 */
package com.waynesun.common.web.view;

import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 * 
 * Title: net<br>
 * Description:back<br>
 * create date：2010-5-23<br>
 * 
 * 多个ViewResolver
 * @author Administrator
 * @version: 0.1
 */
public class MultiViewResolver implements ViewResolver
{
	private Map<String, ViewResolver> resolvers;

	public void setResolvers(Map<String, ViewResolver> resolvers)
	{
		this.resolvers = resolvers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.ViewResolver#resolveViewName(java.lang
	 * .String, java.util.Locale)
	 */
	public View resolveViewName(String viewName, Locale locale) throws Exception
	{
		//如果默认json结尾, 则用json的resolver
		if(viewName.indexOf("json")>=0)
			return resolvers.get("json").resolveViewName(viewName, locale);
		return resolvers.get("jsp").resolveViewName(viewName, locale);
	}

}

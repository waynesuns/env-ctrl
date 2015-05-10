package com.waynesun.common.web.interceptor;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.waynesun.utils.MessageReaderWarpper;

/**
 * Title: ��ұ����<br>
 * Description:<br>
 * Copyright: Copyright (c) Steel Bright Intelligence 2006<br>
 * Company: 1703 Studio<br>
 * create date��2006-7-27<br>
 * ��ȡi18n��Ϣ��������
 * 
 * @author �
 * @version: 1.0
 */
public class I18nInterceptor implements HandlerInterceptor
{
	/**
	 * Default name of the locale specification parameter: "locale".
	 */
	public static final String DEFAULT_PARAM_NAME = "locale";

	private String paramName = DEFAULT_PARAM_NAME;

	/**
	 * Set the name of the parameter that contains a locale specification in a
	 * locale change request. Default is "locale".
	 */
	public void setParamName(String paramName)
	{
		this.paramName = paramName;
	}

	/**
	 * Return the name of the parameter that contains a locale specification in
	 * a locale change request.
	 */
	public String getParamName()
	{
		return this.paramName;
	}

	/**
	 * ΪMessageReaderWarpper����MessageSource��Locale���Դ����ṩi18n֧��
	 * 
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object)
	 * @see net.webuilder.framework.util.MessageReaderWarpper
	 * @see net.webuilder.framework.util.MessageReader#getMessage(String)
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		String newLocale = request.getParameter(this.paramName);
		//
		MessageReaderWarpper readerWarpper = MessageReaderWarpper.getInstance();
		if (!readerWarpper.hasMessageSource()) {
			ApplicationContext applicationContext = RequestContextUtils.getWebApplicationContext(request);
			readerWarpper.setMessageSource(applicationContext);
		}
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		if (newLocale != null) 
		{
			if (localeResolver == null) 
			{
				throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
			}
			LocaleEditor localeEditor = new LocaleEditor();
			localeEditor.setAsText(newLocale);
			Locale locale = (Locale) localeEditor.getValue();
			localeResolver.setLocale(request, response, locale);
			readerWarpper.setLocale(locale);
		}
		readerWarpper.setLocale(localeResolver.resolveLocale(request));
		return true;
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		// TODO �Զ���ɷ������

	}

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		// TODO �Զ���ɷ������

	}

}

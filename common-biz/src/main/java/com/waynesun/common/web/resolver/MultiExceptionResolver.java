/**
 * 
 */
package com.waynesun.common.web.resolver;

import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.waynesun.exception.BizException;
import com.waynesun.exception.NoUserException;


/**
 * Title: Ivy<br>
 * Description:中青常春藤<br>
 * create date：2010-6-14<br>
 * 
 * @author Administrator
 * @version: 0.1
 */
public class MultiExceptionResolver extends SimpleMappingExceptionResolver
{
	public final static String DEFAULT_JSON_ERROR_VIEW = "jsonView";
	
	private String xmlHttpHeaderTag = "X-Requested-With";
//
//	private String jsonErrorView = DEFAULT_JSON_ERROR_VIEW;
//
//	public final static String DEFAULT_AJAX_ERROR_VIEW = "/pages/errors/ajax_errors.jsp";
//
//	private String ajaxErrorView = DEFAULT_AJAX_ERROR_VIEW;
//
//	public void setJsonErrorView(String jsonErrorView)
//	{
//		this.jsonErrorView = jsonErrorView;
//	}

	// @Override
	// public ModelAndView resolveException(HttpServletRequest request,
	// HttpServletResponse response, Object handler,
	// Exception ex)
	// {
	// if(ex instanceof JsonResultException)
	// {
	// JsonResultException jsonE = (JsonResultException)ex;
	// ex.printStackTrace();
	// return new ModelAndView(jsonErrorView, jsonE.getJsonResult());
	// }
	// if(ex instanceof AjaxErrorException)
	// {
	// ex.printStackTrace();
	// request.setAttribute("err", ex.getMessage());
	// return new ModelAndView(ajaxErrorView);
	// }
	// return super.resolveException(request, response, handler, ex);
	// }
	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex)
	{
//		Enumeration<String> e  = request.getHeaderNames();
//		while(e.hasMoreElements())
//		{
//			String name = e.nextElement();
//			System.out.println(name + "=" + request.getHeader(name));
//		}
		ex.printStackTrace();
		if(request.getHeader(getXmlHttpHeaderTag()) != null)
		{
			request.setAttribute("isXMLRequest", true);
			if(ex instanceof LoginException || ex instanceof NoUserException){
				try {
					response.sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION,ex.getMessage());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(ex instanceof BizException){
				try {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST,ex.getMessage());
				} catch (IOException e) {
					e.printStackTrace();
				}
				//response.setStatus(5001);
			}else{
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}
		
		if(request.getHeader("accept")!= null && request.getHeader("accept").indexOf("application/json") >= 0)
		{/*
//			System.out.println("is json error");
//			response.setContentType("application/html" + ";charset=UTF-8");
//			response.setHeader("Pragma", "No-cache");
//			response.setHeader("Cache-Control", "no-cache");
//			response.setDateHeader("Expires", 0);
			

			response.setStatus(5001);
			if(ex instanceof BizException)
				request.setAttribute("json", MessageReader.getMessage("error.biz") + ex.getMessage());
			else
				request.setAttribute("json", MessageReader.getMessage("error.sys") + ex.getMessage());
			*/
			if(ex instanceof org.hibernate.StaleObjectStateException || ex instanceof org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException)
				return new ModelAndView("/errors/optimistic_locking_exception.jsp");
			
//			try
//			{
//				response.getWriter().write(jsonObj.toString());			
//				response.getWriter().flush();
//			} catch (IOException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//return new ModelAndView("/errors/json_exception.jsp");
		}
		
		return super.doResolveException(request, response, handler, ex);


	}

	/**
	 * @param xmlHttpHeaderTag the xmlHttpHeaderTag to set
	 */
	public void setXmlHttpHeaderTag(String xmlHttpHeaderTag)
	{
		this.xmlHttpHeaderTag = xmlHttpHeaderTag;
	}

	/**
	 * @return the xmlHttpHeaderTag
	 */
	public String getXmlHttpHeaderTag()
	{
		return xmlHttpHeaderTag;
	}

//	public void setAjaxErrorView(String ajaxErrorView)
//	{
//		this.ajaxErrorView = ajaxErrorView;
//	}

}

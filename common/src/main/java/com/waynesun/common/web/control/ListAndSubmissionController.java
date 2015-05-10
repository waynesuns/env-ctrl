/**
 * 
 */
package com.waynesun.common.web.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.waynesun.pojo.Pages;

/**
 * @author Administrator socko 2011-5-25
 */
public abstract class ListAndSubmissionController extends SubmissionController
{
	private Integer pageSize = Pages.DEFAULT_PAGE_SIZE;

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(HttpServletRequest request)
	{
		/*AbstractListHelper listHelp = getListHelper(request);
		listHelp.listObjects(request);*/
		return getListAjaxView();
	}

	/*protected AbstractListHelper getListHelper(HttpServletRequest request)
	{
		AbstractListHelper listHelp = new CommonListHelper(request, getUser(request), getCommandClass(), getPageSize());
		return listHelp;
	}
*/
	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}

	public Integer getPageSize()
	{
		return pageSize;
	}

	public abstract String getListAjaxView();
}

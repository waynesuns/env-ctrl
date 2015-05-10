/**
 * 
 */
package com.waynesun.common.web.view;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.waynesun.common.web.view.template.UserTemplate;


/**
 * @author Administrator
 * 
 */
public class TilesAndJstlViewResolver extends InternalResourceViewResolver
{
	private UserTemplate userTemplate = new UserTemplate();
	
	public static String NO_TEMPLATE_SUFFIX = "noTemplate:";

	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception
	{
		AbstractUrlBasedView view = super.buildView(viewName);
		
		if(viewName.indexOf(NO_TEMPLATE_SUFFIX)>=0)
		{
			view.setUrl(viewName.substring(viewName.indexOf(NO_TEMPLATE_SUFFIX) + NO_TEMPLATE_SUFFIX.length()));
//			System.out.println(view.getUrl());
			return view;
		}
		// User user = UserUtils.getUserIgnoreNull();
		String template = userTemplate.getDefaultName();
		// if (user != null)
		// {
		// String userId = user.getId();
		// template = userTemplate.getTemplateName(userId);
		// }

		// portal系统访问第三方系统
		// 返回:.accessSystem~http://192.168.1.11:8080/sanbao/home/show.do
		if (viewName.startsWith(".accessSystem"))
		{
			if (viewName.indexOf("~") > 0)
			{
				String[] names = viewName.split("~");
				view.setUrl("." + template + names[0] );
				view.addStaticAttribute("tiles_content", names[1]);
				return view;
			}
			viewName = viewName.startsWith("/")?viewName:"/"+viewName;
			view.setUrl("." + template + viewName);
			return view;
		}
		////////////
		
		if (viewName.startsWith("."))
		{
			if (viewName.indexOf("~") > 0)
			{
				String[] names = viewName.split("~");
				view.setUrl("." + template + names[0] );
				String url = names[1].startsWith("/")?names[1]:"/"+names[1];
				view.addStaticAttribute("tiles_content", getPrefix() + template + url + getSuffix());
				return view;
			}
			viewName = viewName.startsWith("/")?viewName:"/"+viewName;
			view.setUrl("." + template + viewName);
			return view;
		}
		viewName = viewName.startsWith("/")?viewName:"/"+viewName;
		view.setUrl(getPrefix() + template + viewName + this.getSuffix());
		return view;
	}

	public void setUserTemplate(UserTemplate userTemplate)
	{
		this.userTemplate = userTemplate;
	}

	public UserTemplate getUserTemplate()
	{
		return userTemplate;
	}

}

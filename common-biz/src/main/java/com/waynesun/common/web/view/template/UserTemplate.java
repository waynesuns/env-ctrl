/**
 * 
 */
package com.waynesun.common.web.view.template;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public class UserTemplate
{
	private static final UserTemplate INSTANCE =  new UserTemplate();
	private static String DEFAULT_TEMPLATE_NAME = "default";
	
	private String defaultName = DEFAULT_TEMPLATE_NAME;
	
	private Map<String, String> userTemplate = new HashMap<String, String>();
	
	public String getTemplateName(String userId)
	{
		String templateName = userTemplate.get(userId);
		if(templateName == null)
			return getDefaultName();
		return templateName;
	}
	
	public static UserTemplate getInstance(){
		return UserTemplate.INSTANCE;
	}

	public String getUrl(String url){
		return "resources/"+UserTemplate.DEFAULT_TEMPLATE_NAME+"/"+url;
	}
	public void setDefaultName(String defaultName)
	{
		this.defaultName = defaultName;
	}

	public String getDefaultName()
	{
		return defaultName;
	}
}

package com.waynesun.utils;

import java.util.Properties;

public class PropertyUtils
{

	public static Properties properties = null;

	public static void init()
	{
		properties = (Properties)SpringContextUtil.getBean("configproperties");
	}

	public static String getValue(String key)
	{
		if (properties == null)
			init();
		return properties.getProperty(key);
	}
}

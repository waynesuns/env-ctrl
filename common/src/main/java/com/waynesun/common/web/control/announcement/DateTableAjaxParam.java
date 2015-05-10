package com.waynesun.common.web.control.announcement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.waynesun.utils.StringUtils;

public class DateTableAjaxParam
{
	private String sSearch_0;
	private String sSearch_1;
	private String sSearch_2;
	private String sSearch_3;
	private String sSearch_4;
	private String sSearch_5;
	private String sSearch_6;
	private String sSearch_7;
	private String sSearch_8;
	private String sSearch_9;
	private String sSearch_10;
	private String sSearch_11;
	private String sSearch_12;
	
	public boolean isHaveParam() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Method[] methods = this.getClass().getDeclaredMethods();
		for(Method method : methods)
		{
			if(method.getName().startsWith("getsSearch"))
			{
				Object value = method.invoke(this);
				if(!StringUtils.isEmpty(value))
					return true;
			}
		}
		return false;
	}
	
	public String getsSearch_0()
	{
		return sSearch_0;
	}

	public void setsSearch_0(String sSearch_0)
	{
		this.sSearch_0 = sSearch_0;
	}

	public String getsSearch_1()
	{
		return sSearch_1;
	}

	public void setsSearch_1(String sSearch_1)
	{
		this.sSearch_1 = sSearch_1;
	}

	public String getsSearch_2()
	{
		return sSearch_2;
	}

	public void setsSearch_2(String sSearch_2)
	{
		this.sSearch_2 = sSearch_2;
	}

	public String getsSearch_3()
	{
		return sSearch_3;
	}

	public void setsSearch_3(String sSearch_3)
	{
		this.sSearch_3 = sSearch_3;
	}

	public String getsSearch_4()
	{
		return sSearch_4;
	}

	public void setsSearch_4(String sSearch_4)
	{
		this.sSearch_4 = sSearch_4;
	}

	public String getsSearch_5()
	{
		return sSearch_5;
	}

	public void setsSearch_5(String sSearch_5)
	{
		this.sSearch_5 = sSearch_5;
	}

	public String getsSearch_6()
	{
		return sSearch_6;
	}

	public void setsSearch_6(String sSearch_6)
	{
		this.sSearch_6 = sSearch_6;
	}

	public String getsSearch_7()
	{
		return sSearch_7;
	}

	public void setsSearch_7(String sSearch_7)
	{
		this.sSearch_7 = sSearch_7;
	}

	public String getsSearch_8()
	{
		return sSearch_8;
	}

	public void setsSearch_8(String sSearch_8)
	{
		this.sSearch_8 = sSearch_8;
	}

	public String getsSearch_9()
	{
		return sSearch_9;
	}

	public void setsSearch_9(String sSearch_9)
	{
		this.sSearch_9 = sSearch_9;
	}

	public String getsSearch_10()
	{
		return sSearch_10;
	}

	public void setsSearch_10(String sSearch_10)
	{
		this.sSearch_10 = sSearch_10;
	}

	public String getsSearch_11()
	{
		return sSearch_11;
	}

	public void setsSearch_11(String sSearch_11)
	{
		this.sSearch_11 = sSearch_11;
	}

	public String getsSearch_12()
	{
		return sSearch_12;
	}

	public void setsSearch_12(String sSearch_12)
	{
		this.sSearch_12 = sSearch_12;
	}
}

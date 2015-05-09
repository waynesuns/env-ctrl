package com.waynesun.pojo;

import java.util.EnumSet;

/**
 * Title: 宝冶二期<br>
 * Description:<br>
 * Copyright: Copyright &copy; Steel Bright Intelligence 2006<br>
 * Company: 1703 Studio<br>
 * create date：2006-6-20<br>
 * 
 * 描述Pojo的状态
 * 
 * @author  
 * @version: 1.0
 */
public enum PojoState
{
	NORMAL(0), DELETED(1), LIMITED(2), SYSTEM(128);

	private int state;

	PojoState(int state)
	{
		this.state = state;
	}

	public int getState()
	{
		return state;
	}

	private static EnumSet<PojoState> set = EnumSet.allOf(PojoState.class);

	public static PojoState valueOf(int state)
	{
		for (PojoState enum1 : set)
		{
			if (enum1.getState() == state)
				return enum1;
		}
		throw new IllegalArgumentException("未知的枚举值：" + state);
	}
}

package com.waynesun.common.biz.log;

import java.util.EnumSet;

/**
 * 操作类型枚举
 * 
 * @author Liu Bin
 * 
 * @version 创建时间：2012-6-22下午12:27:38
 */
public enum OperateLogType
{
	/** 添加 */
	ADD(0),
	/** 修改 */
	MODIFY(1),
	/** 删除 */
	DELETE(2),
	/** 登入*/
	LOGIN(3),
	/** 登出*/
	LOGINOUT(4);
	
	private int status;
	private static EnumSet<OperateLogType> set = EnumSet.allOf(OperateLogType.class);
	

	OperateLogType(int status)
	{
		this.status = status;
	}

	public static OperateLogType valueOf(int status)
	{
		for (OperateLogType olt : set)
		{
			if (status == olt.getStatus())
				return olt;
		}
		throw new IllegalArgumentException("未知枚举：" + status);
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}
}

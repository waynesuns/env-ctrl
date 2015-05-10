package com.waynesun.common.biz.log;

import com.waynesun.pojo.BaseEntity;

/**
 * 操作日志
 * 
 * @author Liu Bin
 * 
 * @version 创建时间：2012-6-22下午12:21:19
 */
public class OperateLog extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2783272527094376794L;
	
	/** 操作类型 */
	private OperateLogType type;
	/** 目标类全名 */
	private String targetClass;
	/** 目标ID */
	private String targetId;

	protected OperateLog()
	{
	}
	public void saveOperateLog(){
		SystemLogProcess.addOperateLog(this);
	}
	
	public static OperateLog getInstance(Log log,OperateLogType type)
	{
		OperateLog operate = new OperateLog();
		operate.setTargetClass(log.getClassName());
		operate.setTargetId(log.getId());
		operate.setType(type);
		return operate;
	}
	
	//操作日志修改调用方法
	public static void update(Log log){
		getInstance(log,OperateLogType.MODIFY).update();
	}
	
	public OperateLogType getType()
	{
		return type;
	}

	public void setType(OperateLogType type)
	{
		this.type = type;
	}

	public String getTargetClass()
	{
		return targetClass;
	}

	public void setTargetClass(String targetClass)
	{
		this.targetClass = targetClass;
	}

	public String getTargetId()
	{
		return targetId;
	}

	public void setTargetId(String targetId)
	{
		this.targetId = targetId;
	}
}

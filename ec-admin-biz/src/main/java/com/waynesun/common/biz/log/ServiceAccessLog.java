package com.waynesun.common.biz.log;

import java.util.Date;

import com.waynesun.pojo.BaseEntity;

/**
 * 接口访问日志
 * @author wayne
 *
 */
public class ServiceAccessLog extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -12032028016000298L;
	/**接口类型*/
	private Integer type;
	/**操作类型*/
	private Integer operateType;
	/**调用开始时间*/
	private Date beginTime;
	/**调用结束时间*/
	private Date endTime;
	/**调用参数*/
	private String param;
	/**失败原因*/
	private String failResult;
	/**状态（成功/失败）*/
	private Integer status;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getFailResult() {
		return failResult;
	}

	public void setFailResult(String failResult) {
		this.failResult = failResult;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public void update() {
		if (this.failResult != null && this.failResult.length() > 1000) {
			this.failResult = this.failResult.substring(0, 1000);
		}
		super.update();
	}
}
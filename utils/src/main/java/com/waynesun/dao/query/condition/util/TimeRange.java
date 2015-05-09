package com.waynesun.dao.query.condition.util;

import java.util.Date;

/**
 * @ClassName: TimeRange
 * @Description: 时间范围(配合 DateZone 使用)
 * @author zhengnan
 * @date 2014年3月31日 下午2:13:46
 *
 */
public class TimeRange {
	/** 开始时间 */
	private Date startTime;
	/** 结束时间 */
	private Date endTime;

	public TimeRange(Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
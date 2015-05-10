package com.waynesun.common.biz.announcement;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;

public class DealerAnnouncementAuthConfQC extends BaseQueryCondition{

	/**
	 * 
	 */
	private static final long serialVersionUID = -456587663543960435L;
	private Integer status;
	/** 发布 */
	private boolean announcement_released;
	private String dealer_id;
	
	@Eq
	public String getDealer_id() {
		return dealer_id;
	}

	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}

	@Eq
	public boolean isAnnouncement_released() {
		return announcement_released;
	}

	public void setAnnouncement_released(boolean announcement_released) {
		this.announcement_released = announcement_released;
	}

	@Eq
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

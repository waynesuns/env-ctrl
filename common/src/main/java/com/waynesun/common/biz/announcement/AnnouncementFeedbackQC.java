package com.waynesun.common.biz.announcement;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;

public class AnnouncementFeedbackQC extends BaseQueryCondition{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1792979992282435711L;
	private String user_id;
	private AnnouncementReadStatus status;
	private String announcement_id;
	@Eq
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Eq
	public AnnouncementReadStatus getStatus() {
		return status;
	}
	public void setStatus(AnnouncementReadStatus status) {
		this.status = status;
	}
	@Eq
	public String getAnnouncement_id() {
		return announcement_id;
	}
	public void setAnnouncement_id(String announcement_id) {
		this.announcement_id = announcement_id;
	}
	
	
}

package com.waynesun.common.biz.announcement;

import com.waynesun.common.biz.user.AbstractDealer;

/**按网点进行授权*/
public class DealerAnnouncementAuthConf extends AbstractAnnouncementAuthConf {
	
	public static final Integer UNREAD = 0;
	public static final Integer READ = 1;
	
	
	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	
	/**被授权浏览的网点*/
	public AbstractDealer dealer;
	/**公告*/ 
	public Announcement announcement;
	/**已读1，未读0*/
	public Integer status;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public AbstractDealer getDealer() {
		return dealer;
	}

	public void setDealer(AbstractDealer dealer) {
		this.dealer = dealer;
	}
	

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
}

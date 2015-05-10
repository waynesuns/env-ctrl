package com.waynesun.common.biz.announcement;


import com.waynesun.pojo.BaseEntity;
import com.waynesun.common.biz.user.AbstractUser;

/**
 * 公告回执
 * @author wayne
 *
 */
public class AnnouncementFeedback extends BaseEntity {
	private static final long serialVersionUID = -6421684854683404057L;
	/**所属公告*/
	private Announcement announcement;
	/**阅读人*/
	private AbstractUser user;
	/**公告阅读状态*/
	private AnnouncementReadStatus status;
	
	public AbstractUser getUser() {
		return user;
	}
	public void setUser(AbstractUser user) {
		this.user = user;
	}
	public Announcement getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
	public AnnouncementReadStatus getStatus() {
		return status;
	}
	public void setStatus(AnnouncementReadStatus status) {
		this.status = status;
	}
	
	
}

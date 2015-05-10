package com.waynesun.common.biz.announcement;

/**
 * 
 * 公告阅读状态
 * @author wayne
 *
 */
public enum AnnouncementReadStatus {
	/**已读*/
	READ(1),
	/**未读*/
	UNREAD(0);
	
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	AnnouncementReadStatus(int status){
		this.status = status;
	}
	
	public static AnnouncementReadStatus valueOf(int status)
	{
		for (AnnouncementReadStatus enum1 : AnnouncementReadStatus.values())
		{
			if (enum1.getStatus() == status)
				return enum1;
		}
		throw new IllegalArgumentException("未知的枚举值：" + status);
	}
}

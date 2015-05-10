package com.waynesun.common.biz.attachment;

import com.waynesun.pojo.BizObject;
import com.waynesun.pojo.PojoState;
import com.waynesun.common.biz.announcement.Announcement;

public class Attachment extends BizObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1939587764725402541L;

	private Announcement announcement;
	private String fileName;
	private String filePath;
	private PojoState state = PojoState.NORMAL;
	
	public void relation(Announcement announcement)
	{
		this.setAnnouncement(announcement);
		this.update();
	}

	public Announcement getAnnouncement()
	{
		return announcement;
	}

	public void setAnnouncement(Announcement announcement)
	{
		this.announcement = announcement;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}

	public PojoState getState()
	{
		return state;
	}

	public void setState(PojoState state)
	{
		this.state = state;
	}
}

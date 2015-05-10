package com.waynesun.common.web.ftp.command;

import java.io.Serializable;

public class StorArgument implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -797359721090283288L;
	private String type;
	private String fileName;
	private String uuid;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}

package com.waynesun.utils.impt;

import com.waynesun.utils.MessageReader;


public class ImportErrorInfo {
	/** 异常信息参数 */
	private String[] params;

	private String errorCode;

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public ImportErrorInfo() {
		super();
	}

	/**
	 * 
	 * 
	 * @param errorCode 异常代码，自己到message.properties去看
	 * @param params 异常信息参数，自己到message.properties去看
	 */
	public ImportErrorInfo(String errorCode, String... params)
	{
		setParams(params);
		this.errorCode = errorCode;
	}
	
	public String getMessage()
	{
		return MessageReader.getMessage(getErrorCode(), params);
	}
	
	public String getHtmlMessage(){
		return "<li>"+getMessage()+"</li>";
	}
}

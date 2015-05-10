package com.waynesun.common.utils;

import com.waynesun.common.web.ftp.command.StorArgument;

public class StorUtils {
	public static String getFilePathName(StorArgument argument){
		String fileName=argument.getFileName();
		String fileType=fileName.substring(fileName.lastIndexOf("."));
		if(fileName.indexOf("/")>0){
			fileName=fileName.substring(0,fileName.lastIndexOf("/")+1);
		}else{
			fileName="/";
		}
		fileName=fileName+argument.getUuid()+fileType;
		return fileName;
	}
}

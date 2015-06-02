package com.waynesun.utils.export.param.it;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

import com.waynesun.utils.export.param.ExportParamInterType;

/**
 * 日期类型转字符串
 * @author wayne
 *
 */
public class DateFormatEPIT implements ExportParamInterType{
	private String pattern;
	public DateFormatEPIT(){
		this("yyyy-MM-dd");
	}
	public DateFormatEPIT(String pattern){
		this.pattern = pattern;
	}
	@Override
	public Object getValue(Object value) {
		if(value==null)
			return "";
		System.out.println(DateFormatUtils.format((Date) value, pattern));
		return DateFormatUtils.format((Date) value, pattern);
	}

}

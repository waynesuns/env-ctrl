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
	public DateFormatEPIT(String pattern){
		this.pattern = pattern;
	}
	@Override
	public Object getValue(Object value) {
		if(value==null)
			return "";
		return DateFormatUtils.format((Date) value, pattern);
	}

}

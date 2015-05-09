package com.waynesun.utils.export.param.vt;

import com.waynesun.utils.export.param.ExportParamValueType;

/**
 * 字符串形式的值类型
 * @author wayne
 *
 */
public class StringEPVT implements ExportParamValueType{
	private String value;
	public StringEPVT(String value){
		this.value = value;
	}
	@Override
	public Object getValue(Object object){
		return value;
	}
	

}

package com.waynesun.common.biz.config;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Like;

public class SystemConfigQC extends BaseQueryCondition{
	private String code;
	private String name;
	private String value;
	@Like
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Like
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Like
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}

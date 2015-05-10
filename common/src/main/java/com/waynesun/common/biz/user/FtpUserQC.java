package com.waynesun.common.biz.user;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;

public class FtpUserQC extends BaseQueryCondition{
	private String name;
	@Eq
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

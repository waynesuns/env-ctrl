package com.waynesun.common.biz.user;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;
import com.waynesun.pojo.PojoState;

public class EmployeeQC extends BaseQueryCondition {
	private PojoState state;

	@Eq
	public PojoState getState() {
		return state;
	}

	public void setState(PojoState state) {
		this.state = state;
	}

}

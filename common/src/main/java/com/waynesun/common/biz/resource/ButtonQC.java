package com.waynesun.common.biz.resource;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;
import com.waynesun.dao.query.condition.annotation.IsNot;
import com.waynesun.dao.query.condition.annotation.PropertyProxy;
import com.waynesun.pojo.PojoState;

public class ButtonQC extends BaseQueryCondition
{
	private String code;
	
	private PojoState state;
	
	private PojoState state_not;

	@Eq
	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	@Eq
	public PojoState getState()
	{
		return state;
	}

	public void setState(PojoState state)
	{
		this.state = state;
	}

	@Eq
	@IsNot
	@PropertyProxy(propertyChain="state")
	public PojoState getState_not()
	{
		return state_not;
	}

	public void setState_not(PojoState state_not)
	{
		this.state_not = state_not;
	}
}

package com.waynesun.common.biz.user;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;
import com.waynesun.pojo.PojoState;

public class LoginAccountQC extends BaseQueryCondition
{
	private String userName;
	private String password;
	private PojoState state;
	private PojoState user_state;

	@Eq
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Eq
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
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
	public PojoState getUser_state()
	{
		return user_state;
	}

	public void setUser_state(PojoState user_state)
	{
		this.user_state = user_state;
	}
}

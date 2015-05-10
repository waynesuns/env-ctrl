package com.waynesun.common.biz.user;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;
import com.waynesun.dao.query.condition.annotation.IdEq;
import com.waynesun.dao.query.condition.annotation.IsNot;
import com.waynesun.dao.query.condition.annotation.Like;
import com.waynesun.dao.query.condition.annotation.PropertyProxy;
import com.waynesun.pojo.PojoState;

public class UserQC extends BaseQueryCondition
{
	private String name;
	private String userName;
	private String account_userName;
	private String sex;
	private String roles_name;
	private PojoState state;
	private String userGroup;
	private PojoState state_not;
	private String employeeId;
	private String roles_id;
	private String name_search;
	private String dealer_dealerCode;
	private String login_userName;
	private String dealer_id;

	@Like(matchMode = Like.START) 
	@PropertyProxy(propertyChain = "name")
	public String getName_search()
	{
		return name_search;
	}

	public void setName_search(String name_search)
	{
		this.name_search = name_search;
	}

	@PropertyProxy(propertyChain = "name")
	@Like(matchMode = Like.START)
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Eq
	public String getEmployeeId()
	{
		return employeeId;
	}

	public void setEmployeeId(String employeeId)
	{
		this.employeeId = employeeId;
	}

	@Eq
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Like(matchMode = Like.START)
	public String getAccount_userName()
	{
		return account_userName;
	}

	public void setAccount_userName(String account_userName)
	{
		this.account_userName = account_userName;
	}

	@Eq
	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	@Eq
	public String getRoles_name()
	{
		return roles_name;
	}

	public void setRoles_name(String roles_name)
	{
		this.roles_name = roles_name;
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
	public String getUserGroup()
	{
		return userGroup;
	}

	public void setUserGroup(String userGroup)
	{
		this.userGroup = userGroup;
	}

	@Eq
	@IsNot
	@PropertyProxy(propertyChain = "state")
	public PojoState getState_not()
	{
		return state_not;
	}

	public void setState_not(PojoState state_not)
	{
		this.state_not = state_not;
	}
	@IdEq
	public String getRoles_id()
	{
		return roles_id;
	}

	
	public void setRoles_id(String roles_id)
	{
		this.roles_id = roles_id;
	}

	@Eq
	@PropertyProxy(propertyChain = "account_userName")
	public String getLogin_userName() {
		return login_userName;
	}

	public void setLogin_userName(String login_userName) {
		this.login_userName = login_userName;
	}

	@Eq
	public String getDealer_dealerCode() {
		return dealer_dealerCode;
	}

	public void setDealer_dealerCode(String dealer_dealerCode) {
		this.dealer_dealerCode = dealer_dealerCode;
	}

	@Eq
	public String getDealer_id() {
		return dealer_id;
	}

	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}
}

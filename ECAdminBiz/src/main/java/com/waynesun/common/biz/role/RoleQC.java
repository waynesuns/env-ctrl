package com.waynesun.common.biz.role;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;
import com.waynesun.dao.query.condition.annotation.IdEq;
import com.waynesun.dao.query.condition.annotation.IsNot;
import com.waynesun.dao.query.condition.annotation.Like;
import com.waynesun.dao.query.condition.annotation.PropertyProxy;
import com.waynesun.pojo.PojoState;

public class RoleQC extends BaseQueryCondition
{
	private PojoState state;

	private String users_id;

	private PojoState state_not;
	
	private PojoState state_not_other;
	
	private String resources_id;
	
	private String name;
	
	private String not_roeId;
	
	private String dealer_id;
	
	private String dealer_dealerCode;
	
	@Eq
	public String getDealer_dealerCode() {
		return dealer_dealerCode;
	}

	public void setDealer_dealerCode(String dealer_dealerCode) {
		this.dealer_dealerCode = dealer_dealerCode;
	}

	@Like(matchMode = Like.START)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@IdEq
	public String getResources_id() {
		return resources_id;
	}

	public void setResources_id(String resources_id) {
		this.resources_id = resources_id;
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
	public String getUsers_id()
	{
		return users_id;
	}

	public void setUsers_id(String users_id)
	{
		this.users_id = users_id;
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
	
	@Eq
	@IsNot
	@PropertyProxy(propertyChain = "state")
	public PojoState getState_not_other() {
		return state_not_other;
	}

	public void setState_not_other(PojoState state_not_other) {
		this.state_not_other = state_not_other;
	}

	@Eq
	@IsNot
	@PropertyProxy(propertyChain = "id")
	public String getNot_roeId() {
		return not_roeId;
	}

	public void setNot_roeId(String not_roeId) {
		this.not_roeId = not_roeId;
	}

	@Eq
	public String getDealer_id() {
		return dealer_id;
	}

	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}
	
}

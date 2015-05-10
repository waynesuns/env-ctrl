package com.waynesun.common.biz.resource;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;
import com.waynesun.dao.query.condition.annotation.IdEq;
import com.waynesun.dao.query.condition.annotation.IsNot;
import com.waynesun.dao.query.condition.annotation.PropertyProxy;
import com.waynesun.pojo.PojoState;

/**
 * @ClassName: ResourceQC
 * @Description: Resource查询条件
 */
public class ResourceQC extends BaseQueryCondition {
	private static final long serialVersionUID = 1L;

	private String code;
	private PojoState state;
	private PojoState state_not;
	private Integer level;
	private String roles_id;
	private String roles_users_id;
	private PojoState roles_state;

	@Eq
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Eq
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Eq
	public PojoState getState() {
		return state;
	}

	public void setState(PojoState state) {
		this.state = state;
	}

	@Eq
	@IsNot
	@PropertyProxy(propertyChain = "state")
	public PojoState getState_not() {
		return state_not;
	}

	public void setState_not(PojoState state_not) {
		this.state_not = state_not;
	}

	@Eq
	public String getRoles_id() {
		return roles_id;
	}

	public void setRoles_id(String roles_id) {
		this.roles_id = roles_id;
	}

	@IdEq
	public String getRoles_users_id() {
		return roles_users_id;
	}

	public void setRoles_users_id(String roles_users_id) {
		this.roles_users_id = roles_users_id;
	}

	@Eq
	public PojoState getRoles_state() {
		return roles_state;
	}

	public void setRoles_state(PojoState roles_state) {
		this.roles_state = roles_state;
	}
}
package com.waynesun.common.biz.dictionary;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;
import com.waynesun.dao.query.condition.annotation.IdEq;
import com.waynesun.dao.query.condition.annotation.IsNot;
import com.waynesun.dao.query.condition.annotation.PropertyProxy;
import com.waynesun.pojo.PojoState;


public class DictionaryQC extends BaseQueryCondition
{
	private String name;
	private String code;
	private String value;
	private String parent_id;
	private String parent_code;
	private String parent_value;
	private String parent_name;
	private PojoState state;
	private PojoState state_not;

	@Eq
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

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
	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	@IdEq
	public String getParent_id()
	{
		return parent_id;
	}

	public void setParent_id(String parent_id)
	{
		this.parent_id = parent_id;
	}

	@Eq
	public String getParent_code()
	{
		return parent_code;
	}

	public void setParent_code(String parent_code)
	{
		this.parent_code = parent_code;
	}

	@Eq
	public String getParent_value()
	{
		return parent_value;
	}

	public void setParent_value(String parent_value)
	{
		this.parent_value = parent_value;
	}

	@Eq
	public String getParent_name()
	{
		return parent_name;
	}

	public void setParent_name(String parent_name)
	{
		this.parent_name = parent_name;
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
	@PropertyProxy(propertyChain = "state")
	public PojoState getState_not()
	{
		return state_not;
	}

	public void setState_not(PojoState state_not)
	{
		this.state_not = state_not;
	}
}

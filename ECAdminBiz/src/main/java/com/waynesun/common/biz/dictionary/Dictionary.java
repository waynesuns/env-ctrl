package com.waynesun.common.biz.dictionary;

import com.waynesun.pojo.BaseEntity;

public abstract class Dictionary extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 674059714700402237L;

	
	/** 名称，必填最长30位 */
	private String name;
	/** 编号，必填、唯一、字母数字下划线组合，最长16位 */
	private String code;
	/** 值，必填，本数据字典类型内必须唯一，最能是字母数字组合，最长16位 */
	private String value;

	/**
	 * 首次创建，验证重复
	 */
	public abstract void validateRepeat();

	/**
	 * 获取子类标示
	 * 
	 * @return
	 */
	public abstract int getDiscriminator();

	@Override
	public void update()
	{
		if (getId() == null || "".equals(getId()))
			validateRepeat();
		super.update();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
}
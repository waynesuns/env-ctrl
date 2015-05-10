package com.waynesun.common.biz.area;

import com.waynesun.pojo.BaseEntity;



/**
 * 省市区抽象父类
 * 
 * @author Liu Bin
 * 
 * @version 创建时间：2012-7-2下午8:13:44
 */
public class AbstractArea extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2697743623684446089L;

	/** 关联父对象 */
	private AbstractArea parent;
	/** 省/市/区编号 */
	private String code;
	/** 省/市/区名称 */
	private String name;
	/** 邮编 */
	private String zipCode;
	/** 电话区号 */
	private String phoneCode;

	public AbstractArea getParent()
	{
		return parent;
	}

	public void setParent(AbstractArea parent)
	{
		this.parent = parent;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getPhoneCode()
	{
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode)
	{
		this.phoneCode = phoneCode;
	}
}

package com.waynesun.common.biz.dealerarea.rel;

import com.waynesun.pojo.BasePojo;
import com.waynesun.common.biz.area.ProvinceArea;
import com.waynesun.common.biz.dealerarea.AbstractDealerArea;



/**
 * 省市区级联同经销商区域的中间表
 * 
 * @author Liu Bin
 * 
 * @version 创建时间：2012-7-2下午8:22:39
 */
public class DealerAreaRel extends BasePojo
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -259889604837607754L;

	/** 经销商区域 */
	private AbstractDealerArea dealerAraea;
	/** 省 */
	private ProvinceArea area;

	public AbstractDealerArea getDealerAraea()
	{
		return dealerAraea;
	}

	public void setDealerAraea(AbstractDealerArea dealerAraea)
	{
		this.dealerAraea = dealerAraea;
	}

	public ProvinceArea getArea()
	{
		return area;
	}

	public void setArea(ProvinceArea area)
	{
		this.area = area;
	}
}

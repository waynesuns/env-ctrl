package com.waynesun.common.biz.area;

import java.util.Set;

import com.waynesun.common.biz.dealerarea.rel.DealerAreaRel;

/**
 * 省
 *
 * @author Liu Bin
 *
 * @version 创建时间：2012-7-2下午8:20:09
 */
public class ProvinceArea extends AbstractArea
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4418078809823834315L;

	/** 市列表 */
	private Set<CityArea> cityAreas;
	/** 经销商区域同省市区级联中间对象 */
	private Set<DealerAreaRel> dealerAreaRels;

	public Set<CityArea> getCityAreas()
	{
		return cityAreas;
	}

	public void setCityAreas(Set<CityArea> cityAreas)
	{
		this.cityAreas = cityAreas;
	}

	public Set<DealerAreaRel> getDealerAreaRels()
	{
		return dealerAreaRels;
	}

	public void setDealerAreaRels(Set<DealerAreaRel> dealerAreaRels)
	{
		this.dealerAreaRels = dealerAreaRels;
	}
	
	public String getProName(){
		return this.getName().replace("自治区", "").replace("市","").replace("省","");
	}
}

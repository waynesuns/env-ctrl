package com.waynesun.common.biz.area;

import java.util.Set;

/**
 * 市
 *
 * @author Liu Bin
 *
 * @version 创建时间：2012-7-2下午8:20:36
 */
public class CityArea extends AbstractArea
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3300758346331058863L;

	/** 省 */
	private ProvinceArea provinceArea;
	/** 区列表 */
	private Set<DistrictArea> districtAreas;

	public ProvinceArea getProvinceArea()
	{
		return provinceArea;
	}

	public void setProvinceArea(ProvinceArea provinceArea)
	{
		this.provinceArea = provinceArea;
	}

	public Set<DistrictArea> getDistrictAreas()
	{
		return districtAreas;
	}

	public void setDistrictAreas(Set<DistrictArea> districtAreas)
	{
		this.districtAreas = districtAreas;
	}
}

package com.waynesun.common.biz.area;

/**
 * 区
 *
 * @author Liu Bin
 *
 * @version 创建时间：2012-7-2下午8:21:58
 */
public class DistrictArea extends AbstractArea
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5175368992424736587L;

	/** 市 */
	private CityArea cityArea;

	public CityArea getCityArea()
	{
		return cityArea;
	}

	public void setCityArea(CityArea cityArea)
	{
		this.cityArea = cityArea;
	}
}

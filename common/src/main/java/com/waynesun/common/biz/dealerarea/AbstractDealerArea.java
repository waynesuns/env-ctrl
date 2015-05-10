package com.waynesun.common.biz.dealerarea;

import java.util.Set;

import com.waynesun.pojo.BaseEntity;
import com.waynesun.common.biz.dealerarea.rel.DealerAreaRel;
import com.waynesun.common.biz.veh.VehicleBrand;


/**
 * 经销商区域抽象父类
 *
 * @author Liu Bin
 *
 * @version 创建时间：2012-7-2下午4:45:23
 */
public class AbstractDealerArea extends BaseEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4709265335234154877L;
	
	/** 经销商区域名称 */
	private String name;
	/** 经销商区域同省市区级联中间对象 */
	private Set<DealerAreaRel> dealerAreaRels;
	/** 区域分组（1商用，2乘用） */
	private Integer areaGroup;
	/** 车辆品牌 (1五菱，2宝骏) */
	private VehicleBrand brand;
	

	public VehicleBrand getBrand() {
		return brand;
	}

	public void setBrand(VehicleBrand brand) {
		this.brand = brand;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<DealerAreaRel> getDealerAreaRels()
	{
		return dealerAreaRels;
	}

	public void setDealerAreaRels(Set<DealerAreaRel> dealerAreaRels)
	{
		this.dealerAreaRels = dealerAreaRels;
	}

	public Integer getAreaGroup() {
		return areaGroup;
	}

	public void setAreaGroup(Integer areaGroup) {
		this.areaGroup = areaGroup;
	}
	
}

package com.waynesun.common.biz.dealerarea;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;

public class DealerAreaQC extends BaseQueryCondition{
	/***品牌名称 **/
	private String brand_id;
	
	@Eq
	public String getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}

	
	
}

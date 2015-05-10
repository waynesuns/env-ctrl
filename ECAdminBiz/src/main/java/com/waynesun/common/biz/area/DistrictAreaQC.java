package com.waynesun.common.biz.area;

import com.waynesun.dao.query.condition.annotation.Eq;

/**
 * @ClassName: DistrictAreaQC
 * @Description: DistrictArea查询条件
 *
 */
public class DistrictAreaQC extends AreaQC {
	private static final long serialVersionUID = 1L;

	private String cityArea_provinceArea_name;

	@Eq
	public String getCityArea_provinceArea_name() {
		return cityArea_provinceArea_name;
	}

	public void setCityArea_provinceArea_name(String cityArea_provinceArea_name) {
		this.cityArea_provinceArea_name = cityArea_provinceArea_name;
	}
}
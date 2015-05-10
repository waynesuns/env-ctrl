package com.waynesun.common.biz.veh;

import com.waynesun.pojo.BaseEntity;
import com.waynesun.common.biz.config.SystemConfigCacheUtils;

/**
 * 车型品牌
 * @author cheng.sun
 *
 */
public class VehicleBrand extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/** 车型品牌名称 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getRepairType(){
		return SystemConfigCacheUtils.getCacheSystemConfig("repair_apply_url_"+getId().toString()).getValue();
	}
	public String getAppType(){
		return SystemConfigCacheUtils.getCacheSystemConfig("app_url_"+getId().toString()).getValue();
	}
	
}

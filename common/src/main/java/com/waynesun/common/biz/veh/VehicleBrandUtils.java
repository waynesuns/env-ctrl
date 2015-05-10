package com.waynesun.common.biz.veh;

import java.util.List;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;

/**
 * @ClassName: VehicleBrandUtils
 * @Description: VehicleBrand工具
 *
 */
public class VehicleBrandUtils {
	
	public static List<VehicleBrand> findAllVehicleBrands() {
		return DaoFactory.getInstance().getQueryDao().list(VehicleBrand.class, null, new SimpleQuery(), true).getResults();
	}
}
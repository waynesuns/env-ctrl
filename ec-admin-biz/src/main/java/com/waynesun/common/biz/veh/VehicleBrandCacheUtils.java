package com.waynesun.common.biz.veh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;

public class VehicleBrandCacheUtils {

	public static final String BRAND_CACHE_LIST_KEY = "BRAND_CACHE_LIST_KEY";
	public static void initArea(List<VehicleBrand> list){
		Map<String,VehicleBrand> map = new HashMap<String, VehicleBrand>();
		for (VehicleBrand area : list) {
			map.put(area.getId(), area);
		}
		Cache cache = CacheFactory.getInstance().getCache();
		cache.put(VehicleBrandCacheUtils.BRAND_CACHE_LIST_KEY, map); 
	}
	
	@SuppressWarnings("unchecked")
	public static VehicleBrand getBrandById(String brandId){
		Cache cache = CacheFactory.getInstance().getCache(); 
		return ((Map<String,VehicleBrand>)cache.get(VehicleBrandCacheUtils.BRAND_CACHE_LIST_KEY)).get(brandId);
	}
	
	@SuppressWarnings("unchecked")
	public static List<VehicleBrand> getVehicleBrandAllByCache(){
		Cache cache = CacheFactory.getInstance().getCache(); 
		Map<String,VehicleBrand> map = (Map<String,VehicleBrand>)cache.get(VehicleBrandCacheUtils.BRAND_CACHE_LIST_KEY);
		List<VehicleBrand> list = new ArrayList<VehicleBrand>();
		for(String key : map.keySet()){
			list.add(map.get(key));
		}
		return list;
	}

	
}

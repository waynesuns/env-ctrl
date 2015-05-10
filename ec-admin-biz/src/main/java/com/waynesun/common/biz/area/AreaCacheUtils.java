package com.waynesun.common.biz.area;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;
import com.waynesun.utils.StringUtils;
import com.waynesun.common.biz.cache.CacheConst;

public class AreaCacheUtils {

	
	public static void initArea(List<AbstractArea> list){
		Map<String,AbstractArea> map = new HashMap<String, AbstractArea>();
		Map<String,AbstractArea> cityMap = new HashMap<String, AbstractArea>();
		for (AbstractArea area : list) {
			map.put(area.getCode(), area);
			if(area instanceof CityArea){
				// 以城市名称为key， 服务站主数据导入所用
				cityMap.put(area.getName(), area);
			}
		}
		Cache cache = CacheFactory.getInstance().getCache();
		cache.put(CacheConst.AREA_CACHE_LIST_KEY, map);
		cache.put(CacheConst.AREA_CACHE_NAME_KEY, cityMap);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, AbstractArea> getAllArea()
	{
		Cache cache = CacheFactory.getInstance().getCache();
		return (Map<String, AbstractArea>) cache .get(CacheConst.AREA_CACHE_LIST_KEY);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, AbstractArea> getAllAreaNameKeyMap()
	{
		Cache cache = CacheFactory.getInstance().getCache();
		return (Map<String, AbstractArea>) cache .get(CacheConst.AREA_CACHE_NAME_KEY);
	}
	
	/**
	 * 根据code查找省市区
	 * @param code
	 * @return
	 */
	public static AbstractArea getAreaByCode(String code){
		return getAllArea().get(code);
	}
	
	/**
	 * 根据名称取得省市区
	 * @param name
	 * @return
	 */
	public static AbstractArea getAreaByName(String name){
		Map<String, AbstractArea> map = getAllAreaNameKeyMap();
		return map == null ? null : map.get(name);
	}
	
	public static String getAreaName(String code){
		if (!StringUtils.isEmpty(code)) {
			AbstractArea area = (AbstractArea) getAllArea().get(code);
			if (area != null)
				return area.getName();
		}
		return "";
	}
	
}

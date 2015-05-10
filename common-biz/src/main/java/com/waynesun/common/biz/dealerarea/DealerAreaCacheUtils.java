package com.waynesun.common.biz.dealerarea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;
import com.waynesun.utils.StringUtils;
import com.waynesun.common.biz.dealerarea.rel.DealerAreaRel;

public class DealerAreaCacheUtils
{
	static final String CACHE_KEY_DEALER_AREA = "dealerAreaKey";
	static final String CACHE_KEY_DEALER_AREA_MAP = "dealerAreaKeyMap";

	public static void init(List<AbstractDealerArea> list)
	{
		synchronized (DealerAreaCacheUtils.CACHE_KEY_DEALER_AREA)
		{
			Cache cache = CacheFactory.getInstance().getCache();
			cache.put(CACHE_KEY_DEALER_AREA, list);
			
			Map<String, Map<String, AbstractDealerArea>> map = new HashMap<String, Map<String,AbstractDealerArea>>();
			for(AbstractDealerArea dealerAraea : list)
			{
				DealerAreaCacheUtils.addDealerArea(dealerAraea, map);
			}
			
			cache.put(CACHE_KEY_DEALER_AREA_MAP, map);
		}
	}
	
	private static void addDealerArea(AbstractDealerArea dealerAraea,Map<String, Map<String, AbstractDealerArea>> map)
	{
		Map<String, AbstractDealerArea> innerMap = map.get(dealerAraea.getBrand().getId());
		if(innerMap == null)
			innerMap = new HashMap<String, AbstractDealerArea>();
		map.put(dealerAraea.getBrand().getId(), innerMap);
		Set<DealerAreaRel> set = dealerAraea.getDealerAreaRels();
		for(DealerAreaRel rel : set)
			innerMap.put(rel.getArea().getId(), dealerAraea);
	}
	
	
	public static AbstractDealerArea getDealerAraea(String areaId,String brandId)
	{
		Map<String, Map<String, AbstractDealerArea>> map = DealerAreaCacheUtils.getDealerAraeaMap();
		Map<String, AbstractDealerArea> innerMap = map.get(brandId);
		return innerMap.get(areaId);
	}
	
	public static List<AbstractDealerArea> getDealerAraea(String brandId)
	{
		List<AbstractDealerArea> list = DealerAreaCacheUtils.getDealerAraeas();
		List<AbstractDealerArea> temp = new ArrayList<AbstractDealerArea>();
		for (AbstractDealerArea abstractDealerArea : list) {
			if(abstractDealerArea.getBrand().getId().equals(brandId))
				temp.add(abstractDealerArea);
		}
		return temp;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Map<String, AbstractDealerArea>> getDealerAraeaMap()
	{
		Cache cache = CacheFactory.getInstance().getCache();
		return (Map<String, Map<String, AbstractDealerArea>>) cache.get(CACHE_KEY_DEALER_AREA_MAP);
	}
	
	@SuppressWarnings("unchecked")
	public static List<AbstractDealerArea> getDealerAraeas()
	{
		Cache cache = CacheFactory.getInstance().getCache();
		return (List<AbstractDealerArea>) cache.get(CACHE_KEY_DEALER_AREA);
	}
	
	@SuppressWarnings("unchecked")
	public static AbstractDealerArea getDealerAraeaById(String dealerAreaId)
	{
		Cache cache = CacheFactory.getInstance().getCache();
		List<AbstractDealerArea> list = (List<AbstractDealerArea>)cache.get(CACHE_KEY_DEALER_AREA);
		if(!StringUtils.isEmpty(dealerAreaId)){
			for (AbstractDealerArea abstractDealerArea : list) {
				if(dealerAreaId.equals(abstractDealerArea.getId()))
					return abstractDealerArea;
			}
		}
		return null;
	}
}

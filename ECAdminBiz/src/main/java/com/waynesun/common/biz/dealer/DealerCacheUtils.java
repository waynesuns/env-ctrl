package com.waynesun.common.biz.dealer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;
import com.waynesun.utils.StringUtils;
import com.waynesun.common.biz.cache.CacheConst;
import com.waynesun.common.biz.user.AbstractDealer;
import com.waynesun.common.biz.user.Dealer;
/**
 * 经销商缓存工具类
 * 
 * @author LiuBin
 * 
 *         2012-7-31下午3:42:59
 */
public class DealerCacheUtils
{
	public static void initDealer(List<AbstractDealer> list)
	{
		Map<Integer, Map<Integer, Map<String, AbstractDealer>>> map = new HashMap<Integer, Map<Integer, Map<String, AbstractDealer>>>();
		Map<String, AbstractDealer> mapT = new HashMap<String, AbstractDealer>();
		for (AbstractDealer dealer : list)
		{
			DealerCacheUtils.addDealerCache(map, dealer);
			DealerCacheUtils.addDealerCache(dealer, mapT);// DealerCode - dealer
		}
		Cache cache = CacheFactory.getInstance().getCache();
		cache.put(CacheConst.DEALER_TWO_CACHE_KEY, map);
		cache.put(CacheConst.DEALER_CACHE_LIST_KEY, mapT);
	}

	private static void addDealerCache(Map<Integer, Map<Integer, Map<String, AbstractDealer>>> map, AbstractDealer dealer)
	{
		Map<Integer, Map<String, AbstractDealer>> insideMap = map.get(dealer.getDealerType());
		if (insideMap == null)
		{
			insideMap = new HashMap<Integer, Map<String, AbstractDealer>>();
			map.put(dealer.getDealerType(), insideMap);
		}
		Map<String, AbstractDealer> insideTMap = insideMap.get(dealer.getDealerGroup());
		if (insideTMap == null)
		{
			insideTMap = new HashMap<String, AbstractDealer>();
			insideMap.put(dealer.getDealerGroup(), insideTMap);
		}
		insideTMap.put(dealer.getDealerCode(), dealer);
	}

	private static void addDealerCache(AbstractDealer dealer, Map<String, AbstractDealer> map)
	{
		map.put(dealer.getDealerCode(), dealer);
	}

	@SuppressWarnings("unchecked")
	public static Map<Integer, Map<Integer, Map<String, AbstractDealer>>> getDealer()
	{
		Cache cache = CacheFactory.getInstance().getCache();
		return (Map<Integer, Map<Integer, Map<String, AbstractDealer>>>) cache.get(CacheConst.DEALER_TWO_CACHE_KEY);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, AbstractDealer> getAllDealer()
	{
		Cache cache = CacheFactory.getInstance().getCache();
		return (Map<String, AbstractDealer>) cache.get(CacheConst.DEALER_CACHE_LIST_KEY);
	}

	public static AbstractDealer getDealerCache(int dealerType, int dealerGroup, String dealerCode)
	{
		Map<Integer, Map<Integer, Map<String, AbstractDealer>>> map = DealerCacheUtils.getDealer();
		Map<Integer, Map<String, AbstractDealer>> insideMap = map.get(dealerType);
		if (insideMap == null)
			return null;
		Map<String, AbstractDealer> insideTMap = insideMap.get(dealerGroup);
		if (insideTMap == null)
			return null;
		return insideTMap.get(dealerCode);
	}
	
	public static Map<String,AbstractDealer> getDealerCache(int dealerType, int dealerGroup)
	{
		Map<Integer, Map<Integer, Map<String, AbstractDealer>>> map = DealerCacheUtils.getDealer();
		Map<Integer, Map<String, AbstractDealer>> insideMap = map.get(dealerType);
		if (insideMap == null)
			return null;
		Map<String, AbstractDealer> insideTMap = insideMap.get(dealerGroup);
		if (insideTMap == null)
			return null;
		return insideTMap;
	}

	/**
	 * 根据网点编号，从全部的网点中取出，对应的网点，
	 * @param dealerCode
	 * @return
	 */
	public static AbstractDealer getDealerCache(String dealerCode)
	{
		Map<String, AbstractDealer> map = DealerCacheUtils.getAllDealer();
		return map.get(dealerCode!=null?dealerCode.toUpperCase():dealerCode);
	}
	
	/**
	 * 增加一个网点到缓存
	 * @param dealer
	 */
	public static void addOrUpdateDealerToCache(AbstractDealer dealer){
		synchronized(CacheConst.DEALER_TWO_CACHE_KEY){
			DealerCacheUtils.addDealerCache(DealerCacheUtils.getDealer(), dealer);
			DealerCacheUtils.addDealerCache(dealer, DealerCacheUtils.getAllDealer());
			/*Map<Integer, Map<Integer, Map<String, AbstractDealer>>> map = DealerCacheUtils.getDealer();
			if(map!=null&&map.size()>0){
				DealerCacheUtils.addDealerCache(map, dealer);
				Map<String, AbstractDealer> allMap = getAllDealer();
				DealerCacheUtils.addDealerCache(dealer, allMap);
			}else{
				List<AbstractDealer> list = BizObjReader.list(AbstractDealer.class);
				DealerCacheUtils.initDealer(list);
			}*/
		}
	}
	
	/**
	 * 根据城市编码获取相应的网点
	 * @param cityCode 城市编码
	 * @return
	 */
	public static List<AbstractDealer> getDealerByCity(String cityCode){
		Collection<AbstractDealer> dealers = getAllDealer().values();
		List<AbstractDealer> list = new ArrayList<AbstractDealer>();
		if(dealers!=null&&dealers.size()>0&&!StringUtils.isEmpty(cityCode)){
			for (AbstractDealer dealer : dealers) {
				if(cityCode.equals(dealer.getCity()))
					list.add(dealer);
			}
		}
		return list;
	}
	
	/**
	 * 获取全部网点
	 * @return
	 */
	public static List<AbstractDealer> getAllDealerList(){
		Collection<AbstractDealer> dealers = getAllDealer().values();
		List<AbstractDealer> list = new ArrayList<AbstractDealer>();
		for (AbstractDealer dealer : dealers){
			if(dealer instanceof Dealer)
				list.add(dealer); 
		}
		return list;
	}
	/*
	*//**
	 * 更新dealer缓存
	 * @param dealer
	 *//*
	public static void updateDealerCache(AbstractDealer dealer){
		if(dealer == null)
			return;
		Map<Integer, Map<Integer, Map<String, AbstractDealer>>> map1 = getDealer();
		Map<String,AbstractDealer> map2 = getAllDealer();
		Integer dealerType = dealer.getDealerType();
		Integer dealerGroup = dealer.getDealerGroup();
		String dealerCode = dealer.getDealerCode();
		Map<Integer, Map<String, AbstractDealer>> mapChildrenOne = new HashMap<Integer, Map<String, AbstractDealer>>();
		if(map1.containsKey(dealerType))
			mapChildrenOne = map1.get(dealerType);
		Map<String, AbstractDealer> mapChildrenTwo = new HashMap<String, AbstractDealer>();
		if(mapChildrenOne.containsKey(dealerGroup))
			mapChildrenTwo = mapChildrenOne.get(dealerGroup);
		mapChildrenTwo.put(dealerCode, dealer);
		mapChildrenOne.put(dealerGroup, mapChildrenTwo);
		map1.put(dealerType, mapChildrenOne);
		Cache cache = CacheFactory.getInstance().getCache();
		cache.put(CacheConst.DEALER_TWO_CACHE_KEY, map1);
		map2.put(dealerCode, dealer);
		cache.put(CacheConst.DEALER_CACHE_LIST_KEY, map2);
	}*/
}


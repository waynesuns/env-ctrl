package com.waynesun.common.biz.dictionary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.concurrent.BizConcurrentHashMap;
import com.waynesun.common.biz.cache.CacheConst;

public class DictionaryCacheUtils
{
	public static void initDictionaryCache(List<DictionaryItem> dictionaryItems)
	{
		Cache cache = CacheFactory.getInstance().getCache();
		Map<String, Map<String, DictionaryItem>> map = new BizConcurrentHashMap<String, Map<String, DictionaryItem>>();
		Map<String, DictionaryItem> idMap = new BizConcurrentHashMap<String, DictionaryItem>();

		for (DictionaryItem dictionaryItem : dictionaryItems)
		{
			DictionaryCacheUtils.addDictionary(map, dictionaryItem);
			DictionaryCacheUtils.addDictionaryIdCache(idMap, dictionaryItem);
		}
		cache.put(CacheConst.DICTIONARY_DATA_CACHE_KEY, map);
		cache.put(CacheConst.DICTIONARY_DATA_CACHE_KEY_ID, idMap);
	}

	private static void addDictionary(Map<String, Map<String, DictionaryItem>> map, DictionaryItem dictionaryItem)
	{
		Map<String, DictionaryItem> dictionaryItemMap = map.get(dictionaryItem.getParent().getCode());
		if (dictionaryItemMap == null)
		{
			dictionaryItemMap = new BizConcurrentHashMap<String, DictionaryItem>();
			map.put(dictionaryItem.getParent().getCode(), dictionaryItemMap);
		}
		dictionaryItemMap.put(dictionaryItem.getValue(), dictionaryItem);
	}
	private static void addDictionaryIdCache(Map<String, DictionaryItem> map, DictionaryItem dictionaryItem){
		map.put(dictionaryItem.getId(), dictionaryItem);
	}
	public static void addDictionary(DictionaryItem dictionaryItem)
	{
		DictionaryCacheUtils.addDictionary(DictionaryCacheUtils.getDictionaryCache(), dictionaryItem);
	}

	@SuppressWarnings("unchecked")
	private static Map<String, Map<String, DictionaryItem>> getDictionaryCache()
	{
		return (Map<String, Map<String, DictionaryItem>>) CacheFactory.getInstance().getCache().get(CacheConst.DICTIONARY_DATA_CACHE_KEY);
	}

	/**
	 * 根据数据字典CODE和数据字典项的值查询数据字典项对象
	 * 
	 * @param code
	 * @param value
	 * @return
	 */
	public static DictionaryItem getDictionaryItem(String code, String value)
	{
		Map<String, DictionaryItem> dictionaryItems = DictionaryCacheUtils.getDictionaryCache().get(code);
		DictionaryItem dictionaryItem = null;
		if (dictionaryItems != null)
		{
			dictionaryItem = dictionaryItems.get(value);
		}
		return dictionaryItem;
	}

	/**
	 * 根据数据字典CODE获取其下所有数据字典项
	 * 
	 * @param code
	 * @return
	 */
	public static Collection<DictionaryItem> getDictionaryItems(String code)
	{
		Map<String, DictionaryItem> dictionaryItems = DictionaryCacheUtils.getDictionaryCache().get(code);
		return dictionaryItems.values();
	}

	/**
	 * 根据数据字典CODE获取其下所有数据字典项，若state在pojoStates的则返回
	 * 
	 * @param code
	 * @param pojoStates
	 * @return
	 */
	public static Collection<DictionaryItem> getDictionaryItems(String code, PojoState[] pojoStates)
	{
		Map<String, DictionaryItem> dictionaryItems = DictionaryCacheUtils.getDictionaryCache().get(code);
		Collection<DictionaryItem> colloection = dictionaryItems.values();
		List<DictionaryItem> dictionaryItemList = new ArrayList<DictionaryItem>();
		for (DictionaryItem dictionaryItem : colloection)
		{
			if (ArrayUtils.contains(pojoStates, dictionaryItem.getState()))
			{
				dictionaryItemList.add(dictionaryItem);
			}
		}

		return dictionaryItemList;
	}

	public static DictionaryItem getDictionaryItems(String code, String value)
	{
		Map<String, DictionaryItem> dictionaryItems = DictionaryCacheUtils.getDictionaryCache().get(code);
		DictionaryItem dictionaryItem = null;
		if (dictionaryItems != null)
		{
			dictionaryItem = dictionaryItems.get(value);
		}
		return dictionaryItem;
	}

	public static void updateDictionaryItem(DictionaryItem dictionaryItem)
	{
		Map<String, DictionaryItem> map = DictionaryCacheUtils.getDictionaryCache().get(dictionaryItem.getParent().getCode());
		map.put(dictionaryItem.getValue(), dictionaryItem);
	}
	public static DictionaryItem getDictionaryItemById(String id)
	{
		return DictionaryCacheUtils.getDictionaryIdCache().get(id);
	}
	@SuppressWarnings("unchecked")
	private static  Map<String, DictionaryItem> getDictionaryIdCache()
	{
		return (Map<String, DictionaryItem>) CacheFactory.getInstance().getCache().get(CacheConst.DICTIONARY_DATA_CACHE_KEY_ID);
	}
}

package com.fusioninfo.cache;

import java.util.Map;

import com.fusioninfo.utils.concurrent.BizConcurrentHashMap;

public class MapCache implements Cache
{

	static Map<String, Object> cacheMap = new BizConcurrentHashMap<String, Object>();
	
	@Override
	public Object get(String key)
	{
		return cacheMap.get(key);
	}

	@Override
	public void put(String key, Object value)
	{
		cacheMap.put(key, value);
	}
}

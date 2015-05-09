package com.waynesun.cache;

/**
 * Cache（缓存）创建类
 *
 * @author Liu Bin
 *
 * @version 创建时间：2012-7-3下午3:46:22
 */
public class CacheFactory
{
	private static final CacheFactory cacheFactory = new CacheFactory();
	
	Cache cache;
	
	public static CacheFactory getInstance()
	{
		return cacheFactory;
	}

	public Cache getCache()
	{
		return cache;
	}

	public void setCache(Cache cache)
	{
		this.cache = cache;
	}
}

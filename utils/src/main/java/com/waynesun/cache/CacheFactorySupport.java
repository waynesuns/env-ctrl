package com.waynesun.cache;

/**
 * 将缓存对象的实例注入
 *
 * @author Liu Bin
 *
 * @version 创建时间：2012-7-3下午3:46:45
 */
public class CacheFactorySupport
{
	public void setCache(Cache cache)
	{
		CacheFactory.getInstance().cache = cache;
	}
}

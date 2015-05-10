package com.waynesun.common.biz.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.waynesun.cache.CacheFactory;
import com.waynesun.common.biz.cache.CacheConst;

/**
 * 系统配置缓存管理类
 * 
 * @author Liu Bin
 * 
 * @version 创建时间：2012-7-15下午3:06:57
 */
public class SystemConfigCacheUtils
{
	/**
	 * 加载SystemConfig到缓存
	 * 
	 * @param list
	 */
	public static void initSystemConfig(List<SystemConfig> list)
	{
		Map<String, SystemConfig> map = new HashMap<String, SystemConfig>(100);
		for (SystemConfig config : list)
			SystemConfigCacheUtils.addSystemConfigCache(map, config);
		CacheFactory.getInstance().getCache().put(CacheConst.CONFIG_CACHE_KEY, map);
	}

	/**
	 * 将SystemConfig添加到Map<String, SystemConfig>
	 * 
	 * @param map
	 * @param config
	 */
	private static void addSystemConfigCache(Map<String, SystemConfig> map, SystemConfig config)
	{
		map.put(config.getCode(), config);
	}

	/**
	 * 得到缓存中的集合SystemConfig
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static Map<String, SystemConfig> getSystemConfigCache()
	{
		return (Map<String, SystemConfig>) CacheFactory.getInstance().getCache().get(CacheConst.CONFIG_CACHE_KEY);
	}
	
	/**
	 * 得到缓存中所有的SystemConfig对象
	 * 
	 * @return
	 */
	public static Collection<SystemConfig> getAllSystemConfig()
	{
		Map<String, SystemConfig> map = getSystemConfigCache();
		return map.values();
	}

	/**
	 * 根据SystemConfig的Code得到缓存中的SystemConfig对象
	 * 
	 * @param code
	 * @return
	 */
	public static SystemConfig getCacheSystemConfig(String code)
	{
		Map<String, SystemConfig> map = SystemConfigCacheUtils.getSystemConfigCache();
		if (map == null)
			return null;
		return map.get(code);
	}

	/**
	 * 将一个SystemConfig对象放入缓存中
	 * 
	 * @param config
	 */
	public static void addSystemConfigToCache(SystemConfig config)
	{
		Map<String, SystemConfig> map = SystemConfigCacheUtils.getSystemConfigCache();
		if (map == null)
			map = new HashMap<String, SystemConfig>();
		SystemConfigCacheUtils.addSystemConfigCache(map, config);
		CacheFactory.getInstance().getCache().put(CacheConst.CONFIG_CACHE_KEY, map);
	}
	
	/**
	 * 修改缓存中该SystemConfig对象
	 * 
	 * @param config
	 */
	public static void modifySystemConfigToCache(SystemConfig config)
	{
		Map<String, SystemConfig> map = SystemConfigCacheUtils.getSystemConfigCache();
		SystemConfigCacheUtils.addSystemConfigCache(map, config);
	}
	public static void main(String[] args) {
		int a= 10;
		int b=1;
		StringBuffer s=new StringBuffer();
		s.append(1>5?100:'A');
		s.append(6>5?90:'B');
		System.out.println(s);
		
	}
}

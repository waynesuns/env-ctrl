package com.waynesun.cache;

/**
 * 缓存接口
 * 
 * @author Liu Bin
 * 
 * @version 创建时间：2012-6-25上午11:01:25
 */
public interface Cache
{
	/**
	 * 根据Key取出放入缓存的对象
	 * 
	 * @param key
	 * @return
	 */
	Object get(String key);

	/**
	 * 根据Key放入将Value放入缓存
	 * 
	 * @param key
	 * @param value
	 */
	void put(String key, Object value);
}

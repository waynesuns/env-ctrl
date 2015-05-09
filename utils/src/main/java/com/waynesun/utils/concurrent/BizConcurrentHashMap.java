package com.waynesun.utils.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * get时若key不存在返回NULL的ConcurrentHashMap
 * @author wayne
 *
 * @param <K>
 * @param <V>
 */
public class BizConcurrentHashMap<K,V> extends ConcurrentHashMap<K,V>{
	private static final long serialVersionUID = 2958420848316391485L;

	@Override
	public V get(Object key) {
		try{
			return super.get(key);
		}catch(NullPointerException e){
			return null;
		}
	}
}

package com.waynesun.cache;

import java.io.Serializable;

import net.sf.ehcache.Element;

public class EHCache implements Cache,Serializable
{
	private static final long serialVersionUID = 8125983094943365520L;
	private net.sf.ehcache.Cache cache;

	@Override
	public Object get(String key)
	{
		Element element = cache.get(key);
		if(element == null)
			return null;
		return element.getObjectValue();
	}

	@Override
	public void put(String key, Object value)
	{
		Element element = new Element(key, value);
		cache.put(element);
	}

	public void setCache(net.sf.ehcache.Cache cache)
	{
		this.cache = cache;
	}
}

package com.waynesun.cache;

import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.waynesun.exception.BizException;

/**
 * OSCache 对象
 *
 * @author Liu Bin
 *
 * @version 创建时间：2012-7-23上午11:21:33
 */
public class OSCache extends GeneralCacheAdministrator implements Cache
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1903532554527946730L;

	@Override
	public Object get(String key)
	{
		try
		{
			return super.getFromCache(key);
		}
		catch (NeedsRefreshException e)
		{
			e.printStackTrace();
			throw new BizException(e);
		}
	}

	@Override
	public void put(String key, Object value)
	{
		super.putInCache(key, value);
	}
}

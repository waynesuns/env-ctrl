package com.waynesun.common.biz.role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;

public class RoleCacheUtils
{

	static final String ROLE_CACHE_KEY = "role_cache_key";

	public static void init(List<Role> list)
	{
		Map<String, Role> map = new HashMap<String, Role>();
		for (Role role : list)
		{
			RoleCacheUtils.addRole(role, map);
		}

		Cache cache = CacheFactory.getInstance().getCache();
		cache.put(RoleCacheUtils.ROLE_CACHE_KEY, map);
	}

	private static void addRole(Role role, Map<String, Role> map)
	{
		role.setResources(role.getResources());
		map.put(role.getId(), role);
	}

	@SuppressWarnings("unchecked")
	private static Map<String, Role> getRoleMap()
	{
		Cache cache = CacheFactory.getInstance().getCache();
		return (Map<String, Role>) cache.get(RoleCacheUtils.ROLE_CACHE_KEY);
	}

	public static Map<String, Role> getRoles()
	{
		return RoleCacheUtils.getRoleMap();
	}

	public static void addOrUpdateRole(Role role)
	{
		Map<String, Role> map = RoleCacheUtils.getRoleMap();
		if (map == null)
		{
			map = new HashMap<String, Role>();
		}
		role.setResources(role.getResources());
		map.put(role.getId(), role);
	}
}

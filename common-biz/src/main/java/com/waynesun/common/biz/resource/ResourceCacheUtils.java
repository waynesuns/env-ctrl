package com.waynesun.common.biz.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;
import com.waynesun.pojo.PojoState;

public class ResourceCacheUtils
{

	static final String RESOURCE_CACHE_KEY = "RESOURCE_CACHE_KEY";

	public static void init(List<Resource> list)
	{

		Map<String, Resource> map = new LinkedHashMap<String, Resource>();

		for (Resource r : list)
		{
			addResource(r, map);
		}

		Cache cache = CacheFactory.getInstance().getCache();
		cache.put(RESOURCE_CACHE_KEY, map);
	}

	private static void addResource(Resource r, Map<String, Resource> map)
	{

		map.put(r.getId(), r);

		if (r instanceof Menu)
		{
			Menu menu = (Menu) r;
			MenuCategory parentCategory = (MenuCategory) map.get(menu.getParentId());
			if (parentCategory != null)
				menu.setCategory(parentCategory);
		}
		else if (r instanceof Button)
		{
			Button button = (Button) r;
			Menu parentMenu = (Menu) map.get(button.getParentId());
			button.setMenu(parentMenu);
		}
	}

	@SuppressWarnings("unchecked")
	private static Map<String, Resource> getResourceByCache()
	{
		Cache cache = CacheFactory.getInstance().getCache();
		return (Map<String, Resource>) cache.get(RESOURCE_CACHE_KEY);
	}

	public static Resource getResource(String id)
	{
		Map<String, Resource> map = ResourceCacheUtils.getResourceByCache();
		return map.get(id);
	}

	public static List<Resource> getResources(String[] ids)
	{
		Map<String, Resource> map = ResourceCacheUtils.getResourceByCache();
		List<Resource> list = new ArrayList<Resource>();
		for (String id : ids)
		{
			list.add(map.get(id));
		}
		return list;
	}

	public static List<Resource> getResourcesByNormal()
	{
		Map<String, Resource> map = ResourceCacheUtils.getResourceByCache();
		Collection<Resource> collection = map.values();
		List<Resource> list = new ArrayList<Resource>();
		for (Resource r : collection)
		{
			if (PojoState.NORMAL.equals(r.getState()))
				list.add(r);
		}
		return list;
	}

	public static List<Resource> getResourcesByNotSystem()
	{
		Map<String, Resource> map = ResourceCacheUtils.getResourceByCache();
		Collection<Resource> collection = map.values();
		List<Resource> list = new ArrayList<Resource>();
		for (Resource r : collection)
		{
			if (!PojoState.SYSTEM.equals(r.getState()))
				list.add(r);
		}
		return list;
	}
}

package com.waynesun.common.util.reload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;
import com.waynesun.pojo.PojoState;
import com.waynesun.common.biz.cache.AuthConst;
import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.resource.ResourceQC;
import com.waynesun.common.biz.resource.ResourceUtils;
import com.waynesun.common.biz.role.Role;

public class ResourceReload
{
	public static void reloadResource()
	{
		Map<String, String> urlAuthorities = new HashMap<String, String>();
		ResourceQC qc = new ResourceQC();
		qc.setState_not(PojoState.SYSTEM);
		List<Resource> urlResources = ResourceUtils.findResources(qc);
		for (Resource resource : urlResources)
			urlAuthorities.put(resource.getValue(), resource.getRoleAuthorities());
		qc = new ResourceQC();
		qc.setState(PojoState.SYSTEM);
		List<Resource> list = ResourceUtils.findResources(qc);
		for(Resource resource : list)
			urlAuthorities.put(resource.getValue(), AuthConst.PUBLIC_AUTHORITY_ROLE_ID);
		Cache cache = CacheFactory.getInstance().getCache();
		cache.put(AuthConst.LOAD_URL_AUTHORITY, urlAuthorities);
		cache.put(AuthConst.LOAD_SYS_RESOURCE, list);
	}

	public static void reloadRole()
	{
		Map<String, String> urlAuthorities = new HashMap<String, String>();
		ResourceQC qc = new ResourceQC();
		List<Resource> resources = ResourceUtils.findResources(qc);
		List<Resource> list = new ArrayList<Resource>();

		for(Resource resource : resources){
			if(resource.getState().equals(PojoState.SYSTEM)){
				list.add(resource);
				urlAuthorities.put(resource.getValue(), AuthConst.PUBLIC_AUTHORITY_ROLE_ID);
			}else{
				List<String> roleList = new ArrayList<String>();
				for(Role role : resource.getRoles()){
					roleList.add(role.getId());
				}
				urlAuthorities.put(resource.getValue(), StringUtils.join(roleList.iterator(),","));
			}
		}
		
		Cache cache = CacheFactory.getInstance().getCache();
		cache.put(AuthConst.LOAD_URL_AUTHORITY, urlAuthorities);
		cache.put(AuthConst.LOAD_SYS_RESOURCE, list);
	}
	/*
	public static void reloadRole()
	{
		Map<String, String> urlAuthorities = new HashMap<String, String>();
		ResourceQC qc = new ResourceQC();
		
		Map<String,Role> roleMap = RoleCacheUtils.getRoles();
		
		Map<String,List<String>> resourceMap = new HashMap<String, List<String>>();
		for(Role roleParam : roleMap.values())
		{
			roleParam = BizObjReader.read(Role.class, roleParam.getId());
			Set<Resource> set = roleParam.getResources();
			for(Resource resource : set)
			{
				List<String> roleIds = resourceMap.get(resource.getValue());
				if(roleIds == null){
					roleIds = new ArrayList<String>();
					resourceMap.put(resource.getValue(), roleIds);
				}
				roleIds.add(roleParam.getId());
			}
		}
		
		for(String value : resourceMap.keySet())
		{
			List<String> roleList = resourceMap.get(value);
			urlAuthorities.put(value, StringUtils.join(roleList.iterator(),","));
		}
		
		qc = new ResourceQC();
		qc.setState(PojoState.SYSTEM);
		List<Resource> list = ResourceUtils.findResourceByQC(qc);
		for(Resource resource : list)
			urlAuthorities.put(resource.getValue(), AuthConst.PUBLIC_AUTHORITY_ROLE_ID);
		Cache cache = CacheFactory.getInstance().getCache();
		cache.put(AuthConst.LOAD_URL_AUTHORITY, urlAuthorities);
		cache.put(AuthConst.LOAD_SYS_RESOURCE, list);
	}*/
}

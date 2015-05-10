package com.waynesun.common.biz.security;

import java.util.List;
import java.util.Map;

import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.role.Role;


public interface SecurityManager {
	    
    public Map<String, String> loadUrlAuthorities();
    
    /**
     * 加载系统级菜单
     * 
     * @return
     */
    public List<Resource> loadSysResource();
    
    /**
     * 加载系统角色
     * 
     * @return
     */
    public List<Role> loadSysRole();
}

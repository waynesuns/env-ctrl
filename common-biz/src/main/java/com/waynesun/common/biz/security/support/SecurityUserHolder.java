/**
 * 
 */
package com.waynesun.common.biz.security.support;

import org.springframework.security.core.context.SecurityContextHolder;

import com.waynesun.common.biz.user.LoginAccount;

public class SecurityUserHolder {

	/**
	 * Returns the current user
	 * 
	 * @return
	 */
	public static LoginAccount getCurrentUser() {
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginAccount)
			return (LoginAccount) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		else
			return null;
	}

}

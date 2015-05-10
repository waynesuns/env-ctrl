package com.waynesun.common.biz.user;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService
{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException
	{
		LoginAccountQC qc = new LoginAccountQC();
		qc.setUserName(username);
		LoginAccount account = LoginAccountUtils.findLoginAccount(qc);
		return account;
	}
}

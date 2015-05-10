package com.waynesun.common.biz.security.support;

import java.util.Collection;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

public class AffirmativeBased extends org.springframework.security.access.vote.AffirmativeBased {
	 public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException {
		 super.decide(authentication, object, configAttributes);
//		 SecurityUserHolder.getCurrentUser().transferLocation();
	 }
}

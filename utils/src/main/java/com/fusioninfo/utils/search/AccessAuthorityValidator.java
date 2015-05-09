package com.fusioninfo.utils.search;


public interface AccessAuthorityValidator {
	public boolean isAccessable(String ownerId,String createUserId);
}

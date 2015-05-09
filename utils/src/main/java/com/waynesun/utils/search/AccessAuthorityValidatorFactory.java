package com.waynesun.utils.search;

import java.util.HashMap;
import java.util.Map;

public class AccessAuthorityValidatorFactory {
	private static final Map<String,AccessAuthorityValidator> validators = new HashMap<String, AccessAuthorityValidator>();
	
	public static void addValidator(String ownerType,AccessAuthorityValidator validator){
		if(validators.containsKey(ownerType)){
			throw new RuntimeException("validator is exists");
		}
		validators.put(ownerType, validator);
	}
	
	public static boolean isAccessable(String ownerType, String ownerId,String createUserId) {
		AccessAuthorityValidator validator = AccessAuthorityValidatorFactory.validators.get(ownerType);
		if(validator==null)
			throw new RuntimeException("validator is not exists:"+ownerType);
		return validator.isAccessable(ownerId, createUserId);
	}
}

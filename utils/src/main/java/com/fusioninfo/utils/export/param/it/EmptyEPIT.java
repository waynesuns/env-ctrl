package com.fusioninfo.utils.export.param.it;

import com.fusioninfo.utils.export.param.ExportParamInterType;

/**
 * 不进行国际化
 * @author wayne
 *
 */
public class EmptyEPIT implements ExportParamInterType{
	private static final EmptyEPIT INSTANCE = new EmptyEPIT();
	@Override
	public Object getValue(Object key) {
		return key;
	}
	public static EmptyEPIT getInstance(){
		return EmptyEPIT.INSTANCE;
	}
}

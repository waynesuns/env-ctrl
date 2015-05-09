package com.waynesun.utils.export.param.vt;

import com.waynesun.utils.export.param.ExportParamValueType;

/**
 * 直接返回传入值
 * @author wayne
 *
 */
public class EmptyEPVT implements ExportParamValueType{
	private static final EmptyEPVT INSTANCE = new EmptyEPVT();
	
	private EmptyEPVT(){
	}
	
	public static EmptyEPVT getInstance(){
		return EmptyEPVT.INSTANCE;
	}
	@Override
	public Object getValue(Object object){
		return object;
	}
	

}

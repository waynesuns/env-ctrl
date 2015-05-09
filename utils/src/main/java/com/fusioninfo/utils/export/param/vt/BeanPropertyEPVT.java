package com.fusioninfo.utils.export.param.vt;

import com.fusioninfo.utils.BeanUtil;
import com.fusioninfo.utils.export.param.ExportParamValueType;

/**
 * 通过类的GET方法获取返回值
 * @author wayne
 *
 */
public class BeanPropertyEPVT implements ExportParamValueType{
	private String propertyName;
	public BeanPropertyEPVT(String propertyName){
		this.propertyName = propertyName;
	}
	@Override
	public Object getValue(Object object)throws Exception {
		return BeanUtil.invokGetMethodChain(object, propertyName, ".", new Object[0], null);
	}
	

}

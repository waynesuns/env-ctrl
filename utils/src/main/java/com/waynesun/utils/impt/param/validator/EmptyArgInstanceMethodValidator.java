package com.waynesun.utils.impt.param.validator;

import org.apache.commons.beanutils.MethodUtils;

import com.waynesun.exception.BizException;

public class EmptyArgInstanceMethodValidator implements ImportParamAfterValidator{
	/**方法名*/
	private String methodName;
	public EmptyArgInstanceMethodValidator(String methodName){
		this.methodName = methodName;
	}
	@Override
	public void doValidate(Object entity,Object cellValue, int rowNum) {
		try {
			Object errorCode = MethodUtils.invokeMethod(entity, methodName,new Object[0]);
			if(errorCode!=null && errorCode instanceof String){
				throw new BizException(errorCode.toString(), String.valueOf(rowNum));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}

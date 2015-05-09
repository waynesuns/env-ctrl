package com.waynesun.utils.impt.param.validator;


import com.waynesun.exception.BizException;

/**
 * 值相等验证器
 * @author wayne
 *
 */
public class ValueEqualsValidator implements ImportParamBeforeValidator{
	private String exceptionKey;
	private Object value;
	
	public ValueEqualsValidator(Object value,String exceptionKey){
		this.value = value;
		this.exceptionKey = exceptionKey;
	}
	@Override
	public void doValidate(Object entity,Object cellValue, int rowNum) {
		if(!value.equals(cellValue))
			throw new BizException(exceptionKey,String.valueOf(rowNum));
	}
}

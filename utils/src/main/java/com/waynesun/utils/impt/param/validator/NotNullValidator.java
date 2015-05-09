package com.waynesun.utils.impt.param.validator;


import com.waynesun.exception.BizException;

/**
 * 非空验证其
 * @author wayne
 *
 */
public class NotNullValidator implements ImportParamBeforeValidator,ImportParamValidator{
	private String exceptionKey;
	
	public NotNullValidator(String exceptionKey){
		this.exceptionKey = exceptionKey;
	}
	@Override
	public void doValidate(Object entity,Object cellValue, int rowNum) {
		if(cellValue==null)
			throw new BizException(exceptionKey,String.valueOf(rowNum));
	}
}

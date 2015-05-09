/**   
 * @Title: ValueCEqualsValidator.java 
 * @Package com.dynatecs.common.util.param.impt 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhengnan  
 * @date 2013年9月9日 上午10:38:13
 */
package com.fusioninfo.utils.impt.param.validator;

import com.fusioninfo.exception.BizException;

/** 
 * @ClassName: StringValueEqualsValidator 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zhengnan 
 * @date 2013年9月9日 上午10:38:13 
 *  
 */
public class StringValueEqualsValidator implements ImportParamBeforeValidator {

	private String exceptionKey;
	private String value;

	public StringValueEqualsValidator(String value,String exceptionKey){
		this.value = value;
		this.exceptionKey = exceptionKey;
	}

	@Override
	public void doValidate(Object entity,Object cellValue, int rowNum) {
		if(!(cellValue instanceof String) || !value.equalsIgnoreCase((String) cellValue))
			throw new BizException(exceptionKey,String.valueOf(rowNum));
	}
}
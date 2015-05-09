package com.waynesun.utils.impt.param.validator;


import com.waynesun.exception.BizException;

/**
 * 正则表达式验证器
 * 若导入的内容不为空，将调用对象的toString()方法进行正则表达式验证
 * 若验证不通过，将抛出异常
 * @author wayne
 *
 */
public class RegexpValidator implements ImportParamBeforeValidator {
	/**验证不通过时所抛出的异常信息国际化KEY*/
	private String exceptionKey;
	/**正则表达式*/
	private String regexp;
	public RegexpValidator(String regexp,String exceptionKey){
		this.exceptionKey = exceptionKey;
		this.regexp = regexp;
	}
	@Override
	public void doValidate(Object entity,Object cellValue, int rowNum) {
		//正则表达式进行验证
		if(cellValue!=null && !cellValue.toString().matches(regexp)){
			throw new BizException(exceptionKey, String.valueOf(rowNum));
		}
	}
}

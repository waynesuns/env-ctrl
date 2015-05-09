package com.waynesun.utils.impt.param.validator;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.MethodUtils;

import com.waynesun.exception.BizException;


/**
 * 
 * 实例方法验证器
 * 将会调用导入时被赋值对象的实例方法进行验证
 * @author wayne
 *
 */
public class InstanceMethodValidator implements ImportParamValidator, ImportParamBeforeValidator{
	/**方法名*/
	private String methodName;
	public InstanceMethodValidator(String methodName){
		this.methodName = methodName;
	}
	@Override
	public void doValidate(Object entity,Object cellValue, int rowNum) {
			try {
				Object errorCode=null;
				if(cellValue!=null){
							errorCode = MethodUtils.invokeMethod(entity, methodName,cellValue);
				}else{
					Method[] methods=entity.getClass().getMethods();
					for (Method method : methods) {
						if(method.getName().equals(methodName)){
							errorCode=method.invoke(entity, cellValue);
							break;
						}
					}
				}
				if(errorCode!=null && errorCode instanceof String){
					throw new BizException(errorCode.toString(), String.valueOf(rowNum));
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		
	}

}

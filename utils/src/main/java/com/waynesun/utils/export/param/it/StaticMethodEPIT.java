package com.waynesun.utils.export.param.it;

import org.apache.commons.beanutils.MethodUtils;

import com.waynesun.utils.export.param.ExportParamInterType;

/**
 * 字符串形式的值类型
 * @author wayne
 *
 */
public class StaticMethodEPIT implements ExportParamInterType{
	/**类名*/
	private String className;
	/**方法名*/
	private String methodName;
	
	public StaticMethodEPIT(String className,String methodName){
		this.className = className;
		this.methodName = methodName;
	}
	
	@Override
	public Object getValue(Object value){
		try {
			return MethodUtils.invokeStaticMethod(Class.forName(className),methodName, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}

package com.waynesun.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * bean的工具类
 * @author wayne
 *
 */
public class BeanUtil {

	/**
	 * 返回bean下的指定属性（接收属性链，并以"."作为分割，例如：aaa.bbb,则相当于bean.getAaa().getBbb()）
	 * 
	 * @param bean
	 *            目标BEAN
	 * @param propNameChain
	 *            属性名链
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static Object getProperty(Object bean, String propNameChain) throws NoSuchFieldException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException
	{

		return BeanUtil.getProperty(bean, propNameChain, ".");
	}

	/**
	 * 返回bean下的指定属性（接收属性链，并以delim作为分割，例如：aaa.bbb,则相当于bean.getAaa().getBbb()）
	 * 
	 * @param bean
	 *            目标BEAN
	 * @param propNameChain
	 *            属性名链
	 * @param delim
	 *            分隔符
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static Object getProperty(Object bean, String propNameChain, String delim) throws NoSuchFieldException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException
	{
		if (bean == null)
			return null;
		StringTokenizer st = new StringTokenizer(propNameChain, delim);
		while (st.hasMoreTokens())
		{
			String s = st.nextToken();
			bean = PropertyUtils.getProperty(bean, s);
			if (bean == null)
				return null;
		}
		return bean;
	}
	/**
	 *  通过调用bean的get方法获取对象属性
	 * @param bean
	 * @param propNameChain
	 * @param delim
	 * @param args
	 * @param nullValue
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static Object invokGetMethodChain(Object bean,String propNameChain,String delim,Object[] args,Object nullValue) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Object title = bean;
		StringTokenizer st = new StringTokenizer(propNameChain,delim);
		while(st.hasMoreTokens()){
			String methodName = st.nextToken();
			if(title==null){
				return nullValue;
			}else if(title instanceof Map){
				title = ((Map<?,?>)title).get(methodName);
			}else if(title instanceof List){
				title = ((List<?>)title).get(new Integer(methodName).intValue());
			}else{
				//System.out.println("title:"+title);
				//System.out.println("BeanUtils.getGetterName(String.class,methodName):"+BeanUtils.getGetterName(String.class,methodName));
				//System.out.println("args:"+args);
				title = MethodUtils.invokeMethod(title,BeanUtil.getGetterMethodName(String.class,methodName),args);
				//System.out.println("----------------------------------");
			}
			

		}
		return title==null?nullValue:title;
	}
	public static String getGetterMethodName(Class<?> clazz,String propertyName){
		return "get"+propertyName.replaceFirst(propertyName.substring(0, 1), propertyName.substring(0, 1).toUpperCase()); 
	}
	public static Object getPropertyValue(Object obj,String propertyName){
		try {
			Class<?> orderClass = obj.getClass();
			Field field = orderClass.getDeclaredField(propertyName);
			field.setAccessible(true);
			return field.get(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
}

package com.waynesun.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

import net.sf.cglib.proxy.Enhancer;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * Title: 宝冶二期<br>
 * Description:<br>
 * Copyright: Copyright (c) Steel Bright Intelligence 2006<br>
 * Company: 1703 Studio<br>
 * create date：2006-8-8<br>
 * 操作Class的工具类
 * 
 * @author  
 * @version: 1.0
 */
public class ClassUtils
{
	private static Map<String, Class<?>> classMapping = new ConcurrentHashMap<String, Class<?>>();

	/**
	 * 判断两个类是否相等，如果类是由CGlib代理生成，就根据原始的类判断
	 * 
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static  boolean isEquals(Class<?> c1, Class<?> c2)
	{
		Class<?> a = c1;
		
		if (Enhancer.isEnhanced(c1))
			a = c1.getSuperclass();
		Class<?> b = c2;
		if (Enhancer.isEnhanced(c2))
			b = c2.getSuperclass();

		if (a.equals(b))
			return true;
		return false;
	}

	/**
	 * 得到类名，过滤掉CGlib代理
	 * 
	 * @param clazz Class对象
	 * @return 类名
	 */
	public static String getClassName(Class<?> clazz)
	{
		if (Enhancer.isEnhanced(clazz))
			return clazz.getSuperclass().getName();
		return clazz.getName();
	}

	/**
	 * 得到key的名称,供页面取值设值时使用
	 * 
	 * @param clz Class
	 * @return 类名的第一个字母小写+Id,如Apply类得到的是applyId
	 */
	public static String getKeyName(Class<?> clz)
	{
		String keyName = clz.getSimpleName();
		char[] array = keyName.toCharArray();
		array[0] = Character.toLowerCase(array[0]);
		return new String(array) + "Id";
	}

	/**
	 * 根据类的名字和ID来取得类的实例
	 * 
	 * @param className 类名
	 * @param id ID值
	 * @return BasePojo
	 */
//	public static Pojo getPojo(String className, String id)
//	{
//		List<Pojo> list = DaoFactory.getInstance().getDao().find("from " + className + " t where t.id=?", id);
//		if (list.size() == 0)
//			return null;
//		return (Pojo) list.get(0);
//	}

	/**
	 * 调用Class.forName(String)，并且把异常包装成RuntimeException
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static final Class forName(String name)
	{
		Class c = classMapping.get(name);
		if (c != null)
			return c;
		try
		{
			c = Class.forName(name);
			classMapping.put(name, c);
			return c;
		}
		catch (ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 判断类是否实现了指定的接口
	 * 
	 * @param clazz 需要判断的类
	 * @param interfaceClazz 指定的接口
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean hasInterface(Class clazz, Class interfaceClazz)
	{
		Set set = org.springframework.util.ClassUtils.getAllInterfacesForClassAsSet(clazz);
		return set.contains(interfaceClazz);
	}

	/**
	 * 返回bean下的指定属性（接收属性链，并以delim作为分割，例如：aaa.bbb,则相当于bean.getAaa().getBbb()）
	 * @param bean 目标BEAN
	 * @param propNameChain 属性名链
	 * @param delim 分隔符
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static Object getProperty(Object bean,String propNameChain,String delim) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if(bean == null)
			return null;
		StringTokenizer st = new StringTokenizer(propNameChain,delim);
		while(st.hasMoreTokens()){
			String s = st.nextToken();
			bean = PropertyUtils.getProperty(bean,s);
			if(bean == null)
				return null;
		}
		return bean;
	}
	/**
	 * 返回bean下的指定属性（接收属性链，并以"."作为分割，例如：aaa.bbb,则相当于bean.getAaa().getBbb()）
	 * @param bean 目标BEAN
	 * @param propNameChain 属性名链
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static Object getProperty(Object bean,String propNameChain) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return ClassUtils.getProperty(bean, propNameChain, ".");
	}
}

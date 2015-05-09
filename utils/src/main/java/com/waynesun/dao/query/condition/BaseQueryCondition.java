package com.waynesun.dao.query.condition;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.criterion.Criterion;

import com.waynesun.dao.query.condition.annotation.CollectionCriterion;
import com.waynesun.dao.query.condition.annotation.Exclude;
import com.waynesun.dao.query.condition.annotation.IsNot;
import com.waynesun.dao.query.condition.annotation.PropertyProxy;
import com.waynesun.pojo.PojoState;

/**
 * 查询条件基类
 * 若属性不为空即会进行条件查询
 * @author wayne
 *
 */
public abstract class BaseQueryCondition {
	/**包含的状态列表*/
	private List<PojoState> includeStates;
	/**排除的状态列表*/
	private List<PojoState> excludeStates;
	/**不进行条件查询的属性*/
	private String excludeProperties = ",class,helper,";
	
	/**
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public List<QueryConditionEntry> generateEntries() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		List<QueryConditionEntry> entries = new ArrayList<QueryConditionEntry>();
		//获取所有的属性列表
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(this);
		
		for(PropertyDescriptor propertyDescriptor : propertyDescriptors){
			//循环属性列表
			if(this.getExcludes().indexOf(","+propertyDescriptor.getName()+",")<0&&propertyDescriptor.getReadMethod()!=null&&!propertyDescriptor.getReadMethod().isAnnotationPresent(Exclude.class)){
				//若该属性未定义excludeProperties列表中，且在该类中能找到该属性的get方便，且该方法未被申明Exclude注解则继续
				//获取get方法对应的返回值
				Object propertyValue = propertyDescriptor.getReadMethod().invoke(this, new Object[0]);
				
				if(propertyValue==null||"".equals(propertyValue)){
					//若值为空或空字符串则跳过
					continue;
				}
				entries.add(QueryConditionEntry.newInstance(propertyDescriptor, propertyValue));
				
			}
		}
		return entries;
	}
	
	@Exclude
	public String getExcludes(){
		return excludeProperties;
	}
	
	/**
	 * 生成hibernate离线查询条件
	 */
	@Exclude
	public Criterion getCriterion(String propertyName,Object propertyValue,String conditionName){
		return null;
	}

	@CollectionCriterion(elementRel=CollectionCriterion.OR)
	@PropertyProxy(propertyChain="state")
	public List<PojoState> getIncludeStates() {
		return includeStates;
	}

	public void setIncludeStates(List<PojoState> includeStates) {
		this.includeStates = includeStates;
	}
	public void setIncludeStates(PojoState[] includeStates) {
		this.includeStates = Arrays.asList(includeStates);
	}

	@CollectionCriterion(elementRel=CollectionCriterion.OR)
	@PropertyProxy(propertyChain="state")
	@IsNot
	public List<PojoState> getExcludeStates() {
		return excludeStates;
	}

	public void setExcludeStates(List<PojoState> excludeStates) {
		this.excludeStates = excludeStates;
	}
	public void setExcludeStates(PojoState[] excludeStates) {
		this.excludeStates = Arrays.asList(excludeStates);
	}


	
}

package com.waynesun.dao.query.condition;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.criterion.Criterion;

import com.waynesun.dao.query.condition.annotation.CriterionAnnotationInterpreter;
import com.waynesun.dao.query.condition.annotation.Exclude;
import com.waynesun.dao.query.condition.annotation.JoinType;
import com.waynesun.dao.query.condition.annotation.PropertyProxy;
import com.waynesun.dao.type.DaoType;

/**
 * hibernate查询条件
 * @author wayne
 *
 */
public class CriteriaBean {

	private CriteriaBean parent;
	private String fullCriteriaName;
	private String criteriaName;
	private List<Criterion> criterions = new ArrayList<Criterion>();
	private List<CriteriaBean> subCriteriaBeans = new ArrayList<CriteriaBean>();
	private int joinType = JoinType.INNER_JOIN;
	public static final String PROPERTY_CHAIN_SEPARATOR = "_";
	public static final String PROPERTY_CHAIN_SELF = "_self";
	/**
	 * 生成hibernate查询条件
	 * @param condition 查询条件
	 * @return
	 */
	public static CriteriaBean geneateCondition(BaseQueryCondition condition){
		try {
			CriteriaBean result = new CriteriaBean();
			Map<String,CriteriaBean> temp = new HashMap<String, CriteriaBean>();
			temp.put("_self", result);
			//获取所有的属性列表
			PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(condition);
			
			for(PropertyDescriptor propertyDescriptor : propertyDescriptors){
				//循环属性列表
				
				if(condition.getExcludes().indexOf(","+propertyDescriptor.getName()+",")<0&&propertyDescriptor.getReadMethod()!=null&&!propertyDescriptor.getReadMethod().isAnnotationPresent(Exclude.class)){
					//若该属性未定义excludeProperties列表中，且在该类中能找到该属性的get方便，且该方法未被申明Exclude注解则继续
					//获取get方法对应的返回值
					Object propertyValue = propertyDescriptor.getReadMethod().invoke(condition, new Object[0]);
					
					if(propertyValue==null||"".equals(propertyValue)){
						//若值为空或空字符串则跳过
						continue;
					}
					
					String criteriaName = null;
					String propertyName = null;
					if(propertyDescriptor.getReadMethod().isAnnotationPresent(PropertyProxy.class)){
						//若该方法声明了PropertyProxy注解，则获取注解中定义的属性链作为属性名称
						propertyName = propertyDescriptor.getReadMethod().getAnnotation(PropertyProxy.class).propertyChain();
					}else{
						//若未申明PropertyProxy注解，则直接获取参数名称作为属性名称
						propertyName = propertyDescriptor.getName();
					}
					
					//判断属性名称是否为属性链
					int index = propertyName.lastIndexOf(CriteriaBean.PROPERTY_CHAIN_SEPARATOR);
					if(index>0){
						//若为属性链，则属性链的第一部分作为条件名称（类对象名称）
						criteriaName = propertyName.substring(0, index);
						//剩余部分作为属性名称
						propertyName = propertyName.substring(index+1);
					}else{
						//若非属性链，则赋予默认值赋予条件名称
						criteriaName = CriteriaBean.PROPERTY_CHAIN_SELF;
					}
					//将属性名和条件名作为参数对查询条件进行递归拆解
					List<Criterion> criterions = CriteriaBean.getCriteriaBean(temp, criteriaName,null,propertyDescriptor).getCriterions();
					//调用QC的自定义查询方法进行查询条件的获取
					Criterion criterion = condition.getCriterion(propertyName, propertyValue,propertyDescriptor.getName());
					//System.out.println("----------------------------------"+propertyDescriptor.getName()+":"+propertyValue);
					
					if(criterion==null){
						//若该属性未实现定义查询方法则按照默认解析器进行查询条件的生产
						criterion = CriterionAnnotationInterpreter.generateCriteria(DaoType.HIBERNATE, propertyName, propertyValue, propertyDescriptor.getReadMethod());
					}
					//System.out.println("----------------------------------criterion:"+criterion);
					
					criterions.add(criterion);
					
				}
				
			}
			return result;
		
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
	public static CriteriaBean getCriteriaBean(Map<String,CriteriaBean> temp,String parentCriteriaName,CriteriaBean criteriaBean,PropertyDescriptor propertyDescriptor){
		CriteriaBean paretnCriteriaBean = temp.get(parentCriteriaName);
		if(paretnCriteriaBean==null){
			int index = parentCriteriaName.lastIndexOf("_");
			paretnCriteriaBean = new CriteriaBean();
			paretnCriteriaBean.setCriteriaName(parentCriteriaName.substring(index+1));
			paretnCriteriaBean.setFullCriteriaName(parentCriteriaName.substring(index+1));
			temp.put(parentCriteriaName, paretnCriteriaBean);
			if(index>0){
				CriteriaBean.getCriteriaBean(temp, parentCriteriaName.substring(0, index),criteriaBean,propertyDescriptor).getSubCriteriaBeans().add(paretnCriteriaBean);
			}else{
				temp.get("_self").getSubCriteriaBeans().add(paretnCriteriaBean);
			}	
		}else if(criteriaBean!=null){
			paretnCriteriaBean.setFullCriteriaName(paretnCriteriaBean.getCriteriaName()+"."+paretnCriteriaBean.getCriteriaName());
			criteriaBean.setParent(paretnCriteriaBean);
			paretnCriteriaBean.getSubCriteriaBeans().add(criteriaBean);
		}
		if(propertyDescriptor.getReadMethod().isAnnotationPresent(JoinType.class)){
			paretnCriteriaBean.setJoinType(propertyDescriptor.getReadMethod().getAnnotation(JoinType.class).joinType());
		}
		return paretnCriteriaBean;
	}
	
	
	public String getCriteriaName() {
		return criteriaName;
	}
	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}
	public List<Criterion> getCriterions() {
		return criterions;
	}
	public void setCriterions(List<Criterion> criterions) {
		this.criterions = criterions;
	}
	public List<CriteriaBean> getSubCriteriaBeans() {
		return subCriteriaBeans;
	}
	public void setSubCriteriaBeans(List<CriteriaBean> subCriteriaBeans) {
		this.subCriteriaBeans = subCriteriaBeans;
	}
	public boolean isSubCriteriaBean(){
		return !(criteriaName==null);
	}
	public int getJoinType() {
		return joinType;
	}
	public void setJoinType(int joinType) {
		this.joinType = joinType;
	}
	public String getFullCriteriaName() {
		return fullCriteriaName;
	}
	public void setFullCriteriaName(String fullCriteriaName) {
		this.fullCriteriaName = fullCriteriaName;
	}

	public CriteriaBean getParent() {
		return parent;
	}


	public void setParent(CriteriaBean parent) {
		this.parent = parent;
	}
}

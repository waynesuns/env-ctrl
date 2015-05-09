package com.waynesun.dao.query.condition;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.waynesun.utils.BeanUtil;

public class CriteriaUtils {


	public static Criteria processCriteria(Criteria crit, CriteriaBean criteriaBean,Order... orders)
	{
		List<String> orderNameList = new ArrayList<String>();
		if(orders!=null&&orders.length>0){
			for(Order order : orders){
				Boolean ascending = (Boolean)BeanUtil.getPropertyValue(order, "ascending");
				String propertyName = (String)BeanUtil.getPropertyValue(order, "propertyName");
				int index = propertyName.lastIndexOf(".");
				if(index>0 && !orderNameList.contains(propertyName.substring(0, index))){
					orderNameList.add(propertyName.substring(0, index));
				}
			}
		}
		for (Criterion criterion : criteriaBean.getCriterions())
		{
			crit.add(criterion);
		}
		CriteriaUtils.addCriteria(crit, criteriaBean,orderNameList);
		
		for(String orderName:orderNameList){
			crit.createAlias(orderName, orderName,criteriaBean.getJoinType());
			
		}
		return crit;
	}
	public static void main(String[] args) {
		System.out.println("a.b".replaceAll("\\.", ""));
		
	}

	private static void addCriteria(Criteria crit, CriteriaBean criteriaBean,List<String> orderNameList)
	{
		if (criteriaBean.getSubCriteriaBeans() == null || criteriaBean.getSubCriteriaBeans().isEmpty())
			return;
		for (CriteriaBean subCriteriaBean : criteriaBean.getSubCriteriaBeans())
		{
			orderNameList.remove(subCriteriaBean.getFullCriteriaName());
			Criteria c = crit.createCriteria(subCriteriaBean.getCriteriaName(),subCriteriaBean.getCriteriaName(), criteriaBean.getJoinType());
			for (Criterion criterion : subCriteriaBean.getCriterions())
			{
				c.add(criterion);
			}

			addCriteria(c, subCriteriaBean,orderNameList);
		}

	}
}

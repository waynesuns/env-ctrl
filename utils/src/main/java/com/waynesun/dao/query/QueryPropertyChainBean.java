package com.waynesun.dao.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.common.util.StringUtils;

import com.waynesun.dao.query.condition.annotation.JoinType;

/**
 * @ClassName: QueryPropertyChainBean
 * @Description: 属性链Bean(去重)
 * @author zhengnan
 * @date 2014年4月24日 下午3:12:56
 *
 */
public class QueryPropertyChainBean implements IQueryPropertyBean {
	public static final String PROPERTY_CHAIN_SEPARATOR = "_";

	private static final String SELF = "this";
	private static final String PROPERTY_CHAIN_SEPARATOR_REGEX = "_|\\.";

	/** 父对象的别名 */
	private String parentAlias;
	/** 属性名 */
	private String name;
	/** 关联方式 */
	private int joinType = JoinType.INNER_JOIN;
	/** 子属性 */
	private Map<String, QueryPropertyChainBean> propertys = new HashMap<String, QueryPropertyChainBean>();

	private QueryPropertyChainBean() {}

	/**
	 * @Title: getParentAlias
	 * @Description: 取得父对象别名
	 * @return String
	 * @throws
	 */
	public String getParentAlias() {
		return this.parentAlias;
	}

	/**
	 * @Title: getName
	 * @Description: 取得属性名
	 * @return String
	 * @throws
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @Title: getJoinType
	 * @Description: 取得关联方式
	 * @return int {@link com.waynesun.dao.query.condition.annotation.JoinType}
	 * @throws
	 */
	@Override
	public int getJoinType() {
		return this.joinType;
	}

	/**
	 * @Title: getQueryPropertyBean
	 * @Description: 根据属性链取得Bean
	 * @param propertyNameChain
	 * @return IQueryPropertyBean
	 * @throws
	 */
	public IQueryPropertyBean getQueryPropertyBean(String propertyNameChain) {
		if (StringUtils.isEmpty(propertyNameChain)) {
			return null;
		}
		if (this.getName().equals(propertyNameChain)) {
			return this;
		}
		String[] keys = propertyNameChain.split(PROPERTY_CHAIN_SEPARATOR_REGEX);
		QueryPropertyChainBean propertyChainBean = null;
		if (keys != null && keys.length > 0) {
			propertyChainBean = this;
			for (String key : keys) {
				propertyChainBean = propertyChainBean.getSubPropertyChainBean(key);
				if (propertyChainBean == null) {
					break;
				}
			}
		}
		return propertyChainBean;
	}

	/**
	 * @Title: newInstance
	 * @Description: 实例化Bean
	 * @return QueryPropertyChainBean
	 * @throws
	 */
	public static QueryPropertyChainBean newInstance() {
		return QueryPropertyChainBean.newInstance(null);
	}

	/**
	 * @Title: newInstance
	 * @Description: 实例化Bean
	 * @param propertyNameChains
	 * @return PropertyChainBean
	 * @throws
	 */
	public static QueryPropertyChainBean newInstance(List<String> propertyNameChains) {
		QueryPropertyChainBean bean = new QueryPropertyChainBean();
		bean.setName(SELF);

		if (propertyNameChains != null) {			
			for (String propertyNameChain : propertyNameChains) {
				bean.addPropertyChainName(propertyNameChain);
			}
		}

		return bean;
	}

	/**
	 * @Title: getFullPropertyName
	 * @Description: 取得全属性名(带父对象别名)
	 * @return String
	 * @throws
	 */
	@Override
	public String getFullPropertyName() {
		if (StringUtils.isEmpty(this.getParentAlias())) {
			return this.getName();
		} else {
			return new StringBuilder(this.getParentAlias()).append(".").append(this.getName()).toString();
		}
	}

	/**
	 * @Title: getAlias
	 * @Description: 取得别名
	 * @return String
	 * @throws
	 */
	@Override
	public String getAlias() {
		if (StringUtils.isEmpty(this.getParentAlias()) || SELF.equals(this.getParentAlias())) {
			return this.getName();
		} else {
			return new StringBuilder(this.getParentAlias()).append("_").append(this.getName()).toString();
		}
	}

	/**
	 * @Title: getAllNeedRegisterQueryPropertyBeans
	 * @Description: 取得所有需要注册的查询属性
	 * @return List<IQueryPropertyBean>
	 * @throws
	 */
	public List<IQueryPropertyBean> getAllNeedRegisterQueryPropertyBeans() {
		List<IQueryPropertyBean> aliasBeans = new ArrayList<IQueryPropertyBean>();
		if (this.getParentAlias() != null && !this.propertys.isEmpty()) {
			aliasBeans.add(this);
		}
		for (QueryPropertyChainBean bean : this.propertys.values()) {
			aliasBeans.addAll(bean.getAllNeedRegisterQueryPropertyBeans());
		}

		return aliasBeans;
	}

	/**
	 * @Title: addPropertyChainName
	 * @Description: 加入一个属性链
	 * @param propertyNameChain
	 * @param joinType {@link com.waynesun.dao.query.condition.annotation.JoinType}
	 * @return void
	 * @throws
	 */
	public void addPropertyChainName(String propertyNameChain, int joinType) {
		if (StringUtils.isEmpty(propertyNameChain)) {
			return;
		}
		if (propertyNameChain.contains(".")) {
			propertyNameChain = propertyNameChain.replace(".", PROPERTY_CHAIN_SEPARATOR);
		}

		int index = propertyNameChain.indexOf(PROPERTY_CHAIN_SEPARATOR);
		String propertyName = null;
		String subPropertyNameChain = null;
		if (index > 0) {
			propertyName = propertyNameChain.substring(0, index);
			subPropertyNameChain =  propertyNameChain.substring(index + 1);
		} else {
			propertyName = propertyNameChain;
		}

		QueryPropertyChainBean subPropertyChainBean = propertys.get(propertyName);
		if (subPropertyChainBean == null) {
			subPropertyChainBean = QueryPropertyChainBean.newInstance(this.getAlias(), propertyName, joinType, subPropertyNameChain);
			propertys.put(propertyName, subPropertyChainBean);
		}
		subPropertyChainBean.addPropertyChainName(subPropertyNameChain);
	}

	/**
	 * @Title: addPropertyChainName
	 * @Description: 加入一个属性链
	 * @param propertyNameChain
	 * @return void
	 * @throws
	 */
	public void addPropertyChainName(String propertyNameChain) {
		this.addPropertyChainName(propertyNameChain, JoinType.INNER_JOIN);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendSpaceStr(sb);
		sb.append("{parentAlias=").append(this.getParentAlias());
		sb.append(",");
		sb.append("name=").append(this.getName());
		sb.append(",");
		sb.append("alias=").append(this.getAlias()).append("}");
		if (!this.propertys.isEmpty()) {
			sb.append(System.getProperty("line.separator"));
			appendSpaceStr(sb);
			sb.append("[").append(System.getProperty("line.separator"));
			for (QueryPropertyChainBean bean : this.propertys.values()) {
				sb.append(bean.toString()).append(System.getProperty("line.separator"));
			}
			appendSpaceStr(sb);
			sb.append("]");
		}

		return sb.toString();
	}

	private QueryPropertyChainBean getSubPropertyChainBean(String name) {
		return this.propertys.get(name);
	}

	private void setParentAlias(String parentAlias) {
		this.parentAlias = parentAlias;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setJoinType(int joinType) {
		this.joinType = joinType;
	}

	private static QueryPropertyChainBean newInstance(String parentAlias, String propertyName, int joinType, String propertyNameChain) {
		QueryPropertyChainBean bean = new QueryPropertyChainBean();
		bean.setParentAlias(parentAlias);
		bean.setName(propertyName);
		bean.setJoinType(joinType);
		bean.addPropertyChainName(propertyNameChain);

		return bean;
	}

	//辅助输出
	private void appendSpaceStr(StringBuilder sb) {
		if (this.getParentAlias() == null) {
			return;
		}
		int index = -1;
		sb.append("  ");
		while ((index = this.getParentAlias().indexOf(PROPERTY_CHAIN_SEPARATOR, index + 1)) > 0) {
			sb.append("  ");
		}
	}

	public static void main(String[] args) {
		String str1 = "a_b_c_d";
		String str2 = "a.b.h.i";
		String str3 = "j.e.f.g";
		QueryPropertyChainBean bean1 = QueryPropertyChainBean.newInstance(Arrays.asList(new String[]{str1, str2 , str3}));
		System.out.println(bean1);
		System.out.println("----------");
		IQueryPropertyBean bean2 = bean1.getQueryPropertyBean("a.b.c");
		System.out.println(bean2);
		System.out.println("----------");
		IQueryPropertyBean bean3 = bean1.getQueryPropertyBean("b");
		System.out.println(bean3);
	}
}
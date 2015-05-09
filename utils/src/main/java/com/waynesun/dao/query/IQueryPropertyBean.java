package com.waynesun.dao.query;

/**
 * @ClassName: IQueryPropertyBean
 * @Description: 属性Bean
 * @author zhengnan
 * @date 2014年4月25日 下午1:05:44
 *
 */
public interface IQueryPropertyBean {

	/**
	 * @Title: getFullPropertyName
	 * @Description: 取得全属性名(带父对象别名)
	 * @return String
	 * @throws
	 */
	String getFullPropertyName();

	/**
	 * @Title: getAlias
	 * @Description: 取得别名
	 * @return String
	 * @throws
	 */
	String getAlias();

	/**
	 * @Title: getJoinType
	 * @Description: 取得关联方式
	 * @return int {@link com.waynesun.dao.query.condition.annotation.JoinType}
	 * @throws
	 */
	int getJoinType();
}
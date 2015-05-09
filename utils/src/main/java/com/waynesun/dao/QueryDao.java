package com.waynesun.dao;

import com.waynesun.dao.query.SelectItemQuery;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.pages.QueryPages;
import com.waynesun.dao.query.result.QueryResult;
import com.waynesun.pojo.BasePojo;

public interface QueryDao {

	/**
	 * 读取一个指定的类的实例
	 * @param clazz 需要读取的类
	 * @param id 主键值
	 * @param cacheable 是否使用二级缓存
	 * @return 读取出的对象
	 */
	public <T> T get(Class<? extends BasePojo> clazz, String id, boolean cacheable);

	/**
	 * 读取唯一的符合查询条件的查询结果
	 * @param clazz 需要读取的类
	 * @param query 查询条件
	 * @param cacheable 是否使用二级缓存
	 * @return 查询到的对象，若不存在返回null，若存在多个抛出异常
	 */
	public <T> T uniqueResult(final Class<? extends BasePojo> clazz, final SimpleQuery query, boolean cacheable);

	/**
	 * 查询符合查询条件的对象列表
	 * @param clazz 需要读取的类
	 * @param returnClazz 需要返回的类
	 * @param pages 分页查询条件（为空则返回全部结果，查询后会回填符合条件的查询总数及页码总数等信息）
	 * @param query 查询条件
	 * @param cacheable 是否使用二级缓存
	 * @return 符合查询条件的结果
	 */
	public <T> QueryResult<T> list(Class<? extends BasePojo> clazz, Class<T> returnClazz, final SelectItemQuery<?> query, boolean cacheable);

	/**
	 * 查询符合查询条件的对象列表
	 * @param clazz 需要读取的类
	 * @param pages 分页查询条件（为空则返回全部结果，查询后会回填符合条件的查询总数及页码总数等信息）
	 * @param query 查询条件
	 * @param cacheable 是否使用二级缓存
	 * @return 符合查询条件的结果
	 */
	public <T extends BasePojo, Q extends T> QueryResult<T> list(Class<Q> clazz, QueryPages pages, final SimpleQuery query, boolean cacheable);
}
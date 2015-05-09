package com.waynesun.dao;

import com.waynesun.pojo.BasePojo;

public interface MaintainDao {
	/**
	 * 保存一个对象
	 * 
	 * @param pojo
	 *            要保存的对象
	 */
	public void save(BasePojo pojo);

	/**
	 * 删除一个对象
	 * 
	 * @param pojo
	 */
	public void remove(BasePojo pojo);

	/**
	 * 批量更新/删除操作
	 * 
	 * @param hql
	 * @param values
	 *            参数列表
	 * @return 更新/删除的数目
	 */
	public int bulkUpdate(String hql, Object... values);
	
//	public <T> T merge(T pojo);
//	/**
//	 * 从当前的缓存中清除所有的对象
//	 */
//	public void clear();
//	/**
//	 * 从当前的缓存中清除指定的对象
//	 */
//	public void evict(BasePojo pojo);
//	/**
//	 * 重新读取一个对象
//	 * 
//	 * @param obj
//	 */
//	public void refresh(BasePojo obj);
//	/**
//	 * 更新session的信息
//	 */
//	public void flush();
}

package com.waynesun.dao.query;

import java.util.List;


/**
 * 分组查询
 * @author weisun
 *
 */
public class GroupQuery extends FunctionQuery {
	private static final long serialVersionUID = 6209413542457903324L;

	/**分组条件*/
	private List<IColumn> groups;

	@Override
	public List<IColumn> getGroups() {
		// TODO Auto-generated method stub
		return this.groups;
	}

	public void setGroups(List<IColumn> groups) {
		this.groups = groups;
	}
}
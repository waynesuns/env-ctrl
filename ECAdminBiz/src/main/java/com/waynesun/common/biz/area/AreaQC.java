package com.waynesun.common.biz.area;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;
import com.waynesun.dao.query.condition.annotation.IsNull;

/**
 * @ClassName: AreaQC
 * @Description: Area查询条件
 *
 */
public class AreaQC extends BaseQueryCondition {
	private static final long serialVersionUID = 1L;

	private String parent_id;
	private String code;
	private String name;

	@IsNull
	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	@Eq
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Eq
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
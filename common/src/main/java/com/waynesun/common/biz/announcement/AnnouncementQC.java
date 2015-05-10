package com.waynesun.common.biz.announcement;

import java.util.Date;
import java.util.List;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.CollectionCriterion;
import com.waynesun.dao.query.condition.annotation.Eq;
import com.waynesun.dao.query.condition.annotation.Ge;
import com.waynesun.dao.query.condition.annotation.IdEq;
import com.waynesun.dao.query.condition.annotation.Le;
import com.waynesun.dao.query.condition.annotation.PropertyProxy;
import com.waynesun.pojo.PojoState;

public class AnnouncementQC extends BaseQueryCondition{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2093030109999508680L;

	private boolean released;
	
	private PojoState state;

	private String authConfs_dealer_id;
	
	private Date createTime_start;
	
	private Date createTime_end;
	private List<String> ids;
	
	@PropertyProxy(propertyChain="id")
	@CollectionCriterion(elementRel=CollectionCriterion.OR)
	@IdEq
	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
	@PropertyProxy(propertyChain="createTime")
	@Ge
	public Date getCreateTime_start() {
		return createTime_start;
	}

	public void setCreateTime_start(Date createTime_start) {
		this.createTime_start = createTime_start;
	}
	@PropertyProxy(propertyChain="createTime")
	@Le
	public Date getCreateTime_end() {
		return createTime_end;
	}

	public void setCreateTime_end(Date createTime_end) {
		this.createTime_end = createTime_end;
	}

	@Eq
	public String getAuthConfs_dealer_id() {
		return authConfs_dealer_id;
	}

	public void setAuthConfs_dealer_id(String authConfs_dealer_id) {
		this.authConfs_dealer_id = authConfs_dealer_id;
	}

	@Eq
	public boolean isReleased() {
		return released;
	}

	public void setReleased(boolean released) {
		this.released = released;
	}

	@Eq
	public PojoState getState() {
		return state;
	}

	public void setState(PojoState state) {
		this.state = state;
	}
	
	
}

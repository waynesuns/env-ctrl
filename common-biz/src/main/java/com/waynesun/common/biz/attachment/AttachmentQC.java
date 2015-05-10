package com.waynesun.common.biz.attachment;

import java.util.List;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.CollectionCriterion;
import com.waynesun.dao.query.condition.annotation.IdEq;
import com.waynesun.dao.query.condition.annotation.PropertyProxy;

public class AttachmentQC extends BaseQueryCondition
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3896036808987990455L;
	private String announcement_id;
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

	@IdEq
	public String getAnnouncement_id()
	{
		return announcement_id;
	}

	public void setAnnouncement_id(String announcement_id)
	{
		this.announcement_id = announcement_id;
	}
}

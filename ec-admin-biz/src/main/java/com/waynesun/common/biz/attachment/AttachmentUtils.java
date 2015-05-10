package com.waynesun.common.biz.attachment;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;

public class AttachmentUtils 
{
	public static Attachment getAttachmentByAnnouncementId(String announcement_id)
	{
		AttachmentQC qc = new AttachmentQC();
		qc.setAnnouncement_id(announcement_id);
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		Attachment attachment = DaoFactory.getInstance().getQueryDao().uniqueResult(Attachment.class, sq,true);;
		return attachment;
	}
}

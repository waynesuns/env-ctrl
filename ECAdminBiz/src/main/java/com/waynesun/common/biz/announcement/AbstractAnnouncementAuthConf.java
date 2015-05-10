package com.waynesun.common.biz.announcement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.waynesun.dao.query.result.QueryResult;
import com.waynesun.pojo.BizObject;
import com.waynesun.pojo.Pages;
import com.waynesun.pojo.PojoState;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.util.json.StateEnumSerializer;

/**
 * 
 * 公告访问授权
 * @author wayne
 *
 */
public abstract class AbstractAnnouncementAuthConf  extends BizObject {
	/**
	 * 
	 */
	/** 状态 */
	private PojoState state = PojoState.NORMAL;

	@JsonSerialize(using = StateEnumSerializer.class)
	public PojoState getState()
	{
		return state;
	}

	public void setState(PojoState state)
	{
		this.state = state;
	}
	private static final long serialVersionUID = 1L; 

	/**
	 * 返回允许指定用户访问的公告列表
	 * @param user
	 * @return
	 */
	public static QueryResult<DealerAnnouncementAuthConf> getAllowVisitAnnouncement(AbstractUser user, Pages pages){
		return AnnouncementAuthConfUtils.getAnnouncementByDealer(user.getDealer().getId(),pages);
	}
}
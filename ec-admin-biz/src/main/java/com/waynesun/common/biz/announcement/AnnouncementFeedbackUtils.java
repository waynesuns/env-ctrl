package com.waynesun.common.biz.announcement;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.utils.SpringContextUtil;
import com.waynesun.utils.UserUtils;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.biz.user.UserQC;

public class AnnouncementFeedbackUtils {

	private static Log sapOrderLog = LogFactory.getLog("jobInfo");

	private static AnnouncementFeedbackService announcementFeedbackService = (AnnouncementFeedbackService) SpringContextUtil.getBean("announcementFeedbackService");
	
	public static List<AnnouncementFeedback> getFeedBackByQc(AnnouncementFeedbackQC qc) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().list(AnnouncementFeedback.class, null, sq, true).getResults();
	}
	
	/**
	 * 拿出未读的
	 * @return
	 */
	public static List<DealerAnnouncementAuthConf> getUnReadDealerAnnouncementAuthConf(){
		DealerAnnouncementAuthConfQC qc = new DealerAnnouncementAuthConfQC();
		qc.setStatus(0);
		qc.setAnnouncement_released(true);
		return DealerAnnouncementAuthConfUtils.getDealerAnnouncementAuthConfByQc(qc);
	}

	public static void addAnnouncementFeedback(List<DealerAnnouncementAuthConf> DealerAnnouncementAuthConfList) throws Exception{
		if(DealerAnnouncementAuthConfList != null && DealerAnnouncementAuthConfList.size()>0){
		
			UserQC userqc = new UserQC();
			userqc.setAccount_userName("administrator");
			SimpleQuery sq = new SimpleQuery();
			QueryConditionAssenble qca = new QueryConditionAssenble();
			qca.setCondition(userqc);
			sq.setQueryCondtion(qca);
			UserUtils.setUser((AbstractUser)DaoFactory.getInstance().getQueryDao().uniqueResult(AbstractUser.class, sq, true));
			
			for(DealerAnnouncementAuthConf dealerAnnouncementAuthConf : DealerAnnouncementAuthConfList){
				try {
					announcementFeedbackService.executeAddAnnouncementFeedback(dealerAnnouncementAuthConf);
				} catch (Exception e) {
					sapOrderLog.info("announcementFeedbackJob error:" + e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

	public static void doSubtractAnnouncementFeedback(String announceId){
		AbstractUser user = (AbstractUser) UserUtils.getUser();
		AnnouncementFeedback feedBack = AnnouncementFeedbackCacheUtils.getAnnouncementFeedbackByMap(user.getId(), announceId);
		if(feedBack != null){
			/*Map<String, Map<String, AnnouncementFeedback>> feedBackMap = AnnouncementFeedbackCacheUtils.getAnnouncementFeedbackUserAnnounceMap();
			int unReadAmt = AnnouncementFeedbackCacheUtils.getUserPendingUnReadAmt(feedBackMap,user.getId());
			user.setPenddingReadAnnonAmt(unReadAmt - 1);
			user.update();*/
			feedBack.setStatus(AnnouncementReadStatus.READ);
			feedBack.update();
			AnnouncementFeedbackCacheUtils.deleteAnnouncementFeedbackByAnnouncementId(user.getId(), announceId);
		}
	}

	public static List<AnnouncementFeedback> getAnnouncementFeedbackAll() {
		return DaoFactory.getInstance().getQueryDao().list(AnnouncementFeedback.class, null, new SimpleQuery(),true).getResults();
	}

	public static  List<AnnouncementFeedback> getAnnouncementFeedbackByQc(String userId, String announcementId){
		AnnouncementFeedbackQC qc = new AnnouncementFeedbackQC();
		qc.setStatus(AnnouncementReadStatus.UNREAD);
		qc.setUser_id(userId);
		qc.setAnnouncement_id(announcementId);
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return  DaoFactory.getInstance().getQueryDao().list(AnnouncementFeedback.class, null, sq,true).getResults();
	}

	public static void doSubtractAnnouncement(String announceId){
		AnnouncementFeedbackQC qc = new AnnouncementFeedbackQC();
		qc.setAnnouncement_id(announceId);
		List<AnnouncementFeedback> feedbackList =AnnouncementFeedbackUtils.getFeedBackByQc(qc);
		if(feedbackList != null && feedbackList.size()>0){
			for(AnnouncementFeedback feedBack:feedbackList){
				feedBack.setStatus(AnnouncementReadStatus.READ);
				feedBack.update();
				/*AbstractUser user = feedBack.getUser();
				AnnouncementFeedbackCacheUtils.deleteAnnouncementFeedbackByAnnouncementId(user.getId(), announceId);
				Map<String, Map<String, AnnouncementFeedback>> feedBackMap = AnnouncementFeedbackCacheUtils.getAnnouncementFeedbackUserAnnounceMap();
				int unReadAmt = AnnouncementFeedbackCacheUtils.getUserPendingUnReadAmt(feedBackMap,user.getId());
				try{
					user.setPenddingReadAnnonAmt(unReadAmt);
					user.update();
				}catch(Exception e){
					e.printStackTrace();
					DaoUtils.getDao().refresh(user);
					user.setPenddingReadAnnonAmt(unReadAmt);
					user.update();
				}*/
			}
			for(AnnouncementFeedback feedBack:feedbackList){
				AbstractUser user = feedBack.getUser();
				AnnouncementFeedbackCacheUtils.deleteAnnouncementFeedbackByAnnouncementId(user.getId(), announceId);
			}
		}
	}
}

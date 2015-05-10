package com.waynesun.common.biz.announcement;

import java.util.ArrayList;
import java.util.List;

import com.waynesun.pojo.PojoState;
import com.waynesun.common.biz.user.AbstractDealer;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.biz.user.UserQC;

/** 
 * @ClassName: AnnouncementFeedbackService 
 * @Description: 公告确认
 * @author zhengnan 
 * @date 2013年10月22日 下午3:26:26 
 *  
 */
public class AnnouncementFeedbackService {

	public void executeAddAnnouncementFeedback(DealerAnnouncementAuthConf dealerAnnouncementAuthConf) {
		AbstractDealer dealer = dealerAnnouncementAuthConf.getDealer();
		Announcement announcement = dealerAnnouncementAuthConf.getAnnouncement();
		UserQC qc = new UserQC();
		qc.setDealer_id(dealer.getId());
		List<AbstractUser> userList = com.waynesun.common.biz.user.UserUtils.findUsers(qc);
		List<AnnouncementFeedback> feedBackList = new ArrayList<AnnouncementFeedback>();
		for (AbstractUser user : userList) {
			if (user.getState().getState() == PojoState.NORMAL.getState()) {
				AnnouncementFeedback feedBack = AnnouncementFeedbackCacheUtils.getAnnouncementFeedbackByMap(user.getId(), announcement.getId());
				boolean flag = false;
				if (feedBack == null) {
					/*List<AnnouncementFeedback> backList = AnnouncementFeedbackUtils.getAnnouncementFeedbackByQc(user.getId(),announcement.getId());
					if (backList != null && backList.size() > 0) {
						for (AnnouncementFeedback back : backList) {
							flag = true;
							feedBackList.add(back);
							break;
						}
					}*/
				} else {
					flag = true;
				}
				if (!flag) {
					feedBack = new AnnouncementFeedback();
					feedBack.setAnnouncement(announcement);
					feedBack.setUser(user);
					feedBack.setStatus(AnnouncementReadStatus.UNREAD);
					feedBack.update();
					feedBackList.add(feedBack);
				}
			}
		}
		dealerAnnouncementAuthConf.setStatus(1);
		dealerAnnouncementAuthConf.update();

		AnnouncementFeedbackCacheUtils.initAnnouncementFeedbackCache(feedBackList);
	}
}
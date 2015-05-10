package com.waynesun.common.biz.announcement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;
import com.waynesun.dao.DaoFactory;
import com.waynesun.common.biz.cache.CacheConst;

public class AnnouncementFeedbackCacheUtils {
	public static void initAnnouncementFeedbackCache(
			List<AnnouncementFeedback> list) {
		Map<String, AnnouncementFeedback> map = getAnnouncementFeedbackMap();
		Map<String, Map<String, AnnouncementFeedback>> userAnnouncemap = getAnnouncementFeedbackUserAnnounceMap();
		for (AnnouncementFeedback announcementFeedback : list) {
			if(map == null){
				map = new HashMap<String, AnnouncementFeedback>();
			}
			map.put(announcementFeedback.getId(), announcementFeedback);
			if(userAnnouncemap == null){
				userAnnouncemap = new HashMap<String, Map<String, AnnouncementFeedback>>();
			}
			Map<String, AnnouncementFeedback> userFeedback = userAnnouncemap
					.get(announcementFeedback.getUser().getId());
			if (userFeedback == null) {
				userFeedback = new HashMap<String, AnnouncementFeedback>();
			}
			userFeedback.put(announcementFeedback.getAnnouncement().getId(),
					announcementFeedback);
			userAnnouncemap.put(announcementFeedback.getUser().getId(),
					userFeedback);
		}
		Cache cache = CacheFactory.getInstance().getCache();
		cache.put(CacheConst.ANNOUNCE_NOTIFICATION_KEY, map);
		cache.put(CacheConst.ANNOUNCE_USER_NOTIFICATION_KEY, userAnnouncemap);
		String hql =" update AbstractUser u set u.penddingReadAnnonAmt = (select count(*) from AnnouncementFeedback b where u.id=b.user and b.status=0) ";
		DaoFactory.getInstance().getMaintainDao().bulkUpdate(hql);
	}
	
	public static Integer getUserPendingUnReadAmt(Map<String, Map<String, AnnouncementFeedback>> feedBackMap,String userId){
		int unReadAmt = 0;
		if(feedBackMap != null){
			Map<String, AnnouncementFeedback> userMap = feedBackMap.get(userId);
			if(userMap != null){
				unReadAmt = userMap.size();
			}
		}
		return unReadAmt;
	}

	public static AnnouncementFeedback getAnnouncementFeedbackByID(
			String feedBackId) {
		Map<String, AnnouncementFeedback> feedBackMap = getAnnouncementFeedbackMap();
		if (feedBackMap == null) {
			return null;
		} else {
			return feedBackMap.get(feedBackId);
		}
	}

	public static AnnouncementFeedback getAnnouncementFeedbackByMap(
			String userId, String announceId) {
		Map<String, AnnouncementFeedback> announceMap = getAnnouncementFeedbackByUserId(userId);
		if (announceMap == null) {
			return null;
		} else {
			return announceMap.get(announceId);
		}
	}

	public static Map<String, AnnouncementFeedback> getAnnouncementFeedbackByUserId(
			String userId) {
		Map<String, Map<String, AnnouncementFeedback>> feedBackMap = getAnnouncementFeedbackUserAnnounceMap();
		if (feedBackMap == null) {
			return null;
		} else {
			Map<String, AnnouncementFeedback> announceMap = feedBackMap
					.get(userId);
			return announceMap;
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<String, AnnouncementFeedback> getAnnouncementFeedbackMap() {
		Cache cache = CacheFactory.getInstance().getCache();
		return (Map<String, AnnouncementFeedback>) cache
				.get(CacheConst.ANNOUNCE_NOTIFICATION_KEY);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Map<String, AnnouncementFeedback>> getAnnouncementFeedbackUserAnnounceMap() {
		Cache cache = CacheFactory.getInstance().getCache();
		return (Map<String, Map<String, AnnouncementFeedback>>) cache
				.get(CacheConst.ANNOUNCE_USER_NOTIFICATION_KEY);
	}

	@SuppressWarnings("rawtypes")
	public static void deleteAnnouncementFeedbackByAnnouncementId(
			String userId, String announcementId) {
		Map<String, Map<String, AnnouncementFeedback>> feedBackMap = getAnnouncementFeedbackUserAnnounceMap();
		Map<String, AnnouncementFeedback> announcementMap = getAnnouncementFeedbackMap();
		if (feedBackMap != null) {
			Map<String, AnnouncementFeedback> announceMap = feedBackMap
					.get(userId);
			if (announceMap != null) {
				AnnouncementFeedback feedback = announceMap.get(announcementId);
				Iterator iterator = announceMap.keySet().iterator();
				while (iterator.hasNext()) {
					String key = (String) iterator.next();
					if (announcementId.equals(key)) {
						iterator.remove();
						announceMap.remove(key);
					}
				}
				announceMap.remove(announcementId);
				feedBackMap.put(userId, announceMap);
				if(feedback != null){
					if(announcementMap != null){
						Iterator mapIte = announcementMap.keySet().iterator();
						while (mapIte.hasNext()) {
							String key = (String) mapIte.next();
							if (feedback.getId().equals(key)) {
								mapIte.remove();
								announcementMap.remove(key);
							}
						}
					}
				}
			}
		}
	}
}

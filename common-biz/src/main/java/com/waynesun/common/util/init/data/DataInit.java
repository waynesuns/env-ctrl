package com.waynesun.common.util.init.data;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.waynesun.utils.concurrent.BizConcurrentHashMap;
import com.waynesun.common.biz.announcement.AnnouncementFeedback;
import com.waynesun.common.biz.announcement.AnnouncementFeedbackCacheUtils;
import com.waynesun.common.biz.area.AbstractArea;
import com.waynesun.common.biz.area.AreaCacheUtils;
import com.waynesun.common.biz.config.SystemConfig;
import com.waynesun.common.biz.config.SystemConfigCacheUtils;
import com.waynesun.common.biz.dealer.DealerCacheUtils;
import com.waynesun.common.biz.dealerarea.AbstractDealerArea;
import com.waynesun.common.biz.dealerarea.DealerAreaCacheUtils;
import com.waynesun.common.biz.dictionary.DictionaryCacheUtils;
import com.waynesun.common.biz.dictionary.DictionaryCategory;
import com.waynesun.common.biz.dictionary.DictionaryItem;
import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.resource.ResourceCacheUtils;
import com.waynesun.common.biz.role.Role;
import com.waynesun.common.biz.role.RoleCacheUtils;
import com.waynesun.common.biz.user.AbstractDealer;
import com.waynesun.common.biz.veh.VehicleBrand;
import com.waynesun.common.biz.veh.VehicleBrandCacheUtils;

public class DataInit implements InitializingBean {
	private Data data;


	@Override
	public void afterPropertiesSet() throws Exception
	{
		loadDealer();
		loadArea();
		loadSystemConfigInfo();
		loadResource();
		loadDealerArea();
		loadRole();
		loadBrand();
		loadDictionaryInfo();
		doAnnouncementFeedback();
	}

	/**
	 * 初始化品牌
	 */
	private void loadBrand(){
		List<VehicleBrand> list =  data.findAllVehicleBrands();
		VehicleBrandCacheUtils.initArea(list);
	}
	/**
	 * 初始化省市区数据
	 */
	private void loadArea(){
		List<AbstractArea> list =  data.findAllAreas();
		AreaCacheUtils.initArea(list);
	}
	/**
	 * 初始化dealer
	 */
	private void loadDealer(){
		List<AbstractDealer> list = data.findAllDealers();
		DealerCacheUtils.initDealer(list);
	}
	/**
	 * 初始化经销商区域抽象父类
	 */
	private void loadDealerArea()
	{
		List<AbstractDealerArea> list = data.findAllDealerAreas();
		DealerAreaCacheUtils.init(list);
	}
	
	/**
	 * 系统配置初始化
	 */
	private void loadSystemConfigInfo()
	{
		List<SystemConfig> list = data.findAllSystemConfigs();
		SystemConfigCacheUtils.initSystemConfig(list);
	}
	

	


	
	
	private void loadResource()
	{
		List<Resource> list = data.findAllResources();
		ResourceCacheUtils.init(list);
	}
	
	/**
	 * 加载角色信息
	 */
	private void loadRole()
	{
		List<Role> list = data.findAllRoles();
		RoleCacheUtils.init(list);
	}
	
	public void setData(Data data)
	{
		this.data = data;
	}
	
	


	private void loadDictionaryInfo()
	{
		List<DictionaryCategory> categories = data.findAllDictionaryCategories();
		Map<String, DictionaryCategory> categoryMap = new BizConcurrentHashMap<String, DictionaryCategory>();

		for (DictionaryCategory category : categories)
		{
			categoryMap.put(category.getId(), category);
		}
		List<DictionaryItem> items = data.findAllDictionaryItems();
		for (DictionaryItem item : items)
		{
			item.setParent(categoryMap.get(item.getParent().getId()));
		}
		DictionaryCacheUtils.initDictionaryCache(items);
	}
	private void doAnnouncementFeedback() throws Exception{
		List<AnnouncementFeedback> feedbackList = data.findAnnouncementFeedback();
		try{
			AnnouncementFeedbackCacheUtils.initAnnouncementFeedbackCache(feedbackList);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	
	
}
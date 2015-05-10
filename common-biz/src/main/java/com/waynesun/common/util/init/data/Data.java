package com.waynesun.common.util.init.data;

import java.util.List;

import com.waynesun.common.biz.announcement.AnnouncementFeedback;
import com.waynesun.common.biz.area.AbstractArea;
import com.waynesun.common.biz.config.SystemConfig;
import com.waynesun.common.biz.dealerarea.AbstractDealerArea;
import com.waynesun.common.biz.dictionary.DictionaryCategory;
import com.waynesun.common.biz.dictionary.DictionaryItem;
import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.role.Role;
import com.waynesun.common.biz.user.AbstractDealer;
import com.waynesun.common.biz.veh.VehicleBrand;

public interface Data {

	/**
	 * 经销商实体
	 * 
	 * @return
	 */
	List<AbstractDealer> findAllDealers();

	/**
	 * 所有的省 市区
	 * 
	 * @return
	 */
	List<AbstractArea> findAllAreas();
	
	/**
	 * 所有的省 市区
	 * 
	 * @return
	 */
	List<VehicleBrand> findAllVehicleBrands(); 

	/**
	 * 业务大区
	 * 
	 * @return
	 */
	List<AbstractDealerArea> findAllDealerAreas();

	/**
	 * 查询获取所有系统配置
	 * 
	 * @return
	 */
	List<SystemConfig> findAllSystemConfigs();


	/**
	 * 加载所有菜单
	 * 
	 * @return
	 */
	List<Resource> findAllResources();

	/**
	 * 加载所有角色
	 * 
	 * @return
	 */
	List<Role> findAllRoles();
	/**
	 * 查询获取所有数据字典项
	 * 
	 * @return
	 */
	List<DictionaryItem> findAllDictionaryItems();

	/**
	 * 查询获取所有数据字类别
	 * 
	 * @return
	 */
	List<DictionaryCategory> findAllDictionaryCategories();
	/**
	 * 
	 * @return
	 */
	List<AnnouncementFeedback> findAnnouncementFeedback();
}
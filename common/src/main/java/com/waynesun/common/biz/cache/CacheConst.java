package com.waynesun.common.biz.cache;

/**
 * 缓存的Key
 * 
 * @author Liu Bin
 * 
 * @version 创建时间：2012-6-26下午12:06:48
 */
public class CacheConst
{


	/** 订单校验设置Key */
	public static final String ORDER_TYPE_CONFIG_CACHE_LIST_KEY = "order_type_config_cache_list_key";
	/** 经销商缓存Key */
	public static final String DEALER_CACHE_LIST_KEY = "dealer_cache";
	/** 经销商缓存Key */
	public static final String DEALER_TWO_CACHE_KEY = "dealer_two_cache";
	/** 省市区Key */
	public static final String AREA_CACHE_LIST_KEY = "area_cache";
	/** 省市区Key */
	public static final String AREA_CACHE_NAME_KEY = "area_cache_name";
	
	/** 车型缓存Key */
	public static final String CACHE_KEY_VEHICLE_MODEL = "vehicle_model_cache";
	/** 故障模式缓存Key */
	public static final String CACHE_KEY_FAULT_MODEL = "fault_model_cache";
	
	/** 系统配置缓存Key */
	public static final String CONFIG_CACHE_KEY = "config_cache_key";
	
	/** 数据字典缓存Key */
	public static final String DICTIONARY_DATA_CACHE_KEY = "dictionary_data_cache_key";
	public static final String DICTIONARY_DATA_CACHE_KEY_ID = "dictionary_data_cache_key_id";
	/** 数据字典类型缓存Key */
	public static final String DICTIONARY_CATEGORY_CACHE_KEY_CODE = "dictionary_category_cache_key_code";
	public static final String DICTIONARY_CATEGORY_CACHE_KEY_ID = "dictionary_category_cache_key_id";
	
	/** 严重安全性能故障缓存Key */
	public static final String FITTING_FAULT = "fitting_fault";

	/** vsn与车型平台关系缓存Key */
	public static final String VEHICLE_MODEL_DETAIL = "vehicle_model_detail";
	
	public static final String CACHE_KEY_PART_GROUP = "part_group_cache";

	/** 次要件件缓存Key */
	public static final String FITTING_SUBPARTS="fitting_subparts";

	/** 主要件缓存 Key*/
	public static final String FITTING_MAIN = "fitting_main";

	/** 发动机变速器零件缓存Key */
	public static final String FITTING_ENGINE = "fitting_engine";

	/** 预警明细缓存Key */
	public static final String EW_PART = "ew_part";

	/** 预警明细详情缓存Key */
	public static final String EW_PART_DETAIL = "ew_part_detail";
	/** 预警明细详情缓存Key */
	public static final String EW_ITEM = "ew_item";
	/** 流水号初始值 */
	public static final String SERIAL_NUMBER = "Serial_Number";
	/** 预警项配置缓存Key */
	public static final String EW_ITEM_CONFIG = "ew_item_config";
	/** upcfna缓存Key */
	public static final String CACHE_KEY_UPC_FNA = "cache_key_upc_fna";
	/** 预警级别缓存Key */
	public static final String CACHE_KEY_EW_LEVEL = "cache_key_ew_level";
	
	public static final String ORDER_TYPE_PRODUCT_TYPE_REL = "order_type_product_type_rel";
	
	public static final String TRANSPORTMODE_STORAGEGROUP_REL = "transportmode_storagegroup_rel";
	/** 到货提醒Key */
	public static final String DELIVERY_NOTIFICATION_KEY = "delivery_notification_key";
	/** 到货提醒dealer Key */
	public static final String DELIVERY_NOTIFICATION_DEALER_KEY = "delivery_notification_dealer_key";
	/** 公告提醒Key */
	public static final String ANNOUNCE_NOTIFICATION_KEY = "announce_notification_key";
	/** 公告提醒按用户和公告双层Map */
	public static final String ANNOUNCE_USER_NOTIFICATION_KEY = "announce_user_notification_key";
}

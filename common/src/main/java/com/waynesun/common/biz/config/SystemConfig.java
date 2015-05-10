package com.waynesun.common.biz.config;

import com.waynesun.pojo.BaseEntity;

/**
 * 系统配置实体
 * 
 * @author Liu Bin
 * 
 * @version 创建时间：2012-6-26下午1:20:06
 */
public class SystemConfig extends BaseEntity
{
	/** 总部管理员角色ID */
	public static final String HEAD_QUARTER_ADMINISTRATOR_ID = "head_administrator_id";
	/** 总部成员角色ID */
	public static final String HEAD_QUARTER_MEMBER_ID = "head_member_id";
	/** 服务站管理员角色ID */
	public static final String SERVER_ADMINISTRATOR_ID = "server_administrator_id";
	/** 服务站成员角色ID */
	public static final String SERVER_MEMBER_ID = "server_member_id";
	/**自动审核通过时长(单位:分钟)*/
	public static String KEY_ORDER_AUTO_CLOSE_TIME = "order_auto_close_time";
	/**订单自动关闭时长(单位:天)*/
	public static String KEY_AUTO_VERIFY_TIME = "auto_verify_time";
	/**订单满足率基准(单位:%,单一品种数量达到该百分比算为品种满足)*/
	public static String KEY_ORDER_SATISFY_RATE = "order_satisfy_rate";
	/**
	 * 
	 */
	private static final long serialVersionUID = 8907882698743513120L;

	/** 默认密码 */
	public static final String DEFAULT_PASSWORD_CONFIG = "default_password_config";
	/** SAP订单下单接口服务地址 */
	public static final String SAP_ORDER_CREATE_SERVICE = "sap_order_create_service";
	/** SAP订单下单接口服务方法 */
	public static final String SAP_ORDER_CREATE_METHOD = "sap_order_create_method";
	

	/** 三包预申请编号确认接口地址 */
	public static final String EW4LC_NO_CHECK_SERVICE_ADDRESS = "ew4lc_no_check_service_address";
	/** 三包预申请编号确认接口方法名 */
	public static final String EW4LC_NO_CHECK_SERVICE_METHOD = "ew4lc_no_check_service_method";
	
	
	/** 配置的Code */
	private String code;
	/** 配置的名称Name */
	private String name;
	/** 配置的名称Value */
	private String value;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
}

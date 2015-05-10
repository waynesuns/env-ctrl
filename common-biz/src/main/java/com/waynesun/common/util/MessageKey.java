package com.waynesun.common.util;

/**
 * 
 * 国际化资源KEY
 * @author wayne
 *
 */

public interface MessageKey {
	
	/** 索赔单状态 */
	public final static String WARRANTY_ORDER_STATUS = "warranty.order.status.";
	/** 索赔件状态 */
	public final static String WARRANTY_PART_STATUS = "warranty.part.status.";
	
	/** 索赔单处理结果 */
	public final static String WARRANTY_ORDER_PROCESS_STATUS = "warranty.order.process.status.";
	/** 索赔类型国际化前缀 */
	public final static String WARRANTYTYPE = "warranty.type.";
	
	/** 订单类型国际化前缀 */
	public final static String ORDERTYPEKEY = "order.type.";
	/** 订单状态国际化前缀 */
	public final static String ORDERSTATUS = "order.status.";
	
	public final static String DELIVERYSTATUS = "delivery.status.";
	
	/** 铺货状态国际化前缀 */
	public final static String DISTRIBUTIONSTATUSKEY = "distribution.status.";
	
	public final static String ASSESSTYPEKEY = "assess.type.";
	/**物料国际化前缀*/
	public final static String PRODUCTKEY = "product.";
	/**物料属性国际化前缀*/
	public final static String PRODUCTCATEGORYKEY = "product.category.";
	/**订单均衡性控制*/
	public final static String DEALER_QUOTA_CONFIG_KEY = "dealer.quota.config.";
	/**服务站配件指标完成情况*/
	public final static String DEALER_QUOTA_KEY = "dealer.quota.";
	/**物料属性前缀*/
	public final static String PRODUCT_CATEGORY_KEY = "product.category.";
	
	
	/**订单创建错误（物料不存在）*/
	public static final String ORDER_ERROR_INVALID_PRODUCT = "order.error.invalid.product";
	/**订单创建错误（物料价格不存在）*/
	public static final String ORDER_ERROR_PRODUCT_PRICE_EMPTY = "order.error.product.price.empty";
	/**订单创建错误（订购的物料类别不在可订购范围之内）*/
	public static final String ORDER_ERROR_ORDERITEM_PRODUCTCATEGORY_INVALID = "order.error.orderItem.productCategory.invalid";
	/**订单创建错误（订购的物料供应商无效）*/
	public static final String ORDER_ERROR_ORDERITEM_PROVIDER_INVALID = "order.error.orderItem.provider.invalid";
	/**订单创建错误（物料订购数量未达下限）*/
	public static final String ORDER_ERROR_ORDERITEM_LOWORDERLIMIT_LESS = "order.error.orderItem.lowOrderLimit.less";
	/**订单创建错误（物料订购数量非最小订购量倍数）*/
	public static final String ORDER_ERROR_ORDERITEM_LOWORDERLIMIT_INVALID = "order.error.orderItem.lowOrderLimit.invalid";
	/**订单创建错误（物料订购数量超过上限）*/
	public static final String ORDER_ERROR_ORDERITEM_HIGHORDERLIMIT_OUTOFBOUND = "order.error.orderItem.highOrderLimit.outofbound";;
	/**订单创建错误（送达方无效）*/
	public static final String ORDER_ERROR_CONSIGNEE_INVALID = "order.error.consignee.invalid";
	/**指定的订单不存在或已被删除*/
	public static final String ORDER_ERROR_ORDER_INVALID = "order.error.order.invalid";
	/**未添加需要订购的配件*/
	public static final String ORDER_ERROR_ORDERITEM_EMPTY = "order.error.orderItem.empty";
	/**超过最大订购行项*/
	public static final String ORDER_ERROR_ORDERITEM_OUTOFBOUND = "order.error.orderItem.outofbound";
	
	/**订单导入错误（物料价格不存在）*/
	public static final String ORDER_ERROR_IPT_PRODUCT_PRICE_EMPTY = "order.error.ipt.product.price.empty";
	/**订单导入错误（订购的物料类别不在可订购范围之内）*/
	public static final String ORDER_ERROR_IPT_ORDERITEM_PRODUCTCATEGORY_INVALID = "order.error.ipt.orderItem.productCategory.invalid";
	/**订单创建错误（订购的物料供应商无效）*/
	public static final String ORDER_ERROR_IPT_ORDERITEM_PROVIDER_INVALID = "order.error.ipt.orderItem.provider.invalid";
	/**订单导入错误（物料订购数量未达下限）*/
	public static final String ORDER_ERROR_IPT_ORDERITEM_LOWORDERLIMIT_LESS = "order.error.ipt.orderItem.lowOrderLimit.less";
	/**订单创建错误（物料订购数量非最小订购量倍数）*/
	public static final String ORDER_ERROR_IPT_ORDERITEM_LOWORDERLIMIT_INVALID = "order.error.ipt.orderItem.lowOrderLimit.invalid";
	/**订单导入错误（物料订购数量超过上限）*/
	public static final String ORDER_ERROR_IPT_ORDERITEM_HIGHORDERLIMIT_OUTOFBOUND = "order.error.ipt.orderItem.highOrderLimit.outofbound";
	/**订单导入错误（物料重复）*/
	public static final String ORDER_ERROR_IPT_ORDERITEM_REITERATION = "order.error.ipt.orderItem.reiteration";
	/**订单提交错误（未设置审核人）*/
	public static final String ORDER_ERROR_ASSESSOR_EMPTY = "order.error.assessor.empty";
	
	/**铺货计划导入错误（服务站无对应的物料属性）*/
	public static final String DISTRIBUTION_ERROR_IPT_DEALER_PRODUCTCATEGORY_INVALID = "distribution.error.ipt.dealer.productCategory.invalid";
	/**铺货计划导入错误（非一级站）*/
	public static final String DISTRIBUTION_ERROR_IPT_DEALER_INVALID = "distribution.error.ipt.dealer.invalid";
	/**铺货计划导入错误（服务站编号重复）*/
	public static final String DISTRIBUTION_ERROR_IPT_DEALER_REITERATION = "distribution.error.ipt.dealer.reiteration";
	/**铺货计划导入错误（服务站编号为空）*/
	public static final String DISTRIBUTION_ERROR_IPT_DEALERCODE_EMPTY = "distribution.error.ipt.dealerCode.empty";
	/**铺货计划导入错误（服务站编号不存在）*/
	public static final String DISTRIBUTION_ERROR_IPT_DEALERCODE_INVALID = "distribution.error.ipt.dealerCode.invalid";

	/**铺货计划错误（服务站编号不存在）*/
	public static final String DISTRIBUTION_ERROR_DEALERCODE_INVALID = "distribution.error.dealerCode.invalid";
	/**铺货计划错误（非一级站）*/
	public static final String DISTRIBUTION_ERROR_DEALER_INVALID = "distribution.error.dealer.invalid";
	/**铺货计划错误（服务站编号重复）*/
	public static final String DISTRIBUTION_ERROR_DEALER_REITERATION = "distribution.error.dealer.reiteration";
	/**铺货计划错误（服务站无对应的物料属性）*/
	public static final String DISTRIBUTION_ERROR_DEALER_PRODUCTCATEGORY_INVALID = "distribution.error.dealer.productCategory.invalid";
	
	/**订单项导出*/
	public static final String ORDER_ITEM="orderitem.";
	/**发货单导出*/
	public static final String DELIVERYORDER="deliveryorder.";
	/**订单_发货单明细导出*/
	public static final String DELIVERYORDER_ITEM_EXPORT="order.deliveryorderdetail.";

	/**物料替换属性*/
	public static final String SAPODER_ITEM_STATUS="saporder.item.status.";
	/**SAP订单明细*/
	public static final String SAPODER_ITEM="saporder.item.";
	/**发货单满意度评价 */
	public static final String DELIVERY_EVALUATE="saporder.evaluate.";
	/**指定的订单状态已被改变，请刷新后重试 */
	public static final String ORDER_ERROR_STATUS_INVALID = "order.error.status.invalid";
	
	/**发货单明细导出*/
	public static final String DELIVERYORDER_ITEM="deliveryorderitem.";
	
	/**订单满足率报表*/
	public static final String ORDER_RATE_REPORT="report.order.satify.rate.";
	
	/**订单干预报表*/
	public static final String ORDER_INTERVENE_REPORT="order.intervene.report.";
	
	/**配件指标完成情况报表*/
	public static final String PRODUCT_FINISH_REPORT="product.finish.report.";
	
	/**退换货索赔箱号重复*/
	public static final String WARRANTY_ERROR_CASE_NO_REITERATION="warranty.error.caseNo.reiteration";
	/**退换货配件号重复*/
	public static final String WARRANTY_ERROR_PARTS_NO_REITERATION="warranty.error.partsNo.reiteration";
}

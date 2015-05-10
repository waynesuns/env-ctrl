package com.waynesun.common.biz.user;

import com.waynesun.dao.query.condition.BaseQueryCondition;
import com.waynesun.dao.query.condition.annotation.Eq;
import com.waynesun.dao.query.condition.annotation.Like;
import com.waynesun.dao.query.condition.annotation.PropertyProxy;
import com.waynesun.pojo.PojoState;

public class DealerQC extends BaseQueryCondition {
	private String dealerCode;
	private String name;
	private String telephone;
	private AbstractUser manager;
	private String contactName;
	private String area;
	private PojoState state;
	private Integer dealerGroup;
	private Integer dealerType;
	private String oneLevelDealer_id;
	private String dealerCode_eq;
	/** 所在省份编码（字符串Code） */
	private String province;
	/** 所在城市编码（字符串Code）  */
	private String city;
	/** 所在区县编码（字符串Code）  */
	private String district;
	/**下级网点配送*/
	private Boolean sendToSubDealer;


	@Eq
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Eq
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Like(matchMode = Like.START)
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Eq
	public Integer getDealerGroup() {
		return dealerGroup;
	}

	public void setDealerGroup(Integer dealerGroup) {
		this.dealerGroup = dealerGroup;
	}

	@Eq
	public Integer getDealerType() {
		return dealerType;
	}

	public void setDealerType(Integer dealerType) {
		this.dealerType = dealerType;
	}

	@Like(matchMode = Like.START)
	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	@Like(matchMode = Like.START)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public AbstractUser getManager() {
		return manager;
	}

	public void setManager(AbstractUser manager) {
		this.manager = manager;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Eq
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Eq
	public PojoState getState() {
		return state;
	}

	public void setState(PojoState state) {
		this.state = state;
	}

	@Eq
	public String getOneLevelDealer_id() {
		return oneLevelDealer_id;
	}

	public void setOneLevelDealer_id(String oneLevelDealer_id) {
		this.oneLevelDealer_id = oneLevelDealer_id;
	}

	@Eq
	@PropertyProxy(propertyChain = "dealerCode")
	public String getDealerCode_eq() {
		return dealerCode_eq;
	}

	public void setDealerCode_eq(String dealerCode_eq) {
		this.dealerCode_eq = dealerCode_eq;
	}

	@Eq
	public Boolean getSendToSubDealer() {
		return sendToSubDealer;
	}

	public void setSendToSubDealer(Boolean sendToSubDealer) {
		this.sendToSubDealer = sendToSubDealer;
	}
}
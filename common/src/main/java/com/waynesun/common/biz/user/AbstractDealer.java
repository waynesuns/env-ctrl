package com.waynesun.common.biz.user;

import java.util.List;

import com.waynesun.exception.BizException;
import com.waynesun.pojo.BaseEntity;
import com.waynesun.utils.MessageReader;
import com.waynesun.common.biz.area.AbstractArea;
import com.waynesun.common.biz.area.AreaCacheUtils;
import com.waynesun.common.biz.dealer.DealerCacheUtils;
import com.waynesun.common.biz.dealerarea.AbstractDealerArea;
import com.waynesun.common.biz.dealerarea.DealerAreaCacheUtils;
import com.waynesun.common.biz.veh.VehicleBrand;
import com.waynesun.common.biz.veh.VehicleBrandCacheUtils;


/**
 * 经销商实体
 * 
 * @author Liu Bin
 * 
 * @version 创建时间：2012-6-26上午9:43:05
 */
public class AbstractDealer extends BaseEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4852581656996441469L;

	/** 经销商编号 */
	private String dealerCode;
	/** 网点分组（1商用，2乘用） */
	private Integer dealerGroup;
	/** 网点类型（1销售，2维修） */
	private Integer dealerType;
	/** 经销商名称 */
	private String name;
	/** 联系电话 */
	private String telephone;
	/** 传真 */
	private String fax;
	/** Email */
	private String email;
	/** 所在省份编码（字符串Code） */
	private String province;
	/** 所在城市编码（字符串Code）  */
	private String city;
	/** 所在区县编码（字符串Code）  */
	private String district;
	/** 邮编 */
	private String zipCode;
	/** 地址 */
	private String address;
	/** 服务站经理 */
	private String manager;
	/** 联系人 */
	private String contactName;
	/** 区域（对象） */
	private String area;
	/**24小时服务热线*/
	private String hotline;
	/**收货联系人*/
	private String deliveryPerson;
	/**收货联系人电话*/
	private String deliveryPhoneNo;
	/**收货地址*/
	private String deliveryAddress;
	/**服务站经理联系电话*/
	private String managerTelNo;
	/**待收货数量*/
	private Integer penddingReachedAmt;
	/**订单审核人*/
	private AbstractUser assessor;
	/**下级网点配送*/
	private Boolean sendToSubDealer = Boolean.FALSE;

	/*private Set<AbstractDealer> subDealers;*/

	/**获取所有的下级服务站*/
	protected List<AbstractDealer> getSubDealers() {
		throw new BizException("call error");
	}

	/**获取收货网点*/
	public AbstractDealer getDeliveryDealer(){
		return this;
	}
	

	/**是否需要验证审核人*/
	public boolean isCheckAssessor(){
		return true;
	}

	public Integer getPenddingReachedAmt() {
		return penddingReachedAmt;
	}

	public void setPenddingReachedAmt(Integer penddingReachedAmt) {
		this.penddingReachedAmt = penddingReachedAmt;
	}

	public void updateAndUpdateCache(){
		this.update();
//		DealerCacheUtils.addOrUpdateDealerToCache(this);
	}

	public String getDealerCode()
	{
		return dealerCode;
	}

	public void setDealerCode(String dealerCode)
	{
		this.dealerCode = dealerCode;
	}

	public Integer getDealerGroup()
	{
		return dealerGroup;
	}

	public void setDealerGroup(Integer dealerGroup)
	{
		this.dealerGroup = dealerGroup;
	}

	public Integer getDealerType()
	{
		return dealerType;
	}

	public void setDealerType(Integer dealerType)
	{
		this.dealerType = dealerType;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getContactName()
	{
		return contactName;
	}

	public void setContactName(String contactName)
	{
		this.contactName = contactName;
	}

	public String getArea()
	{
		return area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	/*public Set<AbstractDealer> getSubDealers()
	{
		return subDealers;
	}

	public void setSubDealers(Set<AbstractDealer> subDealers)
	{
		this.subDealers = subDealers;
	}*/
	
	public String getParent(){
		if(this instanceof TwoLevelDealer)
			return ((TwoLevelDealer)this).getOneLevelDealer().getId();
		else
			return "";
	}
	public String getCityName() {
		return AreaCacheUtils.getAreaName(this.getCity());
	}

	public String getProvinceName(){
		return AreaCacheUtils.getAreaName(this.getProvince());
	}
	
	public String getBrandName(){
		VehicleBrand brand = VehicleBrandCacheUtils.getBrandById(this.getDealerGroup()+"");
		return brand == null ? "" : brand.getName();
	}
	
	public String getDealerAreaName(){
		if (this.getArea() == null) {
			return null;
		}
		return DealerAreaCacheUtils.getDealerAraeaById(this.getArea()).getName();
	}

	public AbstractArea getDealerProvince(){
		return AreaCacheUtils.getAreaByCode(this.getProvince());
	}
	public AbstractDealerArea getDealerArea(){
		if (this.getArea() == null) {
			return null;
		}
		return DealerAreaCacheUtils.getDealerAraeaById(this.getArea());
	}
	public String getManagerTelNo() {
		return managerTelNo;
	}

	public void setManagerTelNo(String managerTelNo) {
		this.managerTelNo = managerTelNo;
	}


	public String getHotline() {
		return hotline;
	}

	public void setHotline(String hotline) {
		this.hotline = hotline;
	}

	public String getDeliveryPerson() {
		return deliveryPerson;
	}

	public void setDeliveryPerson(String deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}

	public String getDeliveryPhoneNo() {
		return deliveryPhoneNo;
	}

	public void setDeliveryPhoneNo(String deliveryPhoneNo) {
		this.deliveryPhoneNo = deliveryPhoneNo;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}


	public AbstractUser getAssessor() {
		return assessor;
	}

	public void setAssessor(AbstractUser assessor) {
		this.assessor = assessor;
	}


	public Boolean getSendToSubDealer() {
		return sendToSubDealer;
	}

	public void setSendToSubDealer(Boolean sendToSubDealer) {
		this.sendToSubDealer = sendToSubDealer;
	}

	@Override
	public void update() {
		synchronized (this) {
			super.update();
			DealerCacheUtils.addOrUpdateDealerToCache(this);
		}
	}

	protected void superUpdate(){
		super.update();
	}

	public String getSendToSubDealerString() {
		if (Boolean.TRUE.equals(this.sendToSubDealer))
			return MessageReader.getMessage("common.yes");
		return MessageReader.getMessage("common.no");
	}
}
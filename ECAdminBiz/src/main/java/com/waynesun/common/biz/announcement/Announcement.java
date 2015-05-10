package com.waynesun.common.biz.announcement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.waynesun.pojo.BaseEntity;
import com.waynesun.common.biz.attachment.Attachment;
import com.waynesun.common.biz.dealer.DealerCacheUtils;
import com.waynesun.common.biz.dealerarea.AbstractDealerArea;
import com.waynesun.common.biz.dictionary.DictionaryItem;
import com.waynesun.common.biz.user.AbstractDealer;
import com.waynesun.common.biz.veh.VehicleBrand;

/**
 * 公告
 * 
 * @author wayne
 * 
 */
public class Announcement extends BaseEntity
{
	private static final long serialVersionUID = -12727870983170609L;
	/** 标题 */
	private String title;
	/** 正文 */
	private String content;
	/** 发布 */
	private boolean released;
	/** 发布日期 */
	private Date releaseDate;
	/** 附件对象 */
	private Attachment attachment;
	/** 编号 */
	private String serialNumber;
	/** 公告分类 */
	private DictionaryItem category;
	/** 部门 */
	private DictionaryItem department;
	/** 品牌 */
	private VehicleBrand brandId;
	/** 大区 */
	private AbstractDealerArea dealerAreaId;
	/** 省份 */
	private String province;
	/** 联系人 */
	private String contactPerson;
	/** 联系电话 */
	private String contactPhone;
	/** 公告访问授权 */
	private Set<AbstractAnnouncementAuthConf> authConfs;

	public String getDealerId(){
		StringBuffer bf = new StringBuffer();
		Set<AbstractAnnouncementAuthConf> set = this.getAuthConfs();
		if(set!=null){
			for (AbstractAnnouncementAuthConf conf : set) {
				bf.append("-");
				if(conf instanceof DealerAnnouncementAuthConf)
					bf.append(((DealerAnnouncementAuthConf)conf).getDealer().getId());
			}
			bf.append("-");
		}
		return bf.toString();
	}
	
	public void addAuthConfs(String[] dealerCodes,String[] dealerCodeHiddens){
		List<String> list;
		if(dealerCodes!=null&&dealerCodes.length>0)
			list = new ArrayList<String>(Arrays.asList(dealerCodes));
		else
			list = new ArrayList<String>(Arrays.asList(dealerCodeHiddens));
		list.add("0");
		if(this.getAuthConfs()!=null&&this.getAuthConfs().size()>0){
			for (AbstractAnnouncementAuthConf conf : this.getAuthConfs()){
				if(conf instanceof DealerAnnouncementAuthConf){
					String code = ((DealerAnnouncementAuthConf)conf).getDealer().getDealerCode();
					if(list.contains(code))
						list.remove(code);
					else
						conf.delete();
				}
			}
		}
		if(list!=null&&list.size()>0){
			Map<String, AbstractDealer> map = DealerCacheUtils.getAllDealer();
			for (String code : list) {
				DealerAnnouncementAuthConf conf = new DealerAnnouncementAuthConf();
				conf.setAnnouncement(this);
				conf.setDealer(map.get(code));
				conf.setStatus(DealerAnnouncementAuthConf.UNREAD);
				conf.update();
			} 
		}
	}
	
	/**
	 * 是否存在附件
	 * 
	 * @return true：存在，false：不存在
	 */
	public boolean isExistsFile()
	{
		if(attachment == null)
			return false;
		return true;
	}
	public boolean getExistsFile()
	{
		if(attachment == null)
			return false;
		return true;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public boolean isReleased()
	{
		return released;
	}

	public void setReleased(boolean released)
	{
		this.released = released;
	}

	public Date getReleaseDate()
	{
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public Attachment getAttachment()
	{
		return attachment;
	}

	public void setAttachment(Attachment attachment)
	{
		this.attachment = attachment;
	}
	
	public boolean isHasAttachment(){
		if(attachment == null)
			return false;
		return true;
	}

	public Set<AbstractAnnouncementAuthConf> getAuthConfs() {
		return authConfs;
	}


	public void setAuthConfs(Set<AbstractAnnouncementAuthConf> authConfs) {
		this.authConfs = authConfs;
	}

	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public DictionaryItem getCategory() {
		return category;
	}

	public void setCategory(DictionaryItem category) {
		this.category = category;
	}

	public DictionaryItem getDepartment() {
		return department;
	}

	public void setDepartment(DictionaryItem department) {
		this.department = department;
	}

	public VehicleBrand getBrandId() {
		return brandId;
	}


	public void setBrandId(VehicleBrand brandId) {
		this.brandId = brandId;
	}


	public AbstractDealerArea getDealerAreaId() {
		return dealerAreaId;
	}


	public void setDealerAreaId(AbstractDealerArea dealerAreaId) {
		this.dealerAreaId = dealerAreaId;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
}

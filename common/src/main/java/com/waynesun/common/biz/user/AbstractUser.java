/**
 * 
 */
package com.waynesun.common.biz.user;

import java.util.List;
import java.util.Set;

import com.waynesun.dao.query.result.QueryResult;
import com.waynesun.pojo.BaseEntity;
import com.waynesun.pojo.Pages;
import com.waynesun.pojo.PojoState;
import com.waynesun.pojo.User;
import com.waynesun.utils.MessageReader;
import com.waynesun.common.biz.announcement.AbstractAnnouncementAuthConf;
import com.waynesun.common.biz.announcement.DealerAnnouncementAuthConf;
import com.waynesun.common.biz.log.Log;
import com.waynesun.common.biz.role.Role;
import com.waynesun.common.biz.role.RoleQC;
import com.waynesun.common.biz.role.RoleUtils;

/**
 * @author sunmin
 * 
 */
public abstract class AbstractUser extends BaseEntity implements User, Log
{

	private static final long serialVersionUID = 2274719953051444808L;
	private static final Boolean LOCK = new Boolean(true);
	/** 员工姓名 */
	private String name;
	/** 用户组 */
	private String userGroup;
	/** 联系电话 */
	private String phone;
	/** 登陆账户 */
	private LoginAccount account;
	/** 角色 */
	private Set<Role> roles;
	/**所属经销商编号*/
	private AbstractDealer dealer;
	/**待阅读公告数量*/
	private Integer penddingReadAnnonAmt;

	public abstract void add(LoginAccount account) throws Exception;

	public abstract String getClassName();
	

	public List<Role> getRolesByState()
	{
		RoleQC qc = new RoleQC();
		qc.setUsers_id(this.getId());
		qc.setState_not(PojoState.DELETED);
		return RoleUtils.findRoles(qc);
	}

	public List<Role> getRolesByStateNormal()
	{
		RoleQC qc = new RoleQC();
		qc.setUsers_id(this.getId());
		qc.setState(PojoState.NORMAL);
		return RoleUtils.findRoles(qc); 
	}
	public List<Role> getRolesByStateIsNotDelete()
	{
		RoleQC qc = new RoleQC();
		qc.setUsers_id(this.getId());
		qc.setState_not(PojoState.DELETED);
		return RoleUtils.findRoles(qc); 
	}
	public List<Role> getHideRole()
	{
		RoleQC qc = new RoleQC();
		qc.setUsers_id(this.getId());
		qc.setState_not(PojoState.NORMAL);
		return RoleUtils.findRoles(qc);
	}
	
	/**
	 * 当前用户是否管理员
	 * @return
	 */
	public boolean isAdministrator(){
		String dealerCode = dealer.getDealerCode();
		if("0".equals(dealerCode))
			return true;
		return false;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUserGroup()
	{
		return userGroup;
	}

	public void setUserGroup(String userGroup)
	{
		this.userGroup = userGroup;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public LoginAccount getAccount()
	{
		return account;
	}

	public void setAccount(LoginAccount account)
	{
		this.account = account;
	}

	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}

	public AbstractDealer getDealer() {
		return dealer;
	}
	

	public Integer getPenddingReadAnnonAmt() {
		return penddingReadAnnonAmt;
	}

	public void setPenddingReadAnnonAmt(Integer penddingReadAnnonAmt) {
		this.penddingReadAnnonAmt = penddingReadAnnonAmt;
	}

	public void setDealer(AbstractDealer dealer) {
		this.dealer = dealer;
	}
	
	public String getRoleNames(){
		String roleNames = "";
		List<Role> roles = this.getRolesByStateIsNotDelete();
		if(roles != null && roles.size()>0){
			StringBuffer bf = new StringBuffer();
			for (Role role : roles)
			{
				bf.append(role.getName() + ",");
			}
			roleNames = bf.substring(0, bf.length() - 1);
		}
		return roleNames;
	}
	
	public String getRoleIds(){
		String roleIds = "";
		List<Role> roles = this.getRolesByStateIsNotDelete();
		if(roles != null && roles.size()>0){
			StringBuffer bf = new StringBuffer();
			for (Role role : roles)
			{
				bf.append(role.getId() + ",");
			}
			roleIds = bf.substring(0, bf.length() - 1);
		}
		return roleIds;
	}
	
	/**
	 * 是否审核人
	 * @return
	 */
	public String getAssessorMessage(){
		AbstractDealer dealer = this.getDealer();
		if(dealer == null)
			return MessageReader.getMessage("common.no");
		if("0".equals(dealer.getDealerCode()))
			return MessageReader.getMessage("common.no");
		AbstractUser assessor = dealer.getAssessor();
		if(assessor == null)
			return MessageReader.getMessage("common.no");
		if(!this.getId().equals(assessor.getId()))
			return MessageReader.getMessage("common.no");
		return MessageReader.getMessage("common.yes");
	}

	@Override
	public void update() {
		synchronized(LOCK) {
//			AbstractUser user = DaoUtils.getDao().merge(this);
//			user.superUpdate();
			this.superUpdate();
			this.setChanged();
			this.notifyObservers(this);
		}
	}

	protected void superUpdate(){
		super.update();
	}
	/**
	 * 返回允许当前用户访问的公告列表
	 * @param pages
	 * @return
	 */
	public QueryResult<DealerAnnouncementAuthConf> getAllowVisitAnnouncement(Pages pages){
		return AbstractAnnouncementAuthConf.getAllowVisitAnnouncement(this, pages);
	} 
}

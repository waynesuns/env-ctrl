package com.waynesun.common.biz.user;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.waynesun.dao.DaoFactory;
import com.waynesun.pojo.BaseEntity;
import com.waynesun.pojo.PojoState;
import com.waynesun.pojo.User;
import com.waynesun.utils.CollectionUtil;
import com.waynesun.common.biz.cache.AuthConst;
import com.waynesun.common.biz.config.SystemConfig;
import com.waynesun.common.biz.config.SystemConfigCacheUtils;
import com.waynesun.common.biz.role.Role;

public class LoginAccount extends BaseEntity implements UserDetails
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1445317865556204512L;

	/** 用户详情 */
	private AbstractUser user;
	/** 登录名 */
	private String userName;
	/** 登录密码 */
	private String password;
	/** 最后登录日期 */
	private Date lastTime;
	/** 有效期开始日期 */
	private Date startDate;
	/** 有效期结束日期 */
	private Date endDate;
	
	private Object menuRandomKey;
	private String homedirectory;
	private int enableflag=1;
	private int writepermission=0;
	private int idletime=0;
	private int uploadrate=0;
	private int downloadrate=0;
	private int maxloginnumber=0;
	private int maxloginperip=0;
	public String getHomedirectory() {
		return homedirectory;
	}

	public void setHomedirectory(String homedirectory) {
		this.homedirectory = homedirectory;
	}

	public int getEnableflag() {
		return enableflag;
	}

	public void setEnableflag(int enableflag) {
		this.enableflag = enableflag;
	}

	public int getWritepermission() {
		return writepermission;
	}

	public void setWritepermission(int writepermission) {
		this.writepermission = writepermission;
	}

	public int getIdletime() {
		return idletime;
	}

	public void setIdletime(int idletime) {
		this.idletime = idletime;
	}

	public int getUploadrate() {
		return uploadrate;
	}

	public void setUploadrate(int uploadrate) {
		this.uploadrate = uploadrate;
	}

	public int getDownloadrate() {
		return downloadrate;
	}

	public void setDownloadrate(int downloadrate) {
		this.downloadrate = downloadrate;
	}

	public int getMaxloginnumber() {
		return maxloginnumber;
	}

	public void setMaxloginnumber(int maxloginnumber) {
		this.maxloginnumber = maxloginnumber;
	}

	public int getMaxloginperip() {
		return maxloginperip;
	}

	public void setMaxloginperip(int maxloginperip) {
		this.maxloginperip = maxloginperip;
	}

	public LoginAccount()
	{
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities()
	{
		HashSet<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new GrantedAuthorityImpl(AuthConst.PUBLIC_AUTHORITY_ROLE_ID));
		List<Role> listRole = getUser().getRolesByState();
		if (!CollectionUtil.isEmptyOrZero(listRole))
		{
			for (Role role : listRole)
				grantedAuthorities.add(new GrantedAuthorityImpl(role.getId()));
		}
		return grantedAuthorities;
	}

	/**
	 * 定时任务循环判断该账户是否在有效期内， 若不是在有效期内就将状态修改为不可用
	 * 
	 * @throws ParseException
	 * 
	 */
	public void updateStateByValidity() throws ParseException
	{
//		Date currentDate = DateUtils.parseDate(DateUtils.format(new Date(),  DateUtils.YYYY_MM_DD.toPattern()),  DateUtils.YYYY_MM_DD.toPattern());
//		if (currentDate.compareTo(startDate) < 0 || currentDate.compareTo(endDate) > 0)
//		{
//			if (!this.getState().equals(PojoState.DELETED))
//			{
//				this.setState(PojoState.DELETED);
//				this.user.setState(PojoState.DELETED);
//				this.user.update();
//				this.update();
//			}
//		}
//		else
//		{
//			if (this.getState().equals(PojoState.DELETED))
//			{
//				this.setState(PojoState.NORMAL);
//				this.user.setState(PojoState.NORMAL);
//				this.user.update();
//				this.update();
//			}
//		}
	}

	/**
	 * 定时任务调用方法
	 * 
	 * @throws ParseException
	 * 
	 */
	public void updateStateByValidityTask() throws ParseException {
		com.waynesun.utils.UserUtils.setUser((User) DaoFactory.getInstance().getQueryDao().get(AbstractUser.class, "1", true));
		List<LoginAccount> list = LoginAccountUtils.findAllLoginAccounts();
		for (LoginAccount account : list) {
			if (PojoState.SYSTEM.equals(account.getState()))
				continue;
			account.updateStateByValidity();
		}
	}
	
	/**
	 * 获取默认密码
	 * 
	 * @return
	 */
	public static String getDefaultPassword()
	{
		return DigestUtils.md5Hex(SystemConfigCacheUtils.getCacheSystemConfig(SystemConfig.DEFAULT_PASSWORD_CONFIG).getValue());
	}

	/**
	 * 获取密码
	 */
	@Override
	public String getPassword()
	{
		return password;
	}

	/**
	 * 获取用户名
	 */
	@Override
	public String getUsername()
	{
		return userName;
	}

	/**
	 * 用户帐号是否过期
	 */
	@Override
	public boolean isAccountNonExpired()
	{
		/*Date currentDate = null;
		try
		{
			currentDate = DateUtils.parseDate(DateUtils.format(new Date(), DateUtils.YYYY_MM_DD.toPattern()),
					DateUtils.YYYY_MM_DD.toPattern());
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		if (currentDate.compareTo(startDate) < 0 || currentDate.compareTo(endDate) > 0)
			return false;*/
		return true;
	}

	/**
	 * 用户帐号是否锁定
	 */
	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	/**
	 * 用户的凭证是否过期
	 */
	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	/**
	 * 用户是否处于激活状态
	 */
	@Override
	public boolean isEnabled()
	{
		return !PojoState.DELETED.equals(getState());
	}

	// @JsonIgnore
	public AbstractUser getUser()
	{
		return user;
	}

	public void setUser(AbstractUser user)
	{
		this.user = user;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Date getLastTime()
	{
		return lastTime;
	}

	public void setLastTime(Date lastTime)
	{
		this.lastTime = lastTime;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public Object getMenuRandomKey()
	{
		return menuRandomKey;
	}

	public void setMenuRandomKey(Object menuRandomKey)
	{
		this.menuRandomKey = menuRandomKey;
	}

	
	
	
		
}
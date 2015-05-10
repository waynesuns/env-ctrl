/**
 * 
 */
package com.waynesun.common.biz.user;

import java.text.ParseException;

import com.waynesun.exception.BizException;
import com.waynesun.common.biz.log.OperateLog;
import com.waynesun.common.biz.log.OperateLogType;

/**
 * @author sunmin
 * @version 1.0
 * @project sgmw
 */
public class Employee extends AbstractUser 
{

	private static final long serialVersionUID = -2452906938035986099L;

	/** 员工工号 */
	private String employeeId;
	public Employee()
	{
	}

	public String getEmployeeId()
	{
		return employeeId;
	}

	public void setEmployeeId(String employeeId)
	{
		this.employeeId = employeeId;
	}

	@Override
	public void add(LoginAccount account) throws ParseException
	{
		LoginAccountQC qc = new LoginAccountQC();
		qc.setUserName(account.getUserName());
		LoginAccount loginAccount = LoginAccountUtils.findLoginAccount(qc);
		if(loginAccount!=null)
			throw new BizException("error.register.repeat");
		this.setAccount(account);
		this.update();
		account.setUser(this);
		account.setPassword(LoginAccount.getDefaultPassword());
		account.update();
		account.updateStateByValidity();
	}	
	/**
	 * 操作日志记录
	 */
	public void update() {
		String idObj = getId();
		super.update();
		if (idObj == null){
			OperateLog.getInstance(this, OperateLogType.ADD).saveOperateLog();
		}else{
			OperateLog.getInstance(this, OperateLogType.MODIFY).saveOperateLog();
		}
	}

	@Override
	public String getClassName()
	{
		return Employee.class.getName();
	}
	
}


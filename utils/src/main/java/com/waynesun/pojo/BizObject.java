package com.waynesun.pojo;

import java.util.Date;

import com.waynesun.utils.JsonFactory;
import com.waynesun.utils.UserUtils;
import com.waynesun.utils.search.annotation.Index;



public class BizObject extends BasePojo {
	private static final long serialVersionUID = 7910405459391041724L;

	Date createTime;

	Date updateTime;

	User createUser;

	User updateUser;

	@Index()
	public Date getCreateTime()
	{
		return createTime;
	}
	
	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	@Index(propertyNameChain="id")
	public User getCreateUser()
	{
		return createUser;
	}

	public void setCreateUser(User createUser)
	{
		this.createUser = createUser;
	}

	public User getUpdateUser()
	{
		return updateUser;
	}

	public void setUpdateUser(User updateUser)
	{
		this.updateUser = updateUser;
	}

	public void initialize()
	{
		User user = UserUtils.getUser();
		setCreateUser(user);
	}


	@Override
	public  void update()
	{
		setUpdateUser(UserUtils.getUser());
		super.update();
	}
	
	public String toJson() throws Exception
	{
		return JsonFactory.getInstance().getObjectMapper().writeValueAsString(this);
	}

}

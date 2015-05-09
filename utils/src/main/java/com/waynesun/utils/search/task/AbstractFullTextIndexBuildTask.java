package com.waynesun.utils.search.task;

import com.waynesun.pojo.BizObject;
import com.waynesun.utils.search.SearchableObject;

public abstract class AbstractFullTextIndexBuildTask extends BizObject{
	private static final long serialVersionUID = -8563346680388082494L;
	private String ownerClass;
	private String ownerId;
	private Integer operateType;
	
	public String getOwnerClass() {
		return ownerClass;
	}
	public void setOwnerClass(String ownerClass) {
		this.ownerClass = ownerClass;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public Integer getOperateType() {
		return operateType;
	}
	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}
	public SearchableObject getOwner(){
		return null;
//		return (SearchableObject)ClassUtils.getPojo(getOwnerClass(), getOwnerId());
	}
}

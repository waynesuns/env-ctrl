package com.waynesun.pojo;

public abstract class BaseEntity extends BizObject implements VirtualDelete{
	private static final long serialVersionUID = -8982727369482527369L;
	/** 状态 */
	private PojoState state = PojoState.NORMAL;

	public PojoState getState() {
		return state;
	}

	public void setState(PojoState state) {
		this.state = state;
	}
	
	
}

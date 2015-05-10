package com.waynesun.common.biz.ac;

public interface EditableObject {
	public boolean isEditable(Integer action);
	public void checkEditable(Integer action);
	public Integer getEditAction();
}

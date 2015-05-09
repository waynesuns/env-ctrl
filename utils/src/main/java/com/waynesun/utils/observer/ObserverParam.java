package com.waynesun.utils.observer;

import java.util.HashMap;
import java.util.Map;

public class ObserverParam implements Cloneable {

	public static final String PARAM_KEY_ORIGINAL_OBJECT = "originalObject";
	
	private int operateType;
	
	private Map<String,Object> params = new HashMap<String, Object>();
	
	public ObserverParam(int operateType){
		this.operateType = operateType;
	}
	
	public int getOperateType() {
		return operateType;
	}
	public void setOperateType(int operateType) {
		this.operateType = operateType;
	}
	protected Map<String, Object> getParams() {
		return params;
	}
	protected void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	public void addParam(String key,Object value){
		params.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public <T>T getParam(String key){
		return (T) params.get(key);
	}
	
	@Override
	public ObserverParam clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (ObserverParam)super.clone();
	}
}

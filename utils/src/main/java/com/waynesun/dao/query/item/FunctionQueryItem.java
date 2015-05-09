package com.waynesun.dao.query.item;

/**函数查询项*/
public class FunctionQueryItem extends BaseQueryItem{
	private FunctionQueryItem(String propertyChain,Function function) {
		super(propertyChain);
		this.function = function;
	}
	private static final long serialVersionUID = -2236822935202948989L;
	/**函数*/
	private Function function;
	public Function getFunction() {
		return function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
}

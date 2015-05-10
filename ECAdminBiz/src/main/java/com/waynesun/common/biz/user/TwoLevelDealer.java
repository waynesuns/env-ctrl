/**
 * 二级网点
 */
package com.waynesun.common.biz.user;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhuitao
 *
 */
public class TwoLevelDealer extends Dealer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4454040276350322510L;

	// 一级网点
	private OneLevelDealer oneLevelDealer;

	public OneLevelDealer getOneLevelDealer() {
		return oneLevelDealer;
	}

	public void setOneLevelDealer(OneLevelDealer oneLevelDealer) {
		this.oneLevelDealer = oneLevelDealer;
	}


	@Override
	public AbstractDealer getDeliveryDealer() {
		return this.getOneLevelDealer();
	}
	
	@Override
	protected List<AbstractDealer> getSubDealers() {
		return new ArrayList<AbstractDealer>();
	}
}
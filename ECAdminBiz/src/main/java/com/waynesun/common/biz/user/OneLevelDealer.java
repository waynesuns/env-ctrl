/**
 * 一级网点
 */
package com.waynesun.common.biz.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author xuhuitao
 *
 */
public class OneLevelDealer extends Dealer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3018681673173955412L;

	// 大区
	private Region region;

	// 二级网点列表
	private Set<TwoLevelDealer> towLevelDealers;

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Set<TwoLevelDealer> getTowLevelDealers() {
		return towLevelDealers;
	}

	public void setTowLevelDealers(Set<TwoLevelDealer> towLevelDealers) {
		this.towLevelDealers = towLevelDealers;
	}

	@Override
	protected List<AbstractDealer> getSubDealers() {
		List<AbstractDealer> subDealers = new ArrayList<AbstractDealer>();
		if (this.towLevelDealers != null) {
			subDealers.addAll(this.towLevelDealers);
		}
		return subDealers;
	}
}
/**
 * 大区
 */
package com.waynesun.common.biz.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author xuhuitao
 *
 */
public class Region extends AbstractDealer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5801386144445659188L;

	// 总部
	private Manufacturer manufacturer;

	// 一级网点列表
	private Set<OneLevelDealer> oneLevelDealers;

	/**是否需要验证审核人*/
	public boolean isCheckAssessor(){
		return false;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Set<OneLevelDealer> getOneLevelDealers() {
		return oneLevelDealers;
	}

	public void setOneLevelDealers(Set<OneLevelDealer> oneLevelDealers) {
		this.oneLevelDealers = oneLevelDealers;
	}

	@Override
	protected List<AbstractDealer> getSubDealers() {
		List<AbstractDealer> subDealers = new ArrayList<AbstractDealer>();
		if (this.oneLevelDealers != null) {
			subDealers.addAll(this.oneLevelDealers);
		}
		return subDealers;
	}	
}
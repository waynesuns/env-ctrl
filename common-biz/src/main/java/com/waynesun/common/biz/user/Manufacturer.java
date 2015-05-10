/**
 * 总部（特殊的经销商）
 */
package com.waynesun.common.biz.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author xuhuitao
 *
 */
public class Manufacturer extends AbstractDealer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5517790796336162838L;

	// 大区列表
	private Set<Region> regions;

	public Set<Region> getRegions() {
		return regions;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
	}

	/**是否需要验证审核人*/
	public boolean isCheckAssessor(){
		return false;
	}

	@Override
	protected List<AbstractDealer> getSubDealers() {
		List<AbstractDealer> subDealers = new ArrayList<AbstractDealer>();
		if (this.regions != null) {
			subDealers.addAll(this.regions);
		}
		return subDealers;
	}	
}
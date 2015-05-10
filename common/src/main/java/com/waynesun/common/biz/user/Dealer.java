package com.waynesun.common.biz.user;

import com.waynesun.utils.MessageReader;
import com.waynesun.utils.StringUtils;
import com.waynesun.common.biz.area.AbstractArea;
import com.waynesun.common.biz.area.AreaCacheUtils;
import com.waynesun.common.biz.area.CityArea;
import com.waynesun.common.biz.area.DistrictArea;
import com.waynesun.common.biz.dealer.DealerCacheUtils;

public class Dealer extends AbstractDealer {
	private static final long serialVersionUID = 1778089853098693259L;

	/**导入所需属性： 是否五菱 */
	private String isWuling;
	/**导入所需属性： 是否宝骏 */
	private String isBaoJun;
	/**导入所需属性： 是否宏光 */
	private String isHongGuang;
	/**导入所需属性： 是否下级网点配送*/
	private String isSendToSubDealer;

	/**
	 * 导入验证网点编号
	 * @param dealerCode
	 * @return
	 */
	public String validateDealerCode(String dealerCode){
		if(!dealerCode.matches("[a-zA-Z0-9]{7}|[a-zA-Z0-9]{9}"))
			return "dealer.import.info.error.invalid.dealerCode";
		AbstractDealer dealer = DealerCacheUtils.getDealerCache(dealerCode);
		if(dealer==null||StringUtils.isEmpty(dealer.getDealerCode()))
			return "dealer.import.info.error.dealerCode.no.exist";
		return null;
	}

	/**
	 * 验证城市
	 * @param city
	 * @return
	 */
	public String validateCity(String cityName){
		if(!StringUtils.isEmpty(cityName.trim())){
			AbstractArea city = AreaCacheUtils.getAreaByName(cityName.trim());
			// 验证市区是否存在  或者 是不是市区
			if(city==null||!(city instanceof CityArea)){
				
				// 如果城市不存在，则去查询区县是否存在
				DistrictArea disArea = DealerUtils.findDistrictArea(cityName.trim(),this.getProvince());
				if(disArea==null)
					return "dealer.import.info.error.invalid.city";
				else
					city = disArea.getCityArea();
			}
				
			// 验证市区和所在网点的省份是否对应
			AbstractDealer dealer = DealerCacheUtils.getDealerCache(this.getDealerCode());
			// 当前城市数据所属省份
			String provinceCode = ((CityArea)city).getProvinceArea().getCode();
			if(!StringUtils.isEmpty(dealer.getProvince())&&!provinceCode.equals(dealer.getProvince()))
				return "dealer.import.info.error.city.province";
		}
		return null;
	}

	public String validateDealerProperty(String hongGuang){
		String yes = MessageReader.getMessage("common.yes");
		String no = MessageReader.getMessage("common.no");
		if(!hongGuang.matches("["+yes+no+"]"))
			return "dealer.import.info.error.invalid.WhetherHongGuang";
		if(no.equals(this.getIsWuling())&&no.equals(this.getIsBaoJun())&&no.equals(hongGuang))
			return "dealer.import.info.error.invalid.dealer.property";
		return null;
	}

	public String validateIsSendToSubDealer(String isSendToSubDealer) {
		String yes = MessageReader.getMessage("common.yes");
		String no = MessageReader.getMessage("common.no");
		if (yes.equals(isSendToSubDealer) || no.equals(isSendToSubDealer)) {
			return null;
		}
		return "dealer.import.info.error.invalid.sendToSubDealer";
	}

	public String getIsWuling() {
		return isWuling;
	}

	public void setIsWuling(String isWuling) {
		this.isWuling = isWuling;
	}

	public String getIsBaoJun() {
		return isBaoJun;
	}

	public void setIsBaoJun(String isBaoJun) {
		this.isBaoJun = isBaoJun;
	}

	public String getIsHongGuang() {
		return isHongGuang;
	}

	public void setIsHongGuang(String isHongGuang) {
		this.isHongGuang = isHongGuang;
	}

	public String getIsSendToSubDealer() {
		return isSendToSubDealer;
	}

	public void setIsSendToSubDealer(String isSendToSubDealer) {
		this.isSendToSubDealer = isSendToSubDealer;
	}



	/**
	 * @Description: 根据服务站代码获得服务站
	 * @param dealerCode
	 * @return Dealer
	 */
	public static Dealer getDealerByCode(String dealerCode) {
		if (StringUtils.isEmpty(dealerCode)) {
			return null;
		}
		AbstractDealer dealer = DealerCacheUtils.getDealerCache(dealerCode);
		if (dealer instanceof Dealer) {
			return (Dealer) dealer;
		}
		return null;
	}

}
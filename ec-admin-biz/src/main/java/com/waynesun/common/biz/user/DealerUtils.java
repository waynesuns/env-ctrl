package com.waynesun.common.biz.user;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.dao.query.order.Order;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.MessageReader;
import com.waynesun.utils.StringUtils;
import com.waynesun.common.biz.area.DistrictArea;
import com.waynesun.common.biz.area.DistrictAreaQC;
import com.waynesun.common.biz.dealer.DealerCacheUtils;


public class DealerUtils {
	/** 1，商用 */
	public static final Integer DEALER_GROUP_BUSINESS = 1;
	/** 2，乘用 */
	public static final Integer DEALER_GROUP_MULTIPLY = 2;
	/** 2，维修 */
	public static final Integer DEALER_TYPE_SERVICE = 2;

	public static List<AbstractDealer> findDealers(DealerQC qc, Order[] orders) {
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		sq.setOrders(Arrays.asList(orders));
		return DaoFactory.getInstance().getQueryDao().list(AbstractDealer.class, null, sq, true).getResults();
	}

	/**
	 * @Title: findManufacturer
	 * @Description: 返回总部
	 * @return Manufacturer
	 * @throws
	 */
	public static Manufacturer findManufacturer() {
		return DaoFactory.getInstance().getQueryDao().uniqueResult(Manufacturer.class, null, true);
	}

	/**
	 * @Title: findRegion
	 * @Description: 返回指定网点编号的大区
	 * @param dealerCode
	 * @return Region
	 * @throws
	 */
	public static Region findRegion(String dealerCode) {
		DealerQC qc = new DealerQC();
		qc.setDealerCode(dealerCode);
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().uniqueResult(Region.class, sq, true);
	}

	/**
	 * @Title: findDealer
	 * @Description: 通过编号获得经销商
	 * @param dealerCode
	 * @return AbstractDealer
	 * @throws
	 */
	public static AbstractDealer findDealer(String dealerCode) {
		DealerQC qc = new DealerQC();
		qc.setDealerCode_eq(dealerCode);
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().uniqueResult(AbstractDealer.class, sq, true);
	}

	/**
	 * 根据条件查询网点(公告所用) 
	 * @param parentId
	 * @return
	 */
	public static List<AbstractDealer> getDealers(String brandId, String dealerAreaId, String province) {
		List<AbstractDealer> resultList = new ArrayList<AbstractDealer>();
		Map<String, AbstractDealer> map = new HashMap<String, AbstractDealer>();
		if (StringUtils.isEmpty(brandId))
			map = DealerCacheUtils.getAllDealer();
		else
			map = DealerCacheUtils.getDealerCache(DealerUtils.DEALER_TYPE_SERVICE, Integer.parseInt(brandId));
		if (map != null && map.size() > 0) {
			Set<String> set = map.keySet();
			for (String key : set) {
				AbstractDealer dealer = map.get(key);
				if (dealer.getState().equals(PojoState.DELETED))
					continue;
				if (!StringUtils.isEmpty(dealerAreaId))
					if (!dealerAreaId.equals(dealer.getArea()))
						continue;
				if (!StringUtils.isEmpty(province))
					if (!province.equals(dealer.getProvince()))
						continue;
				resultList.add(dealer);
			}
		}
		return resultList;
	}
	
	/**
	 * 导入服务站主数据
	 * @param file
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IOException  
	 */
	public static String doImport(MultipartFile file) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		/*synchronized(CacheConst.DEALER_TWO_CACHE_KEY){
			ExcelImportResult<Dealer> dealerLists = DataImportUtil.doExcelImport(Dealer.class, getExcelCellImportParams(), file, 0, false);
			List<String> errors = dealerLists.getErrors();
			List<Dealer> datas = dealerLists.getDatas();
			if(datas == null || datas.isEmpty())
				return MessageReader.getMessage("dealer.import.main.info.null");
			int updateAmt = 0;
			if (errors == null || errors.isEmpty()) {
				for (Dealer paramBean : datas) {
					AbstractDealer dealer = DealerCacheUtils.getDealerCache(paramBean.getDealerCode());
					
					if(dealer==null)
						throw new BizException("dealer is null, dealerCode : " + paramBean.getDealerCode());
					
					AbstractArea city = AreaCacheUtils.getAreaByName(paramBean.getCity());
					if(city!=null)
						dealer.setCity(city.getCode());
					else{
						DistrictArea disArea = getDistrictArea(paramBean.getCity(),paramBean.getProvince());
						dealer.setCity(disArea.getCityArea().getCode());
						dealer.setDistrict(disArea.getCode());
					}
					
					dealer.setManager(paramBean.getManager().toString());
					dealer.setManagerTelNo(paramBean.getManagerTelNo().toString());
//					dealer.setCategories(getCategories(paramBean));
					dealer.setSendToSubDealer(getSendToSubDealer(paramBean));
					dealer.updateAndUpdateCache();
					updateAmt++;
				}
			}
			return JsonStringUtils.ajaxJsonImportMessage(dealerLists, "dealer.import.info.success",datas.size()+"");
		}*/
		return null;
	}
	

	public static Boolean getSendToSubDealer(Dealer paramBean) {
		String yes = MessageReader.getMessage("common.yes");
		if (yes.equals(paramBean.getIsSendToSubDealer()))
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	/*private static List<ExcelCellImportParam> getExcelCellImportParams() {
		List<ExcelCellImportParam> params = new ArrayList<ExcelCellImportParam>();
		params.add(new ExcelCellImportParam(3, "dealerCode",false, "dealer.import.dealerCode.empty","validateDealerCode"));
		params.add(new ExcelCellImportParam(1, "province",false,"dealer.import.province.empty"));
		params.add(new ExcelCellImportParam(2, "city",false,"dealer.import.city.empty","validateCity"));
		params.add(new ExcelCellImportParam(9, "manager",false, "dealer.import.dealer.manager.empty",".{1,32}","dealer.import.info.error.invalid.manager"));
		params.add(new ExcelCellImportParam(10, "managerTelNo",false, "dealer.import.dealer.managerTelNo.empty",".{1,16}","dealer.import.info.error.invalid.managerTelNo"));
		params.add(new ExcelCellImportParam(11, "isWuling",false, "dealer.import.WhetherWuLing.empty","[是否]","dealer.import.info.error.invalid.WhetherWuLing"));
		params.add(new ExcelCellImportParam(12, "isBaoJun",false, "dealer.import.WhetherBaoJun.empty","[是否]","dealer.import.info.error.invalid.WhetherBaoJun"));
		params.add(new ExcelCellImportParam(13, "isHongGuang",false, "dealer.import.WhetherHongGuang.empty","validateDealerProperty"));
		params.add(new ExcelCellImportParam(14, "isSendToSubDealer",false, "dealer.import.sendToSubDealer.empty","validateIsSendToSubDealer"));
		return params;
	}*/
	public static DistrictArea findDistrictArea(String cityName, String provinceName) {
		DistrictAreaQC qc = new DistrictAreaQC();
		qc.setName(cityName);
		qc.setCityArea_provinceArea_name(provinceName);
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		return DaoFactory.getInstance().getQueryDao().uniqueResult(DistrictArea.class, sq, true);
	}
}
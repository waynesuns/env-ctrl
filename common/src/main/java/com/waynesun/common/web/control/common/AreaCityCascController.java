package com.waynesun.common.web.control.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.waynesun.dao.DaoFactory;
import com.waynesun.utils.JsonStringUtils;
import com.waynesun.utils.StringUtils;
import com.waynesun.utils.export.param.ExportParam;
import com.waynesun.utils.export.param.vt.BeanPropertyEPVT;
import com.waynesun.utils.export.param.vt.StringEPVT;
import com.waynesun.common.biz.area.AreaCacheUtils;
import com.waynesun.common.biz.area.CityArea;
import com.waynesun.common.biz.area.ProvinceArea;
import com.waynesun.common.biz.dealer.DealerCacheUtils;
import com.waynesun.common.biz.dealerarea.AbstractDealerArea;
import com.waynesun.common.biz.dealerarea.DealerAreaCacheUtils;
import com.waynesun.common.biz.dealerarea.rel.DealerAreaRel;
import com.waynesun.common.biz.veh.VehicleBrand;
import com.waynesun.common.biz.veh.VehicleBrandCacheUtils;
import com.waynesun.common.web.control.AbstractController;

/**
 * 品牌、大区、省份、城市，网点、级联 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/area_city_casc")
public class AreaCityCascController extends AbstractController {
	
	/**
	 * 获取品牌
	 * @return
	 */
	@RequestMapping(value="/show/brand",method=RequestMethod.POST)
	@ResponseBody
	public String getBrand(HttpServletRequest request,HttpServletResponse response)throws Exception{
		List<VehicleBrand> list = VehicleBrandCacheUtils.getVehicleBrandAllByCache();
		return JsonStringUtils.generateJSONString(list, getParams()); 
	}
	
	/**
	 * 根据品牌获取业务大区
	 * @return
	 */
	@RequestMapping(value="/show/dealer_area",method=RequestMethod.POST)
	@ResponseBody
	public String getDeealerAreaByBrand(HttpServletRequest request,HttpServletResponse response,String brandId)throws Exception{
		List<AbstractDealerArea> list = DealerAreaCacheUtils.getDealerAraea(brandId);
		return JsonStringUtils.generateJSONString(list, getParams()); 
	}
	
	/**
	 * 根据大区获取省份
	 * @return
	 */
	@RequestMapping(value="/show/province",method=RequestMethod.POST)
	@ResponseBody
	public String getProvinceByDealerArea(HttpServletRequest request,HttpServletResponse response,String dealerAreaId)throws Exception{
		List<ProvinceArea> provinceList = new ArrayList<ProvinceArea>();
		if(!StringUtils.isEmpty(dealerAreaId)){
			AbstractDealerArea dealerArea = DaoFactory.getInstance().getQueryDao().get(AbstractDealerArea.class, dealerAreaId, true);
			Set<DealerAreaRel> citySet = dealerArea.getDealerAreaRels();
			for (DealerAreaRel dealerAreaRel : citySet) {
				provinceList.add(dealerAreaRel.getArea());
			}
		}
		List<ExportParam> params = getParams();
		params.add(new ExportParam(new StringEPVT("code"), new BeanPropertyEPVT("code"), ""));
		return JsonStringUtils.generateJSONString(provinceList, params); 
	}
	
	/**
	 * 根据省份获取城市
	 * @return
	 */
	@RequestMapping(value="/show/city",method=RequestMethod.POST)
	@ResponseBody
	public String getCityByProvince(HttpServletRequest request,HttpServletResponse response,String code)throws Exception{
		List<CityArea> cityList = new ArrayList<CityArea>();
		if(!StringUtils.isEmpty(code)){
			ProvinceArea provinceArea = (ProvinceArea)AreaCacheUtils.getAreaByCode(code);
			Set<CityArea> citySet = provinceArea.getCityAreas();
			cityList = new ArrayList<CityArea>(citySet);
		}
		List<ExportParam> params = getParams();
		params.add(new ExportParam(new StringEPVT("code"), new BeanPropertyEPVT("code"), ""));
		return JsonStringUtils.generateJSONString(cityList, params); 
	}
	
	/**
	 * 根据城市获取网点
	 * @return
	 */
	@RequestMapping(value="/show/dealer",method=RequestMethod.POST)
	@ResponseBody
	public String getDealerByCity(HttpServletRequest request,HttpServletResponse response,String cityCode)throws Exception{
		List<ExportParam> params = getParams();
		params.add(new ExportParam(new StringEPVT("dealerCode"), new BeanPropertyEPVT("dealerCode"), ""));
		return JsonStringUtils.generateJSONString(DealerCacheUtils.getDealerByCity(cityCode), params);  
	}
	
	public List<ExportParam> getParams(){
		List<ExportParam> eParams = new ArrayList<ExportParam>();
		eParams.add(new ExportParam(new StringEPVT("name"), new BeanPropertyEPVT("name"), ""));
		eParams.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"), ""));
		return eParams;
	}
}

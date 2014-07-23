package com.ec.website.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.website.param.CaseGroupParam;
import com.ec.website.param.CaseItemParam;
import com.ec.website.param.PartnerGroupParam;
import com.ec.website.param.PartnerParam;
import com.ec.website.param.SolutionParam;
import com.ec.website.param.SolutionSampleParam;

@Controller
@RequestMapping(value = "/about_us")
public class AboutUsController {

	@RequestMapping(value = "/summary")
	public String index(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(0);
		param.setTitle("前言");
		StringBuffer sb = new StringBuffer();
		sb.append("过去，我们一直致力于对极端恶劣环境的控制、不断提升环境控制的标准").append("</br>")
		.append("现在的我们依然坚持不断地探索开发").append("</br>")
		.append("为地球环境、为人类传承").append("</br>")
		.append("因为我们相信……不仅仅是现在").append("</br>")
		.append("在未来，在与恶劣环境抗争的战场，依然会有我们的身影").append("</br>")
		.append("会有更多的人们了解并依赖EC——环境控制的标准制定者和解决方案提供商");

		param.setSubItemInfo(sb.toString());
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "about_us/summary");

		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/news")
	public String index2(HttpServletRequest request, HttpServletResponse response){
		
		SolutionParam param = this.generateParam(1);

		param.setSubItemInfo("优势之选不仅仅体现在产品本身的卓越效果，更体现在每个部件的精工细作以及每个合作伙伴的深厚底蕴。我们产品的核心部分供应商，都是经过历史的积累和沉淀，在各自领域里是绝对领先的代名词。这不仅代表了我们的产品在行业内的顶尖地位，更意味着我们将有条件永不停止的在环境控制领域与时俱进，推陈出新，为客户提供全方位的服务。");
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "about_us/news");
		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/download")
	public String index3(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(2);
		param.setSubItemInfo("");
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "about_us/download");
		return "/template/2ndTemplate.jsp";
	}
	@RequestMapping(value = "/certification")
	public String certification(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(3);
		param.setSubItemInfo("优势之选不仅仅体现在产品本身的卓越效果，更体现在每个部件的精工细作以及每个合作伙伴的深厚底蕴。我们产品的核心部分供应商，都是经过历史的积累和沉淀，在各自领域里是绝对领先的代名词。这不仅代表了我们的产品在行业内的顶尖地位，更意味着我们将有条件永不停止的在环境控制领域与时俱进，推陈出新，为客户提供全方位的服务。");
		param.addSample(new SolutionSampleParam("US. GREEN BUILDING","about_us/certification/logo_1.jpg", "在能源与环境、室内环境质量、创新的设计过程等方面若采用CA产品，能在LEED认证5先决条件和15个credits获得总计超过20分"));
		param.addSample(new SolutionSampleParam("RoHS认证","about_us/certification/logo_2.jpg", "欧盟关于限制在电子电器设备中使用某些有害成分的指令"));
		param.addSample(new SolutionSampleParam("ISO9001: 2008 认证","about_us/certification/logo_3.jpg", ""));
		param.addSample(new SolutionSampleParam("ASHRAE 认证","about_us/certification/logo_4.jpg", ""));
		param.addSample(new SolutionSampleParam("Underwriter Laboratories Inc","about_us/certification/logo_5.jpg", "美国保险商试验所 UL一级防火认证"));
		param.addSample(new SolutionSampleParam("CONFORMITE EUROPEENNE “CE” logo","about_us/certification/logo_6.jpg", "是一种安全认证标志。凡是贴有“CE”标志的产品就可在欧盟各成员国 内销售,无须符合每个成员国的要求,从而实现了商品在欧盟成员国范 围内的自由流通。"));
		param.addSample(new SolutionSampleParam("The Canadian Environmental Certification Mark","about_us/certification/logo_7.jpg", "加拿大环保认证标志"));
		param.addSample(new SolutionSampleParam("Air-Conditioning, Heating, and Refrigeration Institute","about_us/certification/logo_8.jpg", "美国空调、供热及制冷工业协会 成员 2008年1月1日,美国空调制冷协会(ARI)与美国气体设备生产商协会(GAMA) 合二为一,组建成规模更大、实力更强的空调供热制冷协会(AHRI)。"));
		
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "about_us/certification");
		return "/template/2ndTemplate.jsp";
	}
	@RequestMapping(value = "/global_map")
	public String globalMap(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(4);
		
		param.setSubItemInfo("优势之选不仅仅体现在产品本身的卓越效果，更体现在每个部件的精工细作以及每个合作伙伴的深厚底蕴。我们产品的核心部分供应商，都是经过历史的积累和沉淀，在各自领域里是绝对领先的代名词。这不仅代表了我们的产品在行业内的顶尖地位，更意味着我们将有条件永不停止的在环境控制领域与时俱进，推陈出新，为客户提供全方位的服务。");

		List<PartnerGroupParam> groupParams =  new ArrayList<PartnerGroupParam>();
		PartnerGroupParam groupParam = new PartnerGroupParam("北美洲");
		groupParam.addPartnerParam(new PartnerParam("思科系统", "img/about_us/global_map/us/1.jpg"));
		groupParam.addPartnerParam(new PartnerParam("旧金山机场", "img/about_us/global_map/us/2.jpg"));
		groupParam.addPartnerParam(new PartnerParam("世通公司", "img/about_us/global_map/us/3.jpg"));
		groupParam.addPartnerParam(new PartnerParam("美国肯尼迪图书馆", "img/about_us/global_map/us/4.jpg"));
		groupParam.addPartnerParam(new PartnerParam("埃克森美孚", "img/about_us/global_map/us/5.jpg"));
		groupParam.addPartnerParam(new PartnerParam("IBM国际商业机器", "img/about_us/global_map/us/6.jpg"));
		groupParam.addPartnerParam(new PartnerParam("华盛顿杜勒斯国际机场", "img/about_us/global_map/us/7.jpg"));
		groupParam.addPartnerParam(new PartnerParam("北电网络", "img/about_us/global_map/us/8.jpg"));
		groupParam.addPartnerParam(new PartnerParam("帝国石油公司", "img/about_us/global_map/us/9.jpg"));
		groupParam.addPartnerParam(new PartnerParam("斯普林特", "img/about_us/global_map/us/10.jpg"));
		groupParam.addPartnerParam(new PartnerParam("美国舰船", "img/about_us/global_map/us/11.jpg"));
		groupParam.addPartnerParam(new PartnerParam("加拿大贝尔直升机", "img/about_us/global_map/us/12.jpg"));
		groupParam.addPartnerParam(new PartnerParam("多伦多城市控制", "img/about_us/global_map/us/13.jpg"));
		groupParam.addPartnerParam(new PartnerParam("安大略水电能源", "img/about_us/global_map/us/14.jpg"));
		groupParam.addPartnerParam(new PartnerParam("加拿大辛克鲁德油砂能源开采企业", "img/about_us/global_map/us/15.jpg"));
		groupParam.addPartnerParam(new PartnerParam("蒙特利尔 皮埃尔·埃利奥特·特鲁多国际机场", "img/about_us/global_map/us/16.jpg"));
		groupParams.add(groupParam);

		groupParam = new PartnerGroupParam("欧洲");
		groupParam.addPartnerParam(new PartnerParam("依必安派特风机", "img/about_us/global_map/europe/1.jpg"));
		groupParam.addPartnerParam(new PartnerParam("雪铁龙股份", "img/about_us/global_map/europe/2.jpg"));
		groupParam.addPartnerParam(new PartnerParam("瑞士日内瓦基督教青年会", "img/about_us/global_map/europe/3.jpg"));
		groupParam.addPartnerParam(new PartnerParam("沙特阿拉伯石油", "img/about_us/global_map/europe/4.jpg"));
		groupParams.add(groupParam);

		groupParam = new PartnerGroupParam("亚洲");
		groupParam.addPartnerParam(new PartnerParam("爱美克空气过滤器", "img/about_us/global_map/asia/1.jpg"));
		groupParam.addPartnerParam(new PartnerParam("爱立信通信", "img/about_us/global_map/asia/2.jpg"));
		groupParams.add(groupParam);
		
		
		

		request.setAttribute("groupParams", groupParams);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "about_us/globalMap");
		return "/template/2ndTemplate.jsp";
	}
	@RequestMapping(value = "/case_list")
	public String caseList(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(5);
		param.setSubItemInfo("优势之选不仅仅体现在产品本身的卓越效果，更体现在每个部件的精工细作以及每个合作伙伴的深厚底蕴。我们产品的核心部分供应商，都是经过历史的积累和沉淀，在各自领域里是绝对领先的代名词。这不仅代表了我们的产品在行业内的顶尖地位，更意味着我们将有条件永不停止的在环境控制领域与时俱进，推陈出新，为客户提供全方位的服务。");
		
		List<CaseGroupParam> groupParams =  new ArrayList<CaseGroupParam>();
		this.addCaseGroupParam(groupParams, "纸浆厂");
		this.addCaseGroupParam(groupParams, "机场");
		this.addCaseGroupParam(groupParams, "石油化工工业");
		this.addCaseGroupParam(groupParams, "有毒气体处理");
		this.addCaseGroupParam(groupParams, "商业建筑");
		this.addCaseGroupParam(groupParams, "其它");
		this.addCaseGroupParam(groupParams, "化工领域");
		this.addCaseGroupParam(groupParams, "臭味控制");
		this.addCaseGroupParam(groupParams, "钢铁");

		request.setAttribute("groupParams", groupParams);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "about_us/caseList");
		return "/template/2ndTemplate.jsp";
	}
	private void addCaseGroupParam(List<CaseGroupParam> groupParams,String groupName){
		CaseGroupParam groupParam = new CaseGroupParam(groupName);
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("阿维娜公司", "魁北克和安大略", "高浓度气体洗涤剂净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("阿维娜公司", "魁北克和安大略", "高浓度气体洗涤剂净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("阿维娜公司", "魁北克和安大略", "高浓度气体洗涤剂净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("阿维娜公司", "魁北克和安大略", "高浓度气体洗涤剂净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("阿维娜公司", "魁北克和安大略", "高浓度气体洗涤剂净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("阿维娜公司", "魁北克和安大略", "高浓度气体洗涤剂净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("阿维娜公司", "魁北克和安大略", "高浓度气体洗涤剂净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("阿维娜公司", "魁北克和安大略", "高浓度气体洗涤剂净化机组", "计算机腐蚀控制"));
		
	}
	public SolutionParam generateParam(int subItemIndex){
		SolutionParam param = new SolutionParam();
		param.setHeaderPicName("about_us.jpg");
		param.setSubItemTitle("关于EC");
		param.setSubItemHeaderImgInfo("多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。");
		param.addSubItem("公司简介", "about_us/summary.html");
		param.addSubItem("新闻及公告", "about_us/news.html");
		param.addSubItem("资料下载", "about_us/download.html");
		param.addSubItem("认证及资质", "about_us/certification.html");
		param.addSubItem("国际合作", "about_us/global_map.html");
		param.addSubItem("我们的客户", "about_us/case_list.html");
		param.setActiveSubItem(param.getSubItems().get(subItemIndex).getName());
		param.setTitle(param.getActiveSubItem());
		return param;
	}
}

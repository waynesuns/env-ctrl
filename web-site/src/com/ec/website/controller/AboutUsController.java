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
public class AboutUsController extends AbstractController{

	@RequestMapping(value = "/summary")
	public String summary(HttpServletRequest request, HttpServletResponse response){
		

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
		CaseGroupParam groupParam = new CaseGroupParam("有毒气体处理");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "安大略史密斯维拉焚化厂", "高浓度气体洗涤器净化机组", "PCB废气"));
		groupParam.addItem(new CaseItemParam("", "化学安全公司", "深床式气相净化机组", "PCB废气"));
		groupParam.addItem(new CaseItemParam("", "东塔纸业有限公司", "高浓度气体洗涤器净化机组", "氯气控制"));

		groupParam = new CaseGroupParam("臭味控制");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "洛斯废水处理厂", "受控增压单元/高浓度气体洗涤器净化机组", "气味/计算机腐蚀控制/气味处理控制"));
		groupParam.addItem(new CaseItemParam("", "卡尔加里市", "高浓度气体洗涤器净化机组", "气味处理控制"));
		groupParam.addItem(new CaseItemParam("", "温尼伯污水处理厂", "高浓度气体洗涤器净化机组/受控增压单元", "气味处理控制/计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "苏圣玛丽市", "高浓度气体洗涤器净化机组/受控增压单元", "有气味废气"));
		groupParam.addItem(new CaseItemParam("", "桑德贝市", "高浓度气体洗涤器净化机组", "气味控制"));
		groupParam.addItem(new CaseItemParam("", "伊莱佩罗过滤厂", "深床式气相净化机组", "气味控制"));
		groupParam.addItem(new CaseItemParam("", "香港排水服务部门", "深床式气相净化机组/高浓度气体洗涤器净化机组", "通用侧开门系列	气味控制"));
		groupParam.addItem(new CaseItemParam("", "爱芬食品", "深床式气相净化机组", "气味控制"));
		groupParam.addItem(new CaseItemParam("", "布朗福尔曼实验室", "深床式气相净化机组", "气味控制/味测试实验室"));
		groupParam.addItem(new CaseItemParam("", "香港Sam Shing污水泵站", "高浓度气体洗涤器净化机组", "气味处理控制"));
		groupParam.addItem(new CaseItemParam("", "上海金京路污水泵站", "高浓度气体洗涤器净化机组", "气味处理控制"));
		

		groupParam = new CaseGroupParam("化工领域");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "Ireland F.M. Marr 公司", "气箱", "源捕获气味控制"));
		groupParam.addItem(new CaseItemParam("", "卡塔尔化肥公司", "受控增压单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "宾尼沃尔特公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "康塞公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "欧科公司", "通用侧开门系列", "废气气味控制"));
		groupParam.addItem(new CaseItemParam("", "皮特蒙特公司", "受控增压单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "卡博化学公司", "受控再循环单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "萨斯卡通化学公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "奥尔布赖特威尔森公司", "高浓度气体洗涤器净化机组/深床式气相净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "南京扬子巴斯夫", "深床式气相净化机组", "计算机腐蚀控制"));

		groupParam = new CaseGroupParam("石油化工工业");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "台湾中石油", "深床式气相净化机组/CPU/CRU", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "壳牌石油", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "埃索石油公司", "受控增压单元", "行政办公楼气味控制"));
		groupParam.addItem(new CaseItemParam("", "辛克鲁德公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "科威特石油公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "加拿大石油公司", "受控增压及再循环单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "森科能源公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "西海岸能源公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));

		groupParam = new CaseGroupParam("钢铁");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "加拿大多法斯科公司", "高浓度气体洗涤器净化机组/受控增压单元/受控再循环单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "阿尔戈马钢铁公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "雷诺兹公司", "模块化单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "加拿大铝业公司", "模块化单元", "计算机腐蚀控制"));

		groupParam = new CaseGroupParam("纸浆厂");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "阿派克公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "阿维娜公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "考陶尔纤维", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "乌塔码公司", "深床式气相净化机组/CPU/CRU", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "麦克拉伦公司", "高浓度气体洗涤器净化机组", "衣帽间气味控制"));
		groupParam.addItem(new CaseItemParam("", "东塔纸业", "高浓度气体洗涤器净化机组", "废/污水处理区域"));
		groupParam.addItem(new CaseItemParam("", "天柏公司", "受控再循环单元", "行政办公楼气味控制"));
		groupParam.addItem(new CaseItemParam("", "惠好纸业公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "大昭和纸业", "高浓度气体洗涤器净化机组", ""));
		groupParam.addItem(new CaseItemParam("", "斯科特纸业", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "联盟坎普", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "沙巴森林制品", "高浓度气体洗涤器净化机组/通用侧开门系列", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "米德纸业", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "盖洛德公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "国际纸业", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "冠军纸业", "高浓度气体洗涤器净化机组", "电脑板储存设施"));
		groupParam.addItem(new CaseItemParam("", "斯托拉森林制品", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "欧文造纸厂", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "山东亚泰森博浆纸", "深床式气相净化机组", "计算机腐蚀控制"));
		groupParam = new CaseGroupParam("机场");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "华盛顿杜勒斯国际机场", "通用侧开门系列", "户外空气净化，去处碳氢化合物、Nox、SO2、 O3（主航站楼）"));
		groupParam.addItem(new CaseItemParam("", "旧金山国际机场航站楼A和G", "通用侧开门系列", "户外空气净化，去处碳氢化合物、Nox、SO2、 O3（主航站楼）"));
		groupParam.addItem(new CaseItemParam("", "蒙特利尔多瓦尔国际机场", "通用侧开门系列", "户外空气净化，去处碳氢化合物、Nox、SO2、 O3（控制塔）"));
		groupParam.addItem(new CaseItemParam("", "庞巴迪集团机场办公大楼", "深床式气相净化机组", "户外空气净化，去处碳氢化合物、Nox、SO2、 O3（主办公大楼）"));
		groupParam.addItem(new CaseItemParam("", "庞巴迪集团支线飞机生产厂", "深床式气相净化机组", "常用溶剂，去处油漆废气的挥发性有机物，产生100%再循环"));
		groupParam = new CaseGroupParam("商业建筑");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "乔治亚国际会议及贸易中心", "通用侧开门系列", "室内空气质量控制"));
		groupParam.addItem(new CaseItemParam("", "萨拉索塔纪念中心，急救护理中心", "模块化单元", "户外空气进气过滤"));
		groupParam.addItem(new CaseItemParam("", "布鲁克林植物园", "模块化单元", "档案保存"));
		groupParam.addItem(new CaseItemParam("", "卡尔顿美术馆", "模块化单元", "档案保存"));
		groupParam.addItem(new CaseItemParam("", "昆士茅特公立学校", "模块化单元", "档案保存"));
		groupParam.addItem(new CaseItemParam("", "费尔斯通档案馆", "模块化单元", "档案保存"));
		groupParam.addItem(new CaseItemParam("", "渥太华艺术宫", "模块化单元", "档案保存"));
		groupParam = new CaseGroupParam("其他");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "菲尔普斯道奇莫伦西矿业公司", "高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "贝尔县法医鉴定中心", "通用侧开门系列", "甲醛气体控制"));
		groupParam.addItem(new CaseItemParam("", "科尼精密有限公司", "模块化单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "冶炼厂", "模块化单元", "气味控制"));
		groupParam.addItem(new CaseItemParam("", "加拿大多法斯科公司", "模块化单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "东元电机", "气箱", "有毒气体控制"));
				
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
		
	}
	public SolutionParam generateParam(int subItemIndex){
		SolutionParam param = new SolutionParam();
		param.setHeaderPicName("about_us");
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

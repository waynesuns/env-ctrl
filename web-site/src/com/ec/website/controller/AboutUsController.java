package com.ec.website.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.website.param.CaseGroupParam;
import com.ec.website.param.CaseItemParam;
import com.ec.website.param.ImageParam;
import com.ec.website.param.PartnerGroupParam;
import com.ec.website.param.PartnerParam;
import com.ec.website.param.SolutionParam;
import com.ec.website.param.SolutionSampleParam;
import com.ec.website.param.group.DivGroupParam;
import com.ec.website.param.group.ImageGroupParam;
import com.ec.website.param.group.MainGroupParam;
import com.ec.website.param.group.OlGroupParam;

@Controller
@RequestMapping(value = "/about_us")
public class AboutUsController extends AbstractController{

	@RequestMapping(value = "/summary")
	public String summary(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(0);
		//param.setTitle("前言");
		//StringBuffer sb = new StringBuffer();
		//sb.append("过去，我们一直致力于对极端恶劣环境的控制、不断提升环境控制的标准").append("</br>")
		//.append("现在的我们依然坚持不断地探索开发").append("</br>")
		//.append("为地球环境、为人类传承").append("</br>")
		//.append("因为我们相信……不仅仅是现在").append("</br>")
		//.append("在未来，在与恶劣环境抗争的战场，依然会有我们的身影").append("</br>")
		//.append("会有更多的人们了解并依赖EC——环境控制的标准制定者和解决方案提供商");

		//param.setSubItemInfo(sb.toString());
		param.setSubItemInfo(""); 
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "about_us/summary");

		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/news")
	public String index2(HttpServletRequest request, HttpServletResponse response){
		
		SolutionParam param = this.generateParam(5);

		param.setSubItemInfo("优势之选不仅仅体现在产品本身的卓越效果，更体现在每个部件的精工细作以及每个合作伙伴的深厚底蕴。我们产品的核心部分供应商，都是经过历史的积累和沉淀，在各自领域里是绝对领先的代名词。这不仅代表了我们的产品在行业内的顶尖地位，更意味着我们将有条件永不停止的在环境控制领域与时俱进，推陈出新，为客户提供全方位的服务。");
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "about_us/news");
		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/download")
	public String index3(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(1);
		param.setSubItemInfo("");
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "about_us/download");
		return "/template/2ndTemplate.jsp";
	}
	@RequestMapping(value = "/certification")
	public String certification(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(2);

		param.setSubItemInfo("IIECC在不断发展的历程中，已与多家行业领袖级企业联手合作，并加入了一系列国际性行业协会，多方探讨、共同进步。此外，IIECC更凭借卓越的产品性能，顺利通过国内多家权威机构的检测认证，更成功获得多项国际专业认证。");
		param.addSample(new SolutionSampleParam("US. GREEN BUILDING","about_us/certification/logo_1.jpg", "在能源与环境、室内环境质量、创新的设计过程等方面若采用CA产品，能在LEED认证5先决条件和15个credits获得总计超过20分。"));
		param.addSample(new SolutionSampleParam("RoHS认证","about_us/certification/logo_2.jpg", "Restriction of Hazardous Substances</br>欧盟关于限制在电子电器设备中使用某些有害成分的指令。"));
		param.addSample(new SolutionSampleParam("ISO9001: 2008 认证","about_us/certification/logo_3.jpg", "ISO9001:2008标准是根据世界上170个国家大约100万个通过ISO9001认证的组织的8年实践，更清晰、明确地表达ISO9001:2000的要求，并增强与ISO14001:2004的兼容性。"));
		param.addSample(new SolutionSampleParam("ASHRAE 认证","about_us/certification/logo_4.jpg", "American Society of Heating, Refrigerating and Air-Conditioning Engineers, Inc</br>美国采暖、制冷与空调工程师学会认证。"));
		param.addSample(new SolutionSampleParam("Underwriter Laboratories Inc","about_us/certification/logo_5.jpg", "美国保险商试验所 UL一级防火认证"));
		param.addSample(new SolutionSampleParam("CE认证","about_us/certification/logo_6.jpg", "CONFORMITE EUROPEENNE “Ce”标志是一种安全认证标志。</br>凡是贴有“CE”标志的产品就可在欧盟各成员国内销售，无须符合每个成员国的要求，从而实现了商品在欧盟成员国范围内的自由流通。"));
		param.addSample(new SolutionSampleParam("The Canadian Environmental Certification Mark","about_us/certification/logo_7.jpg", "加拿大环保认证标志"));
		param.addSample(new SolutionSampleParam("ebmpapst GREENTECH认证","about_us/certification/logo_9.png", "满足欧盟为能源动力制定的最严格的能源要求。"));
		
		param.addSample(new SolutionSampleParam("中国质量认证中心","about_us/certification/logo_12.png", "安全与电磁兼容认证"));
		param.addSample(new SolutionSampleParam("中国质量认证中心","about_us/certification/logo_13.png", "除菌认证"));
		param.addSample(new SolutionSampleParam("中国质量认证中心","about_us/certification/logo_14.png", "节能产品认证"));
		param.addSample(new SolutionSampleParam("中国质量认证中心","about_us/certification/logo_15.png", "环保产品认证"));
		param.addSample(new SolutionSampleParam("ISO9001认证","about_us/certification/logo_16.png", ""));
		
		
		SolutionParam guild = this.generateParam(2);
		guild.setTitle("行业协会");
		guild.setSubItemInfo("IIECC加入了行业内多个的专业级协会，并参与国际标准的制定，对行业的未来起着重要作用。");
		guild.addSample(new SolutionSampleParam("American Society of Heating, Refrigerating and Air-Conditioning Engineers, Inc","about_us/certification/logo_4.jpg", "美国采暖、制冷与空调工程师学会 成员</br>* 参与ASHRAE 62.1-2013中关于室内空气过滤质量标准的制定。"));
		guild.addSample(new SolutionSampleParam("Air-Conditioning, Heating, and Refrigeration Institute","about_us/certification/logo_8.jpg", "美国空调、供热及制冷工业协会 成员</br>2008年1月1日，美国空调制冷协会（ARI）与美国气体设备生产商协会（GAMA）合二为一，组建成规模更大、实力更强的空调供热制冷协会（AHRI）。"));
		guild.addSample(new SolutionSampleParam("U.S Green Building Council","about_us/certification/logo_1.jpg", "美国绿色建筑委员会 会员"));
		guild.addSample(new SolutionSampleParam("The Asian American Hotel Owners Association","about_us/certification/logo_10.png", "亚裔美国人酒店业主联合会 成员"));
		guild.addSample(new SolutionSampleParam("Home Ventilating Institute","about_us/certification/logo_11.png", "住宅通风协会 成员"));
		
		request.setAttribute("solutionParam", param);
		request.setAttribute("guildParam", guild);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "about_us/certification");
		return "/template/2ndTemplate.jsp";
	}
	@RequestMapping(value = "/global_map")
	public String globalMap(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(3);
		
		param.setSubItemInfo("为打造出更具竞争力的优秀产品，IIECC与诸多国际一流的大型企业开展了广泛而长远的技术合作。互通资讯、吸收经验，并将最新科技与合作成果，成功应用至多元产品系列中。");

		List<PartnerGroupParam> groupParams =  new ArrayList<PartnerGroupParam>();
		PartnerGroupParam groupParam = new PartnerGroupParam("北美洲");
		groupParam.addPartnerParam(new PartnerParam("加拿大Circul-Aire", "img/about_us/global_map/us/17.png"));
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
		groupParam.addPartnerParam(new PartnerParam("爱立信通信", "img/about_us/global_map/asia/2.jpg"));
		groupParams.add(groupParam);

		groupParam = new PartnerGroupParam("亚洲");
		groupParam.addPartnerParam(new PartnerParam("爱美克空气过滤器", "img/about_us/global_map/asia/1.jpg"));
		groupParam.addPartnerParam(new PartnerParam("韩国spe", "img/about_us/global_map/asia/3.png"));
		groupParam.addPartnerParam(new PartnerParam("沙特阿拉伯石油", "img/about_us/global_map/europe/4.jpg"));
		groupParams.add(groupParam);
		
		
		

		request.setAttribute("groupParams", groupParams);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "about_us/globalMap");
		return "/template/2ndTemplate.jsp";
	}
	@RequestMapping(value = "/case_list")
	public String caseList(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(4);
		param.setSubItemInfo("为满足企业等用户日趋迫切的气体净化需求，IIECC向来自多个行业类别的客户，提供了具有针对性的专业环境控制解决方案及节能环保产品，且成效显著。");
		
		List<CaseGroupParam> groupParams =  new ArrayList<CaseGroupParam>();
		CaseGroupParam groupParam = new CaseGroupParam("工业类客户");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "Chinese Petroleum Corp.</br>中国台湾中华石油", "DAS深床式气相净化机组</br>CPU受控增压单元</br>CRU受控再循环单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Shell Oil</br>新奥尔良壳牌石油（加拿大/美国）", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Esso Oil</br>加拿大埃索石油公司", "CPU受控增压单元", "行政办公楼气味控制"));
		groupParam.addItem(new CaseItemParam("", "Syncrude</br>加拿大辛克鲁德公司", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Kuwait Oil Company</br>科威特石油公司", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Petro Canada</br>加拿大石油公司", "CPU受控增压单元</br>CRU受控再循环单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Suncor</br>加拿大森科能源公司", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "West Coast Energy</br>加拿大西海岸能源公司", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Dofasco</br>加拿大多法斯科公司", "HDS 高浓度气体洗涤器净化机组</br>CPU受控增压单元</br>CRU受控再循环单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Algoma Steel</br>加拿大阿尔戈马钢铁公司", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Reynolds</br>加拿大雷诺兹公司", "Modular Unit 模块化单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Alcan</br>加拿大加拿大铝业公司", "Modular Unit 模块化单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Phelps Dodge Morenci Crusher</br>美国亚利桑那州菲尔普斯道奇莫伦西矿业公司", "HDS 高浓度气体洗涤器净化机组</br>CRU受控再循环单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Aluminerie Bécancourt</br>加拿大冶炼厂", "Modular Unit 模块化单元", "气味控制"));
		groupParam.addItem(new CaseItemParam("", "F.M. Marr</br>爱尔兰F.M. Marr公司", "Airbox 气箱", "源捕获气味控制"));
		groupParam.addItem(new CaseItemParam("", "Qafco</br>卡塔尔化肥公司", "CPU受控增压单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Pennwalt</br>美国华盛顿州宾尼沃尔特公司", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Conserv</br>美国佛罗里达州康塞公司", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Erco</br>加拿大欧科公司", "USAH 通用侧开门系列", "废气气味控制"));
		groupParam.addItem(new CaseItemParam("", "Petromont</br>加拿大皮特蒙特公司", "CPU受控增压单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Carbochem</br>加拿大卡博化学公司", "CPU受控增压单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Saskatoon Chemicals</br>加拿大萨斯卡通化学公司", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Albright Wilson</br>加拿大奥尔布赖特威尔森公司", "DAS 深床式气相净化机组</br>HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "BASF-YPC</br>中国南京扬子巴斯夫", "DAS 深床式气相净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Chem Security</br>加拿大化学安全公司", "DAS 深床式气相净化机组", "PCB废气"));
		groupParam.addItem(new CaseItemParam("", "Kony Precision</br>韩国科尼精密有限公司", "Modular Unit 模块化单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Teco Electric</br>中国台湾东元电机", "Airbox 气箱", "有毒气体控制"));
		groupParam.addItem(new CaseItemParam("", "Alpac</br>加拿大阿派克公司", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Avenor</br>加拿大阿维娜公司", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Courtaulds Fibers</br>美国阿拉巴马州考陶尔纤维", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Inti Indorayon Utama</br>印度尼西亚乌塔码公司", "DAS深床式气相净化机组</br>CPU受控增压单元</br>CRU受控再循环单元", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "MacLaren</br>加拿大麦克拉伦公司", "HDS 高浓度气体洗涤器净化机组", "衣帽间气味控制"));
		groupParam.addItem(new CaseItemParam("", "Domtar</br>加拿大东塔纸业", "HDS 高浓度气体洗涤器净化机组", "废</br>污水处理区域"));
		groupParam.addItem(new CaseItemParam("", "Tembec</br>加拿大天柏公司", "CRU受控再循环单元", "行政办公楼气味控制"));
		groupParam.addItem(new CaseItemParam("", "Weyerhaeuser</br>加拿大惠好纸业公司", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Daishowa Paper</br>加拿大和美国大昭和纸业", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Scott Paper</br>斯科特纸业（加拿大/美国/意大利/法国/西班牙）", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Union Camp</br>美国阿拉巴马州联盟坎普", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Sabah Forest Products</br>马来西亚沙巴森林制品", "HDS 高浓度气体洗涤器净化机组</br>USAH 通用侧开门系列", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Mead Paper</br>美国阿拉巴马州米德纸业", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Gaylord</br>美国路易斯安那州盖洛德公司", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "International Paper</br>美国阿拉巴马州国际纸业", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Champion Paper</br>加拿大冠军纸业", "HDS 高浓度气体洗涤器净化机组", "电脑板储存设施"));
		groupParam.addItem(new CaseItemParam("", "Stora Forest Products</br>加拿大斯托拉森林制品", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Irving Pulp & Paper</br>加拿大欧文造纸厂", "HDS 高浓度气体洗涤器净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Asiasymbol</br>中国山东亚泰森博浆纸", "DAS 深床式气相净化机组", "计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "Domtar</br>加拿大东塔纸业有限公司", "HDS 高浓度气体洗涤器净化机组", "氯气控制"));
		groupParam.addItem(new CaseItemParam("", "Riau Andalan Pulp & Paper, Indonesia</br>印度尼西亚Riau Andalan 纸浆造纸厂", "DAS 深床式气相净化机组</br>APS 小型气相净化机组", "PCB废气</br>空气净化"));

		groupParam = new CaseGroupParam("市政类");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "Washington Dulles International Airport</br>美国弗吉尼亚州华盛顿杜勒斯国际机场", "USAH 通用侧开门系列", "户外空气净化，去处碳氢化合物、NO<SUB>X</SUB>、SO<SUB>2</SUB>、 O<SUB>3</SUB>（主航站楼）"));
		groupParam.addItem(new CaseItemParam("", "San Francisco International Airport, Terminal A and G</br>美国加州旧金山国际机场航站楼A和G", "MC 单元", "户外空气净化，去处碳氢化合物、NO<SUB>X</SUB>、SO<SUB>2</SUB>、 O<SUB>3</SUB>（主航站楼）"));
		groupParam.addItem(new CaseItemParam("", "Montreal Dorval International Airport</br>加拿大蒙特利尔多瓦尔国际机场", "USAH 通用侧开门系列", "户外空气净化，去处碳氢化合物、NO<SUB>X</SUB>、SO<SUB>2</SUB>、 O<SUB>3</SUB>（控制塔）"));
		groupParam.addItem(new CaseItemParam("", "Canadair Bombardier Group Airport Office Tower</br>加拿大庞巴迪集团机场办公大楼", "DAS 深床式气相净化机组", "户外空气净化，去处碳氢化合物、NO<SUB>X</SUB>、SO<SUB>2</SUB>、 O<SUB>3</SUB>（主办公大楼）"));
		groupParam.addItem(new CaseItemParam("", "Canadair Bombardier Group Regional Jet Production</br>加拿大庞巴迪集团支线飞机生产厂", "DAS 深床式气相净化机组", "去处油漆废气的挥发性有机物"));
		groupParam.addItem(new CaseItemParam("", "The Reno Tahoe International Airport, NV</br>美国华达州里诺市⁄太浩湖国际机场", "TMP Series 空气净化系统", "空气净化"));
		groupParam.addItem(new CaseItemParam("", "Smithville Incineration Plant</br>加拿大史密斯维拉焚化厂", "HDS 高浓度气体洗涤器净化机组", "PCB废气"));
		groupParam.addItem(new CaseItemParam("", "Los Alisos Waste Water Treatment Plant</br>美国加州洛斯废水处理厂", "CPU受控增压单元", "气味</br>计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "City of Calgary</br>加拿大卡尔加里市", "HDS 高浓度气体洗涤器净化机组", "气味处理控制"));
		groupParam.addItem(new CaseItemParam("", "Winnipeg Sewage Treatment Plant</br>加拿大温尼伯污水处理厂", "HDS 高浓度气体洗涤器净化机组</br>CRU受控再循环单元", "气味处理控制</br>计算机腐蚀控制"));
		groupParam.addItem(new CaseItemParam("", "City of Sault Ste-Marie</br>加拿大苏圣玛丽市", "HDS 高浓度气体洗涤器净化机组</br>CPU受控增压单元", "有气味废气"));
		groupParam.addItem(new CaseItemParam("", "City of Thunder Bay</br>加拿大桑德贝市", "HDS 高浓度气体洗涤器净化机组", "气味控制"));
		groupParam.addItem(new CaseItemParam("", "Ile Perrot Filtration Plant</br>加拿大伊莱佩罗过滤厂", "DAS 深床式气相净化机组", "气味控制"));
		groupParam.addItem(new CaseItemParam("", "City of Hong Kong Drainage Services Dept.</br>中国香港排水服务部门", "DAS 深床式气相净化机组</br>HDS 高浓度气体洗涤器净化机组</br>USAH 通用侧开门系列", "气味控制"));
		groupParam.addItem(new CaseItemParam("", "Effem Foods</br>加拿大爱芬食品", "DAS 深床式气相净化机组", "气味控制"));
		groupParam.addItem(new CaseItemParam("", "Brown Foreman Laboratories</br>美国肯塔基州布朗福尔曼实验室", "Modular Unit 模块化单元", "气味控制</br>味测试实验室"));
		groupParam.addItem(new CaseItemParam("", "Sam Shing Sewage Treatment Plant</br>中国香港Sam Shing污水泵站", "HDS 高浓度气体洗涤器净化机组", "气味处理控制"));
		groupParam.addItem(new CaseItemParam("", "Jinjing Sewage Pump Station</br>上海金京路污水泵站", "HDS 高浓度气体洗涤器净化机组", "气味处理控制"));
		groupParam.addItem(new CaseItemParam("", "British Columbia Hydro</br>哥伦比亚不列颠哥伦比亚省温哥华市电厂", "APS 小型气相净化机组", "空气净化"));
		groupParam.addItem(new CaseItemParam("", "West Side Waste Water Treatment Plant, Bridgeport, CT</br>美国康涅狄格州布里奇波特市西区污水处理厂", "Custom Air Handling Unit 客户定制空气处理机组", "空气过滤"));
		

		groupParam = new CaseGroupParam("商业类");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "Harrah's Casino, Summit View Lounge, Lake Tahoe, NV</br>美国内华达州太浩湖海瑞斯赌场高层观光大厅", "APS 小型气相净化机组", "空气净化"));
		groupParam.addItem(new CaseItemParam("", "Jumeirah Beach Hotel, Dubai</br>迪拜朱美拉海滩酒店", "APS 小型气相净化机组", "空气净化"));
		groupParam.addItem(new CaseItemParam("", "Jin Mao Tower, Shanghai</br>中国上海金茂大厦", "APS 小型气相净化机组", "空气净化"));
		groupParam.addItem(new CaseItemParam("", "Tomson Riviera etc.</br>北京丽都、北京丽宫、汤臣一品等高端社区", "APS 小型气相净化机组", "空气净化"));

		groupParam = new CaseGroupParam("其他");
		groupParams.add(groupParam);
		groupParam.addItem(new CaseItemParam("", "Primary Learning Center - Dade County School Board, Miami, Florida</br>美国佛罗里达州迈阿密市戴德郡学校", "APS 小型气相净化机组", "空气净化"));
		groupParam.addItem(new CaseItemParam("", "George Bush Presidential Library & Museum, College Station,Texas</br>美国德克萨斯州大学城，乔治布什总统图书馆博物院", "APS 小型气相净化机组</br>USAH 通用侧开门系列", "空气净化"));
		groupParam.addItem(new CaseItemParam("", "University of Ottawa - Dissection Room 117, Gendron Hall</br>加拿大渥太华大学 – 霍尔根德伦科学工程学院", "APS 小型气相净化机组", "空气净化"));
		groupParam.addItem(new CaseItemParam("", "Queensmount Public School</br>加拿大昆士茅特公立学校", "Modular Unit 模块化单元", "档案保存"));
		groupParam.addItem(new CaseItemParam("", "Firestone Archives</br>加拿大费尔斯通档案馆", "Modular Unit 模块化单元", "档案保存"));
		groupParam.addItem(new CaseItemParam("", "Ottawa Art Court</br>加拿大渥太华艺术宫", "Modular Unit 模块化单元", "档案保存"));
		groupParam.addItem(new CaseItemParam("", "Georgia International Convention & Trade Center</br>美国乔治亚国际会议及贸易中心", "USAH 通用侧开门系列", "室内空气质量控制"));
		groupParam.addItem(new CaseItemParam("", "Brooklyn Botanic Garden</br>美国纽约布鲁克林植物园", "Modular Unit 模块化单元", "档案保存"));
		groupParam.addItem(new CaseItemParam("", "Carleton Art Gallery</br>加拿大卡尔顿美术馆", "Modular Unit 模块化单元", "档案保存"));
		groupParam.addItem(new CaseItemParam("", "Kansas City Zoo, Missouri</br>美国密苏里州堪萨斯市立动物园 ", "Custom Air Handling Unit 客户定制空气处理机组", "空气处理及净化 "));
		groupParam.addItem(new CaseItemParam("", "Forensic Pathology Laboratory, Toronto</br>加拿大多伦多法医病理实验室", "APS 小型气相净化机组", "空气净化"));
		groupParam.addItem(new CaseItemParam("", "Bexar County Forensic Science Center</br>美国贝尔县法医鉴定中心", "USAH 通用侧开门系列", "甲醛气体控制"));
		groupParam.addItem(new CaseItemParam("", "Washoe Medical Center - Reno, Nevada</br>美国内华达州里诺市肖沃医疗中心", "APS 小型气相净化机组</br>USAH 通用侧开门系列", "空气净化"));
		groupParam.addItem(new CaseItemParam("", "Sarasota Memorial Center,Critical Care Center</br>美国佛罗里达州萨拉索塔纪念中心，急救护理中心", "Modular Unit 模块化单元", "户外空气进气过滤"));

		request.setAttribute("groupParams", groupParams);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "about_us/caseList");
		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/20140930_apic")
	public String multiMix(HttpServletRequest request,
			HttpServletResponse response) {
		SolutionParam param = this.generateParam("中国空气质量现状");

		List<MainGroupParam> details = new 	ArrayList<MainGroupParam>();
		details.add((new MainGroupParam(null,null))
				//.addValue(new RowGroupParam(null, null)

					.addValue(new DivGroupParam("现状", ""))
					.addValue(new DivGroupParam(null, "1952年12月4日，伦敦城发生了世界上最为严重的“烟雾”事件：来自工厂和住户的烟尘与气体在低空大量聚积，近一周不散，整个城市雾霾极为严重。成千上万受害者因此罹患支气管炎、气喘等呼吸系统疾病。当12月10日烟雾终于散去时，已有约四千人死亡。"))
					.addValue(new DivGroupParam(null, "二战后的美国也曾因工业飞速发展、化石能源消耗量激增，遭受严重大气污染。其中，1952年的光化学烟雾事件曾使洛杉矶四百多位65岁以上的老人死亡。"))
					.addValue(new DivGroupParam(null, "而同样的问题，正在中国上演……"))
					.addValue(new DivGroupParam(null, "中国人民大学环境学院等机构2013年3月发布的《中国城市空气质量管理绩效评估》结果显示，中国只有10.67%的城市空气质量好，75.80%的城市空气质量差，13.52%空气质量极差。报告还指出，中国空气污染防治政策滞后于社会经济发展。无论是大城市、经济发达城市、工业城市等，空气质量普遍较差，且总体上有恶化的趋势。"))
					.addValue(new DivGroupParam(null, "中国环境保护部发布的《2013中国环境状况公报》揭示了中国环境污染的现状："))
					.addValue(new ImageGroupParam("1、全国平均霾日数为35.9天，比2012年增加了18.3天，为1961年以来最多。").addValue(new ImageParam("/articles/img_apic_01.png","</br>图：国家气候中心发布的2013年全国霾日数分布示意图")))
					.addValue(new ImageGroupParam("2、在74个根据空气质量新标准监测的城市之中，仅海口、舟山和拉萨3个城市空气质量达标，超标城市比例达95.9%。").addValue(new ImageParam("/articles/img_apic_02.png","表：2013年重点区域各项污染物达标城市数量")))
					.addValue(new DivGroupParam(null, "<b>空气质量指数</b>"))
					.addValue(new DivGroupParam(null, "2012年2月中国环境保护部发布国家环境保护标准《环境空气质量指数（AQI）技术规定（试行）》的公告。AQI分级计算参考的标准是GB 3095-2012《环境空气质量标准》（现行），每小时发布一次。"))
					.addValue(new DivGroupParam(null, "空气质量指数AQI（Air Quality Index）是定量描述空气质量状况的非线性无量纲指数。参与空气质量评价的主要污染物为：PM2.5（细颗粒物）、PM10（可吸入颗粒物）、NO<sub>2</sub> （二氧化氮）、SO<sub>2</sub> （二氧化硫）、O<sub>3</sub> （臭氧）、CO（一氧化碳）等六项指标。空气质量指数数值越大、级别和类别越高、表征颜色越深，说明空气污染越严重，对人体危害越大。"))
					.addValue(new DivGroupParam(null, "AQI级别如下："))
					.addValue(new ImageGroupParam("").addValue(new ImageParam("/articles/img_apic_03.png","")))

					.addValue(new DivGroupParam("成因", ""))
					.addValue(new DivGroupParam(null, "空气污染成因可大致分为自然和人为。因低能效的工业设施和燃烧非清洁能源的机动车问题，我国大气污染主要呈现人为煤烟型污染特征：城市大气环境中总悬浮颗粒物浓度普遍超标，二氧化硫、氮氧化物和机动车尾气排放物污染不断升高。若风力不够强劲，空气污染物会加速堆积。此外，地形因素也会助长空气污染，两面或多面环山的城市（如北京和洛杉矶）常遭遇严重空气污染事件就根源于此。"))
					.addValue(new DivGroupParam(null, "室内出现空气污染的原因有：外部排放、建筑物密集、通风不足、家居清洁产品的使用、释放有害气体的家具等。常见污染物包括甲醛、苯、氡、氮化物、硫化物、烟、病菌、花粉等，而吸烟是最常见且伤害性最大的室内空气污染源。"))

					.addValue(new DivGroupParam("危害", ""))
					.addValue(new DivGroupParam(null, "2013年，美国北卡罗来纳大学环境科学院与国家环境保护局研究人员在《环境研究通讯》发布研究报告称，目前每年全球因空气污染而死亡的人数超过200万人。报告还指出，东亚、印度和东南亚是空气污染重灾区，仅印度一国每年因空气污染至少有50万人失去生命。"))
					.addValue(new DivGroupParam(null, "无独有偶，2012年联合国环境规划署公布的《全球环境展望5》指出，每年有70万人死于因臭氧导致的呼吸系统疾病，有近200万过早死亡与颗粒物污染有关。"))
					.addValue(new DivGroupParam(null, "另外，《2010年全球疾病负担评估》称，目前在全球范围内细颗粒物污染每年造成320多万人过早死亡以及影响超过7600万人的健康。"))
					.addValue(new DivGroupParam(null, "北京市卫生局统计数据显示，2010年肺癌位居北京市户籍人口男性恶性肿瘤发病的第一位，在女性中居第二位，仅次于乳腺癌。2001至2010年，北京市肺癌发病率增长了56%。全市新发癌症患者中有五分之一为肺癌患者。"))
					.addValue(new DivGroupParam(null, "空气中常见的气态污染物包括："))
					.addValue(new OlGroupParam(null)
						.addValue("可与水混合形成酸雨的酸性气体，如二氧化硫（SO<sub>2</sub>）、氮氧化物（NOSO<sub>X</sub>）； ")
						.addValue("对人体有毒气体，如一氧化碳（CO）、部分碳氢化合物等；")
						.addValue("对流层臭氧（平流层臭氧不会扩散；电离层臭氧可阻挡紫外光及辐射，有益环境）；")
						.addValue("光化学烟雾（由大气中的氮氧化物与碳氢化合物经过紫外线照射发生反应而成）；")
						.addValue("可构成悬浮微粒的化学物质，如钡、铜、铍、汞、铬、砷和氟化物。")
					 )
					.addValue(new DivGroupParam(null, "空气污染可严重影响人体健康："))
					.addValue(new OlGroupParam(null)
						.addValue("二氧化硫、二氧化氮等气体和悬浮粒子会刺激呼吸系统、眼睛，造成不适，高浓度时会引发心脏病及呼吸系统疾病； ")
						.addValue("甲醛对人体健康的影响包括嗅觉异常、刺激、过敏、肺功能异常、肝功能异常、免疫功能异常、中枢神经受影响等，还可损伤细胞内的遗传物质，是可疑致癌物； ")
						.addValue("一氧化碳会影响血液运送氧气的能力； ")
						.addValue("铅会影响人的神经系统，令儿童智力发展迟缓； ")
						.addValue("二氧化氮作用后可能形成对流层臭氧和硝酸过氧化乙醘醘（光化学烟雾的主要成份）； ")
						.addValue("碳氢化合物，尤其是多环性芳香化合物可致癌； ")
						.addValue("氟氯碳化物会破坏臭氧层，使更多紫外线抵达地面，增加患癌机率； ")
						.addValue("烟尘会使气喘发作频率升高； ")
						.addValue("胎儿出生后畸形的机率上升； ")
						.addValue("影响生殖系统，导致生育能力下降。 ")
					 )
					.addValue(new DivGroupParam(null, "世界卫生组织（WHO）颁布的空气质量准则认为，如长期暴露在超过空气质量准则值PM2.5——即每立方米微粒物超过10微克的空气中，人类总死亡率、心肺疾病死亡率和肺癌的死亡率都会增加。"))
					.addValue(new DivGroupParam(null, "<b>中美十大空气污染最严重的城市一览</b>"))
					.addValue(new ImageGroupParam("").addValue(new ImageParam("/articles/img_apic_04.png","图：日均空气污染程度。</br>数据来源：中国环境保护部、美国肺脏协会（American Lung Association）、WHO（世界卫生组织）。原图由《华盛顿邮报》于2014年2月2日17点48分发布")))

					.addValue(new DivGroupParam(null, "<b>室内空气污染是最容易被忽视的健康威胁</b>"))
					.addValue(new DivGroupParam(null, "室内空气质量指建筑结构内的空气质量，关系到内部人员的健康，受一氧化碳、二氧化硫、二氧化氮、挥发性有机化合物VOC等气体、微粒物质、微生物污染物（霉菌、细菌）等的影响。"))
					.addValue(new DivGroupParam(null, "美国EPA（环保署）称，室内空气的污染程度可能比室外空气高100倍以上。室内空气污染造成了多种建筑物病态综合症和化学污染物过敏症。室内空气质量造成的过敏、传染、肺癌、污染综合症等造成了巨大的经济损失，2005年美国EPA将室内污染物的危害例为二十一世纪人类面临的首要问题之一。我国也在从世纪九十年代起建立了一系列室内污染物的检测方法和控制法规。"))
					.addValue(new ImageGroupParam("").addValue(new ImageParam("/articles/img_apic_05.jpg","")))

					.addValue(new DivGroupParam(null, "<b>在工业环境中，空气的质量直接关系着人们的身体健康和工作效率，有时还是保证正常生产的基本条件。</b>"))
					.addValue(new DivGroupParam(null, "由于很多工厂的工作条件的限制以及通风设备的不完善，室内环境污染情况更是不容乐观，尤其在一些特殊的工作环境里到处充斥着粉尘颗粒以及有毒有害气体。长期处于这样的工作环境中，会使人头晕目眩、恶心，甚至会引起流泪、咽喉不适，更严重的甚至会危害到人的生命健康。"))
					.addValue(new DivGroupParam(null, "在某些工作地点，如不采取通风除尘措施，空气中的含尘浓度可高达每立方米上千毫克，即超过卫生标准数百倍。例如氧化铝车间空气中的粉尘和氟化物浓度，铅冶炼车间空气中的铅尘含量均可超过卫生标准数十倍，严重影响工人的身体健康。近年日益发展的电子计算机房、自动控制室、计量室等生产工艺，对室内温、湿度和洁净度都提出了更高的要求，不采取空气质量调节来改善空气环境是难以保证正常生产的。"))
					.addValue(new DivGroupParam(null, "另外，炼油厂、纸浆造纸厂、化工厂中腐蚀问题也同时存在。外表的硬腐蚀，可导致设备的物理性能退化，而内部对控制系统的软腐蚀却是肉眼无法察觉到的。设备管理经理早己认识到，电气元件即使是处在低浓度的有害气体、酸性气体和杂质的环境中也容易受到腐蚀，导致生产效率降低、生产成本和设备维修费用的增加甚至生产停顿。"))
					.addValue(new ImageGroupParam("").addValue(new ImageParam("/articles/img_apic_06.jpg","")))

					.addValue(new DivGroupParam("总结", ""))
					.addValue(new DivGroupParam(null, "空气污染除了影响人体健康及企业生产效率以外，还会严重阻碍社会经济发展。世界银行数据表明，当前中国由空气污染导致的经济损失至少相当于GDP的1.2%，还不包括有损国际形象等隐性成本。"))
					.addValue(new DivGroupParam(null, "的确，卓越迅捷的经济发展造福了国人，但“空气污染”这一快速发展所产生的副作用也不容忽视。为避免造成更严重的损失，及时有效地控制空气污染已经刻不容缓。"))

				//)
			
		);
		
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs2");
		request.setAttribute("productDetailPage", "productDetailPage5");
		request.setAttribute("details", details);
		return "/template/2ndTemplate.jsp";
	}

	public SolutionParam generateParam(String name) {
		SolutionParam param = AboutUsController.generateParam();
		param.setActiveSubItem(name);
		param.setTitle(param.getActiveSubItem());
		return param;
	}
	
	public SolutionParam generateParam(int subItemIndex) {
		SolutionParam param = AboutUsController.generateParam();
		param.setActiveSubItem(param.getSubItems().get(subItemIndex).getName());
		param.setTitle(param.getActiveSubItem());
		return param;
	}

	public static SolutionParam generateParam() {
		SolutionParam param = new SolutionParam();
		param.setHeaderPicName("about_us");
		param.setSubItemTitle("关于IIECC");
		param.setSubItemHeaderImgInfo("IIECC致力于为客户提供完善的环境控制解决方案以及节能、低碳的环保产品。凭借专业实力与严谨坚持，我们不断研发高效空气净化设施，守护人体健康、提升生活质量。");
		param.addSubItem("公司简介", "about_us/summary.html");
//		param.addSubItem("新闻及公告", "about_us/news.html");
		param.addSubItem("资料下载", "about_us/download.html");
		param.addSubItem("认证及资质", "about_us/certification.html");
		param.addSubItem("国际合作", "about_us/global_map.html");
		param.addSubItem("我们的客户", "about_us/case_list.html");
		return param;
	}
}

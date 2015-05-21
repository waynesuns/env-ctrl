package com.ec.website.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.website.param.ImageParam;
import com.ec.website.param.SolutionParam;
import com.ec.website.param.group.DivGroupParam;
import com.ec.website.param.group.ImageGroupParam;
import com.ec.website.param.group.MainGroupParam;
import com.ec.website.util.DataImportUtil;

@Controller
@RequestMapping(value = "/solution")
public class SolutionController extends AbstractController {

	@RequestMapping(value = "/industry")
	public String industry(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, IOException
	{
		SolutionParam param = this.generateParam(1);
		Map<String, MainGroupParam> details = new HashMap<String, MainGroupParam>();
		details.put("overView",(new MainGroupParam(null,null))
		.addValue(new DivGroupParam(null, "在石油化工、冶炼、造纸、印染等不同工业领域，特征污染物不尽相同。依据污染物的形态，可分为颗粒污染物和气态污染物：颗粒污染物包括粉尘、烟尘、雾尘、煤尘等，气态污染物包括含硫化合物、含氮化合物、碳氧化合物、碳氢化合物、卤氧化合物等。这些污染物大多具有刺激性或腐蚀性，直接损害人体健康，并能腐蚀设备表面甚至内部线路及部件。"))
		.addValue(DataImportUtil.doExcelImport(0, new File("/Users/weisun/git/env-ctrl/web-site/WebContent/excel/solution/industry.xlsx"), "常见污染物列表",null))
		.addValue(new DivGroupParam(null, "针对工业类主要污染物为有害气体这一特征，IIECC空气净化方案不仅能过滤常见颗粒物，还能利用专业的气相媒体过滤段，有效去除多种有害气体，为客户提供真正洁净的空气。"))
		.addValue(new DivGroupParam(null, "Multi-Mix<sup>®</sup> Media家族拥有多种气相净化媒体，如专门针对酸性氧化物的MM-9000和具备强氧化性的MM-1000等单一媒体，以及适用于特定环境的复合媒体，如MM-1955、TM MM-1355等。IIECC提供的TECH-CHEK<sup>TM</sup>分析服务，可根据现场实际有害气体的成分和浓度，筛选出最匹配的媒体，以达到最佳净化效果。此外，IIECC在选取DAS、UASH系列等净化设备时，会充分考虑污染类别、处理气体的体积和浓度、现场安装条件等多种因素，为客户提供量身定做最佳净化方案。"))
		.addValue(new DivGroupParam(null, "IIECC完备的空气净化方案，能保证设备机房内的空气质量达到G1标准，即设备可靠性不再被腐蚀影响的空气质量等级。"))
		.addValue(DataImportUtil.doExcelImport(1, new File("/Users/weisun/git/env-ctrl/web-site/WebContent/excel/solution/industry.xlsx"), "",new String[]{"100px",""}).addAnnon("表：依据ISA-711.04-1985对污染物严重级别的解释，在工业用过程检测和控制设备中，污染物浓度和存在的反应性级别的分布范围很大。某些环境属于严重腐蚀性的，而另一些则很轻微。"))
		.addValue(new DivGroupParam("案例", ""))
		.addValue(new ImageGroupParam("BASF-YPC Company Ltd., Co. —— DAS Series</br>扬子石化－巴斯夫").addValue(new ImageParam("/solution/industry_1.jpg","扬子石化－巴斯夫有限责任公司属于世界五百强企业，其主要生产线通过裂解生产乙烯。由于在蒸汽裂解过程中易产生苯系有机物、其他烃类化合物以及氮化物和硫化物，这些有害物质会随排风系统进入大气，严重影响办公区域及设备间的空气质量。IIECC工程师量身设计，为其控制室、设备间、马达室选用了DAS系列深床式气相净化机组。该机组投入使用后，极大降低了来自室外的新风中挥发性有机化合物和颗粒物的浓度，明显改善了室内空气品质。根据美国仪表学会标准ISA-711.04-1985进行的监测报告确认，受保护区域的环境始终维持在G1水平。此外，在进行预定周期的检测后发现，在不更换媒体的条件下，原先12个月的设计使用周期可继续延长使用3个月。")))
		.addValue(new ImageGroupParam("Riau Andalan Pulp & Paper, Indonesia —— DAS Series</br>印度尼西亚安达兰纸浆造纸厂").addValue(new ImageParam("/solution/industry_3.jpg","安达兰纸浆造纸厂生产设备多，致使周边污染气体浓度居高不下，尤其是与生产车间相距不远的办公室区域。IIECC工程师在现场勘测后，采用了DAS系列净化方案，分别在每栋办公大楼的新风机房内加装一台风量可达30000m³/h的DAS系列深床式气相净化机组，对引入的新风进行气相媒体段净化，将其中污染气体的浓度降至最低，颗粒物浓度更是降低至个位数级别，从而有效保证了室内的空气质量以及相关机电设备的使用寿命。")))
		.addValue(new ImageGroupParam("Asiasymbol —— DAS Series</br>山东亚泰森博浆纸有限公司").addValue(new ImageParam("/solution/industry_2.jpg","山东亚泰森博浆纸有限公司生产线多，生产过程中产生了硫化物等酸性气态污染物。浓度过高时对重要设备造成严重腐蚀，带来不可估量的损失。IIECC工程师经现场勘测后，在控制室和设备间采用DAS系列深床式气相净化机组，有效避免了设备的腐蚀。根据美国仪表学会标准ISA-711.04-1985进行的监测报告确认，受保护区域的环境始终维持在G1水平。")))
		.addValue(new ImageGroupParam("Dofasco —— Modular Unit</br>加拿大多法斯科公司").addValue(new ImageParam(null,"加拿大多法斯科公司厂区在冶炼过程中产生了浓度较高的酸性气体，对设备间造成腐蚀。采用模块化单元后酸性气相污染物浓度大大降低，机电设备遭受腐蚀的速率显著下降，从而延长了设备的使用寿命，降低了企业的更换成本，达到了预期的设计效果。")))
				);
		request.setAttribute("solutionParam", param);
		request.setAttribute("details", details);
		request.setAttribute("detailPage", "technology2");
		request.setAttribute("productDetailPage", "productDetailPage5");
		return "/template/2ndTemplate.jsp";
	}
	

	@RequestMapping(value = "/municipal_administration")
	public String municipalAdministration(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, IOException
	{
		SolutionParam param = this.generateParam(0);
		Map<String, MainGroupParam> details = new HashMap<String, MainGroupParam>();
		details.put("overView",(new MainGroupParam(null,null))
		.addValue(new DivGroupParam(null, "市政工程是指与城市生活配套的各种公共基础设施建设，主要包括机场、污水泵站、垃圾填埋场、隧道、大型车站等。这些设施由于作业环境复杂，或人员相对密集，通常会产生一系列较为严重的环境污染问题，如异味气体（以H<sub>2</sub>S为例）、高浓度腐蚀性气体（以SO<sub>2</sub>为例）等。"))
		.addValue(DataImportUtil.doExcelImport(0, new File("/Users/weisun/git/env-ctrl/web-site/WebContent/excel/solution/municipal_administration.xlsx"), "常见污染物列表",null))
		.addValue(new DivGroupParam(null, "市政类的服务设施均呈现出占地面积广、容纳人口多或处理量大的特点，极易产生有气味性的气体或出现由于人员众多带来的通风不畅、室内空气质量较差等问题，而这是传统的湿式吸收或者单一加大空气循环量的方法一直无法解决的。"))
		.addValue(new DivGroupParam(null, "IIECC提出了利用HDS系列高浓度气体干式洗涤器净化机组等系列产品去除有毒有害气体的解决方案。干式洗涤器净化机组可有效地消除污染物达到ppm（10<sup>-6</sup>）级别。"))
		.addValue(new DivGroupParam(null, "在IIECC的Multi-Mix<sup>®</sup> Media家族里有专门针对硫化氢等臭味气体的强氧化性媒体MM-1000，有比表面积大的活性炭媒体MM-3000，更有特殊配比的CleanAire型媒体。在净化设备的选择上，考虑到市政工程的安装条件所限，IIECC旗下的HDS系列高浓度气体洗涤器净化机组能够在较小的占地面积的条件下有一个很好的净化效果。另外，部分大风量或者浓度较高的市政设施会选用DAS系列深床式气相净化机组，在某些特定的区域内部也会选用APS小型气相净化系统来提高室内空气质量。"))
		.addValue(new DivGroupParam("案例", ""))
		.addValue(new ImageGroupParam("Washington Dulles International Airport —— USAH Series</br>华盛顿杜勒斯国际机场").addValue(new ImageParam("/solution/municipal_1.jpg","华盛顿杜勒斯国际机场有1800名员工，机场办公大楼的设计原已包含新风系统，但因距机场跑道只有数十米，不断有员工反映办公区域内部空气质量差，现场勘测后发现NO<sub>X</sub>，SO<sub>2</sub>，O<sub>3</sub>等有害气体浓度均高于标准数倍。为此，IIECC工程师采用USAH通用侧开系列气相净化机组，使大楼总流量为324000CFM（立方英尺每分钟）的气流经过USAH机组的两个并联媒体过滤段，分别为建筑供应180000CFM和144000CFM的清洁空气，同时，系统内置总重为80000磅的Multi-Mix<sup>®</sup> Media以保证空气品质等级。经USAH机组净化后，室内颗粒物浓度和有害污染气体浓度均有效降低。")))
		.addValue(new ImageGroupParam("Al Shindagha Tunnel, Dubai —— Modular Unit</br>迪拜隧道").addValue(new ImageParam("/solution/municipal_2.jpg","由于过往车辆较多，海底隧道内部的尾气浓度偏高，而原有的内部通风设计并不能有效解决这一问题。汽车尾气的主要成分是氮氧化合物和硫氧化合物，因此IIECC工程师选用了气相净化模块单元进行内循环过滤净化，有害气体经过媒体的吸附催化氧化后，浓度显著降低，且有效减少了隧道内部挥发性有机化合物的浓度。")))
		.addValue(new ImageGroupParam("Sewage Pump Station in Shanghai Pudong District —— HDS Series</br>上海市浦东污水泵站").addValue(new ImageParam("/solution/municipal_3.jpg","上海浦东污水泵站位于上海外环线处，近期规模为8000立方/天，远景设计规模可达10000立方/天。由于泵站紧邻居民楼（相距仅数十米），运行中产生的大量硫化氢等恶臭气体对周边环境带来了极大的影响。该泵站曾经采用雾化除臭工艺，但因处理工艺不完善，总体处理效果远低于预期。后停用该除臭工艺，选用HDS系列高浓度气体洗涤器净化机组，恶臭气体浓度明显降低，净化效果显著。")))
		.addValue(new ImageGroupParam("Smithville Incineration Plant, Ontario —— HDS Series</br>安大略史密斯维拉焚化厂").addValue(new ImageParam("/solution/municipal_4.jpg","史密斯维拉焚化厂在垃圾焚烧过程中会产生一系列臭味气体，严重影响周边居民的生活。考虑到臭味气体的危害性，IIECC的工程师选用了HDS系列高浓度气体洗涤器净化机组。设备投入使用后，气味得到了有效控制，焚烧厂对周边的污染程度也降低至可控范围内。")))
				);
		request.setAttribute("solutionParam", param);
		request.setAttribute("details", details);
		request.setAttribute("detailPage", "technology2");
		request.setAttribute("productDetailPage", "productDetailPage5");
		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/business")
	public String business(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, IOException
	{
		SolutionParam param = this.generateParam(2);
		Map<String, MainGroupParam> details = new HashMap<String, MainGroupParam>();
		details.put("overView",(new MainGroupParam(null,null))
		.addValue(new DivGroupParam(null, "以酒店、办公楼宇、住宅为代表的商业领域呈现出区域面积大、人数多、对空气质量要求高等三大特点；在早期的楼宇新风系统设计中，绝大部分新风系统只是加装了简单的初效过滤段，随着室外污染气体（以硫氧化物和氮氧化物为首）浓度的日益增长，更高级别的颗粒物过滤段以及去除新风中的有毒有害气体的需求显得更加迫切。"))
		.addValue(DataImportUtil.doExcelImport(0, new File("/Users/weisun/git/env-ctrl/web-site/WebContent/excel/solution/business.xlsx"), "常见污染物列表",null).addAnnon("注：常见的甲醛\\甲苯\\二甲苯等均属于VOCs（挥发性有机化合物）。"))
		.addValue(new DivGroupParam(null, "IIECC提出了多重颗粒物过滤系统+气相净化的新风设计方案，不仅能够使室内PM2.5降低到极低值，还能利用化学吸附催化氧化的原理处理掉从室外引进的新风中的污染气体。"))
		.addValue(new DivGroupParam(null, "商业类的场所由于其环境的特殊性造成了以香烟烟雾为代表的颗粒物浓度偏高，部分硫氧化物、氮氧化物由开窗换气通风或者由新风机组引入室内；在此类情况下IIECC除了选用强氧化性的媒体MM-1000来催化氧化以甲醛为首的有害气体以外，还会根据具体VOCs的不同选择不同比例的MM-3000来进行吸收。"))
		.addValue(new DivGroupParam(null, "商业项目与工业和市政类项目最大的不同点是对颗粒物浓度的处理级别要求更高，鉴于此IIECC定制选用了AAF的HEPA13过滤级别的高效过滤段，确保对PM2.5的去除达到一个最佳的效果；在净化设备的选择上考虑到商业项目的处理循环风量、安装条件、污染物浓度；IIECC旗下的APS小型气相净化系统能够在较小的占地面积下有一个很好的净化效果。"))
		.addValue(new DivGroupParam("案例", ""))
		.addValue(new ImageGroupParam("Harrah's Casino, Summit View Lounge, Lake Tahoe, NV —— APS Series</br>美国内华达州太浩湖海瑞斯赌场高层观光大厅").addValue(new ImageParam("/solution/business_1.jpg","尽管大多数美国城市已禁止在酒吧和餐馆吸烟，但事实上，吸烟者和非吸烟者仍可以共处一室。一个设计合理的过滤系统既要能减少有害气体和颗粒物的排放，同时还须满足地方法律规章的要求。APS小型气相净化系统的设计旨在去除由香烟烟雾释放的颗粒物和气态污染物，为高层观光大厅提供12ACH（每小时换气次数）风量的100%再循环空气，从而在烟雾集中区域有效去除ETS（环境烟草烟雾），同时使侧流（二手）烟雾对非吸烟者的影响降至最低。由于香烟烟雾是由颗粒物和气态污染物组成的复杂混合物，因此对它的处理必须经过不同的过滤段来完成。APS-1500空气净化系统通过一个HEPA（95%的颗粒物去除率）过滤器过滤掉颗粒物，再通过二阶媒体单元去除所有有害气体，其中包括香烟燃烧所释放的致癌物。")))
		
		.addValue(new ImageGroupParam("Jumeirah Beach Hotel, Dubai —— APS Series</br>迪拜朱美拉海滩酒店").addValue(new ImageParam("/solution/business_2.jpg","海滩酒店的厨房在设计阶段时，只考虑了普通油烟机和排风系统。运营一段时间后，发现无法解决烹饪产生的高浓度异味，此外，异味还容易通过门窗渗透至餐厅区域影响顾客的用餐环境。IIECC工程师现场勘测后，采用气相过滤的方法吸收、净化厨房异味气体。在气相净化模块投入使用后，内部异味得到了有效控制，并且原有排风系统的使用频率也大大降低，减少了能源消耗。")))
		.addValue(new ImageGroupParam("Jin Mao Tower, Shanghai —— APS Series</br>上海浦东金茂大厦").addValue(new ImageParam("/solution/business_3.jpg","金茂大厦等高端办公楼宇原有的系统设计中已包含有新风系统，虽具备较高级别的颗粒物过滤段，但对常见氮氧化物和硫氧化物的去除率却很低，因此室外的气态污染物会随新风一起进入室内，影响室内办公人员的身体健康和工作效率。后选用IIECC的APS系列小型气相净化系统在室内进行内循环净化，经检测室内的气体污染物浓度大幅下降，空气品质得到明显改善。")))
		.addValue(new ImageGroupParam("Beijing Lido, Beijing Palace, Tomson Riviera etc.  —— APS Series</br>北京丽都、北京丽宫、汤臣一品等高端社区").addValue(new ImageParam("/solution/business_4.jpg","一般来说室内空气污染比室外严重，但在国内目前环境下，开窗换气的方法已然没有效果。在一些高级公寓和别墅项目中，业主们对空气质量极为重视，不仅要求PM2.5浓度低，对空气中各类有毒有害气体的浓度控制也提出了更高要求，如空气质量指数中的SO<sub>2</sub>和NO<sub>X</sub>浓度等。IIECC的APS系列小型气相净化系统除了能有效去除PM2.5/PM10等颗粒物污染外，还能同时去除空气中的NO<sub>X</sub>，SO<sub>X</sub>，O<sub>3</sub>等化学性污染，从而满足了业主对高品质空气的需求。此外，IIECC的APS系列小型气相净化系统还可以加装热回收系统，通过逆流式热交换方式回收能量、降低能耗。")))
		);
		request.setAttribute("solutionParam", param);
		request.setAttribute("details", details);
		request.setAttribute("detailPage", "technology2");
		request.setAttribute("productDetailPage", "productDetailPage5");
		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/other")
	public String other(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, IOException
	{
		SolutionParam param = this.generateParam(3);
		Map<String, MainGroupParam> details = new HashMap<String, MainGroupParam>();
		details.put("overView",(new MainGroupParam(null,null))
		.addValue(new DivGroupParam(null, "医疗、军事、院校场馆、金融机构等特殊的场所，常需要有针对性地去除某种或某几种特殊的气相污染物：如医疗所用的福尔马林溶液（甲醛溶液）易挥发，对人体健康产生影响；图书馆的文献资料会因酸性气体腐蚀令保存时限缩短；军事设施内部需要保持对有毒有害气体的去除能力等。"))
		.addValue(DataImportUtil.doExcelImport(0, new File("/Users/weisun/git/env-ctrl/web-site/WebContent/excel/solution/other.xlsx"), "常见污染物列表",null))
		.addValue(new DivGroupParam(null, "IIECC针对此类区域提出的专业气相净化方案，能有效去除空气中的有害气体及颗粒污染物。"))
		.addValue(new DivGroupParam(null, "院校场馆、医疗军事等场所的空气污染呈现总体分布区域广、单体数量多等特点。综合考虑下，IIECC选用混合媒体MM-1355来催化氧化有害气体；针对这些场所的使用用途，IIECC还会根据实际情况选用AAF的HEPA13过滤级别的高效过滤段，以确保最有效去除PM2.5；在净化设备的选择上，根据现场情况通常会选用USAH、AG、APS等系列净化机组来实现对空气的过滤及净化。"))
		.addValue(new DivGroupParam("案例", ""))
		.addValue(new ImageGroupParam("The George W. Bush Presidential Library & Museum —— APS Series</br>乔治布什总统图书馆博物院").addValue(new ImageParam("/solution/other_1.jpg","德克萨斯州大学城乔治布什总统图书馆博物院内藏有大量的珍贵文献，但由于室内空气中酸性氧化物的浓度日益增大，对文献的腐蚀愈加严重。经研究，IIECC工程师采用了特别设计的组合Multi-Mix<sup>®</sup> Media（MM-1355），并经特殊处理，内置于二阶媒体单元系统。这种二阶式设计使博物院的空气污染物在设备内的滞留时间达到0.2秒，因此能彻底去除包括氮氧化物（NO<sub>X</sub>），硫氧化物（SO<sub>X</sub>），臭氧（O<sub>3</sub>）和总烃在内的有害气体。另有效率高达90%的中效过滤器集成于USAH通用侧开门系列气相净化机组，作为终端去除颗粒物。所有已安装的过滤器均符合UL等级I标准，无论物理过滤器、化学媒体还是化学媒体容纳单元都具有UL等级I认可的防火和不燃特性。")))
		.addValue(new ImageGroupParam("Washoe Medical Center - Reno, NV —— APS Series</br>美国内华达州里诺市肖沃医疗中心").addValue(new ImageParam("/solution/other_2.jpg","美国内华达州里诺市肖沃医疗中心为解决空气污染问题，选择了IIECC推荐的APS小型气相净化系统。机组分布于各科室的吊顶空间内，通过内循环过滤，有效地去除了空气中的颗粒物、病菌以及气态污染物。且在APS小型气相净化系统安装过程中充分考虑了原有的室内空间，将立式与卧式两款机型与现场条件完美匹配，营造出绝佳的设计与安装效果。")))
		.addValue(new ImageGroupParam("Escape channels of UN —— DAS + APS Series</br>联合国逃生通道").addValue(new ImageParam("/solution/other_3.jpg","联合国作为国际性的政务工作部门，为应对恐怖袭击、火灾、自然灾害等危害极大的突发事件，需配备高质量的逃生通道，而内部的空气品质则是设计的重中之重。为保证通道内的有害气体污染物浓度达到最低，IIECC工程师提出了DAS系列深床式气相净化机组+APS小型气相净化系统的综合解决方案：DAS用来去除新风引进时内含的气态污染物，而APS则对通道内的空气进行内循环过滤。使用后经监测，通道内的各项污染物浓度均低于国际标准。")))
		.addValue(new ImageGroupParam("Beijing Focus Building —— AG Series</br>北京富凯大厦").addValue(new ImageParam("/solution/other_4.jpg","北京富凯大厦尽管在每层均设有独立的新风机房，然而仅安装了G4级别的初效过滤段，随着北京空气情况的日益恶化，该系统已无法提供洁净的新风。后经IIECC现场勘测，在原有新风主机后加装了AG系列气相净化系统，在保证风量不变、不改动原有室内管道的前提下，仅对新风机房的管路进行了改造。项目改造完成后，现场进行了颗粒物浓度的检测，出风口的颗粒物浓度均为个位数，室内空气品质得到显著提升。")))
		);
		request.setAttribute("solutionParam", param);
		request.setAttribute("details", details);
		request.setAttribute("detailPage", "technology2");
		request.setAttribute("productDetailPage", "productDetailPage5");
		return "/template/2ndTemplate.jsp";
	}
	public SolutionParam generateParam(int subItemIndex) {
		SolutionParam param = SolutionController.generateParam();
		param.setActiveSubItem(param.getSubItems().get(subItemIndex).getName());
		param.setTitle(param.getActiveSubItem());
		return param;
	}

	public static SolutionParam generateParam() {
		SolutionParam param = new SolutionParam();
		param.setHeaderPicName("solution");
		param.setSubItemTitle("应用领域");
		param.setSubItemHeaderImgInfo("多年来，IIECC有针对性地为多个行业的代表性公司量身定做了环境控制解决方案，取得了至优净化效果，有效提升了人们的生活品质和企业的生产效益。");
		param.addSubItem("市政", "solution/municipal_administration.html");
		param.addSubItem("工业", "solution/industry.html");
		param.addSubItem("商业", "solution/business.html");
		param.addSubItem("其他", "solution/other.html");
		return param;
	}
}

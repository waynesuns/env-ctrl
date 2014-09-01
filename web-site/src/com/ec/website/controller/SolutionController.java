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
		.addValue(new DivGroupParam(null, "工业包含石油化工、冶炼、造纸、印染等多个领域，不同类型的工业领域特征污染物不同，依据污染物的形态，可分为颗粒污染物和气态污染物：颗粒污染物包括粉尘、烟尘、雾尘、煤尘等；气态污染物包括含硫化合物、含氯化合物、碳氧化合物、碳氢化合物、卤氧化合物等。这些污染物大多都有刺激性或腐蚀性，会直接损害人体健康，并且能够腐蚀设备的表面甚至内部线路以及各零部件。"))
		.addValue(DataImportUtil.doExcelImport(0, new File("/Users/weisun/git/ec/web-site/WebContent/excel/solution/industry.xlsx"), "常见污染物列表",null))
		.addValue(new DivGroupParam(null, "针对工业类主要污染物为有害气体这一特征，IIECC提出的空气净化方案除了能过滤常见颗粒物外，还能利用专业的气相媒体过滤段，有效去除多种有害气体，为客户提供真正洁净的空气。"))
		.addValue(new DivGroupParam(null, "Multi-Mix® Media家族拥有多种净化媒体，如专门针对酸性氧化物的MM-9000型媒体，和具备强氧化性的MM-1000型媒体。除单一媒体之外，根据IIECC以往处理工业类污染的经验，混合媒体MM-1955、MM-1355也能在相应环境下取得很好的净化效果。另外IIECC还能提供TECH-CHEKTM分析服务，即根据现场实际分析的有害气体成分、浓度，选取最合适的媒体。除了为用户提供具备最佳去除效果的媒体外，IIECC还会在选取净化设备时充分考虑到处理排放量的气体体积、气体浓度、现场安装条件等多个因素。面对每一个项目的不同要求，IIECC旗下的DAS、UASH产品系列都能在特定场合下，为工业类污染带来良好净化效果。"))
		.addValue(new DivGroupParam(null, "IIECC完备的空气净化方案，能保证设备机房内达到G1标准，即设备可靠性不再被腐蚀影响。"))
		.addValue(DataImportUtil.doExcelImport(1, new File("/Users/weisun/git/ec/web-site/WebContent/excel/solution/industry.xlsx"), "",new String[]{"100px",""}).addAnnon("表：依据ISA-711.04-1985对污染物严重级别的解释，在工业用过程检测和控制设备中，污染物浓度和存在的反应性级别的分布范围很大。某些环境属于严重腐蚀性，而另一些则较轻微。"))
		.addValue(new DivGroupParam("案例", ""))
		.addValue(new ImageGroupParam("BASF-YPC Company Ltd., Co. —— DAS Series</br>扬子石化－巴斯夫").addValue(new ImageParam("/solution/chemica.jpg","扬子石化－巴斯夫有限责任公司属于世界五百强企业，其主要生产线通过裂解生产乙烯。由于在蒸汽裂解过程中易产生苯系有机物、其他烃类化合物以及氮化物和硫化物，多种有害物质会随排风系统进入大气，严重影响办公区域及设备间的空气质量。后经工程师量身设计，为其控制室、设备间、马达室选用了DAS（卧式深床气相净化系统）系列机组。该机组投入使用后，极大降低了来自室外的新风中VOCs（挥发性有机化合物）和颗粒物的浓度，改善了室内空气品质。对系统进行预定周期的检测后证实，原先12个月的设计使用周期在不更换媒体的条件下还能延长3个月。根据美国仪表学会的标准ISA-711.04-1985，相关监测报告确认，受保护区域的环境始终维持在G1水平。")))
		.addValue(new ImageGroupParam("Riau Andalan Pulp & Paper, Indonesia —— DAS Series</br>印度尼西亚安达兰纸浆造纸厂").addValue(new ImageParam(null,"安达兰纸浆造纸厂生产设备多，致使周边污染气体浓度居高不下，尤其是与生产车间相距不远的办公室区域。我们的工程师在现场勘测完后，提出了采用DAS系列净化的方案，分别在每栋办公大楼的新风机房内加装一台风量可达30000m³/h的DAS机组。这种设计的优势在于，可对新风机组引入的新风进行气相媒体段的净化，从而将新风中污染气体的浓度降至最低，颗粒物浓度更是降低至个位数级别，有效保证了室内人员呼吸空气的质量以及相关机电设备的使用寿命。")))
		.addValue(new ImageGroupParam("Asiasymbol —— DAS Series</br>山东亚泰森博浆纸").addValue(new ImageParam(null,"山东日照亚太森博造纸厂生产线多，且生产过程中会产生以硫化物为首的酸性气态污染物，浓度过高时易对重要设备造成腐蚀，带来不可估量的损失。我们的工程师在现场勘测后，提出对其控制室、设备间采用DAS系列深床式净化机组的方案。净化设备投入使用后，有效避免了设备的腐蚀。根据美国仪表学会的标准ISA-711.04-1985，相关监测报告确认受保护区域的环境始终维持在G1水平。")))
		.addValue(new ImageGroupParam("Dofasco —— Modular Unit</br>加拿大多法斯科公司").addValue(new ImageParam(null,"加拿大多法斯科公司，在冶炼过程中会产生浓度较高的酸性气体，对设备间造成腐蚀。后采用模块化单元后取得了良好的去除效果，大大降低室内的酸性气相污染物浓度。机电设备遭受腐蚀的速率显著下降，从而延长了相关设备的使用寿命，降低了企业的更换成本。")))
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
		.addValue(new DivGroupParam(null, "市政工程是指城市生活配套的各种公共基础设施建设，主要包括机场、污水泵站、垃圾填埋场、隧道、大型车站等。这些公共基础设施在给人们带来生活保障的同时，难免也会产生一系列环境污染问题，如异味气体（以H2S为例）、高浓度腐蚀性气体（以SO2为例）等。"))
		.addValue(DataImportUtil.doExcelImport(0, new File("/Users/weisun/git/ec/web-site/WebContent/excel/solution/municipal_administration.xlsx"), "常见污染物列表",null))
		.addValue(new DivGroupParam(null, "市政类服务设施均呈现占地面积小、容纳人口多或处理量大的特点；且市政类的服务设施易产生有气味性的气体，或出现由人员众多带来的通风不畅、室内空气质量较差的问题。针对气味性气体的去除，IIECC并没有采用传统的湿式吸收、或单一加大空气循环量的方法，而是突破性地提出利用HDS干式洗涤塔等系列产品去除有毒有害气体的解决方案。干式洗涤塔能有效地消除污染物至ppm（10-9）级别。"))
		.addValue(new DivGroupParam(null, "在IIECC的媒体家族中，有专门针对硫化氢等臭味气体的强氧化性媒体MM-1000，有比表面积大的活性炭媒体MM-3000，更有特殊配比的CleanAire型媒体。考虑到市政工程的安装条件，在净化设备的选择上我们也有多种应对方法。IIECC旗下的HDS机组能在较小占地面积下呈现良好净化效果，部分大风量或浓度较高的市政设施需用到DAS型机组，在某些特定的区域内部也会选用APS小型室内净化机组来提升空气质量。"))
		.addValue(new DivGroupParam("案例", ""))
		.addValue(new ImageGroupParam("Washington DullesInternational Airport —— USAH Series, MM-1355</br>华盛顿杜勒斯国际机场").addValue(new ImageParam("/solution/municipal_administration_1.jpg","华盛顿杜勒斯国际机场有1800名员工。机场办公大楼的设计原已包含新风系统，但因距机场跑道只有数十米，大楼完工后不断有员工反映办公区域内部空气质量差，现场勘测分析发现NOX，SO2，O3等有害气体浓度均高于标准数倍。后设计采用了IIECC的净化设备，即使大楼总流量为324000CFM（CFM：立方英尺每分钟）的气流经过USAH系统的两个并联处理部分，分别为建筑供应180000CFM和144000CFM的清洁空气。系统内置总重为80000 lb.的Multi-Mix® Media以保证空气品质等级。经USAH机组净化后，室内颗粒物的浓度和室内有害污染气体浓度均有效降低。")))
		.addValue(new ImageGroupParam("Al Shindagha Tunnel, Dubai —— Modular Unit</br>迪拜隧道").addValue(new ImageParam("/solution/municipal_administration_2.jpg","由于过往车辆较多，海底隧道内部的尾气浓度偏高，而原有的内部通风设计并不能有效解决这一问题。汽车尾气的主要成分是氮氧化合物和硫氧化合物，因此我们选用了净化模块单元进行内循环过滤净化，有害气体经过媒体的吸附催化氧化后浓度显著降低，且有效减少了隧道内部VOCs的浓度。")))
		.addValue(new ImageGroupParam("Sewage Pump Station in Shanghai Pudong District —— HDS Series</br>上海市浦东污水泵站").addValue(new ImageParam(null,"上海浦东污水泵站位于上海外环线处，近期规模为8000m³/d，远景设计规模可达10000m³/d。由于泵站紧邻居民楼（相距仅数十米），运行中产生的大量恶臭气体对周边环境带来了极大的影响。该泵站曾经采用雾化除臭工艺，但因臭气处理工艺不够完善，总体处理效果远低于预期。停用该除臭工艺后，选用了HDS系列机组净化，效果显著，恶臭气体浓度显著减小。")))
		.addValue(new ImageGroupParam("Smithville Incineration Plant, Ontario —— HDS Series</br>安大略史密斯维拉焚化厂").addValue(new ImageParam(null,"史密斯维拉焚化厂在垃圾焚烧过程中会产生一系列臭味气体，严重影响周边居民的生活起居。考虑到臭味气体的危害性，我们选用了IIECC的HDS系列净化机组。设备投入使用后，气味得到了有效控制，将焚烧厂对周边的污染降低至可控范围内。")))
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
		.addValue(new DivGroupParam(null, "以酒店、办公楼宇、住宅为代表的商业领域，具有区域面积大、人数多、对空气质量要求高等三大特点。在早期的楼宇新风系统设计中，绝大部分只是加装了简单的初效过滤段，随着室外污染气体（以硫氧化物和氮氧化物为首）的浓度日益增长，去除有毒有害气体的需求显得愈加迫切。"))
		.addValue(DataImportUtil.doExcelImport(0, new File("/Users/weisun/git/ec/web-site/WebContent/excel/solution/business.xlsx"), "常见污染物列表",null).addAnnon("注：常见的甲醛\\甲苯\\二甲苯等均属于VOCs（挥发性有机化合物）。"))
		.addValue(new DivGroupParam(null, "IIECC提出的多重颗粒物过滤系统+气相净化的新风设计方案，不仅能使室内PM2.5降低到极低值，还能利用化学吸附催化氧化的原理处理掉室外引进新风中的气态污染物。"))
		.addValue(new DivGroupParam(null, "商业类场所由于其环境的特殊性，以香烟烟雾为代表的颗粒物浓度多数偏高，部分硫氧化物、氮氧化物会经由开窗换气通风、或由新风机组引入室内。在此类情况下，IIECC除了选用强氧化性的媒体MM-1000来催化氧化以甲醛为首的有害气体外，还会根据VOCs的具体区别，选择不同比例的MM-3000进行吸收。"))
		.addValue(new DivGroupParam(null, "商业项目与工业和市政类项目的最大区别，是对颗粒物浓度的处理级别要求更高。因此，IIECC定制选用了AAF的HEPA13过滤级别的高效过滤段，确保最有效地去除PM2.5。在净化设备的选择上，还会考虑到商业项目的处理循环风量、安装条件和污染物浓度。"))
		.addValue(new DivGroupParam("案例", ""))
		.addValue(new ImageGroupParam("Harrah's Casino, Summit View Lounge, Lake Tahoe, NV —— APS Series</br>内华达州太浩湖海瑞斯赌场高层观光大厅").addValue(new ImageParam("/solution/business_1.jpg","大多数美国城市已禁止在酒吧和餐馆中吸烟，事实上，吸烟者和非吸烟者是可以共存的。一个设计合理的过滤系统可以减少有害气体和颗粒物的排放，同时还能满足地方法律规章的要求。APS空气净化系统的设计旨在去除由香烟烟雾释放的颗粒物和气相污染物。内华达州太浩湖海瑞斯赌场环境控制的目标，是为高层观光大厅提供12ACH（每小时换气次数）风量的100%再循环空气，从而在烟雾集中区域有效去除ETS（环境烟草烟雾）同时使侧流（二手）烟雾对非吸烟者的影响降至最低。香烟雾是由颗粒物和气相污染物组成的复杂混合物，因此它的处理必须经过不同尺度的过滤器。APS-1500空气净化系统通过一个HEPA（95%的颗粒物去除率）过滤器收集所有的颗粒物，再通过二阶媒体单元去除所有有害气体，其中包括香烟燃烧所释放的致癌物。")))
		
		.addValue(new ImageGroupParam("Jumeirah Beach Hotel, Dubai —— APS Series</br>迪拜朱美拉海滩酒店").addValue(new ImageParam("/solution/business_2.jpg","海滩酒店的厨房在设计阶段时，起初只考虑到了普通油烟机以及排风系统。运营一段时间后，发现普通的通风换气系统无法解决烹饪产生的高浓度异味，长此以往不仅不利于厨房内部人员的日常工作，异味还容易通过门窗渗透至餐厅区域影响顾客的用餐环境。工程师现场勘测后，提出了利用气相过滤的方法吸收净化厨房异味气体。在IIECC的净化模块投入使用一段时间之后，内部异味得到了很好的控制，并且原有排风系统的使用频率也大大降低，减少了能源消耗。")))
		.addValue(new ImageGroupParam("Jin Mao Tower, Shanghai —— APS Series</br>上海浦东金茂大厦").addValue(new ImageParam("/solution/business_3.jpg","金茂大厦等高端办公楼宇原有的系统设计中已包含有新风系统，虽具备较高级别的颗粒物过滤段，但是对常见氮氧化物和硫氧化物的去除率却很低，因此室外的气体污染物会在未被去除的情况下随新风一起进入室内。长期在这种空气质量下工作，会严重影响室内办公人员的身体健康以及工作效率。后选用了IIECC的APS系列机组在室内进行内循环净化，机组正常运行一段时间后，经检测室内的气体污染物浓度大幅下降，空气品质得到有效改善。")))
		.addValue(new ImageGroupParam("Beijing Lido / Beijing Palace, Tomson Riviera… APS Series</br>北京丽都/北京丽宫、汤臣一品等高端社区").addValue(new ImageParam("/solution/business_4.jpg","一般来说室内空气污染比室外严重，但在国内目前的环境下，开窗换气的方法已然没有效果。在一些高级公寓和别墅项目中，业主们对空气质量极为重视，不仅要求PM2.5浓度低，更对空气中各类有毒有害气体的浓度也提出了较高要求，如空气质量指数中的SO2和NO2浓度等。IIECC的APS系列除了能有效去除PM2.5/PM10等颗粒物污染外，还能同时去除空气中的NOX，SOX，CO，O3等化学性污染，从而满足了业主对高品质空气的需求。除此之外，IIECC的APS系列机组还可以加装热回收系统，通过逆流式热交换方式回收能量、降低能耗。")))
		.addValue(new ImageGroupParam("</br>").addValue(new ImageParam("/solution/business.jpg","")))
		.addValue(new ImageGroupParam("</br>").addValue(new ImageParam("/solution/business.jpg","")))
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
		.addValue(DataImportUtil.doExcelImport(0, new File("/Users/weisun/git/ec/web-site/WebContent/excel/solution/other.xlsx"), "常见污染物列表",null))
		.addValue(new DivGroupParam(null, "IIECC针对此类区域提出的专业气相净化方案，能有效去除空气中的有害气体及颗粒污染物。"))
		.addValue(new DivGroupParam(null, "院校场馆、医疗军事等场所的空气污染呈现总体分布区域广、单体数量多等特点。综合考虑下，IIECC选用混合媒体MM-1355来催化氧化有害气体；针对这些场所的使用用途，IIECC还会根据实际情况选用AAF的HEPA13过滤级别的高效过滤段，以确保最有效去除PM2.5；在净化设备的选择上，根据现场情况通常会选用USAH、AG、APS等系列净化机组来实现空气的过滤及净化。"))
		.addValue(new DivGroupParam("案例", ""))
		.addValue(new ImageGroupParam("The George W. Bush Presidential Library and Museum —— APS Series</br>乔治布什总统图书馆博物院").addValue(new ImageParam("/solution/other_1.jpg","德克萨斯州大学城乔治布什图书馆内藏有大量的珍贵文献，但由于室内酸性氧化物的浓度日益增大，对文献的腐蚀愈加严重。后经工程师研究，采用了特别设计的组合Multi-Mix® Media（MM-1355），并经特殊处理，内置于二阶媒体单元系统。这种二阶式设计使乔治布什总统图书馆博物院的室外空气污染物在设备内的滞留时间达到0.2秒，因此能彻底去除氮氧化物（NOX），硫氧化物（SOX），臭氧（O3）和总烃在内的所有室外有害气体。另有效率高达90%的中效过滤器集成于USAH空气净化系统，可作为终端彻底去除颗粒物。所有已安装的过滤器均符合UL等级I标准，无论物理过滤器、化学媒体还是化学媒体容纳单元都具有UL等级I认可的防火和不燃特性。")))
		.addValue(new ImageGroupParam("Washoe Medical Center - Reno, Nevada —— APS Series</br>美国内华达州里诺市肖沃医疗中心").addValue(new ImageParam("/solution/other_2.jpg","美国内华达州里诺市肖沃医疗中心为解决空气污染问题，经工程师们推荐后选择了APS小型室内净化机组。安装后的APS分布于各个科室的吊顶空间内，经过内循环过滤净化，能有效去除空气中的颗粒物、病菌以及气态污染物。且APS在安装过程中充分考虑了原有的室内空间，将立式与卧式两款机型与现场条件完美匹配，营造出绝佳设计与安装效果。")))
		.addValue(new ImageGroupParam("Escape channels of UN —— DAS + APS Series</br>联合国逃生通道").addValue(new ImageParam("/solution/other_3.jpg","联合国作为国际性的政务工作部门，为应对恐怖袭击、火灾、自然灾害等危害极大的突发事件，需配备高质量的逃生通道，而内部的空气品质则是设计的重中之重。为保证通道内的有害气体污染物浓度达到最低，我们的工程师们提出了DAS深床式气相净化+APS小型净化机组的综合解决方案。在该项目中，DAS深床式气相净化可以去除新风引进时内含的气态污染物，而APS小型净化机组则可针对逃生通道内的空气，进行内循环过滤。该逃生通道投入使用后，经过监测，通道内的各项污染物浓度均低于国际标准。")))
		.addValue(new ImageGroupParam("Beijing Focus Building / AG Series</br>北京富凯大厦").addValue(new ImageParam("/solution/other_4.jpg","北京富凯大厦（北京证监会办公所在地）原有的新风系统，在每层均设有独立的新风机房。然而该套新风系统设计时仅安装了G4级别的初效过滤段，随着北京空气情况的日益恶劣，该套系统已无法提供洁净的新风。后经工程师现场勘测后，提出了在原有新风主机后加装AG系列净化系统的方案，在保证风量风压不变、并且不改动原有室内管道的前提下，仅对新风机房的管路进行了改造。项目改造完成后，现场进行了颗粒物浓度的检测，出风口的颗粒物浓度均为个位数，室内空气品质显著提升。")))
		.addValue(new ImageGroupParam("</br>").addValue(new ImageParam("/solution/other_5.jpg","")))
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
		param.setSubItemTitle("领域应用及解决方案");
		param.setSubItemHeaderImgInfo("多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。");
		param.addSubItem("市政", "solution/municipal_administration.html");
		param.addSubItem("工业", "solution/industry.html");
		param.addSubItem("商业", "solution/business.html");
		param.addSubItem("其他", "solution/other.html");
		return param;
	}
}

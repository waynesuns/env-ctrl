package com.ec.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.website.param.SolutionParam;
import com.ec.website.param.SolutionSampleParam;

@Controller
@RequestMapping(value = "/solution")
public class SolutionController {

	@RequestMapping(value = "/military")
	public String military(HttpServletRequest request, HttpServletResponse response)
	{
		SolutionParam param = this.generateParam();
		param.setActiveSubItem("军队");
		param.setSubItemInfo("由于工作环境的重要性，某些涉及到军方的项目对其内部的环境质量要求更高，例如潜艇内部、逃生通道等；此类区域的空气污染物的浓度必须严格控制在ppt(parts-per-trillion,10–12) 级别，传统的颗粒物过滤系统以及单纯的物理性吸附无法解决此类污染问题；针对此类项目我们提供了多级气相媒体净化系统，并根据不同的污染物选配从MM-1000到MM-9000等不同的媒体滤料，以达到最好的气相净化效果。");
		param.addSample(new SolutionSampleParam("联合国逃生通道", "military_un.jpg","联合国作为国际性的政务工作部门，为应对恐怖袭击、火灾或者自然灾害这些危害极大的突发事件需配备高质的逃生通道，而逃生通道内的空气品质是设计过程中重中之重的，为了保证逃生通道内的有害气体污染物浓度达到最低，我们的工程师们提出了深床式气相净化+室内小型净化机组的综合解决方案，在该项目中，深床式气相净化可以去除新风引进时内含的气态污染物，而室内小型净化机组则可针对逃生通道内的空气进行内循环过滤；该逃生通道投入使用后，经过监测，通道内的各项污染物浓度均低于国际标准。"));
		param.addSample(new SolutionSampleParam("美国军方逃生通道", "美国军方逃生通道，作为战时备用的通道，其内部的通风系统的设计要求严格控制空气污染的浓度，特别是从室外引进的新风里污染物的浓度，针对此类特殊项目，工程师们提出了DAS（深床式气相过滤系统）+APS（小型室内净化机组）组合式净化系统，该系统能够在净化新风的同时对通道内的空气进行循环过滤，有效的降低了室内颗粒物的浓度和有害的污染气体。"));
		request.setAttribute("detailPage", "solutionDetail");
		request.setAttribute("solutionParam", param);
		return "/template/2ndTemplate.jsp";
	}
	
	@RequestMapping(value = "/chemica_industry")
	public String chemicaIndustry(HttpServletRequest request, HttpServletResponse response)
	{
		SolutionParam param = this.generateParam();
		param.setActiveSubItem("化工");
		param.setSubItemInfo("化工行业包含化工、炼油、冶金、能源、轻工、医药等多个领域，不同类型的化工领域特征污染物不同，按照污染物存在的形态，化工废气可分为颗粒污染物和气态污染物，颗粒污染物包括粉尘、烟尘、雾尘、煤尘等；气态污染物包括含硫化合物、含氯化合物、碳氧化合物、碳氢化合物、卤氧化合物等。这些污染物大多都有刺激性或腐蚀性，会直接损害人体健康，并腐蚀控制设备的表面；EC提出的空气净化方案除了能解决常见的颗粒物过滤外，还能利用其专业的气相媒体过滤段有效的去除多种有害气体，从而为客户提供真正意义上洁净的空气。");
		param.addSample(new SolutionSampleParam("印度尼西亚安达兰纸浆造纸厂", "chemica_pp.jpg","安达兰纸浆造纸厂生产设备多，造成了周边污染气体浓度居高不下，尤其是与生产车间相距不远的办公室区域，我们的工程师在现场勘测完以后提出了采用DAS系列进行净化的方案，分别在每栋办公大楼的新风机房内加装一台30000m³/h的DAS机组，这种设计的优势在于可以将新风机组引入的新风进行气相媒体段的净化，从而将新风里污染气体的浓度降到最低值，颗粒物的浓度更是降低至个位数级别。"));
		param.addSample(new SolutionSampleParam("扬子石化－巴斯夫", "扬子石化－巴斯夫有限责任公司属于世界五百强企业，其主要生产线通过裂解生产乙烯，由于在蒸汽裂解过程中易产生苯系有机物、其他烃类化合物以及氮化物和硫化物，多种有害物质随排风系统排放到大气中，严重影响了办公区域以及设备间的空气质量；该项目后经过工程师量身设计，为其控制室、设备间、马达室选用DAS（卧式深床气相净化系统）系列机型。该机组投入使用后，极大的降低了室外引进的新风中的VOC（挥发性有机物）和颗粒物浓度，改善了室内空气品质。对系统进行预定周期的检测后证实，原先12个月的设计使用周期在不更换媒体条件下仍可延长3个月。根据美国仪表学会的标准71.04，相关监测报告确认受保护区域的环境始终维持在G1水平。"));
		request.setAttribute("detailPage", "solutionDetail");
		request.setAttribute("solutionParam", param);
		return "/template/2ndTemplate.jsp";
	}

	
	@RequestMapping(value = "/municipal_administration")
	public String municipalAdministration(HttpServletRequest request, HttpServletResponse response)
	{
		SolutionParam param = this.generateParam();
		param.setActiveSubItem("市政");
		param.setSubItemInfo("市政工程主要指的是城市生活配套的各种公共基础设施建设，主要包括市政污水泵站、垃圾填埋场、隧道、大型车站等；这些公共基础设施在给人们带来生活保障的同时也难免会产生一系列的环境污染问题，例如异味气体（以H2S为例）、高浓度腐蚀性气体（以SO2为例），针对此类污染问题，EC提出了利用高浓度干式洗涤塔去除有毒有害气体的解决方案。干式洗涤塔将有效地消除污染物达到检测不到的水平。值得一提是，此方案维护工作量小，每年只需要更换维护即可,而无需传统湿式洗涤器复杂且频繁的维修程序。");
		param.addSample(new SolutionSampleParam("蒙特利尔国际机场", "municipal_administration_montreal.jpg","蒙特利尔国际机场办公大楼内有1800名员工，该大楼原有设计中已含新风系统，但该大楼距机场跑道仅数十米，大楼完工后不断有员工反映在办公区域内部可以闻到飞机柴油的味道，经工程师设计后，机场办公大楼总流量为324000CFM的气流经过DAS系统的两个并联处理部分，分别为建筑供应180000CFM和144000CFM的清洁空气。总重为80000 lb.的Multi-Mix媒体内置于系统以保证空气品质等级。通过DAS机组净化后有效的降低了室内颗粒物的浓度和有害的室内污染气体浓度。"));
		param.addSample(new SolutionSampleParam("迪拜隧道", "隧道在设计之初仅考虑了内部的通风设计，运营一段时间后，由于内部人数多，呼出的二氧化碳浓度持续走高，再加上挥发性有机物的浓度逐渐上升，单靠通风系统难以将隧道内部的污染气体浓度进行降低，后经我们的工程师推荐采用了APS小型净化机组系列，其主要作用是对通风后的隧道内空气进行一个内循环过滤净化，能够有效的降低VOCs的浓度，系统安装投入使用后，隧道内部空气质量大为好转，保证了隧道内部人员的呼吸健康。"));
		param.addSample(new SolutionSampleParam("上海市浦东污水泵站", "上海浦东污水泵站位于上海外环线处，近期规模为8000m³/d,远景设计规模可达10000m³/d；由于泵站紧邻居民楼（相距仅数十米），运行中产生的大量恶臭气体对周边环境带来了极大的影响，为了完善该污水泵站功能，创造良好的生活工作环境，改建泵站除臭工程势在必行。在此之前，泵站曾经采用雾化除臭工艺，但由于臭气处理工艺不完善，总体处理效果远远低于预期，目前该除臭工艺已停用，泵站产生的臭气只能通过风机引入约8米的高空直接排放。直到选用HDS系列机组净化后，效果显著，恶臭气体浓度大大减小。"));
		request.setAttribute("detailPage", "solutionDetail");
		request.setAttribute("solutionParam", param);
		return "/template/2ndTemplate.jsp";
	}
	
	@RequestMapping(value = "/medical_treatment")
	public String MedicalTreatment(HttpServletRequest request, HttpServletResponse response)
	{
		SolutionParam param = this.generateParam();
		param.setActiveSubItem("医疗");
		param.setSubItemInfo("呼吸道感染、泌尿感染和肠胃道感染是医院感染部位的前三甲，呼吸道感染首当其冲。医院空气污染带来的感染难以防范又不易察觉，医院又是病菌的集散地，悬浮在空气中的PM2.5更是病菌的生生不息的乐土，这对于病人来说简直是“雪上加霜”。除此之外，医疗行业大量使用福尔马林（甲醛溶液）作为防腐消毒剂，甲醛不仅会带来刺鼻性气味且其本身属于有毒有害物质。气相媒体滤料MM-1000主要成分是高锰酸钾浸渍活性氧化铝和活性炭，能够有效的去除甲醛等有毒有害气体，同时配备的HEPA13级别的高效过滤段能够使颗粒物的去除率达到99.99%，全面满足医院空气污染治理需求。");
		param.addSample(new SolutionSampleParam("美国内华达州里诺市肖沃医疗中心", "medical_treatment_washoe.jpg","美国内华达州里诺市肖沃医疗中心为解决空气污染问题，经工程师们推荐后选择了APS（小型室内净化机组）,安装后的APS分布于各个科室的吊顶空间内，经过内循环过滤净化，有效的去除了颗粒物以及污染气体；且APS在安装的过程中充分考虑了原有的室内空间，将立式与卧式两款机型与现场条件相匹配，营造一个最佳的设计与安装效果。"));
		param.addSample(new SolutionSampleParam("多伦多法医病理实验室", "多伦多法医病理实验室由解剖室、尸体贮藏室、其它各种实验室、私人办公室和办公厅组成。未处理和已处理的腐烂尸体产生的异味以及有害气体严重影响了办公人员的身体健康；通过选用A.P.S.（小型气相净化机组）净化后，病理实验室室内的空气品质得到极大的改善，腐烂尸体的异味得到了有效的控制，整个实验室内的甲醛浓度也降到了室内标准值以下。"));
		request.setAttribute("detailPage", "solutionDetail");
		request.setAttribute("solutionParam", param);
		return "/template/2ndTemplate.jsp";
	}
	
	@RequestMapping(value = "/residence")
	public String residence(HttpServletRequest request, HttpServletResponse response)
	{
		SolutionParam param = this.generateParam();
		param.setActiveSubItem("住宅");
		param.setSubItemInfo("考虑到人类本身对于新风的需求性，现阶段大部分住宅系统开始安装新风系统，但室外空气实际质量并不理想，污染物不仅仅包括PM2.5 等颗粒物，氮氧化物和硫氧化物给人带来的危害更大，此类新风一旦引入室内，非但不能起到给人带来舒适度的作用，还会给人们的呼吸系统带来危害；针对住宅类的新风系统，EC提出了多重颗粒物过滤系统+气相净化的新风设计方案，不仅能够使室内PM2.5降低到极低值，还能利用化学吸附催化氧化的原理处理掉室外引进新风中的污染气体。");
		param.addSample(new SolutionSampleParam("东渡国际", "residence_dongdu.jpg","东渡国际中心作为上海高档的大平层住宅类别墅，设计方在考虑暖通设计时就对空气净化提出了严格的要求，后经工程师们推荐选用了新风与内循环净化混合的AG系列机型，该机型的特征是将内循环净化和新风引进设计在一个机组内部，这样既满足了住宅类的通风要求，又实现了内循环净化，在该套机组设备的运转下，可以保证室内的PM2.5浓度持续保持在国标以下，让室内人员呼吸时不再受雾霾之苦。"));
		param.addSample(new SolutionSampleParam("北京丽都/北京丽宫、汤臣一品等高端社区", "一般来说室内空气污染会比室外严重，但在国内目前的环境下，人们平时都会采用开窗换气的方法已经没有效果。在一些高级公寓和别墅项目中，业主们对空气质量有较高要求，不仅要求空气中尽量少的PM2.5浓度，更对空气中所含的各类有毒有害气体的浓度也提出了高要求。比如空气质量指数中的SO2和NO2浓度等。在这个条件下我们的APG40M系列除有效去除PM2.5/PM10等颗粒物污染以外，还同时去除空气中的NOX，SOX，CO，O3等化学性污染，从而满足了业主对高品质空气的需求"));
		request.setAttribute("detailPage", "solutionDetail");
		request.setAttribute("solutionParam", param);
		return "/template/2ndTemplate.jsp";
	}
	
	@RequestMapping(value = "/hotel")
	public String hotel(HttpServletRequest request, HttpServletResponse response)
	{
		SolutionParam param = this.generateParam();
		param.setActiveSubItem("酒店及办公楼宇");
		param.setSubItemInfo("以酒店和办公楼为代表的某些领域现阶段呈现出区域面积大、人数多、对空气质量要求高等三大特点；在早期的楼宇新风系统设计中，绝大部分新风系统知识加装了简单的初效过滤段，随着室外污染气体（以硫氧化物和氮氧化物为首）浓度的日益增长，去除新风中的有毒有害气体的需求显得更加迫切；针对此类项目，我们提出了系统的改造方案，即在不改变原有室内新风管道的前提下仅在新风机房增加气相过滤设备，在源头上去除污染气体以及PM2.5等颗粒物。");
		param.addSample(new SolutionSampleParam("迪拜塔", "hotel_dubai.jpg","迪拜塔作为全球最著名的的七星级酒店，在设计之初，如何保证室内空气品质就是一个极其充满挑战的设计；后经工程师们设计，新风在引入到室内前，经过DAS净化机组的过滤，考虑到七星级酒店客人对于空气品质的要求，DAS机组内置的媒体净化段设计为3级，并标配的了初效以及高效颗粒物过滤段，整套净化系统设计完成投入使用后，酒店内的每个房间所获得的新风内含的颗粒物浓度以及有害气体浓度均降至标准以下，为入住的客人带来了最好呼吸的空气。"));
		param.addSample(new SolutionSampleParam("内华达州太浩湖海瑞斯赌场高层观光大厅", "大多数美国城市已禁止在酒吧和餐馆中吸烟。但吸烟者和非吸烟者是可以共存的：一个合理设计的过滤系统可以减少有害气体和颗粒物的排放，同时还能满足地方法律规章的要求。空气净化系统（A.P.S.）设计旨在去除由香烟雾释放的颗粒物和气相污染物。环境控制的目标是为高层观光大厅提供12ACH （换气次数每小时）风量的100%再循环空气，从而在烟雾集中区域有效去除ETS（环境烟草烟雾）同时使侧流（二手）烟雾对非吸烟者的影响降至最低。香烟雾是由颗粒物和气相污染物组成的特别复杂的混合物，因此它的处理必须经过不同尺度的过滤器。A.P.S.-1500空气净化系统通过一个HEPA（高效颗粒物捕获，95%）过滤器收集所有的颗粒物，再通过二阶媒体单元去除所有有害气体，其中包括香烟燃烧所释放的致癌物。"));

		param.addSample(new SolutionSampleParam("北京富凯大厦", "北京富凯大厦（北京证监会办公所在地）原有自己一套独立的新风系统，大厦每层均设有独立的新风机房，该套新风系统设计时仅安装了G4级别的初效过滤段，随着北京空气情况的日益恶劣，该套系统已远不能为办公人员提供洁净的新风；后经工程师现场勘测后，提出了在原有新风主机后加装AG系列净化系统的方案，在保证风量风压不变并且不改动原有室内管道的前提下仅对新风机房的管路进行了改造，项目改造完成后，现场进行了颗粒物浓度的检测，出风口的颗粒物浓度均为个位数，大大提高了室内的空气品质。"));
		param.addSample(new SolutionSampleParam("钓鱼台国宾馆", "一般来说，室内封闭环境空气质量要比室外空气质量差，尤其长时间使用空调的环境，各种污染更多。绝大多数的酒店客房是相对密闭的环境，只靠空调新风来调节空气。而我们传统的新风只有简单的针对毛发灰尘等大颗粒物的初效过滤器，对PM2.5颗粒物和各种气体污染的过滤几乎没有效果。而且酒店的相对密闭导致其装修污染物和各种生活异味很难快速散发，所以很多酒店在清洁房间后会喷洒香水来遮盖异味。而通过使用APG系列净化系统，能大大改善室内的空气质量，能去除包括各类装修污染物、PM2.5、从新风系统进来的室外汽车尾气甚至是前面住客留下的体味烟味等。"));
		
		request.setAttribute("detailPage", "solutionDetail");
		request.setAttribute("solutionParam", param);
		return "/template/2ndTemplate.jsp";
	}
	
	@RequestMapping(value = "/stadium")
	public String stadium(HttpServletRequest request, HttpServletResponse response)
	{
		SolutionParam param = this.generateParam();
		param.setActiveSubItem("场馆及院校");
		param.setSubItemInfo("院校和场馆属于人流比较集中的区域，其内部空气污染物浓度过高时人容易产生疲劳和易怒，这些区域的通风系统设计的原则在是能应对一切可能的室外空气质量问题的同时，以最小的运行费用为室内环境提供合适的空气质量。EC针对此类区域提出了专业气相净化方案，能够有效的去除空气中的硫氧化物、氮氧化物、烃类和挥发性有机物。");
		param.addSample(new SolutionSampleParam("乔治布什总统图书馆博物院", "stadium_george.jpg","德克萨斯州大学城乔治布什图书馆内藏有大量的珍贵文献，但由于室内酸性氧化物的浓度日益增大，对文献的腐蚀呈愈演愈烈之势，后经工程师们设计，媒体采用了特别设计的一种组合：高锰酸钾加上活性炭。Multi-Mix® Media（MM-1355）组合媒体经特殊处理，内置于一个二阶媒体单元系统。这种二阶式设计使乔治布什总统图书馆博物院的室外空气污染物在设备内滞留时间达到0.2秒，因此能彻底去除氮氧化物（NOX），硫氧化物（SOX）,臭氧（O3）和总烃在内的所有室外有害气体。效率达90%的终过滤器集成于USAH空气净化系统，作为对颗粒物的终端去除。所有已安装的过滤器具有UL等级I标准。无论物理过滤器、化学媒体还是化学媒体容纳单元都具有UL等级I认可的防火和不燃特性。"));
		param.addSample(new SolutionSampleParam("佛罗里达州迈阿密市戴德郡学校", "戴德郡小学原有的通风系统设计中设计了新风系统，但该新风系统只能过滤大颗粒物，室外的气体污染物随新风进入室内，再加上室内人数较多，且前期装饰过程中产生的化学物质逐渐开始散发出来，多种因素造成室内空气质量大幅度下降，前期只能通过加大新风量的置换来缓解这种状况，后加装了APS-400机组进行过滤再循环后，达到了设计者预期的污染物过滤要求并使总新风量减少了大约50%，新风量的减少也意味着每年用于制冷的能量也显著减小。"));
		request.setAttribute("detailPage", "solutionDetail");
		request.setAttribute("solutionParam", param);
		return "/template/2ndTemplate.jsp";
	}
	@RequestMapping(value = "/overview")
	public String overview(HttpServletRequest request, HttpServletResponse response)
	{
		SolutionParam param = this.generateParam();
		param.setActiveSubItem("概览");
		param.setSubItemInfo("EC提出的空气净化解决方案不仅仅针对PM2.5等颗粒物的去除，更旨在有效去除有毒有害的污染气体；正因为EC能为不同行业的不同污染物提供量身定做的净化设备，多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。");
		request.setAttribute("detailPage", "solutionDetail");
		request.setAttribute("solutionParam", param);
		return "/template/2ndTemplate.jsp";
	}
	public SolutionParam generateParam(){
		SolutionParam param = new SolutionParam();
		param.setHeaderPicName("solution.jpg");
		param.setSubItemTitle("领域应用及解决方案");
		param.setSubItemHeaderImgInfo("多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。");
		param.addSubItem("概览", "solution/overview.html");
		param.addSubItem("化工", "solution/chemica_industry.html");
		param.addSubItem("医疗", "solution/medical_treatment.html");
		param.addSubItem("市政", "solution/municipal_administration.html");
		param.addSubItem("军队", "solution/military.html");
		param.addSubItem("住宅", "solution/residence.html");
		param.addSubItem("场馆及院校", "solution/stadium.html");
		param.addSubItem("酒店及办公楼宇", "solution/hotel.html");
		return param;
	}
}

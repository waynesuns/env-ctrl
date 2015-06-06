package com.ec.website.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.website.param.ImageParam;
import com.ec.website.param.PartnerGroupParam;
import com.ec.website.param.PartnerParam;
import com.ec.website.param.SolutionParam;
import com.ec.website.param.SolutionSampleParam;
import com.ec.website.param.TableHeaderParam;
import com.ec.website.param.group.DivGroupParam;
import com.ec.website.param.group.ImageGroupParam;
import com.ec.website.param.group.MainGroupParam;
import com.ec.website.param.group.RowGroupParam;
import com.ec.website.param.group.TableGroupParam;
import com.ec.website.param.group.UlGroupParam;

@Controller
@RequestMapping(value = "/product")
public class ProductController extends AbstractController {

	@RequestMapping(value = "/aps")
	public String aps(HttpServletRequest request, HttpServletResponse response) {
		SolutionParam param = this.generateParam(0);
		param.setTitle("APS系列小型气相净化系统");

		List<MainGroupParam> details = new 	ArrayList<MainGroupParam>();
		this.initAPS3(details);
		this.initAPS2(details);
		this.initAPS1(details);
		
		Map<Integer,String> keys = new HashMap<Integer, String>();
		keys.put(0, "移动式系列");
		keys.put(1, "暗藏式系列");
		keys.put(2, "立式系列");
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "productDetail3");
		request.setAttribute("productDetailPage", "productDetailPage5");
		request.setAttribute("details", details);
		request.setAttribute("keys", keys);
		return "/template/2ndTemplate.jsp";
	}

	public void initAPS1(List<MainGroupParam> details){
		details.add((new MainGroupParam(null,null))
				.addValue(new RowGroupParam(null, null)
					.addValue(new DivGroupParam(null, "APS小型气相净化系统，被设计成为能在较小空间内有效去除微尘和污染的空气净化装置，并能同时减少新风的风量，降低建筑能耗。"+"</br></br>"+"APS小型气相净化系统严格符合最新建筑通风设备标准和室内空气质量要求。其特色是多级过滤系统，包括高效率的气相净化媒体，能提供极高能效的净化过滤。").setCssClassName("col-xxs-12 col-md-6"))
					.addValue(new ImageGroupParam(null).addValue(new ImageParam("/product/aps_v.png")).setCssClassName("col-xxs-12 col-md-6"))
						)
				.addValue(new UlGroupParam("APS过滤部分符合所有的ASHRAE标准，包括：")
					.addValue("30%初效过滤；")
					.addValue("多段混合化学媒体箱，加入MM-1000 型Multi-Mix<sup>®</sup> Media（可选用其他媒体配方）；")
					.addValue("空气过滤器对0.3微米尘埃最高可达到99.99%的过滤率。"))
				.addValue(new DivGroupParam(null, "APS小型气相净化系统具有极高的性价比，可用于教室、医院、实验室、监狱、研究所、宾馆、吸烟室、会议室等，能轻松解决目前的室内空气质量问题。").setDoDelim(true))
				.addValue(new DivGroupParam("特点",null))
				.addValue(new UlGroupParam(null)
					.addValue("低噪音")
					.addValue("紧凑设计")
					.addValue("卧式或立式结构")
					.addValue("多级空气过滤")
					.addValue("提高室内空气质量")
					.addValue("减少新风能量负荷")
					.addValue("双层绝缘PU面板结构")
					.addValue("30%初效过滤器")
					.addValue("一至三级气相净化媒体模块")
					.addValue("过滤臭味和有毒气体")
					.addValue("快速门锁扣")
					.addValue("检修门")
					.addValue("启动开关").setDoDelim(true))
				
				.addValue(new DivGroupParam("可选配置",null))
				.addValue(new UlGroupParam(null)
					.addValue("90%中效过滤器")
					.addValue("带式传动内置风机")
					.addValue("压差表")
					.addValue("手动风阀")
					.addValue("变速控制器（可装在机组或遥控上）")
					.addValue("压差表可监控系统压力")
					.addValue("水加热盘管")
					.addValue("直膨式或冷冻水制冷盘管")
					
						));
	}
	public void initAPS2(List<MainGroupParam> details){
		details.add((new MainGroupParam(null,null))
				.addValue(new RowGroupParam(null, null)
					.addValue(new DivGroupParam(null, "APS系列小型气相净化系统，在提供舒适新风的同时，可将热量与湿气在排风与新风间转移，以节省空调用于处理新风温差的能耗。暗藏式系列可净化补进新风，有效去除外界异味、汽车尾气以及PM2.5等空气污染，以极高的能量回收效率，最大程度地满足人们对工作、生活环境高品质的渴求，广泛应用于宾馆、公寓、住宅、商务楼、医院、展览建筑等。").setCssClassName("col-xxs-12 col-md-6"))
					.addValue(new ImageGroupParam(null).addValue(new ImageParam("/product/aps_h.png")).setCssClassName("col-xxs-12 col-md-6"))
						)
				.addValue(new DivGroupParam("特点",null))
				.addValue(new UlGroupParam(null)
					.addValue("在空调与采暖季节节省空调采暖能耗15%以上；")
					.addValue("高效纸质换热芯体具有极强的湿气吸附与传递功能；")
					.addValue("高效低噪音直流马达系统（部分机型除外）；")
					.addValue("机组采用上海宝钢耐指纹板材，人性化设计，外表美观；")
					.addValue("机组配置过滤净化段，有效去除有毒有害气体；")
					.addValue("灵巧简洁的设计使拆卸保养极为简便；")
					.addValue("采用特殊吸音材料和优质电机，低噪音，低能耗。").setDoDelim(true))
				
				.addValue(new DivGroupParam("可选配置",null))
				.addValue(new UlGroupParam(null)
					.addValue("智能控制系统")
					.addValue("通过感测二氧化碳等多种化学有害气体及湿度来调整新风系统")
					.addValue("全热换热器")

					
						));
	}

	public void initAPS3(List<MainGroupParam> details){
//		details.add((new MainGroupParam(null,null))
//				.addValue(new DivGroupParam(null,"APS移动式系列气相净化仪拥有行业领先的净化能力，可完全去除PM2.5，并将气体污染物的危害降至最低。"))
//				.addValue(new DivGroupParam(null,"独有的Multi-Mix<sup>®</sup> Media气相净化媒体，能在0.05秒内彻底去除有毒有害气体，技术源自加拿大Circul-Aire公司。"))
//				.addValue(new DivGroupParam(null,"作为顶级的净化过滤媒体，Multi-Mix<sup>®</sup> Media不仅能对环境里的腐蚀、气味和有毒污染物质提供不间断的快速净化，还能有效消除普通空气过滤器无法消除的有毒有害气体，如：二氧化硫、二氧化氮、有机污染物，甚至在特殊地区可有效净化二噁英等。"))
//				.addValue(new DivGroupParam(null,"气相和尘埃污染控制技术是当前最先进、最高效的解决方案，现有案例多应用于较为复杂的污染环境。APS移动式气相净化仪这一高性能系统，集成了精密的元件材料与工程实践，利用多级过滤和气相过滤媒体相结合的方式，能非常有效地去除室内空气污染物，可用于恶劣的工业和商业环境。").setDoDelim(true))

		details.add((new MainGroupParam(null,null))
				.addValue(new RowGroupParam(null, null)
					.addValue(new DivGroupParam(null, "APS移动式系列气相净化仪拥有行业领先的净化能力，可完全去除PM2.5，并将气体污染物的危害降至最低。"+"</br></br>"+"独有的Multi-Mix<sup>®</sup> Media气相净化媒体，能在0.05秒内彻底去除有毒有害气体，技术源自加拿大Circul-Aire公司。").setCssClassName("col-xxs-12 col-md-6"))
					.addValue(new ImageGroupParam(null).addValue(new ImageParam("/product/aps_480m.png")).setCssClassName("col-xxs-12 col-md-6"))
						)
				.addValue(new DivGroupParam(null,"作为顶级的净化过滤媒体，Multi-Mix<sup>®</sup> Media不仅能对环境里的腐蚀、气味和有毒污染物质提供不间断的快速净化，还能有效消除普通空气过滤器无法消除的有毒有害气体，如：二氧化硫、二氧化氮、有机污染物，甚至在特殊地区可有效净化二噁英等。"))
				.addValue(new DivGroupParam(null,"气相和尘埃污染控制技术是当前最先进、最高效的解决方案，现有案例多应用于较为复杂的污染环境。APS移动式气相净化仪这一高性能系统，集成了精密的元件材料与工程实践，利用多级过滤和气相过滤媒体相结合的方式，能非常有效地去除室内空气污染物，可用于恶劣的工业和商业环境。").setDoDelim(true))
				
				.addValue(new DivGroupParam("特点",null))
				.addValue(new DivGroupParam(null,"等离子发生器采用韩国 spe H•ion cluster 技术，通过 IST 专业评测机构认证，可高效灭菌、降解部分有害气体。","第一层 等离子段（可选配置）"))
				.addValue(new DivGroupParam(null,"采用AAF AmMet可清洗铝网过滤器可滤除所有直径 10μm以上的大颗粒粉尘，容尘量大并可清洗后重复使用。","第二层 初效过滤段"))
				.addValue(new DivGroupParam(null,"其独特“V”型工业级设计保证了高接触面积和低阻力，双气相净化媒体模块结构可装填最大重达10000 克的Multi-Mix<sup>®</sup> Media气相净化媒体，能在 0.05 秒内去除数百种室内污染气体，即使室内环境有数十人吸烟， APS移动式气相净化仪也能表现出色。","第三层 气相分子筛"))
				.addValue(new DivGroupParam(null,"PTFE材质的HEPA13高效过滤器，专门针对PM2.5颗粒设计，甚至是0.1微米的颗粒也能达到99.99%的处理效率。","第四层 高效过滤段"))
				.addValue(new TableGroupParam("产品家族")
				.addHeader(new TableHeaderParam("", "20%")).addHeader(new TableHeaderParam("APS-550M","50%")).addHeader(new TableHeaderParam("APS-480M","30%"))
				.addValue(new String[]{"产品介绍","适用于居室及办公环境的顶级空气净化系统。极致去除颗粒物能力，多种气相净化媒体任意组合，长效去除常见的数百种有毒害气体。","适用于居室及办公环境的专业级空气净化系统。超大净化效能，综合去除颗粒物及有毒害气体。"})
				.addValue(new String[]{"","<a href='../aps550m/index.html'><b><font color='#009bdf'>浏览产品网站</font></b></a>","<a href='../aps480m/index.html'><b><font color='#009bdf'>浏览产品网站</font></b></a>"})
				.addValue(new String[]{"风机风量","1300 m<sup>3</sup>/h","1300 m<sup>3</sup>/h"})
				.addValue(new String[]{"CADR","530 m<sup>3</sup>/h",">800 m<sup>3</sup>/h"})
				.addValue(new String[]{"净化效能","3.33（符合A级）","4.76（符合A级）"})
				.addValue(new String[]{"风档","无级变速","无级变速"})
				.addValue(new String[]{"工作电压","220V 50Hz","220V 50Hz"})
				.addValue(new String[]{"最大功耗","160 w","160 w"})
				.addValue(new String[]{"尺寸","842×305×508 mm","842×305×508 mm"})
				.addValue(new String[]{"重量</br>（不含净化媒体）","24 kg","24 kg"})
				.addValue(new String[]{"最大噪音","64 db","64 db"})
				.addValue(new String[]{"整机材料","镀锌钢板","镀锌钢板"})
				.addValue(new String[]{"初效过滤器","AAF AmMet铝制初效过滤器","AAF AmMet铝制初效过滤器"})
				.addValue(new String[]{"气相净化媒体","MM-1000 / MM-1355 / CleanAire 任意两种气相净化媒体组合","CleanAire"})
				.addValue(new String[]{"高效过滤器","AAF HEPA13 PTFE材质高效过滤器","3M HEPA13 高效过滤器"})
				.addValue(new String[]{"风机","ebmpapst Radical 德国原产风机","ebmpapst Radical 德国原产风机"})
				.addValue(new String[]{"滚轮","4个滚轮，方便移动","4个滚轮，方便移动"})
				.addValue(new String[]{"","<a href='../aps550m/index.html'><b><font color='#009bdf'>浏览产品网站</font></b></a>","<a href='../aps480m/index.html'><b><font color='#009bdf'>浏览产品网站</font></b></a>"})
				
				)

					
						);
	}
	@RequestMapping(value = "/ag")
	public String ag(HttpServletRequest request, HttpServletResponse response) {
		SolutionParam param = this.generateParam(1);
		param.addSample(new SolutionSampleParam(
				"简介",
				"ag_670x383.png",
				"AG系列气相净化系统主要用于商业楼宇的空气净化，既能与原楼宇新风系统相匹配，也可设计成新风机组的形式。机组内部的多种媒体和颗粒物净化段可有效去处有害气体和颗粒物，提供洁净的新风。同时，IIECC工程师会定时跟踪机组内部媒体的更换时间，始终确保媒体工作的有效性和稳定性。"));

		List<PartnerGroupParam> details = new ArrayList<PartnerGroupParam>();

		PartnerGroupParam partnerGroupParam = new PartnerGroupParam("特点", "li");
		partnerGroupParam.addPartnerParam(new PartnerParam("异味去除（非化学药剂气味掩蔽法）",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("精心设计的过滤器串联次序，尽可能减少维护和更换费用",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("无障碍设计，可适应天花板夹层安装",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("经严格论证和检验的化学媒体，用于气相过滤",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("配备1～3级的气相过滤段",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("可提供客户定制服务（模块化组件、可用于消毒的紫外光发生器等）",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("专用于厨房的风机，带检修门和水管以便清洁，另带有置于“外排气流”的全封闭扇冷却式电机",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("“VFD”（可变频率驱动器）以有线，集成或另外提供的方式供选用，适应场所负荷/气流条件",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("检修门和控制面板的两面均易于维护安装",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("可选冷却盘管或循环盘管和板式换热器，根据实际应用和本地法规要求进行能量回收",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("全封闭扇冷却式电机，绝缘等级F，高效感应类型，可用频率为50 & 60 Hz",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("适用于排放气体到停车场和其它非重要区域（区域的界定参照本地法规）",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("整体去除率超过95%",null));
		details.add(partnerGroupParam);

		partnerGroupParam = new PartnerGroupParam("标准配置");
		partnerGroupParam
				.addPartnerParam(new PartnerParam("过滤器压力梯度监测系统DPMS-5—整个机组配有压力仪表，可以监测气流通过预过滤器、所有中过滤器和整个系统后的压降。压力仪表箱可以现场更换安装位置，自选位于机组的左边或右边，以便于使用。",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("机组表面涂有1.5 lbs∕ft<sup>3</sup> （24 kg∕m<sup>3</sup>）的绝缘材料。", null));

		details.add(partnerGroupParam);

		partnerGroupParam = new PartnerGroupParam("可选配置");
		partnerGroupParam.addPartnerParam(new PartnerParam("冷却或加热盘管段，根据新风负荷不同，可配置冷却或加热盘管；", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("UV灯或等离子发生器段，可有效杀菌以及病毒，部分去除甲醛等TVOC（Total Volatile Organic Compounds，TVOC是影响室内空气品质中三种污染中影响较为严重的一种。）成份。",null));

		details.add(partnerGroupParam);

		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "productDetail2");
		request.setAttribute("productDetailPage", "productDetailPage4");
		request.setAttribute("details", details);
		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/hds")
	public String hds(HttpServletRequest request, HttpServletResponse response) {
		SolutionParam param = this.generateParam(2);
		param.addSample(new SolutionSampleParam("简介", "hds_670x383.png",
				"HDS系列高浓度气体洗涤器净化机组是经专业设计，用于去除腐蚀性、恶臭和有毒气体的净化设备，特别适合要求高去除率和较长媒体使用寿命的应用场合。"));
		param.addSample(new SolutionSampleParam(
				null,
				null,
				"HDS机组主要由三个部分组成：工业风机，载有化学介质船体和排气段微粒过滤段，过滤器部分。受污染空气如硫化氢、二氧化硫、氯、氨等，由防滑节装工业风机吹入，然后强行通过Multi-Mix<sup>®</sup> 媒体床去除污染物。媒体的选择及其深度，取决于污染物的类型和严重程度。为获得最佳的污染物去除率，可通过增加媒体床深度延长气体滞留时间，应保证至少0.6秒。随后，空气将通过经ASHRAE认证、效率达90%的后端尘埃过滤器，最后排入大气。IIECC实验室将对使用媒体进行周期性取样分析，以确定媒体的剩余寿命并优化系统运作。"));

		List<PartnerGroupParam> details = new ArrayList<PartnerGroupParam>();

		PartnerGroupParam partnerGroupParam = new PartnerGroupParam("特点", "li");

		partnerGroupParam.addPartnerParam(new PartnerParam("可靠的结构，最大程度应对腐蚀和其它恶劣环境状况", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("种类齐全的Multi-Mix<sup>®</sup>Media 气相净化媒体，适应不同的应用要求", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("工厂组装并以滑动底座包装，便于安装和调试", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("媒体卸载的逆流设计减少了维护停机时间，并允许卸载部分媒体床", null));		details.add(partnerGroupParam);

		partnerGroupParam = new PartnerGroupParam("可选配置", "li");

		partnerGroupParam
				.addPartnerParam(new PartnerParam("100%附加风机（备用）", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("预热段", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("惯性集尘器", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("FRP材质支撑结构", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("控制面板（预置或拆装运输）",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("预除湿器", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("PGCS：压力梯度控制系统",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("可使系统保持不间断运作的媒体保留器",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("防爆保护装置", null));
		details.add(partnerGroupParam);

		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "productDetail2");
		request.setAttribute("productDetailPage", "productDetailPage4");
		request.setAttribute("details", details);

		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/das")
	public String das(HttpServletRequest request, HttpServletResponse response) {
		SolutionParam param = this.generateParam(3);
		param.addSample(new SolutionSampleParam(
				"简介",
				"das_670x383.png",
				"DAS系列深床式气相净化机组可有效净化空气中的恶臭、有毒、腐蚀等气态污染物。这些污染物通常来源于化学物质、化肥、药物、食品加工、废物中转站、焚化场、垃圾处理站等，因其不断扩散，严重污染周边环境，因此，有效控制污染物的排放，创造安全舒适的工作环境已经越来越成为人们关注的问题。"));
		param.addSample(new SolutionSampleParam(
				null,
				null,
				"针对污染物特别复杂的特定场合，DAS系列深床式气相净化机组可精确组合多种化学媒体，形成气相净化过滤段，达到最佳的净化效果。此外，DAS系列深床式气相净化机组的维护也无需湿式洗涤器复杂繁琐的保养程序，只需每年更换气相净化媒体即可。"));

		List<PartnerGroupParam> details = new ArrayList<PartnerGroupParam>();

		PartnerGroupParam partnerGroupParam = new PartnerGroupParam("特点", "li");

		partnerGroupParam.addPartnerParam(new PartnerParam("三层防腐涂层保护镀锌板", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("30%初效过滤器2\"（MERV6）", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("最多达三段的化学过滤媒体箱用以控制", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("臭味及腐蚀空气", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("30%中效过滤器2\" （MERV6）", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("90%的高效过滤器12\"（MERV14）", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("后倾离心风机", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("网孔不锈钢316媒体箱段", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("大尺寸化学媒体填充口", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("大尺寸化学媒体卸载门（可选真空口）", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("全尺寸的检修门", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("高强度不锈钢铰链及门锁", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("C型内腔", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("双层面板保温结构", null));
		details.add(partnerGroupParam);

		partnerGroupParam = new PartnerGroupParam("可选配置", "li");
		partnerGroupParam.addPartnerParam(new PartnerParam("可选压差控制系统", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("可选电源控制箱", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("可选消声器", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("可选感温探头", null));

		details.add(partnerGroupParam);

		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "productDetail2");
		request.setAttribute("productDetailPage", "productDetailPage4");
		request.setAttribute("details", details);

		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/usah")
	public String usah(HttpServletRequest request, HttpServletResponse response) {
		SolutionParam param = this.generateParam(4);
		param.addSample(new SolutionSampleParam(
				"简介",
				"usah_670x383.png",
				"USAH通用侧开门系列气相净化机组，具备常用边开门机组的所有优点：可选的微过滤器单元都可调，机组占有空间更少，维修更方便、维修费用更低，空气质量控制更强。具有多种类型的气体过滤单元，设计师可选择特制的多混合过滤媒体介质、组合各种气体过滤单元，以满足每种安装的严格要求。USAH通用侧开门系列气相净化机组可通过灵活的调整，来控制净化所有的颗粒污染和气体污染。"));

		List<PartnerGroupParam> details = new ArrayList<PartnerGroupParam>();

		PartnerGroupParam partnerGroupParam = new PartnerGroupParam("特点", "div");
		partnerGroupParam.addPartnerParam(new PartnerParam("USAH在工厂完整组装，整体船运。", "工厂组装完整"));
		partnerGroupParam.addPartnerParam(new PartnerParam("1.6毫米（16gauge）镀锌钢板材料，由三层板组成，耐腐蚀涂料，标准的外壳设备，设计成U型滑道的坚固框架结构，提供最可操作性的使用设备。",	"牢固的结构"));
		partnerGroupParam.addPartnerParam(new PartnerParam("USAH特点是铝压过滤装置加上尼龙密封条，防止空气泄漏。多种可选的滑道规格能满足几乎任何的过滤器元件的特定需求。",	"过滤器安装滑道"));
		partnerGroupParam.addPartnerParam(new PartnerParam("现有多种USAH尺寸能满足各种客户对空气处理系统的要求。", "尺寸灵活性"));
		partnerGroupParam.addPartnerParam(new PartnerParam("MM单元是24gauge喷耐腐蚀油漆的带孔板。每个抽取式模块包括快速开门装置而无需工具打开。可选不锈钢板材。","气体过滤模块"));
		partnerGroupParam.addPartnerParam(new PartnerParam("正压门是由氯丁橡胶发泡密封的，媒体过滤器滑道由尼龙材料密封，在所有防漏交接处由防漏硅橡胶密封。", "密封度高"));
		partnerGroupParam.addPartnerParam(new PartnerParam("牢固的侧检修门有快速开门锁，以便检查和更换。", "维修方便"));
		partnerGroupParam.addPartnerParam(new PartnerParam("具有正规的多混合媒体箱样本实验室（只供实验人员使用），提供媒体箱的更换服务。", "TECH-CHEK<sup>TM</sup>服务"));

		details.add(partnerGroupParam);

		partnerGroupParam = new PartnerGroupParam("可选配置", "li");
		partnerGroupParam.addPartnerParam(new PartnerParam("初效过滤器", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("中效过滤器", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("高效过滤器", null));
		partnerGroupParam.addPartnerParam(new PartnerParam("高灰尘场合用惯性分离器做预过滤",null));
		partnerGroupParam.addPartnerParam(new PartnerParam("Multi-Mix<sup>®</sup> Media气相净化媒体",null));

		details.add(partnerGroupParam);

		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "productDetail2");
		request.setAttribute("productDetailPage", "productDetailPage4");
		request.setAttribute("details", details);

		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/multi_mix")
	public String multiMix(HttpServletRequest request,
			HttpServletResponse response) {
		SolutionParam param = this.generateParam(5);
		param.setTitle("Multi-Mix<sup>®</sup> Media气相净化媒体");

		List<MainGroupParam> details = new 	ArrayList<MainGroupParam>();
		this.initMultiMixOverview(details);
		this.initMultiMixMM1000(details);
		this.initMultiMixMM3000(details);
		this.initMultiMixMM7000(details);
		this.initMultiMixMM9000(details);
		
		Map<Integer,String> keys = new HashMap<Integer, String>();
		keys.put(0, "概览");
		keys.put(1, "MM1000");
		keys.put(2, "MM3000");
		keys.put(3, "MM7000");
		keys.put(4, "MM9000");
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "productDetail3");
		request.setAttribute("productDetailPage", "productDetailPage5");
		request.setAttribute("details", details);
		request.setAttribute("keys", keys);
		return "/template/2ndTemplate.jsp";
	}

	public void initMultiMixOverview(List<MainGroupParam> details){
//		details.add((new MainGroupParam(null,null))
//				.addValue(new DivGroupParam(null, "Multi-Mix<sup>®</sup> Media气相净化媒体， 专门设计用于去除广泛的空气污染物。Multi-Mix<sup>®</sup> Media气相净化媒体种类繁多，即可以单独使用，也可以组合使用，并为商业和工业环境腐蚀性、异味及有毒污染物提供持续不断的净化空气。"))

		details.add((new MainGroupParam(null,null))
				.addValue(new RowGroupParam(null, null)
					.addValue(new DivGroupParam(null, "Multi-Mix<sup>®</sup> Media气相净化媒体， 专门设计用于去除广泛的空气污染物。Multi-Mix<sup>®</sup> Media气相净化媒体种类繁多，即可以单独使用，也可以组合使用，并为商业和工业环境腐蚀性、异味及有毒污染物提供持续不断的净化空气。").setCssClassName("col-xxs-12 col-md-6"))
					.addValue(new ImageGroupParam(null).addValue(new ImageParam("/product/multi-mix_media_670x383.png")).setCssClassName("col-xxs-12 col-md-6"))
				)
			
				.addValue(new TableGroupParam("")
						.addHeader(new TableHeaderParam("媒体", "100px")).addHeader(new TableHeaderParam("说明")).addHeader(new TableHeaderParam("应用"))
						.addValue(new String[]{"MM‐100","活性氧化铝颗粒浸渍金属催化剂","室温催化去除一氧化碳（CO）"})
						.addValue(new String[]{"MM‐200","氢氧化钙浸渍钠和钾的氢氧化物","去除二氧化碳（CO<sub>2</sub>）"})
						.addValue(new String[]{"MM‐1000","活性氧化铝颗粒浸渍到4-5%高锰酸钾","氧化范围从有机到无机污染物。（如：甲醛，硫化氢）"})
						.addValue(new String[]{"MM‐1000C","超大的MMM‐1000粉碎成块","比普通的MM-1000有更高的去除效率"})
						.addValue(new String[]{"MM‐1100","活性氧化铝颗粒浸渍到8-9%高锰酸钾","比普通的MM-1000有更高的性能"})
						.addValue(new String[]{"MM‐3000","煤基70 CTC活性炭颗粒（直径3毫米的圆柱体）","吸附有机蒸汽"})
						.addValue(new String[]{"MM‐3000LP","煤基70 CTC活性炭颗粒（直径4毫米的圆柱体）","比常规的MM-3000有较低的压降"})
						.addValue(new String[]{"MM‐3000C","椰壳基活性炭","对较轻的有机蒸汽有较高的吸附性能能"})
						.addValue(new String[]{"MM‐6000","氢氧化钙颗粒浸渍钠和钾的氢氧化物","去除高浓度的氯气（用于紧急洗涤器）"})
						.addValue(new String[]{"MM‐7000","活性炭颗粒浸渍磷酸","去除碱性气体，如氨气"})
						.addValue(new String[]{"MM‐7000C","椰壳活性炭浸渍磷酸","用于非常低浓度的氨气（ppb级）"})
						.addValue(new String[]{"MM‐8000","活性炭浸渍碘","用于去除汞（水银）"})
						.addValue(new String[]{"MM‐9000","活性炭颗粒浸渍氢氧化钾（直径3毫米圆柱体）","去除酸性气体（.氢、氯气），此外也有去除有机蒸汽的性能"})
						.addValue(new String[]{"MM‐9000LP","活性炭颗粒浸渍氢氧化钾（直径4毫米圆柱体）","比常规的MM-9000有较低的压降"})
						.addValue(new String[]{"MM‐9000LT","活性炭颗粒与轻度浸渍氢氧化钾","对于酸性气体比常规的MM-9000有较低的性能，但对有机蒸汽有较高的性能"})
						.addValue(new String[]{"MM‐9000LTC","椰壳活性炭与轻度浸渍氢氧化钾","用于去除低浓度的酸性气体（户外NO<sub>X</sub>、SO<sub>2</sub>）和有机蒸气"}).setDoDelim(true))
				.addValue(new DivGroupParam("混合媒体","混合媒体主要应用于以下两种情况：</br>1、依靠单一媒体不能有效去除一定范围内的气体或气体污染物；</br>2、无足够预算或空间使用多床过滤结构；</br></br>最常见的混合媒体如下表所示："))
				.addValue(new TableGroupParam("")
						.addHeader(new TableHeaderParam("媒体", "100px")).addHeader(new TableHeaderParam("说明")).addHeader(new TableHeaderParam("应用"))
						.addValue(new String[]{"MM‐1355","由MM-1000和MM-3000按照50%的比例混合","适用于去除综合的气味，可去除广泛的有机和无机污染物"})
						.addValue(new String[]{"MM‐1955","由MM-1000和MM-9000按照50%的比例混合","适用于工业上去除广泛的腐蚀性气体"})
						.addValue(new String[]{"MM‐1955LTC</br>CleanAire","由MM-1000C和MM-9000LTC按照50%的比例混合","非常适用于过滤净化空气，改善室内空气质量"}))
				.addValue(new DivGroupParam(null, "另外，我们还提供特殊用途的媒体，如核电站专用活性炭，可用于吸收放射性碘等。"))
		);
	}
	public void initMultiMixMM1000(List<MainGroupParam> details){
		details.add((new MainGroupParam(null,null))
				.addValue(new DivGroupParam(null, "MM-1000 Multi-Mix<sup>®</sup> 媒体是一种高表面积的活性氧化铝颗粒，经高锰酸钾浸渍制造而成。是一种能增强性能的化学过滤器，用于去除硫化氢（H<sub>2</sub>S），二氧化硫（SO<sub>2</sub>），二氧化氮（NO<sub>2</sub>），硫醇，以及气流中轻量有机物。MM-1000 Multi-Mix<sup>®</sup> 媒体是一种化学吸附剂，通过吸附和氧化来过滤，由于球状形态、大小均匀，具有低压降。"))
				.addValue(new DivGroupParam("典型的物理属性", null))
				.addValue(new TableGroupParam(null)
				.addHeader(new TableHeaderParam("物理属性", "50%")).addHeader(new TableHeaderParam("数值"))
				.addValue(new String[]{"H<sub>2</sub>S的容量（最小）","0.10 g H<sub>2</sub>S/cc"})
				.addValue(new String[]{"水分","22 wt%"})
				.addValue(new String[]{"压实（最小）","2.7 kg （6 lb.）"})
				.addValue(new String[]{"颗粒直径","3.2 mm （1/8 in.）"})
				.addValue(new String[]{"基体的表面面积","250 m<sup>2</sup>/g"})
				.addValue(new String[]{"形状"," Spherical Pellet"})
				.addValue(new String[]{"表观密度"," 0.88 g/cc （55 lb./ft<sup>3</sup>）"})
				.addValue(new String[]{"压降@ 50 fpm （0.25 m/s）"," 1.0 in. of water/ft. of bed"}).setDoDelim(true))
				.addValue(new DivGroupParam("性能准则",null))
				.addValue(new UlGroupParam("MM-1000 Multi-Mix<sup>®</sup> 媒体在下列条件下性能稳定：")
					.addValue("温度：-20℃至51℃（-4℉至125℉）")
					.addValue("湿度：10%至95%RH")
					.addValue("风量：从小于25立方英尺至超过100,000立方英尺，风速从50英尺/分钟（0.254米/秒）至500英尺/分钟（2.54米/秒）。").setDoDelim(true))
				
				.addValue(new DivGroupParam("质量控制",null))
				.addValue(new UlGroupParam("MM-1000 Multi-Mix<sup>®</sup> 媒体在装运前经过了以下质量控制测试：")
					.addValue("高锰酸钾含量")
					.addValue("水分含量")
					.addValue("粒度分布")
					.addValue("体积密度")
					.addValue("压实").setDoDelim(true))
				
				.addValue(new DivGroupParam("优势",null))
				.addValue(new UlGroupParam(null)
					.addValue("无毒，无害")
					.addValue("非解吸")
					.addValue("不支持细菌或真菌生长")
					.addValue("UL认证1级不可燃")
					.addValue("与其他的Multi-Mix<sup>®</sup> 媒体可兼容")
					.addValue("通过TECH-CHEK<sup>TM</sup>服务，实验室检测和分析可确定剩余使用寿命。").setDoDelim(true))
				.addValue(new DivGroupParam("安全预防措施",null))
				.addValue(new UlGroupParam(null)
					.addValue("避免接触易氧化物质")
					.addValue("远离热源和易燃材料")
					.addValue("在通风良好的区域操作")
					.addValue("储存在阴凉、干燥区域，远离不相容的材料")
					.addValue("当操作化学媒体时，始终佩戴护目镜和手套")
					.addValue("当处理Multi-Mix<sup>®</sup> 媒体时，工人应该遵循当地的安全指引")
					.addValue("更多信息请参考材料安全数据表（M.S.D.S.）")
					
						));
	}
	public void initMultiMixMM3000(List<MainGroupParam> details){
		details.add((new MainGroupParam(null,null))
				.addValue(new DivGroupParam(null, "MM-3000 Multi-Mix<sup>®</sup> 媒体是一种活性炭颗粒，通过物理吸附，可去除各种有机化合物和挥发性有机化合物（VOCs）的臭味。MM-3000 Multi-Mix<sup>®</sup> 媒体是从一种独特的烟煤培养基激活和制造而成的吸附剂，具有低压降和高吸附去除能力。"))
				.addValue(new DivGroupParam("典型的物理属性", null))
				.addValue(new TableGroupParam(null)
				.addHeader(new TableHeaderParam("物理属性", "50%")).addHeader(new TableHeaderParam("数值"))
					.addValue(new String[]{"水分（最大）","2 wt%"})
					.addValue(new String[]{"硬度（最小）","95 wt%"})
					.addValue(new String[]{"颗粒直径","3 mm"})
					.addValue(new String[]{"基体的CTC（最小）","70 wt%"})
					.addValue(new String[]{"基体的表面面积","1,250 m2/g"})
					.addValue(new String[]{"形状","Pellet"})
					.addValue(new String[]{"表观密度","30 lb./ft<sup>3</sup>"})
					.addValue(new String[]{"灰分含量","12% maximum"})
					.addValue(new String[]{"压降@ 50 fpm （0.25 m/s）","1.7 in. of water/ft. of bed"}).setDoDelim(true))
					
				.addValue(new DivGroupParam("性能准则",null))
				.addValue(new UlGroupParam("MM-3000 Multi-Mix®媒体在下列条件下性能稳定：")
					.addValue("温度：-20℃至46℃（-4℉至115℉）")
					.addValue("湿度：不凝结")
					.addValue("风量：从小于25立方英尺至超过100,000立方英尺，风速从50英尺/分钟（0.254米/秒）至500英尺/分钟（2.54米/秒）。").setDoDelim(true))

				.addValue(new DivGroupParam("质量控制",null))
				.addValue(new UlGroupParam("MM-3000 Multi-Mix<sup>®</sup> 媒体在装运前经过了以下质量控制测试：")
					.addValue("丁烷活性")
					.addValue("水分含量")
					.addValue("粒度分布")
					.addValue("体积密度").setDoDelim(true))

				.addValue(new DivGroupParam("优势",null))
				.addValue(new UlGroupParam(null)
					.addValue("无毒，无害")
					.addValue("UL认证1级不可燃")
					.addValue("与其他的Multi-Mix<sup>®</sup> 媒体可兼容")
					.addValue("通过TECH-CHEK<sup>TM</sup> 服务，实验室检测和分析可确定剩余使用寿命。").setDoDelim(true))
				.addValue(new DivGroupParam("安全预防措施",null))
				.addValue(new UlGroupParam(null)
					.addValue("潮湿的活性炭易于吸收大气中的氧气。密闭容器和通风不畅的区域可能存在危险的低氧状况。在进入低氧区域时，工人应该遵循联邦，省/州和当地的安全指引。")
					.addValue("远离热源")
					.addValue("在通风良好的区域操作")
					.addValue("储存在阴凉、干燥区域，远离不相容的材料")
					.addValue("当操作化学媒体时，始终佩戴护目镜和手套")
					.addValue("当处理Multi-Mix<sup>®</sup> 媒体时，工人应该遵循当地的安全指引")
					.addValue("更多信息请参考材料安全数据表（M.S.D.S.）")
					
						));
	}
	public void initMultiMixMM7000(List<MainGroupParam> details){
		details.add((new MainGroupParam(null,null))
				.addValue(new DivGroupParam(null, "MM-7000 Multi-Mix<sup>®</sup> 媒体是一种磷酸浸渍的增强性能的活性炭颗粒，用于去除基本的气体，如来自气流中的氨气（NH<sub>3</sub>）。MM-7000 Multi-Mix<sup>®</sup> 媒体是一种从独特的烟煤培养基制造而成的化学吸附剂，具有低压降和高吸附去除能力。"))
				.addValue(new DivGroupParam("典型的物理属性", null))
				.addValue(new TableGroupParam(null)
				.addHeader(new TableHeaderParam("物理属性", "50%")).addHeader(new TableHeaderParam("数值"))
				.addValue(new String[]{"NH<sub>3</sub>的容量（最小）","5.5 wt% （0.05 g NH<sub>3</sub>/cc）"})
				.addValue(new String[]{"水分","15 wt%"})
				.addValue(new String[]{"基体硬度","95 wt%"})
				.addValue(new String[]{"颗粒直径","3 mm"})
				.addValue(new String[]{"基体的CTC","70 wt%"})
				.addValue(new String[]{"基体的表面面积","1,250 m<sup>2</sup>/g"})
				.addValue(new String[]{"形状"," Pellet"})
				.addValue(new String[]{"表观密度"," 0.64 g/cc （40 lb./ft<sup>3</sup>）"})
				.addValue(new String[]{"压降@ 50 fpm （0.25 m/s）","1.7 in. of water/ft. of bed"}).setDoDelim(true))

				.addValue(new DivGroupParam("性能准则",null))
				.addValue(new UlGroupParam("MM-7000 Multi-Mix<sup>®</sup> 媒体在下列条件下性能稳定：")
					.addValue("温度：-20℃至51℃（-4℉至125℉）")
					.addValue("湿度：10%至95%RH")
					.addValue("风量：从小于25立方英尺至超过100,000立方英尺，风速从60英尺/分钟（0.305米/秒）至500英尺/分钟（2.54米/秒）。").setDoDelim(true))
				.addValue(new DivGroupParam("质量控制",null))
				.addValue(new UlGroupParam("MM-7000 Multi-Mix<sup>®</sup> 媒体在装运前经过了以下质量控制测试：")
					.addValue("磷酸含量")
					.addValue("水分含量")
					.addValue("粒度分布")
					.addValue("体积密度").setDoDelim(true))
				
				.addValue(new DivGroupParam("优势",null))
				.addValue(new UlGroupParam(null)
					.addValue("无害")
					.addValue("非解吸")
					.addValue("不支持细菌或真菌生长")
					.addValue("媒体浸渍能特别有效地去除氨气")
					.addValue("与其他的Multi-Mix<sup>®</sup> 媒体可兼容")
					.addValue("通过TECH-CHEK<sup>TM</sup>服务，实验室检测和分析可确定剩余使用寿命。").setDoDelim(true))
				.addValue(new DivGroupParam("安全预防措施",null))
				.addValue(new UlGroupParam(null)
					.addValue("潮湿的活性炭易于吸收大气中的氧气。密闭的容器和通风不畅的区域可能存在危险的低氧水平。在进入低氧区域时，工人应该遵循联邦，省/州和当地的安全指引。")
					.addValue("远离热源")
					.addValue("在通风良好的区域操作")
					.addValue("储存在阴凉、干燥区域，远离不相容的材料")
					.addValue("当操作化学媒体时，始终佩戴护目镜和手套")
					.addValue("当处理Multi-Mix<sup>®</sup> 媒体时，工人应该遵循当地的安全指引")
					.addValue("更多信息请参考材料安全数据表（M.S.D.S.）")
					
						));
	}
	public void initMultiMixMM9000(List<MainGroupParam> details){
		details.add((new MainGroupParam(null,null))
				.addValue(new DivGroupParam(null, "MM-9000 Multi-Mix<sup>®</sup> 媒体是一种增强性能的氢氧化钾浸渍粒状活性炭，用于去除污染气流中的酸性气体，如：硫化氢（H<sub>2</sub>S），二氧化硫（SO<sub>2</sub>），氯气（CL<sub>2</sub>），和盐酸（HCL）。MM-9000 Multi-Mix<sup>®</sup> 媒体是一种从独特的烟煤培养基制造而成的化学吸附剂，具有低压降和高吸附去除能力。"))
				.addValue(new DivGroupParam("典型的物理属性", null))
				.addValue(new TableGroupParam(null)
				.addHeader(new TableHeaderParam("物理属性", "50%")).addHeader(new TableHeaderParam("数值"))
				.addValue(new String[]{"H<sub>2</sub>S的容量（最小）","0.16 g H<sub>2</sub>2S/cc"})
				.addValue(new String[]{"水分（最大） ","15 wt%"})
				.addValue(new String[]{"基体硬度（最小）","95 wt%"})
				.addValue(new String[]{"颗粒直径","3 mm"})
				.addValue(new String[]{"基体的CTC","70 wt%"})
				.addValue(new String[]{"基体的表面面积","1,250 m<sup>2</sup>/g"})
				.addValue(new String[]{"形状"," Pellet"})
				.addValue(new String[]{"表观密度","0.61 g/cc （38 lb./ft<sup>3</sup>）"})
				.addValue(new String[]{"压降@ 50 fpm （0.25 m/s）","1.7 in. of water/ft. of bed"}).setDoDelim(true))


				.addValue(new DivGroupParam("性能准则",null))
				.addValue(new UlGroupParam("MM-7000 Multi-Mix<sup>®</sup> 媒体在下列条件下性能稳定：")
					.addValue("温度：-20℃至51℃（-4℉至125℉）")
					.addValue("湿度：10%至95%RH")
					.addValue("风量：从小于25立方英尺至超过100,000立方英尺，风速从60英尺/分钟（0.305米/秒）至500英尺/分钟（2.54米/秒）。").setDoDelim(true))
				.addValue(new DivGroupParam("质量控制",null))
				.addValue(new UlGroupParam("MM-9000 Multi-Mix<sup>®</sup> 媒体在装运前经过了以下质量控制测试")
					.addValue("氢氧化钾含量")
					.addValue("水分含量")
					.addValue("粒度分布")
					.addValue("体积密度").setDoDelim(true))
				.addValue(new DivGroupParam("优势",null))
				.addValue(new UlGroupParam(null)
					.addValue("最大去除H<sub>2</sub>S的能力")
					.addValue("设备使用媒体更换的频率更少，保护的时间更长")
					.addValue("可用于所有的碳基的空气过滤系统")
					.addValue("无毒")
					.addValue("非解吸")
					.addValue("不支持细菌或真菌生长")
					.addValue("与其他的Multi-Mix<sup>®</sup> 媒体可兼容")
					.addValue("通过TECH-CHEK<sup>TM</sup>服务，实验室检测和分析可确定剩余使用寿命。").setDoDelim(true))
				.addValue(new DivGroupParam("安全预防措施",null))
				.addValue(new UlGroupParam(null)
					.addValue("潮湿的活性炭易于吸收大气中的氧气。密闭的容器和通风不畅的区域可能存在危险的低氧水平。在进入低氧区域时，工人应该遵循联邦，省/州和当地的安全指引。")
					.addValue("远离热源和易燃材料")
					.addValue("在通风良好的区域操作")
					.addValue("储存在阴凉、干燥区域，远离不相容的材料")
					.addValue("当处理化学媒体时，始终佩戴护目镜和手套")
					.addValue("当处理Multi-Mix<sup>®</sup> 媒体时，工人应该遵循当地的安全指引")
					.addValue("更多信息请参考材料安全数据表（M.S.D.S.）")
					
						));
	}
	public SolutionParam generateParam(int subItemIndex) {
		SolutionParam param = ProductController.generateParam();
		param.setActiveSubItem(param.getSubItems().get(subItemIndex).getName());
		return param;
	}

	public static SolutionParam generateParam() {
		SolutionParam param = new SolutionParam();
		param.setHeaderPicName("product");
		param.setSubItemTitle("产品系列");
		param.setSubItemHeaderImgInfo("为更有策略性地解决不同场合的空气污染问题，IIECC设计研发了多元产品系列，以适用于各个行业及领域。");
		param.addSubItem("APS系列小型气相净化系统", "product/aps.html");
		param.addSubItem("AG系列气相净化系统", "product/ag.html");
		param.addSubItem("HDS系列高浓度气体洗涤器净化机组", "product/hds.html");
		param.addSubItem("DAS系列深床式气相净化机组", "product/das.html");
		param.addSubItem("USAH通用侧开门系列气相净化机组", "product/usah.html");
		param.addSubItem("Multi-Mix<sup>®</sup> Media气相净化媒体", "product/multi_mix.html");
		return param;
	}
}

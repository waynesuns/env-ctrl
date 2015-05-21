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
import com.ec.website.param.TableHeaderParam;
import com.ec.website.param.TableTdParam;
import com.ec.website.param.group.DivGroupParam;
import com.ec.website.param.group.ImageGroupParam;
import com.ec.website.param.group.MainGroupParam;
import com.ec.website.param.group.OlGroupParam;
import com.ec.website.param.group.RowGroupParam;
import com.ec.website.param.group.TableGroupParam;
import com.ec.website.param.group.UlGroupParam;
import com.ec.website.util.DataImportUtil;

@Controller
@RequestMapping(value = "/technology")
public class TechnologyController extends AbstractController {
	
	@RequestMapping(value = "/energy_conservation")
	public String energyConservation(HttpServletRequest request, HttpServletResponse response)
	{

		SolutionParam param = this.generateParam(4);
		Map<String, MainGroupParam> details = new HashMap<String, MainGroupParam>();
		
		
		details.put("overView",(new MainGroupParam(null,null))
				.addValue(new DivGroupParam(null, "IIECC在设计产品效能时考虑了节能，因此，我们选择了德国ebmpapst公司作为提供高效动力的合作伙伴。"))
				.addValue(new DivGroupParam(null, "德国依必安派特（ebmpapst）公司于1963年在德国成立。作为在电机和风机产业领域的技术领导者之一，回收利用、避免浪费、生态材料、降低排放水平、降低能耗从而实现更高的效率是ebmpapst的产品特点，也恰好符合IIECC的一贯要求。此外ebmpapst也是可靠持久的代名词，在正常使用环境下，每一个ebmpapst风机都能连续安全运行5万小时以上。"))
				.addValue(new DivGroupParam(null, "IIECC更在部分产品中选装了绿色科技EC技术（GreenTech）电机，以及RaidCal（超凡曲线）叶轮设计的风机。EC电机为无刷直流驱动装置，集成驱动电子设备，易于控制且效率高达90%，在各种负荷条件下都可安静高效运行。依必安派特（ebmpapst）采用外转子结构的电机设计，电机直接与叶片相连，不仅使电机散热更佳，也令风机结构更紧凑。RadiCal（超凡曲线）叶轮的创新几何结构设计，显著优化了风机的空气动力特性和声学特性，有效增强风机性能，同时降低声噪。绿色电机和创新叶轮的完美结合，打造出了“ 绿色科技EC超凡曲线离心风机” （ ebmpapst GreenTech EC RadiCal Fan），使得安装有这款风机的空气净化系统结构更小巧、性能更卓越、质量更可靠。"))
				.addValue(new ImageGroupParam(null).addValue(new ImageParam("/technology/ebmpapst_670x404.png","图：RadiCal风机在4种不同转速下，各阻力点的风速曲线图。由此可以看出采用EC技术的RadiCal风机在各种条件下的完美表现。")))
		);
		
		
		
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "technology2");
		request.setAttribute("productDetailPage", "productDetailPage5");
		request.setAttribute("details", details);
		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/particles_filter")
	public String particlesFilter(HttpServletRequest request, HttpServletResponse response)
	{

		SolutionParam param = this.generateParam(1);
		Map<String, MainGroupParam> details = new HashMap<String, MainGroupParam>();
		
		
		details.put("overView",(new MainGroupParam(null,null))
				.addValue(new DivGroupParam(null, "IIECC选用有90年历史的国际过滤器大牌AAF公司研制的代表世界先进技术的颗粒物过滤器系列。AAF是全球公认的过滤器行业高品质、专业化和技术革新的代表，是全球最大的商业、工业和住宅用空气过滤器产品的生产厂家和销售商。"))
				.addValue(new DivGroupParam(null, "1960年AAF为阿波罗登月飞船提供空气过滤器，防止月球污染，美国白宫也有使用AAF空气过滤器。"))
				.addValue(new ImageGroupParam(null).addValue(new ImageParam("/technology/particles_filter_670x383.jpg","</br>AAF的系列初效过滤器有着阻力低、容尘量高、使用寿命长、方便清洗的优点。")))
				//.addValue(new DivGroupParam(null, "AAF的系列初效过滤器有着阻力低、容尘量高、使用寿命长、方便清洗的优点。"))
				.addValue(new DivGroupParam(null, "AAF的PTFE材质HEPA高效过滤器及ULPA超高效过滤器，代表了行业内最巅峰的技术，最高能达到对0.1微米的颗粒进行99.999995％的拦截率。"))
				.addValue(new DivGroupParam(null, "PTFE材质的高效和超高效过滤器在更低的能耗下保持着极低的阻力和超高效率，为IIECC设备的完美表现提供了最佳的基础。PTFE材质还具有抗环境腐蚀能力强、极低的化学气体散播性、强度高、符合I11301且通过UL900的防火1级标准等优点。"))
				.addValue(new DivGroupParam(null, "目前世界范围内绝大多数净化产品还是采用玻璃纤维材质的过滤器，而IIECC已经率先在多个系列中采用了PTFE材质的过滤器。并且每片AAF PTFE过滤器在装配前都经过IIECC的严格测试，确保没有任何泄漏点，能让每一个最终用户都放心使用。"))
				.addValue(new ImageGroupParam(null).addValue(new ImageParam("/technology/aaf_670x394.png","图：AAF MEGACel高效过滤器性能曲线图。从这张图中可以看出，在达到同样过滤率的条件下，采用PTFE材质的过滤器可以做到更薄，在同等的面风速条件下，阻力更低，从而能达到更高的效率。")))
		);
		
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "technology2");
		request.setAttribute("productDetailPage", "productDetailPage5");
		request.setAttribute("details", details);
		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/power_refund")
	public String powerRefund(HttpServletRequest request, HttpServletResponse response)
	{

		SolutionParam param = this.generateParam(3);
		Map<String, MainGroupParam> details = new HashMap<String, MainGroupParam>();
		
		
		details.put("overView",(new MainGroupParam(null,null))
				.addValue(new RowGroupParam(null,null)
					.addValue(new DivGroupParam(null, "从室外引进新风、从室内进行排风的同时，会引起能量损失。以夏季为例：因室外温度较高、室内温度较低，室内空气排出时会带走一部分冷量，IIECC设备的全热交换系统能最大限度地回收这部分冷量，从而降低空调能耗。").setCssClassName("col-xxs12 col-md-6"))
					.addValue(new ImageGroupParam(null).addValue(new ImageParam("/technology/energy_recovery_670x383.png",null)).setCssClassName("col-xxs12 col-md-6")))
				.addValue(new DivGroupParam(null, "全热交换器的工作原理：工作时，室内排风和新风分别呈交叉方式逆流经过换热器芯体，由于分隔板两侧的气流存在温差和分压差，两股气流通过分隔板时就会进行传热，产生全热交换过程。夏季运行时，新风从排风侧获得冷量，温度降低；冬季运行时，新风从排风侧获得热量，温度升高。"))
				.addValue(new OlGroupParam(null)
					.addValue("采用独特的热函传递材料进行传热；")
					.addValue("逆流式热交换方式，全热交换效率可达75％；")
					.addValue("ABS 框架结构，风阻低，不会收缩变形，坚固耐用，日常维护简便；")
					.addValue("热交换材料透气率极低，新风排风两股空气完全隔离，无交叉污染；")
					.addValue("可模块组合，维持低风阻同时实现在在大风量产品上的应用；")
				 )
		);
		
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "technology2");
		request.setAttribute("productDetailPage", "productDetailPage5");
		request.setAttribute("details", details);
		return "/template/2ndTemplate.jsp";
	}
	
	@RequestMapping(value = "/gas_filter")
	public String gasFilter(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, IOException
	{

		SolutionParam param = this.generateParam(0);
		Map<String, MainGroupParam> details = new HashMap<String, MainGroupParam>();
		TableTdParam[] a = new TableTdParam[]{};
		details.put("overView",(new MainGroupParam(null,null))
				//.addValue(new RowGroupParam(null,null)
				.addValue(new DivGroupParam(null, "IIECC选用独特的Multi-Mix<sup>®</sup> Media气相净化媒体技术，通过物理吸附、吸收、化学吸附、催化的原理，不可逆地彻底消除空气中各种有毒有害气体。"))
					//.addValue(new DivGroupParam(null, "IIECC选用独特的Multi-Mix® Media气相净化媒体技术，来消除空气中各种有毒有害气体。气相净化媒体的净化原理为：物理吸附、吸收、化学吸附、催化。确保了各种有害气体彻底不可逆的被消除，没有后顾之忧。").setCssClassName("col-xxs12 col-md-6"))
					//.addValue(new ImageGroupParam(null).addValue(new ImageParam("/technology/gas_1.png",null)).setCssClassName("col-xxs12 col-md-6")).setDoDelim(true))
				.addValue(new DivGroupParam(null, "<b>吸附（Adsorption）</b></br>吸附是一种物理过程，污染物（液体、气体、或悬浮物）会吸附在吸附剂材料的表面或是毛孔内。吸附是一个可逆过程，无化学反应发生。"))
				.addValue(new DivGroupParam(null, "<b>吸收（Absorption）</b></br>吸收是指污染物渗透到另一种物质的结构中的过程，这是不同于吸附的地方，吸附是一种物质存在于另一种物质的表面。"))
				.addValue(new DivGroupParam(null, "<b>化学吸附（Chemisorption）</b></br>化学吸附与物理吸附过程相关，化学吸附是指由吸附剂与污染物之间产生的化学作用而产生的吸附，化学吸附是通常被认为是一个不可逆转的进程。"))
				.addValue(new DivGroupParam(null, "<b>催化（Catalysis）</b></br>催化是一个过程，在催化剂的作用下形成另一种物质的化学变化。这种变化（通常是导致或加速化学反应）将去除污染物而催化剂本身没有发生任何变化的。").setDoDelim(true))
				.addValue(new DivGroupParam("气相净化原理", ""))
				.addValue(new ImageGroupParam(null).addValue(new ImageParam("/technology/process_670x563.png",null)).setDoDelim(true))
				.addValue(new DivGroupParam("气相净化示意图", ""))
				.addValue(new ImageGroupParam(null).addValue(new ImageParam("/technology/theory_670x589.png",null)))
				.addValue(new UlGroupParam("不同于现有的其他技术，Multi-Mix<sup>®</sup> Media气相净化媒体具有通用性强、简单可靠、节能、高效的特点。具体表现在：")
					.addValue("Multi-Mix<sup>®</sup>Media适用广泛，可应用于多领域，不论是新建项目或者是改造项目都可以胜任；不需要复杂的维护保养程序；")
					.addValue("Multi-Mix<sup>®</sup>Media具有高挤压强度，不易磨损，高孔隙结构使用寿命更长久；")
					.addValue("Multi-Mix<sup>®</sup>Media稳定性高，在环境温度湿度发生突然变化的情况下，不会释放出已处理的污染物质，适用的温度范围在零下40摄氏度到48.9摄氏度，湿度范围10％到95％；")
					.addValue("充分利用循环空气从而减少对室外空气的需求；")
					.addValue("高效迅速地去除环境中多种空气污染物，并且通过调节媒体配比，可以解决从ppb（10亿分之一）级别的细微污染至超过25ppm（百万分之一）级别的严重的环境污染问题。").setDoDelim(true)
				 )
				 .addValue(new TableGroupParam("经过反复科学实验，我们对Multi-Mix<sup>®</sup>Media气相净化媒体处理各类有毒有害气体的能力进行了如下总结：")
					 .addHeader(new TableHeaderParam("种类")).addHeader(new TableHeaderParam("名称",2)).addHeader(new TableHeaderParam("代表性气味",2))
					 .addValue(new TableTdParam[]{new TableTdParam("醇类</br>ALCOHOLS",3),new TableTdParam("乙醇"),new TableTdParam("Ethyl Alcohol"),new TableTdParam("酒精"),new TableTdParam("Liquor")})
					 .addValue(new TableTdParam[]{new TableTdParam("丙醇"),new TableTdParam("Isopropyl Alcohol"),new TableTdParam("外用酒精"),new TableTdParam("Rubbing alcohol")})
					 .addValue(new TableTdParam[]{new TableTdParam("甲醇"),new TableTdParam("Methyl Alcohol"),new TableTdParam("防冻剂"),new TableTdParam("Antifreeze")})
					 .addValue(new TableTdParam[]{new TableTdParam("醛类</br>ALDEHYDES",3),new TableTdParam("乙醛"),new TableTdParam("Acetaldehyde"),new TableTdParam("浓烈刺鼻的气味",3),new TableTdParam("Sharp, acrid odor",3)})
					 .addValue(new TableTdParam[]{new TableTdParam("丁醛"),new TableTdParam("Butyraldehyde")})
					 .addValue(new TableTdParam[]{new TableTdParam("甲醛"),new TableTdParam("Formaldehyde")})
					 .addValue(new TableTdParam[]{new TableTdParam("生物碱类</br>ALKALOIDS",3),new TableTdParam("吲哚"),new TableTdParam("Indole"),new TableTdParam("蛋白质腐败"),new TableTdParam("Putrefaction of proteins")})
					 .addValue(new TableTdParam[]{new TableTdParam("烟碱"),new TableTdParam("Nicotine"),new TableTdParam("烟雾"),new TableTdParam("Tobacco smoke")})
					 .addValue(new TableTdParam[]{new TableTdParam("类毒素"),new TableTdParam("Skatole"),new TableTdParam("生物排泄物"),new TableTdParam("Putrefaction of proteins-feces")})
					 .addValue(new TableTdParam[]{new TableTdParam("胺类胺类</br>AMINES",4),new TableTdParam("氨水"),new TableTdParam("Ammonia"),new TableTdParam("蛋白生物分解</br>鱼的气味",4),new TableTdParam("Bacterial decomposition of proteins</br>Fish odor",4)})
					 .addValue(new TableTdParam[]{new TableTdParam("尸胺"),new TableTdParam("Cadaverine")})
					 .addValue(new TableTdParam[]{new TableTdParam("腐胺"),new TableTdParam("Putrescine")})
					 .addValue(new TableTdParam[]{new TableTdParam("三甲胺"),new TableTdParam("Trimethylamine")})
					 .addValue(new TableTdParam[]{new TableTdParam("苯类</br>AROMATICS",3),new TableTdParam("乙二苯"),new TableTdParam("Ethyle Benzene"),new TableTdParam("喷粉溶剂气味</br>汽油气味",3),new TableTdParam("Paint solvent odor</br>Gasoline odor",3)})
					 .addValue(new TableTdParam[]{new TableTdParam("甲苯"),new TableTdParam("Toluene")})
					 .addValue(new TableTdParam[]{new TableTdParam("二甲苯"),new TableTdParam("Xylene")})
					 .addValue(new TableTdParam[]{new TableTdParam("酯类</br>ESTERS",3),new TableTdParam("乙酸戊酯"),new TableTdParam("Amyl Acetate"),new TableTdParam("香蕉气味"),new TableTdParam("Banana odor")})
					 .addValue(new TableTdParam[]{new TableTdParam("酞酸二辛酯"),new TableTdParam("Dioctyl Pthalate"),new TableTdParam("可塑剂"),new TableTdParam("Plasticizer")})
					 .addValue(new TableTdParam[]{new TableTdParam("腊酸乙酯"),new TableTdParam("Ethyl Acetate"),new TableTdParam("去指甲油"),new TableTdParam("Nail polish remover")})
					 .addValue(new TableTdParam[]{new TableTdParam("醚类</br>ETHERS",3),new TableTdParam("二丁醚"),new TableTdParam("Butyl Ether"),new TableTdParam("有机物溶解"),new TableTdParam("Organic solvent")})
					 .addValue(new TableTdParam[]{new TableTdParam("乙醚"),new TableTdParam("Ethyl Ether"),new TableTdParam("麻醉剂"),new TableTdParam("Anesthetic")})
					 .addValue(new TableTdParam[]{new TableTdParam("丙醚"),new TableTdParam("Propyl Ether"),new TableTdParam("有机溶剂"),new TableTdParam("Organic solvent")})
					 .addValue(new TableTdParam[]{new TableTdParam("酮类</br>KETONES",3),new TableTdParam("丙酮"),new TableTdParam("Acetone"),new TableTdParam("有机溶剂",3),new TableTdParam("Organic solvent",3)})
					 .addValue(new TableTdParam[]{new TableTdParam("一甲酮"),new TableTdParam("Dipropyl Ketone")})
					 .addValue(new TableTdParam[]{new TableTdParam("丁酮"),new TableTdParam("Methyl Ethyl Ketone")})
					 .addValue(new TableTdParam[]{new TableTdParam("硫醇类</br>MERCAPTANS",3),new TableTdParam("丁硫醇"),new TableTdParam("Butyl Mercaptan"),new TableTdParam("恶臭（臭鼬）"),new TableTdParam("Stench（skunk odor）")})
					 .addValue(new TableTdParam[]{new TableTdParam("乙硫醇"),new TableTdParam("Ethyl Mercaptan"),new TableTdParam("类似于丁硫醇臭气"),new TableTdParam("Stench（similar to Butyl Mercaptan）")})
					 .addValue(new TableTdParam[]{new TableTdParam("甲硫醇"),new TableTdParam("Methyl Mercaptan"),new TableTdParam("天然气中臭气"),new TableTdParam("Odorant in natural gas")})
					 .addValue(new TableTdParam[]{new TableTdParam("树酯类</br>OLEFINES",3),new TableTdParam("乙炔"),new TableTdParam("Acetylene"),new TableTdParam("工业气体",3),new TableTdParam("Industrial gas, odorless",3)})
					 .addValue(new TableTdParam[]{new TableTdParam("丁烯"),new TableTdParam("Butylene")})
					 .addValue(new TableTdParam[]{new TableTdParam("乙烯"),new TableTdParam("Ethylene")})
					 .addValue(new TableTdParam[]{new TableTdParam("有机酸类</br>ORGANIC ACIDS",5),new TableTdParam("乙酸"),new TableTdParam("Acetic Acid"),new TableTdParam("醋"),new TableTdParam("Vinegar")})
					 .addValue(new TableTdParam[]{new TableTdParam("丁酸"),new TableTdParam("Butyric Acid"),new TableTdParam("腐化油脂气味"),new TableTdParam("Odor of rancid butter")})
					 .addValue(new TableTdParam[]{new TableTdParam("辛酸"),new TableTdParam("Caprylic Acid"),new TableTdParam("动物油脂分解"),new TableTdParam("Decomposition of animal fats and oils")})
					 .addValue(new TableTdParam[]{new TableTdParam("异戊酸"),new TableTdParam("Isovaleric Acid"),new TableTdParam("动物油脂分解"),new TableTdParam("Decomposition of animal fats and oils")})
					 .addValue(new TableTdParam[]{new TableTdParam("丙酸"),new TableTdParam("Propionic Acid"),new TableTdParam("剧烈气味类酯酸"),new TableTdParam("Sharp odor （similar to vinegar）")})
					 .addValue(new TableTdParam[]{new TableTdParam("氧化物</br>OXIDES",4),new TableTdParam("一氧化碳"),new TableTdParam("Carbon Monoxide"),new TableTdParam("有毒气体</br>刺激性气体",4),new TableTdParam("Toxic, odorless gas</br>Toxic, irritating gas",4)})
					 .addValue(new TableTdParam[]{new TableTdParam("二氧化氮"),new TableTdParam("Nitrogen Dioxide")})
					 .addValue(new TableTdParam[]{new TableTdParam("氧化氮"),new TableTdParam("Nitrogen Oxide")})
					 .addValue(new TableTdParam[]{new TableTdParam("二氧化硫"),new TableTdParam("Sulfur Dioxide")})
					 .addValue(new TableTdParam[]{new TableTdParam("苯酚类</br>PHENOLS",3),new TableTdParam("氯酚"),new TableTdParam("Chlorophenol"),new TableTdParam("杀菌剂"),new TableTdParam("Germicide")})
					 .addValue(new TableTdParam[]{new TableTdParam("甲酚"),new TableTdParam("Cresol"),new TableTdParam("甲酚盐"),new TableTdParam("Prime ingredient of Creosote")})
					 .addValue(new TableTdParam[]{new TableTdParam("苯酚"),new TableTdParam("Phenol"),new TableTdParam("杀菌剂"),new TableTdParam("Germicide")})
					 .addValue(new TableTdParam[]{new TableTdParam("硫化物</br>SULFIDES",3),new TableTdParam("二烯丙基二硫化物"),new TableTdParam("Allyl Disulfide"),new TableTdParam("大蒜油"),new TableTdParam("Garlic oil")})
					 .addValue(new TableTdParam[]{new TableTdParam("碳硫化物"),new TableTdParam("Carbon Disulfide"),new TableTdParam("有机物溶解（类似于硫化氢）"),new TableTdParam("Organic solvent（odor similar to Hydrogen Sulfide）")})
					 .addValue(new TableTdParam[]{new TableTdParam("硫化氢"),new TableTdParam("Hydrogen Sulfide"),new TableTdParam("腐烂的鸡蛋"),new TableTdParam("Rotten eggs")})
					 .addAnnon("表：可以与Multi-Mix<sup>®</sup> Media气相媒体发生化学反应的成分").setDoDelim(true)
				 )
			     .addValue(new TableGroupParam("Multi-Mix<sup>®</sup> Media主要有四种基本规格，各自有不同的化学成份，具体如下：")
				     .addHeader(new TableHeaderParam("规格","85px")).addHeader(new TableHeaderParam("化学成分"))
				     .addValue(new String[]{"Multi-Mix<sup>®</sup></br>MM-1000","MM-1000是直径为1/8-inch（0.3厘米）的紫色球体颗粒，由活性矾土及高锰酸钾组成。腐蚀性气体被吸附后与高锰酸钾反应，再通过紫色颗粒分解。腐蚀性气体被氧化成无毒无害的非腐蚀性气体。"})
		    		 .addValue(new String[]{"Multi-Mix<sup>®</sup></br>MM-3000","MM-3000是直径为1/8-inch（0.3厘米）的立柱型颗粒—活性碳组成。通过物理吸收来过滤气体，该过程为凝结形式。活性碳对腐蚀气体有很强的吸收作用。"})
					 .addValue(new String[]{"Multi-Mix<sup>®</sup></br>MM-7000","MM-7000是直径为1/8-inch（0.3厘米）的立柱型颗粒，由活性碳与磷酸组成。磷酸进入活性碳提高吸附效率和能力，吸附反应后使有毒气体成中性。"})
					 .addValue(new String[]{"Multi-Mix<sup>®</sup></br>MM-9000","MM-9000是直径为1/8-inch（0.3厘米）的立柱型颗粒，由活性碳和氢氧化钾组成。氢氧化钾进入活性碳提高吸附效率及能力。吸附反应后有害物被中和或被氧化成非腐蚀性物质。"})
				 	.setDoDelim(true)
			     )
			     .addValue(new TableGroupParam("MM-1000气相净化媒体的过滤性能:")
			     	 .addHeader(new TableHeaderParam("成份")).addHeader(new TableHeaderParam("COMPOUNDS")).addHeader(new TableHeaderParam("代码","45px"))
			     	 .addHeader(new TableHeaderParam("成份")).addHeader(new TableHeaderParam("COMPOUNDS")).addHeader(new TableHeaderParam("代码","45px"))
			     	
			     	 .addValue(new String[]{"丙烯酸酯","Acalylane","P","氢氟化物","Hydrogen Fluoride","F"})
					.addValue(new String[]{"乙醛，醋醛","Acetaldehyde","F","氢碘化物","Hydrogen Iodide","G"})
					.addValue(new String[]{"醋酸","Acetic Acid","E","氢硒化物","Hydrogen Selenide","F"})
					.addValue(new String[]{"乙酸酐","Acetic Anhydride","E","氢硫化物","Hydrogen Sulfide","G"})
					.addValue(new String[]{"丙酮","Acetone","G","熏香","Incense","E"})
					.addValue(new String[]{"丙烯酰胺","Acrolam","G","吲哚","Indole","E"})
					.addValue(new String[]{"丙烯酸","Acrylic Acid","E","碘酒","Iodine","E"})
					.addValue(new String[]{"丙烯腈","Acrylonrole","E","三碘甲烷，碘仿","Iodoform","E"})
					.addValue(new String[]{"酒精","Alcholic Beverages","E","刺激物","Irritants","E"})
					.addValue(new String[]{"胺","Amines","F","异佛乐酮","Isophorone","E"})
					.addValue(new String[]{"氨","Ammonia","F","橡胶基质","Isoprene","G"})
					.addValue(new String[]{"戊基醋酸盐","Amyl Acetate","E","异丙基醋酸盐","Isopropyl Acetate","E"})
					.addValue(new String[]{"戊基洒精","Amyl Alcohol","E","异丙基酒精","Isopropyl Alcohol","E"})
					.addValue(new String[]{"戊基醚","Amyl Ether","E","异丙基天空醚","Isopropyl Ether","E"})
					.addValue(new String[]{"苯胺","Aniline","E","煤油","Kerosene","E"})
					.addValue(new String[]{"沥青烟气","Asphalt Fumes","E","厨房异味","Kitchen Odors","E"})
					.addValue(new String[]{"汽车尾气","Automobile Exhaust","G","乳酸","Lactic Acid","E"})
					.addValue(new String[]{"苯","Benzene","E","薄荷醇","Menthol","E"})
					.addValue(new String[]{"人体气味","Body Odors","E","硫醇","Mercaptans","E"})
					.addValue(new String[]{"硼烷","Borane","G","甲烷，沼气","Methane","P"})
					.addValue(new String[]{"溴","Bromine","E","甲基醋酸盐","Methyl Acetates","G"})
					.addValue(new String[]{"乙烷基酒精","Burned Flesh","E","甲基丙烯酸盐","Methyl Acrylate","E"})
					.addValue(new String[]{"乙胺","Burned Food","E","甲基洒精","Methyl Alcohol","G"})
					.addValue(new String[]{"丁二烯","Butadiene","G","甲基溴化物","Methyl Bromide","G"})
					.addValue(new String[]{"丁烷","Butane","F","甲基丁基酮","Methyl Butyl Ketone","E"})
					.addValue(new String[]{"丁酮","Butanone","E","甲基纤维素溶剂","Methyl Cellosolve","E"})
					.addValue(new String[]{"丁基醋酸盐","Butyl Acetate","E","甲基纤维素溶剂醋酸盐","Methyl Cellosolve Acetate","E"})
					.addValue(new String[]{"丁基洒精","Butyl Alcohol","E","甲基氯化物","Methyl Chloride","G"})
					.addValue(new String[]{"丁基纤维素溶剂","Butyl Cellosolve","E","甲基氯仿","Methyl Chloroform","E"})
					.addValue(new String[]{"丁基氯化物","Butyl Chloride","E","甲基醚","Methyl Ether","G"})
					.addValue(new String[]{"丁基醚","Butyl Ether","E","甲基甲酸盐","Methyl Formate","G"})
					.addValue(new String[]{"丁烯","Butylene","F","甲基异丁基酮","Methyl Isobutyl Ketone","E"})
					.addValue(new String[]{"丁炔","Butyne","F","甲基环已胺","Methylcyclohexane","E"})
					.addValue(new String[]{"丁醛","Butyraldehyde","G","甲基环已醇","Methylcyclohexanol","E"})
					.addValue(new String[]{"丁酸","Butyric Acid","E","甲基环已酮","Methylcyclohexanone","E"})
					.addValue(new String[]{"樟脑","Camphor","E","来甲基氯化物","Methylene Chloride","E"})
					.addValue(new String[]{"辛酸","Caprylic Acid","E","甲基乙酮","Methylethyl Ketone","E"})
					.addValue(new String[]{"碳酸","Carbolic Acid","E","甲基硫醇","Methylmercaptan","E"})
					.addValue(new String[]{"二氧化碳","Carbon Dioxide","P","一氯苯","Monochlorobenzene","P"})
					.addValue(new String[]{"二硫化碳","Carbon Disulfide","E","一氟三氯甲","Monofluorotri-Chloromethane","E"})
					.addValue(new String[]{"一氧化碳","Carbon Monoxide","P","石脑油","Naphtha","E"})
					.addValue(new String[]{"四氯化碳","Carbon Tetrachloride","E","萘球，卫生球","Naphthalene","E"})
					.addValue(new String[]{"纤维素溶液","Cellosolve","E","氮酸","Nitric Acid","G"})
					.addValue(new String[]{"醋酸纤维素","Cellosolve Acetate","E","硝基苯","Nitrobenzene","E"})
					.addValue(new String[]{"干酪","Cheese","E","硝基乙烷","Nitroethane","E"})
					.addValue(new String[]{"氯","Chlorine","G","二氧化氮","Nitrogen Dioxide","F"})
					.addValue(new String[]{"氯丁二烯","Chlorobutadiene","E","硝化甘油","Nitroglycerine","E"})
					.addValue(new String[]{"氯仿","Chloroform","E","硝基甲烷","Nitromethane","E"})
					.addValue(new String[]{"壮棉丹","Chloronitropropane","E","硝基丙烷","Nitropropane","E"})
					.addValue(new String[]{"三氯硝基甲","Chloropicrin","E","硝基甲奔","Nitrotoluene","E"})
					.addValue(new String[]{"柑桔类及其他水果","Citrus & Other Fruits","E","壬烷","Nonane","E"})
					.addValue(new String[]{"清洁剂","Cleaning Compounds","E","尿酸","Octalene","E"})
					.addValue(new String[]{"煤烟","Coal Smoke","G","辛烷","Octane","E"})
					.addValue(new String[]{"杂芬油，木溜油","Creosote","E","颉草酸","Onions","E"})
					.addValue(new String[]{"甲酚","Cresols","E","有机化学制品","Organic Chemicals","E"})
					.addValue(new String[]{"巴豆醛","Crotonaldehyde","E","臭氧","Ozone","E"})
					.addValue(new String[]{"环已胺","Cyclohexane","E","包装房间味道","Packing House Odors","E"})
					.addValue(new String[]{"环已醇","Cyclohexanol","E","油漆和装修气味","Paint & Redecorating Odors","E"})
					.addValue(new String[]{"环已酮","Cyclohexanone","E","棕榈酸","Palmitic Acid","E"})
					.addValue(new String[]{"已烯","Cyclohexene","E","对二氯苯","Paradichlorobenzene","E"})
					.addValue(new String[]{"葵烷","Decane","E","戊烷","Pentane","G"})
					.addValue(new String[]{"二溴乙烷","Dibromoethane","E","戊酮","Pentanone","E"})
					.addValue(new String[]{"二氯（代）苯","Dichlorobenzene","E","戊二烯","Pentylene","G"})
					.addValue(new String[]{"二氯二氟甲烷","Dichlorodifluromethane","E","戊炔","Pentyne","G"})
					.addValue(new String[]{"二氯乙烷","Dichloroethane","E","全氯乙烯","Perchloroethylene","E"})
					.addValue(new String[]{"二氯一氟甲烷","Dichloromonofluoromethane","E","香水和化妆品","Perfumes & Cosmetics","E"})
					.addValue(new String[]{"二氯代硝基乙烯","Dichloronitroethene","E","苯酚，石碳酸","Phenol","E"})
					.addValue(new String[]{"氯丙烷","Dichloropropane","E","光气，碳酰氯","Phosgene","G"})
					.addValue(new String[]{"二氯四氟乙烷","Dichlorotetrafluoroethane","E","沥青","Pitch","E"})
					.addValue(new String[]{"二氯硫醚","Dichlorothyelether","E","有毒气体","Poison Gases","G"})
					.addValue(new String[]{"柴油烟气","Diesel Fumes","E","花粉","Pollen","G"})
					.addValue(new String[]{"二乙酮","Diethyl Ketone","E","爆料花和糖果","Popcorn & Candy","E"})
					.addValue(new String[]{"二乙胺","Diethylamine","G","家禽气味","Poultry Odors","E"})
					.addValue(new String[]{"二甲基苯胺","Dimethylaniline","E","丙烷","Propane","F"})
					.addValue(new String[]{"二甲基硫酸盐","Dimethysulfate","E","丙醛","Propionaldehyde","G"})
					.addValue(new String[]{"二氧杂环乙烷","Dioxane","E","丙酸","Propionic Acid","E"})
					.addValue(new String[]{"二丙基酮","Dipropyl Ketone","E","丙基醋酸盐","Propyl Acetate","E"})
					.addValue(new String[]{"精油","Essential Oils","E","丙基酒精","Propyl Alcohol","E"})
					.addValue(new String[]{"乙烷","Ethane","P","氯丙烷","Propyl Chloride","E"})
					.addValue(new String[]{"天空醚","Ether","G","丙基醚","Propyl Ether","E"})
					.addValue(new String[]{"乙烷基醋酸盐","Ethyl Acetate","E","丙基硫醇","Propyl Mercaptan","E"})
					.addValue(new String[]{"乙烷基丙烯酸盐","Ethyl Acrylate","E","丙烯","Propylene","F"})
					.addValue(new String[]{"乙醇","Ethyl Alcohol","E","丙炔","Propyne","F"})
					.addValue(new String[]{"乙苯","Ethyl Benzene","E","化脓的物质","Putrefying Substances","B"})
					.addValue(new String[]{"乙烷基溴化物","Ethyl Bromide","E","腐胺","Putrescine","E"})
					.addValue(new String[]{"乙烷基氯化物","Ethyl Chloride","G","嘧啶","Pyridine","E"})
					.addValue(new String[]{"乙醚","Ethyl Ether","G","树脂","Resins","E"})
					.addValue(new String[]{"乙烷基甲酸盐","Ethyl Formate","G","橡胶","Rubber","E"})
					.addValue(new String[]{"乙烷基硫醇","Ethyl Mercaptane","G","泡菜","Sauerkraut","E"})
					.addValue(new String[]{"乙烷基硅酸盐","Ethyl Silicate","E","下水道气味","Sewer Odors","E"})
					.addValue(new String[]{"乙胺","Ethylamines","G","臭烘素","Skatole","E"})
					.addValue(new String[]{"乙烯","Ethylene","P","屠宰场气味","Slaughtering Odors","G"})
					.addValue(new String[]{"氯乙醇","Ethylene Chlorhydrin","E","烟雾","Smog","E"})
					.addValue(new String[]{"乙烯基氯化物","Ethylene Oxide","G","酸奶","Sour Milk","E"})
					.addValue(new String[]{"桉树脑，桉油精","Eucalyptol","E","斯托达德溶剂","Stoddard Solvent","E"})
					.addValue(new String[]{"肥料","Fertilizer","E","单体苯乙烯","Styrene Monomer","E"})
					.addValue(new String[]{"装填过程中的气体","Fill Processing Odors","G","二氯化硫","Sulfur Dioxide","F"})
					.addValue(new String[]{"鱼腥味","Fish Odors","E","三氧化硫","Sulfur Trioxide","G"})
					.addValue(new String[]{"花香味","Floral Scents","E","硫磺酸","Sulfuric Acid","E"})
					.addValue(new String[]{"氟三氯甲烷","Fluorotrichloromethane","G","四氯乙烷","Tetrachloroethane","E"})
					.addValue(new String[]{"甲醛，蚁醛","Formaldehyde","F","四氯乙烯，全氯乙烷","Tetrachloroethylene","E"})
					.addValue(new String[]{"蚁酸","Formic Acid","G","吸烟的气味","Tobacco Smoke Odor","E"})
					.addValue(new String[]{"坏疽，腐烂味","Gangrene","E","崦所气味","Toilet Odors","E"})
					.addValue(new String[]{"大蒜","Garlic","E","甲苯","Toluene","E"})
					.addValue(new String[]{"汽油","Gasoline","E","甲苯胺","Toluidine","E"})
					.addValue(new String[]{"瘐烷","Heptane","E","三氯乙烯","Trichlorethylene","E"})
					.addValue(new String[]{"瘐烯","Heptylene","E","三氯乙烷","Trichloroethane","E"})
					.addValue(new String[]{"已烷","Hexane","G","松节油，松脂","Turpentine","E"})
					.addValue(new String[]{"已烯","Hexylene","G","尿素","Urea","F"})
					.addValue(new String[]{"已炔","Hexyne","G","尿酸","Uric Acid","E"})
					.addValue(new String[]{"氢","Hydrogen","P","戊酸","Valeric Acid","E"})
					.addValue(new String[]{"氢溴化物","Hydrogen Bromide","G","颉草醛","Valeric aldehyde","E"})
					.addValue(new String[]{"氢氯化物","Hydrogen Chloride","F","油漆气味","Varnish Fumes","E"})
					.addValue(new String[]{"氢氰化物","Hydrogen Cyanide","G","二甲苯","Xylene","E"})
		
					.addAnnon("注：</br>E：EXCELLENT，非常好/F：FAIR，一般/G：GOOD，好/P：POOR，差</br>如果显示的是F或P设计指示，请在使用前先咨询本公司。").setDoDelim(true)
					//.setCssClassName("col-xxs-12 col-md-6")
			     ).addValue(DataImportUtil.doExcelImport(0, new File("/Users/weisun/git/env-ctrl/web-site/WebContent/excel/technology/MM3000-7000-9000.xlsx"), "MM-3000/7000/9000气相净化媒体的过滤性能:",null)
							.addAnnon("注：</br>E：EXCELLENT，非常好/F：FAIR，一般/G：GOOD，好/P：POOR，差</br>如果显示的是F或P设计指示，请在使用前先咨询本公司。"))
			     
//			     .addValue(new TableGroupParam(null)
//		     	 .addHeader(new TableHeaderParam("成份")).addHeader(new TableHeaderParam("COMPOUNDS")).addHeader(new TableHeaderParam("代码","45px"))
//					
//				//.setCssClassName("col-xxs-12 col-md-6")
//		     )
		);
		

		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "technology2");
		request.setAttribute("productDetailPage", "productDetailPage5");
		request.setAttribute("details", details);
		return "/template/2ndTemplate.jsp";
	}
	

	@RequestMapping(value = "/degerming")
	public String degerming(HttpServletRequest request, HttpServletResponse response)
	{

		SolutionParam param = this.generateParam(2);
		Map<String, MainGroupParam> details = new HashMap<String, MainGroupParam>();
		
		
		details.put("overView",(new MainGroupParam(null,null))
				.addValue(new DivGroupParam(null, "IIECC选用韩国排名第一的Spe公司生产的等离子发生器（部分产品选装），可高效灭菌、降解部分有害气体。"))
				.addValue(new DivGroupParam(null, "等离子的工作原理：在电场作用下，产生大量的小离子群，小离子与空气中的氧分子碰撞形成正负氧离子。"))
				.addValue(new ImageGroupParam(null).addValue(new ImageParam("/technology/ion_1_670x258.png",null)))
				.addValue(new DivGroupParam(null, "正氧离子具有很强的活性，能在极短时间内氧化分解甲硫醇、氨、硫化氢等污染因子，并打开有机物挥发性气体的化学链，经过一系列的反应最终生成二氧化碳和水。正氧离子还能破坏空气中细菌的生存环境，使细菌和孢子失去活性，丧失繁殖能力，从而降低室内细菌的浓度。"))
				.addValue(new ImageGroupParam(null).addValue(new ImageParam("/technology/ion_2_670x315.png",null)))
				.addValue(new DivGroupParam(null, "负氧离子可以吸附大于自身重量几十倍的悬浮颗粒，靠自身重力沉降下来，清除空气中的悬浮胶体（气溶胶），以达到净化空气的目的。"))
				.addValue(new DivGroupParam(null, "经日本Kitasato、三星电子、KTR等权威检测机构检测，该等离子发生器对H1N1、VOCs、硫化氢、大肠杆菌、三甲胺、甲苯等都具有高效去除率，并通过了臭氧测试，达到国际标准。"))
				.addValue(new TableGroupParam("离子发生器检测数据如下：")
					.addHeader(new TableHeaderParam("可去除的污染物"))
					.addHeader(new TableHeaderParam("去除效率"))
					.addHeader(new TableHeaderParam("检测机构"))
				 	.addValue(new String[]{"H1N1甲流病毒","95%","Kitasato （Japan）"})
			 		.addValue(new String[]{"S. Aureus金黄色葡萄球菌","98%","Kitasato （Japan）"})
			 		.addValue(new String[]{"VOCs各种挥发性有机物","98%","Samsung Elec."})
					.addValue(new String[]{"E. Coli大肠杆菌","99%","KTR"})
					.addValue(new String[]{"Toluene甲苯","92%","Inha Univ, KTR"})
					.addValue(new String[]{"Trimethylamine三甲胺","60%","KTR"})
					.addValue(new String[]{"H<sub>2</sub>S硫化氢","98%","KTR"})
					.addValue(new String[]{"Safety for O<sub>3</sub>臭氧","0.045ppm","KCL （with 50 CMH Fan）"})
				 	.addAnnon("")
				 )
		);

		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "technology2");
		request.setAttribute("productDetailPage", "productDetailPage5");
		request.setAttribute("details", details);
		return "/template/2ndTemplate.jsp";
	}
	
	@RequestMapping(value = "/overview")
	public String overview(HttpServletRequest request, HttpServletResponse response)
	{

		SolutionParam param = this.generateParam(0);
		param.setTitle("气相过滤和气相混合净化媒体简介");
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "technology");
		request.setAttribute("productDetailPage", "technology/overview");
		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/scope")
	public String scope(HttpServletRequest request, HttpServletResponse response)
	{

		SolutionParam param = this.generateParam(0);
		param.setTitle("可去除的气态污染物及其介绍");
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "technology");
		request.setAttribute("productDetailPage", "technology/scope");
		return "/template/2ndTemplate.jsp";
	}

	public SolutionParam generateParam(int subItemIndex) {
		SolutionParam param = TechnologyController.generateParam();
		param.setActiveSubItem(param.getSubItems().get(subItemIndex).getName());
		param.setTitle(param.getActiveSubItem());
		return param;
	}

	public static SolutionParam generateParam() {
		SolutionParam param = new SolutionParam();
		param.setHeaderPicName("technology");
		param.setSubItemTitle("优势技术");
		param.setSubItemHeaderImgInfo("IIECC和各行业的龙头企业倾力合作，在引入先进技术的同时，联合开发、反复试验、严苛测试，最终将解决方案完美转化为产品并付诸实施。");
		param.addSubItem("气相过滤技术", "technology/gas_filter.html");
		param.addSubItem("颗粒物过滤技术", "technology/particles_filter.html");
		param.addSubItem("杀菌除菌技术", "technology/degerming.html");
		param.addSubItem("能量回收技术", "technology/power_refund.html");
		param.addSubItem("高效节能技术", "technology/energy_conservation.html");
		return param;
	}
}

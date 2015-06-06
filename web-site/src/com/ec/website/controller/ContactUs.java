package com.ec.website.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.website.param.CaseGroupParam;
import com.ec.website.param.CaseItemParam;
import com.ec.website.param.SolutionParam;

@Controller
@RequestMapping(value = "/contact_us")
public class ContactUs extends AbstractController {

	@RequestMapping(value = "/contact_info")
	public String contactInfo(HttpServletRequest request,
			HttpServletResponse response) {

		SolutionParam param = this.generateParam(0);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "contactUs");
		request.setAttribute("productDetailPage", "contact_us/contactInfo");

		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/tmall")
	public String tmall(HttpServletRequest request, HttpServletResponse response) {

		SolutionParam param = this.generateParam(1);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "contactUs");
		request.setAttribute("productDetailPage", "contact_us/tmall");

		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/dealer_list")
	public String dealeList(HttpServletRequest request,
			HttpServletResponse response) {

		SolutionParam param = this.generateParam(1);
		param.setSubItemInfo("前往您附近的IIECC授权经销商垂询和购买我们的产品。我们将解答您的全部问题，并帮您选择一款适合您的产品。");

		List<CaseGroupParam> groupParams = new ArrayList<CaseGroupParam>();
		this.addCaseGroupParam(groupParams, "上海", new String[][] { {
				"上海市闵行区莘福路396号1号楼7楼", "季洲", "18901639333" } });
		this.addCaseGroupParam(groupParams, "北京", new String[][] {
				{ "北京市朝阳区光华路9号光华路SOHO2 A6-5", "杨乐", "13910381897" },
				{ "北京市顺义区天竺镇花园四街温榆广场L1-12", "杨乐", "13910381897" } });
		this.addCaseGroupParam(groupParams, "吉林", new String[][] { {
				"吉林省长春市亚太大街4906号南岭商务中心a座7楼", "刘以平", "13304301843" } });
		this.addCaseGroupParam(groupParams, "辽宁", new String[][] {
				{ "辽宁省大连市中山区人民路时代广场B座3003室", "谷宏芳", "18641142239" },
				{ "辽宁省沈阳市和平区和平南大街24号", "杨志刚", "024-88809999" } });
		this.addCaseGroupParam(groupParams, "山西", new String[][] { {
				"山西省太原市万柏林区新明珠装饰广场3-9", "李沛峰", "0351-2868648/13403454853" } });

		request.setAttribute("groupParams", groupParams);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "contactUs");
		request.setAttribute("productDetailPage", "contact_us/dealeList");
		return "/template/2ndTemplate.jsp";
	}

	private void addCaseGroupParam(List<CaseGroupParam> groupParams,
			String groupName, String[][] dealers) {
		CaseGroupParam groupParam = new CaseGroupParam(groupName);
		groupParams.add(groupParam);
		for (String[] dealer : dealers) {
			groupParam.addItem(new CaseItemParam(groupName, dealer[0],
					dealer[1], dealer[2]));
		}

	}

	public SolutionParam generateParam(int subItemIndex) {
		SolutionParam param = ContactUs.generateParam();
		param.setActiveSubItem(param.getSubItems().get(subItemIndex).getName());
		param.setTitle(param.getActiveSubItem());
		return param;
	}

	public static SolutionParam generateParam() {
		SolutionParam param = new SolutionParam();
		param.setHeaderPicName("contact_us");
		param.setSubItemTitle("联系我们");
		param.setSubItemHeaderImgInfo("如需了解产品等方面的信息，您可以拨打我们服务热线或亲临IIECC授权经销商门店，我们将竭诚为您服务。 ");
		param.addSubItem("联系方式", "contact_us/contact_info.html");
		// param.addSubItem("天猫旗舰店", "contact_us/tmall.html");
		param.addSubItem("授权经销商", "contact_us/dealer_list.html");
		return param;
	}

}

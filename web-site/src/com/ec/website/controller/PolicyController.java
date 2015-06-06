package com.ec.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.website.param.SolutionParam;

@Controller
@RequestMapping(value = "/policy")
public class PolicyController extends AbstractController {

	@RequestMapping(value = "/privacy_policy")
	public String privacy(HttpServletRequest request,
			HttpServletResponse response) {

		SolutionParam param = this.generateParam(0);
		param.setSubItemInfo("");
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "policy/privacy");

		return "/template/2ndTemplate.jsp";
	}

	@RequestMapping(value = "/use_policy")
	public String use(HttpServletRequest request, HttpServletResponse response) {

		SolutionParam param = this.generateParam(1);

		param.setSubItemInfo("优势之选不仅仅体现在产品本身的卓越效果，更体现在每个部件的精工细作以及每个合作伙伴的深厚底蕴。我们产品的核心部分供应商，都是经过历史的积累和沉淀，在各自领域里是绝对领先的代名词。这不仅代表了我们的产品在行业内的顶尖地位，更意味着我们将有条件永不停止的在环境控制领域与时俱进，推陈出新，为客户提供全方位的服务。");
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "aboutUs");
		request.setAttribute("productDetailPage", "policy/use");
		return "/template/2ndTemplate.jsp";
	}

	public SolutionParam generateParam(String name) {
		SolutionParam param = PolicyController.generateParam();
		param.setActiveSubItem(name);
		param.setTitle(param.getActiveSubItem());
		return param;
	}

	public SolutionParam generateParam(int subItemIndex) {
		SolutionParam param = PolicyController.generateParam();
		param.setActiveSubItem(param.getSubItems().get(subItemIndex).getName());
		param.setTitle(param.getActiveSubItem());
		return param;
	}

	public static SolutionParam generateParam() {
		SolutionParam param = new SolutionParam();
		param.setHeaderPicName("about_us");
		param.setSubItemTitle("关于IIECC");
		param.setSubItemHeaderImgInfo("IIECC致力于为客户提供完善的环境控制解决方案以及节能、低碳的环保产品。凭借专业实力与严谨坚持，我们不断研发高效空气净化设施，守护人体健康、提升生活质量。");
		param.addSubItem("隐私权保护政策", "policy/privacy_policy.html");
		param.addSubItem("使用条款", "policy/use_policy.html");
		return param;
	}
}

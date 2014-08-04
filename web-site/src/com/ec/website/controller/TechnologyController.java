package com.ec.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.website.param.SolutionParam;

@Controller
@RequestMapping(value = "/technology")
public class TechnologyController extends AbstractController {
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
	public SolutionParam generateParam(int subItemIndex){
		SolutionParam param = new SolutionParam();
		param.setHeaderPicName("technology");
		param.setSubItemTitle("核心技术");
		param.setSubItemHeaderImgInfo("近50年来，凭借着技术优势和可靠的质量，CA一直是气相过滤和能量回收领域的领导者。");
		param.addSubItem("气相过滤和气相混合净化媒体简介", "technology/overview.html");
		param.addSubItem("可去除的气态污染物及其介绍", "technology/scope.html");
		param.setActiveSubItem(param.getSubItems().get(subItemIndex).getName());
		param.setTitle(param.getActiveSubItem());
		return param;
	}
}

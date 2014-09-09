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
	public String contactInfo(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(0);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "contactUs");
		request.setAttribute("productDetailPage", "contact_us/contactInfo");

		return "/template/2ndTemplate.jsp";
	}


	@RequestMapping(value = "/tmall")
	public String tmall(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(1);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "contactUs");
		request.setAttribute("productDetailPage", "contact_us/tmall");

		return "/template/2ndTemplate.jsp";
	}
	@RequestMapping(value = "/dealer_list")
	public String dealeList(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(1);
		param.setSubItemInfo("优势之选不仅仅体现在产品本身的卓越效果，更体现在每个部件的精工细作以及每个合作伙伴的深厚底蕴。我们产品的核心部分供应商，都是经过历史的积累和沉淀，在各自领域里是绝对领先的代名词。这不仅代表了我们的产品在行业内的顶尖地位，更意味着我们将有条件永不停止的在环境控制领域与时俱进，推陈出新，为客户提供全方位的服务。");
		
		List<CaseGroupParam> groupParams =  new ArrayList<CaseGroupParam>();
		this.addCaseGroupParam(groupParams, "吉林",3);
		this.addCaseGroupParam(groupParams, "北京",3);
		this.addCaseGroupParam(groupParams, "山西",1);
		this.addCaseGroupParam(groupParams, "河北",1);
		this.addCaseGroupParam(groupParams, "内蒙古",1);
		this.addCaseGroupParam(groupParams, "辽宁",2);
		this.addCaseGroupParam(groupParams, "陕西",1);
		this.addCaseGroupParam(groupParams, "浙江",2);

		request.setAttribute("groupParams", groupParams);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "contactUs");
		request.setAttribute("productDetailPage", "contact_us/dealeList");
		return "/template/2ndTemplate.jsp";
	}
	private void addCaseGroupParam(List<CaseGroupParam> groupParams,String groupName,int amt){
		CaseGroupParam groupParam = new CaseGroupParam(groupName);
		groupParams.add(groupParam);
		for(int i=0;i<amt;i++){
			groupParam.addItem(new CaseItemParam(groupName, "天元环境科技有限公司", "上海市闵行区莘福路396号1号楼7楼", "0431-88888888"));
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
		param.setSubItemHeaderImgInfo("多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。");
		param.addSubItem("联系方式", "contact_us/contact_info.html");
//		param.addSubItem("天猫旗舰店", "contact_us/tmall.html");
		param.addSubItem("授权经销商", "contact_us/dealer_list.html");
		return param;
	}

}

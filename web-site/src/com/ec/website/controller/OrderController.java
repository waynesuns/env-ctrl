package com.ec.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.website.param.SolutionParam;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
	@RequestMapping(value = "/sale_order")
	public String saleOrder(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(0);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "contactUs");
		request.setAttribute("productDetailPage", "order/sale_order");

		return "/template/orderTemplate.jsp";
	}
	@RequestMapping(value = "/service_intro")
	public String serviceIntro(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(0);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "contactUs");
		request.setAttribute("productDetailPage", "order/service_intro");

		return "/template/orderTemplate.jsp";
	}
	@RequestMapping(value = "/service_order")
	public String serviceOrder(HttpServletRequest request, HttpServletResponse response){
		

		SolutionParam param = this.generateParam(0);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "contactUs");
		request.setAttribute("productDetailPage", "order/service_order");

		return "/template/orderTemplate.jsp";
	}
	public SolutionParam generateParam(int subItemIndex) {
		SolutionParam param = OrderController.generateParam();
		param.setActiveSubItem(param.getSubItems().get(subItemIndex).getName());
		param.setTitle(param.getActiveSubItem());
		return param;
	}

	public static SolutionParam generateParam() {
		SolutionParam param = new SolutionParam();
		param.setHeaderPicName("contact_us");
		param.setSubItemTitle("产品订购");
		param.setSubItemHeaderImgInfo("如需了解产品等方面的信息，您可以拨打我们服务热线或亲临IIECC授权经销商门店，我们将竭诚为您服务。 ");
		param.addSubItem("产品订购", "order/sale_order.html");
		param.addSubItem("检测服务", "order/service_intro.html");
//		param.addSubItem("天猫旗舰店", "contact_us/tmall.html");
//		param.addSubItem("授权经销商", "contact_us/dealer_list.html");
		return param;
	}

}

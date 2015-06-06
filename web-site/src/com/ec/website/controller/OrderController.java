package com.ec.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ec.website.param.SolutionParam;

@Controller
@RequestMapping(value = "/order")
public class OrderController extends AbstractController {
	@RequestMapping(value = "/sale_order")
	public String saleOrder(HttpServletRequest request,
			HttpServletResponse response) {

		SolutionParam param = this.generateParam(1);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "contactUs");
		request.setAttribute("productDetailPage", "order/sale_order");

		return "/template/orderTemplate.jsp";
	}

	@RequestMapping(value = "/service_intro")
	public String serviceIntro(HttpServletRequest request,
			HttpServletResponse response) {

		SolutionParam param = this.generateParam(0);
		request.setAttribute("solutionParam", param);
		request.setAttribute("detailPage", "contactUs");
		request.setAttribute("productDetailPage", "order/service_intro");

		return "/template/orderTemplate.jsp";
	}

	@RequestMapping(value = "/service_order")
	public String serviceOrder(HttpServletRequest request,
			HttpServletResponse response) {

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
		param.setHeaderPicName("order");
		param.setSubItemTitle("服务及订购");
		param.setSubItemHeaderImgInfo("IIECC提供的空气质量检测服务以及产品网络订购服务，让您足不出户就可以安心尽享“零污染”洁净空气。 ");
		param.addSubItem("Tech-CHEK空气质量检测服务", "order/service_intro.html");
		param.addSubItem("产品在线订购", "order/sale_order.html");
		// param.addSubItem("天猫旗舰店", "contact_us/tmall.html");
		// param.addSubItem("授权经销商", "contact_us/dealer_list.html");
		return param;
	}

}

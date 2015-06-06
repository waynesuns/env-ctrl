package com.ec.website.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ec.website.controller.AboutUsController;
import com.ec.website.controller.ContactUs;
import com.ec.website.controller.OrderController;
import com.ec.website.controller.ProductController;
import com.ec.website.controller.SolutionController;
import com.ec.website.controller.TechnologyController;

public class ECServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setAttribute("productMenus", ProductController.generateParam());
		event.getServletContext().setAttribute("technologyMenus", TechnologyController.generateParam());
		event.getServletContext().setAttribute("solutionMenus", SolutionController.generateParam());
		event.getServletContext().setAttribute("contactUsMenus", ContactUs.generateParam());
		event.getServletContext().setAttribute("aboutUsMenus", AboutUsController.generateParam());
		event.getServletContext().setAttribute("orderMenus", OrderController.generateParam());
	}

}

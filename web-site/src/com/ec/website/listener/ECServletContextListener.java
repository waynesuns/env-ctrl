package com.ec.website.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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
		
	}

}

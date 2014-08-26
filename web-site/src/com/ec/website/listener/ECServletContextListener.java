package com.ec.website.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ec.website.controller.ProductController;

public class ECServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setAttribute("productMenus", ProductController.generateParam());
		
	}

}

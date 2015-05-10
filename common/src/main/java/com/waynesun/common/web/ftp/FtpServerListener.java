package com.waynesun.common.web.ftp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ftpserver.impl.DefaultFtpServer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class FtpServerListener implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent contextEvent) {
		System.out.println("Stopping FtpServer");
		DefaultFtpServer server = (DefaultFtpServer) contextEvent.getServletContext()
				.getAttribute("FTPSERVER_CONTEXT_NAME");
		if (server != null) {
			server.stop();
			contextEvent.getServletContext().removeAttribute("FTPSERVER_CONTEXT_NAME");
			System.out.println("FtpServer stopped");
		} else {
			System.out.println("No running FtpServer found");
		}
	}

	public void contextInitialized(ServletContextEvent contextEvent) {
		System.out.println("Starting FtpServer");
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(contextEvent.getServletContext());
		DefaultFtpServer server = (DefaultFtpServer) ctx.getBean("myServer");   
		contextEvent.getServletContext().setAttribute("FTPSERVER_CONTEXT_NAME", server);   
		try {
			server.start();
			System.out.println("FtpServer started");
		} catch (Exception e) {
			throw new RuntimeException("Failed to start FtpServer", e);
		}
	}

	
}

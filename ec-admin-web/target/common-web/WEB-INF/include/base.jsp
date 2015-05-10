<%@page contentType="text/html"  import="java.util.*" pageEncoding="UTF-8"%><%
	String base = (String)session.getAttribute("BASE_SESSION_KEY");
	
	if (base == null)
	{
		String webServerPath = (String)request.getAttribute("WEB_SERVER_PATH");
		if (webServerPath == null)
		{
			webServerPath = request.getServerName() + ":" + request.getServerPort();
		}
		else
			webServerPath = request.getServerName();
		String baseUrl = "http://" + webServerPath + request.getContextPath();
		if (!baseUrl.endsWith("/"))
			baseUrl += "/";
		base = "<base href=\"" + baseUrl + "\" >";
		
		session.setAttribute("BASE_SESSION_KEY", base);
		session.setAttribute("BASE_URL", baseUrl);
		request.setAttribute("BASE_URL",baseUrl);
		
	}
	session.setAttribute("template", "/WEB-INF/pages");
	session.setAttribute("pageTemplate", "/WEB-INF/pages");
%>
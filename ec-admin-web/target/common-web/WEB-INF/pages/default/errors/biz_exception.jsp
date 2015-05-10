<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<% 
	Exception ex = (Exception)request.getAttribute("exception");
%>
<%=ex.getMessage() %>

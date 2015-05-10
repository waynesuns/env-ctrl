<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/WEB-INF/include/taglib.jsp"%> 
<% 
Exception ex = (Exception)request.getAttribute("exception");
%>

<b>System exception:</b>
<%=ex.getClass().getName() %><br/>
<%=ex.getMessage() %>

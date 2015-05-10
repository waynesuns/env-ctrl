<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!-- import="com.dynatecs.web.util.CookieUtils, com.chinasshp.poms.web.control.WebConst" --> 
<%@include file="/WEB-INF/include/taglib.jsp"%> 

<html>
<%-- <%

	CookieUtils.removeCookie(request, response, WebConst.KEY_USER_ID);
	CookieUtils.removeCookie(request, response, WebConst.KEY_AREA);
	CookieUtils.removeCookie(request, response, WebConst.KEY_USER_NAME);

%> --%>
<%if(request.getAttribute("isXMLRequest")!= null){ %>
<fmt:message key="errors.noUser"/>
<%} %>
<script type="text/javascript">
top.location.href="${pageContext.request.contextPath}/login.do";
window.location.href="${pageContext.request.contextPath}/login.do";
</script>
</html>
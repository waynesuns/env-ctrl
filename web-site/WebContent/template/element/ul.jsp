<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<c:if test="${paramGroup.title != null}">
<div class="info" style="margin-bottom: 5px;">${paramGroup.title}</div>
</c:if>
<ul>
<c:forEach items="${paramGroup.values}" var="paramValue">
	<li>${paramValue }</li>
</c:forEach>
</ul>
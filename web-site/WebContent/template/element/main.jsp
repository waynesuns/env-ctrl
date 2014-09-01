<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<c:if test="${detailValue.title != null}">
<div class="title">${detailValue.title}</div>
</c:if>
<c:if test="${detailValue.desc != null}">
<div class="info">${detailValue.desc}</div>
</c:if>
<c:forEach var="value" items="${detailValue.values}">
<c:set var="paramGroup" value="${value}" scope="request"/>
<c:import url="/template/element/${value.templatePath}"></c:import>

<c:choose>
	<c:when test="${value.doDelim}">
		<hr style="margin-bottom: 40px;margin-top: 10px;"/>
	</c:when>
	<c:otherwise>
		<div style="padding-bottom: 12px;"></div>
	</c:otherwise>
</c:choose>
</c:forEach>
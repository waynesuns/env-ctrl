<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<c:if test="${paramGroup.title != null}">
<h5>${paramGroup.title}</h5>
</c:if>
<c:forEach var="value" items="${paramGroup.values}" varStatus="i">
	<div class="img ${paramGroup.cssClassName}">
		<c:if test="${value.url !=null}">
			<img src="${path}img${value.url}" class="img-responsive">
		</c:if>
		
		<c:if test="${value.annon !=null}">
			<div class="info" style="margin-top: 12px;"><c:out value="${value.annon}" escapeXml="false"/></div>
		</c:if>
	</div>
	
</c:forEach>
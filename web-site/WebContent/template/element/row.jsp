<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="row">
	<c:forEach var="value" items="${paramGroup.values}">
	<c:set var="paramGroup" value="${value}" scope="request"/>
	<c:import url="/template/element/${value.templatePath}"></c:import>
	<c:if test="${value.doDelim}">
		<hr style="margin-bottom: 40px;margin-top: 10px;"/>
	</c:if>
	</c:forEach>
</div>
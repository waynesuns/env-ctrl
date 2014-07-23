<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="title">案例</div>
<c:forEach var="sample" items="${solutionParam.samples}" varStatus="i">
	<c:if test="${i.index>0}">
		<hr style="margin-bottom: 40px;margin-top: 10px;"/>
	</c:if>
	<div class="sample-title" style="margin-bottom: 0">${sample.title}</div>
	<div class="row" style="padding-top: 12px">
		<div class="info col-xs-7" style="margin-bottom: 0">${sample.info}</div>
		<div class="img col-xs-5"><img src="${path}img/sample/${sample.picName}" class="img-responsive"></div>
	</div>
</c:forEach>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="title">${solutionParam.activeSubItem}</div>
<div class="info">${solutionParam.subItemInfo}</div>
<c:if test="${fn:length(solutionParam.samples)>0}">
<hr/>
<div class="title">案例</div>
<c:forEach var="sample" items="${solutionParam.samples}">
	<div class="sample-title">${sample.title}</div>
	<div class="info">${sample.info}</div>
	<c:if test="${sample.picName != null}">
	<div class="img"><img src="${path}img/sample/${sample.picName}" class="img-responsive"></div>
	</c:if>
</c:forEach>
</c:if>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="title"><c:out value="${solutionParam.activeSubItem}"/></div>
<c:forEach var="sample" items="${solutionParam.samples}" varStatus="i">
	<div class="sample-title" style="margin-bottom: 0">${sample.title}</div>
	<div class="row" style="padding-top: 0;">
		<c:choose>
			<c:when test="${sample.picName == null}">
				<div style="padding-top: 12px" class="info col-xs-12" style="margin-bottom: 0">${sample.info}</div>
			</c:when>
			<c:otherwise>
				<div style="padding-top: 12px" class="info col-xxs-12 col-md-6" style="margin-bottom: 0">${sample.info}</div>
				<div style="padding-top: 12px" class="img col-xxs-12 col-md-6"><img src="${path}img/product/${sample.picName}" class="img-responsive"></div>
			</c:otherwise>
		</c:choose>
	</div>
</c:forEach>
<c:forEach var="detail" items="${details}" varStatus="i">
<hr style="margin-bottom: 40px;margin-top: 10px;"/>
<div class="sample-title">${detail.name}</div>
<c:forEach var="partner" items="${detail.partners}" varStatus="i">
	<c:choose>
		<c:when test="${detail.type eq 'div'}">
			<c:if test="${partner.logo !=null}">
				<h5>${partner.logo}</h5>
			</c:if>
			<div class="info">${partner.name}</div>
		</c:when>
		<c:otherwise>
			<li>${partner.name }</li>
		</c:otherwise>
	</c:choose>
</c:forEach>
</c:forEach>
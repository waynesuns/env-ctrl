<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="title">${solutionParam.title}</div>
<div class="info">${solutionParam.subItemInfo}</div>

<c:import url="${productDetailPage}.jsp"></c:import>
<c:if test="${guildParam!=null}">
<div style="margin-bottom: 120px;"></div>
<c:set var="solutionParam" value="${guildParam}" scope="request"></c:set>
<div class="title">${solutionParam.title}</div>
<div class="info">${solutionParam.subItemInfo}</div>

<c:import url="${productDetailPage}.jsp"></c:import>
</c:if>

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="title">${solutionParam.title }</div>
<c:forEach var="detail" items="${details}" varStatus="i">
	<c:set scope="request" value="${detail.value }" var="detailValue"></c:set>
	<c:import url="${productDetailPage}.jsp"></c:import>
</c:forEach>
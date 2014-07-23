<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="title">${solutionParam.title}</div>
<div class="info">${solutionParam.subItemInfo}</div>

<c:import url="${productDetailPage}.jsp"></c:import>

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="title">${solutionParam.title }</div>
<ul class="nav nav-tabs nav-justified product_nav" role="tablist" style="margin-bottom: 10px;">
  <c:forEach var="key" items="${keys}" varStatus="i">
  <li class="${i.index==0?'active':'' }"><a href="#tab_${key.key}" role="tab" data-toggle="tab">${key.value}</a></li>
  </c:forEach>
</ul>
<!-- Tab panes -->
<div class="tab-content" style="margin-top: 24px;">
	<c:forEach var="detail" items="${details}" varStatus="i">
		<div class="tab-pane ${i.index==0?'active':''}" id="tab_${i.index}">
			<c:set scope="request" value="${detail}" var="detailValue"></c:set>
			<c:import url="${productDetailPage}.jsp"></c:import>
		</div>
	</c:forEach>
</div>
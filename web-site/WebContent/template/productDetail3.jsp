<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="title">MULTI-MIX® Media</div>
<ul class="nav nav-tabs nav-justified product_nav" role="tablist" style="margin-bottom: 10px;">
  <li class="active"><a href="#overView" role="tab" data-toggle="tab">概览</a></li>
  <li><a href="#MM-1000" role="tab" data-toggle="tab">MM-1000</a></li>
  <li><a href="#MM-3000" role="tab" data-toggle="tab">MM-3000</a></li>
  <li><a href="#MM-7000" role="tab" data-toggle="tab">MM-7000</a></li>
  <li><a href="#MM-9000" role="tab" data-toggle="tab">MM-9000</a></li>
</ul>
<!-- Tab panes -->
<div class="tab-content" style="margin-top: 24px;">
	<c:forEach var="detail" items="${details}" varStatus="i">
		<div class="tab-pane ${detail.key eq 'overView'?'active':''}" id="${detail.key}">
			<c:set scope="request" value="${detail.value }" var="detailValue"></c:set>
			<c:import url="${productDetailPage}.jsp"></c:import>
		</div>
	</c:forEach>
</div>
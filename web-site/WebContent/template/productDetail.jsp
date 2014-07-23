<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>

<ul class="nav nav-tabs nav-justified" role="tablist" style="margin-bottom: 10px;">
  <li class="active"><a href="#feautre" role="tab" data-toggle="tab">功能设计</a></li>
  <li><a href="#param" role="tab" data-toggle="tab">参数规格</a></li>
  <li><a href="#download" role="tab" data-toggle="tab">下载</a></li>
  <li><a href="#desc" role="tab" data-toggle="tab">常见问题</a></li>
  <li><a href="#q&a" role="tab" data-toggle="tab">购买咨询</a></li>
</ul>
<!-- Tab panes -->
<div class="tab-content">
	<div class="tab-pane active" id="feautre">
		<c:import url="${productDetailPage}.jsp"></c:import>
	</div>
	<div class="tab-pane" id="param">...</div>
	<div class="tab-pane" id="download">...</div>
	<div class="tab-pane" id="desc">...</div>
	<div class="tab-pane" id="q&a">...</div>
</div>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<ul class="nav nav-tabs nav-justified product_nav" role="tablist" style="margin-bottom: 10px;">
  <li class="active"><a href="#feautre" role="tab" data-toggle="tab">功能设计</a></li>
  <li><a href="#param" role="tab" data-toggle="tab">参数规格</a></li>
  <li><a href="#download" role="tab" data-toggle="tab">下载</a></li>
  <li><a href="#q&a" role="tab" data-toggle="tab">常见问题</a></li>
  <li><a href="#contact" role="tab" data-toggle="tab">购买咨询</a></li>
</ul>
<!-- Tab panes -->
<div class="tab-content">
	<div class="tab-pane active" id="feautre">
		<c:import url="${productDetailPage}.jsp"></c:import>
	</div>
	<div class="tab-pane" id="param">
		<div class="table-responsive">
			<table class="table table-hover table-bordered">
				<thead >
					<th class="col-xs-6 active" colspan="2" style="text-align: center;">客户</th>
					<th class="col-xs-6 active" style="text-align: center;">设备</th>
				</thead>
				<c:forEach begin="0" end="5" varStatus="j">
					<tr class="${j.index%2==1?'active':''}">
						<td>达能</td>
						<td>中国</td>
						<td>空气净化</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="tab-pane" id="download">
		<div class="table-responsive">
			<table class="table table-bordered">
			<c:forEach begin="0" end="5" varStatus="j">
				<tr class="${j.index%2==0?'active':''}">
					<td style="border-left: 0;border-right: 0;">高浓度气体洗涤净化器机组</td>
					<td style="border-left: 0;border-right: 0;"><img src="../img/kv_1170.png" style="width: 13px;height: 17px;" class="icon_download" /></td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	<div class="tab-pane" id="desc"></div>
	<div class="tab-pane" id="q&a"></div>
</div>
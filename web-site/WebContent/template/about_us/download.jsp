<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
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
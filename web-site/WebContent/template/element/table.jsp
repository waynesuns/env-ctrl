<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="table-responsive">
	<table class="table table-hover table-bordered">
		<thead class="">
			<c:forEach var="tableHeader" items="${paramGroup.headers}">
				<th class="active" style="text-align: center;"><c:out value="${tableHeader.name}"></c:out></th>
			</c:forEach>
		</thead>
		<c:forEach var="value" items="${paramGroup.values}" varStatus="i">
			<tr class="${j.index%2==1?'active':''}">
				<c:forEach begin="0" end="${(fn:length(paramGroup.headers))-1}" var="j">
					<td style="width: <c:out value="${paramGroup.headers[j].width}" default="auto"/>"><c:out value="${value[j]}"></c:out></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</div>
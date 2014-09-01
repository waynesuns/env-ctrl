<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<c:if test="${paramGroup.title != null}">
<div class="info" style="margin-bottom: 12px;">${paramGroup.title}</div>
</c:if>
<div class="table-responsive" style="margin-left: 0;margin-right: 0;padding-left: 0;padding-right: 0">
	<table class="table table-hover table-bordered">
		<thead class="">
			<c:forEach var="tableHeader" items="${paramGroup.headers}">
				<th colspan="${tableHeader.colspan}" class="active" style="text-align: center;width: <c:out value="${tableHeader.width}" default="auto"/>"><c:out value="${tableHeader.name}"></c:out></th>
			</c:forEach>
		</thead>
		<c:forEach var="value" items="${paramGroup.values}" varStatus="i">
			<tr class="${j.index%2==1?'active':''}">
				<c:forEach var="v" items="${value}">
					<td rowspan="${v.rowSpan}"><c:out value="${v.text}" escapeXml="false"></c:out></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</div>
<c:forEach var="annon" items="${paramGroup.annons}" varStatus="i">
<div class="info" style="margin-bottom: 12px;margin-top: 12px;">${annon}</div>
</c:forEach>
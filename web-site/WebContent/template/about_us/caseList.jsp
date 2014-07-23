<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<hr />
<div class="title" >部分客户列表</div>

<div class="panel-group" id="accordion">
	<c:forEach var="groupParam" items="${groupParams}" varStatus="i">
		<div class="panel panel-default">
			<div class="panel-heading ${i.index==0?'active':''}">
				<h4 class="panel-title">
					<a id="a" data-toggle="collapse" data-parent="#accordion" href="#case_${i.index}"><c:out value="${groupParam.groupName}"></c:out><div class="panel-button"></div></a>
				</h4>
			</div>
			<div id="case_${i.index}" class="panel-collapse collapse ${i.index==0?'in':''}">
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-hover table-bordered">
							<thead class="">
								<th class="col-xs-5 active" colspan="2">客户</th>
								<th class="col-xs-4 active">设备</th>
								<th class="col-xs-3 active">应用</th>
							</thead>
							<c:forEach var="item" items="${groupParam.items}" varStatus="j">
								<tr class="${j.index%2==1?'active':''}">
									<td><c:out value="${item.firstName}"/></td>
									<td><c:out value="${item.lastName}"/></td>
									<td><c:out value="${item.productName}"/></td>
									<td><c:out value="${item.itemName}"/></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
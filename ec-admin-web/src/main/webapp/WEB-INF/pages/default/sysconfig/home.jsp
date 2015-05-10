<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<jsp:include page="script.jsp"/>
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header" style="padding-bottom: 12px"><i class="fa fa-align-justify fa-lg"></i>
			<fmt:message key="system.management" />
			>> <a  href='<c:url value="/sysconfig/show/home.do"/>' ><fmt:message key="sysconfig.title" /></a>
		</h3>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading" style="padding: 5px 15px; height: 45px;">
		<div class="pull-left panel-heading-title-left">
			<i class="fa fa-table fa-lg"></i>&nbsp;&nbsp;<fmt:message key="sysconfig.table.title"></fmt:message>
		</div>
	</div>
	<div class="panel-body">
		<div class="table-responsive">
			<table id="sysconfig_table"
				class="table table-striped table-bordered table-hover " width="100%">
				<thead>
			<tr>
				<th width="185"><fmt:message key="sysconfig.code"/></th>
				<th width="498"><fmt:message key="sysconfig.name"/></th>
				<th width="183"><fmt:message key="sysconfig.value"/></th>
				<th><fmt:message key="sysconfig.id"/></th>
			</tr>
		</thead>
		<tbody></tbody>
			</table>
		</div>
	</div>
</div>

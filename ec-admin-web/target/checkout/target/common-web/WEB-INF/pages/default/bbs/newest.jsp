<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header" style="padding-bottom: 12px"><i class="fa fa-align-justify fa-lg"></i>
			<a  href='<c:url value="/login/show.do"/>' ><fmt:message key="bbs.new.list" /></a>
		</h3>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading" style="padding: 5px 15px; height: 45px;">
		<div class="pull-left panel-heading-title-left">
			<i class="fa fa-table fa-lg"></i>&nbsp;&nbsp;<fmt:message key="bbs.new.table.list"></fmt:message>
		</div>
	</div>
	<div class="panel-body">
		<div class="table-responsive">
			<table id="table1"
				class="table table-striped table-bordered table-hover " width="100%">
				<thead>
				<tr>
					<th><fmt:message key="bbs.title" /></th>
				    <th><fmt:message key="common.file" /></th>
				    <th width="0">announcementId</th>
				    <th width="0">attachmentId</th>
				    <th width="0">anconfId</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			</table>
		</div>
	</div>
</div>
<jsp:include page="newest_script.jsp"></jsp:include>
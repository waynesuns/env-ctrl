<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<jsp:include page="script.jsp"/>
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header" style="padding-bottom: 12px"><i class="fa fa-align-justify fa-lg"></i>
			<fmt:message key="system.management" />
			>> <a  href='<c:url value="/user/show/home.do"/>' ><fmt:message key="user.management" /></a>
			<button class="btn btn-primary  pull-right" type="button"   data-toggle="modal" data-target="#myModal">
					<i class="fa fa-plus"></i>&nbsp;&nbsp;<fmt:message key="common.button.create"></fmt:message>
				</button>
		</h3>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading" style="padding: 5px 15px; height: 45px;">
		<div class="pull-left panel-heading-title-left">
			<i class="fa fa-table fa-lg"></i>&nbsp;&nbsp;<fmt:message key="user.table.title"></fmt:message>
		</div>
		<button class="btn btn-default pull-right" type="button" onclick="exportUser()">
			<i class="fa fa-download"></i>&nbsp;&nbsp;<fmt:message key="user.exportuser"></fmt:message>
		</button>
	</div>
	<div class="panel-body">
		<div class="table-responsive">
			<table id="userTableList"
				class="table table-striped table-bordered table-hover " width="100%">
				<thead>
					<tr id="table_th">
						<th width="160" nowrap="nowrap"><fmt:message key="user.name" /></th>
						<th width="410" nowrap="nowrap"><fmt:message key="user.role.name" /></th>
						<th width="200" nowrap="nowrap"><fmt:message key="user.userName" /></th>
						<th nowrap="nowrap"></th>
					</tr>
				</thead>
				<tbody id="userList"></tbody>
			</table>
		</div>
	</div>
</div>
<div style="display: none">
	<form action="<c:url value="/user/export.do"/>" method="post" id="hiddenForm">
		<input type="hidden" id="nameSearch" name="nameSearch" value="" >
		<input type="hidden" id="roleSearch" name="roleSearch" value="" >
		<input type="hidden" id="userNameSearch" name="userNameSearch" value="" >
	</form>
	</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modal-body" aria-hidden="true"  data-backdrop="static">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3 class="modal-title text-center" id="myModalLabel"><fmt:message key="user.add.title"></fmt:message></h3>
      </div>
      <div class="modal-body">
        <form class="form-inline" role="form" id="user_form" action="<c:url value="/user/add.do" />" method="post">
			<div class="row">
  				<div class="col-xs-2 col-xs-np ml">
   	 					<label for="name" class="control-label"><fmt:message key="common.colon"><fmt:param><fmt:message key="user.name"/></fmt:param></fmt:message></label>
  				</div>
  				<div class="col-xs-8 col-xs-np">
   	 					<input type="text" class="form-control input-sm col-lg-12 required" id="name" maxlength="20" 
								placeholder="<fmt:message key="user.name"/>" name="name" style="width:231px">
  				</div>
			</div>
			<div class="row">
  				<div class="col-xs-2 col-xs-np ml">
   	 					<label for="role_ids" class=" control-label"><fmt:message key="common.colon"><fmt:param><fmt:message key="user.role.name"/></fmt:param></fmt:message></label>
  				</div>
  				<div class="col-xs-8 col-xs-np">
   	 					<select id="role_ids" name="rolesId" class="required" style="width: 200px;" multiple></select>
  				</div>
			</div>
			<div class="row">
  				<div class="col-xs-2 col-xs-np ml">
   	 					<label for="userName" class="control-label"><fmt:message key="common.colon"><fmt:param><fmt:message key="user.userName"/></fmt:param></fmt:message></label>
  				</div>
  				<div class="col-xs-8 col-xs-np">
   	 					<input type="text" class="form-control input-sm col-lg-12 required" id="userName" maxlength="30" 
								placeholder="<fmt:message key="user.userName"/>" name="userName" style="width:231px">
  				</div>
			</div>
				</form>
      </div>
      <div class="modal-footer">
       <button type="button" class="btn btn-primary" onclick="addUser()"><fmt:message key="common.define"></fmt:message></button>
        <button type="button" class="btn btn-default" data-dismiss="modal" ><fmt:message key="common.cancel"></fmt:message></button>
       
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
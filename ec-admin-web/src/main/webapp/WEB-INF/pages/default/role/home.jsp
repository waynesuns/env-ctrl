<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<jsp:include page="script.jsp" />
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header" style="padding-bottom: 12px"><i class="fa fa-align-justify fa-lg"></i>
			<fmt:message key="system.management" />
			>> <a  href='<c:url value="/role/show/home.do"/>' ><fmt:message key="menu.role" /></a>
				<button class="btn btn-primary  pull-right" type="button"  onclick="shownewForm()">
					<i class="fa fa-plus"></i>&nbsp;&nbsp;<fmt:message key="common.button.create"></fmt:message>
				</button>
		</h3>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading" style="padding: 5px 15px; height: 45px;">
		<div class="pull-left panel-heading-title-left">
			<i class="fa fa-table fa-lg"></i>&nbsp;&nbsp;<fmt:message key="role.table.title"></fmt:message>
		</div>
		<button class="btn btn-default pull-right" type="button" onclick="exportRole()">
			<i class="fa fa-download"></i>&nbsp;&nbsp;<fmt:message key="role.export.title"></fmt:message>
		</button>
	</div>
	<div class="panel-body">
		<div class="table-responsive">
			<table id="role_table"
				class="table table-striped table-bordered table-hover " width="100%">
				<thead>
					<tr>
						<th><fmt:message key="role.name" /></th>
						<th><fmt:message key="user.authorize" /></th>
						<th><fmt:message key="menu.list" /></th>
						<th><fmt:message key="state" /></th>
						<th width="0">id</th>
						<th width="0">state</th>
						<th width="0">html</th>
						<th width="0">userIds</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modal-body" aria-hidden="true"  data-backdrop="static">
  <div class="modal-dialog" style="width:800px">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3 class="modal-title text-center" id="myModalLabel"></h3>
      </div>
      <div class="modal-body">
        <form class="form-inline" role="form" id="role_form" action='' method="post">
			<div class="row">
  				<div class="col-xs-2 col-xs-np ml">
   	 					<label for="add_role_name" class="control-label"><fmt:message key="common.colon"><fmt:param><fmt:message key="role.name"/></fmt:param></fmt:message></label>
  				</div>
  				<div class="col-xs-8 col-xs-np">
   	 					<input type="text" class="form-control input-sm col-lg-12 required" id="role_name" maxlength="10" 
								placeholder="<fmt:message key="role.name"/>" name="name" style="width:231px">
  				</div>
			</div>
			<div class="row">
  				<div class="col-xs-2 col-xs-np ml">
   	 					<label for="authorized_users" class=" control-label"><fmt:message key="common.colon"><fmt:param><fmt:message key="user.authorize"/></fmt:param></fmt:message></label>
  				</div>
  				<div class="col-xs-8 col-xs-np">
   	 					<select id="authorized_users" name="userId" class="" style="width: 200px;" multiple></select>
  				</div>
			</div>
			<div class="row">
  				<div class="col-xs-2 col-xs-np ml">
   	 					<label for="authorized_users" class=" control-label"><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.name"/></fmt:param></fmt:message></label>
  				</div>
			</div>
			<div class="row" style="padding-top:10px">
					<div class="col-xs-3"> <!-- required for floating -->
		                <!-- Nav tabs -->
		                <ul class="nav nav-tabs tabs-left" id="menu_tabs">
		                </ul>
		            </div>
		            <div class="col-xs-9">
		                <!-- Tab panes -->
		                <div class="tab-content" id="contents">
		                </div>
		            </div>
			</div>
			<div class="row" style="display:none" id="state_row">
  				<div class="col-xs-2 col-xs-np ml">
   	 					<label  class="control-label"><fmt:message key="common.colon"><fmt:param><fmt:message key="state"/></fmt:param></fmt:message></label>
  				</div>
  				<div class="col-xs-8 col-xs-np">
   	 					<label for="state_role_yes" class="checkbox-inline"><input id="state_role_yes" name="stateStr" class="required" type="radio" value="0" /><fmt:message key="state.enabled"/></label>
   	 					<label for="state_role_no" class="checkbox-inline"><input id="state_role_no" name="stateStr" class="required"   type="radio" value="1" /><fmt:message key="state.disabled"/></label>
  				</div>
			</div>
			<input type="hidden" name="roleId" value="" id="role_id"/>
				</form>
      </div>
      <div class="modal-footer">
       <button type="button" class="btn btn-primary" ><fmt:message key="common.define"></fmt:message></button>
        <button type="button" class="btn btn-default" data-dismiss="modal" ><fmt:message key="common.cancel"></fmt:message></button>
       
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<div style="display: none">
	<form action="<c:url value="/role/export.do" />" method="post" id="hiddenForm"></form>
	</div>
	


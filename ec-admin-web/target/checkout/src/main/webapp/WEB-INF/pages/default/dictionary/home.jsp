<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<jsp:include page="script.jsp"/>
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header" style="padding-bottom: 12px"><i class="fa fa-align-justify fa-lg"></i>
			<fmt:message key="system.management" />
			>> <a  href='<c:url value="/dictionary/show/home.do"/>' ><fmt:message key="dictionary.title" /></a>
				<button class="btn btn-primary  pull-right" type="button"  data-toggle="modal" data-target="#myModal">
					<i class="fa fa-plus"></i>&nbsp;&nbsp;<fmt:message key="common.button.create"></fmt:message>
				</button>
		</h3>
	</div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modal-body" aria-hidden="true"  data-backdrop="static">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3 class="modal-title text-center" id="myModalLabel"><fmt:message key="dictionary.add.title"/></h3>
      </div>
      <div class="modal-body">
        <form class="form-inline" action="<c:url value="/dictionary/add_category.do"/>" role="form" id="add_dictionary_form" action='' method="post">
			<div class="row">
				<div class="col-xs-2 col-xs-np"></div>
  				<div class="col-xs-1 col-xs-np ml">
   	 					<label for="code" class="control-label pull-right"><fmt:message key="common.colon"><fmt:param><fmt:message key="dictionary.code"/></fmt:param></fmt:message></label>
  				</div>
  				<div class="col-xs-8 col-xs-np">
   	 					<input type="text" class="form-control input-sm" id="code" maxlength="16" 
								placeholder="<fmt:message key="dictionary.code"/>" name="code" >
  				</div>
			</div>
			<div class="row">
				<div class="col-xs-2 col-xs-np"></div>
  				<div class="col-xs-1 col-xs-np ml">
   	 					<label for="name" class="control-label pull-right"><fmt:message key="common.colon"><fmt:param><fmt:message key="dictionary.name"/></fmt:param></fmt:message></label>
  				</div>
  				<div class="col-xs-8 col-xs-np">
   	 					<input name="name" class="form-control input-sm" id="name" type="text" maxlength="30" placeholder="<fmt:message key="dictionary.name"/>"/>
  				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
       <button type="button" class="btn btn-primary" onclick="addDictionary()"><fmt:message key="common.define"></fmt:message></button>
        <button type="button" class="btn btn-default" data-dismiss="modal" ><fmt:message key="common.cancel"></fmt:message></button>
       
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="panel panel-default">
	<div class="panel-heading" style="padding: 5px 15px; height: 45px;">
		<div class="pull-left panel-heading-title-left">
			<i class="fa fa-table fa-lg"></i>&nbsp;&nbsp;<fmt:message key="dictionary.table.title"></fmt:message>
		</div>
	</div>
	<div class="panel-body">
		<div class="table-responsive">
			<table id="dictionary_table"
				class="table table-striped table-bordered table-hover " width="100%">
				<thead>
					<tr>
						<th width="100"><fmt:message key="dictionary.code"/></th>
						<th width="675"><fmt:message key="dictionary.name"/></th>
						<th>id</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>

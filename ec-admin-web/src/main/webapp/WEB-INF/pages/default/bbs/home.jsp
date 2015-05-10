<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<jsp:include page="home_script.jsp" />
<jsp:include page="upload_script.jsp" />
<style>
.fileinput-button input {
position: absolute;
top: 0;
right: 0;
margin: 0;
border: solid transparent;
border-width: 0 0 0 240px;
opacity: 0;
filter: alpha(opacity=0);
-moz-transform: translate(-300px, 0) scale(4);
direction: ltr;
cursor: pointer;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header" style="padding-bottom: 12px"><i class="fa fa-align-justify fa-lg"></i>
			<a href="<c:url value="/announcement/show/home.do"/>" ><fmt:message key="bbs"></fmt:message></a>
				<button class="btn btn-primary  pull-right" type="button"  onclick="showElement('addbbs');">
					<i class="fa fa-plus"></i>&nbsp;&nbsp;<fmt:message key="common.button.create"></fmt:message>
				</button>
		</h3>
	</div>
</div>
<div class="modal fade" id="addbbs" tabindex="-1" role="dialog" aria-labelledby="modal-body" aria-hidden="true"  data-backdrop="static">
  <div class="modal-dialog" style="width:800px">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3 class="modal-title text-center" id="myModalLabel"><fmt:message key="bbs.add.title"/></h3>
      </div>
      <div class="modal-body ml" >
        <form class="form-inline" action="<c:url value="/announcement/add.do"/>" role="form" id="add_announcement"  method="post">
			<div class="row">
				<div class="col-xs-12 col-xs-np">
					<label class="control-label ">
						<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.type"/></fmt:param>
						</fmt:message><font color="red">*</font>
					</label>
					<dic:select  name="categoryId" id="category" styleClass="w200" selectValue="">
							<option value=""><fmt:message key="common.all"></fmt:message></option>
							<dic:option parentCode="10027"/>
					</dic:select>
					<label class="control-label">
  				<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.publish.department"/></fmt:param></fmt:message>
  				<font color="red">*</font>
  				</label>
  				<dic:select name="departmentId" id="department" styleClass="w200" selectValue="">
							<option value=""><fmt:message key="common.all"></fmt:message></option> 
							<dic:option parentCode="10028"/> 
						</dic:select>
  				
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-xs-np">
					<label class="control-label">
						<fmt:message key="common.colon">
							<fmt:param><fmt:message key="bbs.publish.target"/></fmt:param>
						</fmt:message><font color="red">*</font>
					</label>
					<label class="control-label">
						<fmt:message key="common.colon">
							<fmt:param><fmt:message key="common.brand"/></fmt:param>
						</fmt:message>
					</label>
					<select name="brand" id="brand" class="" onchange="getDealerArea(this,'add')"> 
							<option value=""><fmt:message key="common.all"></fmt:message></option> 
						</select>
					<label class="control-label">
						<fmt:message key="common.colon">
							<fmt:param><fmt:message key="common.region"/></fmt:param>
						</fmt:message>
					</label>
					<select name="dealerArea" id="dealerArea" class="" onchange="getProvince(this,'add')" style="width: 65px;">
						<option value=""><fmt:message key="common.all"></fmt:message></option>
					</select>
					 <label class="control-label">
						<fmt:message key="common.colon">
							<fmt:param><fmt:message key="common.province"/></fmt:param>
						</fmt:message>
					</label>
					<select name="province" id="province" class="" onchange="getDealerCatrgory(this)" style="width: 90px;">
						<option value=""><fmt:message key="common.all"></fmt:message></option>
					</select>
					<label class="control-label">
						<fmt:message key="common.colon">
							<fmt:param><fmt:message key="common.dealerCode"/></fmt:param>
						</fmt:message>
					</label>
					<select multiple name="dealerCode" id="dealerCode" style="width:200px"></select>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-xs-np">
					<label class="control-label ">
						<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.title"/></fmt:param>
						</fmt:message><font color="red">*</font>
					</label>
					<input class="form-control input-sm required" style="width:436px" maxlength="100"  name="title" type="text" onkeypress="if(event.keyCode==13){return false;}" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-xs-np">
					<label class="control-label ">
						<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.content"/></fmt:param>
						</fmt:message><font color="red">*</font>
					</label>
					<textarea id="add_announcement_textarea" class="form-control required" maxlength="500" style="width:540px;height:120px;" name="content" cols="200" rows="3"></textarea>
				</div>
			</div>
			<div class="row ">
				<div class="col-xs-12 col-xs-np ml20">
					<label class="control-label ">
						<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.linked.men"/></fmt:param>
						</fmt:message>
					</label>
					<input class="form-control input-sm w195 filterContactProson" name="contactPerson" maxlength="20" type="text" />
					<label class="control-label ">
  					<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.linked.phone"/></fmt:param></fmt:message>
  					</label>
  					<input class="form-control input-sm w195 validatePhone" name="contactPhone" maxlength="20" type="text" />
				</div>
			</div>
			<div id="dealerCodeAddHiddens"></div>
		</form>
		<div id="file_list" class="cl mt10" style="padding-left:45px"></div>
		<div class="row">
				<div class="col-xs-1 col-xs-np">
				</div>
  				<div class="col-xs-10 col-xs-np">
   	 					<!-- 附件上传 -->
					<form id="upload_form" action="<c:url value='/announcement/show/upload.do'/>" method="post" enctype="multipart/form-data">
						 <div class="fileupload-buttonbar" style="height:20px;margin-top:10px">
				            <div>
				                <!-- The fileinput-button span is used to style the file input field as button -->
				                <span class="btn btn-success fileinput-button" style="position:absolute;">
				                    <span class="glyphicon glyphicon-paperclip"></span>
				                    <span><fmt:message key="common.file.add"/></span>
				                    <input type="file" name="files" onchange="fileUpload()">
				                    <span><img id="file_upload_img" src="<c:url value="/images/loader.gif"/>" width="16px" height="16px" style="display:none"/></span>
				                </span>
				               </div>
				         	</div>
					</form> 
  				</div>
			</div>
      </div>
      <div class="modal-footer">
       <button type="button" class="btn btn-primary" onclick="ajaxSubmitAdd('add_announcement',this)"><fmt:message key="common.define"></fmt:message></button>
        <button type="button" class="btn btn-default" data-dismiss="modal" ><fmt:message key="common.cancel"></fmt:message></button>
       
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<ul class="nav nav-tabs">
  <li class="active"><a href="#bbs1" data-toggle="tab"><fmt:message key="bbs.nopublished"></fmt:message></a></li>
  <li><a href="#bbs2" data-toggle="tab"><fmt:message key="bbs.published"></fmt:message></a></li>
</ul>
<div class="tab-content mt15">
  <div class="tab-pane active" id="bbs1">
  <div class="panel panel-default">
	<div class="panel-heading" style="padding: 5px 15px; height: 45px;">
		<div class="pull-left panel-heading-title-left">
			<i class="fa fa-table fa-lg"></i>&nbsp;&nbsp;<fmt:message key="bbs.nopublished.list"></fmt:message>
		</div>
	</div>
	<div class="panel-body">
		<div class="table-responsive">
			<form id="announcement_form" action="" method="post">
				<input type="hidden" name="state" value="false"/>
			<table id="bbsTable1"
				class="table table-striped table-bordered table-hover " width="100%">
				 <thead>
				  	<tr class="bb"> 
					    <th width="22"><input id="check_all" name="" onclick="selectOption(this,$('#bbsTable1'));" type="checkbox" value="" /></th>
					    <th width="573"><fmt:message key="bbs.title"></fmt:message></th>
					    <th width="170"><fmt:message key="bbs.create.time"></fmt:message></th>
					    <th width="0">Id</th>
					    <th width="0"><fmt:message key="bbs.message"></fmt:message></th>
				    </tr>
				  </thead>
				  <tbody>
				  </tbody>
				</table>
			</form>
		</div>
	</div>
	 <div class="panel-footer">
	 <button class="btn btn-primary" id="releasebbs_button" type="button" onclick="releasebbs()"><fmt:message key="bbs.release" /></button>
	 <button type="button" class="btn btn-default ml" onclick="deletebbs($('#announcement_form'),0)"><fmt:message key="bbs.delete"></fmt:message></button>
	 </div>
</div>
  </div>
  <div class="tab-pane" id="bbs2">
	<div class="panel panel-default">
	<div class="panel-heading" style="padding: 5px 15px; height: 45px;">
		<div class="pull-left panel-heading-title-left">
			<i class="fa fa-table fa-lg"></i>&nbsp;&nbsp;<fmt:message key="bbs.published.list"></fmt:message>
		</div>
	</div>
	<div class="panel-body">
		<div class="table-responsive">
			<form id="announcement_form_released" action="" method="post">
			<input type="hidden" name="state" value="true"/>
			<table id="bbsTable2"
				class="table table-striped table-bordered table-hover " width="100%">
					<thead>
					  	<tr class="bb">
					  		<th width="22"><input id="check_all_release" name="" onclick="selectOption(this,$('#bbsTable2'));" type="checkbox" value="" /></th>
						    <th width="600" ><fmt:message key="bbs.title"></fmt:message></th>
						    <th width="142"><fmt:message key="bbs.release.time"></fmt:message></th>
						    <th width="0">Id</th>
						    <th width="0">count</th>
					    </tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	 <div class="panel-footer">
	 <button class="btn btn-primary " type="button" onclick="deletebbs($('#announcement_form_released'),1)"><fmt:message key="bbs.delete" /></button>
</div>
  </div>
</div>
</div>
<div class="modal fade" style="width:200px" id="confirm" tabindex="-1" role="dialog" aria-labelledby="modal-body" aria-hidden="true"  data-backdrop="static">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Modal title</h4>
      </div>
      <div class="modal-body">
               <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        	   <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


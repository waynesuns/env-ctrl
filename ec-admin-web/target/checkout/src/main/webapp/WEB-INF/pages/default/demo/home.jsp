<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<style>
  /* .ui-tabs-vertical { width: 55em; }
  .ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 12em; } */
  /*.ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
  .ui-tabs-vertical .ui-tabs-nav li a { display:block; }
  .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
  .ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 40em;} */
  </style>
<jsp:include page="script.jsp" />
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header" style="padding-bottom: 12px"><i class="fa fa-align-justify fa-lg"></i>
			<fmt:message key="system.management" />
			>> <a id="testtooltip" href="role/show/home.do"   data-toggle="tooltip" data-placement="bottom"  data-original-title="Tooltip on bottom"><fmt:message key="menu.role" /></a>
				<button class="btn btn-primary  pull-right"  data-toggle="modal" data-target="#myModal">
					<i class="fa fa-plus"></i>&nbsp;&nbsp;角色新增
				</button>
		</h3>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading" style="padding: 5px 15px; height: 45px">
		<div class="pull-left panel-heading-title-left">
			<i class="fa fa-search fa-lg"></i>&nbsp;&nbsp;角色查询
		</div>
	</div>
	<div class="panel-body">
		<form class="form-inline" role="form">
			<div class="row">
  				<div class="col-xs-2 col-xs-np">
   	 					<label for="exampleInputEmail2" class="pull-right">Email address：</label>
  				</div>
  				<div class="col-xs-4 col-xs-np">
   	 					<input type="email" class="form-control input-sm" id="exampleInputEmail2" placeholder="Enter email">
  				</div>
  				<div class="col-xs-2 col-xs-np">
   	 					<label for="exampleInputPassword2" class="pull-right">Password：</label>
  				</div>
  				<div class="col-xs-4 col-xs-np">
    					<input type="password" class="form-control input-sm" id="exampleInputPassword2" placeholder="Password">
  				</div>
			</div>
			<div class="row">
				<div class="col-xs-2 col-xs-np">
				<label  class="pull-right">checkbox：</label>
				</div>
				<div class="col-xs-4 col-xs-np">
					<label class="checkbox-inline" for="inlineCheckbox1"> <input type="checkbox"
						id="inlineCheckbox1" value="option1"> 1
					</label> 
					<label class="checkbox-inline" for="inlineCheckbox2"> <input type="checkbox"
						id="inlineCheckbox2" value="option2"> 2
					</label> 
					<label class="checkbox-inline" for="inlineCheckbox3"> <input type="checkbox"
						id="inlineCheckbox3" value="option3"> 3
					</label>
				</div>
				<div class="col-xs-2 col-xs-np">
				<label  class="pull-right">radio：</label>
				</div>
				<div class="col-xs-4 col-xs-np">
    					<label class="radio-inline" for="inlineRadio1"> <input type="radio"
						id="inlineRadio1" value="option1" name="radio"> 1
					</label> 
					<label class="radio-inline" for="inlineRadio2"> <input type="radio"
						id="inlineRadio2" value="option2" name="radio"> 2
					</label> 
					<label class="radio-inline" for="inlineRadio3"> <input type="radio"
						id="inlineRadio3" value="option3" name="radio"> 3
					</label>
  				</div>
			</div>
			<div class="row">
				<div class="col-xs-2 col-xs-np">
					<label class="pull-right"  for="select">select：</label>
				</div>
				<div class="col-xs-4 col-xs-np">
					<select id="authorized_users" name="userId" class="" style="width: 200px;" multiple></select>
				</div>
				<div class="col-xs-2 col-xs-np">
					<label class="pull-right"  for="date">date：</label>
				</div>
				<div class="col-xs-4 col-xs-np">
					<input type="text" class="form-control input-sm" id="date" placeholder="Select date" >
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2 col-xs-np">
					<label class="pull-right"  for="textarea">textarea：</label>
				</div>
				<div class="col-xs-10 col-xs-np">
					<textarea class="form-control " rows="3" id="textarea" cols="100" ></textarea>
				</div>
			</div>
			
			<button type="button" id="reasch" class="btn btn-default pull-right"  data-loading-text="<i class='fa fa-search'></i>&nbsp;&nbsp;正在查询..."  onclick=""><i class="fa fa-search"></i>&nbsp;&nbsp;查询</button>
		</form>
	</div>
</div>
<div class="panel panel-default">
	<div class="panel-heading" style="padding: 5px 15px; height: 45px;">
		<div class="pull-left panel-heading-title-left">
			<i class="fa fa-table fa-lg"></i>&nbsp;&nbsp;角色列表
		</div>
		<button class="btn btn-default pull-right">
			<i class="fa fa-download"></i>&nbsp;&nbsp;角色导出
		</button>
	</div>
	<div class="panel-body">
		<div class="table-responsive">
			<table id="role_table"
				class="table table-striped table-bordered table-hover " >
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
 <div  class="col-sm-6">
            <div class="col-xs-3"> <!-- required for floating -->
                <!-- Nav tabs -->
                <ul class="nav nav-tabs tabs-left">
                  <li class="active"><a href="#home" data-toggle="tab">Home</a></li>
                  <li><a href="#profile" data-toggle="tab">Profile</a></li>
                  <li><a href="#messages" data-toggle="tab">Messages</a></li>
                  <li><a href="#settings" data-toggle="tab">Settings</a></li>
                </ul>
            </div>

            <div class="col-xs-9">
                <!-- Tab panes -->
                <div class="tab-content">
                  <div class="tab-pane active" id="home">Home Tab.</div>
                  <div class="tab-pane" id="profile">Profile Tab.</div>
                  <div class="tab-pane" id="messages">Messages Tab.</div>
                  <div class="tab-pane" id="settings">Settings Tab.</div>
                </div>
            </div>


        </div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modal-body" aria-hidden="true" data-backdrop="static">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3 class="modal-title text-center" id="myModalLabel">角色新增</h3>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" id="addForm">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<input type="email" class="form-control input-sm col-lg-6" id="inputEmail"
								placeholder="Email" name="email">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" name="password" class="form-control input-sm col-lg-6" id="inputPassword"
								placeholder="Password">
						</div>
					</div>
				</form>
      </div>
      <div class="modal-footer">
       <button type="button" class="btn btn-primary" onclick="saveRole()">确定</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" >取消</button>
       
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



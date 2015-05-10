<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<script type="text/javascript"> 
var nTr = "";  //打开或者关闭
var userStr = "";
var oTable = ""; // 当前初始化的tadatable 
function getUser(){
	$.ajax({
		url : '<c:url value="/role/show/user_enabled_list.do" />',
		type : 'post',
		dataType : 'json',
		success : function(data) {
			var html = '<optgroup label="<fmt:message key="user.list"/>">';
			var json = data.aaData;
			for(var i = 0;i<json.length;i++)
				html += '<option value="'+json[i].id+'">'+json[i].name+'</option>';
			html += '</optgroup>';
			$("#authorized_users").append(html);
			initMultiselect("authorized_users");
		}
	});
}
function getMenu(){
	$.ajax({
		url : '<c:url value="/role/show/menu_enabled_list.do" />',
		type : 'post',
		dataType : 'json',
		success : function(data) {
			var json = data.aaData;
			for(var i = 0;i<json.length;i++){
				if(json[i].type=="menucategory"){
					var menu_childrens=json[i].childrens;
					var html='<li id="category_' + json[i].id + '"><input name="categoryId" id="category_check_' + json[i].id + '" type="checkbox" onclick="checkedAll(this);"   value="'+json[i].id+'" /><a href="#content_' + json[i].id + '" data-toggle="tab" >'+json[i].name+'</a></li>';
					$("#menu_tabs").append(html);
					var content_html='<div class="tab-pane popup" id="content_' + json[i].id + '">';
					if(menu_childrens.length==0){
						content_html+='<p><fmt:message key="menu.noresources"/></p>';
					}else{
						for(var j=0;j<menu_childrens.length;j++){
								content_html+='<dl  id="menu_' + menu_childrens[j].id + '">';
							content_html+='<dt><input name="menuId" type="checkbox" id="menu_check_' + menu_childrens[j].id + '" onclick="checkedMenu(this,'+menu_childrens[j].parentId+');" value="'+menu_childrens[j].id+'" /><label class="ml5" for="menu_check_' + menu_childrens[j].id + '" >'+menu_childrens[j].name+'</label></dt>';
							var button_childrens=menu_childrens[j].childrens;
							for(var k=0;k<button_childrens.length;k++){
								if((k+1)%3==1)
									content_html+='<div class="row" style="margin-left:0px">';
									content_html+='<div class="col-xs-4"><input type="checkbox" id="button_check_' + button_childrens[k].id + '" value="'+button_childrens[k].id+'" onclick="checkedButton(this,\''+button_childrens[k].parentId+'\',\'menucategory\');" name="buttonId"><label class="ml5 fwn" for="button_check_' + button_childrens[k].id + '" >'+button_childrens[k].name+'</label></div>';
								if((k+1)%3==0)
									content_html+='</div>';
								
							}
							content_html+='</dl>';
						}
					}
					content_html+='</div>';
					$("#contents").append(content_html);
				}
				
				if(json[i].type=="menu"){
					var button_childrens=json[i].childrens;
					var html='<li id="category_' + json[i].id + '"><input  name="menuId" type="checkbox"  id="menu_check_' + json[i].id + '" onclick="checkedAll(this);"   value="'+json[i].id+'" /><a href="#content_' + json[i].id + '" data-toggle="tab">'+json[i].name+'</a></li>';
					$("#menu_tabs").append(html);
					var content_html='<div class="tab-pane popup" id="content_' + json[i].id + '">';
					if(button_childrens.length==0){
						content_html+='<p><fmt:message key="menu.noresources"/></p>';
					}else{
						for(var k=0;k<button_childrens.length;k++){
							if((k+1)%3==1)
								content_html+='<div class="row" style="margin-left:0px">';
								content_html+='<div class="col-xs-4"><input type="checkbox" id="button_check_' + button_childrens[k].id + '" value="'+button_childrens[k].id+'" onclick="checkedButton(this,\''+button_childrens[k].parentId+'\',\'menu\');" name="buttonId"><label class="ml5 fwn" for="button_check_' + button_childrens[k].id + '" >'+button_childrens[k].name+'</label></div>';
							if((k+1)%3==0)
								content_html+='</div>';
							
						}
					}
						
					
					content_html+='</div>';
					$("#contents").append(content_html);
				}
				
			}
			$("#menu_tabs").find("li:first").addClass('active');
			$("#contents").children("div:first").addClass('active');
		}
});
}
function dataTable(){
	oTable = $('#role_table').dataTable({
		"bInfo": true,		//页脚信息
		"bServerSide" : true,
		"bProcessing": true,
		"sDom" : 'TRCF<"clear">rtip',
		"bStateSave" : false,
		"bSortCellsTop" : false,
		"bSort" : false,
		"sPaginationType": "bootstrap",
		"sAjaxSource" : '<c:url value="/role/show/list.do"/>',
		"oLanguage" : <gh:dataTableLanguage/>,
		"iDisplayLength" : 20,
		"aoColumnDefs": [{ "bVisible": false, "aTargets": [4,5,6,7,8] }],
		"sServerMethod": "POST",
		"fnInitComplete": function(oSettings, json){
			$("#role_table").show();
		},
		"aoColumns" : [
			{ "mDataProp": "name","sWidth": "145"},
			{ "mDataProp": "users","sWidth": "120" },
			{ "mDataProp": "resources","sWidth": "405" ,"fnRender": function(data){
				return data.aData.resources;
			}},
			{ "mDataProp": "stateStr","sWidth": "100","fnRender": function(data){
				 var aData=data.aData;
			     var state = aData.stateStr;
			     if(state=="0")
			    	return '<fmt:message key="state.enabled"/>';
				 return '<fmt:message key="state.disabled"/>';
			}},
			{ "mDataProp": "id" },
			{ "mDataProp": "state" },
			{ "mDataProp": "resourcesTitleStr" ,"fnRender": function(data){
				return data.aData.resourcesTitleStr;
			}},
			{ "mDataProp": "resourcesIds"},
			{ "mDataProp": "userIds"}
		],
		"fnRowCallback": function( nRow, aData, iDisplayIndex ){
			var userTd = $( nRow ).children("td").eq(1);
			$(userTd).html("<div id='users_"+aData.id+"' class='cutLen100' data-toggle='tooltip' data-placement='bottom'  data-original-title='"+aData.users+"'>" + aData.users + "</div>");
			var resourceTd = $( nRow ).children("td").eq(2);
			$(resourceTd).html("<div id='resources_"+aData.id+"' class='cutLen400' data-toggle='tooltip' data-placement='bottom'  data-original-title='"+aData.resources+"'>" + aData.resources + "</div>");
			var td = $(nRow).children().eq(3);
				var img = $(td).find(".option");
				if(img.length>0)
					return;
				$(td).append('<a class="option pull-right cursor" style="margin-right:5px"  data-placement="bottom"  data-original-title="编辑" onclick=""><i  class="fa fa-edit fa-lg " ></i></a>');
				$(td).find(".option").click(function(){
					showEditModal(aData);
				});
				
		},
		"fnServerParams" : function(aoData){
			for(var p = 0; p < aoData.length;p++){
				if (aoData[p].name == 'sSearch_3'){
					var state = HTMLDecode(unescape(aoData[p].value));
					if(state == '<fmt:message key="state.enabled"/>')
						aoData[p].value = 0;
					if(state == '<fmt:message key="state.disabled"/>')
						aoData[p].value = 1;
				}
			}
		},
		"fnDrawCallback":function( oSettings ) {initTips(".cutLen100");initTips(".cutLen400");initTips(".option"); },
		"fnServerData": function ( sSource, aoData, fnCallback ) {
			$.ajax( {
				"dataType": 'json',
				"type": "post", 
				"url": sSource, 
				"data": aoData, 
				"success": fnCallback
			} );
		}
	}).columnFilter({ sPlaceHolder: "head:after",
		aoColumns: [
                    { type: "text" },
                    null,
                    null,
                    { type: "select",values:['<fmt:message key="state.enabled"/>','<fmt:message key="state.disabled"/>'] }
                    ]
	});
}
//关闭ntr
function closeAddOrEdit(){
	var formSize = $("#role_update_form").size();
	if(formSize >=1 )
		$("#role_update_form").resetForm();
	oTable.fnClose(nTr);
	nTr = "";
}
$(document).ready(function() {
	$('#myModal').on('hide.bs.modal', function (e) {
		  // do something...
		window.scrollTo(0,0);
		$("#role_form").resetForm();
		clearnCheckbox("role_form");
		});
	getUser();
	getMenu();
	dataTable();
} );// 初始化read结束

//菜单复选框多选
function checkedAll(thiz){
	 $(thiz).next().tab('show');
	if($(thiz).is(":checked"))
		 $("#content_"+$(thiz).val()).find("input[type='checkbox']").prop("checked",true);
	else
		 $("#content_"+$(thiz).val()).find("input[type='checkbox']").prop("checked",false);
}
function checkedButton(thiz,parentId,type){
	if(type=="menucategory"){//一级菜单的按钮
		var dl=	$("#menu_"+parentId);//二级菜单内容
		var contentid=$(dl).parent().attr("id");//一级菜单的ID
		var category=$("#category_"+contentid.split("_")[1]);//一级菜单的tab
		var content=$("#"+contentid);//一级菜单的内容
		if($(thiz).is(":checked")){//当前按钮选中
			$(dl).children("dt").children(":checkbox").prop("checked",true);//相关二级菜单选中
			$(category).children(":checkbox").prop("checked",true);//相关一级菜单选中
			if(!isAllChecked($(dl).children("div.row"))){//相关的二级菜单的按钮未全部选中
				$(dl).children("dt").children(":checkbox").prop("indeterminate",true);//二级菜单的设置为部分选择样式
			}else{//相关的二级菜单的按钮全部选中
				$(dl).children("dt").children(":checkbox").prop("indeterminate",false);//关闭二级菜单的设置为部分选择样式
			}
			if(!isAllChecked(content)){//相关的一级级菜单的二级菜单和按钮未全部选中
				$(category).children(":checkbox").prop("indeterminate",true);//一级级菜单的设置为部分选择样式
			}else{//相关的一级级菜单的二级菜单和按钮全部选中
				$(category).children(":checkbox").prop("indeterminate",false);//关闭一级菜单的设置为部分选择样式
			}
		}else{//当前按钮未选中，则需要设置相关二级菜单的checkbox样式和一级菜单的checkbox的样式
			if(isAllNoChecked($(dl).children("div.row"))){
				$(dl).children("dt").children(":checkbox").prop("checked",false);
				$(dl).children("dt").children(":checkbox").prop("indeterminate",false);
			}else{
				$(dl).children("dt").children(":checkbox").prop("checked",true);
				$(dl).children("dt").children(":checkbox").prop("indeterminate",true);
			}
			if(isAllNoChecked(content)){
				$(category).children(":checkbox").prop("checked",false);
				$(category).children(":checkbox").prop("indeterminate",false);
			}else{
				$(category).children(":checkbox").prop("checked",true);
				$(category).children(":checkbox").prop("indeterminate",true);
			}
		}
	}else{//当前按钮为二级菜单的按钮
		var category=$("#category_"+parentId);//二级菜单的tab
		var content=$("#content_"+parentId);//二级菜单的内容
		if($(thiz).is(":checked")){//当前按钮选中
			$(category).children(":checkbox").prop("checked",true);//相关二级菜单选中
			if(!isAllChecked(content)){//相关的二级菜单的按钮未全部选中
				$(category).children(":checkbox").prop("indeterminate",true);//二级菜单的设置为部分选择样式
			}else{//相关的二级菜单的按钮全部选中
				$(category).children(":checkbox").prop("indeterminate",false);//关闭二级菜单的设置为部分选择样式
			}
		}else{//当前按钮未选中，则需要设置相关二级菜单的checkbox样式
			if(isAllNoChecked(content)){
				$(category).children(":checkbox").prop("checked",false);
				$(category).children(":checkbox").prop("indeterminate",false);
			}else{
				$(category).children(":checkbox").prop("checked",true);
				$(category).children(":checkbox").prop("indeterminate",true);
			}
		}
	}
}
function checkedMenu(thiz,parentId){
	if($(thiz).is(":checked")){
		$(thiz).parent("dt").parent("dl").children("div.row").find(":checkbox").prop("checked",true);
		$("#category_"+parentId).children(":checkbox").prop("checked",true);
		if(!isAllChecked("#content_"+parentId)){
			$("#category_"+parentId).children(":checkbox").prop("indeterminate",true);
		}else{
			$("#category_"+parentId).children(":checkbox").prop("indeterminate",false);
		}
	}else{
		$(thiz).parent("dt").parent("dl").children("div.row").find(":checkbox").prop("checked",false);
		if(isAllNoChecked("#content_"+parentId)){
			$("#category_"+parentId).children(":checkbox").prop("checked",false);
			$("#category_"+parentId).children(":checkbox").prop("indeterminate",false);
		}else{
			$("#category_"+parentId).children(":checkbox").prop("checked",true);
			$("#category_"+parentId).children(":checkbox").prop("indeterminate",true);
		}
	}
}

function isAllChecked(container){
	var isChecked=true;
	var child_checkboxs=$(container).find(":checkbox");
	for(var i=0;i<child_checkboxs.length;i++){
		if(!$(child_checkboxs[i]).is(":checked")){
			isChecked=false;
			break;
		}
	}
	return isChecked;
}
function isAllNoChecked(container){
	var isnoChecked=true;
	var child_checkboxs=$(container).find(":checkbox");
	for(var i=0;i<child_checkboxs.length;i++){
		if($(child_checkboxs[i]).is(":checked")){
			isnoChecked=false;
			break;
		}
	}
	return isnoChecked;
}
function ajaxSubmitRole(divId){
	validationTooltipFormContentRight(divId,null);
	if($("#"+divId).validate().form()){
		$("#"+divId).ajaxSubmit({ dataType : 'html', success : function(json) {
			closeModal('myModal');
			oTable.fnReloadAjax();
			open_popover_success('<fmt:message key="role.success.add" />');
			
		} });
	}
}
function clearnCheckbox(formID){
	$("#"+formID).find(":checkbox").prop("checked",false);
	$("#"+formID).find(":checkbox").prop("indeterminate",false);
	$("#authorized_users").find("option").prop("selected",false);
	$("input[type='search']").val("");
}

function setChecked(str){
	var array = str.split("、");
	for(var i = 0;i<array.length;i++){
		if(array[i]!=""&&array[i]!=null){
			var input = $("#role_form").find("input[value='"+array[i]+"']");
				$(input).prop("checked",true);
			 
		}
	}
	for(var i = 0;i<array.length;i++){
		if(array[i]!=""&&array[i]!=null){
			var input = $("#role_form").find("input[value='"+array[i]+"']");
			if($("#category_"+array[i]).size()>0){//左侧tab
				if(!isAllChecked("#content_"+array[i]))
					$(input).prop("indeterminate",true);
			}else if($("#menu_"+array[i]).size()>0){//二级菜单
				if(!isAllChecked($("#menu_"+array[i]).children("div.row")))
					$(input).prop("indeterminate",true);
			} 
			 
		}
	}
	
}

function shownewForm(){
	$("#myModal .modal-header h3").html('<fmt:message key="role.add.title"/>');
	$("#myModal .form-inline").attr("action",'<c:url value="/role/add.do"/>');
	$("#myModal .modal-footer .btn-primary").off("click");
	$("#myModal .modal-footer .btn-primary").click(function(){
		ajaxSubmitRole('role_form');
	});
	$("#role_id").attr("value","");
	$("#state_row").hide();
	$('#myModal').modal('show');
}
function closeModal(selector){
	$('#'+selector).modal('hide');
}

//显示编辑时的菜单
function showEditModal(aaData){
	$("#myModal .modal-header h3").html('<fmt:message key="role.update.title"/>');
	$("#myModal .form-inline").attr("action",'<c:url value="/role/modify.do"/>');
	$("#myModal .modal-footer .btn-primary").off("click");
	$("#myModal .modal-footer .btn-primary").click(function(){
		ajaxUpdateRole('role_form');
	});
	$("#role_id").attr("value",aaData.id);
	$("#state_row").show();
	var userIdList = aaData.userIds.split(",");
	for(var j = 0; j < userIdList.length; j++) {
		$("#authorized_users").find('option[value="'+userIdList[j]+'"]').prop("selected",true);
	}
	$("#authorized_users").multiselect("refresh");
	if(aaData.state=="0"){
		$("#state_role_yes").prop("checked",true);
	}else{
		$("#state_role_no").prop("checked",true);
	}
	setChecked(HTMLDecode(aaData.resourcesIds));
	$("#role_name").val(HTMLDecode(aaData.name));
	$('#myModal').modal('show');
}


function ajaxUpdateRole(divId){
	submitFromTrim(divId);
	validationTooltipFormContentRight(divId,null);
	if($("#"+divId).validate().form()){
		$("#"+divId).ajaxSubmit({ dataType : 'html', success : function(json) {
			closeModal('myModal');
			oTable.fnReloadAjax();
			open_popover_success('<fmt:message key="role.success.modify" />');
			
		} });
	}
}
function exportRole(){
	$("#hiddenForm").submit();
}


</script>
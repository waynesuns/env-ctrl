<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<script type="text/javascript">
function modifyUser(){
	submitFromTrim('modifyUserForm');
	if($("#modifyUserForm").validate().form()){
		$("#modifyUserForm").ajaxSubmit({
			dataType : "json",
			success : function(json){
				oTable.fnReloadAjax();
				open_popover_success(HTMLDecode(json.message));
			}
		});
	}
}
function cancelModify(){
	if($("#modifyUserForm").size() > 0)
		$("#modifyUserForm").resetForm();
	$(oTable.fnGetNodes()).each(function(index){
	    if(oTable.fnIsOpen(this)){
	    	oTable.fnClose(this); 
	    }
    });
}
var oTable;
$(document).ready(function(){
	getRoles();
	validationTooltipFormContentRight("user_form");
	$('#myModal').on('hide.bs.modal', function (e) {
		  // do something...
		window.scrollTo(0,0);
		$("#user_form").resetForm();
		});
	// 编辑和添加图片添加到表中
	// 初始化的DataTable，
	var setting = {
		
			"bInfo": true,		//页脚信息
			//"sDom" : 'TRCF<"clear">lrtip',
			"sDom" : 'TRCF<"clear">rtip',
			"sPaginationType": "bootstrap",
			"bServerSide" : true,
			"bStateSave" : false,
			"bSortCellsTop" : false,
			"bSort" : false,
			"sAjaxSource" : '<c:url value="/user/show/list.do"/>',
			"bProcessing": true,
			"oLanguage" : <gh:dataTableLanguage/>,
			"iDisplayLength" : 20,
			"aoColumnDefs": [
			 	   			{ "bVisible": false, "aTargets": [3] }
			 	   		],
			"aoColumns" : [
				{ "mDataProp" : "name" },
				{ "mDataProp" : "roleNames" },
				{ "mDataProp" : "userName" },
				{ "mDataProp" : "id" }
			],
			"fnServerParams" : function(aoData){
				for(var p = 0; p < aoData.length;p++){
					if(aoData[p].name == 'sSearch_0'){
						aoData[p].value = HTMLDecode(unescape(aoData[p].value));
						$('#nameSearch').val(HTMLDecode(unescape(aoData[p].value)));
					}else if (aoData[p].name == 'sSearch_1'){
						aoData[p].value = HTMLDecode(unescape(aoData[p].value));
						$('#roleSearch').val(HTMLDecode(unescape(aoData[p].value)));
					}else if(aoData[p].name == 'sSearch_2'){
						aoData[p].value = HTMLDecode(unescape(aoData[p].value));
						$('#userNameSearch').val(HTMLDecode(unescape(aoData[p].value)));
					}
				}
			},
			"fnServerData": function ( sSource, aoData, fnCallback ) {
				$.ajax( {
					"dataType": 'json',
					"type": "post", 
					"url": sSource, 
					"data": aoData, 
					"success": fnCallback
				} );
			},
			"fnDrawCallback":function(){
				initTips(".update");
			},
			"fnRowCallback": function( nRow, aData, iDisplayIndex ){
				var nameTd = $( nRow ).children("td").eq(2);
				var img = $(nameTd).find(".update");
				if(img.length>0)
					return;
				$(nameTd).append('<a class="update pull-right cursor" style="margin-right:5px"  data-placement="bottom"  data-original-title="编辑" onclick=""><i  class="fa fa-edit fa-lg " ></i></a>');
				
				$(nameTd).find(".update").click(function(){
					cancelModify();
					nTr = $(this).parents('tr')[0];
					oTable.fnOpen(nTr,fnFormatDetails(oTable,nTr),'details');
					initMultiselect('user_role_sel');
					validationTooltipFormContentRight("modifyUserForm",null);
				});
			} 
	};
	oTable = $('#userTableList').dataTable(setting).columnFilter({ sPlaceHolder: "head:after",
			aoColumns: [
                        {type:"text"},
                        {type:"select",values:${rolesStr}},
                        {type:"text"},
                        null
                        ]
	});
});

function fnFormatDetails ( oTable, nTr ){
	var aData = oTable.fnGetData( nTr );
	var sOut;
	$.ajax({
		url : '<c:url value="/user/show/get.do"/>',
		type : 'post',
		dataType : 'json',
		data : 'id='+aData.id,
		async : false,
		success : function(json){
			sOut = '<div class="modify">';
			sOut += '<form action="<c:url value="/user/modify.do"/>" method="post" id="modifyUserForm">';
			sOut += '<input type="hidden" name="loginId" value="'+json.accountId+'"/>';
			sOut += '<input type="hidden" name="userId" value="'+json.id+'"/>';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '<div class="col-xs-1 col-xs-np ml">';
			sOut += '<label for="name" class="control-label pull-right"><fmt:message key="common.colon"><fmt:param><fmt:message key="user.role.name"/></fmt:param></fmt:message></label>';
			sOut += '</div>';
			sOut += '<div class="col-xs-5 col-xs-np">';
			sOut += '<select class="l required" style="width:210px" name="rolesId" id="user_role_sel" multiple>';
			$.ajax({
				url : '<c:url value="/user/show/role.do"/>',
				type : 'post',
				dataType : 'json',
				async : false,
				success : function(jsonRole){
					var roleIds = json.roleIds.split(",") ;
					var bool = false;
					for(var i = 0;i < jsonRole.length;i++){
						if(roleIds == jsonRole[i].id){
							bool = true;
						}else{
							for(var j = 0; j < roleIds.length;j++){
								if(roleIds[j] == jsonRole[i].id){
									bool = true;
									break;
								}
							}
						}
						if(bool)
							sOut += '<option selected value="'+jsonRole[i].id+'">'+jsonRole[i].name+'</option>';
						else
							sOut += '<option value="'+jsonRole[i].id+'">'+jsonRole[i].name+'</option>';	
						bool = false;
					}
				}
			});
			sOut += '</select>';
			sOut += '</div>';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '</div>';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '<div class="col-xs-4 col-xs-np text-center">';
			sOut += '<button type="button" class="btn btn-primary mr20" onclick="modifyUser()"><fmt:message key="button.modify"/></button><button type="button" class="btn btn-default" onclick="cancelModify()"><fmt:message key="button.cancel"/></button>';
			sOut += '</div>';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '</div>';
			sOut += '</form>';
			sOut += '</div>';
		}
	});
	return sOut;
}
function exportUser(){
$("#hiddenForm").submit();
}

function getRoles(){
	$.ajax({
		url : '<c:url value="/user/show/role.do"/>',
		type : 'post',
		dataType : 'json',
		success : function(data) {
			var html = '<optgroup label="<fmt:message key="role.list"/>">';
			for(var i = 0;i<data.length;i++)
				html += '<option value="'+data[i].id+'">'+data[i].name+'</option>';
			html += '</optgroup>';
			$("#role_ids").append(html);
			initMultiselect("role_ids");
		}
	});
}
function addUser(){
	submitFromTrim('user_form');
	if($("#user_form").validate().form()){
		$("#user_form").ajaxSubmit({
			dataType : "json",
			success : function(json){
				$('#myModal').modal('hide');
				oTable.fnReloadAjax();
				open_popover_success(HTMLDecode(json.message));
			}
		});
	}
}
</script>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<style>
.cutLen_value{width:210px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;float: left;}
</style>
<script type="text/javascript">
var oTable;
var countS = 0;
$(document).ready(function() {
	oTable = $("#sysconfig_table").dataTable({
		"bInfo" : true, //页脚信息
		//"sDom" : 'rtip',
		"sDom" : 'TRCF<"clear">rtip',
		/* "bServerSide" : true, */
		"bStateSave" : false,
		"bSortCellsTop" : false,
		"sPaginationType" : "bootstrap",
		"bSort" : false,
		"sAjaxSource" : '<c:url value="/sysconfig/show/list.do"/>',
		"sServerMethod" : "POST",
		"aaSorting": [[ 0, "asc" ]],
		"oLanguage" : <gh:dataTableLanguage/>,
		"aoColumns" : [
		                {
			"mDataProp" : "code"
		}, {
			"mDataProp" : "name","fnRender": function(data){
   				return HTMLDecode(data.aData.name);
   			}
		}, {
			"mDataProp" : "value"
		},
		{
			"mDataProp" : "id"
		}],
		"aoColumnDefs": [
			 	   			{ "bVisible": false, "aTargets": [3]}
			 	   		],
		"fnDrawCallback" : function() {
			initTips(".update");
		},
		"fnServerParams" : function(aoData){
			for(var p = 0; p < aoData.length;p++){
				//alert(aoData[p].name+"="+aoData[p].value);
				if(aoData[p].name == 'sSearch_0'){
					aoData[p].value = HTMLDecode(unescape(aoData[p].value));
				}else if (aoData[p].name == 'sSearch_1'){
					aoData[p].value = HTMLDecode(unescape(aoData[p].value));
				}else if(aoData[p].name == 'sSearch_2'){
					aoData[p].value = HTMLDecode(unescape(aoData[p].value));
				}
			}

		},
		"fnRowCallback" : function(nRow, aData, iDisplayIndex) {
			var nameTd = $( nRow ).children("td").eq(2);
			var img = $(nameTd).find(".update");
			if(img.length>0)
				return;
			$(nameTd).append('<a class="update pull-right cursor" style="margin-right:5px"  data-placement="bottom"  data-original-title="编辑" onclick=""><i  class="fa fa-edit fa-lg " ></i></a>');
			
			$(nameTd).find(".update").click(function(){
				reseatModifySysconfig();
				nTr = $(this).parents('tr')[0];
				oTable.fnOpen(nTr,fnFormatEditItem(oTable,nTr),'details');
				var rules = {
						name : {
							required : true
						},
						value : {
							required : true
						}
				};
				var messages = {
						name : {
							required : "名称不能为空"
						//	maxlength : "请输入一个长度最多是 {0} 的字符串"
						},
						value : {
							required : "配置值不能为空"
						}
				};
				validationTooltipFormContentRight("sysconfig_modify_item_form",null,rules,messages);
			});
		}
	}).columnFilter({ sPlaceHolder: "head:before",
		aoColumns: [
		          
                    { type: "text"},
                    { type: "text" },
                    { type: "text" },
                    null
                    ]
});
});
function reseatModifySysconfig(){
	$(oTable.fnGetNodes()).each(function(index){
	    if(oTable.fnIsOpen(this)){
	    	oTable.fnClose(this); 
	    }
    });
	$("form").resetForm();
}
function fnFormatEditItem(oTable, nTr){
	var aData = oTable.fnGetData( nTr );
	var sOut = "";
	$.ajax({
		url : '<c:url value="/sysconfig/get.do"/>',
		dataType : 'json',
		type : 'post',
		data : {id : aData.id},
		async : false,
		success : function(json){
			sOut = '<div class="modify">';
			sOut += '<form action="<c:url value="/sysconfig/modify_item.do" />" method="post" id="sysconfig_modify_item_form">';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '<div class="col-xs-1 col-xs-np ml">';
			sOut += '<label for="name" class="control-label pull-right"><fmt:message key="common.colon"><fmt:param><fmt:message key="sysconfig.name"/></fmt:param></fmt:message></label>';
			sOut += '</div>';
			sOut += '<div class="col-xs-5 col-xs-np">';
			sOut += '<input name="name" class="form-control input-sm" value="'+json.name+'" maxlength="200" style="width:200px" id="name" type="text"  placeholder="<fmt:message key="sysconfig.name"/>"/>';
			sOut += '</div>';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '</div>';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '<div class="col-xs-1 col-xs-np ml">';
			sOut += '<label for="value" class="control-label pull-right"><fmt:message key="common.colon"><fmt:param><fmt:message key="sysconfig.value"/></fmt:param></fmt:message></label>';
			sOut += '</div>';
			sOut += '<div class="col-xs-5 col-xs-np">';
			sOut += '<input name="value" class="form-control input-sm" style="width:200px" value="'+json.value+'" maxlength="200" id="value" type="text"  placeholder="<fmt:message key="sysconfig.value"/>"/>';
			sOut += '</div>';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '</div>';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '<div class="col-xs-4 col-xs-np text-center">';
			sOut += '<button type="button" class="btn btn-primary mr20" onclick="modifyItem(\''+json.id+'\')"><fmt:message key="button.modify"/></button><button type="button" class="btn btn-default" onclick="reseatModifySysconfig()"><fmt:message key="button.cancel"/></button>';
			sOut += '</div>';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '</div>';
			sOut += '</form>';
			sOut += '</div>';
		}
	});
	return sOut;
}
function modifyItem(id){
	if($("#sysconfig_modify_item_form").validate().form()){
		$("#sysconfig_modify_item_form").ajaxSubmit({
			dataType : "json",
			data : {id : id},
			success : function(json){
				open_popover_success(HTMLDecode(json.message));
				oTable.fnReloadAjax();
				reseatModifySysconfig();
			}
		});
	}
}

</script>
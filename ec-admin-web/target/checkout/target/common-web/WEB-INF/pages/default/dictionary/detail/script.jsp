<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<script type="text/javascript">
var categoryId = '${id}';

var countS = 0;
var oTable;
$(document).ready(function() {
	initTips("#back");
	$('#myModal').on('hide.bs.modal', function (e) {
		  // do something...
		$("#dictionary_add_item_form").resetForm();
		});
	var rules = {
		name : {
			required : true,
			maxlength : 30
		},
		value : {
			required : true,
			maxlength : 16,
			digitalOrLetter : true
		}
	};
	var messages = {	
	};
	validationTooltipFormContentRight("dictionary_add_item_form", null, rules, messages);


	var params = '?id='+ encodeURIComponent(categoryId);

	oTable = $("#dictionary_table").dataTable({
		"bInfo" : true,
		"sDom" : 'rtip',
		"sPaginationType" : "bootstrap",
		"bSort" : false,
		"sAjaxSource" : '<c:url value="/dictionary/detail/show/list.do' + params + '"/>',
		"sServerMethod" : "POST",
		"oLanguage" : <gh:dataTableLanguage/>,
		"aoColumns" : [
			               {"mDataProp" : "name"}, 
			               {"mDataProp" : "value"}, 
			               {"mDataProp" : "stateStr"}, 
			               {"mDataProp" : "id"}
		               ],
		"aoColumnDefs": [
			 	   			{ "bVisible": false, "aTargets": [3]}
			 	   		],
		"fnDrawCallback":function( oSettings ) {initTips(".update"); },
		"fnRowCallback" : function(nRow, aData, iDisplayIndex) {
			var nameTd = $( nRow ).children("td").eq(2);
			var img = $(nameTd).find(".update");
			if(img.length>0)
				return;
			$(nameTd).append('<a class="update pull-right cursor" style="margin-right:5px"  data-placement="bottom"  data-original-title="编辑" onclick=""><i  class="fa fa-edit fa-lg " ></i></a>');
			
			$(nameTd).find(".update").click(function(){
				resetDictionaryItem();
				nTr = $(this).parents('tr')[0];
				oTable.fnOpen(nTr,fnFormatEditItem(oTable,nTr),'details');
				var rulesAdd = {
						name : {
							required : true,
							maxlength : 30
						},
						state : {
							required : true
						}
				};
				var messagesAdd = {
				};
				validationTooltipFormContentRight("dictionary_modify_item_form",null,rulesAdd,messagesAdd);
			});
		}
	});
});



function fnFormatEditItem(oTable, nTr){
	var aData = oTable.fnGetData( nTr );
	var sOut = "";
	$.ajax({
		url : '<c:url value="/dictionary/detail/show/get.do"/>',
		dataType : 'json',
		type : 'post',
		data : {id : aData.id},
		async : false,
		success : function(json){
			sOut = '<div class="modify">';
			sOut += '<form action="<c:url value="/dictionary/detail/modify_item.do" />" method="post" id="dictionary_modify_item_form">';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '<div class="col-xs-1 col-xs-np ml">';
			sOut += '<label for="name" class="control-label pull-right"><fmt:message key="common.colon"><fmt:param><fmt:message key="dictionary.name"/></fmt:param></fmt:message></label>';
			sOut += '</div>';
			sOut += '<div class="col-xs-5 col-xs-np">';
			sOut += '<input name="name" class="form-control input-sm" value="'+json.name+'" id="name" type="text" maxlength="30" placeholder="<fmt:message key="dictionary.name"/>"/>';
			sOut += '</div>';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '</div>';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '<div class="col-xs-1 col-xs-np ml">';
			sOut += '<label for="state" class="control-label pull-right"><fmt:message key="common.colon"><fmt:param><fmt:message key="dictionary.state"/></fmt:param></fmt:message></label>';
			sOut += '</div>';
			sOut += '<div class="col-xs-5 col-xs-np">';
			if(json.state == 'DELETED'){
				sOut += '<label for="NORMAL" class="checkbox-inline"><input id="NORMAL" name="state"  type="radio" value="NORMAL" /><fmt:message key="dictionary.state.enabled"/></label>';
				sOut += '<label for="DELETED" class="checkbox-inline"><input id="DELETED" name="state" checked  type="radio" value="DELETED" /><fmt:message key="dictionary.state.disabled"/></label>';
			}else{
				sOut += '<label for="NORMAL" class="checkbox-inline"><input id="NORMAL" name="state" checked type="radio" value="NORMAL" /><fmt:message key="dictionary.state.enabled"/></label>';
				sOut += '<label for="DELETED" class="checkbox-inline"><input id="DELETED" name="state"   type="radio" value="DELETED" /><fmt:message key="dictionary.state.disabled"/></label>';
			}
			sOut += '</div>';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '</div>';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '<div class="col-xs-4 col-xs-np text-center">';
			sOut += '<button type="button" class="btn btn-primary mr20" onclick="modifyItem(\''+json.id+'\')"><fmt:message key="button.modify"/></button><button type="button" class="btn btn-default" onclick="resetDictionaryItem()"><fmt:message key="button.cancel"/></button>';
			sOut += '</div>';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '</div>';
			sOut += '</form>';
			sOut += '</div>';
		}
	});
	return sOut;
}

function addItem(){
	if($("#dictionary_add_item_form").validate().form()){
		$("#dictionary_add_item_form").ajaxSubmit({
			dataType : "json",
			data : {'categoryId' : categoryId},
			success : function(json){
				$('#myModal').modal('hide');
				open_popover_success( HTMLDecode(json.message));
				oTable.fnReloadAjax();
			}
		});
	}
}

function modifyItem(id){
	if($("#dictionary_modify_item_form").validate().form()){
		$("#dictionary_modify_item_form").ajaxSubmit({
			dataType : "json",
			data : {id : id},
			success : function(json){
				open_popover_success(HTMLDecode(json.message));
				oTable.fnReloadAjax();
				resetDictionaryItem();
			}
		});
	}
}

function resetDictionaryItem(){
	$(oTable.fnGetNodes()).each(function(index){
	    if(oTable.fnIsOpen(this)){
	    	oTable.fnClose(this); 
	    }
    });
	$("#dictionary_modify_item_form").resetForm();
}


function goBack() {
	location.href='${pageContext.request.contextPath}/dictionary/show/home.do';
}
</script>
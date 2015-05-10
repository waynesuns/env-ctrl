<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<script type="text/javascript">
var countS = 0;
var oTableLoad = 0;
var oTable;
$(document).ready(function() {
	$('#myModal').on('hide.bs.modal', function (e) {
		  // do something...
		$("#add_dictionary_form").resetForm();
		});
	var rules = {
			code : {
				required : true,
				maxlength : 16,
				digitalLetterOrUnderscore : true,
				 remote : {
					url: "<c:url value='/dictionary/show/code.do'/>",   //后台处理程序
				    type: "post",               //数据发送方式
				    dataType: "json",           //接受数据格式
				    async : false,
				    data: {                     //要传递的数据
				    	code: function() {
				            return $("#code").val(); 
				        }
				    }
				}, 
				digitalOrLetter : true
			},
			name : {
				required : true,
				maxlength : 30
			}
	};
	var messages = {
			code : {
				required : "编号不能为空",
				maxlength : "请输入一个长度最多是 {0} 的字符串",
				digitalLetterOrUnderscore : "只能是数字、字母和下划线组合",
					 remote : "该编号已存在" 
			},
			name : {
				required : "名称不能为空",
				maxlength : "请输入一个长度最多是 {0} 的字符串"
			}	
	};
	validationTooltipFormContentRight("add_dictionary_form", null, rules, messages);
	oTable = $("#dictionary_table").dataTable({
		"bInfo" : true, //页脚信息
		//"sDom" : 'TRCF<"clear">lrtip',
		"sDom" : 'TRCF<"clear">rtip',
		"sPaginationType" : "bootstrap",
		"bSort" : false,
		"sAjaxSource" : '<c:url value="/dictionary/show/list.do"/>',
		"sServerMethod" : "POST",
		//"bServerSide": true,
		//"bProcessing": true,
		"oLanguage" : <gh:dataTableLanguage/>,
		"aoColumns" : [ {
			"mDataProp" : "code"
		}, {
			"mDataProp" : "name"
		}, {
			"mDataProp" : "id"
		} ],
		"aoColumnDefs": [
			 	   			{ "bVisible": false, "aTargets": [2]}
			 	   		],
		"fnDrawCallback":function( oSettings ) {initTips(".detail");initTips(".update"); },
		"fnRowCallback" : function(nRow, aData, iDisplayIndex) {
			var nameTd = $( nRow ).children("td").eq(1);
				var img = $(nameTd).children("a");
				if(img.length>0)
					return;
				$(nameTd).append('<a class="detail pull-right cursor" style="margin-right:5px"  data-placement="bottom"  data-original-title="详情" onclick=""><i  class="fa fa-arrow-circle-right fa-lg " ></i></a>');
				$(nameTd).append('<a class="update pull-right cursor" style="margin-right:5px"  data-placement="bottom"  data-original-title="编辑" onclick=""><i  class="fa fa-edit fa-lg " ></i></a>');
				
				$(nameTd).find(".update").click(function(){
					nTr = $(this).parents('tr')[0];
					oTable.fnOpen(nTr,fnFormatDetails(oTable,nTr),'details');
					validationTooltipFormContentRight("dictionary_modify_form",null);
				});
				$(nameTd).find(".detail").click(function(){
					var nTr = $(this).parents('tr')[0];
					var aData = oTable.fnGetData(nTr);
					var params = '?id=' + encodeURIComponent(aData.id)
							   + '&code=' + encodeURIComponent(aData.code)
							   + '&name=' + encodeURIComponent(aData.name);
					location.href='${pageContext.request.contextPath}/dictionary/detail/show/home.do' + params;
				});
		}
	});
});

function addDictionary() {
	if ($("#add_dictionary_form").validate().form()) {
		$("#add_dictionary_form").ajaxSubmit({
			dataType : "json",
			success : function(json) {
				$('#myModal').modal('hide');
				open_popover_success( HTMLDecode(json.message));
				oTable.fnReloadAjax();
			}
		});
	}
}



function fnFormatDetails(oTable, nTr){
	reseatModifyDictionary();
	var aData = oTable.fnGetData( nTr );
	var sOut;
	$.ajax({
		url : '<c:url value="/dictionary/show/get.do"/>',
		type : 'post',
		dataType : 'json',
		data : 'id='+aData.id,
		async : false,
		success : function(json){
			sOut = '<div class="modify">';
			sOut += '<form action="<c:url value="/dictionary/modify_category.do" />" method="post" id="dictionary_modify_form">';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '<div class="col-xs-1 col-xs-np ml">';
			sOut += '<label for="name" class="control-label pull-right"><fmt:message key="common.colon"><fmt:param><fmt:message key="dictionary.name"/></fmt:param></fmt:message></label>';
			sOut += '</div>';
			sOut += '<div class="col-xs-5 col-xs-np">';
			sOut += '<input name="name" class="form-control input-sm required" value="'+json.name+'" id="name" type="text" maxlength="30" placeholder="<fmt:message key="dictionary.name"/>"/>';
			sOut += '</div>';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '</div>';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '<div class="col-xs-4 col-xs-np text-center">';
			sOut += '<button type="button" class="btn btn-primary mr20" onclick="modifyDictionary(\''+json.id+'\')"><fmt:message key="button.modify"/></button><button type="button" class="btn btn-default" onclick="reseatModifyDictionary()"><fmt:message key="button.cancel"/></button>';
			sOut += '</div>';
			sOut += '<div class="col-xs-3 col-xs-np"></div>';
			sOut += '</div>';
			
			sOut += '</form>';
			sOut += '</div>';
		}
	});
	return sOut;
}

function modifyDictionary(id){
	if($("#dictionary_modify_form").validate().form()){
		$("#dictionary_modify_form").ajaxSubmit({
			dataType : "json",
			data : {id : id},
			success : function(json){
				open_popover_success(HTMLDecode(json.message));
				oTable.fnReloadAjax();
				reseatModifyDictionary();
			}
		});
	}
}

function reseatModifyDictionary(){
	if($("#dictionary_modify_form").size() > 0)
		$("#dictionary_modify_form").resetForm();
	$(oTable.fnGetNodes()).each(function(index){
	    if(oTable.fnIsOpen(this)){
	    	oTable.fnClose(this); 
	    }
    });
}

</script>
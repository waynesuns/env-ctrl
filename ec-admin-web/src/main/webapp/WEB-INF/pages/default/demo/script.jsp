<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<!-- <script type="text/javascript" src="js/jquery/plugin/dataTables/ZeroClipboard.js"></script> -->
<!-- <script type="text/javascript" src="js/jquery/plugin/dataTables/TableTools.min.js"></script> -->
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

function dataTable(){
	oTable = $('#role_table').dataTable({
		"bInfo": true,		//页脚信息
		"bServerSide" : true,
		"bProcessing": true,
		"sDom" : 'TRCF<"clear">rtip',
		"bStateSave" : false,
		"bSortCellsTop" : false,
		"bSort" : false,
		"sPaginationType": "full_numbers",
		"sAjaxSource" : '<c:url value="/role/show/list.do"/>',
		"oLanguage" : <gh:dataTableLanguage/>,
		"iDisplayLength" : 20,
		"aoColumnDefs": [{ "bVisible": false, "aTargets": [4,5,6,7,8] }],
		"sServerMethod": "POST",
		/* "sScrollX": "100%",
		"sScrollXInner": "150%",
		"bScrollCollapse": true, */
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
			//$(nRow).children("td").eq(2).children("div").data("titles",HTMLDecode(aData.resourcesTitleStr));
			 var i = 0;
			var td = $(nRow).children().eq(3);
				var img = $(td).find(".option");
				if(img.length>0)
					return;
				$(td).append('<a class="option pull-right cursor " style="margin-right:10px"  data-placement="bottom"  data-original-title="删除" onclick=""><i  class="fa fa-times fa-lg" ></i></a>');
				$(td).append('<a class="option pull-right cursor" style="margin-right:10px"  data-placement="bottom"  data-original-title="编辑" onclick=""><i  class="fa fa-edit fa-lg " ></i></a>');
				
				
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
	/* new FixedColumns( oTable,{'iLeftColumns' : 1,
		'iLeftWidth' : '188'} ); */
}
$(document).ready(function() {
	getUser();
	dataTable();
	var rules={
			email:{required:true},
			password:{required:true}
	};
	var messages={
			email:{required:"请输入邮箱地址"},
			password:{required:"请输入密码"}
	};
	validationTooltipFormContent("addForm",null, "right", rules, messages);
	$('#reasch')
    .click(function () {
      var btn = $(this);
      btn.button('loading');
      oTable.fnReloadAjax();
      setTimeout(function () {
        btn.button('reset');
      }, 3000);
    });
	
	open_popover_error("错误提示框！");
	$('#date').datetimepicker({
		format:'yyyy-mm-dd',
		 language:  'zh-CN',
		 todayBtn:true,
        weekStart: 1,
		autoclose: true,
		todayHighlight: true,
		startView: 2,
		minView: 2,
		forceParse: true
    });
	$("#testtooltip").tooltip();
	 $('#myTab a').click(function (e) {
		  $(this).tab('show');
		});
} );// 初始化read结束
function saveRole(){
	if($("#addForm").validate().form()){
		open_popover_success("成功提示框！");
	}
}
</script>
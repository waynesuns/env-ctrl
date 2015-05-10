<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<script>
var nTr = "";
var oTable = "";
$(document).ready(function() { 
	dataTables();
});
function dataTables(){
	   oTable = $('#table1').dataTable( {
			"bInfo" : true,		
			"bServerSide" : true,
			"bProcessing": true,
			"sDom" : 'TRCF<"clear">rtip',
			"iDisplayLength" : 20,
			"bStateSave" : false,
			"bSortCellsTop" : false,
			"bSort" : false,
			"sPaginationType": "bootstrap",
			"aoColumnDefs": [{ "bVisible": false, "aTargets": [2,3,4] }],
			"sAjaxSource":'<c:url value="/announcement/show/file_list/new.do"/>',	 		
			"sServerMethod": "post",
			"aoColumns": [
							{ "mDataProp": "title","sWidth": "650","fnRender": function(data){
								var html = '<div class="cutLen650 l">';
								if(data.aData.status=="0")
									html = '<img style="float: left;" src="<c:url value="/images/New.png"/>" />'; 
								html += data.aData.title+'</div>';
								return html;
							}},
							{ "mDataProp": "fileName","sWidth": "120","fnRender": function(data){
								var html = '<div class="cutLen75 l">' + data.aData.fileName + '</div>'
								return html;
							}}, 
							{ "mDataProp": "announcementId"},
							{ "mDataProp": "attachmentId"},
							{ "mDataProp": "anconfId"} 
						],
			"oLanguage":<gh:dataTableLanguage/>,
			"fnRowCallback": function( nRow, aData, iDisplayIndex ){
				var td1 = $( nRow ).children("td").eq(0);
				var announcementId = aData.announcementId;
				var anconfId = aData.anconfId;
				$( td1 ).addClass("cursor");
				$( td1 ).click(function(){
					window.location.href= '<c:url value="/announcement/show/get_content/new.do?announcementId='+announcementId+'&anconfId='+anconfId+'"/>'; 
				});
				var td2 = $( nRow ).children("td").eq(1);
				var size = $( td2 ).find(".download").size();
				var attachmentId = aData.attachmentId;
				if(size < 1 && attachmentId != "")
					$(td2).append('<a class="download pull-right  cursor"  data-placement="bottom"  data-original-title="下载" ><i  class="fa fa-download fa-lg " ></i></a>');
				$(td2).find(".download").click(function(){
					window.location.href = '<c:url value="/announcement/download.do"/>?id='+announcementId;
				});
			},
			"fnDrawCallback":function( oSettings ) {
				initTips(".download");
			}
			})
};
</script>
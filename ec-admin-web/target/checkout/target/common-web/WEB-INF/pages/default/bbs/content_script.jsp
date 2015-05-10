<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%> 
<script>
$(document).ready(function() { 
	initTips(".download");
	initTips("#back");
	praseContent("${announcement.id }");
});
function downLoad(announcementId){
	window.location.href = '<c:url value="/announcement/download.do"/>?id='+announcementId;
}
function praseContent(id){
	$.ajax({
		url : '<c:url value="/announcement/show/get_content_html/new.do"/>',
		type : 'post',
		dataType : 'json',
		data : 'id='+id,
		async : false,
		success : function(json){
			var aData = json.aaData[0];
			var content = aData.content;
			$("#show_content").html(content);
		}
	});
}
</script>
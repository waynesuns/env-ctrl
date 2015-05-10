<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<script>
function fileUpload(){
	$("#file_upload_img").show();
	$("#upload_form").ajaxSubmit({
		dataType : "json",
		success : function(json){
			$("#file_list").append('<div id="div_file_'+json.id+'">'+json.fileName+'&nbsp;&nbsp;<a class="cursor" onclick="deleteFile(\''+json.id+'\')"><i  class="fa fa-times fa-lg " ></i></a></div>');
			$("#add_announcement").append('<input type="hidden" name="fileId" value="'+json.id+'" id="input_file_'+json.id+'"/>');
			$("#upload_form").hide();
			$("#file_upload_img").hide();
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			$("#file_upload_img").hide();
			if(XMLHttpRequest.status==400){
				open_tip("error", XMLHttpRequest.responseText);
				return;
			}else if(XMLHttpRequest.status==203){
				top.window.location="./login.do";
				return;
			}else if(XMLHttpRequest.status==500){
				$('<form action="./500.do?v=123" method="post"><input type="hidden" name="errorInfo" value="'+XMLHttpRequest.responseText+'"/></form>').submit();
				//open_tip("error", XMLHttpRequest.responseText, 3);
				//top.window.location="500";
				return;
			}else if(XMLHttpRequest.status==404){
				top.window.location="404.do";
				return;
			} else if(XMLHttpRequest.status==403){
				open_tip("error", error403);
				return;
			}
			open_tip("error", XMLHttpRequest.responseText);
    	} 
	});
}

function fileUploadModfiy(){
	$("#file_upload_img_modify").show();
	$("#upload_form_modify_2").ajaxSubmit({
		dataType : "json",
		success : function(json){
			$("#file_list_modfiy").append('<div id="div_file_'+json.id+'">'+json.fileName+'&nbsp;&nbsp;<a class="cursor" onclick="deleteFileModify(\''+json.id+'\')"><i  class="fa fa-times fa-lg " ></i></a></div>');
			$("#upload_form_modify").append('<input type="hidden" name="fileId" value="'+json.id+'" id="input_file_'+json.id+'"/>');
			$("#file_div").hide();
			$("#file_upload_img_modify").hide();
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			$("#file_upload_img_modify").hide();
			if(XMLHttpRequest.status==400){
				open_tip("error", XMLHttpRequest.responseText);
				return;
			}else if(XMLHttpRequest.status==203){
				top.window.location="./login.do";
				return;
			}else if(XMLHttpRequest.status==500){
				$('<form action="./500.do?v=123" method="post"><input type="hidden" name="errorInfo" value="'+XMLHttpRequest.responseText+'"/></form>').submit();
				//open_tip("error", XMLHttpRequest.responseText, 3);
				//top.window.location="500";
				return;
			}else if(XMLHttpRequest.status==404){
				top.window.location="404.do";
				return;
			} else if(XMLHttpRequest.status==403){
				open_tip("error", error403);
				return;
			}
			open_tip("error", XMLHttpRequest.responseText);
		}
	});
}

function deleteFile(id){
	$("#input_file_"+id).remove();
	$("#div_file_"+id).remove();
	$("#upload_form").show();
	$("#file_upload_img").hide();
}

function deleteFileModify(id){
	$("#input_file_"+id).remove();
	$("#div_file_"+id).remove();
	$("#file_div").show();
	$("#file_upload_img_modify").hide();
}
</script>
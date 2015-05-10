<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<script>
var nTr = "";  //打开或者关闭
var releasednTr = "";
var unreleasedTable = "";
var releasedTable = "";
var open = false;
var dataId = ""; 
var brandJson = ${brandJson };
var selectedMessage = '全部';
var optionHTMLStr = '<option value="">全部</option>'; 
var currentDealerCodeHiddens;
function showUnreleasedContent(oTable, nTr, sOut){
	var aData = oTable.fnGetData(nTr);
	var sOut = '<div id="message_'+aData.id+'" ><p class="g9">'+aData.content+'</p></div>';
	open = true;
	return sOut;
}
function showReleasedContent(oTable, nTr, sOut){
	var aData = oTable.fnGetData(nTr);
	var sOut = '<div id="message_'+aData.id+'" ><p class="g9">'+aData.content+'</p></div>';
	open = true;
	return sOut;
}
function unreleasedDataTable(){
	unreleasedTable = $('#bbsTable1').dataTable({
		"bPaginate" : false, // 禁用分页
		"bInfo": false,		//页脚信息
		"bServerSide" : false,
		"bSort" : false,
		"bStateSave" : false,
		"bSortCellsTop" : false,
		"iDisplayLength" : 20,
		"sDom" : 'rtip',
		"sAjaxSource" : '<c:url value="/announcement/show/under_released_list.do" />',
		"oLanguage" : <gh:dataTableLanguage/>,
		"aoColumnDefs": [{ "bVisible": false, "aTargets": [3,4,5] }],
		"sServerMethod": "POST",
		"aoColumns" : [
			{ "mData": null},
			{ "mData": "title" },
			{ "mData": "createTime","fnRender": function(data){
				var html = '<div class="l">' + data.aData.createTime + '</div>';
				return html;
			}},
			{ "mData": "id"},
			{ "mData": "content"},
			{ "mData": "existsFile"}
		],
		"fnDrawCallback":function(){
			initTips(".update");initTips(".download");
		},
		"fnInitComplete": function(oSettings, json) {
			$('#bbs').show();
		},
		"fnRowCallback": function( nRow, aData, iDisplayIndex ){
			$(nRow).children().eq(0).each(function(index, td){
				$(td).append("<input type='checkbox' name='announcementId' value='"+aData.id+"' />");
			});
			$(nRow).children().eq(1).addClass("cursor");
			var td = $(nRow).children().eq(1);
			$(td).click(function(){
				closeAddOrEdit();
				if(aData.content==""||aData.content==null)
					return;
				nTr = $(this).parents('tr')[0];
					unreleasedTable.fnOpen(nTr,showUnreleasedContent(unreleasedTable,nTr),'');
			});
			var td = $(nRow).children().eq(2);
			if(aData.existsFile == 'true'){
				 $(td).append('<a class="download pull-right  cursor"  data-placement="bottom"  data-original-title="下载" ><i  class="fa fa-download fa-lg " ></i></a>');
				$(td).find(".download").click(function(){
					window.location.href = '<c:url value="/announcement/download.do"/>?id='+aData.id;
				}); 
			}
			$(td).append('<a class="update pull-right  cursor" style="margin-right:10px"  data-placement="bottom"  data-original-title="编辑" onclick=""><i  class="fa fa-edit fa-lg " ></i></a>');
			$(td).find(".update").click(function(){
				closeAddOrEdit();
				currentDealerCodeHiddens = "dealerCodeEditHiddens";
				nTr = $(this).parents('tr')[0];
				unreleasedTable.fnOpen(nTr,fnFormatDetails(unreleasedTable,nTr),'details');
				charCountTextarea("modify_announcement_textarea");
				var aaData = unreleasedTable.fnGetData( nTr );
				initBrand("brand_edit"); 
				if(aaData.brandId!=""){
					$('#brand_edit').val(aaData.brandId);
					getDealerArea($('#brand_edit'),"edit");
				}
				if(aaData.dealerAreaId!=""){
					$('#dealerArea_edit').val(aaData.dealerAreaId); 
					getProvince($('#dealerArea_edit'),"edit");
				}
				if(aaData.province!="")
					$('#province_edit').val(aaData.province); 
				$('#category_edit').val(aData.category);$('#department_edit').val(aData.department);
				getDealer($('#dealerCode_edit'),aaData.dealerId);  
				initMultiselect("dealerCode_edit");
				validationTooltipFormContentRight("upload_form_modify",null);
			});
		} 
	});
	releasedDataTable();
}
/* 行细节格式化功能 */  
function fnFormatDetails ( oTable, nTr ){
	var aaData = oTable.fnGetData( nTr );
	var sOut = "";
	$.ajax({
		url : '<c:url value="/announcement/show/get_announcement.do"/>',
		type : 'post',
		dataType : 'json',
		data : 'id='+aaData.id,
		async : false,
		success : function(json){
			var aData = json.aaData[0]; 
			sOut += '<div class="modify" style="padding-left:30px;padding-bottom:10px"><form class="form-inline" id="upload_form_modify" action="<c:url value="/announcement/modify.do"/>" method="post">';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-12 col-xs-np">';
			sOut += '<label class="control-label ">';
			sOut += '<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.no"/></fmt:param></fmt:message><font color="red">*</font></label>';
			sOut += '<input readonly value="'+aData.serialNumber+'" class="form-control input-sm w195" name="" type="text" />';
			sOut += '</div>';
			sOut += '</div>';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-12 col-xs-np">';
			sOut += '<label class="control-label ">';
			sOut += '<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.type"/></fmt:param>';
			sOut += '</fmt:message><font color="red">*</font>';
			sOut += '</label>';
			sOut += '<dic:select name="categoryId" id="category_edit" styleClass="w200" selectValue="'+aData.category+'">';
			sOut += '<option value=""><fmt:message key="common.all"></fmt:message></option>';
			sOut += '<dic:option parentCode="10027"/>';
			sOut += '</dic:select>';
			sOut += '<label class="control-label ml">';
			sOut += '<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.publish.department"/></fmt:param></fmt:message>';
			sOut += '<font color="red">*</font>';
			sOut += '</label>';
			sOut += '<dic:select name="departmentId" id="department_edit" styleClass="w200" selectValue="'+aData.department+'">';
			sOut += '<option value=""><fmt:message key="common.all"></fmt:message></option>';
			sOut += '<dic:option parentCode="10028"/>';
			sOut += '</dic:select>';
			sOut += '</div>';
			sOut += '</div>';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-12 col-xs-np">';
			sOut += '<label class="control-label">';
			sOut += '<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.publish.target"/></fmt:param></fmt:message><font color="red">*</font></label>';
			sOut += '<label class="control-label"><fmt:message key="common.colon"><fmt:param><fmt:message key="common.brand"/></fmt:param></fmt:message></label>';
			sOut += '<select name="brand" id="brand_edit" onchange="getDealerArea(this,\'add\')">';
			sOut += '<option value=""><fmt:message key="common.all"></fmt:message></option>';
			sOut += '</select>';
			sOut += '<label class="control-label ml">';
			sOut += '<fmt:message key="common.colon"><fmt:param><fmt:message key="common.region"/></fmt:param></fmt:message>';
			sOut += '</label>';
			sOut += '<select name="dealerArea" id="dealerArea_edit" onchange="getProvince(this,\'add\')" style="width: 65px;">';
			sOut += '<option value=""><fmt:message key="common.all"></fmt:message></option>';
			sOut += '</select>';
			sOut += '<label class="control-label ml">';
			sOut += '<fmt:message key="common.colon"><fmt:param><fmt:message key="common.province"/></fmt:param></fmt:message>';
			sOut += '</label>';
			sOut += '<select name="province" id="province_edit" onchange="getDealerCatrgory(this)" style="width: 90px;">';
			sOut += '<option value=""><fmt:message key="common.all"></fmt:message></option>';
			sOut += '</select>';
			sOut += '<label class="control-label ml">';
			sOut += '<fmt:message key="common.colon">';
			sOut += '<fmt:param><fmt:message key="common.dealerCode"/></fmt:param>';
			sOut += '</fmt:message>';
			sOut += '</label>';
			sOut += '<select multiple="multiple" name="dealerCode" id="dealerCode_edit"></select>';
			sOut += '</div>';
			sOut += '</div>';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-12 col-xs-np">';
			sOut += '<label class="control-label ">';
			sOut += '<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.title"/></fmt:param>';
			sOut += '</fmt:message><font color="red">*</font>';
			sOut += '</label>';
			sOut += '<input class="form-control input-sm required" value="'+aData.title+'" style="width:436px" maxlength="100"  name="title" type="text" onkeypress="if(event.keyCode==13){return false;}" />';
			sOut += '</div></div>';
			sOut += '<div class="row">';
			sOut += '<div class="col-xs-12 col-xs-np">';
			sOut += '<label class="control-label ">';
			sOut += '<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.content"/></fmt:param>';
			sOut += '</fmt:message><font color="red">*</font>';
			sOut += '</label>';
			sOut += '<textarea id="modify_announcement_textarea" class="form-control required" maxlength="500" style="width:540px;height:120px;" name="content" cols="200" rows="3">';
				var content = aData.content;
				if(content != null) 
					sOut += content.replace(new RegExp("<br/>", "gm"), "\r\n"); 
			sOut += '</textarea>';
			sOut += '</div></div>';
			sOut += '<div class="row ">';
			sOut += '<div class="col-xs-12 col-xs-np ml20">';
			sOut += '<label class="control-label ">';
			sOut += '<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.linked.men"/></fmt:param>';
			sOut += '</fmt:message>';
			sOut += '</label>';
			sOut += '<input class="form-control input-sm w195 filterContactProson" name="contactPerson" maxlength="20" type="text" value="'+aData.contactPerson+'"/>';
			sOut += '<label class="control-label ml">';
			sOut += '<fmt:message key="common.colon"><fmt:param><fmt:message key="bbs.linked.phone"/></fmt:param></fmt:message>';
			sOut += '</label>';
			sOut += '<input class="form-control input-sm w195 validatePhone" name="contactPhone" maxlength="20" type="text" value="'+aData.contactPhone+'"/>';
			sOut += '</div></div>';
			sOut += '<input type="hidden" name="id" value="'+aData.id+'"/>';
			if(aData.existsFile == 'true')
				sOut += '<input type="hidden" id="input_file_'+aData.fileId+'" name="fileId" value="'+aData.fileId+'"/>';
			sOut += '<div id="dealerCodeEditHiddens"></div></form>';
			
			if(aData.existsFile == 'true'){
				sOut += '<div id="file_list_modfiy" class="cl mt10" style="padding-left:45px">';
				sOut += '<div id="div_file_'+aData.fileId+'">'+aData.fileName+'&nbsp;&nbsp;<a class="cursor" onclick="deleteFileModify(\''+aData.fileId+'\')"><i  class="fa fa-times fa-lg " ></i></a></div></div>';
				sOut += '</dd></dl>';
				sOut += '<div id="file_div" style="display:none">';
			}else{
				sOut += '<div id="file_list_modfiy" class="cl mt10" style="padding-left:45px"></div>';
				sOut += '</dd></dl>';
				sOut += '<div id="file_div">';
			}
			sOut += '<form id="upload_form_modify_2" action="<c:url value="/announcement/show/upload.do"/>" method="post" enctype="multipart/form-data">';
			// 如果是IE浏览器
			/* if ($.browser.msie && $.browser.version == "6.0"){
				sOut += '<input type="file" name="files" onchange="fileUploadModfiy()" style="margin-left:73px"/>';
			}else{ */
				sOut += '<div class="fileupload-buttonbar" style="height:20px;margin-top:10px">';
				sOut += '<div>';
				sOut += '<span class="btn btn-success fileinput-button" style="position:absolute;">';
				sOut += '<span class="glyphicon glyphicon-paperclip"></span>';
				sOut += '<span>&nbsp;<fmt:message key="common.file.add"/></span>';
				sOut += '<input type="file" name="files" onchange="fileUploadModfiy()">';
				sOut += '<span><img id="file_upload_img_modify" src="<c:url value="/images/loader.gif"/>" width="16px" height="16px" style="display:none"/></span>';
				sOut += '</span>';
				sOut += '</div>';
				sOut += '</div>';
			//}
			sOut += '</form>';
			sOut += '<div class="cl"></div>';
			sOut += '</div>';
			sOut += '<div class="row ">';
			sOut += '<div class="col-xs-12 col-xs-np text-center">';
			sOut += '<span style="height: 20px;width: 68px;display: none;" id="loaderImageEdit"><img class="mr20" src="<c:url value="/images/loader.gif" />" ></span>';
			sOut += '<button onclick="ajaxSubmitUpdate(\'upload_form_modify\',this)"  type="button" class="btn btn-primary mr20"><fmt:message key="bbs.button.update" /></button>';
			sOut += '<button onclick="closeAddOrEdit()"  type="button" class="btn btn-default"><fmt:message key="bbs.button.close" /></button>';
			sOut += '</div></div></div>';
		}});
	return sOut;
}
function getDealerCatrgory(thiz){
	if($(thiz).attr("id").indexOf("edit")>0)
		getDealer($('#dealerCode_edit'),null); 
	else
		getDealer($('#dealerCode'),null);
}
function getDealerArea(thiz,editStr){
	$(thiz).next().next().html(optionHTMLStr);
	$(thiz).next().next().next().next().html(optionHTMLStr);
	// 修改时,不填充网点,最后做统一填充 
	if(editStr!="edit")
		getDealer(thiz,null);
	if($(thiz).val()!=""){
		$.ajax({ 
			url : '<c:url value="/announcement/dealerArea_list.do" />',
			type : 'post',
			dataType : 'json',
			async : false,
			data : "brandId="+$(thiz).val(),
			success : function(json){ 
				for(var i=0; i<json.length; i++){
					$(thiz).next().next().append('<option value="'+json[i].id+'">'+json[i].name+'</option>');
				}
			}
		});
	}
}
function getProvince(thiz,editStr){ 
	$(thiz).next().next().html(optionHTMLStr);
	// 修改时,不填充网点,最后做统一填充 
	if(editStr!="edit")
		getDealer(thiz,null); 
	if($(thiz).val()!=""){
		$.ajax({
			url : '<c:url value="/announcement/province_list.do" />',
			type : 'post',
			dataType : 'json',
			async : false,
			data : "dealerAreaId="+$(thiz).val()+"&brandId="+$(thiz).prev().prev().val(), 
			success : function(json){
				for(var i=0; i<json.length; i++){
					$(thiz).next().next().append('<option value="'+json[i].code+'">'+json[i].name+'</option>');
				}
			}
		});
	}
}
function releasedDataTable(){
	releasedTable = $('#bbsTable2').dataTable({
		"bInfo": true,		//页脚信息
		"bServerSide" : false,
		"bStateSave" : false,
		"bSortCellsTop" : false,
		"bSort" : false,
		"iDisplayLength" : 20,
		"sPaginationType": "bootstrap",
		"sDom" : 'rtip',
		"sAjaxSource" : '<c:url value="/announcement/show/released_list.do" />',
		"aoColumnDefs": [{ "bVisible": false, "aTargets": [3,4,5] }],
		"oLanguage" : <gh:dataTableLanguage/>,
		"sServerMethod": "POST",
		"aoColumns" : [
			{ "mData": null},
			{ "mData": "title" },
			{ "mData": "releaseDate","fnRender": function(data){
				return '<span style="float:left;">'+data.aData.releaseDate+'</span>'; 
			}}, 
			{ "mData": "id"},
			{ "mData": "content"},
			{ "mData": "existsFile"}
		],
		"fnRowCallback": function( nRow, aData, iDisplayIndex ){
			var checkboxSize = $(nRow).children("td").eq(0).find("input[type='checkbox']").size();
			if(checkboxSize <= 0)
				$(nRow).children("td").eq(0).append("<input type='checkbox' name='announcementId' value='"+aData.id+"' />");
			$(nRow).children().eq(1).addClass("cursor");
			var td = $(nRow).children().eq(1);
			$(td).unbind();
			$(td).click(function(){
				releasedTable.fnClose(releasednTr);
				if(dataId!=aData.id)
				{
					dataId=aData.id;
					open=false;
				}
				if(aData.content==""||aData.content==null)
					return;
				releasednTr = $(this).parents('tr')[0];
				if(open)
					open=false;
				else
					releasedTable.fnOpen(releasednTr,showReleasedContent(releasedTable,releasednTr),'');
			});
			td = $(nRow).children().eq(2);
			if(aData.existsFile == 'true'){
				 $(td).append('<a class="download pull-right cursor" style="margin-right:5px"  data-placement="bottom"  data-original-title="下载" onclick=""><i  class="fa fa-download fa-lg " ></i></a>');
					$(td).find(".download").click(function(){
						window.location.href = '<c:url value="/announcement/download.do"/>?id='+aData.id;
					}); 
			}
		}, 
		"fnDrawCallback":function(){
			initTips(".download");
		}
	});
}
function charCountTextarea(id){
	$("#"+id).parent().children("span").remove();
	$("#"+id).charCount({
		allowed: 500, 
		warning: 20,
		counterElement: 'span',
		counterText: '<fmt:message key="common.colon"><fmt:param><fmt:message key="common.surplus.length"/></fmt:param></fmt:message>'
	});
}
$(document).ready(function() { 
	validationTooltipFormContentRight("add_announcement",null);
	charCountTextarea("add_announcement_textarea");
	unreleasedDataTable(); 
	initBrand("brand");  
	initMultiselect("dealerCode");
	$('#addbbs').on('hide.bs.modal', function (e) {
		  // do something...
		$("#add_announcement").resetForm();
		if($('#brand').val()!="")
			getDealer($('#dealerCode'),null); 
		resetUpload();
		var formId = $(this).find("form").attr("id");
		$("#"+ formId).resetForm();
		$('div[class="ui-multiselect-filter"]').find('input').val("");
		charCountTextarea("add_announcement_textarea");
		$("#upload_form").show();  
		});
});
function initBrand(id){
	var json = brandJson;
	for(var i=0; i<json.length; i++){
		$('#'+id).append('<option value="'+json[i].id+'">'+json[i].name+'</option>');
	}
}

/* 显示元素 */
function showElement(id) {
	
	closeAddOrEdit();
	$('#addbbs').modal("show");
	$("#upload_form").show();
	
	getDealer($('#dealerCode'),null); 
	currentDealerCodeHiddens = "dealerCodeAddHiddens";
	$('div[class="ui-multiselect-filter"]').find('input').val("");
}
//关闭ntr
function closeAddOrEdit(){
	var formSize = $("#update_form").size();
	if(formSize >= 1)
		$("#update_form").resetForm();
	unreleasedTable.fnClose(nTr);
	nTr = "";
} 
function ajaxSubmitUpdate(divId,thiz){
	validationTooltipFormContentRight(divId,null);
	if($("#"+divId).validate().form()){
		$('#loaderImageEdit').show();
		$(thiz).prop("disabled",true);  // 修改速度过慢，修改期间禁用添加按钮 
		$("#"+divId).ajaxSubmit({ dataType : 'json', success : function(json) {
		    $('#loaderImageEdit').hide();
		    $(thiz).prop("disabled",false);
		    closeAddOrEdit();
		    unreleasedTable.fnReloadAjax();
		    open_popover_success('<fmt:message key="bbs.success.update"></fmt:message>');
		}});
	}
}
function ajaxSubmitAdd(divId,thiz){
	validationTooltipFormContentRight(divId,null);
	if($("#"+divId).validate().form()){
		$('#loaderImage').show();
		$(thiz).prop("disabled",true);  // 添加速度过慢，添加期间禁用添加按钮 
		$("#"+divId).ajaxSubmit({ dataType : 'json', success : function(json) {
			$('#loaderImage').hide();
			$(thiz).prop("disabled",false);  // 添加速度过慢，添加期间禁用添加按钮 
			$("#addbbs").modal('hide');
			unreleasedTable.fnReloadAjax();
			open_popover_success('<fmt:message key="bbs.success.add"></fmt:message>');
		}});
	} 
}

function resetUpload(){
	$("input[name='files']").val("");
	$("input[name='fileId']").remove();
	$("#file_list").empty();
}

function deletebbs(formObj,state){  
	if($(formObj).find("[name=announcementId]").is(":checked")){ 
		 modal_confirm('<fmt:message key="bbs.delete.bbs.confirm" />?',function(){
			 closeAddOrEdit();
				$(formObj).attr("action","<c:url value='/announcement/remove.do'/>");
				$(formObj).ajaxSubmit({ 
					dataType : 'json', 
					success : function(json) {
						if(state == 0)
							unreleasedTable.fnReloadAjax();
						else if(state == 1)
							releasedTable.fnReloadAjax();
						$("#check_all").prop("checked",false);
						open_popover_success('<fmt:message key="bbs.delete.success" />');
					}
				});
		 });
	}else{
		open_popover_error('<fmt:message key="bbs.only" />');
	}
}
function releasebbs(){  
	 if($("#bbsTable1 [name=announcementId]").is(":checked")){ 
		 modal_confirm('<fmt:message key="bbs.release.bbs.confirm" />?',function(){
			 closeAddOrEdit();
				$("#announcement_form").attr("action","<c:url value='/announcement/release.do'/>");
				$("#announcement_form").ajaxSubmit({ 
					dataType : 'json', 
					success : function(json) {
					unreleasedTable.fnReloadAjax();
					releasedTable.fnReloadAjax();
					$("#check_all").prop("checked",false);
					open_popover_success('<fmt:message key="bbs.released.success" />');
					}
				});
		 });
	}else{ 
		open_popover_error('<fmt:message key="bbs.only" />');
	}
}
function selectOption(thiz,tableObj){
	if($(thiz).is(":checked")){
		$(tableObj).children('tbody').find('input:checkbox').prop("checked",true);
	}else{
		$(tableObj).children('tbody').find('input:checkbox').prop("checked",false);
	} 
}
// 查询网点编号，
function getDealer(thiz,dealerIds){
	var selects = $(thiz).parent().find('select');
	var brand = $(selects[0]).val(); 
	var dealerArea = $(selects[1]).val();  
	var province = $(selects[2]).val();  
	var currentSelect = selects[3];   
	$.ajax({
		url : '<c:url value="/announcement/dealer_list.do" />',
		type : 'post',
		dataType : 'json', 
		data : {brandId:brand,dealerAreaId:dealerArea,province:province }, 
		success : function(json){
			var html = ""; 
			var hiddenHtml = "";
			for(var i=0; i<json.length; i++){ 
				// 选择了省份才会填充网点到select
				if(json[i].code=="0")
					continue;
				if(province!=""){
					if(dealerIds!=""&&dealerIds!=null){
						if(dealerIds.indexOf(json[i].id)!=-1)
							html += '<option selected="selected" value="'+json[i].code+'">'+json[i].code+'</option>';
						else
							html += '<option value="'+json[i].code+'">'+json[i].code+'</option>';
					}else{
						html += '<option selected="selected" value="'+json[i].code+'">'+json[i].code+'</option>';
					}
				}else{
					hiddenHtml += '<input type="hidden" name="dealerCodeHidden" value="'+json[i].code+'">';
				}
			}  
			$('#'+currentDealerCodeHiddens).html(hiddenHtml);
			$(currentSelect).html(html);
			$(currentSelect).multiselect("refresh");    
		} 
	});
}
</script>
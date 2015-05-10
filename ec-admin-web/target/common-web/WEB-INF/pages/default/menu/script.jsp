<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<script>
var nTr = "";  //打开或者关闭
var oTable = "";
function dataTable(){
	oTable = $('#menu_list').dataTable({
		"bServerSide" : true,
		"bProcessing": true,
		"sDom" : 'TRCF<"clear">rtip',
		"bPaginate" : false, // 禁用分页
		"bInfo": false,		//页脚信息
		"bStateSave" : false,
		"bSort" : false,
		"sAjaxSource" : '<c:url value="/menu/show/list.do"/>',
		"aoColumnDefs": [ { "bVisible": false, "aTargets": [5,6,7,8,9] }],
		"oLanguage" : <gh:dataTableLanguage/>,
		"sServerMethod": "POST",
		"aoColumns" : [
			{ "mDataProp": "name"},
			{ "mDataProp": "code"},
			{ "mDataProp": "roles"},
			{ "mDataProp": "path"},
			{ "mDataProp": "state","fnRender": function(data){
				return HTMLDecode(data.aData.state);
			}},
			{ "mDataProp": "id"},
			{ "mDataProp": "className"},
			{ "mDataProp": "imgPath"},
			{ "mDataProp": "value"},
			{ "mDataProp": "parentId"}
		],
		"fnServerData": function ( sSource, aoData, fnCallback ) {
			$.ajax( {
				"dataType": 'json',
				"type": "post", 
				"url": sSource, 
				"data": aoData, 
				"success": fnCallback
			} );
		},
		"fnRowCallback": function( nRow, aData, iDisplayIndex ){
			$(nRow).removeClass();
			var roleTd = $( nRow ).children("td").eq(2);
			$(roleTd).html("<div id='roles_"+aData.id+"' title='' class='cutLen100'>" + aData.roles + "</div>");
			if(aData.className=='com.chinasshp.poms.biz.resource.MenuCategory')
			{
				$(nRow).addClass("bg_blue1");
				$(nRow).addClass("b");
				$(nRow).attr("id","category_"+aData.id);
				var td = $(nRow).children().eq(4);
				$(nRow).mouseover(function(){
					showImg($(nRow));
				});
				$(nRow).mouseout(function(){
					hideImg($(nRow));
				});
				var img = $(td).find("img[class='add']");
				if(img.length<=0)
				{
						$(td).append('<img style="display:none" align="right" class="add" src="images/add_menu2.png" title=\'<fmt:message key="qtip.message.add"/>\'>');
				}
				$(td).find("img[class='add']").click(function(){
					closeAddOrEdit();
					nTr = $(this).parents('tr')[0];
					hideElement('new_category');
					hideElement('new_menu');
					oTable.fnOpen(nTr,fnFormatDetailsAddMenu(oTable,nTr),'details');
					setSelected(null);
					initMultiselect("role_select");
				});
				img = $(td).find("img[class='edit']");
				if(img.length<=0)
				{
						$(td).append('<img class="edit" style="display:none" align="right" src="images/modify.png" title="<fmt:message key="qtip.message.modify"/>">');
				}
				$(td).find("img[class='edit']").click(function(){
					closeAddOrEdit();
					nTr = $(this).parents('tr')[0];
					hideElement('new_category');
					hideElement('new_menu');
					oTable.fnOpen(nTr,fnFormatDetailsCategory(oTable,nTr),'details');
					setSelected(HTMLDecode(aData.roles));
					initMultiselect("role_select");
				});
				return;
			}
			if(aData.className=='com.chinasshp.poms.biz.resource.Menu')
			{
				var text = $(nRow).children("td").eq(0).html();
				var parentId = aData.parentId;
				if(parentId == "" || parentId == null)
				{
					$(nRow).addClass("bg_blue1");
					$(nRow).addClass("b");
				}
				else
				{
					$(nRow).addClass("bg_blue2");
					if(text.indexOf("&nbsp;&nbsp;&nbsp;")==-1)
						$(nRow).children("td").eq(0).html("&nbsp;&nbsp;&nbsp;"+text);
				}
				$(nRow).attr("id","menu_"+aData.id);
				var td = $(nRow).children().eq(4);
				$(nRow).mouseover(function(){
					showImg($(nRow));
				});
				$(nRow).mouseout(function(){
					hideImg($(nRow));
				});
				var img = $(td).find("img[class='add']");
				if(img.length<=0)
				{
						$(td).append('<img style="display:none" align="right" class="add" src="images/add_menu2.png" title="<fmt:message key="qtip.message.add"/>">');
				}
				$(td).find("img[class='add']").click(function(){
					closeAddOrEdit();
					nTr = $(this).parents('tr')[0];
					hideElement('new_category');
					hideElement('new_menu');
					oTable.fnOpen(nTr,fnFormatDetailsAddButton(oTable,nTr),'details');
					setSelected(null);
					initMultiselect("role_select");
				});
				img = $(td).find("img[class='edit']");
				if(img.length<=0)
				{
						$(td).append('<img class="edit" style="display:none" align="right" src="images/modify.png" title="<fmt:message key="qtip.message.modify"/>">');
				}
				$(td).find("img[class='edit']").click(function(){
					closeAddOrEdit();
					nTr = $(this).parents('tr')[0];
					hideElement('new_category');
					hideElement('new_menu');
					oTable.fnOpen(nTr,fnFormatDetailsMenu(oTable,nTr),'details');
					setSelected(HTMLDecode(aData.roles));
					initMultiselect("role_select");
				});
				return;
			}
			if(aData.className=='com.chinasshp.poms.biz.resource.Button')
			{
				var text = $(nRow).children("td").eq(0).html();
				if(text.indexOf("&nbsp;&nbsp;&nbsp;")==-1)
					$(nRow).children("td").eq(0).html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+text);
				$(nRow).addClass("bg_blue3");
				$(nRow).attr("id","button_"+aData.id);
				var td = $(nRow).children().eq(4);
				$(nRow).mouseover(function(){
					showImg($(nRow));
				});
				$(nRow).mouseout(function(){
					hideImg($(nRow));
				});
				var img = $(td).find("img[class='edit']");
				if(img.length<=0)
				{
						$(td).append('<img class="edit" style="display:none" align="right" src="images/modify.png" title="<fmt:message key="qtip.message.modify"/>">');
				}
				$(td).find("img[class='edit']").click(function(){
					closeAddOrEdit();
					nTr = $(this).parents('tr')[0];
					hideElement('new_category');
					hideElement('new_menu');
					oTable.fnOpen(nTr,fnFormatDetailsButton(oTable,nTr),'details');
					setSelected(HTMLDecode(aData.roles));
					initMultiselect("role_select");
				});
				return;
			}
		},
		"fnDrawCallback":function( oSettings ) {
			$("img.edit,img.add").qtip({
				position: {
					at: "bottom center",
					my: "top center"
				},
				style: {
					border: "0px",
					classes: "ui-tooltip-green1",
					tip: true
				}
			});
			var list = $("div[id^='roles_']");
			for(var i = 0;i<list.length;i++){
				var id = $(list[i]).attr("id");
				$(list[i]).data("titles",$(list[i]).text());
				qtipImg(id);
			}
		}
	});
	getRole();
}
$(document).ready(function() {  
	validationFormByPositionRTBL("#menu_category_form",null);
	validationFormByPositionRTBL("#menu_form",null);
	dataTable();
});
/* 行细节格式化功能类别 修改类别*/
function fnFormatDetailsCategory(oTable, nTr, sOut) {
	var html = $("#role_list").html();
	var aaData = oTable.fnGetData(nTr); 
	var sOut = "";
	$.ajax({
		url : '<c:url value="/menu/show/get_category.do"/>',
		type : 'post',
		dataType : 'json',
		data : 'id='+aaData.id,
		async : false,
		success : function(json){
			var aData = json.aaData[0];
			var state = HTMLDecode(aData.state);
			sOut = '<form id="category_update_form" action="menu/modify/category.do" method="post"><div class="modify all">';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.category.name"/></fmt:param></fmt:message></dt><dd><input style="width:300px" maxlength="20" value="'+aData.name+'" class="required w195" name="name" type="text" onkeypress="if(event.keyCode==13){return false;}" /></dd></dl>';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="role.authorize"/></fmt:param></fmt:message></dt><dd><select name="roleId" id="role_select" style="width:300px" multiple="multiple"/>'+html+'</select></dd></dl>';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="common.img"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="50" style="width:300px" name="imgPath" type="text" value="'+aData.imgPath+'" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="state"/></fmt:param></fmt:message></dt><dd>';
			sOut += '<input id="state_modify_category_yes" name="stateStr" class="required" ';
			if(state == '<fmt:message key="state.enabled" />')
				sOut += 'checked="checked"';
			sOut += ' type="radio" value="0" /><label for="state_modify_category_yes"><fmt:message key="state.enabled" /></label><input name="stateStr" id="state_modify_category_no"';
			if(state == '<fmt:message key="state.disabled" />')
				sOut += 'checked="checked"';
			sOut += ' class="required" type="radio" value="1" /><label for="state_modify_category_no"><fmt:message key="state.disabled" /></label></dd></dl><dl><dd><input type="button" class="btn1 l" onclick="ajaxUpdateCategory(\'category_update_form\')" value="<fmt:message key="common.modify"/>" />';
			sOut += '<a class="btn5" onclick="closeAddOrEdit()"><fmt:message key="bbs.button.close"/></a></dd></dl><input type="hidden" name="categoryId" value="'+aData.id+'"/></div><form>';
	}});
	return sOut;
}
/* 行细节格式化功能菜单修改菜单 */
function fnFormatDetailsMenu(oTable, nTr, sOut) {
	var html = $("#role_list").html();
	var aaData = oTable.fnGetData(nTr); 
	var sOut = "";
	$.ajax({
		url : '<c:url value="/menu/show/get_menu.do"/>',
		type : 'post',
		dataType : 'json',
		data : 'id='+aaData.id,
		async : false,
		success : function(json){
			var aData = json.aaData[0];
			var state = HTMLDecode(aData.state);
			sOut = '<form id="menu_update_form" action="menu/modify/menu.do" method="post"><div class="modify all"  style="width:730px;">';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.name"/></fmt:param></fmt:message></dt><dd><input class="required w195" value="'+aData.name+'" maxlength="20" style="width:300px" name="name" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="role.authorize"/></fmt:param></fmt:message></dt><dd><select name="roleId"  style="width:300px" id="role_select" multiple="multiple"/>'+html+'</select></dd></dl>';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="common.img"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="50" style="width:300px" name="imgPath" type="text" value="'+aData.imgPath+'" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.path"/></fmt:param></fmt:message></dt><dd><input class="required w195" maxlength="50" value="'+aData.path+'" style="width:300px" name="path" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.url.expression"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="50" style="width:300px" name="value" type="text" value="'+aData.value+'" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="state"/></fmt:param></fmt:message></dt><dd>';
			sOut += '<input id="state_modify_menu_yes" name="stateStr" class="required" ';
			if(state == '<fmt:message key="state.enabled" />')
				sOut += 'checked="checked"';
			sOut += ' type="radio" value="0" /><label for="state_modify_menu_yes"><fmt:message key="state.enabled" /></label><input id="state_modify_menu_no" name="stateStr" ';
			if(state == '<fmt:message key="state.disabled" />')
				sOut += 'checked="checked"';
			sOut += ' class="required" type="radio" value="1" /><label for="state_modify_menu_no"><fmt:message key="state.disabled" /></label></dd></dl><dl><dd><input type="button" class="btn1 l" onclick="ajaxUpdateMenu(\'menu_update_form\')" value="<fmt:message key="common.modify"/>" />';
			sOut += '<a class="btn5" onclick="closeAddOrEdit()"><fmt:message key="bbs.button.close"/></a></dd></dl><input type="hidden" name="menuId" value="'+aData.id+'"/></div><form>';
	}});
	return sOut;
}
/* 行细节格式化功能按钮修改按钮 */
function fnFormatDetailsButton(oTable, nTr, sOut) {
	var html = $("#role_list").html();
	var aaData = oTable.fnGetData(nTr); 
	var sOut = "";
	$.ajax({
		url : '<c:url value="/menu/show/get_button.do"/>',
		type : 'post',
		dataType : 'json',
		data : 'id='+aaData.id,
		async : false,
		success : function(json){
			var aData = json.aaData[0];
			var state = HTMLDecode(aData.state);
			sOut = '<form id="button_update_form" action="menu/modify/button.do" method="post"><div class="modify all" style="width:730px;">';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.button.name"/></fmt:param></fmt:message></dt><dd><input class="required w195" maxlength="20" value="'+aData.name+'" style="width:300px" name="name" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="role.authorize"/></fmt:param></fmt:message></dt><dd><select name="roleId" id="role_select" style="width:300px" multiple="multiple"/>'+html+'</select></dd></dl>';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.path"/></fmt:param></fmt:message></dt><dd><input class="required w195" maxlength="50" value="'+aData.path+'" style="width:300px" name="path" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.url.expression"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="50" style="width:300px" name="value" type="text" value="'+aData.value+'" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="state"/></fmt:param></fmt:message></dt><dd>';
			sOut += '<input id="state_modify_button_yes" name="stateStr" class="required" ';
			if(state == '<fmt:message key="state.enabled" />')
				sOut += 'checked="checked"';
			sOut += ' type="radio" value="0" /><label for="state_modify_button_yes"><fmt:message key="state.enabled" /></label><input id="state_modify_button_no" name="stateStr" ';
			if(state == '<fmt:message key="state.disabled" />')
				sOut += 'checked="checked"';
			sOut += ' class="required" type="radio" value="1" /><label for="state_modify_button_no"><fmt:message key="state.disabled" /></label></dd></dl>';
			sOut += '<dl><dd><input type="button" class="btn1 l" onclick="ajaxUpdateButton(\'button_update_form\')" value="<fmt:message key="common.modify"/>" />';
			sOut += '<a class="btn5" onclick="closeAddOrEdit()"><fmt:message key="bbs.button.close"/></a></dd></dl><input type="hidden" name="buttonId" value="'+aData.id+'"/></div><form>';
	}});
	return sOut;
}
/* 行细节格式化功能按钮 添加按钮*/
function fnFormatDetailsAddButton(oTable, nTr, sOut) {
	var html = $("#role_list").html();
	var aData = oTable.fnGetData(nTr); 
	var sOut = '<form id="add_button_form" action="menu/add/button.do" method="post"><div class="modify" style="width:730px;">';
	sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.button.name"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="20" style="width:300px" name="name" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
	sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.code"/></fmt:param></fmt:message></dt><dd><input maxlength="10" class="required" style="width:300px" name="code" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
	sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="role.authorize"/></fmt:param></fmt:message></dt><dd><select name="roleId" id="role_select" style="width:300px" multiple="multiple"/>'+html+'</select></dd></dl>';
	sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.path"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="50"  style="width:300px" name="path" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
	sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.url.expression"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="50" style="width:300px" name="value" type="text" value="" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
	sOut += '<input name="menuId" value="'+aData.id+'" type="hidden"/>';
	sOut += '<dl><dd><input type="button" class="btn1 l" onclick="addButton(\'add_button_form\')" value="<fmt:message key="common.new"/>" />';
	sOut += '<a class="btn5" onclick="closeAddOrEdit()"><fmt:message key="bbs.button.close"/></a></dd></dl></div></form>';
	return sOut;
}
function fnFormatDetailsAddMenu(oTable, nTr, sOut) {
	var html = $("#role_list").html();
	var aData = oTable.fnGetData(nTr); 
	var sOut = '<form id="add_menu_form" action="menu/add/menu.do" method="post"><div class="modify" style="width:730px;">';
	sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.name"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="20" name="name" type="text" style="width:300px" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
	sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.code"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="10" name="code" type="text" style="width:300px" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
	sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="role.authorize"/></fmt:param></fmt:message></dt><dd><select name="roleId" id="role_select" style="width:300px" multiple="multiple"/>' + html + '</select></dd></dl>';
	sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="common.img"/></fmt:param></fmt:message></dt><dd><input class="required" style="width:300px" maxlength="50" name="imgPath" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
	sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.path"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="50" name="path" type="text" style="width:300px" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
	sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.url.expression"/></fmt:param></fmt:message></dt><dd><input class="required" style="width:300px" maxlength="50" name="value" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>';
	sOut += '<input name="categoryId" value="'+aData.id+'" type="hidden"/>';
	sOut += '<dl><dd><input type="button" class="btn1 l" onclick="addMenu(\'add_menu_form\')" value="<fmt:message key="common.new"/>" /><a class="btn5" onclick="closeAddOrEdit()"><fmt:message key="bbs.button.close"/></a>';
	sOut += '</dd></dl></div></form>';
	return sOut;
}
/* 显示元素  */
function showImg(thiz){
	$(thiz).find("img").show();
}
/* 隐藏元素 */
function hideImg(thiz){
	$(thiz).find("img").hide();
}
/* 显示元素 */
function showElement(id) {
	$("#" + id).show();
}
/* 隐藏元素  */
function hideElement(id) {
	var formId = $("#"+ id).parent("form").attr("id");
	$("#"+formId).validate().resetForm();
	$("#" + id).hide();
}
function showC() {
	closeAddOrEdit();
	$("#menu_form").validate().resetForm();
	$("#new_category").show();
	$("#new_menu").hide();
}
function showM() {
	closeAddOrEdit();
	$("#menu_category_form").validate().resetForm();
	$("#new_menu").show();
	$("#new_category").hide();
}
/* 添加按钮选项  */
function addOption(id) {
	$('#' + id).after('<li id="button_url"><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.code"/></fmt:param></fmt:message><input name="" type="text" onkeypress="if(event.keyCode==13){return false;}"/><span  class="ml13" style=" margin-right:23px">按钮:</span><input  name="" type="text" onkeypress="if(event.keyCode==13){return false;}"/><span class="ml13">访问地址：</span><input maxlength="50"  style="width:300px" name="" type="text" onkeypress="if(event.keyCode==13){return false;}"/><img src="images/minus_menu2.png" onclick="removeOption(\'button_url\')"  />');
}
function removeOption(id){
	$('#'+id).remove();
}
//关闭ntr
function closeAddOrEdit(){
	var formSize = $("#category_update_form").size();
	if(formSize >=1 )
		$("#category_update_form").validate().resetForm();
	formSize = $("#menu_update_form").size();
	if(formSize >=1 )
		$("#menu_update_form").validate().resetForm();
	formSize = $("#button_update_form").size();
	if(formSize >=1 )
		$("#button_update_form").validate().resetForm();
	formSize = $("#add_button_form").size();
	if(formSize >=1 )
		$("#add_button_form").validate().resetForm();
	formSize = $("#add_menu_form").size();
	if(formSize >=1 )
		$("#add_menu_form").validate().resetForm();
	oTable.fnClose(nTr);
	nTr = "";
}
//取得更新索引
function getIndex(divId){
	var td = $("#"+divId).parent().parent().prev("tr").children("td");
	nTr = $(td).parents('tr')[0];
	var index = oTable.fnGetPosition(nTr);
	return index;
}
function ajaxUpdateCategory(divId){
	submitFromTrim(divId);
	validationFormByPositionRTBL("#"+divId,null);
	var index = getIndex(divId);
	if($("#"+divId).validate().form()){
		$("#"+divId).ajaxSubmit({ dataType : 'json', success : function(json) {
			oTable.fnReloadAjax();
		    open_tip('message','<fmt:message key="menu.success.modify.category" />');
			closeAddOrEdit();
		} });
	}
}
function ajaxUpdateButton(divId){
	submitFromTrim(divId);
	validationFormByPositionRTBL("#"+divId,null);
	var index = getIndex(divId);
	if($("#"+divId).validate().form()){
		$("#"+divId).ajaxSubmit({ dataType : 'json', success : function(json) {
			oTable.fnReloadAjax();
			open_tip('message','<fmt:message key="menu.success.modify.button" />');
			closeAddOrEdit();
		} });
	}
}
function ajaxUpdateMenu(divId){
	submitFromTrim(divId);
	validationFormByPositionRTBL("#"+divId,null);
	var index = getIndex(divId);
	if($("#"+divId).validate().form()){
		$("#"+divId).ajaxSubmit({ dataType : 'json', success : function(json) {
			/* var data = json.aaData; */
		    /* oTable.fnUpdate({"name":data[0].name,"code":data[0].code,"roles":data[0].roles,"path":data[0].path,"id":data[0].id,"className":data[0].className,"state":data[0].state,"imgPath":data[0].imgPath,"value":data[0].value},index,0); */
		    oTable.fnReloadAjax();
			open_tip('message','<fmt:message key="menu.success.modify.menu" />');
			closeAddOrEdit();
		} });
	}
}
function addMenuOther(divId){
	submitFromTrim(divId);
	validationFormByPositionRTBL("#"+divId,null);
	var id = $("tbody").children(".bg_blue1").last().attr("id");
	if(id!=null&&id.indexOf('_')!=-1)
		id = id.substring(id.indexOf("_")+1,id.length);
	$("#"+divId).find("input[name='categoryId']").val(id);
	if($("#"+divId).validate().form()){
	$("#"+divId).ajaxSubmit({ dataType : 'json', success : function(json) {
		oTable.fnReloadAjax();
		$("#"+divId).validate().resetForm();
		open_tip('message','<fmt:message key="menu.success.add.menu" />');
		hideElement($("#"+divId).children("div").attr("id"));
	} });}
}
//菜单按钮Form提交
function addButton(divId){
	submitFromTrim(divId);
	validationFormByPositionRTBL("#"+divId,null);
	if($("#"+divId).validate().form()){
	$("#"+divId).ajaxSubmit({ dataType : 'json', success : function(json) {
		/* oTable.fnClearTable(); */
		oTable.fnReloadAjax();
	    open_tip('message','<fmt:message key="menu.success.add.button" />');
	    closeAddOrEdit();
	} });}
}
function addCategory(divId){
	submitFromTrim(divId);
	validationFormByPositionRTBL("#"+divId,null);
	var tr = $("tbody").children(".bg_blue1");
	var no = $(tr).length;
	$("#orderNumber").val(no);
	if($("#"+divId).validate().form()){
	$("#"+divId).ajaxSubmit({ dataType : 'json', success : function(json) {
		oTable.fnReloadAjax();
		$("#"+divId).validate().resetForm();
		open_tip('message','<fmt:message key="menu.success.add.category" />');
		hideElement($("#"+divId).children("div").attr("id"));
	} });}
}
function addMenu(divId){
	submitFromTrim(divId);
	validationFormByPositionRTBL("#"+divId,null);
	if($("#"+divId).validate().form()){
	$("#"+divId).ajaxSubmit({ dataType : 'json', success : function(json) {
		oTable.fnReloadAjax();
		$("#"+divId).validate().resetForm();
		open_tip('message','<fmt:message key="menu.success.add.menu" />');
	    closeAddOrEdit();
	} });}
}
function getRole(){
	$.ajax({
		url : '<c:url value="/menu/show/enabled_list.do" />',
		type : 'post',
		dataType : 'json',
		success : function(data) {
			var html = "";
			var json = data.aaData;
			for(var i = 0;i<json.length;i++)
				html += '<option value="'+json[i].id+'" >'+json[i].name+'</option>';
			$('#role_list').append(html);
			$("#role_list_other").append(html);
			initMultiselect("role_list_other");
		}	
	});
}
function setSelected(str){
	if(str==null||str=="")
		return;
	var array = "";
	if(str.indexOf("、")!=-1){
		array = str.split("、");
		var select = $("#role_select").find("option");
		for(var i = 0;i<select.length;i++){
			for(var j = 0;j<array.length;j++){
				var text = $(select[i]).text();
				if(text==array[j])
					$(select[i]).attr("selected","selected");
			}
		}
		return;
	}
	var select = $("#role_select").find("option");
	for(var i = 0;i<select.length;i++){
		var text = $(select[i]).text();
		if(text==HTMLDecode(str))
			$(select[i]).attr("selected","selected");
	}
}
function qtipImg(divId){
	$('#'+divId).qtip({
		position: {
			at: "bottom left",
			my: "top left"
		},
		style: {
			border: "0px",
			classes: "ui-tooltip-green1",
			tip: true
		},
		content:{
			text:function(api){
				return $(this).data("titles");
			}
		}
	});
}
</script>
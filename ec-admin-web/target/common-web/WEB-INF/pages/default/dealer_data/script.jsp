<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<script type="text/javascript">
var blockUIHtml = '<div class="blockUI"> <img width="25px" height="25px" src="images/loader.gif" class="mr10 mt5" /><fmt:message key="common.just.moment"/></div>';
var ntr;
var dataTable;
var queryData={
		"brandId":"",
		"dealerAreaId":"",
		"provinceId":"",
		"cityId":"",
		"dealerCode":"",
		"dealerName":"",
		"categoriesId":""
	};
$(document).ready(function(){
	getBrand("search");
	getCategory('categoriesId_search',null);
	//initDataTable();
	/* var rules = {
			productProviderId:{
				checkProvider : function(){ return $('#originId_add').val(); }
			},
			brandId : { 
				checkSelect : ""
			}
	};
	var messages={
			brandId:{
				checkSelect : "请选择" 
			}
		};
	vfByPositionRTBLAndRM("#tsForm",null,rules,messages); */
});

//初始化DataTable
function initDataTable(){
	dataTable = $('#dealer_table').dataTable({
		"bInfo": true,		//页脚信息
		"sDom" : 'TCF<"clear">rtip',
		"sPaginationType": "full_numbers",
		"iDisplayLength": 20,
		"bServerSide" : true,
		"bProcessing": true,
		"bStateSave" : false,
		"bSortCellsTop" : false,
		"bSort" : false,
		"sAjaxSource" : '<c:url value="/dealer_msater_data/show/list.do" />',
		"oLanguage" : <gh:dataTableLanguage/>,
		"sServerMethod": "POST",
		"aoColumnDefs": [{ "bVisible": false, "aTargets": [12] }],
		"aoColumns" : [
					{ "mDataProp": "dealerAreaName","sWidth":"50"},
					{ "mDataProp": "provinceName","sWidth":"50","fnRender": function(data){
						return '<div class="cutLen50" style="float:left;" id="provinceName_'+data.aData.id+'" title="'+data.aData.provinceName+'">'+data.aData.provinceName+'</div>'; 
					}},  
					{ "mDataProp": "cityName","sWidth":"50","fnRender": function(data){
						return '<div class="cutLen50" style="float:left;" id="cityName_'+data.aData.id+'" title="'+data.aData.cityName+'">'+data.aData.cityName+'</div>'; 
					}},  
					{ "mDataProp": "dealerCode","sWidth":"70"},
					{ "mDataProp": "name","sWidth":"70","fnRender": function(data){
						return '<div class="cutLen70" style="float:left;" id="dealerName_'+data.aData.id+'" title="'+data.aData.name+'">'+data.aData.name+'</div>'; 
					}},  
					{ "mDataProp": "zipCode","sWidth":"50"},
					{ "mDataProp": "deliveryPerson","sWidth":"60"},
					{ "mDataProp": "deliveryPhoneNo","sWidth":"60","fnRender": function(data){
						return '<div class="cutLen60" style="float:left;" id="deliveryPhoneNo_'+data.aData.id+'" title="'+data.aData.deliveryPhoneNo+'">'+data.aData.deliveryPhoneNo+'</div>'; 
					}}, 
					{ "mDataProp": "deliveryAddress","sWidth":"60","fnRender": function(data){
						return '<div class="cutLen50" style="float:left;" id="deliveryAddress_'+data.aData.id+'" title="'+data.aData.deliveryAddress+'">'+data.aData.deliveryAddress+'</div>'; 
					}}, 
					{ "mDataProp": "categories","sWidth":"65","fnRender": function(data){
						return '<div class="cutLen70" style="float:left;" id="categories_'+data.aData.id+'" title="'+data.aData.categories+'">'+data.aData.categories+'</div>'; 
					}}, 
					{ "mDataProp": "dealerManager","sWidth":"60"},
					{ "mDataProp": "dealerManagerPhoneNo","sWidth":"100","fnRender": function(data){
						return '<div class="cutLen60" style="float:left;" id="dealerManagerPhoneNo_'+data.aData.id+'" title="'+data.aData.dealerManagerPhoneNo+'">'+data.aData.dealerManagerPhoneNo+'</div>'; 
					}},  
		   			{ "mDataProp": "id"}
		 ],
		 "fnRowCallback": function( nRow, aData, iDisplayIndex ){
				 $(nRow).children().eq(11).each(function(index, td){
					 	if($(td).find('img').length>0)
					 		return;
					 	$(nRow).mouseover(function(){
							showImg($(nRow));
						});
						$(nRow).mouseout(function(){
							hideImg($(nRow));
						});
						$(td).append('<span class="" ><img class="edit cursor" align="right" title="<fmt:message key="common.modify"/>" id="modify_img_'+aData.id+'" style="display:none;" src="images/modify.png"></span>');
						$(td).find("img").eq(0).click(function(){
							closeDTableEdit();
							$('#addDiv').hide();
							ntr = $(this).parents('tr')[0];
							dataTable.fnOpen(ntr,fnFormatDetails2(dataTable,ntr),'details');
							getCityCustomer("cityId_modify",aData.provinceCode,aData.cityCode);
							initMultiselectCustom("categoriesId_modify");
							validationFormByPositionRTBL("#modify_form_id",null);
							$('#dealerManagerPhoneNo_modify').val($('#dealerManagerPhoneNo_'+aData.id).text());
							$("input[name=sendToSubDealer][value=" + aData.sendToSubDealer + "]").attr("checked","checked");
						});
					});
		 },
		 "fnServerParams" : function(aoData) {   
			 aoData.push(
					 { "name" : "brandId", "value" : queryData.brandId},
					 { "name" : "dealerAreaId", "value" : queryData.dealerAreaId},
					 { "name" : "provinceId", "value" : queryData.provinceId},
					 { "name" : "cityId", "value" : queryData.cityId},
					 { "name" : "dealerCode", "value" : queryData.dealerCode},
					 { "name" : "dealerName", "value" : queryData.dealerName},
					 { "name" : "categoriesId", "value" : queryData.categoriesId},
					 { "name" : "sendToSubDealer", "value" : queryData.sendToSubDealer}
			);  
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
		 "fnDrawCallback": function( oSettings ) {
			 closeBlockUI();
			 var ids = ["provinceName","cityName","dealerName","deliveryPhoneNo","deliveryAddress","categories","dealerManagerPhoneNo"];
			 for ( var i = 0; i < ids.length; i++) {
				 var list = $("div[id^='"+ids[i]+"_']");
				 for(var j=0;j<list.length;j++){
					 var id = $(list[j]).attr("id");
					 qtipImg(id);
				 }
			}
			 var list = $("img[id^='modify_img_']");
			 for(var j=0;j<list.length;j++){
				 var id = $(list[j]).attr("id");
				 qtipImg(id);
			 }
		 	$('#dealer_table').show();
		 }
	})
}
//关闭table编辑   
function closeDTableEdit(){
	dataTable.fnClose(ntr);
}
function fnFormatDetails2(oTable, ntr) {
	var aaData = oTable.fnGetData(ntr); 
	var categoryValues = aaData.categoriesValues;
	var sOut = '<div class="modify"><form method="post" id="modify_form_id" action="dealer_msater_data/modify.do" >';
	$.ajax({
		url : '<c:url value="/dealer_msater_data/show/product_category.do"/>',
		type : 'post',
		dataType : 'json',
		async : false,
		success : function(json){
			var html = "";
			for(var i=0;i<json.length;i++){
				if(categoryValues!=null&&categoryValues.indexOf(json[i].value)>-1)
					html += '<option value="'+json[i].value+'" selected="selected">'+json[i].message+'</option>';
				else
					html += '<option value="'+json[i].value+'">'+json[i].message+'</option>';
			}
			sOut +='<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="common.city" /></fmt:param></fmt:message></dt> <dd>';
			sOut +='<select id="cityId_modify" name="city" class="checkSelect" style="width: 180px;"></select>';
			sOut +='</dd></dl>';  
			sOut +='<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="dealer.property" /></fmt:param></fmt:message></dt> <dd>';
			sOut +='<select id="categoriesId_modify" name="categoriesId" multiple="multiple" style="width: 180px;">'+html+'</select>';
			sOut +='</dd></dl>'; 
			sOut +='<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="dealer.export.dealer.manager" /></fmt:param></fmt:message></dt> <dd>';
			sOut +='<input type="text" name="dealerManager"  maxlength="32" class="required" style="width: 170px;" id="dealerName_modify" value="'+aaData.dealerManager+'">';
			sOut +='</dd></dl>'; 
			sOut +='<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="dealer.export.dealer.manager.phone.no" /></fmt:param></fmt:message></dt> <dd>';
			sOut +='<input type="text" name="dealerManagerPhoneNo" maxlength="16" class="required" style="width: 170px;" id="dealerManagerPhoneNo_modify" value="">';
			sOut +='</dd></dl>'; 
			
			sOut += '<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="order.verify.config.sendto_subdealer" /></fmt:param></fmt:message></dt><dd>';
			sOut += '<input name="sendToSubDealer" type="radio" value="true" /><fmt:message key="order.verify.config.yes" />';
			sOut += '<input name="sendToSubDealer" type="radio" value="false" /><fmt:message key="order.verify.config.no" /> ';
			sOut += '</dd></dl>';
			
			sOut +='<dl><dt></dt><dd>';
			sOut +='<input class="btn1 l" onclick="modifySubmit(\'modify_form_id\')" type="button" value="<fmt:message key="common.modify"/>" />';
			sOut +='<div class="l pt5 cursor" onclick="closeDataTable()"><fmt:message key="bbs.button.close"/></div>';
			sOut +='</dd></dl>';
			sOut += '<input type="hidden" name="dealerId" value="'+aaData.id+'"/></form></div>';
		}
	});
	return sOut;  
}
// 查询
function searchTrans(){
	fillSearchItem();
	openBlockUI(blockUIHtml);
	reloadDataTable();
}
function reloadDataTable(){
	if(dataTable==null)
		initDataTable();
	else
		dataTable.fnReloadAjax();
}
function fillSearchItem(){
	 queryData.brandId = $('#brandId_search').val();
	 queryData.dealerAreaId = $('#dealerAreaId_search').val();
	 queryData.provinceId = $('#provinceId_search').val();
	 queryData.cityId = $('#cityId_search').val();
	 queryData.dealerCode = $('#dealerCode_search').val();
	 queryData.dealerName = $('#dealerName_search').val();
	 queryData.categoriesId = $('#categoriesId_search').val();
	 queryData.sendToSubDealer = $('#sendToSubDealer_search').val();
	 if(queryData.categoriesId==null)
		 queryData.categoriesId = "";
}
//修改
function modifySubmit(formId){
	var vali = $('#categoriesId_modify').next();
	if($('#categoriesId_modify').val()==null){ 
		/* $(vali).attr("title","请选择");
		qtipImg2(vali);   */
		showValidationQtipError(vali,"请选择");
	}	
	validationFormByPositionRTBL("#"+formId,null);
	if($("#"+formId).validate().form()&&$('#categoriesId_modify').val()!=null){
		$(vali).qtip('destroy');
		$("#"+formId).ajaxSubmit({ 
			dataType : 'json', 
			success : function(json){
				closeDTableEdit();
				searchTrans();
				if(json.status == "success")
					open_tip('message',json.message);
		} });  
	}
}
//添加 
function addSubmit(formId){
	validationFormByPositionRTBL("#"+formId,null);
	if($("#"+formId).validate().form()){
		$("#"+formId).ajaxSubmit({ 
			dataType : 'json', 
			success : function(json){
				dataTable.fnReloadAjax();  
				$('#addDiv').hide();
				if(json.status == "success")
					open_tip('message',json.message);
		} });  
	}		
}
function closeDataTable(){
	$('#modify_form_id').validate().resetForm();
	closeDTableEdit();
}
//显示图片
function showImg(thiz){	
	$(thiz).find('img').show();
}
//隐藏图片
function hideImg(thiz){
	$(thiz).find('img').hide();
}
function qtipImg(divId){
	$('#'+divId).qtip({
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
}
function qtipImg2(thiz){
	$(thiz).qtip({
		show : {
			ready : true
		},
		position: {
			at: "right top",
			my: "left bottom"
		},
		hide : {
			inactive:3000
		},
		style : {
			classes : 'ui-tooltip-red'
		}
	});
}
function hideElement(id){
	$('#tsForm').validate().resetForm();
	var vali = $('#dealerCode_add').next();
	$(vali).removeAttr("title");
	$(vali).qtip('destroy');
	//$("#transportModeId_add").removeData("previousValue");
	$("#"+id).hide();
}
function selectOption(thiz,tableObj){
	if($(thiz).is(":checked")){
		$(tableObj).children('tbody').find('input:checkbox').attr("checked","checked");
	}else{
		$(tableObj).children('tbody').find('input:checkbox').removeAttr("checked");
	} 
}
////////////////////////////////////////////////////////////////////////////////////////
//获取服务站属性 
function getCategory(id,categoryValues){
	$.ajax({
		url : '<c:url value="/dealer_msater_data/show/product_category.do"/>',
		type : 'post',
		dataType : 'json',
		success : function(json){
			var html = "";
			for(var i=0;i<json.length;i++){
				if(categoryValues!=null&&categoryValues.indexOf(json[i].value)>-1)
					html += '<option value="'+json[i].value+'" selected="selected">'+json[i].message+'</option>';
				else
					html += '<option value="'+json[i].value+'">'+json[i].message+'</option>';
			}
			$('#'+id).html(html);
			initMultiselectCustom(id);
		}
	});
}
function getCityCustomer(id,provinceCode,cityCode){ 
	$.ajax({
		url : cityURL,
		type : 'post',
		dataType : 'json',
		data : 'code='+provinceCode,
		success : function(json){
			var html = optionPleaseSelectHTML;
			for(var i=0;i<json.length;i++){
				if(json[i].code==cityCode)
					html += '<option value="'+json[i].code+'" selected="selected">'+json[i].name+'</option>';
				else
					html += '<option value="'+json[i].code+'">'+json[i].name+'</option>';
			}
			$('#'+id).html(html);
		}
	});
}
	//导入
	function importFile(thiz){
		$('#uploadForm').ajaxSubmit({
			beforeSubmit : function() { 
				$("#loader").show();      
			},
			dataType : 'json',
			success : function(data) {
				$('#loader').hide();
				if(data.status=="error"){
					var htmlError="<ul class='importer_ul'>";
					for(var i in data.message){
						htmlError+="<li>"+data.message[i]+"</li>";
					}
					htmlError+="</ul>";
					qtipModalError('<fmt:message key="dealer.imp.failed.title"/>：',htmlError);
					$("#loader").hide();
				}
				if(data.status=="success"){
					open_tip('message','<fmt:message key="dealer.imp.success.title"/>');
				}
				reloadDataTable();
			},
			error : function(data){
				$("#loader").hide();
				open_tip('error', data.responseText);
			}
		});
	}

	//导出
	function exportFile() {
		fillSearchItem();
		var params = [];
		params.push(
				 { "name" : "brandId", "value" : queryData.brandId},
				 { "name" : "dealerAreaId", "value" : queryData.dealerAreaId},
				 { "name" : "provinceId", "value" : queryData.provinceId},
				 { "name" : "cityId", "value" : queryData.cityId},
				 { "name" : "dealerCode", "value" : queryData.dealerCode},
				 { "name" : "dealerName", "value" : queryData.dealerName},
				 { "name" : "categoriesId", "value" : queryData.categoriesId},
				 { "name" : "sendToSubDealer", "value" : queryData.sendToSubDealer}
		);
		for (var index in params) {
			$('#exportForm input[name="' + params[index].name + '"]').val(params[index].value);
		}
		$('#exportForm').formSerialize();
	    $('#exportForm').submit(); 
	}
function initMultiselectCustom(id) {
	$("#" + id).multiselect({
		noneSelectedText : selectedMessage,
		checkAllText : checkAllText,
		uncheckAllText : unCheckAllText,
		selectedText : "# " + selectedText,
		selectedList : 3,
		height : 100
	})
}
</script>
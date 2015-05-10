/**
 * cityCasc.js
 * 
 * 品牌、大区、省份、城市、网点、级联 
 * 品牌前缀 'brandId_' 后缀自定义
 * 大区前缀 'dealerAreaId_' 后缀 自定义
 * 省份前缀 'provinceId_' 后缀 自定义
 * 城市前缀 'cityId_' 后缀 自定义
 * 
 * @author 孙成
 * @version 0.1
 */

/**
 * 当前的表头信息
 */
var currentOptionTitle;
/**
 * 根据后缀获取下拉框表头内容
 */
function getOptionTitle(suffix){
	return suffix == "search" ? optionAllHTML : optionPleaseSelectHTML;
}
/**
 * 获取品牌
 */
function getBrand(suffix){
	currentOptionTitle = getOptionTitle(suffix);
	$.ajax({
		url : brandURL,
		type : 'post',
		dataType : 'json',
		success : function(json){
			var html = currentOptionTitle;
			for(var i=0;i<json.length;i++){
				html += '<option value="'+json[i].id+'" >'+json[i].name+'</option>';
			}
			$('#brandId_'+suffix).html(html);
		}
	});
}
/**
 * 获取大区
 */
function getDealerArea(suffix){ 
	currentOptionTitle = getOptionTitle(suffix);
	$("#provinceId_"+suffix).html(currentOptionTitle);
	$("#cityId_"+suffix).html(currentOptionTitle);
	$('#dealerAreaId_'+suffix).html(currentOptionTitle);
	clearDealerCode(suffix);
	if($("#brandId_"+suffix).val()!="0"){
		$.ajax({
			url : dealerAreaURL,
			type : 'post',
			dataType : 'json',
			data : 'brandId='+$("#brandId_"+suffix).val(),
			success : function(json){
				var html = currentOptionTitle;
				for(var i=0;i<json.length;i++){
					html += '<option value="'+json[i].id+'">'+json[i].name+'</option>';
				}
				$('#dealerAreaId_'+suffix).html(html);
			}
		});
	}
}
/**
 * 获取省份
 */
function getProvince(suffix){ 
	currentOptionTitle = getOptionTitle(suffix);
	$("#cityId_"+suffix).html(currentOptionTitle);
	$('#provinceId_'+suffix).html(currentOptionTitle);
	clearDealerCode(suffix);
	if($("#dealerAreaId_"+suffix).val()!="0"){
		$.ajax({
			url : provinceURL,
			type : 'post',
			dataType : 'json',
			data : 'dealerAreaId='+$("#dealerAreaId_"+suffix).val(),
			success : function(json){
				var html = currentOptionTitle;
				for(var i=0;i<json.length;i++){
					html += '<option value="'+json[i].code+'">'+json[i].name+'</option>';
				}
				$('#provinceId_'+suffix).html(html);
				$("#cityId_"+suffix).html(currentOptionTitle);
			}
		});
	}
}
/**
 * 获取城市
 */
function getCity(suffix){ 
	currentOptionTitle = getOptionTitle(suffix);
	$('#cityId_'+suffix).html(currentOptionTitle);
	clearDealerCode(suffix);
	if($("#provinceId_"+suffix).val()!="0"){
		$.ajax({
			url : cityURL,
			type : 'post',
			dataType : 'json',
			data : 'code='+$("#provinceId_"+suffix).val(),
			success : function(json){
				var html = currentOptionTitle;
				for(var i=0;i<json.length;i++){
					html += '<option value="'+json[i].code+'">'+json[i].name+'</option>';
				}
				$('#cityId_'+suffix).html(html);
			}
		});
	}
}
//清空dealerCode 
function clearDealerCode(suffix){
	if($('#dealerCode_'+suffix).html()!=null&&$('#dealerCode_'+suffix).html()!="")
		$('#dealerCode_'+suffix).html(optionAllHTML); 
	/*$('#dealerCode_'+suffix).multiselect("refresh");*/  
}
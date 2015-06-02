<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<script type="text/javascript" src="${path}js/jquery.cityselect.js"></script>
<div class="title">预约TECH-CHEK<sup>TM</sup>空气质量检测服务</div>
<div id="orderInfoDiv">
<div>
	<div class="row" style="padding-top: 30px;margin-left:0px;margin-right: 0px;">客户信息：<hr/></div>
	<div class="row" style="padding-top: 0;margin-left:0px;margin-right: 0px;">
		<div style="width: 120px;float: left;">姓名*</div>
		<div style="overflow: hidden;" data-toggle="tooltip" data-placement="left" title="请填写姓名" id="nameDiv" class="tooltipDiv"><input type="text" name="name" id="name" class="form-control" style="width: 200px;" maxlength="20"></div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 120px;float: left;">手机号码*</div>
		<div style="overflow: hidden;" data-toggle="tooltip" data-placement="left" title="请填写手机号码"id="mobileDiv" class="tooltipDiv"><input type="text" name="mobile" id="mobile"  class="form-control" style="width: 200px;" maxlength="11"></div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 120px;float: left;">地址*</div>
		<div style="overflow: hidden;" id="cityDiv">
			<select class="prov" class="form-control" id="province"></select>
			<select class="city" class="form-control" id="city"></select>
		</div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 120px;float: left;">&nbsp;</div>
		<div style="overflow: hidden;" data-toggle="tooltip" data-placement="left" title="请填写详细地址" id="addressDiv" class="tooltipDiv"><input type="text" name="address" id="address" class="form-control" style="width: 100%;margin-right: 0;padding-right: 0;" placeholder="详细地址" maxlength="100"></div>
	</div>
	<div class="row" style="padding-top: 30px;margin-left:0px;margin-right: 0px;">建筑物信息：<hr/></div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 160px;float: left;"><span style="vertical-align: middle;line-height: 34px;">建筑物面积</span></div>
		<div style="overflow: hidden;float: left;margin-left: 5px;" data-toggle="tooltip" data-placement="left" title="请正确填写建筑物面积，最大为9999平方米" id="Q1Div" class="tooltipDiv"><input type="text" id="Q1" style="width: 100px;" value="" class="form-control" maxlength="100"></div>
		<div style="float: left;padding-left: 20px;"><span style="vertical-align: middle;line-height: 34px;">平方米</span></div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 160px;float: left;"><span style="vertical-align: middle;line-height: 34px;">层高</span></div>
		<div style="overflow: hidden;float: left;margin-left: 5px;" data-toggle="tooltip" data-placement="left" title="请正确填写层高，最高为10米" id="Q2Div" class="tooltipDiv"><input type="text" id="Q2" style="width: 100px;" value="" class="form-control" maxlength="100"></div>
		<div style="float: left;padding-left: 20px;"><span style="vertical-align: middle;line-height: 34px;">米</span></div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 160px;float: left;"><span style="vertical-align: middle;line-height: 34px;">房间数</span></div>
		<div style="overflow: hidden;float: left;margin-left: 5px;" data-toggle="tooltip" data-placement="left" title="请正确填写房间数，最大为99间" id="Q3Div" class="tooltipDiv"><input type="text"  id="Q3" style="width: 100px;" value="" class="form-control" maxlength="100"></div>
		<div style="float: left;padding-left: 20px;"><span style="vertical-align: middle;line-height: 34px;">间</span></div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 160px;float: left;"><span>建筑物特征<span></div>
		<div style="float: left;overflow: hidden;">
			<input type="checkbox" name="Q4" style="margin-right: 5px;margin-left: 5px;" value="1">新装修
			<input type="checkbox" name="Q4" style="margin-left: 10px;margin-right: 5px;" value="2">带车库
			<input type="checkbox" name="Q4" style="margin-left: 10px;margin-right: 5px;" value="3">室内养宠物
		</div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 160px;float: left;"><span>居住人特征<span></div>
		<div style="float: left;overflow: hidden;">
			<input type="checkbox" name="Q5" style="margin-right: 5px;margin-left: 5px;" value="1">老人
			<input type="checkbox" name="Q5" style="margin-left: 10px;margin-right: 5px;" value="2">婴幼儿
			<input type="checkbox" name="Q5" style="margin-left: 10px;margin-right: 5px;" value="3">孕妇
			<input type="checkbox" name="Q5" style="margin-left: 10px;margin-right: 5px;" value="4">过敏体质
		</div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 160px;float: left;"><span>最担心的空气质量问题?<span></div>
		<div style="float: left;overflow: hidden;">
			<input type="checkbox" name="Q6" style="margin-right: 5px;margin-left: 5px;" value="1">甲醛
			<input type="checkbox" name="Q6" style="margin-left: 10px;margin-right: 5px;" value="2">TVOC
			<input type="checkbox" name="Q6" style="margin-left: 10px;margin-right: 5px;" value="3">异味
			<input type="checkbox" name="Q6" style="margin-left: 10px;margin-right: 5px;" value="4">PM2.5
			<input type="checkbox" name="Q6" style="margin-left: 10px;margin-right: 5px;" value="5">其它
		</div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 160px;float: left;"><span>是否已有新风系统?<span></div>
		<div style="float: left;overflow: hidden;">
			<input type="radio" name="Q7" style="margin-right: 5px;margin-left: 5px;" checked="checked"  value="0">无
			<input type="radio" name="Q7" style="margin-left: 40px;margin-right: 5px;" value="1">有
		</div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 160px;float: left;"><span>是否已有空气净化设备?<span></div>
		<div style="float: left;overflow: hidden;">
			<input type="radio" name="Q8" style="margin-right: 5px;margin-left: 5px;" checked="checked" value="0">无
			<input type="radio" name="Q8" style="margin-left: 40px;margin-right: 5px;" value="1">有
		</div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 160px;float: left;"><span>是否需要提供试用机?<span></div>
		<div style="float: left;overflow: hidden;">
			<input type="radio" name="Q9" style="margin-right: 5px;margin-left: 5px;" value="1">是
			<input type="radio" name="Q9" style="margin-left: 40px;margin-right: 5px;" value="0">否
		</div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">周边环境</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<textarea id="Q10" rows="6" cols="" style="width: 100%"  class="form-control" placeholder="如果您对空气净化有指定需求，如去除甲醛、宠物异味或您的环境周边有化工企业或大型市政设施（机场、立交、隧道、污水泵站、地下停车场……）等，请在这里说明。"></textarea>
	</div>
	
</div>
<div class="row" style="padding-top: 48px;margin-left:0px;margin-right: 15px;" id="orderDescDiv">
	<div class="info ">服务说明：</div>
	<hr/>
	<div>1、目前仅开放北京、上海以及沈阳地区的空气质量检测服务；</div>
	<div>2、本检测服务为免费，不向客户收取任何费用；</div>
	<div>3、在线预约后，本公司会根据排期提前和客户电话确认上门检测时间；</div>
	<div>4、如有任何疑问，欢迎拨打艾易西服务热线4008-725-000，我们将竭诚为您服务。</div>
</div>
<div class="row" style="padding-top: 24px;margin-left:0px;margin-right: 15px;" id="orderDescDiv">
	<div class="info ">免责声明：</div>
	<hr/>
	<div>声明：本检测服务之检测结果仅供参考用途，且仅适用于检测过程中所涉及的房间及空间，不得作为证明第三方造
成本服务中客户损害之证据。本检测服务之信息不含有任何明确或暗示性形式的保证，不含有包括但不限于针对特
定用途的适用性的暗示保证，用户应自行承担对检测结果的准确性和使用的全部风险。检测结果包含的信息以及
IIECC公司针对相关问题的观点和评价的适用性仅在检测结果出具之日有效。</div>
</div>
<div class="row" style="padding-top: 24px;margin-left:0px;margin-right: 15px;" id="orderDescDiv">
	<div class="info "><input type="checkbox" checked="checked" style="margin-right: 5px;" name="contractCofirm" >我已仔细阅读服务说明及免责说明<span data-toggle="tooltip" data-placement="right" title="请仔细阅读服务说明及免责说明" id="contractCofirmDiv" class="tooltipDiv"></span></div>
</div>


<div class="row" style="margin-left:0px;margin-right: 0px;">
	<button onclick="submitOrder();" style="margin-top:15px;float: right;width: 100px;" class="btn btn-danger">提交预约</button>
</div>
</div>
<div class="row" style="padding-top: 12px;display: none;" id="submitResultDiv">
	<h4 style="text-align: center;">您的预约已成功提交！</h4>
	<p style="text-align: center;">我们的客服人员会尽快通过电话和您确认并安排上门检测时间，感谢您的预约！</p>
</div>
<script type="text/javascript">
$("#cityDiv").citySelect({
	url:{"citylist":[
		{"p":"北京","c":[{"n":"北京市"}]},
		{"p":"上海","c":[{"n":"上海市"}]},
		{"p":"辽宁","c":[{"n":"沈阳市"}]},
	]},
	prov:"北京",
	city:"北京市",
	dist:"",
	nodata:"none"
});


function submitOrder(){
	var name = $("#name").val();
	var mobile = $("#mobile").val();
	var address = $("#address").val();
	
	var Q1 = $("#Q1").val();
	var Q2 = $("#Q2").val();
	var Q3 = $("#Q3").val();

	
	var contractCofirm = $("input[name='contractCofirm']:checked").val(); 
	
	var errorInfo = new Array();
	$(".tooltipDiv").tooltip('hide');
	if(name==null || name.length==0){
		errorInfo.push("#nameDiv");
	}
	if(mobile==null || mobile.length!=11){
		errorInfo.push("#mobileDiv");
	}
	if(address==null || address.length==0){
		errorInfo.push("#addressDiv");
	}
	if(Q1!=null && Q1.length>0 && (isUnsignedInteger(Q1) || Q1==0 || Q1> 9999)){
		errorInfo.push("#Q1Div");
	}
	if(Q2!=null && Q2.length>0 && (isUnsignedNumeric(Q2) || Q2==0 || Q2> 10)){
		errorInfo.push("#Q2Div");
	}
	if(Q3!=null && Q3.length>0 && (isUnsignedInteger(Q3) || Q3==0 || Q3> 99)){
		errorInfo.push("#Q3Div");
	}
	if(contractCofirm==null){
		$("#contractCofirmDiv").tooltip('show');
	}
	if(errorInfo.length>0){
		var t_a = $("#name").offset();      
	    $("html,body").animate({scrollTop:t_a.top - "90" + "px"}, 500);
    	setTimeout(function(){
    	    for(ei in errorInfo){
    			$(errorInfo[ei]).tooltip('show');
    	    }
        },1000);
	    	 
		//$("#errorMsg").text(errorInfo.join(","));
		//$("#errorMsgDiv").show();
		return;
	}
	

	var province = $("#province").val();
	var city = $("#city").val();
	var Q4 = jQuery('input[type="checkbox"][name="Q4"]:checked').val();
	var Q5 = jQuery('input[type="checkbox"][name="Q5"]:checked').val();
	var Q6 = jQuery('input[type="checkbox"][name="Q6"]:checked').val();
	var Q7 = jQuery('input[type="radio"][name="Q7"]:checked').val();
	var Q8 = jQuery('input[type="radio"][name="Q8"]:checked').val();
	var Q9 = jQuery('input[type="radio"][name="Q9"]:checked').val();
	var Q10 = jQuery('#Q10').val();
	$.ajax({
	  method: "POST",
	  dataType: 'json',
	  url: "/admin/service_order/order_submit.do",
	  data: { name: name, telNo: mobile, address:address,province:province,city:city,Q1:Q1,Q2:Q2,Q3:Q3,Q4:Q4,Q5:Q5,Q6:Q6,Q7:Q7,Q8:Q8,Q9:Q9,Q10:Q10}, 
	  error: function(XMLHttpRequest, textStatus, errorThrown) {
		  showSubmitResult();
	  } ,
	  success: function(){
		  showSubmitResult();
      }
	});
}

function showSubmitResult(msg){
	$("#orderInfoDiv").hide();
	$("#submitResultDiv").show();
	
}
$(function () {
	  $('[data-toggle="tooltip"]').tooltip({"trigger":"manual"});
});

//检查是否为整数
function isInteger(a) {
	var reg = /^(-|+)?d+$/;
	return reg.test(a);
}
//检查是否为正整数
function isUnsignedInteger(a) {
	var reg = /^d+$/;
	return reg.test(a);
}
function   isNumeric(a)
{
    var   reg=/^(-|+)?d+(.d+)?$/;
   return reg.test(a);
}
//检查是否为正数
function   isUnsignedNumeric(a)
{
    var   reg=/^d+(.d+)?$/;
    return reg.test(a);
}
</script>


<!--

//-->
</script>

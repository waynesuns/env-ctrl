<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<script type="text/javascript" src="${path}js/jquery.cityselect.js"></script>
<div class="title">在线订购</div>
<div id="orderDiv">
	<div class="row order" style="padding-top: 0;margin-left:0px;margin-right: 15px;">
		<div style="padding-top: 12px;margin-right: 15px;" class="img col-xxs-12 col-md-5"><img id="productImg" src="${path}img/order/APS550M.jpg" class="img-responsive"></div>
		<div style="padding-top: 12px;padding-bottom: 0;margin-left: -15px;padding-right: 0;" class="info col-xxs-12 col-md-7 order">
			<p>选择型号：</p>
			<div class="order_item"><span><input type="radio" name="productCode" value="APS550M" checked="checked" onclick="changeProduct('APS550M');"/></span><span>APS-550M移动式气相净化仪</span></div>
			<div class="order_item"><span><input type="radio" name="productCode" value="APS480M" onclick="changeProduct('APS480M');"/></span><span>APS-480M移动式气相净化仪</span></div>
			
			<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
				<span>颜色：<span>
				<span style="margin-left:5px;"><input type="radio" name="color" value="GRAY" checked="checked">&nbsp;灰色</input></span>
				<span style="margin-left:5px;"><input name="color" type="radio" value="WHITE">&nbsp;白色</input></span>
			</div>
			<div style="padding-top: 12px;"><span>单价：</span><span id="priceSpan2">¥19800.00</span></div>
			<div><span>订购数量：</span><span><select name="quantity" id="quantity"><c:forEach begin="1" end="10" var="i"><option value="${i}">${i}</option></c:forEach></select></span></div>
			<div><button style="margin-top:15px;width: 100px;" class="btn btn-danger" onclick="orderConfirm();">下一步</button></div>
		</div>
	</div>
	<div class="row productIntrDiv" style="padding-top: 12px;margin-left:0px;margin-right: 15px;" id="productIntrDiv_APS550M">
		<div class="sample-title">APS-550M移动式气相净化仪</div>
		<div>适用于居室及办公环境的顶级空气净化系统。极致去除颗粒物能力，多种气相净化媒体任意组合，长效去除常见的数百种有毒害气体。<font color="#009BDF">建议新装修及有敏感体质人群的环境使用。</font></div>
		<div style="padding-top: 12px;padding-bottom: 12px;">主要净化性能参数：</div>
		<li>CADR 净化效能：530m<sup>3</sup>/h</li>
		<li>PM0.3 去除率：99.99%</li>
		<li>HCHO 甲醛净化效率：98%</li>
		<li>SO<sub>2</sub> 二氧化硫净化效率：>99%</li>
		<li>NO<sub>2</sub> 二氧化氮净化效率：>99%</li>
		<li>C<sub>6</sub>H<sub>6</sub> 苯净化效率：>99%</li>
		<li>C<sub>8</sub>H<sub>8</sub> 甲苯净化效率：>99%</li>
		<li>C<sub>8</sub>H<sub>10</sub> 二甲苯净化效率：>99%</li>
		<div style="padding-top: 12px;"><a href="${path}aps550m/index.html" style="color: #009BDF;">*更多信息请浏览APS-550M产品网站</a></div>
	</div>
	<div class="row productIntrDiv" style="padding-top: 12px;margin-left:0px;margin-right: 15px;display: none;" id="productIntrDiv_APS480M">
		<div class="sample-title">APS-480M移动式气相净化仪</div>
		<div>适用于居室及办公环境的专业级空气净化系统。超大净化效能，综合去除颗粒物及有毒害气体。<font color="#009BDF">建议有对大型空间快速空气净化需求的环境使用。</font></div>
		<div style="padding-top: 12px;padding-bottom: 12px;">主要净化性能参数：</div>
		<li>CADR 净化效能：800m<sup>3</sup>/h</li>
		<li>PM0.3 去除率：99.97%</li>
		<li>HCHO 甲醛净化效率：96%</li>
		<div style="padding-top: 12px;"><a href="${path}aps480m/index.html" style="color: #009BDF;">*更多信息请浏览APS-480M产品网站</a></div>
	</div>
</div>
<div class="order_confirm" style="display: none;" id="orderConfirmDiv">
	<div class="row" style="padding-top: 0;margin-left:0;margin-right: －15px;"><p>已订购商品：</p><hr/></div>
	<div class="row" style="padding-top: 0;margin-left:0px;margin-right: 0px;">
		<div class="img col-xxs-12 col-md-3" style="margin-right: 15px;"><img src="" class="img-responsive" id="productImg2"></div>
		<div class="img col-xxs-12 col-md-6" style="margin-left: -15px;margin-right: 15px;">
			<div id="nameSpan">APS-550M移动式气相净化仪</div>
			<p></p>
			<div id="descSpan">适用于居室及办公环境的顶级空气净化系统。极致去除颗粒物能力，多种气相净化媒体任意组合，长效去除常见的数百种有毒害气体。</div>
		</div>
		<div class="info col-xxs-12 col-md-3 order" style="margin-bottom: 0;margin-left: -15px;padding-right: 0;">
			<div><span>颜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</span><span id="colorSpan">&nbsp;</span></div>
			<div><span>产品单价：</span><span id="priceSpan">&nbsp;</span></div>
			<div><span>订购数量：</span><span id="quantitySpan">&nbsp;</span></div>
			<div><span>运&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费：</span><span>¥0.00</span></div>
			<p></p>
			<div><span>应付总额：</span><span id="sumSpan">&nbsp;</span></div>
		</div>
		<div class="row">
			<button onclick="updateOrder();" style="margin-top:15px;float: right;width: 100px;" class="btn btn-danger">修改商品</button>
		</div>
	</div>
	<div class="row" style="padding-top: 30px;margin-left:0px;margin-right: 0px;"><p>收货人信息：</p><hr/></div>
	<div class="row" style="padding-top: 0;margin-left:0px;margin-right: 0px;">
		<div style="width: 120px;float: left;">收货人*</div>
		<div style="overflow: hidden;" data-toggle="tooltip" data-placement="left" title="请填写收货人" id="nameDiv"><input type="text" name="name" id="name" class="form-control" style="width: 200px;" maxlength="20"></div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 120px;float: left;">手机号码*</div>
		<div style="overflow: hidden;" data-toggle="tooltip" data-placement="left" title="请填写手机号码"id="mobileDiv"><input type="text" name="mobile" id="mobile"  class="form-control" style="width: 200px;" maxlength="11"></div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 120px;float: left;">收件及安装地址*</div>
		<div style="overflow: hidden;" id="city">
			<select class="prov" class="form-control"></select>
			<select class="city" class="form-control"></select>
		</div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 120px;float: left;">&nbsp;</div>
		<div style="overflow: hidden;" data-toggle="tooltip" data-placement="left" title="请填写详细地址" id="addressDiv"><input type="text" name="address" id="address" class="form-control" style="width: 100%;margin-right: 0;padding-right: 0;" placeholder="详细地址" maxlength="100"></div>
	</div>
	<div class="row" style="padding-top: 30px;margin-left:0px;margin-right: 0px;"><p>发票信息：</p><hr/></div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 120px;float: left;"><span>发票抬头</span></div>
		<div style="overflow: hidden;"><input type="text" style="width: 200px;" value="" class="form-control" maxlength="100"></div>
	</div>
	<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 0px;">
		<div style="width: 120px;float: left;"><span>发票类型<span></div>
		<div style="width:80px;float: left;margin-right: 30px;"><input type="radio" name="invoice" checked="checked">&nbsp;普通发票</div>
		<div style="width:100px;float: left;"><input name="invoice" type="radio">&nbsp;增值税发票</div>
	</div>
	
	<div class="row" style="padding-top: 30px;margin-left:0px;margin-right: 0px;"><p>订单备注：</p><hr/></div>
	<div class="row" style="margin-left:0px;margin-right: 0px;">
		<textarea rows="6" cols="" style="width: 100%"  class="form-control" placeholder="如果您对空气净化有指定需求，如去除甲醛、宠物异味或您的环境周边有化工企业或大型市政设施（机场、立交、隧道、污水泵站、地下停车场……）等，请在这里说明。"></textarea>
	</div>
	<div class="row" style="margin-left:0px;margin-right: 0px;">
		<button onclick="submitOrder();" style="margin-top:15px;float: right;width: 100px;" class="btn btn-danger">提交订单</button>
	</div>
	
</div>

<div class="row" style="padding-top: 12px;margin-left:0px;margin-right: 15px;" id="orderDescDiv">
	<div id="errorMsgDiv" class="alert alert-warning alert-dismissible fade in" role="alert" style="display: none;">
	    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	    <string>请填写以下内容：</string><font id="errorMsg"></font>
	</div>
	<p>订购说明：</p>
	<hr/>
	<div>1、目前仅提供北京、上海以及沈阳地区的在线订购，其他区域敬请期待；</div>
	<div>2、货到付款，由艾易西专业售后服务团队提供送货及安装服务；</div>
	<div>3、提供正规机打发票；</div>
	<div>4、凭产品三包凭证及发票，可享受5年质保服务；</div>
	<div>5、免费提供TECH-CHEK<sup>TM</sup>空气质量检测服务；</div>
	<div>6、如有其他疑问，请拨打艾易西服务热线：4008-725-000，我们将竭诚为您服务。</div>
</div>

<div class="row" style="padding-top: 12px;display: none;" id="submitResultDiv">
	<h4 style="text-align: center;">您的订单已成功提交！</h4>
	<p style="text-align: center;">我们的客服人员会尽快通过电话和您确认订购信息并预约送货安装服务，感谢您的订购！</p>
</div>
<script type="text/javascript">
$("#city").citySelect({
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
var colorInfos = {"GRAY":"灰色","WHITE":"白色"};
var productInfos = {"APS550M":{"price":19800,"model":"APS.550M-","name":"APS-550M移动式气相净化仪","desc":"适用于居室及办公环境的顶级空气净化系统。极致取出颗粒物能力，多种气相净化媒体任意组合，长效去除常见的数百种有毒害气体。"},
			   	   "APS480M":{"price":17600,"model":"APS.480M-","name":"APS-480M移动式气相净化仪","desc":"适用于居室及办公环境的专业级空气净化系统。超大净化效能，综合去除颗粒物及有毒害气体。"}};
function changeProduct(productCode){
	var pi = productInfos[productCode];
	var price = pi["price"];
	$("#priceSpan2").text("¥"+price+".00");
	$("#productImg").attr("src","${path}img/order/"+productCode+".jpg");
	$(".productIntrDiv").hide();
	$("#productIntrDiv_"+productCode).show();
}

function orderConfirm(){
	var productCode = $("input[name='productCode']:checked").val(); 
	var color = $("input[name='color']:checked").val(); 
	var quantity = $("#quantity").val();
	var pi = productInfos[productCode];
	var price = pi["price"];
	
	$("#colorSpan").text(colorInfos[color]);
	$("#priceSpan").text("¥"+price+".00");
	$("#quantitySpan").text(quantity);
	$("#sumSpan").text("¥"+(price*quantity)+".00");
	$("#nameSpan").text(pi["name"]+"("+colorInfos[color]+")");
	$("#descSpan").text(pi["desc"]);
	$("#productImg2").attr("src","${path}img/order/"+productCode+".jpg");
	$("#orderDiv").hide();
	$("#orderConfirmDiv").show();
}

function submitOrder(){
	var name = $("#name").val();
	var mobile = $("#mobile").val();
	var address = $("#address").val();
	var errorInfo = new Array();
	$("#nameDiv").tooltip('hide');
	$("#mobileDiv").tooltip('hide');
	$("#addressDiv").tooltip('hide');
	if(name==null || name.length==0){
		errorInfo.push("#nameDiv");
	}
	if(mobile==null || mobile.length!=11){
		errorInfo.push("#mobileDiv");
	}
	if(address==null || address.length==0){
		errorInfo.push("#addressDiv");
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
	showSubmitResult();
}

function showSubmitResult(msg){
	$("#orderDiv").hide();
	$("#orderConfirmDiv").hide();
	$("#orderDescDiv").hide();
	$("#submitResultDiv").show();
	
}

function updateOrder(){
	$("#orderDiv").show();
	$("#orderConfirmDiv").hide();
}
$(function () {
	  $('[data-toggle="tooltip"]').tooltip({"trigger":"manual"});
	});

</script>


<!--

//-->
</script>

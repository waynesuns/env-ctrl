<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<script type="text/javascript" src="${path}js/jquery.cityselect.js"></script>
<div class="title">TECH-CHEK<sup>TM</sup>空气质量检测服务</div>
<div class="info ">IIIECC联合Circul-Aire与加拿大国家科学与工程研究委员会、加拿大肯高迪亚大学，建立了专属科学实验室，在50年的发展过程中，不断研发更新了数十种的气相净化媒体及几百种的媒体组合，来应对千变万化的应用场合。TECH-CHEKTM正是IIECC公司所独有的技术服务。</div>
<div class="info ">IIECC作为专业的空气质量服务商有专门的上门检测技术人员，他们会将客户的空间实际容积数、室内污染浓度、室内居住人员情况等多种因素结合起来考虑；然后IIECC的技术团队会根据这些现场实际参数为用户量身定制选择出最适合的空气净化设备及媒体组合；当空气净化设备投入使用后还会定期进行回访并对媒体进行寿命周期检测，从而确保整个设备处在一个 最佳的运行点。</div>
<div class="info ">针对特别复杂的工业市政等环境，IIECC还可以提供气体采集并由实验室分析制定相应的解决方案。</div>
<div class="img "><img src="${path}img/order/techchek_pm25.jpg"class="img-responsive"></div>

<div class="info ">家庭及办公环境空气质量检测内容包括：</div>
<li>甲醛 HCHO</li>
<li>总挥发性有机物 TVOC</li>
<li>二氧化硫 SO<sub>2</sub></li>
<li>二氧化氮 NO<sub>2</sub></li>
<li>细颗粒物 PM2.5</li>
<li>可吸入颗粒物 PM10</li>
<div class="row" style="padding-top: 24px;margin-left:0px;margin-right: 15px;" id="orderDescDiv">
	<div class="info ">服务说明：</div>
	<hr/>
	<div>1、目前仅开放北京、上海以及沈阳地区的空气质量检测服务；</div>
	<div>2、本检测服务为免费，不向客户收取任何费用；</div>
	<div>3、在线预约后，本公司会根据排期提前和客户电话确认上门检测时间；</div>
	<div>4、如有任何疑问，欢迎拨打艾易西服务热线4008-725-000，我们将竭诚为您服务。</div>
</div>
<div class="row">
	<!-- button onclick="" style="margin:15px;float: right;width: 200px;" class="btn btn-danger">预约查询</button -->
	<button onclick="window.location.href='${path}order/service_order.html'" style="margin:15px;float: right;width: 200px;" class="btn btn-danger">在线预约空气质量检测服务</button>
</div>
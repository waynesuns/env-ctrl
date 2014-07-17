<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- content start -->
<c:set var="headerPicName" value="solution.jpg" scope="request"/>
<c:set var="subItems" scope="request">
	概览:solution/overview.html,化工:solution/chemica.html,医疗:solution/healthcare.html,市政:solution/government.html,军队:solution/army.html,住宅:solution/residence.html,场馆及院校:solution/venues.html,酒店及办公楼宇:solution/hotel.html
</c:set>
<c:set var="activeSubItem" value="住宅" scope="request"/>
<c:set var="subItemTitle" value="领域应用及解决方案" scope="request"/>
<c:set var="subItemHeaderImgInfo" value="多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。" scope="request"/>
<c:set var="subItemInfo" value="考虑到人类本身对于新风的需求性，现阶段大部分住宅系统开始安装新风系统，但室外空气实际质量并不理想，污染物不仅仅包括PM2.5 等颗粒物，氮氧化物和硫氧化物给人带来的危害更大，此类新风一旦引入室内，非但不能起到给人带来舒适度的作用，还会给人们的呼吸系统带来危害；针对住宅类的新风系统，EC提出了多重颗粒物过滤系统+气相净化的新风设计方案，不仅能够使室内PM2.5降低到极低值，还能利用化学吸附催化氧化的原理处理掉室外引进新风中的污染气体。" scope="request"/>

<c:set var="subItemSample1Title" value="东渡国际" scope="request"/>
<c:set var="subItemSample1Info" value="东渡国际中心作为上海高档的大平层住宅类别墅，设计方在考虑暖通设计时就对空气净化提出了严格的要求，后经工程师们推荐选用了新风与内循环净化混合的AG系列机型，该机型的特征是将内循环净化和新风引进设计在一个机组内部，这样既满足了住宅类的通风要求，又实现了内循环净化，在该套机组设备的运转下，可以保证室内的PM2.5浓度持续保持在国标以下，让室内人员呼吸时不再受雾霾之苦。" scope="request"/>

<c:set var="subItemSample2Title" value="北京丽都/北京丽宫、汤臣一品等高端社区" scope="request"/>
<c:set var="subItemSample2Info" value="一般来说室内空气污染会比室外严重，但在国内目前的环境下，人们平时都会采用开窗换气的方法已经没有效果。在一些高级公寓和别墅项目中，业主们对空气质量有较高要求，不仅要求空气中尽量少的PM2.5浓度，更对空气中所含的各类有毒有害气体的浓度也提出了高要求。比如空气质量指数中的SO2和NO2浓度等。在这个条件下我们的APG40M系列除有效去除PM2.5/PM10等颗粒物污染以外，还同时去除空气中的NOX，SOX，CO，O3等化学性污染，从而满足了业主对高品质空气的需求" scope="request"/>

<c:set var="subItemSample3Title" value="" scope="request"/>
<c:set var="subItemSample3Info" value="" scope="request"/>

<c:set var="subItemSamplePicName" value="chemica.jpg" scope="request"/>

<c:import url="/template/subitem.jsp"/>
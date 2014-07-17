<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- content start -->
<c:set var="headerPicName" value="solution.jpg" scope="request"/>
<c:set var="subItems" scope="request">
	概览:solution/overview.html,化工:solution/chemica.html,医疗:solution/healthcare.html,市政:solution/government.html,军队:solution/army.html,住宅:solution/residence.html,场馆及院校:solution/venues.html,酒店及办公楼宇:solution/hotel.html
</c:set>
<c:set var="activeSubItem" value="军队" scope="request"/>
<c:set var="subItemTitle" value="领域应用及解决方案" scope="request"/>
<c:set var="subItemHeaderImgInfo" value="多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。" scope="request"/>
<c:set var="subItemInfo" value="由于工作环境的重要性，某些涉及到军方的项目对其内部的环境质量要求更高，例如潜艇内部、逃生通道等；此类区域的空气污染物的浓度必须严格控制在ppt(parts-per-trillion,10–12) 级别，传统的颗粒物过滤系统以及单纯的物理性吸附无法解决此类污染问题；针对此类项目我们提供了多级气相媒体净化系统，并根据不同的污染物选配从MM-1000到MM-9000等不同的媒体滤料，以达到最好的气相净化效果。" scope="request"/>

<c:set var="subItemSample1Title" value="联合国逃生通道" scope="request"/>
<c:set var="subItemSample1Info" value="联合国作为国际性的政务工作部门，为应对恐怖袭击、火灾或者自然灾害这些危害极大的突发事件需配备高质的逃生通道，而逃生通道内的空气品质是设计过程中重中之重的，为了保证逃生通道内的有害气体污染物浓度达到最低，我们的工程师们提出了深床式气相净化+室内小型净化机组的综合解决方案，在该项目中，深床式气相净化可以去除新风引进时内含的气态污染物，而室内小型净化机组则可针对逃生通道内的空气进行内循环过滤；该逃生通道投入使用后，经过监测，通道内的各项污染物浓度均低于国际标准。" scope="request"/>

<c:set var="subItemSample2Title" value="美国军方逃生通道" scope="request"/>
<c:set var="subItemSample2Info" value="美国军方逃生通道，作为战时备用的通道，其内部的通风系统的设计要求严格控制空气污染的浓度，特别是从室外引进的新风里污染物的浓度，针对此类特殊项目，工程师们提出了DAS（深床式气相过滤系统）+APS（小型室内净化机组）组合式净化系统，该系统能够在净化新风的同时对通道内的空气进行循环过滤，有效的降低了室内颗粒物的浓度和有害的污染气体。" scope="request"/>

<c:set var="subItemSample3Title" value="" scope="request"/>
<c:set var="subItemSample3Info" value="" scope="request"/>

<c:set var="subItemSamplePicName" value="chemica.jpg" scope="request"/>

<c:import url="/template/subitem.jsp"/>
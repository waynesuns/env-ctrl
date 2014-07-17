<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- content start -->
<c:set var="headerPicName" value="solution.jpg" scope="request"/>
<c:set var="subItems" scope="request">
	概览:solution/overview.html,化工:solution/chemica.html,医疗:solution/healthcare.html,市政:solution/government.html,军队:solution/army.html,住宅:solution/residence.html,场馆及院校:solution/venues.html,酒店及办公楼宇:solution/hotel.html
</c:set>
<c:set var="activeSubItem" value="市政" scope="request"/>
<c:set var="subItemTitle" value="领域应用及解决方案" scope="request"/>
<c:set var="subItemHeaderImgInfo" value="多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。" scope="request"/>
<c:set var="subItemInfo" value="" scope="request"/>

<c:set var="subItemSample1Title" value="" scope="request"/>
<c:set var="subItemSample1Info" value="" scope="request"/>

<c:set var="subItemSample2Title" value="" scope="request"/>
<c:set var="subItemSample2Info" value="" scope="request"/>

<c:set var="subItemSample3Title" value="" scope="request"/>
<c:set var="subItemSample3Info" value="" scope="request"/>

<c:set var="subItemSamplePicName" value="chemica.jpg" scope="request"/>

<c:import url="/template/subitem.jsp"/>
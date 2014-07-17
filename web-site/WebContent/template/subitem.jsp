<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<c:set var="path" value="../" scope="request"/>
<c:import url="/common/header.jsp"/>
<c:import url="/common/navbar.jsp"/>
<!-- content start -->

<div class="jumbotron header_img">
	<div class="container" style="position: relative;">
		<img src="${path}img/header/${headerPicName}">
		<div class="content">
			<div class="title">${subItemTitle}</div>
			<div class="info">${subItemHeaderImgInfo}</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="col-md-9 col-xxs-12 subitem" style="position: relative;">
		<div class="list-group menu hidden-xxs hidden-xs">
			<c:forEach var="subItem" items="${subItems}">
				<c:set var="si" value="${fn:split(subItem,':')}"/>
				<a href="${path}${si[1]}" class="list-group-item ${si[0] eq activeSubItem ? 'active':''}">${si[0]}<span style="float: right;">></span></a>
			</c:forEach>
		</div>
		<div class="content">
			<ol class="breadcrumb">
			  <li><a href="../index.html">首页</a></li>
			  <li><a href="#">${subItemTitle}</a></li>
			  <li class="active">${activeSubItem}</li>
			</ol>
			<div class="title">${activeSubItem}</div>
			<div class="info">${subItemInfo}</div>
			<hr/>
			<div class="title">案例</div>
			<div class="sample-title">${subItemSample1Title}</div>
			<div class="info">${subItemSample1Info}</div>
			<div class="img"><img src="${path}img/sample/${subItemSamplePicName}" class="img-responsive"></div>
			<div class="sample-title">${subItemSample2Title}</div>
			<div class="info">${subItemSample2Info}</div>
			<c:if test="${subItemSample3Title != null}">
				<div class="sample-title">${subItemSample3Title}</div>
				<div class="info">${subItemSample3Info}</div>
			</c:if>
			<c:if test="${subItemSample4Title != null}">
				<div class="sample-title">${subItemSample4Title}</div>
				<div class="info">${subItemSample4Info}</div>
			</c:if>
			<div style="margin-bottom: 120px;"></div>
		</div>
	</div>
</div>
<!-- content end -->
	
<c:import url="/common/footer.jsp"/>
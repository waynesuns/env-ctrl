<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<c:set var="path" value="../" scope="request"/>
<c:import url="/common/header.jsp"/>
<c:import url="/common/navbar.jsp"/>
<!-- content start -->
<div class="jumbotron header_img">
	<div class="container" style="position: relative;">
		<img src="${path}img/header/${solutionParam.headerPicName}">
		<div class="content">
			<div class="title">${solutionParam.subItemTitle}</div>
			<div class="info">${solutionParam.subItemHeaderImgInfo}</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="col-md-9 col-xxs-12 subitem" style="position: relative;">
		<div class="list-group menu hidden-xxs hidden-xs">
			<c:forEach var="subItem" items="${solutionParam.subItems}">
				<a href="${path}${subItem.url}" class="list-group-item ${subItem.name eq activeSubItem ? 'active':''}">${subItem.name}<span style="float: right;">></span></a>
			</c:forEach>
		</div>
		<div class="content">
			<ol class="breadcrumb">
			  <li><a href="../index.html">首页</a></li>
			  <li><a href="#">${solutionParam.subItemTitle}</a></li>
			  <li class="active">${solutionParam.activeSubItem}</li>
			</ol>
			<div class="title">${solutionParam.activeSubItem}</div>
			<div class="info">${solutionParam.subItemInfo}</div>
			<c:if test="${fn:length(solutionParam.samples)>0}">
			<hr/>
			<div class="title">案例</div>
			<c:forEach var="sample" items="${solutionParam.samples}">
				<div class="sample-title">${sample.title}</div>
				<div class="info">${sample.info}</div>
				<c:if test="${sample.picName != null}">
				<div class="img"><img src="${path}img/sample/${sample.picName}" class="img-responsive"></div>
				</c:if>
			</c:forEach>
			</c:if>
			<div style="margin-bottom: 120px;"></div>
		</div>
	</div>
</div>
<!-- content end -->
	
<c:import url="/common/footer.jsp"/>
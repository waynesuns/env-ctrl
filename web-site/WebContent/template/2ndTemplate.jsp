<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<c:set var="path" value="../" scope="request"/>
<c:import url="/common/header.jsp"/>
<c:import url="/common/navbar.jsp"/>
<!-- content start -->
<div class="jumbotron header_img">
	<div class="container" style="position: relative;">
		<img src="${path}img/header/${solutionParam.headerPicName}" class="img-responsive">
		<div class="content">
			<div class="title">${solutionParam.subItemTitle}</div>
			<div class="info">${solutionParam.subItemHeaderImgInfo}</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="col-lg-10 col-sm-11 col-xxs-12 subitem" style="position: relative;">
		<div class="list-group menu hidden-xxs hidden-xs">
			<c:forEach var="subItem" items="${solutionParam.subItems}">
				<div>
				<div class="list-group-item ${subItem.name eq activeSubItem ? 'active':''}">
					<div style="width: 160px;" >
						<a href="${path}${subItem.url}" class="">${subItem.name}</a>
					</div>
					<div style="float: right;position: absolute;top:25%;right:0;"><a href="${path}${subItem.url}" class="">></a></div>
				</div>
				</div>
			</c:forEach>
		</div>
		<div class="content">
			<ol class="breadcrumb">
			  <li><a href="../index.html">首页</a></li>
			  <li><a href="#">${solutionParam.subItemTitle}</a></li>
			  <li class="active">${solutionParam.activeSubItem}</li>
			</ol>
			<c:import url="${detailPage}.jsp"></c:import>
			<div style="margin-bottom: 120px;"></div>
		</div>
	</div>
</div>
<!-- content end -->
	
<c:import url="/common/footer.jsp"/>
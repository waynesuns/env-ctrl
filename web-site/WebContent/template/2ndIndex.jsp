<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<c:set var="path" value="../" scope="request"/>
<c:import url="/common/header.jsp"/>
<c:import url="/common/navbar.jsp"/>
<div class="navbar-collapse collapse in" id="navbar-xs-main" style="margin-top: 4px;">
	<ul class="nav navbar-nav">
		<c:forEach items="${solutionParam.subItems}" var="subItem" varStatus="i">
		<li class="${i.index%2==0?'gray':'' }">
			<a role="button" href="../${subItem.url}">${subItem.name}</a>
		</li>
		</c:forEach>
	</ul>
   
</div>
	
<c:import url="/common/footer.jsp"/>
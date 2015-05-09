<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<hr />
<div style="position: relative;">
	<img alt="" src="../img/about_us/global_map/us.jpg" class="img-responsive" id="globalMapImg">
	<a style="position: absolute;top: 34%;left: 5%;cursor: hand;" onclick="switchGlobalMap('us');">北美</a>
	<a style="position: absolute;top: 38%;left: 37%;cursor: hand;" onclick="switchGlobalMap('europe');">欧洲</a>
	<a style="position: absolute;top: 47%;left: 90%;cursor: hand;" onclick="switchGlobalMap('asia');">亚洲</a>
</div>
<c:forEach var="groupParam" items="${groupParams}">
<div class="">
<div class="row" style="margin-top: 30">
	<div class="col-lg-3 col-sm-4 col-xs-3">
		<span class=" title"><c:out value="${groupParam.name}" escapeXml="false"/></span>
		<hr/>
	</div>
</div>
<c:forEach var="partner" items="${groupParam.partners}" varStatus="i">
<c:if test="${(i.index+1)<fn:length(groupParam.partners) && ((i.index+1)%4==0 || i.index==0)}">
	<div class="row">
</c:if>
	<div class="col-xs-3">	
		<div>
			<img alt="" src="${path}${partner.logo}" class="img-responsive ">
			<div class="caption text-center">
				<p><c:out value="${partner.name}" escapeXml="false"/></p>
			</div>
		</div>
	</div>
	<c:if test="${i.index>0 && ((i.index+1)%4==0 || (i.index+1)==fn:length(groupParam.partners))}">
	</div>
	</c:if>
	</c:forEach>
</div>
</c:forEach>
<script>
	function switchGlobalMap(imgName){
		$('#globalMapImg').attr("src","../img/about_us/global_map/"+imgName+".jpg");
	}
</script>
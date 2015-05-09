<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<hr />
<c:forEach begin="0" end="${fn:length(solutionParam.samples)}" step="4" var="i">
	<div >
		<c:forEach var="cert" items="${solutionParam.samples}" begin="${i}" end="${i+3}">
			<div>
				<div class="row" >
					<div class="col-xxs-5 col-xs-4 col-sm-5 col-md-3"><img src="${path}img/${cert.picName}" alt="" class="img-responsive"></div>
					<div class="col-xxs-7 col-xs-8 col-sm-7 col-md-9 caption text-left">
						<h5><c:out value="${cert.title}" escapeXml="false"/></h5>
						<p><c:out value="${cert.info}" escapeXml="false"/></p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</c:forEach>
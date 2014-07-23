<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<hr />
<c:forEach begin="0" end="${fn:length(solutionParam.samples)}" step="4" var="i">
	<div class="row" <c:if test="${i>0}">style="margin-top: 30px;"</c:if>>
		<c:forEach var="cert" items="${solutionParam.samples}" begin="${i}" end="${i+3}">
			<div class="col-xs-3">
				<div>
					<img src="${path}img/${cert.picName}" alt="" class="img-responsive">
					<div class="caption text-center">
						<h5><c:out value="${cert.title}"/></h5>
						<p><c:out value="${cert.info}"/></p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</c:forEach>
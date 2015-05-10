<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header" style="padding-bottom: 12px"><i class="fa fa-align-justify fa-lg"></i>
			<a  href='<c:url value="/login/show.do"/>' ><fmt:message key="bbs.new.list" /></a> >> ${announcement.title }
			<a class="pull-right mr20" href="<c:url value="/login/show.do"/>" id="back" data-toggle="tooltip" data-placement="bottom"  data-original-title="<fmt:message key="qtip.message.back"/>"><i  class="fa fa-arrow-circle-left fa-lg " ></i></a>
		</h3>
	</div>
</div>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="table-responsive">
			<div class="bbs_l">
			<ul> 
				<span id="show_content"></span>
				<br />
				<c:if test="${announcement.hasAttachment == 'true' }">
				<div class="mt15">${announcement.attachment.fileName }
				<a class="download   cursor"  data-placement="bottom"  data-original-title="<fmt:message key="qtip.message.upload"/>" href="javascript:downLoad('${announcement.id }');"><i  class="fa fa-download fa-lg " ></i></a>
				</div>
				</c:if>        
			</ul>
		</div>
		</div>
	</div>
</div>
<!-- <div class="row"> -->
<!-- 	<div class="col-lg-12"> -->
<!-- 		<div class="bbs_l"> -->
<!-- 			<ul>  -->
<!-- 				<span id="show_content"></span> -->
<!-- 				<br /> -->
<%-- 				<c:if test="${announcement.hasAttachment == 'true' }"> --%>
<%-- 				${announcement.attachment.fileName } --%>
<%-- 				<a class="download   cursor"  data-placement="bottom"  data-original-title="<fmt:message key="qtip.message.upload"/>" href="javascript:downLoad('${announcement.id }');"><i  class="fa fa-download fa-lg " ></i></a> --%>
<%-- 				</c:if>         --%>
<!-- 			</ul> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->


<jsp:include page="content_script.jsp"></jsp:include>
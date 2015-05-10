<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<% 
response.setHeader("P3P","CP=\"ALL ADM DEV PSAi COM OUR OTRo STP IND ONL\""); 
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    
	<jsp:include page="/WEB-INF/include/base.jsp" />
<%-- 	<tiles:insert attribute="meta" /> --%>
	<jsp:include page="/WEB-INF/include/script.jsp" />
	<jsp:include page="../default/include/global_variables.jsp" />
	
	<script type="text/javascript">
	var homeLocationPath='<c:url value="/login/show.do"/>';
	</script>
</head>

<body>
<div id="wrapper">
<tiles:insert attribute="header"/>
<tiles:insert attribute="menu"/>
<div id="page-wrapper">
<tiles:insert page="/${tiles_content}" flush="true"/>
</div>
<div class="clearfooter"></div>
<div class="cl"></div>
<tiles:insert attribute="footer"/>
</div>
</body>
</html>
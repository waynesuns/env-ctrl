<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><fmt:message key="common.sitename"/></title>
	<jsp:include page="/WEB-INF/include/script.jsp" />
</head>
<body>
	<div class="container">
		<!-- <div class="head">
			<div class="top_c">
				<div class="logo"></div>
				<span class="t_title">上汽通用五菱服务商门户</span>
				<div class="fuc">
					<img src="images/setting.png"/>
					<img src="images/user.png"/>
					<img src="images/quit.png" class="cursor" onclick="quit()"/>
				</div>
			</div>
			<div class="cl"></div>
		</div> -->
		<div class="middle">
			<div class="error_wrapper">
				<div class="title404 g6">500</div>
				<div class="content404">
					<span class="f16 g9">
						服务器不能执行此请求， 请稍后再试。<br/>
						如果问题依然存在，请联系系统管理员。
					</span><br/>
					<span class="f16 red_f b cursor" onclick="goBack()">返回上一页</span>
				</div>
			</div>
			<div class="cl"></div>
		</div>
		<!-- <div class="footer">
			<div class="footer_c">上汽通用五菱汽车股份有限公司版权所有</div>
		</div> -->
	</div>
</body>
</html>

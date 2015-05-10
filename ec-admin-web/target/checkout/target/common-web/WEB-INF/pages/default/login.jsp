<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><fmt:message key="common.sitename"/></title>
	<jsp:include page="/WEB-INF/include/script.jsp" />
	<script>
		$(document).ready(function(){
			var message = "${loginErrorMessage}";
			if($.trim(message) != "")
				open_popover_error(message);
		});
	</script>
</head>
<body>
	<div class="login_t">
		<div class="login_logo">
			<img class="l" src="images/logo_l.png" /><span>上汽通用五菱服务商门户</span>
		</div>
		<div class="cl"></div>
	</div>
	<div class="login_con_w">
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<div class="login_con">
			<form method="post" action="j_spring_security_check"  id="login">
				<ul>
					<li>用户名：<input type="text" class="input2" id="userName" name="j_username" /></li>
					<li><span style="margin-left: 15px">密码：</span><input type="password" name="j_password" class="input2" id="password" /></li>
					<li><input type="submit" class="btn2" value="登录" style="font-family: '微软雅黑';" /></li>
				</ul>
			</form>
		</div>
		<div class="cl"></div>
	</div>
	<div class="footer">
		<div class="footer_c">上汽通用五菱汽车股份有限公司版权所有</div>
	</div>
</body>
</html>

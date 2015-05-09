<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
	<!-- footer start -->
<div class="jumbotron main-info">
  <div class="container">
	<div class="row">
		<div class="col-md-6 col-sm-8 col-xs-8 col-xxs-12 product">
			<span class="title">产品系列</span>
			<hr />
			<ul class="list-unstyled visible-xs-block item">
				<c:forEach var="productMenu" items="${productMenus.subItems}">
					<li><a tabindex="-1" href="${path}${productMenu.url}" style="padding-right: 35px;">${productMenu.name}</a></li>
				</c:forEach>
			</ul>
			<div class="row hidden-xs " style="color: #666666;">
				<div class="col-sm-6 ">
					<ul class="list-unstyled item">
						<c:forEach var="productMenu" items="${productMenus.subItems}" end="2">
							<li><a tabindex="-1" href="${path}${productMenu.url}">${productMenu.name}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="col-sm-6">
					<ul class="list-unstyled item">
						<c:forEach var="productMenu" items="${productMenus.subItems}" begin="3">
							<li><a tabindex="-1" href="${path}${productMenu.url}">${productMenu.name}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-4 col-xs-4 col-xxs-12 contact-us">
			<span class="title">联系我们</span>
			<hr/>
			<ul class="list-unstyled item">
				<c:forEach var="contactUsMenu" items="${contactUsMenus.subItems}">
					<li><a tabindex="-1" href="${path}${contactUsMenu.url}">${contactUsMenu.name}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="footer row hidden-xs hidden-xxs" >
		<div class="col-sm-12" style="padding-left: 0;padding-right: 0;">
			<hr/>
			<div>
				<!-- <a class="footer-link" href="${path}area/china.html">中国大陆</a>-->
				<a class="footer-link" href="${path}policy/privacy_policy.html">隐私政策</a>
				<a class="footer-link" href="${path}policy/use_policy.html">使用条款</a>
				<img class="footer-icon" src="${path}img/sns_1.jpg"/>
				<img class="footer-icon" src="${path}img/sns_2.jpg"/>
				<div class="copyright" style="float: right;"><span class="">沪ICP备14044424号</span><span class="hidden-xs hidden-sm" style="padding-left: 15px;">©2014 IIECC, ALL RIGHTS RESERVED</span></div>
			</div>
		</div>
		<div class="copyright visible-sm-block">
			<span style="float: right;padding-right: 15px;"  >©2014 IIECC, ALL RIGHTS RESERVED</span>
		</div>
	</div>
	<div class="footer row visible-xs-block">
		<div class="col-xs-12" style="padding-left: 0;padding-right: 0;">
			<hr/>
			<div class="">
				<!-- <a class="footer-link" href="${path}area/china.html">中国大陆</a> -->
				<a class="footer-link" href="${path}policy/privacy_policy.html">隐私政策</a>
				<img class="footer-icon" src="${path}img/sns_1.jpg"></img>
				<img class="footer-icon" src="${path}img/sns_2.jpg"></img>
				<span class="copyright">沪ICP备14044424号</span>
			</div>
			<div>
				<a class="footer-link" href="${path}policy/use_policy.html">使用条款</a>
				<span class="copyright" >©2014 IIECC, ALL RIGHTS RESERVED</span>
			</div>
		</div>
	</div>
	<div class="footer row visible-xxs-block">
		<div class="col-xs-12" style="padding-left: 0;padding-right: 0;">
			<hr/>
			<div class="row">
				<!-- <a class="footer-link col-xs-3"  href="${path}area/china.html">中国大陆</a> -->
				<a class="footer-link col-xs-3"  href="${path}policy/privacy_policy.html">隐私政策</a>
				<a class="footer-link col-xs-3"  href="${path}policy/use_policy.html">使用条款</a>
			</div>
			<div>
				<img class="footer-icon" src="${path}img/sns_1.jpg"></img>
				<img class="footer-icon" src="${path}img/sns_2.jpg"></img>
			</div>
		</div>
	</div>
	<div class="copyright visible-xxs-block">
		<div class="text-center">沪ICP备14044424号</div>
		<div class="text-center">©2014 IIECC, ALL RIGHTS RESERVED</div>
	</div>
</div>
</div>
</div>

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-55625311-1', 'auto');
  ga('send', 'pageview');

</script>

</body>
</html>
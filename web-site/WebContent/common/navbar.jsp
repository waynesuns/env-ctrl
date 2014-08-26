<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<body> <div class="container">
	<div class="row" style="margin-top: 10px;margin-bottom: 8px;">
		<div class="col-md-2 col-sm-2 col-xs-0 hidden-xs hidden-xxs">
			<a href="${path}index.html"><img src="${path}img/logo.jpg" /></a>
		</div>
		<div class="col-md-10 col-sm-10 col-xs-12" style="margin-top: 7px">
			<div class="row hidden-xs hidden-xxs" >
				<div class="hot-line col-md-offset-9 col-md-3 col-sm-offset-7 col-sm-5">
					<div style="float: left;text-align: left;"><img src="${path}img/icon/phone.png" style="height: 14px;width: 14px;margin-top: -2px;margin-right: 5px;"/>4008-725-000</div>
					<div style="float: right;">EN｜中文</div>
				</div>
			</div>
			<div class="row" style="margin-top: 8px;" >
				<div class="col-md-9 col-sm-12 col-xs-12" style="padding-right: 0;">
					<nav class="navbar navbar-default" role="navigation">
					  <div class="container-fluid">
					    <!-- Brand and toggle get grouped for better mobile display -->
					    
					    <div class="navbar-header" style="width: 100%;">
					      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-xs-main" style="border:none;height: 64px;width: 64px;">
					        <img src="${path}img/nav.png" >
					      </button>
					    	<!-- a href="#" class="btn btn-lg navbar-toggle" role="button" data-toggle="collapse" data-target="#navbar-collapse-main" style="height: 100px;width: 100px;">三</a-->
					      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-xs-search" style="border:none;height: 64px;width: 64px;">
					      	<img src="${path}img/search.png" >
					      </button>
					      <div class="visible-xs-block visible-xxs-block logo" >
								<a href="${path}index.html"><img src="${path}img/logo.png" /></a>
							</div>
						<div class="collapse navbar-collapse" id="navbar-xs-search">
								<!-- form class="navbar-left visible-xs-block" role="search" style="position: relative;">
									<input class="form-control" id="inputIcon" type="text" />
									<span class="glyphicon glyphicon-search" style="position:absolute;right: 18px;top:9px;"></span>
								</form -->
						      
						</div>
						<div class="collapse navbar-collapse" id="navbar-xs-main" style="margin-top: 4px;margin-left: 15px;">
					      <ul class="nav navbar-nav visible-xs-block visible-xxs-block">
					        <li class="gray">
								<a id="drop0" role="button" href="${path}solution/index.html">领域应用及解决方案</a>
							</li>
							<li class="">
							  <a id="drop2" role="button" href="${path}technology/index.html">核心技术</a>
							</li>
							<li class="gray">
							  <a id="drop3" role="button" href="${path}product/index.html">产品系列</a>
							</li>
							<li class="">
							  <a id="drop4" role="button" href="${path}about_us/index.html">关于EC</a>
							</li>
							<li class="gray">
							  <a id="drop5" role="button" href="${path}contact_us/index.html">联系我们</a>
							</li>
					      </ul>
					     
					    </div>
					    
					    <!-- Collect the nav links, forms, and other content for toggling -->
					    <div class="collapse navbar-collapse" id="navbar-main" style="width: 100%;padding-right: 0;">
					      <ul class="nav navbar-nav" style="width: 100%;">
					        <li class="dropdown">
								<a id="drop0" role="button" data-toggle="dropdown" href="#" onmouseover="$(this).click()">领域应用及解决方案</a>
							    <ul id="drop1" class="dropdown-menu row" style="width: 280px;">
									<li class="row">
										<div class="col-sm-4" style="float: left;min-height: 20px;"><a tabindex="-1" href="${path}solution/overview.html" style="padding-left: 35px;">概览</a></div>
										<div class="col-sm-8" style="float: left;min-height: 20px;"><a tabindex="-1" href="${path}solution/military.html" style="padding-left: 15px;">军事</a></div>
									</li>
									<li  class="row">
										<div class="col-sm-4" style="float: left;min-height: 20px;"><a tabindex="-1" href="${path}solution/chemica_industry.html" style="padding-left: 35px;">化工</a></div>
										<div class="col-sm-8" style="float: left;min-height: 20px;"><a tabindex="-1" href="${path}solution/residence.html" style="padding-left: 15px;">住宅</a></div>
									</li>
									<li  class="row">
										<div class="col-sm-4" style="float: left;min-height: 20px;"><a tabindex="-1" href="${path}solution/medical_treatment.html" style="padding-left: 35px;">医疗</a></div>
										<div class="col-sm-8" style="float: left;min-height: 20px;"><a tabindex="-1" href="${path}solution/stadium.html" style="padding-left: 15px;">场馆及院校</a></div>
									</li>
									<li  class="row">
										<div class="col-sm-4" style="float: left;min-height: 20px;"><a tabindex="-1" href="${path}solution/municipal_administration.html" style="padding-left: 35px;">市政</a></div>
										<div class="col-sm-8" style="float: left;min-height: 20px;"><a tabindex="-1" href="${path}solution/hotel.html" style="padding-left: 15px;">酒店及办公楼宇</a></div>
									</li>
								</ul>
							</li>
							<li class="nav-delim"><col-md->|</col-md-></li>
							<li class="dropdown">
							  	<a role="button" data-toggle="dropdown" href="#" onmouseover="$(this).click()">核心技术</a>
								<ul class="dropdown-menu" style="width: 280px;">
									<li>
									<div style="min-height: 20px;"><a tabindex="-1" href="${path}technology/overview.html" style="padding-left: 35px;padding-right: 35px;">气相过滤和气相混合净化媒体简介</a></div>
									</li>
									<li>
										<div style="min-height: 20px;"><a tabindex="-1" href="${path}technology/scope.html" style="padding-left: 35px;padding-right: 35px;">可去除的气态污染物及其介绍</a></div>
									</li>
								</ul>
							</li>
							<li class="nav-delim"><col-md->|</col-md-></li>
							<li class="dropdown">
							  	<a id="drop3" role="button" data-toggle="dropdown" href="#" onmouseover="$(this).click()">产品系列</a>
								<ul class="dropdown-menu" style="width: 300px;">
									<c:forEach var="productMenu" items="${productMenus.subItems}">
										<li>
											<div style="min-height: 20px;"><a tabindex="-1" href="${path}${productMenu.url}" style="padding-left: 35px;padding-right: 35px;">${productMenu.name}</a></div>
										</li>
									</c:forEach>
								</ul>
							</li>
							<li class="nav-delim"><col-md->|</col-md-></li>
							<li class="dropdown">
							  	<a id="drop4" role="button" data-toggle="dropdown" href="#" onmouseover="$(this).click()">关于EC</a>
								<ul class="dropdown-menu" style="width: 150px;">
									<li>
									<div style="min-height: 20px;"><a tabindex="-1" href="${path}about_us/summary.html" style="padding-left: 35px;padding-right: 35px;">公司简介</a></div>
									</li>
									<li>
										<div style="min-height: 20px;"><a tabindex="-1" href="${path}about_us/news.html" style="padding-left: 35px;padding-right: 35px;">新闻及公告</a></div>
									</li>
									<li>
										<div style="min-height: 20px;"><a tabindex="-1" href="${path}about_us/download.html" style="padding-left: 35px;padding-right: 35px;">资料下载</a></div>
									</li>
									<li>
										<div style="min-height: 20px;"><a tabindex="-1" href="${path}about_us/certification.html" style="padding-left: 35px;padding-right: 35px;">认证及资质</a></div>
									</li>
									<li>
										<div style="min-height: 20px;"><a tabindex="-1" href="${path}about_us/global_map.html" style="padding-left: 35px;padding-right: 35px;">国际合作</a></div>
									</li>
									<li>
										<div style="min-height: 20px;"><a tabindex="-1" href="${path}about_us/case_list.html" style="padding-left: 35px;padding-right: 35px;">我们的客户</a></div>
									</li>
								</ul>
							</li>
							<li class="nav-delim"><col-md->|</col-md-></li>
							<li class="dropdown">
							  	<a id="drop5" role="button" data-toggle="dropdown" href="#" onmouseover="$(this).click()">联系我们</a>
								<ul class="dropdown-menu" style="width: 150px;">
									<li>
									<div style="min-height: 20px;"><a tabindex="-1" href="${path}contact_us/contact_info.html" style="padding-left: 35px;padding-right: 35px;">联系方式</a></div>
									</li>
									<li>
										<div style="min-height: 20px;"><a tabindex="-1" href="${path}contact_us/tmall.html" style="padding-left: 35px;padding-right: 35px;">天猫旗舰店</a></div>
									</li>
									<li>
										<div style="min-height: 20px;"><a tabindex="-1" href="${path}contact_us/dealer_list.html" style="padding-left: 35px;padding-right: 35px;">授权经销商</a></div>
									</li>
								</ul>
							</li>
							
							<li class="" style="float: right;padding-top: 10px;">
								<img src="${path}img/search.jpg"  class="visible-sm-block text-right" style=""></div>
					   	 	</li>
					      </ul>
					     
					    </div><!-- /.navbar-collapse -->
					  </div><!-- /.container-fluid -->
					</nav>
				</div>
				<div class="col-md-3 col-sm-1 col-xs-0 hidden-sm search" style="margin-top: 7px;">
					<div class=" visible-lg-block visible-md-block" style="position: relative;">
						<input class="col-md-12 search" id="inputIcon" type="text" />
						<img src="${path}img/search.jpg" style="position:absolute;right: 8px;top:7px;"></span>
				  	</div> 
				</div>
			</div>
		</div>
	</div>
</div>
	
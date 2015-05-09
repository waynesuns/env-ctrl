<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<body> <div class="container">
	<div class="row" style="margin-top: 10px;margin-bottom: 8px;">
		<div class="col-md-2 col-sm-2 col-xs-0 hidden-xs hidden-xxs">
			<a href="${path}index.html"><img src="${path}img/logo.png" style="margin-top: 25px;"/></a>
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
						<div class="collapse navbar-collapse" id="navbar-xs-main" style="margin-top: 10px;margin-left: 15px;">
					      <ul class="nav navbar-nav visible-xs-block visible-xxs-block">
					        <li class="gray">
								<a id="drop0" role="button" href="${path}solution/index.html">应用领域</a>
							</li>
							<li class="">
							  <a id="drop2" role="button" href="${path}technology/index.html">优势技术</a>
							</li>
							<li class="gray">
							  <a id="drop3" role="button" href="${path}product/index.html">产品系列</a>
							</li>
							<li class="">
							  <a id="drop4" role="button" href="${path}about_us/index.html">关于IIECC</a>
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
								<a id="drop0" role="button" data-toggle="dropdown" href="#" onmouseover="$(this).click()">应用领域</a>
							    <ul id="drop1" class="dropdown-menu row" style="width: 280px;">
									<c:forEach var="menu" items="${solutionMenus.subItems}">
										<li>
											<div style="min-height: 20px;"><a tabindex="-1" href="${path}${menu.url}" style="padding-left: 35px;padding-right: 35px;">${menu.name}</a></div>
										</li>
									</c:forEach>
								</ul>
							</li>
							<li class="nav-delim"><col-md->|</col-md-></li>
							<li class="dropdown">
							  	<a role="button" data-toggle="dropdown" href="#" onmouseover="$(this).click()">${technologyMenus.subItemTitle}</a>
								<ul class="dropdown-menu" style="width: 280px;">
									<c:forEach var="menu" items="${technologyMenus.subItems}">
										<li>
											<div style="min-height: 20px;"><a tabindex="-1" href="${path}${menu.url}" style="padding-left: 35px;padding-right: 35px;">${menu.name}</a></div>
										</li>
									</c:forEach>
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
							  	<a id="drop4" role="button" data-toggle="dropdown" href="#" onmouseover="$(this).click()">关于IIECC</a>
								<ul class="dropdown-menu" style="width: 150px;">
									<c:forEach var="aboutUsMenu" items="${aboutUsMenus.subItems}">
										<li>
											<div style="min-height: 20px;"><a tabindex="-1" href="${path}${aboutUsMenu.url}" style="padding-left: 35px;padding-right: 35px;">${aboutUsMenu.name}</a></div>
										</li>
									</c:forEach>
								</ul>
							</li>
							<li class="nav-delim"><col-md->|</col-md-></li>
							<li class="dropdown">
							  	<a id="drop5" role="button" data-toggle="dropdown" href="#" onmouseover="$(this).click()">联系我们</a>
								<ul class="dropdown-menu" style="width: 150px;">
									<c:forEach var="contactUsMenu" items="${contactUsMenus.subItems}">
										<li>
											<div style="min-height: 20px;"><a tabindex="-1" href="${path}${contactUsMenu.url}" style="padding-left: 35px;padding-right: 35px;">${contactUsMenu.name}</a></div>
										</li>
									</c:forEach>
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
	
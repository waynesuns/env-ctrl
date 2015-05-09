<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<c:set var="path" value="./" scope="request"/>
<c:import url="/common/header.jsp"/>
<c:import url="/common/navbar.jsp"/>
<!-- content start -->
<!-- content start -->
<div class="jumbotron" style="">
  <div class="container">
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	  </ol>

	  <!-- Wrapper for slides -->
	  <div class="carousel-inner main-title" role="listbox">
	    <div class="item active">
	        <img src="img/kv_1170.png" class="kv kv1" >
	      	<div class="carousel-caption-kv col-sm-6 col-xs-10 hidden-xxs">
	      		<div class="title">APS-550M</div>
				<div class="content">
					<p>双分子筛结构可装填最大重达<font class="red">10000</font>克的气相净化媒体</p>
					<p>总表面积约为<font class="red">6500000</font>平方米，相当于<font class="red">900</font>个足球场的面积</p>
				</div>
				<button class="btn btn-danger" onclick="window.location.href='aps550m/index.html'">了解详情</button>
	      	</div>
	    </div>
	    <div class="item">
	        <img src="img/kv_1170.png" class="kv kv2">
	      	<div class="carousel-caption-kv col-sm-6 col-xs-12 hidden-xxs"><div class="title">99.99%</div>
				<div class="content">
					<p>高效过滤段能够使颗粒物的去除率达到<font class="red">99.99%</font></p>
					<p>全面满足医院空气污染治理需求</p>
				</div>
				<button class="btn btn-danger" onclick="window.location.href='technology/particles_filter.html'">了解详情</button>
	      	</div>
	    </div>
	    <div class="item">
	        <img src="img/kv_1170.png" class="kv kv3">
	      	<div class="carousel-caption-kv col-sm-6 col-xs-10 hidden-xxs"><div class="title">0.05秒彻底净化</div>
				<div class="content">
					<p><font class="red">Multi-Mix</font><sup class="red">®</sup><font class="red" style="padding-left: 3px;">Media</font>气相分子筛</p>
					<p><font class="red">0.05</font>秒彻底去除有毒有害气体</p>
				</div>
				<button class="btn btn-danger" onclick="window.location.href='technology/gas_filter.html'">了解详情</button>
	      	</div>
	    </div>
  </div>

		  <!-- Controls -->
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		    <span><img src="./img/icon/left.png"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		    <span><img src="./img/icon/right.png"></span>
		    <span class="sr-only">Next</span>
		  </a>
	</div>
	
	    <div id="kv_xxs_text" class="carousel-caption-kv visible-xxs-block" style="position: relative;height: 210px;">
	    		
	    </div>
	</div>
	</div>
  <div class="container">
	<div class="row subtitle" style="margin-top: 40px;">
		<div class="col-sm-3 col-xs-6 col-xxs-12">
			<img alt="140x140" src="img/home/homepage_pic_s1.jpg" class="img-responsive" onclick="window.location.href='product/multi_mix.html'" />
			<div class="title" style="text-align: center;"><a href="product/multi_mix.html">Multi-Mix<sup>®</sup> Media气相净化媒体简介</a></div>
		</div>
		<div class="col-sm-3 col-xs-6 col-xxs-12">
			<img alt="140x140" src="img/home/homepage_pic_s2.jpg" class="img-responsive" onclick="window.location.href='about_us/20140930_apic.html'" />
			<div class="title" style="text-align: center;"><a href="about_us/20140930_apic.html">中国空气质量现状</a></div>
		</div>
		<div class="col-sm-3 col-xs-6 col-xxs-12">
			<img alt="140x140" src="img/home/homepage_pic_s3.jpg" class="img-responsive" onclick="window.location.href='solution/industry.html'" />
			<div class="title" style="text-align: center;"><a href="solution/industry.html">案例研究：扬子石化—巴斯夫</a></div>
		</div>
		<div class="col-sm-3 col-xs-6 col-xxs-12">
			<img alt="140x140" src="img/home/homepage_pic_s4.jpg" class="img-responsive"  onclick="window.location.href='product/aps.html'" />
			<div class="title" style="text-align: center;"><a href="product/aps.html">APS系列小型气相净化系统简介</a></div>
		</div>
	</div></div>
</div>
<!-- content end -->

	
	<script>
	$("#kv_xxs_text").html($('#carousel-example-generic').children('.main-title').children('.active').children('.carousel-caption-kv').html());
	$('#carousel-example-generic').on('slide.bs.carousel', function (e) {
		$("#kv_xxs_text").html($(e.relatedTarget).children('.carousel-caption-kv').html());
		  //alert($(this).$active);
		});
	</script>
<c:import url="/common/footer.jsp"/>
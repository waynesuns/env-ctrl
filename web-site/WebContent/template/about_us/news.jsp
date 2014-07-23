<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<hr />
<div class="row">
	<c:forEach begin="1" end="4">
		<div class="col-sm-6 col-xs-6" style="margin-bottom: 40px;">
			<h3>新闻大标题</h3>
			<h5 style="margin-top: 0;color:#666666;margin-bottom: 2px;font-weight: normal;">2014.07.15</h5>
			<p>优势之选不仅仅体现在产品本身的卓越效果，更体现在每个部件的精工细作以及每个合作伙伴的深厚底蕴。我们产品的核心部分供应商，都是经过历史的积累和沉淀，在各自领域里是绝对领先的代名词。这不仅代表了我们的产品在行业内的顶尖地位，更意味着我们将有条件永不停止的在环境控制领域与时俱进，推陈出新，为客户提供全方位的服务。</p>
			<a style="margin-top: 2px;text-decoration: underline;cursor: hand;" class="red">了解更多</a>
		</div>
	</c:forEach>
</div>
<div class="text-center">
<ul class="pagination ">
  <li class="disabled"><a href="#"><</a></li>
  <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
  <li class=""><a href="#">2</a></li>
  <li class=""><a href="#">3</a></li>
  <li class=""><a href="#">4</a></li>
  <li class=""><a href="#">5</a></li>
  <li class=""><a href="#">6</a></li>
  <li class=""><a href="#">7</a></li>
  <li class=""><a href="#">8</a></li>
  <li class=""><a href="#">></a></li>
</ul></div>
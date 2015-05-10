<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
var projectName = '<%= request.getContextPath()%>';
var localUrl = window.location.href;
var shortUrl = localUrl.substring(localUrl.indexOf(projectName)+projectName.length);
if(shortUrl.indexOf("?")>0){
	shortUrl=shortUrl.substring(0, shortUrl.indexOf("?"));
}
	var linkMenu= $("body").find("#side-menu").find("a");
	var divObjMenu;
	for(var i=0;i<linkMenu.length;i++){
		if(shortUrl.indexOf($(linkMenu[i]).attr("role"))>=0){
			divObjMenu=$(linkMenu[i]);
			break ;
		}
	}
	if(divObjMenu){
		var parentObj=$(divObjMenu).parent();
		if($(parentObj).attr("role")=='menu'){
			$(parentObj).addClass("active");
			$(divObjMenu).addClass("current");
		}else{ 
			var categoryId=$(parentObj).attr("id");
			$("#"+categoryId+"[role='category']").addClass("active");
			$("#"+categoryId+"[role='category']").find("ul").addClass("collapse in");
			$("#"+categoryId+"[role='category']").find("ul").show();
			$(divObjMenu).addClass("current");
		}
	}
});
</script>
<nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
					<gh:surveyMenu/>
                </ul>
                <!-- /#side-menu -->
            </div>
            <!-- /.sidebar-collapse -->
        </nav>
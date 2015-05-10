<%@page contentType="text/html"  import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<!-- 网站图标 -->
<link type="image/x-icon" href="favicon.ico" rel="shortcut icon"/>
 <!-- Core CSS - Include with every page -->
 <!-- 全局CSS -->
<link type="text/css" href="<c:url value="/css/global.css"/>" rel="Stylesheet"/>
    <link href="<c:url value="/css/bootstrap/bootstrap.min.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap/bootstrap-theme.min.css"/>" >
    <link href="<c:url value="/css/bootstrap/bootstrap.vertical-tabs.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/font-awesome/font-awesome.min.css" />" rel="stylesheet">
    <!-- Page-Level Plugin CSS - Dashboard -->
    <link href="<c:url value="/css/bootstrap_sbadmin/plugins/dataTables/dataTables.bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap_sbadmin/plugins/timeline/timeline.css"/>" rel="stylesheet">
 	<link href="<c:url value="/css/bootstrap_sbadmin/plugins/morris/morris-0.4.3.min.css"/>" rel="stylesheet">
 	<link href="<c:url value="/css/bootstrap_sbadmin/plugins/social-buttons/social-buttons.css"/>" rel="stylesheet">
    <!-- SB Admin CSS - Include with every page -->
    <link href="<c:url value="/css/bootstrap_sbadmin/sb-admin.css"/>" rel="stylesheet">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap/bootstrap-datetimepicker.min.css"/>" >
	<link type="text/css" href="<c:url value="/css/jqueryui/jquery-ui-1.10.0.custom.css"/>" rel="Stylesheet"/>
	<link type="text/css" href="<c:url value="/css/jqueryui/jquery.ui.1.10.0.ie.css"/>" rel="Stylesheet"/>

	<link type="text/css" href="<c:url value="/css/jqueryui/autocomplete/jquery.ui.autocomplete.css"/>" rel="Stylesheet"/>
	<!-- multiselect -->
<link type="text/css" href="<c:url value="/css/multiSelect/jquery.multiselect.css"/>" rel="Stylesheet"/>
<link type="text/css" href="<c:url value="/css/multiSelect/jquery.multiselect.filter.css"/>" rel="Stylesheet"/>

<!-- TextboxList -->
<link type="text/css" href="<c:url value="/css/textboxList/TextboxList.css"/>" rel="Stylesheet"/>
<link type="text/css" href="<c:url value="/css/textboxList/TextboxList.Autocomplete.css"/>" rel="Stylesheet"/>
<script type="text/javascript" src="<c:url value="/js/jquery/jquery-1.10.2.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/jquery.browser.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/ui/jquery-ui-1.10.4.custom.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/ui/bootstrap/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/ui/bootstrap/plugin/bootstrap.teninedialog.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/ui/bootstrap/plugin/bootstrap-datetimepicker.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/ui/bootstrap/plugin/bootstrap-datetimepicker.zh-CN.js"/>" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/bootstrap_sbadmin/plugins/metisMenu/jquery.metisMenu.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/bootstrap_sbadmin/sb-admin.js"/>"></script>
<!-- jQuery Form -->
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/form/jquery.form.js"/>"></script>
<!-- DataTable -->
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/dataTables1.9.4/jquery.dataTables.min.js"/>"></script>
<%-- <script type="text/javascript" src="<c:url value="/js/jquery/plugin/dataTables1.9.4/AutoFill.min.js"/>"></script> --%>
<%-- <script type="text/javascript" src="<c:url value="/js/jquery/plugin/dataTables1.9.4/ColReorder.min.js"/>"></script> --%>
<%-- <script type="text/javascript" src="<c:url value="/js/jquery/plugin/dataTables1.9.4/dataTables.scroller.min.js"/>"></script> --%>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/dataTables1.9.4/FixedColumns.min.js"/>"></script>
<%-- <script type="text/javascript" src="<c:url value="/js/jquery/plugin/dataTables1.9.4/FixedHeader.min.js"/>"></script> --%>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/dataTables1.9.4/jquery.dataTables.columnFilter.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/dataTables1.9.4/jquery.dataTables.reload.js"/>"></script>
<%-- <script type="text/javascript" src="<c:url value="/js/jquery/plugin/dataTables1.9.4/KeyTable.min.js"/>"></script> --%>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/bootstrap_sbadmin/plugins/dataTables/dataTables.bootstrap.js"/>"></script>
<!-- jQuery Validation -->
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/validation/jquery.validate.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/validation/additional-methods.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/validation/messages_cn.js"/>"></script>
<!-- multiselect -->
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/multiSelect/jquery.multiselect.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/multiSelect/jquery.multiselect.filter.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/textboxList/TextboxList.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/textboxList/TextboxList.Autocomplete.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/textboxList/TextboxList.Autocomplete.Binary.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/plugin/charcount/charCount.js"/>"></script>
<!-- Global -->
<script type="text/javascript" src="<c:url value="/js/action/global.js"/>"></script>
<!-- common -->
<script type="text/javascript" src="<c:url value="/js/action/common.js"/>"></script>
<!-- homePage -->
<script type="text/javascript" src="<c:url value="/js/action/home/homepage.js"/>"></script>	
<script type="text/javascript" src="<c:url value="/js/action/qtip/validation/qtip-validation.js"/>"></script>	
<!--[if lt IE 9]>
        <script src="<c:url value="/js/html5shiv/html5shiv.js" />"></script>
        <script src="<c:url value="/js/respond/respond.min.js" />"></script>
    <![endif]-->
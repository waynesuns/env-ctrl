<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<script type="text/javascript">
var selectedText = '<fmt:message key="selected.text"/>';
var selectedMessage = '<fmt:message key="selected.message"/>';
var checkAllText = '<fmt:message key="selected.check.all.text"/>';
var unCheckAllText = '<fmt:message key="selected.uncheck.all.text"/>';
var filterText = '<fmt:message key="common.colon"><fmt:param><fmt:message key="selected.filter.name"/></fmt:param></fmt:message>';
var error403 = '<fmt:message key="error.security.message"/>';
//品牌、大区、省份、城市、网点、级联 
var optionAllHTML = '<option value="0" selected="selected"><fmt:message key="common.all" /></option>';
var optionPleaseSelectHTML = '<option value="0" selected="selected"><fmt:message key="common.please.select" /></option>';
var brandURL = '<c:url value="/area_city_casc/show/brand.do"/>';
var dealerAreaURL = '<c:url value="/area_city_casc/show/dealer_area.do"/>';
var provinceURL = '<c:url value="/area_city_casc/show/province.do"/>';
var cityURL = '<c:url value="/area_city_casc/show/city.do"/>';
</script>

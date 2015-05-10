<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<jsp:include page="script.jsp" />
<script type="text/javascript">
</script>
<div class="right">
<div class="right_c">
<h1><fmt:message key="system.management"/> >> <a href="menu/show/home.do"><fmt:message key="menu.menu" /></a></h1>
 <table id="menu_list"  class="menu_table"  border="0" cellspacing="0" cellpadding="0" >
 <thead>
   <tr>
	   <th width="200"><fmt:message key="common.name" /></th>
	   <th width="40" ><fmt:message key="menu.code" /></th>
	   <th width="100" ><fmt:message key="role.authorize" /></th>
	   <th width="320" ><fmt:message key="menu.path" /></th>
	   <th width="110"><fmt:message key="state" /></th>
	   <th> id</th>
	   <th> className</th>
	   <th> img</th>
	   <th> url</th>
	   <th> parentId</th>
   </tr>
 </thead>
<tbody>
</tbody>
</table>
 <div class="cl"></div>
 <div class="l  mt10" >
	<%-- <c:if test="${gh:buttonPermission('100031')}"> --%>
 		<input type="button" class="btn4 l" onclick="showC()" value="<fmt:message key="menu.category.add" />" />
 	<%-- </c:if>
 	<c:if test="${gh:buttonPermission('100032')}"> --%>
 		<input type="button" class="btn4 l"  onclick="showM()" style="margin-right:10px" value="<fmt:message key="menu.add" />" />
	<%-- </c:if> --%>
 </div>
 <div class="cl"></div>
<form id="menu_category_form" action="menu/add/category.do" method="post">
<div class="new" id="new_category" style="display: none;">
		<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.category.name"/></fmt:param></fmt:message></dt><dd><input  name="name" maxlength="20" class="required" style="width:300px" type="text" /><input type="hidden" id="orderNumber" name="orderNumber" value="" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>
		<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.code"/></fmt:param></fmt:message></dt><dd><input maxlength="10" name="code" class="required" style="width:300px" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>
		<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="common.img"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="50" style="width:300px" name="imgPath" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>
		<!-- <li>编号:<input  name="" type="text" /><span class="ml13">菜单名称:</span><input  name="" type="text" /><span class="ml13">访问地址：</span><input  style="width:300px" name="" type="text" />
			</li>
		<li id="firstMenu">编号:<input  name="" type="text" /><span  class="ml13" style=" margin-right:23px">按钮:</span><input  name="" type="text" /><span class="ml13">访问地址：</span><input  style="width:300px" name="" type="text" /><img onclick="addOption('firstMenu')" src="images/add_menu1.png" alt="" />
			</li> -->
		<dl><dd><input type="button" class="btn1 l" onclick="addCategory('menu_category_form')" value="<fmt:message key="common.new"/>" /><a onclick="hideElement('new_category')" ><fmt:message key="bbs.button.close"/></a>
			</dd></dl>
</div>
</form>
<form id="menu_form" action="menu/add/menu.do" method="post">
<div class="new" id="new_menu" style="display: none;">
		<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.name"/></fmt:param></fmt:message></dt><dd><input maxlength="20" class="required" name="name" type="text" style="width:300px" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>
		<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.code"/></fmt:param></fmt:message></dt><dd><input maxlength="10"  name="code" class="required" style="width:300px" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>
		<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="role.authorize"/></fmt:param></fmt:message></dt><dd><select id="role_list_other" style="width:300px" name="roleId"  multiple="multiple"/></select></dd></dl>
		<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="common.img"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="50" style="width:300px" name="imgPath" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>
		<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.path"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="50" style="width:300px" name="path" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>
		<dl><dt><fmt:message key="common.colon"><fmt:param><fmt:message key="menu.url.expression"/></fmt:param></fmt:message></dt><dd><input class="required" maxlength="50"  style="width:300px" name="value" type="text" onkeypress="if(event.keyCode==13){return false;}"/></dd></dl>
		<dl><dd><input class="btn1 l" type="button"  onclick="addMenuOther('menu_form')" value="<fmt:message key="common.new"/>" /><a onclick="hideElement('new_menu')" ><fmt:message key="bbs.button.close"/></a></dd></dl>
</div>
</form>
</div> 
</div> <!-- 全局div结束 -->
<select id="role_list"  multiple="multiple" style="display: none;">
</select>



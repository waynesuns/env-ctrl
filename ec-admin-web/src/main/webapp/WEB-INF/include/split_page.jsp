<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>

<c:set var="pageFunc"><c:out value="${getData}" default="getData"/></c:set>
<div style="text-align:right">
			<c:if test="${pages.currentPage != 1}"><img class="png_bg" src="${template}/images/pages/first.png" title="<fmt:message key="button.firstPage"/>" border="0" style="cursor:pointer" onclick="${pageFunc}(1)"/></c:if>
			<c:if test="${pages.currentPage == 1}"><img class="png_bg" src="${template}/images/pages/first_disable.png" title="<fmt:message key="button.firstPage"/>" border="0"/></c:if>

			<c:if test="${pages.currentPage > 1}"><img class="png_bg" src="${template}/images/pages/previous.png" title="<fmt:message key="button.prevPage"/>" border="0" style="cursor:pointer" onclick="${pageFunc}(${pages.currentPage - 1})"/></c:if>
			<c:if test="${pages.currentPage == 1}"><img class="png_bg" src="${template}/images/pages/previous_disable.png" title="<fmt:message key="button.prevPage"/>" border="0"/></c:if>
			<span >Page ${pages.currentPage} of ${pages.totalPage}</span><input type="hidden" id="currentPage" name="currentPage" value="${pages.currentPage}">
			<c:if test="${pages.currentPage < pages.totalPage}"><img class="png_bg" src="${template}/images/pages/next.png" title="<fmt:message key="button.nextPage"/>" border="0" style="cursor:pointer" onclick="${pageFunc}(${pages.currentPage + 1})"/></c:if>
			<c:if test="${pages.currentPage == pages.totalPage}"><img class="png_bg" src="${template}/images/pages/next_disable.png" title="<fmt:message key="button.nextPage"/>" border="0"/></c:if>

			<c:if test="${pages.currentPage < pages.totalPage}"><img class="png_bg" src="${template}/images/pages/last.png" title="<fmt:message key="button.lastPage"/>" border="0" style="cursor:pointer" onclick="${pageFunc}(${pages.totalPage})"/></c:if>
			<c:if test="${pages.currentPage == pages.totalPage}"><img class="png_bg" src="${template}/images/pages/last_disable.png" title="<fmt:message key="button.lastPage"/>" border="0"/></c:if>
			
	<%
		String pageNumId = "idGOPage" + System.currentTimeMillis();
		pageContext.setAttribute("pageNumId", pageNumId);
	%>
			<input id="${pageNumId}" type="text" size="3">
			<a href="javascript:void(0)" onclick="goPage('${pageNumId}', ${pages.totalPage}, ${pageFunc})">翻页</a>
</div>
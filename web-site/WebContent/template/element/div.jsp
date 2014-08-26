<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<c:if test="${paramGroup.title != null}">
<div class="sample-title">${paramGroup.title}</div>
</c:if>
<c:if test="${paramGroup.desc != null}">
<div class="info">${paramGroup.desc}</div>
</c:if>
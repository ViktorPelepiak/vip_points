<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="com.vip.points.model.UserRole" %>

<jsp:include page="includeResources.jsp"/>
<jsp:useBean id="roles" class="com.vip.points.model.UserRole" scope="session"/>

<link rel="stylesheet" href="<c:url value="/resources/css/include/header.css"/>">

<title>Lab3</title>

<div class="custom-header">
    <nav class="navbar navbar-expand-lg navbar-light bg-white" style="width: 100%; padding-left: 10%; padding-bottom: 0; padding-top: 0; border-bottom: 1px lightgray solid;">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/" style="margin-right: 5px">Minsk-1</a>

        <c:if test="${user == null}">
            <div class="header-text" style="margin-left: auto;">
                <a href="${pageContext.request.contextPath}/login" style="font-weight: bold" class="translatable">Увійти</a>
            </div>
        </c:if>
        <c:if test="${user != null}">
            <input id="loggedUserEmail" type="text" value="${user.email}" hidden>
            <div class="btn-group header-text" style="margin-left: auto;">
                <div style="display: flex;">
                    <div class="translatable">Вітаємо</div>
                    <div>,&nbsp;</div>
                    <div style="font-weight: bold">${user.nameOnSite}</div>
                </div>
            </div>
            <div>
                <button class="btn btn-info" onclick="logout()" style="margin-left: 3rem;">Вийти з профілю</button>
            </div>
        </c:if>
    </nav>
</div>

<script src="<c:url value="/resources/js/logout.js"/>"></script>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="include/header.jsp"/>

<center>
    <div style="margin-top: 10rem; font-size: 3rem">
        Ласкаво просимо до сервісу управління польотами
    </div>

    <c:if test="${user.role.equals(roles.dispatcher)}">
        <a class="dropdown-item translatable" href="${contextPath}/flying_crew">Перейти до формування льотної бригади</a>
    </c:if>

    <c:if test="${user.role.equals(roles.admin)}">
        <a class="dropdown-item translatable" href="${contextPath}/flying_administration">Перейти до управління польотами</a>
    </c:if>
</center>

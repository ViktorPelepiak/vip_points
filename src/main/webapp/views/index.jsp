<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<jsp:include page="include/header.jsp"/>--%>

<%--<center>--%>
<%--    <div style="margin-top: 10rem; font-size: 3rem">--%>
<%--        Ласкаво просимо до сервісу управління польотами--%>
<%--    </div>--%>

<%--    <c:if test="${user.role.equals(roles.dispatcher)}">--%>
<%--        <a class="dropdown-item translatable" href="${contextPath}/flying_crew">Перейти до формування льотної бригади</a>--%>
<%--    </c:if>--%>

<%--    <c:if test="${user.role.equals(roles.admin)}">--%>
<%--        <a class="dropdown-item translatable" href="${contextPath}/flying_administration">Перейти до управління польотами</a>--%>
<%--    </c:if>--%>
<%--</center>--%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <title>HomePage</title>
</head>
<body>
<h3 style="text-align:center;">Authentication</h3>
<br>
<br>
<form style="text-align:center;" action="/secure_page">
    <input type="submit" value="Login" class="btn btn-primary">
</form>

</body>
</html>
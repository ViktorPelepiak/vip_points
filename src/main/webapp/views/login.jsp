<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="include/header.jsp"/>

<div class="card text-center font-registration main-card">
    <div class="card card-body">
        <div class="card card-body">
            <div id="myTabContent" style="margin-top: 2px; padding: 1rem; background: #f9f9f9;">
                <div class="tab-pane fade show active" id="registerContainer" role="tabpanel"
                     aria-labelledby="register-tab">
                    <div class="alert alert-danger" role="alert" id="errorMessage"
                         style="display: none; margin-top: 2rem;">
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <input type="text" class="input font-registration form-control translatable" id="loginInput" placeholder="Логін"
                               style="min-height: 3rem;">
                    </div>
                    <div class="form-group">
                        <input type="password" class="input font-registration form-control translatable" id="passInput" placeholder="Пароль"
                               style="min-height: 3rem;">
                    </div>
                    <button type="button" class="next-step-button font-registration btn btn-success translatable" style="min-height: 3rem; width: 50%"
                            onclick="login()">Увійти
                    </button>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/resources/js/login.js"/> "></script>
</div>

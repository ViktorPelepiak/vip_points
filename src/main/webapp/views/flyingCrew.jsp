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
                    <div style="margin-top: 2rem; font-size: 3rem">
                        Формування льотної бригади
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <label for="firstPilotSelect">Перший пілот</label>
                        <select type="text" class="input font-registration form-control translatable" id="firstPilotSelect"
                               style="min-height: 3rem;">
                        </select>
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <label for="secondPilotSelect">Другий пілот</label>
                        <select type="text" class="input font-registration form-control translatable" id="secondPilotSelect"
                               style="min-height: 3rem;">
                        </select>
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <label for="radiomanSelect">Радист</label>
                        <select type="text" class="input font-registration form-control translatable" id="radiomanSelect"
                               style="min-height: 3rem;">
                        </select>
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <label for="navigatorSelect">Штурман</label>
                        <select type="text" class="input font-registration form-control translatable" id="navigatorSelect"
                               style="min-height: 3rem;">
                        </select>
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <label for="firstStewardSelect">Перша стюардеса</label>
                        <select type="text" class="input font-registration form-control translatable" id="firstStewardSelect"
                               style="min-height: 3rem;">
                        </select>
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <label for="secondStewardSelect">Друга стюардеса</label>
                        <select type="text" class="input font-registration form-control translatable" id="secondStewardSelect"
                               style="min-height: 3rem;">
                        </select>
                    </div>
                    <button type="button" class="next-step-button font-registration btn btn-success translatable" style="min-height: 3rem; width: 50%"
                            onclick="createCrew()">Зформувати бригаду
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/js/flyingCrew.js"/>"></script>
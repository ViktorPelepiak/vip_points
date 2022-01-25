<%--
  Created by IntelliJ IDEA.
  User: ViktorPelepiak
  Date: 01.06.2021
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
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

                    <div class="form-group" style="margin-top: 3rem; display: none;">
                        <label for="flightId">Рейс</label>
                        <input type="text" class="input font-registration form-control translatable" id="flightId"
                                style="min-height: 3rem;" value="${flight.id}" disabled>
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <label for="crew">Льотна бригада</label>
                        <input type="text" class="input font-registration form-control translatable" id="crew"
                                style="min-height: 3rem;" value="${flight.crew.firstPilot}|${flight.crew.secondPilot}|${flight.crew.navigator}|${flight.crew.radioman}|${flight.crew.firstSteward}|${flight.crew.secondSteward}" disabled>
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <label for="cityFrom">Аеропорт відправки</label>
                        <input type="text" class="input font-registration form-control translatable" id="cityFrom"
                               style="min-height: 3rem;" value="${flight.cityFrom}" disabled>
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <label for="cityTo">Аеропорт призначення</label>
                        <input type="text" class="input font-registration form-control translatable" id="cityTo"
                               style="min-height: 3rem;" value="${flight.cityTo}" disabled>
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <label for="datetimeDeparture">Час відправки</label>
                        <input type="datetime-local" class="input font-registration form-control translatable"
                               id="datetimeDeparture"
                               style="min-height: 3rem;" value="${flight.departure.toString()}" disabled>
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <label for="datetimeArrive">Час прибуття</label>
                        <input type="datetime-local" class="input font-registration form-control translatable"
                               id="datetimeArrive"
                               style="min-height: 3rem;" value="${flight.arrival.toString()}" disabled>
                    </div>
                    <div class="form-group" style="margin-top: 3rem;">
                        <select type="text" class="input font-registration form-control translatable" id="status"
                                style="min-height: 3rem;">
                            <c:forEach var="status" items="${statuses}">
                                <option value="${status}" <c:if test="${status==flight.status}"> selected </c:if>>${status}</option>
                            </c:forEach>
                        </select>
                        <label for="status">Статус</label>
                    </div>

                    <button type="button" class="next-step-button font-registration btn btn-success translatable"
                            style="min-height: 3rem; width: 50%" onclick="manageFlight()">
                        Змінити статус
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/js/flights.js"/>"></script>



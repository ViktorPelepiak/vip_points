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
                        Наявні рейси
                    </div>

                    <table>
                        <c:forEach var="flight" items="${flights}">
                            <tr>
                                <td>
                                    ${flight.firstPilot}
                                </td>
                                <td>
                                    ${flight.secondPilot}
                                </td>
                                <td>
                                    ${flight.navigator}
                                </td>
                                <td>
                                    ${flight.radioman}
                                </td>
                                <td>
                                    ${flight.firstSteward}
                                </td>
                                <td>
                                    ${flight.secondSteward}
                                </td>
                                <td>
                                    ${flight.from}
                                </td>
                                <td>
                                    ${flight.to}
                                </td>
                                <td>
                                    ${flight.departure}
                                </td>
                                <td>
                                    ${flight.arrival}
                                </td>
                                <td>
                                    ${flight.status}
                                </td>
                                <td>
                                    <button class="btn btn-info" onclick="manage(${flight.id})">Редагувати</button>
                                </td>
                            </tr
                        </c:forEach>
                    </table>

                    <button type="button" class="next-step-button font-registration btn btn-success translatable"
                            style="min-height: 3rem; width: 50%"
                            onclick="createFlight()">Додати рейс
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/js/flights.js"/>"></script>

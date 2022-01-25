var firstPilots = [];
var secondPilots = [];
var radiomen = [];
var navigators = [];
var stewards = [];

var firstPilotSelect = document.getElementById("firstPilotSelect");
var secondPilotSelect = document.getElementById("secondPilotSelect");
var radiomanSelect = document.getElementById("radiomanSelect");
var navigatorSelect = document.getElementById("navigatorSelect");
var firstStewardSelect = document.getElementById("firstStewardSelect");
var secondStewardSelect = document.getElementById("secondStewardSelect");

$(document).ready(function () {
    getPilots();
    getRadiomen();
    getNavigators();
    getStewards()
});

function getPilots() {
    return $.ajax({
        url: contextPath + "/pilot/all",
        type: "get",
        contentType: "application/json"
    }).done(
        function (data) {
            if (data.success === true) {

                var pilots = data.result;
                for (var i = 0; i < pilots.length; i++) {
                    var pilot = pilots[i];
                    if (pilot.firstPilot === true) {
                        firstPilots.push(pilot);
                        firstPilotSelect.innerHTML = firstPilotSelect.innerHTML
                            + "<option value='" + pilot.id + "'>" + pilot.name + "</option>";
                    } else {
                        secondPilots.push(pilot);
                        secondPilotSelect.innerHTML = secondPilotSelect.innerHTML
                            + "<option value='" + pilot.id + "'>" + pilot.name + "</option>";
                    }
                }

                return pilots;
            } else {
                return null;
            }
        }
    ).fail(function () {
        return null;
    })
}

function getNavigators() {
    return $.ajax({
        url: contextPath + "/navigator/all",
        type: "get",
        contentType: "application/json"
    }).done(
        function (data) {
            if (data.success === true) {

                navigators = data.result;
                for (var i = 0; i < navigators.length; i++) {
                    var navigator = navigators[i];
                    navigatorSelect.innerHTML = navigatorSelect.innerHTML
                        + "<option value='" + navigator.id + "'>" + navigator.name + "</option>";
                }

                return navigators;
            } else {
                return null;
            }
        }
    ).fail(function () {
        return null;
    })
}

function getRadiomen() {
    return $.ajax({
        url: contextPath + "/radioman/all",
        type: "get",
        contentType: "application/json"
    }).done(
        function (data) {
            if (data.success === true) {

                radiomen = data.result;
                for (var i = 0; i < radiomen.length; i++) {
                    var radioman = radiomen[i];
                    radiomanSelect.innerHTML = radiomanSelect.innerHTML
                        + "<option value='" + radioman.id + "'>" + radioman.name + "</option>";
                }

                return radiomen;
            } else {
                return null;
            }
        }
    ).fail(function () {
        return null;
    })
}

function getStewards() {
    return $.ajax({
        url: contextPath + "/steward/all",
        type: "get",
        contentType: "application/json"
    }).done(
        function (data) {
            if (data.success === true) {

                stewards = data.result;
                for (var i = 0; i < stewards.length; i++) {
                    var steward = stewards[i];
                    firstStewardSelect.innerHTML = firstStewardSelect.innerHTML
                        + "<option value='" + steward.id + "'>" + steward.name + "</option>";
                    secondStewardSelect.innerHTML = secondStewardSelect.innerHTML
                        + "<option value='" + steward.id + "'>" + steward.name + "</option>";
                }

                return stewards;
            } else {
                return null;
            }
        }
    ).fail(function () {
        return null;
    })
}

function createCrew() {
    var firstPilotId = document.getElementById("firstPilotSelect").value;
    var secondPilotId = document.getElementById("secondPilotSelect").value;
    var radiomanId = document.getElementById("radiomanSelect").value;
    var navigatorId = document.getElementById("navigatorSelect").value;
    var firstStewardId = document.getElementById("firstStewardSelect").value;
    var secondStewardId = document.getElementById("secondStewardSelect").value;

    $.ajax({
        url: contextPath + "/crew/save",
        type: "POST",
        data: JSON.stringify({
            "firstPilotId": firstPilotId,
            "secondPilotId": secondPilotId,
            "radiomanId": radiomanId,
            "navigatorId": navigatorId,
            "firstStewardId": firstStewardId,
            "secondStewardId": secondStewardId
        }),
        contentType: "application/json"
    }).done(function (data) {
        window.location.href = contextPath + "/";
        if (data.success === true) {

            window.location.href = contextPath + "/";
        } else {
            var errorMessage = "";
            if (data.message === null || data.message === undefined) {
                errorMessage = "Unexpected error just occurred.";
            } else {
                errorMessage = data.message;
            }
        }
    }).fail(function (data) {
        if (data.success === true) {

            window.location.href = contextPath + "/";
        } else {
            var errorMessage = "";
            if (data.message === null || data.message === undefined) {
                errorMessage = "Unexpected error just occurred.";
            } else {
                errorMessage = data.message;
            }
        }
    })
}
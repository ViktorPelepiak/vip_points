function manage(id) {
    window.location.href = contextPath + "/flight/manage/" + id;
}

function createFlight() {
    window.location.href = contextPath + "/flight/editor";
}

function addNewFlight() {
    console.log("adding new flight")
    var crewId = document.getElementById("crew").value;
    var cityFrom = document.getElementById("cityFrom").value;
    var cityTo = document.getElementById("cityTo").value;
    var datetimeDeparture = document.getElementById("datetimeDeparture").value;
    var datetimeArrive = document.getElementById("datetimeArrive").value;
    var status = document.getElementById("status").value;

    $.ajax({
        url: contextPath + "/flight/save",
        type: "post",
        data: JSON.stringify({
            "crewId" : crewId,
            "cityFrom" : cityFrom,
            "cityTo" : cityTo,
            "datetimeDeparture" : datetimeDeparture,
            "datetimeArrive" : datetimeArrive,
            "status" : status
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

function manageFlight() {
    var flightId = document.getElementById("flightId").value;
    var status = document.getElementById("status").value;


    $.ajax({
        url: contextPath + "/flight/manage",
        type: "post",
        data: JSON.stringify({
            "id" : flightId,
            "status" : status
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
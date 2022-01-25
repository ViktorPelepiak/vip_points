function login() {
    var login = document.getElementById("loginInput").value;
    var password = document.getElementById("passInput").value;

    var errorDiv = document.getElementById("errorMessage");

    $.ajax({
        url: contextPath + "/user/login",
        type: "post",
        data: JSON.stringify({
            "login" : login,
            "password": password
        }),
        contentType: "application/json"
    }).done(function (data) {
        if(data.success === true) {
            errorDiv.style.display = "none";

            window.location.href = contextPath + "/";
        } else {
            var errorMessage = "";
            if(data.message === null || data.message === undefined) {
                errorMessage = "Unexpected error just occurred.";
            } else {
                errorMessage = data.message;
            }

            errorDiv.innerText = errorMessage;
            errorDiv.style.display = "";
        }
    }).fail(function (data) {
        var errorMessage = "";
        var result = data.responseJSON;
        if(result === undefined || result.message === null || result.message === undefined) {
            errorMessage = "Unexpected error just occurred.";
        } else {
            errorMessage = result.message;
        }

        errorDiv.innerText = errorMessage;
        errorDiv.style.display = "";
    });
}

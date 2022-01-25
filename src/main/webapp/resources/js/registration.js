function registration() {
    var name = document.getElementById("loginInput").value;
    var email = document.getElementById("emailInput").value;
    var phoneNumber = document.getElementById("phoneInput").value;
    var dateOfBirth = document.getElementById("dobInput").value.split("-");
    var password = document.getElementById("passInput").value;
    var passwordConfirmation = document.getElementById("passInputConfirmation").value;
    var role = "DISPATCHER";
    var enabled = true;

    console.log("registration");
    if (name && email && phoneNumber && dateOfBirth && password && passwordConfirmation
        && password === passwordConfirmation) {

        $.ajax({
            url: contextPath + "/user/registration",
            type: "post",
            data: JSON.stringify({
                "name": name,
                "email": email,
                "phoneNumber": phoneNumber,
                "dob_date": dateOfBirth[2],
                "dob_month": dateOfBirth[1],
                "dob_year": dateOfBirth[0],
                "password": password,
                "passwordConfirmation": passwordConfirmation,
                "role": role,
                "enabled": enabled
            }),
            contentType: "application/json"
        }).done(function (data) {
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
}
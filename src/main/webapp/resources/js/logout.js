var logout = function () {
    $.ajax({
        url: contextPath + "/user/logout",
        type: "post"
    }).done(function () {
        window.location.href = contextPath;
    }).fail(function () {
        window.location.href = contextPath;
    });
};

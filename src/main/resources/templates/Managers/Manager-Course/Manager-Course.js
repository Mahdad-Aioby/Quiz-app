
function showCourseCreateModalForm() {
    $("#createCourse").modal('toggle');
}


function addCourseByManager() {
    const username = window.authenticatedUsername;
    const password = window.authenticatedPassword;
    const courseTitle = $("#course-created-title").val();
    const startDate = $("#course-created-start").val();
    const endDate = $("#course-created-end").val();
    const newCourseCommand = {
        "courseTitle": courseTitle,
        "startDate": startDate,
        "endDate": endDate,
    }
    jQuery.ajax({
        url: serverUrl() + "/manager/create-course",
        type: "POST",
        data: JSON.stringify(newCourseCommand),
        contentType: "application/json; charset=utf-8",
        headers: {
            "Authorization": "Basic " + btoa(username + ":" + password)
        },
        success: function (data, textStatus) {
            if (data.message !== null) {
                showEditMessage(data.message);
                loadAllCourseForManager();
            } else {
                alert("some things went wrong");
            }
        },
        error: function (errorMessage) {
            alert("some things went wrong!");
        }
    });
    $("#createCourse").modal('hide');

}
$(document).delegate('#add-appt-form', 'submit', function (e) {
    e.preventDefault();
    console.log(e);

    let newAppt = new Appointment({
        'appointment_id': null,
        'apptName': e.target[0].value,
        'apptType': e.target[1].value,
        'description': e.target[2].value,
        'startTime': e.target[3].value,
        'endTime': e.target[4].value,
        'metaData': e.target[5].value
    });
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "/api/v1/mgr/post/appt/",
        data: newAppt.toJSON(),
        cache: false,
        success: function (result) {
            console.log(result);
            alert("Appointment added successfully.")
        },
        error: function (err) {
            alert("Appointment add failed.")
        }
    });
});
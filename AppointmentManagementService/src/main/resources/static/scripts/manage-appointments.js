let apptList = [];
let loggedInID = -1;
let $table;

$(document).ready(function () {
    $table = $('table');
    loggedInID = parseInt(sessionStorage.getItem('user-id'));
    console.log(loggedInID);
    $.getJSON('/api/v1/mgr/getappts', function (json) {
        for (var i = 0; i < json.length; i++) {
            let appt = new Appointment(json[i]);
            // console.log(appt.toJSON());
            $table.append(appt.toTableRow(true));
            apptList.push(appt);
        }
        console.log(apptList);
    });
});
$(document).delegate('.edit-appt', 'click', function (e) {
    e.preventDefault();
});
$(document).delegate('#add-appt', 'click', function (e) {
    e.preventDefault();
    console.log('adding appt');
    let newAppt = new Appointment({
        'appointment_id': null,
        'apptName': 'testAdd',
        'apptType': 'experimental',
        'description': 'there is nothing to fear',
        'startTime': '2018-12-12T13:30:30',
        'endTime': '2018-12-12T14:30:30',
        'metaData': null
    });
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "/api/v1/mgr/post/appt/",
        data: newAppt.toJSON(),
        cache: false,
        success: function(result) {
            // $("#msg").html( "<span style='color: green'>Company added successfully</span>" );
            // window.setTimeout(function(){location.reload()},1000)
            console.log(result);
            // location.reload();
        },
        error: function(err) {
        }
    });
});
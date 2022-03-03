let apptList = [];
let $table;

$(document).ready(function () {
    $table = $('table');
    console.log(State.LiveID);
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
    const apptID = e.target.value;
    const appt = apptList.find<Appointment>(a => a.appointment_id == apptID);
    const row = document.getElementById(apptID);
    console.log(`${apptID} :: ${appt} :: ${row}`);

});
$(document).delegate('.delete-appt', 'click', function (e) {
    e.preventDefault();
    let apptID = e.target.value;
    $.ajax({
        type: "DELETE",
        url: "/api/v1/mgr/delete/appt/" + apptID,
        cache: false,
        success: function(result) {
            console.log(result);
            location.reload(true);
        },
        error: function() {
        }
    });

});
$(document).delegate('#add-appt', 'click', function (e) {
    e.preventDefault();
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
            console.log(result);
        },
        error: function(err) {
        }
    });
});
let apptList = [];
let $table;

$(document).ready(function () {
    $table = $('table');
    console.log(State.LiveID);
    $.getJSON(`/api/v1/mgr/${State.LiveID}/getappts`, function (json) {
        console.log(json);
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

    //TODO
});


$(document).delegate('.unrsvp-appt', 'click', function (e) {
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

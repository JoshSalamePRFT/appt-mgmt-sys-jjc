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
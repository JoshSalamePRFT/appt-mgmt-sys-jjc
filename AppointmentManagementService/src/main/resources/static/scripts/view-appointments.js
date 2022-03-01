let apptList = [];
let $table;
let loggedInID;

$(document).ready(function () {
    $table = $('table');
    loggedInID = parseInt(sessionStorage.getItem('user-id'));
    $.getJSON('/api/v1/mgr/getappts', function (json) {
        var trs = [];
        for (var i = 0; i < json.length; i++) {
            let appt = new Appointment(json[i]);
            // console.log(appt.toJSON());
            $table.append(appt.toTableRow(false, true));
            apptList.push(appt);
        }
        console.log(apptList);
    });
});
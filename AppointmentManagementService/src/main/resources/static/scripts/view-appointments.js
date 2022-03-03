let apptList = [];
let $table;

$(document).ready(function () {
    $table = $('table');
    console.log(State.LiveID);
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
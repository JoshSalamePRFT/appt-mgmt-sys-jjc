let apptList = [];

$(document).ready(function () {
    $.getJSON('/api/v1/mgr/getappts', function (json) {
        var trs = [];
        for (var i = 0; i < json.length; i++) {
            let appt = new Appointment(json[i]);
            trs.push(appt.toTableRow(true));
            // console.log(appt.toJSON());
            apptList.push(appt);
        }
        $('table').append($(trs.join('')));
        console.log(apptList);
    });
});
$(document).ready(function () {
    console.log("starting user page");
    $.getJSON('/api/v1/mgr/getappts', function (json) {
        var trs = [];
        for (var i = 0; i < json.length; i++) {
            let appt = new Appointment(json[i]);
            console.log(appt);
            console.log(appt.toString());
            trs.push(appt.toTableRow());
            // tr.push(`<td><button class='edit'>Edit</button>&nbsp;&nbsp;<button class='delete' id=${json[i].id}>Delete</button></td></tr>`);
        }
        $('table').append($(trs.join('')));
    });
});
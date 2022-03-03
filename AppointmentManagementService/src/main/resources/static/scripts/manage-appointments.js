let apptList = [];
let $table;

$(document).ready(function () {
    $table = $('table');
    console.log(State.LiveID);
    $.getJSON(`/api/v1/mgr/${State.LiveID}/getappts`, function (json) {
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
    //TODO
});


$(document).delegate('.delete-appt', 'click', function (e) {
    e.preventDefault();
    let apptID = e.target.id;
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

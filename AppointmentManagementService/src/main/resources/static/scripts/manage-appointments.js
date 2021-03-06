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
            $table.append(appt.toTableRow(false, true));
            apptList.push(appt);
        }
        console.log(apptList);
    });
});

$(document).delegate('.unrsvp-appt', 'click', function (e) {
    //TODO change mapping to delete from users_appts
    e.preventDefault();
    let apptID = e.target.value;
    $.ajax({
        type: "DELETE",
        url: "/api/v1/mgr/remove-user-from-appt/" + State.LiveID + "/" + apptID,
        cache: false,
        success: function() {
            location.reload();
        },
        error: function() {
            //This shouldn't happen, as it only shows you values in the table, hence they should be deletable. But, fill anyway.
        }
    });
});

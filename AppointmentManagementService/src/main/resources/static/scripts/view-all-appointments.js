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
            $table.append(appt.toTableRow(true, false, false, true, true));
            apptList.push(appt);
        }
        console.log(apptList);
    });
});

$(document).delegate('.edit-appt', 'click', function (e) {
    //TODO. Currently does nothing.
});

$(document).delegate('.rsvp-appt', 'click', function (e) {
    e.preventDefault();
    let apptID = e.target.value;
    $.ajax({
        type: "POST",
        url: "/api/v1/mgr/add-user-to-appt/" + State.LiveID + "/" + apptID,
        cache: false,
        success: function() {
            //TODO make more elegant message.
            alert("RSVP success.")
        },
        error: function() {
            //TODO make more elegant message.
            alert("RSVP failed.")
        }
    });
});
//TODO add check that this user has the right to delete said appt. (Need to implement owner_id in model first).
$(document).delegate('.delete-appt', 'click', function (e) {
    e.preventDefault();
    let apptID = e.target.value;
    $.ajax({
        type: "DELETE",
        url: "/api/v1/mgr/delete/appt/" + apptID,
        cache: false,
        success: function() {
            location.reload();
        },
        error: function() {
            //TODO make more elegant. Also...uh, it doesn't appear. Need some sort of timeout for the request.
            alert("Delete failed. Likely cause: This appointment has a user RSVP'ed. User must first remove their RSVP to delete.")
        }
    });
});

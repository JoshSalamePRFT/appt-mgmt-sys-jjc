$(document).ready(function () {
    console.log("starting user page");
    $.getJSON('/api/v1/mgr/getusers', function (json) {
        var trs = [];
        for (var i = 0; i < json.length; i++) {
            let user = new User(json[i]);
            console.log(user);
            // console.log(user.toString());
            trs.push(user.toTableRow());
            // tr.push(`<td><button class='edit'>Edit</button>&nbsp;&nbsp;<button class='delete' id=${json[i].id}>Delete</button></td></tr>`);
        }
        $('table').append($(trs.join('')));
    });
});
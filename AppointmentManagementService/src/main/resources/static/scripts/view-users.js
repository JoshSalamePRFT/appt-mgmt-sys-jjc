let userList = [];
let $table;
let loggedInID;

$(document).ready(function () {
    $table = $('table');
    loggedInID = parseInt(sessionStorage.getItem('user-id'));
    $.getJSON('/api/v1/mgr/getusers', function (json) {
        for (let i = 0; i < json.length; i++) {
            let user = new User(json[i]);
            // console.log(user.toJSON());
            $table.append(user.toTableRow(false));
            userList.push(user);
        }
        console.log(userList);
    });
});
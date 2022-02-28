let userList = [];

$(document).ready(function () {
    $.getJSON('/api/v1/mgr/getusers', function (json) {
        let trs = [];
        for (let i = 0; i < json.length; i++) {
            let user = new User(json[i]);
            trs.push(user.toTableRow());
            // console.log(user.toJSON());
            userList.push(user);
        }
        $('table').append($(trs.join('')));
        console.log(userList);
    });


});
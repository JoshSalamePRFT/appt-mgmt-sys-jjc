$(document).delegate('#signup-form', 'submit', function (e) {
    e.preventDefault();
    console.log(e);
    const birthday = new Date(e.target[4].value);
    const age = new Date(Date.now() - new Date(birthday)).getFullYear() - 1970;
    let newUser = new User({
        'user_id': null,
        'emailAddress': e.target[0].value,
        'phoneNumber': e.target[1].value,
        'firstName': e.target[2].value,
        'lastName': e.target[3].value,
        'age': age,
        'gender': e.target[5].value,
    });
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "/api/v1/mgr/post/user/",
        data: newUser.toJSON(),
        cache: false,
        success: function(result) {
            console.log(result);
            //TODO redirect to Manage Appointments page.
        },
        error: function(err) {
        }
    });
    console.log(newUser);
});
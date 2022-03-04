$(document).delegate('#login-form', 'submit', function(e) {
    e.preventDefault();
    console.log(e);
    let formEmail = e.target[0].value;
    let formPhone = e.target[1].value;

    //get user by email
    $.getJSON(`/api/v1/mgr/get-by-email/user/${formEmail}`, function (json) {
        console.log(json); //uh, so...if phoneNumber is the password...and json contains the phoneNumber...
        // probably shouldn't log this

        let user = new User(json);

        //if user matches, set the state's user to this one and redirect.
        if (user.emailAddress == formEmail && user.phoneNumber == formPhone) {
            State.LiveID = user.user_id;
            //TODO remove hardcoding domain name
            location.replace('http://localhost:8080/html/manage-appointments.html');
        }
        //no matching user, display error
        else {
            //TODO display error. Maybe in a nicer way (though this works)
            alert("Invalid login (phone doesn't match user with email address)")
        }
    });
});
$(document).delegate('#login-form', 'submit', function(e) {
    e.preventDefault();
    // console.log('hi i did a thing');

    //TODO call rest endpoint to getUserByEmail (or getUserByPhone)
    let user = new User({
        'user_id': 1,
        'firstName': "Guy",
        'lastName': "Incognito",
        'gender': "Who's askin",
        'age': 47,
        'emailAddress': "aa@aa.com",
        'phoneNumber': "795-112-3345"
    });
    State.LiveID = user.user_id;

});


$(document).delegate('#login-form', 'submit', function(e) {
    e.preventDefault();
    console.log('hi i did a thing');
    State.loggedInUser = new User({
        'user_id': 111,
        'firstName': "Guy",
        'lastName': "Incognito",
        'gender': "Who's askin",
        'age': 47,
        'emailAddress': "aa@aa.com",
        'phoneNumber': "795-112-3345"
    })
    sessionStorage.setItem('user-id', State.loggedInUser.user_id);
});
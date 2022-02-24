insert into users (first_name, last_name, age, gender, email_address, phone_number)
values ("John", "Doe", 20, "Male", "john.doe@fakemail.com", "1234567890"),
       ("Jack", "Doe", 21, "Male", "jack.doe@fakemail.com", "1234567891"),
       ("Jane", "Doe", 23, "Female", "jane.doe@fakemail.com", "1234567892"),
       ("Maxine", "Doe", 17, "Female", "maxine.doe@fakemail.com", "1234567893"),
       ("Emily", "Doe", 2, "Female", "emily.doe@fakemail.com", "1234567894"),
       ("Santa", "Doe", 80, "Male", "santa.doe@fakemail.com", "1234567895"),
       ("Who?", "Doe", 67, "Female?", "who?.doe@fakemail.com", "1234567885"),
       ("Sammy", "Doe", 21, "Female", "sammy.doe@fakemail.com", "1234567886"),
       ("Yenfay", "Doe", 44, "Male", "yenfay.doe@fakemail.com", "1234567887"),
       ("Totally", "Real", 75, "Male...?", "totally.real@fakemail.com", "1234567899");
# If intellij is telling you these are errors, they're not.
# Make sure to 'use' the appropriate schema before running this,
# or add the schema name before 'users'. In my case, appt_mgmt_sys.users would be the replacement.
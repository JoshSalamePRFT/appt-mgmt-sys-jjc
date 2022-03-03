insert into appointments (appt_name, appt_type, description, start_time, end_time)
values
    ("Test1", "Solo", "some text", "2015-11-15T08:22:12", "2018-12-12T13:30:30"),
    ("Test2", "Solo", "no text", "2016-11-15T08:22:12", "2017-12-12T13:30:30"),
    ("Test3", "Solo", "wee", "2022-11-15T08:22:12", "2027-12-12T13:30:30"),
    ("Test4", "Solo", "woohoo", "2017-11-15T08:22:12", "2018-12-12T13:30:30"),
    ("Test5", "Solo", "some text", "2115-11-15T08:22:12", "2318-12-12T13:30:30"),
    ("Test6", "Solo", "some text", "2154-11-15T08:22:12", "2218-12-12T13:30:30"),
    ("Test7", "Group", "some text", "2018-11-15T08:22:12", "2019-12-12T13:30:30"),
    ("Test8", "Group", "some text", "2011-11-15T08:22:12", "2018-12-12T13:30:30");

# These aren't errors, intellij is being dumb. Also yes, I only bothered changing the year values.
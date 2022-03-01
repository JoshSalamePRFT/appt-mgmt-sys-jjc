insert into appt_mgmt_sys.appointments (appt_name, appt_type, description, start_time,
                                        end_time)
values
    ("Test1", "Solo", "some text", "10:00:00", "11:00:00"),
    ("Test2", "Solo", "no text", "10:00:00", "12:00:00"),
    ("Test3", "Solo", "", "20:00:00", "21:45:00"),
    ("Test4", "Solo", null, "9:30:00", "10:30:00"),
    ("Test5", "Solo", "some text", "10:00:00", "10:15:00"),
    ("Test6", "Solo", "some text", "11:00:00", "11:30:00"),
    ("Test7", "Group", "some text", "17:00:00", "18:00:00"),
    ("Test8", "Group", "some text", "8:00:00", "10:30:00")

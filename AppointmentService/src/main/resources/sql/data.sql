insert into appointments (appt_name, appt_type, description, start_time,
                                        end_time)
values
    ("Test1", "Solo", "some text", "2015-11-15T08:22:12", "2018-12-12T13:30:30"),
    ("Test2", "Solo", "no text", "2015-11-15T08:22:12", "2018-12-12T13:30:30"),
    ("Test3", "Solo", "wee", "2015-11-15T08:22:12", "2018-12-12T13:30:30"),
    ("Test4", "Solo", "woohoo", "2015-11-15T08:22:12", "2018-12-12T13:30:30"),
    ("Test5", "Solo", "some text", "2015-11-15T08:22:12", "2018-12-12T13:30:30"),
    ("Test6", "Solo", "some text", "2015-11-15T08:22:12", "2018-12-12T13:30:30"),
    ("Test7", "Group", "some text", "2015-11-15T08:22:12", "2018-12-12T13:30:30"),
    ("Test8", "Group", "some text", "2015-11-15T08:22:12", "2018-12-12T13:30:30");

insert into users_appointments (user_id, appointment_id)
values
    (1, 93),
    (7, 93),
    (4, 93),
    (2, 93),
    (1, 104),
    (1, 105),
    (1, 112),
    (1, 115)

drop table appointments;

delete from appointments
where appt_mgmt_sys.appointments.appointment_id >= 1;

select * from appt_mgmt_sys.appointments
where appointment_id > 130;
package com.jjcperf.apptmgmtsvc.web;

import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.User;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class DataBootstrap {
    public static List<User> testUsers() {
        List<User> users = new ArrayList<User>();
        User user1 = User.builder()
                .user_id(1)
                .firstName("Uno")
                .lastName("Singulara")
                .age(1)
                .emailAddress("one@uno.com")
                .gender("Female")
                .phoneNumber("111-111-1111")
                .build();
        User user2 = User.builder()
                .user_id(2)
                .firstName("Dos")
                .lastName("Plurales")
                .age(2)
                .emailAddress("two@dos.com")
                .gender("Male")
                .phoneNumber("222-222-2222")
                .build();
        users.add(user1);
        users.add(user2);
        return users;
    }
    public static List<Appointment> testAppts() {
        Appointment appt1 = Appointment.builder()
                .apptName("test1")
                .apptType("solo")
                .description("")
                .startTime(new Time(11, 30, 00))
                .endTime(new Time(12, 30, 00))
                .build();
        Appointment appt2 = Appointment.builder()
                .apptName("test2")
                .apptType("solo")
                .description("")
                .startTime(new Time(13, 0, 00))
                .endTime(new Time(13, 30, 00))
                .build();
        Appointment appt3 = Appointment.builder()
                .apptName("test3")
                .apptType("group")
                .description("")
                .startTime(new Time(16, 0, 00))
                .endTime(new Time(17, 45, 00))
                .build();
        List<Appointment> appts = new ArrayList<>();
        appts.add(appt1);
        appts.add(appt2);
        appts.add(appt3);
        return appts;
    }
}

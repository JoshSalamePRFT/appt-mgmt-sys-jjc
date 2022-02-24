package com.jjcperf.apptGroup.service;

import com.jjcperf.apptGroup.model.Appointment;

import java.sql.Time;
import java.util.List;

public interface ApptService {

    Appointment createAppt(Appointment appt);
    Appointment readApptById(long id);
    Appointment updateApptById(Appointment appt, long id);
    void deleteApptById(long id);

    Appointment getApptByName(String apptName);

    List<Appointment> findAll();
    List<Appointment> findByApptType(String apptType);
    List<Appointment> findByStartTime(Time startTime);
    List<Appointment> findByEndTime(Time endTime);

    void deleteAppt(Appointment appt);
    void deleteApptByName(String apptName);
    void deleteAllAppt();
    void deleteApptsByType(String apptType);
    void deleteApptsByStart(Time start);
    void deleteApptsByEnd(Time end);
}

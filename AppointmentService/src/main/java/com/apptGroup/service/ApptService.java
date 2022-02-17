package com.apptGroup.service;

import com.apptGroup.model.Appointment;

import java.sql.Time;
import java.util.List;

public interface ApptService {
    Appointment saveAppt(Appointment appt);
    Appointment updateAppt(Appointment appt);
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

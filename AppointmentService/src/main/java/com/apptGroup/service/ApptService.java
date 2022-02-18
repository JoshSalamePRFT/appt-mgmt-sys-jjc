package com.apptGroup.service;

import com.apptGroup.model.Appointment;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

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

    Optional<Appointment> findById(long appt_id);
}

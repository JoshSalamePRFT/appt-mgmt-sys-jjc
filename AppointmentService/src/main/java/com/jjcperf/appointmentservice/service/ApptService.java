package com.jjcperf.appointmentservice.service;

import com.jjcperf.appointmentservice.model.Appointment;

import java.sql.Time;
import java.util.List;

public interface ApptService {

    Appointment createAppt(Appointment appt);
    Appointment readAppt(long id);
    Appointment updateAppt(Appointment appt, long id);
    void deleteAppt(long id);

    Appointment getApptByName(String apptName);

    List<Appointment> findAllAppts();
    List<Appointment> findByApptType(String apptType);
    List<Appointment> findByStartTime(Time startTime);
    List<Appointment> findByEndTime(Time endTime);

    void deleteAppt(Appointment appt);
    void deleteApptByName(String apptName);
    void deleteAllAppt();
    void deleteApptsByType(String apptType);
    void deleteApptsByStart(Time start);
    void deleteApptsByEnd(Time end);

    List<Appointment> listAppointmentsByUserId(long user_id);
}

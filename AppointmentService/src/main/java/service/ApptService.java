package service;

import model.Appointment;

import java.sql.Time;
import java.util.List;

public interface ApptService {
    Appointment createAppt(Appointment appt);
    Appointment updateAppt(Appointment appt);
    Appointment getApptByName(String apptName);

    List<Appointment> getAllAppt();
    List<Appointment> getApptsByType(String apptType);
    List<Appointment> getApptsByStart(Time start);
    List<Appointment> getApptsByEnd(Time end);

    void deleteApptByName(String apptName);
}

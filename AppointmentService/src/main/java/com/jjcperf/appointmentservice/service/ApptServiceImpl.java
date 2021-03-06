package com.jjcperf.appointmentservice.service;

import com.jjcperf.appointmentservice.model.Appointment;
import com.jjcperf.appointmentservice.repository.ApptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApptServiceImpl implements ApptService {
    //TODO: Implement all of these.

    @Autowired
    private ApptRepository apptRepo;

    @Override
    public Appointment createAppt(Appointment appt) {
        return apptRepo.save(appt);
    }

    @Override
    public Appointment readAppt(long id) {
        Optional<Appointment> appt = apptRepo.findById(id);
        if (appt.isPresent()) {
            return appt.get();
        } else {
            throw new NoSuchElementException("The appt_id: " + id + " does not exist.");
        }
    }

    @Override
    public Appointment updateAppt(Appointment appt, long id) {
        //TODO doesn't seem implemented correctly? If present, should overwrite all values EXCEPT id, not id ONLY.
        Optional<Appointment> apptOpt = apptRepo.findById(id);
        if (apptOpt.isPresent()) {
            appt.setAppointment_id(id);
            return apptRepo.save(appt);
        } else {
            throw new NoSuchElementException("The appt_id: " + id + " does not exist.");
        }
    }

    @Override
    public void deleteAppt(long id) {
        Optional<Appointment> apptOpt = apptRepo.findById(id);
        if (apptOpt.isPresent()) {
            apptRepo.deleteById(id);
        } else {
            throw new NoSuchElementException("The appt_id: " + id + " does not exist.");
        }
    }

    @Override
    public List<Appointment> findAllAppts() {
        return apptRepo.findAll();
    }

    @Override
    public Appointment getApptByName(String apptName) {
        return null;
    }

    @Override
    public List<Appointment> findByApptType(String apptType) {
        return null;
    }

    @Override
    public List<Appointment> findByStartTime(Time startTime) {
        return null;
    }

    @Override
    public List<Appointment> findByEndTime(Time endTime) {
        return null;
    }

    @Override
    public void deleteAppt(Appointment appt) {
        apptRepo.delete(appt);
    }

    @Override
    public void deleteApptByName(String apptName) {}

    @Override
    public void deleteAllAppt() {
        apptRepo.deleteAll();
    }

    @Override
    public void deleteApptsByType(String apptType) {

    }

    @Override
    public void deleteApptsByStart(Time start) {

    }

    @Override
    public void deleteApptsByEnd(Time end) {

    }

    @Override
    public List<Appointment> listAppointmentsByUserId(long user_id) {
        return null;
    }

}

package com.apptGroup.service;

import com.apptGroup.model.Appointment;
import com.apptGroup.repository.ApptRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Data
@Service
public class ApptServiceImpl implements ApptService{
    //TODO: Implement all of these.
    @Autowired
    private ApptRepository apptRepo;

    public ApptServiceImpl(ApptRepository apptRepo) {
        super();
        this.apptRepo = apptRepo;
    }

    @Override
    public Appointment createAppt(Appointment appt) {
        return apptRepo.save(appt);
    }

    @Override
    public Appointment readApptById(long id) {
        Optional<Appointment> appt = apptRepo.findById(id);
        if (appt.isPresent()) {
            return appt.get();
        } else {
            throw new NoSuchElementException("The appt_id: " + id + " does not exist.");
        }
    }

    @Override
    public Appointment updateApptById(Appointment appt, long id) {
        Optional<Appointment> apptOpt = apptRepo.findById(id);
        if (apptOpt.isPresent()) {
            appt.setAppointment_id(id);
            return apptRepo.save(appt);
        } else {
            throw new NoSuchElementException("The appt_id: " + id + " does not exist.");
        }
    }

    @Override
    public void deleteApptById(long id) {
        Optional<Appointment> apptOpt = apptRepo.findById(id);
        if (apptOpt.isPresent()) {
            apptRepo.deleteById(id);
        } else {
            throw new NoSuchElementException("The appt_id: " + id + " does not exist.");
        }
    }

    @Override
    public List<Appointment> findAll() {
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
    public void deleteApptByName(String apptName) {

    }

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

}

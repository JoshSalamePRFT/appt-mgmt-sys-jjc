package com.apptGroup.service;

import com.apptGroup.model.Appointment;
import com.apptGroup.repository.ApptRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Data
@Service
public class ApptServiceImpl implements ApptService{
    //TODO: Implement all of these.
    private ApptRepository apptRepo;

    @Override
    public Appointment saveAppt(Appointment appt) {
        return apptRepo.save(appt);
    }

    @Override
    public Appointment updateAppt(Appointment appt) {
        return null;
    }

    @Override
    public Appointment getApptByName(String apptName) {
        return null;
    }

    @Override
    public List<Appointment> findAll() {
        return apptRepo.findAll();
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

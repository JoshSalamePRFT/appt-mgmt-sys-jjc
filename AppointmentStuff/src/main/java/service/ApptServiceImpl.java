package service;

import lombok.Data;
import model.Appointment;
import org.springframework.stereotype.Service;
import repository.ApptRepository;

import java.sql.Time;
import java.util.List;

@Service
@Data
public class ApptServiceImpl implements ApptService{
    //TODO: Implement all of these.
    private ApptRepository apptRepo;

    @Override
    public Appointment createAppt(Appointment appt) {
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
    public List<Appointment> getAllAppt() {
        return null;
    }

    @Override
    public List<Appointment> getApptsByType(String apptType) {
        return null;
    }

    @Override
    public List<Appointment> getApptsByStart(Time start) {
        return null;
    }

    @Override
    public List<Appointment> getApptsByEnd(Time end) {
        return null;
    }

    @Override
    public void deleteApptByName(String apptName) {

    }
}

package com.jjcperf.appointmentservice.controller;

import com.jjcperf.appointmentservice.model.Appointment;
import com.jjcperf.appointmentservice.service.ApptService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin
@RequestMapping("/api/v1/appt")
@RequiredArgsConstructor
public class ApptController {

    @Autowired
    private ApptService apptService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment createAppointment(@RequestBody Appointment appt) {
        if (appt.getApptName() == null) {
            throw new IllegalArgumentException("appt.apptName is Null");
        }
        return apptService.createAppt(appt);
    }

    @GetMapping("/read/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment readAppointment(@PathVariable long id) {
        return apptService.readAppt(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment updateAppointment(@RequestBody Appointment appt, @PathVariable long id) {
        if (appt.getApptName() == null) {
            throw new IllegalArgumentException("appt.apptName is Null");
        }
        return apptService.updateAppt(appt, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAppointment(@PathVariable long id) {
        apptService.deleteAppt(id);
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getAllAppointments() {
        return apptService.findAllAppts();
    }

    @GetMapping("/get-appts-by-user/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> listAppointmentsByUserId(@PathVariable("user_id") long user_id) {
        return apptService.listAppointmentsByUserId(user_id);
    }
}

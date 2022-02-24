package com.jjcperf.apptGroup.controller;

import com.jjcperf.apptGroup.model.Appointment;
import com.jjcperf.apptGroup.service.ApptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/appt")
public class ApptController {
    @Autowired
    private ApptService apptService;

    public ApptController(ApptService apptService) {
        super();
        this.apptService = apptService;
    }

    @PostMapping("/create")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appt) {
        if (appt.getApptName() == null) {
            throw new IllegalArgumentException("appt.apptName is Null");
        }
        return new ResponseEntity<>(apptService.createAppt(appt), HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Appointment> readAppointmentById(@PathVariable long id) {
        return new ResponseEntity<>(apptService.readApptById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> updateAppointmentById(@RequestBody Appointment appt, @PathVariable long id) {
        if (appt.getApptName() == null) {
            throw new IllegalArgumentException("appt.apptName is Null");
        }
        return new ResponseEntity<>(apptService.updateApptById(appt, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAppointmentById(@PathVariable long id) {
        apptService.deleteApptById(id);
        return "Successfully Deleted";
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Appointment>> findAll() {
        return new ResponseEntity<>(apptService.findAll(), HttpStatus.OK);
    }
}

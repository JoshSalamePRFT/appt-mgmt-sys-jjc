package com.apptGroup.controller;

import com.apptGroup.model.Appointment;
import com.apptGroup.service.ApptService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/save")
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appt) {
        if (appt.getApptName() == null) {
            throw new IllegalArgumentException("appt.apptName is Null");
        }
        return new ResponseEntity<>(apptService.saveAppt(appt), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appt) {
        if (appt.getApptName() == null) {
            throw new IllegalArgumentException("appt.apptName is Null");
        }
        return new ResponseEntity<>(apptService.saveAppt(appt), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Appointment>> getAppointment() {
        return new ResponseEntity<>(apptService.findAll(), HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<List<Appointment>> deleteAllAppointments() {
        apptService.deleteAllAppt();
        return new ResponseEntity<>(apptService.findAll(), HttpStatus.GONE);
    }
}

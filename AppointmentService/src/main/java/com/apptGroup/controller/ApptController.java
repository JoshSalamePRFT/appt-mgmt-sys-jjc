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

    @PostMapping
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appt) {
        return new ResponseEntity<>(apptService.saveAppt(appt), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAppointment() {
        return new ResponseEntity<>(apptService.findAll(), HttpStatus.FOUND);
    }
}

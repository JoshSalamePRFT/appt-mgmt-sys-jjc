package com.apptGroup.controller;

import com.apptGroup.model.Appointment;
import com.apptGroup.service.ApptService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@CrossOrigin
@RequestMapping("/api/appt")
public class ApptController {
    private ApptService apptService;

    @PostMapping
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appt) {
        return new ResponseEntity<>(apptService.saveAppt(appt), HttpStatus.CREATED);
    }
}

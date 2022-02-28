package com.jjcperf.apptmgmtsvc.web.controller;

import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.apptmgmtsvc.service.ApptManagementService;
import com.jjcperf.apptmgmtsvc.web.DataBootstrap;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/mgr")
@RequiredArgsConstructor
public class ApptMgrController {


    @Autowired
    private final ApptManagementService apptManagementService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/getusers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() throws JMSException {
//        return apptManagementService.listUsers();
        return DataBootstrap.testUsers();
    }
    @GetMapping("/getappts")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getAppts() throws JMSException {
//        return null;
        return DataBootstrap.testAppts();
    }


    @GetMapping("/{user_id}/getappts")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getAppointmentsByUser(@PathVariable("user_id") long userId) {
        return apptManagementService.listApptsByUserId(userId);
    }

    @GetMapping("/{appt_id}/getusers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsersByAppointment(@PathVariable("appt_id") long apptId) {
        return apptManagementService.listUsersByApptId(apptId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> validationError(MethodArgumentNotValidException ex) {
        List<String> exceptions = new ArrayList<>();

        ex.getFieldErrors().forEach(fieldError -> {
            exceptions.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        });
        return exceptions;
    }
}

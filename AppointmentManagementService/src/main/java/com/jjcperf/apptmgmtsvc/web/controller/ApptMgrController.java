package com.jjcperf.apptmgmtsvc.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.apptmgmtsvc.service.ApptManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
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
    public List<User> getUsers() throws JMSException, JsonProcessingException {
        return apptManagementService.listUsers();
    }
    @GetMapping("/getappts")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getAppts() throws JMSException, JsonProcessingException {
        return apptManagementService.listAppts();
    }

    @GetMapping("/{user_id}/getappts")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getAppointmentsByUser(@PathVariable("user_id") long userId) throws JMSException, JsonProcessingException {
        return apptManagementService.listApptsByUserId(userId);
    }

    @GetMapping("/{appt_id}/getusers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsersByAppointment(@PathVariable("appt_id") long apptId) throws JMSException, JsonProcessingException {
        return apptManagementService.listUsersByApptId(apptId);
    }


    //CRUD FOR USER & APPT BELOW
    @GetMapping("/get/user/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable("user_id") long user_id) throws JMSException, JsonProcessingException {
        return apptManagementService.readUser(user_id);
    }

    @GetMapping("/get/appt/{appt_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment getAppointment(@PathVariable("appt_id") long appt_id) throws JMSException, JsonProcessingException {
        return apptManagementService.readAppointment(appt_id);
    }

    @PostMapping("/post/user/")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) throws JMSException, JsonProcessingException {
        return apptManagementService.createUser(user);
    }

    @PostMapping("/post/appt/")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment postAppointment(@RequestBody Appointment appointment) throws JMSException, JsonProcessingException {
        return apptManagementService.createAppointment(appointment);
    }

    @PutMapping("/put/user/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public User putUser(@PathVariable("user_id") long user_id, @RequestBody User user) throws JMSException, JsonProcessingException {
        return apptManagementService.updateUser(user_id, user);
    }

    @PutMapping("/put/appt/{appt_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment putAppointment(@PathVariable("appt_id") long appt_id, @RequestBody Appointment appointment) throws JMSException, JsonProcessingException {
        return apptManagementService.updateAppointment(appt_id, appointment);
    }

    @DeleteMapping("/delete/user/{user_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("user_id") long user_id) throws JMSException {
        apptManagementService.deleteUser(user_id);
    }

    @DeleteMapping("/delete/appt/{appt_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAppointment(@PathVariable("appt_id") long appt_id) {
        apptManagementService.deleteAppointment(appt_id);
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

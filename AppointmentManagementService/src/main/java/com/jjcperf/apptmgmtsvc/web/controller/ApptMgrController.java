package com.jjcperf.apptmgmtsvc.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.AppointmentDTO;
import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.apptmgmtsvc.model.UserDTO;
import com.jjcperf.apptmgmtsvc.service.AppointmentManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import java.util.ArrayList;
import java.util.List;

//TODO perhaps split controllers and services into MgmtService related stuff and Appointment/User related stuff.

@RestController
@RequestMapping("api/v1/mgr")
@RequiredArgsConstructor
@Slf4j
public class ApptMgrController {

    @Autowired
    private final AppointmentManagementService appointmentManagementService;

    private final ObjectMapper mapper;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/getusers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() throws JMSException, JsonProcessingException {
        return appointmentManagementService.listUsers();
    }
    @GetMapping("/getappts")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getAppointments() throws JMSException, JsonProcessingException {
        return appointmentManagementService.listAppointments();
    }

    @GetMapping("/{user_id}/getappts")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getAppointmentsByUser(@PathVariable("user_id") long userId) {
        return appointmentManagementService.listAppointmentsByUserId(userId);
    }

    @GetMapping("/{appointment_id}/getusers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsersByAppointment(@PathVariable("appointment_id") long appointment_id) {
        return appointmentManagementService.listUsersByAppointmentId(appointment_id);
    }

    /* TODO perhaps change to use a request body instead of path variables.
     * Also perhaps change return type to string or something to indicate success (though ResponseStatus might be ok. */
    @PostMapping("/add-user-to-appt/{user_id}/{appointment_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUserToAppointment(@PathVariable("user_id") long user_id, @PathVariable("appointment_id") long appointment_id) {
        appointmentManagementService.addUserToAppointment(user_id, appointment_id);
    }

    //CRUD FOR USER & APPOINTMENT BELOW
    @GetMapping("/get/user/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable("user_id") long user_id) throws JMSException, JsonProcessingException {
        return appointmentManagementService.readUser(user_id);
    }

    @GetMapping("/get/appt/{appointment_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment getAppointment(@PathVariable("appointment_id") long appointment_id) throws JMSException, JsonProcessingException {
        return appointmentManagementService.readAppointment(appointment_id);
    }

    @PostMapping("/post/user/")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody String userJSON) throws JMSException, JsonProcessingException {
        System.out.println(userJSON);
        UserDTO userDTO = mapper.readValue(userJSON, UserDTO.class);
        System.out.println(userDTO);
        return appointmentManagementService.createUser(userDTO);
    }

    @PostMapping("/post/appt/")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment postAppointment(@RequestBody String appointmentJSON) throws JMSException, JsonProcessingException {
        System.out.println(appointmentJSON);
        AppointmentDTO appointmentDTO = mapper.readValue(appointmentJSON, AppointmentDTO.class);
        System.out.println(appointmentDTO);
        return appointmentManagementService.createAppointment(appointmentDTO);
    }

    @PutMapping("/put/user/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public User putUser(@PathVariable("user_id") long user_id, @RequestBody User user) throws JMSException, JsonProcessingException {
        return appointmentManagementService.updateUser(user_id, user);
    }

    @PutMapping("/put/appt/{appointment_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment putAppointment(@PathVariable("appointment_id") long appointment_id, @RequestBody Appointment appointment) throws JMSException, JsonProcessingException {
        return appointmentManagementService.updateAppointment(appointment_id, appointment);
    }

    @DeleteMapping("/delete/user/{user_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("user_id") long user_id) {
        appointmentManagementService.deleteUser(user_id);
    }

    @DeleteMapping("/delete/appt/{appointment_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAppointment(@PathVariable("appointment_id") long appointment_id) {
        appointmentManagementService.deleteAppointment(appointment_id);
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

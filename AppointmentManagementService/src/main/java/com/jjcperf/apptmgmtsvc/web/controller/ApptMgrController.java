package com.jjcperf.apptmgmtsvc.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.AppointmentDTO;
import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.apptmgmtsvc.model.UserDTO;
import com.jjcperf.apptmgmtsvc.service.ApptManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import java.util.ArrayList;
import java.util.List;

//TODO perhaps split controllers and services into MgmtService related stuff and Appt/User related stuff.

@RestController
@RequestMapping("api/v1/mgr")
@RequiredArgsConstructor
@Slf4j
public class ApptMgrController {

    @Autowired
    private final ApptManagementService apptManagementService;

    private final ObjectMapper mapper;

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

    /* TODO perhaps change to use a request body instead of path variables.
     * Also perhaps change return type to string or something to indicate success (though responsestatus might be ok.) */
    @PostMapping("/add-user-to-appt/{user_id}/{appt_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUserToAppointment(@PathVariable("user_id") long user_id, @PathVariable("appt_id") long appt_id) {
        apptManagementService.addUserToAppt(user_id, appt_id);
    }

    @DeleteMapping("/remove-user-from-appt/{user_id}/{appt_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUserFromAppointment(@PathVariable("user_id") long user_id, @PathVariable("appt_id") long appt_id) {
        apptManagementService.deleteUserFromAppointment(user_id, appt_id);
    }

    //CRUD FOR USER & APPT BELOW
    @GetMapping("/get/user/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable("user_id") long user_id) throws JMSException, JsonProcessingException {
        return apptManagementService.readUser(user_id);
    }

    //TODO make email addresses unique so this doesn't break if there's a duplicate.
    @GetMapping("/get-by-email/user/{emailAddress}")
    public User getUserByEmailAddress(@PathVariable("emailAddress") String emailAddress) throws JMSException, JsonProcessingException {
        return apptManagementService.readUserByEmailAddress(emailAddress);
    }

    @GetMapping("/get/appt/{appt_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment getAppointment(@PathVariable("appt_id") long appt_id) throws JMSException, JsonProcessingException {
        return apptManagementService.readAppointment(appt_id);
    }

    @PostMapping("/post/user/")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody String userJSON) throws JMSException, JsonProcessingException {
        System.out.println(userJSON);
        UserDTO userDTO = mapper.readValue(userJSON, UserDTO.class);
        System.out.println(userDTO);
        return apptManagementService.createUser(userDTO);
    }

    @PostMapping("/post/appt/")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment postAppointment(@RequestBody String apptJSON) throws JMSException, JsonProcessingException {
        System.out.println(apptJSON);
        AppointmentDTO apptDTO = mapper.readValue(apptJSON, AppointmentDTO.class);
        System.out.println(apptDTO);
        return apptManagementService.createAppointment(apptDTO);
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

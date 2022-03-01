package com.jjcperf.apptmgmtsvc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.User;

import javax.jms.JMSException;
import java.util.List;

public interface ApptManagementService {

    List<User> listUsers() throws JMSException, JsonProcessingException;
    List<Appointment> listAppts() throws JMSException, JsonProcessingException;

    List<Appointment> listApptsByUserId(long id);
    List<User> listUsersByApptId(long id);

    void addUserToAppt(long user_id, long appt_id);

    User readUser(long user_id) throws JMSException, JsonProcessingException;
    Appointment readAppointment(long appt_id) throws JMSException, JsonProcessingException;

    User createUser(User user) throws JsonProcessingException, JMSException;
    Appointment createAppointment(Appointment appointment) throws JMSException, JsonProcessingException;

    User updateUser(long user_id, User user) throws JMSException, JsonProcessingException;
    Appointment updateAppointment(long appt_id, Appointment appointment) throws JMSException, JsonProcessingException;

    void deleteUser(long user_id) throws JMSException;
    void deleteAppointment(long appt_id);
}

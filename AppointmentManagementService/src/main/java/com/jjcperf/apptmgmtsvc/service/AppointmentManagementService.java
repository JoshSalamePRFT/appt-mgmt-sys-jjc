package com.jjcperf.apptmgmtsvc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.AppointmentDTO;
import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.apptmgmtsvc.model.UserDTO;

import javax.jms.JMSException;
import java.util.List;

public interface AppointmentManagementService {

    List<User> listUsers() throws JMSException, JsonProcessingException;
    List<Appointment> listAppointments() throws JMSException, JsonProcessingException;

    List<Appointment> listAppointmentsByUserId(long id);
    List<User> listUsersByAppointmentId(long id);

    void addUserToAppointment(long user_id, long appointment_id);

    User readUser(long user_id) throws JMSException, JsonProcessingException;
    Appointment readAppointment(long appointment_id) throws JMSException, JsonProcessingException;

    User createUser(UserDTO user) throws JsonProcessingException, JMSException;
    Appointment createAppointment(AppointmentDTO appointment) throws JMSException, JsonProcessingException;

    User updateUser(long user_id, User user) throws JMSException, JsonProcessingException;
    Appointment updateAppointment(long appointment_id, Appointment appointment) throws JMSException, JsonProcessingException;

    void deleteUser(long user_id);
    void deleteAppointment(long appointment_id);
}

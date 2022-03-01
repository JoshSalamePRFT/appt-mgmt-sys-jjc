package com.jjcperf.apptmgmtsvc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.msg.msg.ResponseMessage;
import com.jjcperf.msg.sender.MgmtSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.util.List;

@Service
public class ApptManagementServiceImpl implements ApptManagementService {

    @Autowired
    MgmtSender mgmtSender;

    ObjectMapper mapper;

    public ApptManagementServiceImpl() {
        mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
    }


    @Override
    public List<User> listUsers() throws JMSException, JsonProcessingException {
        //Conversion from Message to String to ResponseMessage to List
        String message = mgmtSender.sendUserGetAllMessage().getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return responseMessage.getEntities();
    }

    @Override
    public List<Appointment> listAppts() throws JMSException, JsonProcessingException {
        //Conversion from Message to String to ResponseMessage to List
        String message = mgmtSender.sendAppointmentGetAllMessage().getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return responseMessage.getEntities();
    }

    @Override
    public List<Appointment> listApptsByUserId(long id) {
        return null;
    }

    @Override
    public List<User> listUsersByApptId(long id) {
        return null;
    }

    //CRUD FOR USER & APPT
    //TODO code cleanup

    @Override
    public User readUser(long user_id) throws JMSException, JsonProcessingException {
        String message = mgmtSender.sendUserGetMessage(user_id).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (User) responseMessage.getEntities().get(0);
    }

    @Override
    public Appointment readAppointment(long appt_id) throws JMSException, JsonProcessingException {
        String message = mgmtSender.sendAppointmentGetMessage(appt_id).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (Appointment) responseMessage.getEntities().get(0);
    }

    @Override
    public User createUser(User user) throws JsonProcessingException, JMSException {
        String message = mgmtSender.sendUserPostMessage(user).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (User) responseMessage.getEntities().get(0);
    }

    @Override
    public Appointment createAppointment(Appointment appointment) throws JMSException, JsonProcessingException {
        String message = mgmtSender.sendAppointmentPostMessage(appointment).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (Appointment) responseMessage.getEntities().get(0);
    }

    @Override
    public User updateUser(long user_id, User user) throws JMSException, JsonProcessingException {
        String message = mgmtSender.sendUserPutMessage(user_id, user).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (User) responseMessage.getEntities().get(0);
    }

    @Override
    public Appointment updateAppointment(long appt_id, Appointment appointment) throws JMSException, JsonProcessingException {
        String message = mgmtSender.sendAppointmentPutMessage(appt_id, appointment).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (Appointment) responseMessage.getEntities().get(0);
    }

    @Override
    public void deleteUser(long user_id) {
        mgmtSender.sendUserDeleteMessage(user_id);
    }

    @Override
    public void deleteAppointment(long appt_id) {
        mgmtSender.sendAppointmentDeleteMessage(appt_id);
    }
}

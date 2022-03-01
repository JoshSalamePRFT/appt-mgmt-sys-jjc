package com.jjcperf.apptmgmtsvc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.msg.msg.ResponseMessage;
import com.jjcperf.msg.sender.MgmtSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ApptManagementServiceImpl implements ApptManagementService {

    @Autowired
    MgmtSender mgmtSender;
    ObjectMapper mapper = new ObjectMapper();

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
}

package com.jjcperf.msg.sender;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.appointmentservice.controller.ApptController;
import com.jjcperf.appointmentservice.model.Appointment;
import com.jjcperf.msg.msg.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Destination;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
@Slf4j
public class ApptSender {
    private final JmsTemplate jmsTemplate;

    @Autowired
    private ApptController apptController;

    //TODO convert RepsonseMessage type to specific message type (e.g. ApptGetMessage), as well as in MgmtListener side.

    @Transactional
    public void sendGetReplyMessage(long id, Destination destination) {
        Appointment appt = apptController.readAppointment(id);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();
        List<Appointment> entities = new ArrayList<>();
        entities.add(appt);
        responseMessage.setEntities(entities);

        log.debug("Sending an Appt Get Response!");

        jmsTemplate.convertAndSend(destination, responseMessage);
    }

    public void sendPostReplyMessage(Appointment appt, Destination destination) {
        Appointment returnAppt = apptController.createAppointment(appt);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();

        List<Appointment> entities = new ArrayList<>();
        entities.add(returnAppt);
        responseMessage.setEntities(entities);

        log.debug("Sending an Appt Post Response!");

        jmsTemplate.convertAndSend(destination, responseMessage);
    }

    public void sendPutReplyMessage(long id, Appointment appt, Destination destination) {
        Appointment returnAppt = apptController.updateAppointment(appt, id);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();
        List<Appointment> entities = new ArrayList<>();
        entities.add(returnAppt);
        responseMessage.setEntities(entities);

        log.debug("Sending an Appt Put Response!");

        jmsTemplate.convertAndSend(destination, responseMessage);
    }

    public void sendDeleteReplyMessage(long id, Destination destination) {
        apptController.deleteAppointment(id);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();

        log.debug("Sending an Appt Delete Response!");

        jmsTemplate.convertAndSend(destination, responseMessage);
    }

    public void sendGetAllReplyMessage(Destination destination) {
        List<Appointment> appointmentList = apptController.getAllAppointments();

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();

        responseMessage.setEntities(appointmentList);

        log.debug("Sending an Appt GetAll Response!");

        jmsTemplate.convertAndSend(destination, responseMessage);
    }
}

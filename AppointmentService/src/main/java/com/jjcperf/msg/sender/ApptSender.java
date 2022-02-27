package com.jjcperf.msg.sender;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.apptGroup.controller.ApptController;
import com.jjcperf.apptGroup.model.Appointment;
import com.jjcperf.msg.config.JmsConfig;
import com.jjcperf.msg.msg.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
@Slf4j
public class ApptSender {
    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    private ApptController apptController;

    //TODO convert RepsonseMessage type to specific message type (e.g. ApptGetMessage), as well as in MgmtListener side.

    @Transactional
    public void sendGetResponseMessage(long id) {
        Appointment appt = apptController.readAppointment(id);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();
        List<Appointment> entities = new ArrayList<Appointment>();
        entities.add(appt);
        responseMessage.setEntities(entities);

        log.debug("Sending an Appt Get Response!");

        jmsTemplate.convertAndSend(JmsConfig.APPT_GET_SEND_QUEUE, responseMessage);
    }

    public void sendPostResponseMessage(Appointment appt) {
        Appointment returnAppt = apptController.createAppointment(appt);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();

        List<Appointment> entities = new ArrayList<Appointment>();
        entities.add(returnAppt);
        responseMessage.setEntities(entities);

        log.debug("Sending an Appt Post Response!");

        jmsTemplate.convertAndSend(JmsConfig.APPT_POST_SEND_QUEUE, responseMessage);
    }

    public void sendPutResponseMessage(long id, Appointment appt) {
        Appointment returnAppt = apptController.updateAppointment(appt, id);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();
        List<Appointment> entities = new ArrayList<Appointment>();
        entities.add(returnAppt);
        responseMessage.setEntities(entities);

        log.debug("Sending an Appt Put Response!");

        jmsTemplate.convertAndSend(JmsConfig.APPT_PUT_SEND_QUEUE, responseMessage);
    }

    public void sendDeleteResponseMessage(long id) {
        apptController.deleteAppointment(id);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();

        log.debug("Sending an Appt Delete Response!");

        jmsTemplate.convertAndSend(JmsConfig.APPT_DELETE_SEND_QUEUE, responseMessage);
    }

    public void sendGetAllResponseMessage() {
        List<Appointment> appointmentList = apptController.getAllAppointments();

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();

        responseMessage.setEntities(appointmentList);

        log.debug("Sending an Appt GetAll Response!");

        jmsTemplate.convertAndSend(JmsConfig.APPT_GETALL_SEND_QUEUE, responseMessage);
    }
}

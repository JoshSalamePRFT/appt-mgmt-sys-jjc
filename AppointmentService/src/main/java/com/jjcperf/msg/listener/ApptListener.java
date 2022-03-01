package com.jjcperf.msg.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.appointmentservice.controller.ApptController;
import com.jjcperf.msg.config.JmsConfig;
import com.jjcperf.msg.msg.appt.*;
import com.jjcperf.msg.sender.ApptSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@RequiredArgsConstructor
@Component
@Slf4j
public class ApptListener {

    @Autowired
    private ApptSender apptSender;
    @Autowired
    private ApptController apptController;
    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    @JmsListener(destination = JmsConfig.APPT_GET_QUEUE)
    public void listenForApptGetReq(@Payload ApptGetMessage getMessage,
                                    @Headers MessageHeaders headers,
                                    Message message) throws JMSException {

        log.debug("I Got an Appt Get Request!" + getMessage);

        apptSender.sendGetReplyMessage(getMessage.getId(), message.getJMSReplyTo());
    }

    @JmsListener(destination = JmsConfig.APPT_POST_QUEUE)
    public void listenForApptPostReq(@Payload ApptPostMessage postMessage,
                                     @Headers MessageHeaders headers,
                                     Message message) throws JMSException {

        log.debug("I Got an Appt Post Request!" + postMessage);

        apptSender.sendPostReplyMessage(postMessage.getAppt(), message.getJMSReplyTo());
    }

    @JmsListener(destination = JmsConfig.APPT_PUT_QUEUE)
    public void listenForApptPutReq(@Payload ApptPutMessage putMessage,
                                    @Headers MessageHeaders headers,
                                    Message message) throws JMSException {

        log.debug("I Got an Appt Put Request!" + putMessage);

        apptSender.sendPutReplyMessage(putMessage.getId(), putMessage.getAppt(), message.getJMSReplyTo());
    }

    @JmsListener(destination = JmsConfig.APPT_DELETE_QUEUE)
    public void listenForApptDeleteReq(@Payload ApptDeleteMessage deleteMessage,
                                       @Headers MessageHeaders headers,
                                       Message message) throws JMSException {

        log.debug("I Got an Appt Delete Request!" + deleteMessage);

        apptSender.sendDeleteReplyMessage(deleteMessage.getId(), message.getJMSReplyTo());
    }

    @JmsListener(destination = JmsConfig.APPT_GETALL_QUEUE)
    public void listenForApptGetAllReq(@Payload ApptGetAllMessage getAllMessage,
                                       @Headers MessageHeaders headers,
                                       Message message) throws JMSException {

        log.debug("I Got an Appt GetAll Request!  " + getAllMessage);

        apptSender.sendGetAllReplyMessage(message.getJMSReplyTo());
    }
}

package com.jjcperf.msg.listener;

import com.jjcperf.msg.msg.ResponseMessage;
import com.jjcperf.msg.config.JmsConfig;
import com.jjcperf.msg.msg.user.UserGetMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@RequiredArgsConstructor
@Component
@Slf4j
public class MgmtListener {

    //TODO change paylood type to specific message for all listeners. See TODO in ResponseMessage.
    @JmsListener(destination = JmsConfig.USER_GET_SEND_QUEUE)
    public void listenForUserGetSvc(@Payload ResponseMessage responseMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        log.debug("I Got a User Get Response!" + responseMessage);
    }

    @JmsListener(destination = JmsConfig.APPT_GET_SEND_QUEUE)
    public void listenForApptGetSvc(@Payload ResponseMessage responseMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        log.debug("I Got an Appointment Get Response!" + responseMessage);
    }
    @JmsListener(destination = JmsConfig.USER_POST_SEND_QUEUE)
    public void listenForUserPostSvc(@Payload ResponseMessage responseMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        log.debug("I Got a User Post Response!" + responseMessage);
    }

    @JmsListener(destination = JmsConfig.APPT_POST_SEND_QUEUE)
    public void listenForApptPostSvc(@Payload ResponseMessage responseMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        log.debug("I Got an Appointment Post Response!" + responseMessage);
    }

    @JmsListener(destination = JmsConfig.USER_PUT_SEND_QUEUE)
    public void listenForUserPutSvc(@Payload ResponseMessage responseMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        log.debug("I Got a User Put Response!" + responseMessage);
    }

    @JmsListener(destination = JmsConfig.APPT_PUT_SEND_QUEUE)
    public void listenForApptPutSvc(@Payload ResponseMessage responseMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        log.debug("I Got an Appointment Put Response!" + responseMessage);
    }

    @JmsListener(destination = JmsConfig.USER_DELETE_SEND_QUEUE)
    public void listenForUserDeleteSvc(@Payload ResponseMessage responseMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        log.debug("I Got a User Delete Response!" + responseMessage);
    }

    @JmsListener(destination = JmsConfig.APPT_DELETE_SEND_QUEUE)
    public void listenForApptDeleteSvc(@Payload ResponseMessage responseMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        log.debug("I Got an Appointment Delete Response!" + responseMessage);
    }

    @JmsListener(destination = JmsConfig.USER_GETALL_SEND_QUEUE)
    public void listenForUserGetAllSvc(@Payload ResponseMessage responseMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        log.debug("I Got a User Get All Response!" + responseMessage);
    }

    @JmsListener(destination = JmsConfig.APPT_GETALL_SEND_QUEUE)
    public void listenForApptGetAllSvc(@Payload ResponseMessage responseMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        log.debug("I Got an Appointment GetAll Response!" + responseMessage);
    }
}

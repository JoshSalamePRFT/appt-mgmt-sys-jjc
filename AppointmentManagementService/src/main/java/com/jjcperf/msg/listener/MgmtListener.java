package com.jjcperf.msg.listener;

import com.jjcperf.msg.msg.ResponseMessage;
import com.jjcperf.msg.config.JmsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@RequiredArgsConstructor
@Component
public class MgmtListener {

    @JmsListener(destination = JmsConfig.USER_SEND_QUEUE)
    public void listenForUserSvc(@Payload ResponseMessage responseMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        System.out.println("I Got a User Response!!!!!");
        System.out.println(responseMessage);
    }

    @JmsListener(destination = JmsConfig.APPT_SEND_QUEUE)
    public void listenForApptSvc(@Payload ResponseMessage responseMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        System.out.println("I Got an Appointment Response!!!!!");
        System.out.println(responseMessage);
    }
}

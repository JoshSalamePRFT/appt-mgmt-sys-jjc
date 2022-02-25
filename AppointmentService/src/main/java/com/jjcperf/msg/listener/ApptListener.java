package com.jjcperf.msg.listener;

import com.jjcperf.msg.config.JmsConfig;
import com.jjcperf.msg.msg.appt.*;
import com.jjcperf.msg.sender.ApptSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@RequiredArgsConstructor
@Component
public class ApptListener {

    @Autowired
    private ApptSender apptSender;

    @JmsListener(destination = JmsConfig.APPT_GET_REQ_QUEUE)
    public void listenForApptGetReq(@Payload ApptGetMessage getMessage,
                                    @Headers MessageHeaders headers,
                                    Message message) {

        System.out.println("I Got an Appt Get Request!");
        System.out.println(getMessage);

        apptSender.sendGetResponseMessage(Long.parseLong(getMessage.getMessage()));
    }

    @JmsListener(destination = JmsConfig.APPT_POST_REQ_QUEUE)
    public void listenForApptPostReq(@Payload ApptPostMessage postMessage,
                                     @Headers MessageHeaders headers,
                                     Message message) {

        System.out.println("I Got an Appt Post Request!");
        System.out.println(postMessage);

        apptSender.sendPostResponseMessage(postMessage.getAppt());
    }

    @JmsListener(destination = JmsConfig.APPT_PUT_REQ_QUEUE)
    public void listenForApptPutReq(@Payload ApptPutMessage putMessage,
                                    @Headers MessageHeaders headers,
                                    Message message) {

        System.out.println("I Got an Appt Put Request!");
        System.out.println(putMessage);

        apptSender.sendPutResponseMessage(putMessage.getId(), putMessage.getAppt());
    }

    @JmsListener(destination = JmsConfig.APPT_DELETE_REQ_QUEUE)
    public void listenForApptDeleteReq(@Payload ApptDeleteMessage deleteMessage,
                                       @Headers MessageHeaders headers,
                                       Message message) {

        System.out.println("I Got an Appt Delete Request!");
        System.out.println(deleteMessage);

        apptSender.sendDeleteResponseMessage(deleteMessage.getId());
    }

    @JmsListener(destination = JmsConfig.APPT_GETALL_REQ_QUEUE)
    public void listenForApptGetAllReq(@Payload ApptGetAllMessage getAllMessage,
                                       @Headers MessageHeaders headers,
                                       Message message) {

        System.out.println("I Got an Appt GetAll Request!");
        System.out.println(getAllMessage);

        apptSender.sendGetAllResponseMessage();
    }
}

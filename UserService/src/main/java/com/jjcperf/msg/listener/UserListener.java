package com.jjcperf.msg.listener;

import com.jjcperf.msg.config.JmsConfig;
import com.jjcperf.msg.msg.user.*;
import com.jjcperf.msg.sender.UserSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@RequiredArgsConstructor
@Component
@Slf4j
public class UserListener {

    @Autowired
    private UserSender userSender;

    @JmsListener(destination = JmsConfig.USER_GET_QUEUE)
    public void listenForUserGetReq(@Payload UserGetMessage getMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) throws JMSException {


        log.debug("I Got a User Get Request!" + getMessage);

        userSender.sendGetReplyMessage(getMessage.getId(), message.getJMSReplyTo());
    }

    @JmsListener(destination = JmsConfig.USER_GETBYEMAIL_QUEUE)
    public void listenForUserGetByEmailReq(@Payload UserGetByEmailMessage getByEmailMessage,
                                           @Headers MessageHeaders headers,
                                           Message message) throws JMSException {

        log.debug("I Got a User Get By Email Request!" + getByEmailMessage);

        userSender.sendGetByEmailReplyMessage(getByEmailMessage.getEmailAddress(), message.getJMSReplyTo());
    }

    @JmsListener(destination = JmsConfig.USER_POST_QUEUE)
    public void listenForUserPostReq(@Payload UserPostMessage postMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) throws JMSException {

        log.debug("I Got a User Post Request!" + postMessage);

        userSender.sendPostReplyMessage(postMessage.getUser(), message.getJMSReplyTo());
    }

    @JmsListener(destination = JmsConfig.USER_PUT_QUEUE)
    public void listenForUserPutReq(@Payload UserPutMessage putMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) throws JMSException {

        log.debug("I Got a User Put Request!" + putMessage);

        userSender.sendPutReplyMessage(putMessage.getId(), putMessage.getUser(), message.getJMSReplyTo());
    }

    @JmsListener(destination = JmsConfig.USER_DELETE_QUEUE)
    public void listenForUserDeleteReq(@Payload UserDeleteMessage deleteMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) throws JMSException {

        log.debug("I Got a User Delete Request!" + deleteMessage);

        userSender.sendDeleteReplyMessage(deleteMessage.getId(), message.getJMSReplyTo());
    }

    @JmsListener(destination = JmsConfig.USER_GETALL_QUEUE)
    public void listenForUserGetAllReq(@Payload UserGetAllMessage getAllMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) throws JMSException {

        log.debug("I Got a User GetAll Request!" + getAllMessage);

        userSender.sendGetAllReplyMessage(message.getJMSReplyTo());
    }
}

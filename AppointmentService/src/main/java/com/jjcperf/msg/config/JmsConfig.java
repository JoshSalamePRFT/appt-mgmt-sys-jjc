package com.jjcperf.msg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {

    public static final String APPT_GET_REQ_QUEUE = "appt-get-req";
    public static final String APPT_POST_REQ_QUEUE = "appt-post-req";
    public static final String APPT_PUT_REQ_QUEUE = "appt-put-req";
    public static final String APPT_DELETE_REQ_QUEUE = "appt-delete-req";
    public static final String APPT_GETALL_REQ_QUEUE = "appt-getall-req";

    public static final String APPT_GET_SEND_QUEUE = "appt-get-send";
    public static final String APPT_POST_SEND_QUEUE = "appt-post-send";
    public static final String APPT_PUT_SEND_QUEUE = "appt-put-send";
    public static final String APPT_DELETE_SEND_QUEUE = "appt-delete-send";
    public static final String APPT_GETALL_SEND_QUEUE = "appt-getall-send";

    public static final String MY_QUEUE = "my-hello-world";
    public static final String MY_SEND_RCV_QUEUE = "replybacktome";

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}

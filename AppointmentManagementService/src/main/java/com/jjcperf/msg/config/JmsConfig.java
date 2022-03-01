package com.jjcperf.msg.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {
    //TODO consider removing the assignment, it's never used.
    public static final String USER_GET_QUEUE = "user-get";
    public static final String USER_POST_QUEUE = "user-post";
    public static final String USER_PUT_QUEUE = "user-put";
    public static final String USER_DELETE_QUEUE = "user-delete";
    public static final String USER_GETALL_QUEUE = "user-getall";
    public static final String USER_GETALLBYAPPTID_QUEUE = "user-getall-by-apptID";

    public static final String APPT_GET_QUEUE = "appt-get";
    public static final String APPT_POST_QUEUE = "appt-post";
    public static final String APPT_PUT_QUEUE = "appt-put";
    public static final String APPT_DELETE_QUEUE = "appt-delete";
    public static final String APPT_GETALL_QUEUE = "appt-getall";
    public static final String APPT_GETALLBYUSERID_QUEUE = "appt-getall-by-userID";

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        converter.setObjectMapper(objectMapper);
        return converter;
    }
}

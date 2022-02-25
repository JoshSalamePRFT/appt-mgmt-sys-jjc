package com.jjcperf.apptmgmtsvc.model;

import lombok.Data;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

//TODO Inherit from a parent class to get audit properties
@Data
public class AppointmentDTO {

    private long appt_id;

    private String apptName;

    private String apptType;

    private String description;

    private Time startTime;

    private Time endTime;

    private String metaData;

    private Set<User> users = new HashSet<>();
}

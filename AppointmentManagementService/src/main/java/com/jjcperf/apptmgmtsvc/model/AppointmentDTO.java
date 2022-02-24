package com.jjcperf.apptmgmtsvc.model;

import lombok.Data;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Data
public class AppointmentDTO extends BaseDTO {

    private String apptName;

    private String apptType;

    private String description;

    private Time startTime;

    private Time endTime;

    private String metaData;

    private Set<User> users = new HashSet<>();
}

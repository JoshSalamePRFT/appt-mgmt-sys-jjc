package com.jjcperf.apptmgmtsvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

//TODO Inherit from a parent class to get audit properties
@Data
public class AppointmentDTO extends BaseDTO {

    private String apptName;

    private String apptType;

    private String description;

    private Time startTime;

    private Time endTime;

    private String metaData;

    @JsonIgnore
    private Set<User> users = new HashSet<>();
}

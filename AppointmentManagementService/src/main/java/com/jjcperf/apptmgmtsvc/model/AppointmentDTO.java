package com.jjcperf.apptmgmtsvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//TODO Inherit from a parent class to get audit properties
@AllArgsConstructor
@Data
public class AppointmentDTO extends BaseDTO {

    private long appointment_id = -1;
    private String apptName;

    private String apptType;

    private String description;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String metaData;

    @JsonIgnore
    private Set<User> users = new HashSet<>();
}

package com.apptGroup.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false, name = "appointment_id")
    private long appointment_id;

    @Column(name="appt_name", nullable = false)
    @NotBlank
    @JsonProperty("apptName") //annotation likely unnecessary.
    private String apptName;

    @Column(name="appt_type")
    @NotBlank
    @JsonProperty("apptType")
    private String apptType;

    @NotBlank
    @JsonProperty("description")
    private String description;

    //startTime and endTime have the format of "YYYY-MM-DDTHH:MM:SS"
    // i.e. "2022-03-12T14:15:00"
    @Column(name="start_time")
    @JsonProperty("startTime")
    private LocalDateTime startTime;

    @Column(name="end_time")
    @JsonProperty("endTime")
    private LocalDateTime endTime;

    @Column(name="meta_data")
    @NotBlank
    @JsonProperty("metaData")
    private String metaData;

    @ManyToMany(mappedBy = "appointments")
    private Set<User> users = new HashSet<>();
}
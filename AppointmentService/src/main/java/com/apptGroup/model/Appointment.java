package com.apptGroup.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    @JsonProperty("appt_id")
    private long appt_id;

    @Column(name="appt_name", nullable = false)
    @NotBlank
    @JsonProperty("apptName")
    private String apptName;

    @Column(name="appt_type")
    @NotBlank
    @JsonProperty("apptType")
    private String apptType;

    @NotBlank
    @JsonProperty("description")
    private String description;

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

}

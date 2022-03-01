package com.jjcperf.apptmgmtsvc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Appointment")
@Table(name = "Appointments")
public class Appointment extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false, name = "appointment_id")
    private long appointment_id;

    @Column(name="appt_name", nullable = false)
    private String apptName;

    @Column(name="appt_type")
    private String apptType;

    private String description;

    @Column(name="start_time")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss", shape=JsonFormat.Shape.STRING)
    private LocalDateTime startTime;

    @Column(name="end_time")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss", shape=JsonFormat.Shape.STRING)
    private LocalDateTime endTime;

    @Column(name="meta_data")
    private String metaData;

    @ManyToMany(mappedBy = "appointments")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

}

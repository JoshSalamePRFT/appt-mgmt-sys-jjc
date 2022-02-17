package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;

@Data
@Entity
@Table
public class Appointment {

    @Id
    private String apptName;
    private String apptType;
    private String description;
    private Time startTime;
    private Time endTime;
    private String metaData;

}

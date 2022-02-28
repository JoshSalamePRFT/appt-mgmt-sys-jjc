package com.jjcperf.apptmgmtsvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//TODO Inherit from a parent class to get audit properties

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String gender;
    //consider making enum

    @PositiveOrZero
    private int age;

    @NotBlank
    @Email
    private String emailAddress;

    @NotBlank
    private String phoneNumber;

    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();

}

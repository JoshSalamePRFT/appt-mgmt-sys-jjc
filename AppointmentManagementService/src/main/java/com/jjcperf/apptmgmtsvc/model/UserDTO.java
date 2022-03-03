package com.jjcperf.apptmgmtsvc.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


//TODO Inherit from a parent class to get audit properties

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class    UserDTO extends BaseDTO {

    private long user_id = -1;

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

    private Set<Appointment> appointments = new HashSet<>();
}

package com.jjcperf.apptmgmtsvc.model;

import com.jjcperf.apptmgmtsvc.phonehandler.Phone;
import com.jjcperf.apptmgmtsvc.phonehandler.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long user_id;

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

    @Columns(columns = {
            @Column(name = "phone_number_value"),
            @Column(name = "phone_number_locale") })
    @Phone
    @Type(type = "com.jjcperf.apptmgmtsvc.phonehandler.PhoneNumberType")
    private PhoneNumber phoneNumber;
}

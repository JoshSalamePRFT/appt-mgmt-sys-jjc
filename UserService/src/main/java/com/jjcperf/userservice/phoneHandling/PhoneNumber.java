package com.jjcperf.userservice.phoneHandling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

//CREDIT TO RAJ https://stackoverflow.com/questions/10631960/validate-mobile-number-using-hibernate-annotation/52003976#52003976

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class PhoneNumber {

    @NotEmpty
    private String value;

    @NotEmpty
    private String locale;
}

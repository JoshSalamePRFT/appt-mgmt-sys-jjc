package com.jjcperf.apptmgmtsvc.phonehandler;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class PhoneNumber {

    @NotEmpty
    private String value;

    @NotEmpty
    private String locale;
}

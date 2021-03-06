package com.jjcperf.apptmgmtsvc.phonehandler;

//CREDIT TO RAJ https://stackoverflow.com/questions/10631960/validate-mobile-number-using-hibernate-annotation/52003976#52003976

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<Phone, PhoneNumber> {

    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(PhoneNumber phoneNumber, ConstraintValidatorContext context) {
        //No null value or locale allowed
        if (phoneNumber.getLocale() == null || phoneNumber.getValue() == null) {
            return false;
        }
        try {
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            return phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(phoneNumber.getValue(), phoneNumber.getLocale()));
        }
        catch (NumberParseException e) {
            return false;
        }
    }
}

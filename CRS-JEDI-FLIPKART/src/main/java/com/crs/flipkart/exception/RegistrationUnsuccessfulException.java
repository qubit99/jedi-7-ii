package com.crs.flipkart.exception;

public class RegistrationUnsuccessfulException extends Exception {

    public RegistrationUnsuccessfulException() {

    }

    @Override
    public String getMessage() {
        return "Registration was unsuccessful";
    }
}

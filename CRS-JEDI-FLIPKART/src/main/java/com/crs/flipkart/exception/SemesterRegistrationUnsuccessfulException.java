package com.crs.flipkart.exception;

public class SemesterRegistrationUnsuccessfulException extends Exception{

    public SemesterRegistrationUnsuccessfulException() {
    }

    @Override
    public String getMessage() {
        return "Semester registration was unsuccessful";
    }
}

package com.crs.flipkart.exception;

public class AddCourseUnsuccessfulException extends Exception {

    public AddCourseUnsuccessfulException() {

    }

    @Override
    public String getMessage() {
        return "Addition of course was unsuccessuful";
    }
}

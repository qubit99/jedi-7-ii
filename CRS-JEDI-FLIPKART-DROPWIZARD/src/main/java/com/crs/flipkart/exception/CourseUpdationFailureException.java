package com.crs.flipkart.exception;

public class CourseUpdationFailureException extends Exception {
    public CourseUpdationFailureException() {
    }

    public String getMessage(){
        return new String("There was a Failure in course updation");
    }}

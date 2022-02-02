package com.crs.flipkart.exception;

public class InvalidCourseIdException extends Exception {
    public InvalidCourseIdException(){}

    @Override
    public String getMessage(){
        return "Course not found!!!";
    }
}

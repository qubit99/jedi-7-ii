package com.crs.flipkart.exception;

public class StudentNotEnrolledException extends Exception{
    public StudentNotEnrolledException() {
    }
    @Override
    public String getMessage(){
        return new String("Student not enrolled in this course");
    }
}

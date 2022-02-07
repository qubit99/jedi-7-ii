package com.crs.flipkart.exception;

public class InvalidStudentIdException extends Exception {
    public InvalidStudentIdException(){}

    @Override
    public String getMessage(){
        return "Student not found!!!";
    }
}

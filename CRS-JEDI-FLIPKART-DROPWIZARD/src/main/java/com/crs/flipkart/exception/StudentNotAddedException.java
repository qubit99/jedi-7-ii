package com.crs.flipkart.exception;

public class StudentNotAddedException extends Exception{
    public StudentNotAddedException(){
    }
    @Override
    public String getMessage() {
        return "Student not found!!!";
    }
}

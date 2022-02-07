package com.crs.flipkart.exception;

public class StudentIdAlreadyInUseException extends  Exception{

    public StudentIdAlreadyInUseException(){
    }

    @Override
    public String getMessage() {
        return "Student Id already in use.Try different student ID";
    }
}

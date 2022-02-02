package com.crs.flipkart.exception;

public class ProfessorNotFoundException extends Exception {
    public ProfessorNotFoundException()
    {

    }
    @Override
    public String getMessage(){
        return "Professor Not Found!";
    }
}

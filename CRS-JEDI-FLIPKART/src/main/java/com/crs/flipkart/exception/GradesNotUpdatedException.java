package com.crs.flipkart.exception;

public class GradesNotUpdatedException extends Exception {

    public GradesNotUpdatedException(){
    }

    @Override
    public String getMessage() {
        return "Grades were not updated due to some error";
    }
}

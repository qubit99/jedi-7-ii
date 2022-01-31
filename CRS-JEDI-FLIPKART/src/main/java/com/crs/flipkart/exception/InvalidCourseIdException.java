package com.crs.flipkart.exception;

public class InvalidCourseIdException extends Exception {
    public InvalidCourseIdException(){
        System.out.println("Course not found!!!");
    }
}

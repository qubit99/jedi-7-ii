package com.crs.flipkart.exception;

public class AlreadyEnrolledInCourseException extends Exception {
    public AlreadyEnrolledInCourseException() {

    }

    @Override
    public String getMessage() {
        return "Student with this studentId is already enrolled in this course";
    }
}

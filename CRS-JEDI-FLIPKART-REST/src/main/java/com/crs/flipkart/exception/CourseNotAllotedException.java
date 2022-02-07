package com.crs.flipkart.exception;

public class CourseNotAllotedException extends Exception{
    public CourseNotAllotedException() {
    }

    public String getMessage(){
        return new String("This Course is not alloted to you");
    }
}

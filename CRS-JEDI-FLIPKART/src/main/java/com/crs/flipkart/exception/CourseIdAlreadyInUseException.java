package com.crs.flipkart.exception;

public class CourseIdAlreadyInUseException extends Exception{
    private String courseId;
    public CourseIdAlreadyInUseException(String courseId){
        this.courseId = courseId;
    }
    @Override
    public String getMessage(){
        return "CourseId-" +this.courseId+ " already in use!";
    }

}

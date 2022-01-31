package com.crs.flipkart.bean;

import java.util.ArrayList;

public class Catalog extends Course {
    /**
     *
     * @param courseId
     * @param courseName
     * @param instructor
     * @param enrolledStudent
     */
    public Catalog(String courseId, String courseName, String instructor, ArrayList<Student> enrolledStudent) {
        super(courseId, courseName, instructor, enrolledStudent);
    }

    public void addCourse() {

    }
    public void removeCourse() {

    }
    public void viewCourse(String courseId) {
        System.out.println();
    }

    public void viewCourseList() {
        System.out.println();
    }
}

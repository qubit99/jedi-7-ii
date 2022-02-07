package com.crs.flipkart.bean;

import java.util.ArrayList;

public class Catalog extends Course {
    /**
     *
     * @param courseId
     * @param courseName
     * @param instructor
     */
    public Catalog(String courseId, String courseName, String instructor) {
        super(courseId, courseName, instructor);
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

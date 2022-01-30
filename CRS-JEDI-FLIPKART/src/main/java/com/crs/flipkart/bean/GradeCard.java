package com.crs.flipkart.bean;

import java.util.ArrayList;

public class GradeCard {
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public float getSgpa() {
        return sgpa;
    }

    public void setSgpa(float sgpa) {
        this.sgpa = sgpa;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public ArrayList<Course> getRegisteredCourse() {
        return registeredCourse;
    }

    public void setRegisteredCourse(ArrayList<Course> registeredCourse) {
        this.registeredCourse = registeredCourse;
    }

    private String studentId;
    private int semester;
    private float sgpa;
    private boolean published;
    private ArrayList<Course> registeredCourse;
}

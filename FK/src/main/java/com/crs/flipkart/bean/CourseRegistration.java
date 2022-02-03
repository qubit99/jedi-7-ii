package com.crs.flipkart.bean;

import java.util.ArrayList;

public class CourseRegistration {

    private ArrayList<String> primaryCourses;
    private ArrayList<String> secondaryCourses;
    private String semester;

    /**
     *
     * @param primaryCourses
     * @param secondaryCourses
     * @param semester
     */
    public CourseRegistration(ArrayList<String> primaryCourses, ArrayList<String> secondaryCourses, String semester) {
        this.primaryCourses = primaryCourses;
        this.secondaryCourses = secondaryCourses;
        this.semester = semester;
    }




    public  ArrayList<String> getPrimaryCourses() {
        return primaryCourses;
    }
    public void setPrimaryCourses(ArrayList<String> primaryCourses) {
        this.primaryCourses = primaryCourses;
    }
    public  ArrayList<String> getSecondaryCourses() {
        return secondaryCourses;
    }
    public void setSecondaryCourses(ArrayList<String> secondaryCourses) {
        this.secondaryCourses = secondaryCourses;
    }
    public String getSemester() {
        return semester;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
}
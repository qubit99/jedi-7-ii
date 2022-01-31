package com.crs.flipkart.bean;

import java.util.ArrayList;

public class Course {

    private String courseName;
    private String courseId;
    private String instructor;
    private ArrayList<Student> enrolledStudent;

    /**
     *
     * @param courseId
     * @param courseName
     * @param instructor
     * @param enrolledStudent
     */
    public Course(String courseId, String courseName, String instructor, ArrayList<Student> enrolledStudent) {
        super();
        this.courseName = courseName;
        this.courseId = courseId;
        this.instructor = instructor;
        this.enrolledStudent = enrolledStudent;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    public ArrayList<Student> getEnrolledStudent() {
        return enrolledStudent;
    }
    public void setEnrolledStudent(ArrayList<Student> enrolledStudent) {
        this.enrolledStudent = enrolledStudent;
    }

}
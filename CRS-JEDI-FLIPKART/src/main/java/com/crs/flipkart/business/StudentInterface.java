package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import javafx.util.Pair;

import java.util.ArrayList;

public interface StudentInterface {
    public void registerStudent(Student student);
    public void viewGradeCard(String rollNo);
    public void registerForCourses(String rollNo,ArrayList<String> courseIds);
    public ArrayList<Course> viewAllCourses();
    public void addCourse(String rollNo);
    public void removeCourse(String rollNo);
    public ArrayList<Pair<String, String>> viewEnrolledCourses(String rollNo);
}

package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import javafx.util.Pair;

import java.util.ArrayList;

public interface StudentDaoInterface {
    /**
     *
     * @param st
     */
    public void registerStudent(Student st);

    /**
     *
     * @param rollNo
     * @param courseIds
     */
    public void registerForCourses(String rollNo, ArrayList<String> courseIds);

    /**
     *
     * @return
     */
    public ArrayList<Course> getAllCourses();

    /**
     *
     * @param rollNo
     * @return
     */
    public ArrayList<Pair<String,String>> getEnrolledCourses(String rollNo);

    /**
     *
     * @param rollNo
     * @param courseId
     */
    public void addCourse(String rollNo,String courseId);

    /**
     *
     * @param rollNo
     * @param courseId
     */
    public void removeCourse(String rollNo, String courseId);

    /**
     *
     * @param rollNo
     * @return
     */
    public ArrayList<Pair<String,String>> getGradeCard(String rollNo);
}

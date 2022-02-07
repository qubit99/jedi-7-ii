package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public interface ProfessorDaoInterface {
    /**
     *
     * @param profId
     * @return
     * @throws ProfessorNotFoundException
     */
    public List<Course> getTeachingCourses(String profId);

    /**
     *
     * @param courseId
     * @return
     */
    public List<Pair<String,String>> getEnrolledStudents(String courseId);

    /**
     *
     * @param studentid
     * @param courseId
     * @param grade
     * @throws InvalidGradeException
     */
    public Boolean giveGrades(String studentid,String profId, String courseId, String grade);

    public Boolean selectTeachingCourses(String profId, String courseId);

    public ArrayList<Course> getAvailableCourses();



}

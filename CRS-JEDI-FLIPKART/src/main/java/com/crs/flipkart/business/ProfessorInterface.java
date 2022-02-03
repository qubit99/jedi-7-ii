package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public interface ProfessorInterface {

    /**
     * Function to view courses a professor is teaching
     * @param profid
     * @return List of courses professor is teaching
     */
    public List<Course> viewTeachingCourses(String profid) throws ProfessorNotFoundException;

    /**
     * Function to view enrolled students for a course
     * @return List of students enrolled in the course
     * @exception InvalidCourseIdException
     */
    public List<Pair<PersonalDetails,String>> viewEnrolledStudents(String courseId) throws InvalidCourseIdException;

    /**
     * Function to give grades to students
     * @param studentid, Course Id, HashTable of StudentId and Grade given
     * @exception InvalidGradeException
     */
    public Boolean giveGrades(String studentid,String profID, String courseId, String grade);


    public Boolean selectTeachingCourses(String profId, String courseId) throws CourseUpdationFailureException;

    public ArrayList<Course> viewAvailableCourses();
}

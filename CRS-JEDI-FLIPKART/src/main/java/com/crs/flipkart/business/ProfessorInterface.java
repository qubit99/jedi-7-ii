package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.InvalidCourseIdException;
import com.crs.flipkart.exception.InvalidGradeException;
import com.crs.flipkart.exception.ProfessorNotFoundException;
import com.crs.flipkart.exception.UserNotFoundException;

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
     * @param profid
     * @return List of students enrolled in the course
     * @exception InvalidCourseIdException
     */
    public List<Student> viewEnrolledStudents(String profid, String courseId) throws InvalidCourseIdException;

    /**
     * Function to give grades to students
     * @param studentid, Course Id, HashTable of StudentId and Grade given
     * @exception InvalidGradeException
     */
    public void giveGrades(String studentid, String courseId, String grade) throws InvalidGradeException;

}

package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.InvalidCourseIdException;
import com.crs.flipkart.exception.InvalidGradeException;
import com.crs.flipkart.exception.ProfessorNotFoundException;

import java.util.List;

public interface ProfessorDaoInterface {
    /**
     *
     * @param profId
     * @return
     * @throws ProfessorNotFoundException
     */
    public List<Course> getTeachingCourses(String profId) throws ProfessorNotFoundException;

    /**
     *
     * @param profid
     * @param courseId
     * @return
     * @throws InvalidCourseIdException
     */
    public List<Student> getEnrolledStudents(String profid, String courseId) throws InvalidCourseIdException;

    /**
     *
     * @param studentid
     * @param courseId
     * @param grade
     * @throws InvalidGradeException
     */
    public void giveGrades(String studentid, String courseId, String grade) throws InvalidGradeException;
}

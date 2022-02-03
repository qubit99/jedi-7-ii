package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.*;
import javafx.util.Pair;

import java.util.ArrayList;

public interface StudentDaoInterface {
    /**
     * @param st
     */
    public Boolean registerStudent(Student st) throws RegistrationUnsuccessfulException, StudentIdAlreadyInUseException, UserIdAlreadyInUseException;

    /**
     * @param rollNo
     * @param courseIds
     */
    public Boolean registerForCourses(String rollNo, ArrayList<String> courseIds) throws SemesterRegistrationUnsuccessfulException;

    /**
     * @return
     */
    public ArrayList<Course> getAllCourses();

    /**
     * @param rollNo
     * @return
     */
    public ArrayList<Pair<String, String>> getEnrolledCourses(String rollNo);

    /**
     * @param rollNo
     * @param courseId
     */
    public Boolean addCourse(String rollNo, String courseId) throws AddCourseUnsuccessfulException;

    /**
     * @param rollNo
     * @param courseId
     */
    public Boolean removeCourse(String rollNo, String courseId) throws CourseRemovalUnsuccessfulException;

    /**
     * @param rollNo
     * @return
     */
    public ArrayList<Pair<String, String>> getGradeCard(String rollNo);

    public String payFees(String rollNo) throws FeesPaymentUnsuccessfulException;

    public String updateNotification(String rollNo, String message) throws NotificationUpdateUnsuccessfulException;

}

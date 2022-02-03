package com.crs.flipkart.business;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.exception.*;
import javafx.util.Pair;

import java.util.ArrayList;

public interface StudentInterface {
    public ArrayList<Pair<String,String>> viewGradeCard(String rollNo);
    public Boolean registerForCourses(String rollNo,ArrayList<String> courseIds) throws SemesterRegistrationUnsuccessfulException;
    public ArrayList<Course> viewAllCourses();
    public Boolean addCourse(String rollNo,String courseId) throws AddCourseUnsuccessfulException;
    public Boolean removeCourse(String rollNo,String courseId) throws CourseRemovalUnsuccessfulException;
    public ArrayList<Pair<String, String>> viewEnrolledCourses(String rollNo);
    public String getRollNo(String userId);
    public ArrayList<Notification> getNotifications(String rollNo);
    public String payFees(String rollNo) throws FeesPaymentUnsuccessfulException;
    public String updateNotification(String rollNo,String message) throws NotificationUpdateUnsuccessfulException;

}

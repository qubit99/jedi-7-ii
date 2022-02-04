package com.crs.flipkart.business;

import com.crs.flipkart.bean.*;
import com.crs.flipkart.dao.StudentDaoOperation;
import com.crs.flipkart.exception.*;
import javafx.util.Pair;

import java.util.ArrayList;

public class StudentService implements StudentInterface{

    StudentDaoOperation studentDaoOperation = new StudentDaoOperation();


    public Boolean registerForCourses(String rollNo,ArrayList<String> courseIds) throws SemesterRegistrationUnsuccessfulException {
        return studentDaoOperation.registerForCourses(rollNo,courseIds);
    }

    public ArrayList<Course> viewAllCourses(){
        return studentDaoOperation.getAllCourses();
    }

    @Override
    public ArrayList<Pair<String, String>> viewEnrolledCourses(String rollNo) {
       return studentDaoOperation.getEnrolledCourses(rollNo);
    }

    @Override
    public String getRollNo(String userId) {
        return studentDaoOperation.getRollNo(userId);
    }

    @Override
    public ArrayList<Notification> getNotifications(String rollNo) {
        return studentDaoOperation.getNotifications(rollNo);
    }

    @Override
    public String payFees(String rollNo) throws FeesPaymentUnsuccessfulException{
        return studentDaoOperation.payFees(rollNo);
    }

    @Override
    public String updateNotification(String rollNo, String message) throws NotificationUpdateUnsuccessfulException {
        return studentDaoOperation.updateNotification(rollNo,message);
    }

    public Boolean addCourse(String rollNo,String courseId) throws AddCourseUnsuccessfulException {
        return studentDaoOperation.addCourse(rollNo,courseId);
    @Override
    public boolean isApproved(String id) {
        return studentDaoOperation.isApproved(id);
    }

    
    


    public Boolean removeCourse(String rollNo,String courseId) throws CourseRemovalUnsuccessfulException {
        return studentDaoOperation.removeCourse(rollNo,courseId);
    }

    public ArrayList<Pair<String, String>> viewGradeCard(String rollNo){
        return studentDaoOperation.getGradeCard(rollNo);
    }
}

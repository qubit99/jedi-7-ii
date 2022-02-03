package com.crs.flipkart.business;

import com.crs.flipkart.bean.*;
import com.crs.flipkart.dao.StudentDaoOperation;
import com.crs.flipkart.exception.FeesPaymentUnsuccessfulException;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService implements StudentInterface{

    StudentDaoOperation studentDaoOperation = new StudentDaoOperation();
    public void registerStudent(Student newStudent){
        studentDaoOperation.registerStudent(newStudent);
    }

    public void registerForCourses(String rollNo,ArrayList<String> courseIds){
        studentDaoOperation.registerForCourses(rollNo,courseIds);
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
    public void payFees(String rollNo) {
        try{
            studentDaoOperation.payFees(rollNo);
        }
        catch(FeesPaymentUnsuccessfulException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isApproved(String id) {
        return studentDaoOperation.isApproved(id);
    }

    public void addCourse(String rollNo){
        System.out.println("These are your already enrolled courses");
        ArrayList<Pair<String, String>> courses = studentDaoOperation.getEnrolledCourses(rollNo);
        ArrayList<String> courseIds = new ArrayList<String>();
        System.out.println("Course ID : Course Name");
        for(Pair<String,String> course: courses)
            System.out.println(course.getKey() + " - " + course.getValue());
        for(Pair<String,String> course : courses)
            courseIds.add(course.getKey());
        System.out.println(courseIds);

        while(true){
            System.out.println("Enter the courseId you want to add");
            System.out.println("or Press -1 to exit");

            Scanner sc = new Scanner(System.in);
            String courseId = sc.nextLine();
            if(courseId.equals("-1"))
                break;

            if(courseIds.contains(courseId))
                System.out.println("You are already enrolled in this course");
            else{
                studentDaoOperation.addCourse(rollNo,courseId);
                break;
            }
        }
    }


    public void removeCourse(String rollNo) {

        System.out.println("These are your already enrolled courses");
        ArrayList<Pair<String, String>> courses = studentDaoOperation.getEnrolledCourses(rollNo);
        ArrayList<String> courseIds = new ArrayList<String>();
        System.out.println("Course ID : Course Name");
        for(Pair<String,String> course: courses)
            System.out.println(course.getKey() + " - " + course.getValue());
        for(Pair<String,String> course : courses)
            courseIds.add(course.getKey());
        System.out.println(courseIds);

        while (true) {
            System.out.println("Enter the courseId you want to remove");
            System.out.println("or Press -1 to exit");
            Scanner sc = new Scanner(System.in);
            String courseId = sc.nextLine();

            if (courseId.equals("-1"))
                break;

            if (courseIds.contains(courseId)) {
                studentDaoOperation.removeCourse(rollNo, courseId);
                break;
            } else
                System.out.println("This course is not in your course list");
        }
    }

    public ArrayList<Pair<String, String>> viewGradeCard(String rollNo){
        return studentDaoOperation.getGradeCard(rollNo);
    }
}

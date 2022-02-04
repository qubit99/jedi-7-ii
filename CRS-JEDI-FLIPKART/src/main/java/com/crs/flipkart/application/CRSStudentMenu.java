package com.crs.flipkart.application;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.business.StudentInterface;
import com.crs.flipkart.business.StudentService;

import com.crs.flipkart.exception.*;
import javafx.util.Pair;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class CRSStudentMenu {

    public void CRSStudentMenu(String rollNo){


        StudentInterface studentInterface = new StudentService();

        while(true){
            System.out.println("=====WELCOME TO STUDENT MENU=====");
            System.out.println("Press 1 : View All Courses");
            System.out.println("Press 2 : Semester Registration");
            System.out.println("Press 3 : View Enrolled Courses");
            System.out.println("Press 4 : Add Course");
            System.out.println("Press 5 : Remove Course");
            System.out.println("Press 6 : View Grade Card ");
            System.out.println("Press 7 : View Notifications ");
            System.out.println("Press 8 : Pay Fees");
            System.out.println("Press 9 : Exit");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();


            switch (choice){
                case 1 : {
                    ArrayList<Course> courses = studentInterface.viewAllCourses();
                    System.out.println("CourseId  : CourseName");
                    courses.forEach(course -> System.out.println(course.getCourseId() + "  -  " + course.getCourseName()));
                    break;
                }
                case 2 :{
                    ArrayList<String> courseIds = new ArrayList<String>();
                    String courseId;

                    System.out.println("Enter your 4 primary choices");

                    System.out.println("Enter courseId of your 1st choice");
                    courseId = sc.next();
                    courseIds.add(courseId);

                    System.out.println("Enter courseId of your 2nd choice");
                    courseId = sc.next();
                    courseIds.add(courseId);

                    System.out.println("Enter courseId of your 3rd choice");
                    courseId = sc.next();
                    courseIds.add(courseId);

                    System.out.println("Enter courseId of your 4th choice");
                    courseId = sc.next();
                    courseIds.add(courseId);

                    System.out.println("Enter your 2 secondary choices");

                    System.out.println("Enter courseId of your 1st choice");
                    courseId = sc.next();
                    courseIds.add(courseId);

                    System.out.println("Enter courseId of your 2nd choice");
                    courseId = sc.next();
                    courseIds.add(courseId);
                    try {
                        Boolean status = studentInterface.registerForCourses(rollNo, courseIds);
                        if (status)
                            System.out.println("Your Semester Registration was done successfully");
                    }
                    catch (SemesterRegistrationUnsuccessfulException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3:{
                    ArrayList<Pair<String, String>> enrolledCourses = studentInterface.viewEnrolledCourses(rollNo);
                    enrolledCourses.forEach(enrolledCourse -> System.out.println(enrolledCourse.getKey()+ "  -  " + enrolledCourse.getValue()));
                    break;
                }
                case 4:{
                    System.out.println("These are your already enrolled courses");
                    ArrayList<Pair<String, String>> courses = studentInterface.viewEnrolledCourses(rollNo);
                    ArrayList<Course> allCourses = studentInterface.viewAllCourses();
                    ArrayList<String> courseIds = new ArrayList<>();
                    ArrayList<String> allCourseIds = new ArrayList<>();
                    System.out.println("Course ID : Course Name");
                    for(Pair<String,String> course: courses)
                        System.out.println(course.getKey() + " - " + course.getValue());
                    for(Pair<String,String> course : courses)
                        courseIds.add(course.getKey());
                    for(Course course : allCourses)
                        allCourseIds.add(course.getCourseId());
                    System.out.println("Enter the courseId you want to add");


                    String courseId = sc.next();
                    try {
                        if (!allCourseIds.contains(courseId))
                            throw new InvalidCourseIdException();
                        if (courseIds.contains(courseId))
                            throw new AlreadyEnrolledInCourseException();
                        Boolean status = studentInterface.addCourse(rollNo,courseId);
                        if(status)
                            System.out.println("Course with courseId:"+ courseId + " was added succesfully to studentId:"+rollNo);
                        else
                            throw new AddCourseUnsuccessfulException();
                    }catch (InvalidCourseIdException | AlreadyEnrolledInCourseException | AddCourseUnsuccessfulException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5:{
                    System.out.println("These are your already enrolled courses");
                    ArrayList<Pair<String, String>> courses = studentInterface.viewEnrolledCourses(rollNo);
                    ArrayList<Course> allCourses = studentInterface.viewAllCourses();
                    ArrayList<String> courseIds = new ArrayList<>();
                    ArrayList<String> existingCourseIds = new ArrayList<>();
                    System.out.println("Course ID : Course Name");
                    for(Pair<String,String> course: courses)
                        System.out.println(course.getKey() + " - " + course.getValue());
                    for(Pair<String,String> course : courses)
                        courseIds.add(course.getKey());
                    for(Course course : allCourses)
                        existingCourseIds.add(course.getCourseId());
                    System.out.println("Enter the courseId you want to remove");

                    String courseId = sc.next();
                    try {
                        if (!existingCourseIds.contains(courseId))
                            throw new InvalidCourseIdException();
                        if (!courseIds.contains(courseId))
                            throw new StudentNotEnrolledException();
                        Boolean status = studentInterface.removeCourse(rollNo,courseId);
                        if(status)
                            System.out.println("Course with courseId:"+ courseId + " was removed succesfully to studentId:"+rollNo);
                        else
                            throw new CourseRemovalUnsuccessfulException();
                    } catch (StudentNotEnrolledException | InvalidCourseIdException  | CourseRemovalUnsuccessfulException  e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6:{
                    ArrayList<Pair<String,String>> gradeCard = studentInterface.viewGradeCard(rollNo);
                    System.out.println("******GRADE CARD***********");
                    for(int i=0;i< gradeCard.size();i++) {
                        System.out.println(gradeCard.get(i).getKey() + ":"+gradeCard.get(i).getValue());
                    }
                    break;
                }
                case 7:{
                    ArrayList<Notification>  notifications = studentInterface.getNotifications(rollNo);
                    if(notifications==null || notifications.isEmpty()) {
                        System.out.println("no Notifications");
                        break;
                    }
                    for(Notification notification : notifications) {
                        System.out.println("Notification ID:" + notification.getNotificationID());
                        System.out.println("Notification:"+ notification.getMessage());
                    }
                    break;
                }
                case 8:{
                    try {
                        String transactionID = studentInterface.payFees(rollNo);
                        if(transactionID!= null && !transactionID.isEmpty()){
                            System.out.println("Fees Payment was successful");
                            LocalDate date = LocalDate.now();
                            LocalTime time = LocalTime.now();
                            String message = new String("Fees Payment with transactionID:" + transactionID + " is done successfully on DATE:" + date.toString() + " and TIME:" + time.toString());
                            System.out.println(message);
                            String notificationId = studentInterface.updateNotification(rollNo, message);
                            if(notificationId!=null && !notificationId.isEmpty()){
                                System.out.println("Notification of Fees with " + notificationId + " was updated successfully");
                            }
                            else
                                throw new NotificationUpdateUnsuccessfulException();
                        }
                    }
                    catch(FeesPaymentUnsuccessfulException | NotificationUpdateUnsuccessfulException e ) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 9:
                    return ;
            }
        }
    }
}

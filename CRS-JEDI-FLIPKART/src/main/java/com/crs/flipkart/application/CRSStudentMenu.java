package com.crs.flipkart.application;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.business.StudentInterface;
import com.crs.flipkart.business.StudentService;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class CRSStudentMenu {

    public void CRSStudentMenu(String userId,String rollNo){


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
                    for(Course course : courses)
                        System.out.println(course.getCourseId() + "  -  " + course.getCourseName());
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
                    studentInterface.registerForCourses(rollNo,courseIds);
                    break;
                }
                case 3:{
                    ArrayList<Pair<String, String>> enrolledCourses = studentInterface.viewEnrolledCourses(rollNo);
                    for (Pair<String,String> enrolledCourse : enrolledCourses)
                        System.out.println(enrolledCourse.getKey()+ "  -  " + enrolledCourse.getValue());
                    break;
                }
                case 4:{
                    studentInterface.addCourse(rollNo);
                    break;
                }
                case 5:{
                    studentInterface.removeCourse(rollNo);
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
                }
                case 8:{
                    studentInterface.payFees(rollNo);
                    break;
                }
                case 9:
                    return ;
            }

        }

    }
}

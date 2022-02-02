package com.crs.flipkart.application;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.business.StudentInterface;
import com.crs.flipkart.business.StudentService;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class CRSStudentMenu {

    public void CRSStudentMenu(String userId,String rollNo){


        StudentInterface studentInterface = new StudentService();

        while(true){
            System.out.println("WELCOME TO STUDENT MENU");
            System.out.println("Press 1 : View All Courses");
            System.out.println("Press 2 : Semester Registration");
            System.out.println("Press 3 : View Enrolled Courses");
            System.out.println("Press 4 : Add Course");
            System.out.println("Press 5 : Remove Course");
            System.out.println("Press 6 : View Grade Card ");
            System.out.println("Press 7 : Exit");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();


            switch (choice){
                case 1 : {
                    ArrayList<Course> courses = studentInterface.viewAllCourses();
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
                    studentInterface.viewGradeCard(rollNo);
                    break;
                }
                case 7:
                    return ;
            }

        }

    }
}

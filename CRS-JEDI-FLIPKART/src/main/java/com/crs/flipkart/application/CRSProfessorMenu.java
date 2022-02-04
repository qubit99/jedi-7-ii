package com.crs.flipkart.application;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Grade;
import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminInterface;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.ProfessorInterface;
import com.crs.flipkart.business.ProfessorService;
import com.crs.flipkart.exception.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRSProfessorMenu {
    Scanner scanner = new Scanner(System.in);

    public void CRSProfessorMenu() {}

    public void profChoice(String profId) throws ProfessorNotFoundException, InvalidCourseIdException {
        AdminInterface adminService = new AdminService();
        ProfessorInterface profService = new ProfessorService();

        int choice;
        do {
            System.out.println("=====WELCOME TO PROFESSOR MENU=====");
            System.out.println("You have the following choices: ");
            System.out.println("Enter 1 to view all courses");
            System.out.println("Enter 2 to view teaching courses");
            System.out.println("Enter 3 to view enrolled students");
            System.out.println("Enter 4 to give grades");
            System.out.println("Enter 5 to select teaching Courses");
            System.out.println("Enter 6 to view available Courses");
            System.out.println("Enter 7 to exit");
            choice = scanner.nextInt();
            if(choice==1) {
                System.out.println("Displaying all courses: ");
                List<Course> courses = adminService.viewAllCourses();
                courses.forEach(course -> System.out.println(course.getCourseName() + "------------" + course.getInstructor()));
            }
            else if(choice==2) {
                System.out.println("Displaying courses that you teach: ");
                List<Course> courses = profService.viewTeachingCourses(profId);
                courses.forEach(course -> System.out.println(course.getCourseName() + "------------" + course.getCourseId()));
            }
            else if(choice==3) {
                System.out.println("Displaying students enrolled under you: ");
                List<Course> courses = profService.viewTeachingCourses(profId);
                for(Course course : courses){
                    System.out.println(course.getCourseName() + "------------" + course.getCourseId());
                    List<Pair<PersonalDetails,String>> students = profService.viewEnrolledStudents(course.getCourseId());
                    if(students.size()==0)
                        System.out.println("No students enrolled under this course");

                    students.forEach(student -> {
                        String name = student.getKey().getName();
                        String rollNo = student.getValue();
                        System.out.println(name+ " "+ rollNo);
                    });
                }
                if(courses.size()==0)
                    System.out.println("Currently yor are not teaching any courses");
            }
            else if(choice==4) {
                System.out.println("Give Grades: ");
                System.out.println("Enter course id: ");
                String cid = scanner.next();
                while(true) {
                    System.out.println("Enter the details or  Enter 0 to quit.");
                    System.out.println("Enter student Roll No: ");
                    String sid = scanner.next();
                    if(sid.equals("0")) {
                        break;
                    }
                    System.out.println("Enter the grade: ");
                    String sgrade = scanner.next();
                    profService.giveGrades(sid,profId, cid, sgrade);
                }
            }
            else if(choice==5) {
                System.out.println("Enter the courseId you want to teach");
                Scanner sc = new Scanner(System.in);
                String courseId = sc.nextLine();
                try {
                    if(!profService.selectTeachingCourses(profId, courseId))
                        throw new CourseUpdationFailureException();
                    System.out.println("Course with courseId:" + courseId + " is added successfullly under your teaching courses");
                }
                catch(CourseUpdationFailureException e){
                    System.out.println(e.getMessage());
                }
            }
            else if(choice==6) {
                System.out.println("Available courses you can opt to teach");
                ArrayList<Course> courses = profService.viewAvailableCourses();
                courses.forEach(course -> System.out.println(course.getCourseId() + " " + course.getCourseName()));
            }
            else if(choice==7) {
                System.out.println("Logged out");
                break;
            }
        } while(true);

        System.out.println("Returning to the main menu");
    }

}

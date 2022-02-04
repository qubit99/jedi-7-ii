package com.crs.flipkart.application;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminInterface;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.ProfessorInterface;
import com.crs.flipkart.business.ProfessorService;
import com.crs.flipkart.exception.InvalidCourseIdException;
import com.crs.flipkart.exception.InvalidGradeException;
import com.crs.flipkart.exception.ProfessorNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRSProfessorMenu {
    Scanner scanner = new Scanner(System.in);

    public void CRSProfessorMenu() {}

    public void profChoice(String profId) throws ProfessorNotFoundException, InvalidCourseIdException {
        AdminInterface adminService = new AdminService();
        ProfessorInterface profService = new ProfessorService();

        System.out.println("=====WELCOME TO PROFESSOR MENU=====");
        System.out.println("You have the following choices: ");
        System.out.println("Enter 1 to view all courses");
        System.out.println("Enter 2 to view teaching courses");
        System.out.println("Enter 3 to view enrolled students");
        System.out.println("Enter 4 to give grades");
        System.out.println("Enter 5 to exit");

        int choice;
        do {
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
                    List<PersonalDetails> students = profService.viewEnrolledStudents(profId, course.getCourseId());
                    students.forEach(student -> System.out.println(student.getName()));
                }
            }
            else if(choice==4) {
                System.out.println("Give Grades: ");
                System.out.println("Enter course id: ");
                String cid = scanner.next();
                System.out.println("Enter the grades. Enter 0 to quit.");
                while(true) {
                    System.out.println("Enter student id: ");
                    String sid = scanner.next();
                    if(sid.equals("0")) {
                        break;
                    }
                    System.out.println("Enter the grade: ");
                    String sgrade = scanner.next();
                    if(sgrade.equals("0")) {
                        break;
                    }
                    try {
                        profService.giveGrades(sid, cid, sgrade);
                    }catch (InvalidGradeException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if(choice==5) {
                System.out.println("Logged out");
                break;
            }
        } while(true);

        System.out.println("Returning to the main menu");
    }

}

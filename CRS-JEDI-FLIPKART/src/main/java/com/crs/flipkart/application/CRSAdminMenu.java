package com.crs.flipkart.application;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.DummyDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CRSAdminMenu {
    Scanner scanner = new Scanner(System.in);

    public void CRSAdminMenu(String adminId) {

    }

    public void adminChoice(String adminId) {
        AdminService adminService = new AdminService();
        System.out.println("=====Admin Menu=====");
        System.out.println("You have the following choices: ");
        System.out.println("Enter 1 to view all courses");
        System.out.println("Enter 2 to view all students");
        System.out.println("Enter 3 to add course");
        System.out.println("Enter 4 to remove course");
        System.out.println("Enter 5 to add new professor");
        System.out.println("Enter 6 to verify student registration");
        System.out.println("Enter 7 to remove student");
        System.out.println("Enter 8 to remove professor");
        System.out.println("Enter 9 to exit");

        int choice;
        do {
            choice = scanner.nextInt();
            if(choice==1) {
                System.out.println("Displaying all Courses: ");
                List<Course> courses = adminService.viewAllCourses();
                for(Course course : courses){
                    System.out.println(course.getCourseName() + "------------" + course.getInstructor());
                }
            }
            else if(choice==2) {
                System.out.println("All students");
                ArrayList<Student> students = adminService.viewAllStudents();
                for(Student student : students){
                    System.out.println(student.getPd().getName());
                }


            }
            else if(choice==3) {
                System.out.println("Drop course: ");
                System.out.println("enter course id: ");
            }
            else if(choice==4) {

            }
            else if(choice==5) {

            }
            else if(choice==6) {

            }
            else if(choice==7) {

            }

            else if(choice==8) {
                break;
            }
            else if(choice==9) {
                System.out.println("Logged out");
                return;
            }
        } while(true);

        System.out.println("Returning to the main menu");

        System.out.println(adminId);
    }

}

package com.crs.flipkart.application;

import com.crs.flipkart.business.StudentService;

import java.util.Scanner;

public class CRSStudentMenu {
    Scanner scanner = new Scanner(System.in);

    public void CRSStudentMenu(String studentId) {

    }

    public void studentChoice(String studentId) {
        System.out.println("=====Student Menu=====");
        System.out.println("You have the following choices: ");
        System.out.println("Enter 1 to view all courses");
        System.out.println("Enter 2 for course registration");
        System.out.println("Enter 3 to add course");
        System.out.println("Enter 4 to drop course");
        System.out.println("Enter 5 to view registered courses");
        System.out.println("Enter 6 to view grades/Grade Card");
        System.out.println("Enter 7 to view notifications");
        System.out.println("Enter 8 to pay fees");
        System.out.println("Enter 9 to exit");

        int choice = scanner.nextInt();

        StudentService student = new StudentService();

        switch(choice) {
            case 1:
                //student.viewCourses();
                break;
            case 2:
                student.registerForCourses();
                break;
            case 3:
                //student.addCourse(student_id);
                break;
            case 4:
                //student.removeCourse(student_id);
                break;
            case 5:
                //student.viewGradeCard();
                break;
            case 6:
                //getGrades(student_id);
                break;
            case 7:
                //showNotifications(student_id);
                break;
            case 8:
                //payFees(student_id);
                break;
            case 9:
                System.out.println("Logged Out Successfully!\n");
                return;

        }


        System.out.println(studentId);
    }
}

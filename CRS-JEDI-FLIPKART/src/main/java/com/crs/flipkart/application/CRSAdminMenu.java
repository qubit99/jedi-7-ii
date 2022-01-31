package com.crs.flipkart.application;

import java.util.Scanner;

public class CRSAdminMenu {
    Scanner scanner = new Scanner(System.in);

    public void CRSAdminMenu(String adminId) {

    }

    public void adminChoice(String adminId) {
        System.out.println("=====Admin Menu=====");
        System.out.println("You have the following choices: ");
        System.out.println("Enter 1 to view all courses");
        System.out.println("Enter 2 to add course");
        System.out.println("Enter 3 to remove course");
        System.out.println("Enter 4 to add new professor");
        System.out.println("Enter 5 to verify student registration");
        System.out.println("Enter 6 to remove student");
        System.out.println("Enter 7 to remove professor");
        System.out.println("Enter 8 to exit");

        int choice;
        do {
            choice = scanner.nextInt();
            if(choice==1) {
                System.out.println("Displaying all Courses: ");
            }
            else if(choice==2) {
                System.out.println("Add new course: ");
                System.out.println("enter course id: ");

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
        } while(true);

        System.out.println("Returning to the main menu");

        System.out.println(adminId);
    }

}

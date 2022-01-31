package com.crs.flipkart.application;

import com.crs.flipkart.business.UserInterface;
import com.crs.flipkart.business.UserService;

import java.util.Scanner;

public class CRSApplication {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CRSApplication client = new CRSApplication();
        client.mainMenu();
        int choice;

        do {
            choice = scanner.nextInt();
            System.out.println("You entered: "+choice);
            if(choice==1) {
                client.login();
            }
            else if(choice==2) {
                client.registerNew();
            }
            else if(choice==3) {
                client.updatePassword();
            }
            else if(choice==4) {
                break;
            }
            client.mainMenu();
        } while (choice!=3);

        System.out.println("Thank you!");
    }

    public void mainMenu() {
        System.out.println("=====CRS Application=====");
        System.out.println("You have the following choices: ");
        System.out.println("Enter 1 for login");
        System.out.println("Enter 2 for new student registration");
        System.out.println("Enter 3 to update password");
        System.out.println("Enter 4 to exit");
    }

    public void login() {
        System.out.println("=====Login=====");
        System.out.println("Enter your user id: ");
        String userId = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter your password: ");
        String userPass = scanner.nextLine();

        UserInterface user = new UserService();

        if(user.verifyCredentials(userId, userPass)) {
            String role = user.getRole(userId);
            System.out.println("login successful!");
            System.out.println("Role: "+role);
            if(role.equals("admin")) {
                CRSAdminMenu clientAdmin = new CRSAdminMenu();
                clientAdmin.adminChoice(userId);
            }
            else if(role.equals("student")) {
                CRSStudentMenu clientStudent = new CRSStudentMenu();
            }
            else if(role.equals("professor")) {
                CRSProfessorMenu clientProf = new CRSProfessorMenu();

            }
        }
        else {
            System.out.println("incorrect id or password");
        }
    }

    public void registerNew() {
        System.out.println("=====New Student Registration=====");

    }

    public void updatePassword() {
        System.out.println("=====Password Update=====");

    }
}

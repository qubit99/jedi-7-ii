package com.crs.flipkart.application;

import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;

import com.crs.flipkart.business.DummyDB;
import com.crs.flipkart.business.UserInterface;
import com.crs.flipkart.business.UserService;
import com.crs.flipkart.exception.UserNotFoundException;
import com.crs.flipkart.exception.WrongPasswordException;

import java.util.Scanner;

public class CRSApplication {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DummyDB.createDatabase();

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
        } while (true);

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
        String userId = scanner.next();
        System.out.println("Enter your password: ");
        String userPass = scanner.next();

        UserInterface user = new UserService();

        try {
            user.verifyCredentials(userId, userPass);
            System.out.println("login successful!");
            String role = user.getRole(userId);
            System.out.println("Role: "+role);
            if(role.equals("admin")) {
                CRSAdminMenu clientAdmin = new CRSAdminMenu();
                clientAdmin.adminChoice(userId);
            }
            else if(role.equals("student")) {
                CRSStudentMenu clientStudent = new CRSStudentMenu();
                clientStudent.studentChoice(userId);
            }
            else if(role.equals("professor")) {
                CRSProfessorMenu clientProf = new CRSProfessorMenu();

            }
        } catch (UserNotFoundException u){
            System.out.println("User not found");
        } catch (WrongPasswordException p){
            System.out.println("Password wrong");
        }
    }

    public void registerNew() {
        System.out.println("=====New Student Registration=====");
        Student newStudent = new Student(null, null, "student", null, null, null, null);
        PersonalDetails newPd = new PersonalDetails(null, null, null);

        System.out.println("enter name: ");
        newPd.setName(scanner.next());
        System.out.println("enter phone number: ");
        newPd.setPhoneNo(scanner.next());
        System.out.println("enter address: ");
        newPd.setAddress(scanner.next());
        newStudent.setPd(newPd);

        System.out.println("enter id: ");
        newStudent.setUserId(scanner.next());
        System.out.println("enter password: ");
        newStudent.setPassword(scanner.next());
        System.out.println("enter roll no: ");
        newStudent.setRollNo(scanner.next());
        System.out.println("enter department: ");
        newStudent.setDepartment(scanner.next());
        System.out.println("enter year of joining: ");
        newStudent.setYearOfJoining(scanner.next());

        DummyDB.userList.put(newStudent.getUserId(), newStudent);
    }

    public void updatePassword() {
        System.out.println("=====Password Update=====");
        System.out.println("enter user id");
        String userId = scanner.next();
        System.out.println("enter your old password");
        String userPass = scanner.next();

        UserInterface user = new UserService();

        try {
            user.verifyCredentials(userId, userPass);
            System.out.println("enter new password");
            String newPass = scanner.next();
            if(user.updatePassword(userId, userPass, newPass)) {
                System.out.println("password updated successfully!");
            }
        } catch (UserNotFoundException u){
            System.out.println("User not found");
        } catch (WrongPasswordException p){
            System.out.println("Password wrong");
        }
    }
}

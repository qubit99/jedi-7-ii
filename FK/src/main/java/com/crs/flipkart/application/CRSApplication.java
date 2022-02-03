package com.crs.flipkart.application;

import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;

import com.crs.flipkart.business.*;
import com.crs.flipkart.exception.InvalidCourseIdException;
import com.crs.flipkart.exception.ProfessorNotFoundException;
import com.crs.flipkart.exception.UserNotFoundException;
import com.crs.flipkart.exception.WrongPasswordException;
import com.crs.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import java.sql.Connection;
import java.util.Scanner;

public class CRSApplication {

    public static Scanner scanner = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(CRSApplication.class);

    public static void main(String[] args) {
        DummyDB.createDatabase();
        BasicConfigurator.configure();

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
        System.out.println("=====WELCOME TO CRS APPLICATION MENU=====");
        System.out.println("You have the following choices: ");
        System.out.println("Enter 1 for login");
        System.out.println("Enter 2 for new student registration");
        System.out.println("Enter 3 to update password");
        System.out.println("Enter 4 to exit");
    }

    public void login() {
        System.out.println("=====LOGIN=====");
        System.out.println("Enter your user id: ");
        String userId = scanner.next();
        System.out.println("Enter your password: ");
        String userPass = scanner.next();

        UserInterface user = new UserService();

        try {
            String rollNo = new String();
            user.verifyCredentials(userId, userPass);
            System.out.println("login successful!");
            String role = user.getRole(userId);
            System.out.println("Role: "+role);
            if(role.equals("Admin")) {
                CRSAdminMenu clientAdmin = new CRSAdminMenu();
                clientAdmin.adminChoice(userId);
            }
            else if(role.equals("Student")) {
                CRSStudentMenu clientStudent = new CRSStudentMenu();
                rollNo = (new StudentService()).getRollNo(userId);
                clientStudent.CRSStudentMenu(rollNo,userId);
            }
            else if(role.equals("Professor")) {
                CRSProfessorMenu clientProf = new CRSProfessorMenu();
                clientProf.profChoice(userId);
            }
        } catch (UserNotFoundException | WrongPasswordException e){
            System.out.println(e.getMessage());
        } catch (ProfessorNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidCourseIdException e) {
            e.printStackTrace();
        }
    }

    public void registerNew() {
        System.out.println("=====NEW STUDENT REGISTRATION=====");
        Student newStudent = new Student(null, null, "Student", null, null, null, null);
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

        StudentInterface studentInterface = new StudentService();
        studentInterface.registerStudent(newStudent);
    }

    public void updatePassword() {
        System.out.println("=====PASSWORD UPDATE=====");
        System.out.println("enter user id");
        String userId = scanner.next();
        System.out.println("enter your old password");
        String userPass = scanner.next();

        UserInterface user = new UserService();

        try {
            user.verifyCredentials(userId, userPass);
            System.out.println("enter new password");
            String newPass = scanner.next();
            if(user.updatePassword(userId, newPass)) {
                System.out.println("password updated successfully!");
            }
        } catch (UserNotFoundException u){
            System.out.println("User not found");
        } catch (WrongPasswordException p){
            System.out.println("Password wrong");
        }
    }
}
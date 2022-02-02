package com.crs.flipkart.application;

import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;

import com.crs.flipkart.business.DummyDB;
import com.crs.flipkart.business.UserInterface;
import com.crs.flipkart.business.UserService;
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
            logger.info("You entered: "+choice);
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

        logger.info("Thank you!");
    }

    public void mainMenu() {
        logger.info("=====CRS Application=====");
        logger.info("You have the following choices: ");
        logger.info("Enter 1 for login");
        logger.info("Enter 2 for new student registration");
        logger.info("Enter 3 to update password");
        logger.info("Enter 4 to exit");
    }

    public void login() {
        logger.info("=====Login=====");
        logger.info("Enter your user id: ");
        String userId = scanner.next();
        logger.info("Enter your password: ");
        String userPass = scanner.next();

        UserInterface user = new UserService();

        try {
            String rollNo = new String();
            user.verifyCredentials(userId, userPass);
            logger.info("login successful!");
            String role = user.getRole(userId);
            logger.info("Role: "+role);
            if(role.equals("Admin")) {
                CRSAdminMenu clientAdmin = new CRSAdminMenu();
                clientAdmin.adminChoice(userId);
            }
            else if(role.equals("Student")) {
                CRSStudentMenu clientStudent = new CRSStudentMenu();
                clientStudent.CRSStudentMenu(rollNo,userId);
            }
            else if(role.equals("professor")) {
                CRSProfessorMenu clientProf = new CRSProfessorMenu();

            }
        } catch (UserNotFoundException | WrongPasswordException e){
            logger.error(e.getMessage());
        }
    }

    public void registerNew() {
        logger.info("=====New Student Registration=====");
        Student newStudent = new Student(null, null, "Student", null, null, null, null);
        PersonalDetails newPd = new PersonalDetails(null, null, null);

        logger.info("enter name: ");
        newPd.setName(scanner.next());
        logger.info("enter phone number: ");
        newPd.setPhoneNo(scanner.next());
        logger.info("enter address: ");
        newPd.setAddress(scanner.next());
        newStudent.setPd(newPd);

        logger.info("enter id: ");
        newStudent.setUserId(scanner.next());
        logger.info("enter password: ");
        newStudent.setPassword(scanner.next());
        logger.info("enter roll no: ");
        newStudent.setRollNo(scanner.next());
        logger.info("enter department: ");
        newStudent.setDepartment(scanner.next());
        logger.info("enter year of joining: ");
        newStudent.setYearOfJoining(scanner.next());

        StudentInterface studentInterface = new StudentService();
        studentInterface.registerStudent(newStudent);
    }

    public void updatePassword() {
        logger.info("=====Password Update=====");
        logger.info("enter user id");
        String userId = scanner.next();
        logger.info("enter your old password");
        String userPass = scanner.next();

        UserInterface user = new UserService();

        try {
            user.verifyCredentials(userId, userPass);
            logger.info("enter new password");
            String newPass = scanner.next();
            if(user.updatePassword(userId, newPass)) {
                logger.info("password updated successfully!");
            }
        } catch (UserNotFoundException u){
            logger.info("User not found");
        } catch (WrongPasswordException p){
            logger.info("Password wrong");
        }
    }
}
package com.crs.flipkart.application;

import com.crs.flipkart.business.DummyDB;
import com.crs.flipkart.business.UserInterface;
import com.crs.flipkart.business.UserService;
import com.crs.flipkart.exception.UserNotFoundException;
import com.crs.flipkart.exception.WrongPasswordException;

import java.util.Scanner;

public class CRSApplication {
    public static void main(String[] args) {

        DummyDB.createDatabase();
        System.out.println("CRS Application");
        System.out.println("Enter a number for the choices: ");
        System.out.println("Login: 1");
        System.out.println("Self-Register: 2");
        System.out.println("Exit: 3");
        Scanner sc = new Scanner(System.in);

        UserInterface userService = new UserService();

        while(true){
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            System.out.println("You entered: "+choice);

            switch(choice){
                case 1 : {
                    System.out.println("Enter login id");
                    String userId = sc.next();
                    System.out.println("Enter Password");
                    String password = sc.next();
                    String role = null;
                    try {
                        userService.verifyCredentials(userId, password);
                        System.out.println("Login Successful");
                        System.out.println(userService.getRole(userId));
                    } catch (UserNotFoundException u){
                        System.out.println("User not found");
                    } catch (WrongPasswordException p){
                        System.out.println("Password wrong");
                    }

                }
            }
        }
    }
}

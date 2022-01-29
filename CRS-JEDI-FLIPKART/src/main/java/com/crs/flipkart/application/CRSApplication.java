package com.crs.flipkart.application;

import java.util.Scanner;

public class CRSApplication {
    public static void main(String[] args) {
        System.out.println("CRS Application");
        System.out.println("Enter a number for the choices: ");
        System.out.println("Login: 1");
        System.out.println("Self-Register: 2");
        System.out.println("Exit: 3");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println("You entered: "+choice);
    }
}

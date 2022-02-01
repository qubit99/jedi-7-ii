package com.crs.flipkart.exception;

import java.sql.SQLOutput;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(){
        System.out.println("Wrong Password");
    }
}

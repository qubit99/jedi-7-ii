package com.crs.flipkart.exception;

import java.sql.SQLOutput;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(){}

    @Override
    public String getMessage(){
        return "Wrong Password";
    }
}

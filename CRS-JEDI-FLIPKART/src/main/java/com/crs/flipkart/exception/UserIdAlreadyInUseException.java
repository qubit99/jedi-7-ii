package com.crs.flipkart.exception;

public class UserIdAlreadyInUseException extends Exception{
    UserIdAlreadyInUseException(){}

    @Override
    public String getMessage(){
        return "UserId already in use!";
    }

}

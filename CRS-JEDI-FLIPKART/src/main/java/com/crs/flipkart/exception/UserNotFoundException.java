package com.crs.flipkart.exception;

public class UserNotFoundException extends Exception{
    private String userId;
    public UserNotFoundException(String userId) {
        this.userId = userId;
    }

    @Override
    public String getMessage(){
        return "User with " + this.userId+ " not found!!!";
    }
}

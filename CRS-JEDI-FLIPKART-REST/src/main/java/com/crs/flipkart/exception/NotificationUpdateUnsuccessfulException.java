package com.crs.flipkart.exception;

public class NotificationUpdateUnsuccessfulException extends Exception{
    public NotificationUpdateUnsuccessfulException(){

    }

    @Override
    public String getMessage() {
        return "Notification of Fees::NOT UPDATED";
    }
}

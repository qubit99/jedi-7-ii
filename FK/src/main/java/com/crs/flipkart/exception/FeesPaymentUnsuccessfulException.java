package com.crs.flipkart.exception;

public class FeesPaymentUnsuccessfulException extends Exception{
    public FeesPaymentUnsuccessfulException(){

    }

    @Override
    public String getMessage() {
        return "Fees payment was unsuccessful";
    }
}

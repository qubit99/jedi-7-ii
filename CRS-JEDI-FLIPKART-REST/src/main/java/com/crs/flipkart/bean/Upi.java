package com.crs.flipkart.bean;

public class Upi extends Payment {
    private String upiId;

    /**
     *
     * @param userId
     * @param password
     * @param role
     * @param pd
     * @param rollNo
     * @param department
     * @param yearOfJoining
     * @param transactionId
     * @param paymentMode
     * @param amount
     * @param status
     * @param upiId
     */
    public Upi(String userId, String password, String role, PersonalDetails pd, String rollNo, String department, String yearOfJoining, int transactionId, String paymentMode, int amount, boolean status, String upiId) {
        super(userId, password, role, pd, rollNo, department, yearOfJoining, transactionId, paymentMode, amount, status);
        this.upiId = upiId;
    }

    /**
     *
     * @return
     */
    public String getUpiId() {
        return upiId;
    }

    /**
     *
     * @param upiId
     */
    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }
}

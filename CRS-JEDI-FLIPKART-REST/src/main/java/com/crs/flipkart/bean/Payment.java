package com.crs.flipkart.bean;

public class Payment extends Student {
    private int transactionId;
    private String paymentMode;
    private int amount;
    private boolean status;

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
     */
    public Payment(String userId, String password, String role, PersonalDetails pd, String rollNo, String department, String yearOfJoining, int transactionId, String paymentMode, int amount, boolean status) {
        super(userId, password, role, pd, rollNo, department, yearOfJoining);
        this.transactionId = transactionId;
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.status = status;
    }

    /**
     *
     * @return
     */
    public int getTransactionId() {
        return transactionId;
    }

    /**
     *
     * @param transactionId
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    /**
     *
     * @return
     */
    public String getPaymentMode() {
        return paymentMode;
    }

    /**
     *
     * @param paymentMode
     */
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    /**
     *
     * @return
     */
    public int getAmount() {
        return amount;
    }

    /**
     *
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     *
     * @return
     */
    public boolean isStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}

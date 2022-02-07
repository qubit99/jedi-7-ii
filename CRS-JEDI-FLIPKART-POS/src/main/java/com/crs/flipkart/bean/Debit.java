package com.crs.flipkart.bean;

public class Debit extends Payment {
    private String number;
    private String type;
    private String expDate;

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
     * @param number
     * @param type
     * @param expDate
     */
    public Debit(String userId, String password, String role, PersonalDetails pd, String rollNo, String department, String yearOfJoining, int transactionId, String paymentMode, int amount, boolean status, String number, String type, String expDate) {
        super(userId, password, role, pd, rollNo, department, yearOfJoining, transactionId, paymentMode, amount, status);
        this.number = number;
        this.type = type;
        this.expDate = expDate;
    }

    /**
     *
     * @return
     */
    public String getNumber() {
        return number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * \
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public String getExpDate() {
        return expDate;
    }

    /**
     *
     * @param expDate
     */
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
}

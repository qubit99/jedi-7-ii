package com.crs.flipkart.bean;


public class Admin extends User {

    private PersonalDetails pd;

    /**
     *
     * @param userId
     * @param password
     * @param role
     * @param pd
     */
    public Admin(String userId, String password, String role, PersonalDetails pd) {
        super(userId, password, role);
        this.pd = pd;
    }
}

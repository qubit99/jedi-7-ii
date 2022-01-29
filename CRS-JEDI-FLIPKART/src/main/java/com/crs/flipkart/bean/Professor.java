package com.crs.flipkart.bean;

public class Professor extends User{

    private PersonalDetails pd;
    private String department;
    private String designation;

    /**
     *
     * @param userId
     * @param password
     * @param role
     * @param pd
     * @param department
     * @param designation
     */
    public Professor(String userId, String password, String role, PersonalDetails pd, String department, String designation) {
        super(userId, password, role);
        this.pd = pd;
        this.department = department;
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

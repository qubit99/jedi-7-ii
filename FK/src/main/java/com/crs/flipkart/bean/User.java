package com.crs.flipkart.bean;

public class User {


    private String userId;
    private String password;
    private String role;

    /**
     *
     * @param userId
     * @param password
     * @param role
     */
    public User(String userId, String password, String role) {

        this.userId = userId;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    /**
     *
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }
}

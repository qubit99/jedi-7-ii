package com.crs.flipkart.bean;

public class Credential {
    private String userId;
    private String password;

    public Credential(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public Credential() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

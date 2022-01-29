package com.crs.flipkart.business;

public interface UserInterface {

    /**
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return boolean
     * @throws
     */
    public boolean updatePassword(String userId, String oldPassword, String newPassword);

    /**
     *
     * @param userId
     * @param password
     * @return
     */
    public boolean verifyCredentials(String userId, String password);

    /**
     *
     * @param userId
     * @return
     */
    public String getRole(String userId);

}

package com.crs.flipkart.dao;

import com.crs.flipkart.exception.UserNotFoundException;
import com.crs.flipkart.exception.WrongPasswordException;

public interface UserDaoInterface {

    /**
     *
     * @param userId
     * @param password
     * @return true if logged in successfully
     * @throws UserNotFoundException
     */
    public boolean verifyCredentials(String userId,String password) throws UserNotFoundException, WrongPasswordException;

    /**
     *
     * @param userID
     * @param oldPassword
     * @param newPassword
     * @return true if password updated successfully
     * @throws UserNotFoundException
     */
    public boolean updatePassword(String userID, String oldPassword,String newPassword) throws UserNotFoundException;

    /**
     *
     * @param userId
     * @return String denoting role of user
     */
    public String getRole(String userId);
}

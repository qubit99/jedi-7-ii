package com.crs.flipkart.business;

import com.crs.flipkart.exception.UserNotFoundException;
import com.crs.flipkart.exception.WrongPasswordException;

public interface UserInterface {

    /**
     *
     * @param userId
     * @param newPassword
     * @return
     */
    public boolean updatePassword(String userId, String newPassword);

    /**
     *
     * @param userId
     * @param password
     * @return
     */
    public boolean verifyCredentials(String userId, String password) throws UserNotFoundException, WrongPasswordException;

    /**
     *
     * @param userId
     * @return
     */
    public String getRole(String userId);

}

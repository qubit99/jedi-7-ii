package com.crs.flipkart.dao;

import com.crs.flipkart.bean.PersonalDetails;
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
     * @param userId
     * @param newPassword
     * @return
     */
    public boolean updatePassword(String userId, String newPassword);

    /**
     *
     * @param userId
     * @return String denoting role of user
     */
    public String getRole(String userId);

    public PersonalDetails getPersonalDetails(String userId);
}

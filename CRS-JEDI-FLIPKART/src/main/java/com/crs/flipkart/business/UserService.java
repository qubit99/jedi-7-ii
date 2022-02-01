package com.crs.flipkart.business;

import com.crs.flipkart.bean.User;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.dao.UserDaoInterface;
import com.crs.flipkart.dao.UserDaoOperation;
import com.crs.flipkart.exception.UserNotFoundException;
import com.crs.flipkart.exception.WrongPasswordException;
import org.apache.log4j.Logger;

import java.util.Map;

public class UserService implements UserInterface{

    public UserService() {

    }

    private static Logger logger = Logger.getLogger(UserService.class);

    UserDaoInterface userDaoOperation =new UserDaoOperation();

    /**
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public boolean updatePassword(String userId, String oldPassword, String newPassword) {

        Map<String, User> userList = DummyDB.userList;

        if(userList.containsKey(userId)){
            if(userList.get(userId).getPassword().equals(oldPassword)){
                userList.get(userId).setPassword(newPassword);
                return true;
            }
            else{
                System.out.println("Wrong old Password");
            }
        }
        else{
            System.out.println("No account with given id found");
        }
        return false;
    }

    /**
     *
     * @param userId
     * @param password
     * @return
     */
    @Override
    public boolean verifyCredentials(String userId, String password) throws UserNotFoundException, WrongPasswordException {
        return userDaoOperation.verifyCredentials(userId, password);
    }

    @Override
    public String getRole(String userId) {
        return userDaoOperation.getRole(userId);
    }
}

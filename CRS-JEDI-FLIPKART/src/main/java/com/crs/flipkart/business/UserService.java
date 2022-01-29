package com.crs.flipkart.business;

import com.crs.flipkart.bean.User;

import java.util.Map;

public class UserService implements UserInterface{

    private UserService(){}

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
    public boolean verifyCredentials(String userId, String password) {
        return DummyDB.userList.containsKey(userId) && DummyDB.userList.get(userId).getPassword().equals(password);
    }

    @Override
    public String getRole(String userId) {
        return DummyDB.userList.get(userId).getRole();
    }
}

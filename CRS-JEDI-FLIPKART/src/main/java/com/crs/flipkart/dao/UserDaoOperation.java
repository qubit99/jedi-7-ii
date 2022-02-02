package com.crs.flipkart.dao;

import com.crs.flipkart.constants.SqlQueriesConstants;
import com.crs.flipkart.exception.UserNotFoundException;
import com.crs.flipkart.exception.WrongPasswordException;
import com.crs.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoOperation implements UserDaoInterface{

    private static Logger logger = Logger.getLogger(UserDaoOperation.class);
    private PreparedStatement statement = null;


    public UserDaoOperation() {}

    Connection connection = DBUtils.getConnection();

    @Override
    public boolean verifyCredentials(String userId, String password) throws UserNotFoundException, WrongPasswordException {
        statement = null;

        try {
            String sql = SqlQueriesConstants.VERIFY_CREDENTIALS_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1,userId);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next())
                throw new UserNotFoundException(userId);
            else if(password.equals(resultSet.getString("password")))
            {
                logger.info("correct password");
                return true;
            }
            else
            {
                throw new WrongPasswordException();
            }

        } catch(SQLException se){
            logger.error(se.getMessage());
        }
        return false;
    }

    @Override
    public boolean updatePassword(String userId, String newPassword){
        statement = null;
        try {
            String sql = SqlQueriesConstants.UPDATE_PASSWORD_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1,newPassword);
            statement.setString(2,userId);
            statement.executeUpdate();
            return true;
        } catch (SQLException se){
            logger.info(se.getMessage());
        }
        return false;
    }

    @Override
    public String getRole(String userId) {
        statement = null;
        String role = "idiot";
        try {
            String sql = SqlQueriesConstants.GET_ROLE_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1,userId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
                role = resultSet.getString("role");

        } catch(SQLException se){
            logger.error(se.getMessage());
        }
        return role;
    }
}
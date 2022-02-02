package com.crs.flipkart.dao;

import com.crs.flipkart.exception.UserNotFoundException;
import com.crs.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthorizationDaoOperation {

    Connection conn = DBUtils.getConnection();

    public ResultSet authorizeUser(String userId,String password){

        try{
            PreparedStatement stmt = null;
            String sql = "SELECT * FROM user WHERE USERID=? AND PASSWORD = ? ";
            String sql1 = "SELECT * FROM STUDENT WHERE USERID=? ";


            stmt = conn.prepareStatement(sql);
            stmt.setString(1,userId);
            stmt.setString(2,password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                if(rs.getString("ROLE").equals("Student"))
                {
                    System.out.println("STUDENT");
                    stmt = conn.prepareStatement(sql1);
                    stmt.setString(1,rs.getString(1));
                    rs = stmt.executeQuery();
                }
                return rs;
            }
            else{
                throw new UserNotFoundException();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}

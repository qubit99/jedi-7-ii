package com.crs.flipkart.dao;

import com.crs.flipkart.application.constants.SqlQueriesConstants;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.UserIdAlreadyInUseException;
import com.crs.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoOperation implements AdminDaoInterface{

//    /**
//     * Volatile keyword to make instance thread safe
//     */
//    private static volatile AdminDaoOperation instance = null;

    private static Logger logger = Logger.getLogger(AdminDaoOperation.class);
    private PreparedStatement statement = null;


    public AdminDaoOperation() {}

//    public static AdminDaoOperation getInstance()
//    {
//        if(instance == null)
//        {
//            synchronized(AdminDaoOperation.class){
//                instance = new AdminDaoOperation();
//            }
//        }
//        return instance;
//    }

    Connection connection = DBUtils.getConnection();

    @Override
    public List<Course> viewAllCourses() {
        statement = null;
        List<Course> courseList = new ArrayList<>();
        try {

            String sql = SqlQueriesConstants.VIEW_COURSE_QUERY;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Course course = new Course();
                course.setCourseId(resultSet.getString(1));
                course.setCourseName(resultSet.getString(2));
                course.setInstructor(resultSet.getString(3));
                courseList.add(course);

            }

            logger.info(courseList.size() + " courses in catalog");

        }catch(SQLException se) {

            logger.error(se.getMessage());

        }

        return courseList;
    }

    @Override
    public List<Professor> viewProfessors(int catalogId) {
        return null;
    }

    @Override
    public boolean addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException {
        return false;
    }
}

package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SqlQueriesConstants;
import com.crs.flipkart.exception.InvalidCourseIdException;
import com.crs.flipkart.exception.InvalidGradeException;
import com.crs.flipkart.exception.ProfessorNotFoundException;
import com.crs.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDaoOperation implements ProfessorDaoInterface {

    private static Logger logger = Logger.getLogger(ProfessorDaoOperation.class);
    private PreparedStatement statement = null;

    public ProfessorDaoOperation() {}

    Connection connection = DBUtils.getConnection();

    @Override
    public List<Course> getTeachingCourses(String profId) throws ProfessorNotFoundException {
        Connection conn = null;
        PreparedStatement prep_stmt = null;
        try {
            conn = DBUtils.getConnection();
            String raw_stmt = SqlQueriesConstants.GET_TEACHING_COURSES;
            prep_stmt = conn.prepareStatement(raw_stmt);
            prep_stmt.setString(1, profId);
            ResultSet result = prep_stmt.executeQuery();
            List<Course> courseList = new ArrayList<Course>();
            while(result.next()) {
                courseList.add(new Course(result.getString(1), result.getString(2), result.getString(3)));
            }
            return courseList;
        }catch (SQLException se) {
            logger.error(se.getMessage());
        }catch (Exception e) {
            logger.error(e.getMessage());
        }finally {
            try{
                if(prep_stmt!=null)
                    prep_stmt.close();
            }catch (SQLException se2) {
                logger.error(se2.getMessage());
            }
        }

        return new ArrayList<Course>();
    }

    @Override
    public List<PersonalDetails> getEnrolledStudents(String profId, String courseId) throws InvalidCourseIdException {
        Connection conn = null;
        PreparedStatement prep_stmt = null;
        try {
            conn = DBUtils.getConnection();
            String raw_stmt = SqlQueriesConstants.GET_ENROLL_STUDENTS;
            prep_stmt = conn.prepareStatement(raw_stmt);
            prep_stmt.setString(1, courseId);
            ResultSet result = prep_stmt.executeQuery();
            List<PersonalDetails> students = new ArrayList<PersonalDetails>();
            while(result.next()) {
                String studentId = result.getString(1);
                UserDaoInterface userDao = new UserDaoOperation();
                PersonalDetails studentDetails = userDao.getPersonalDetails(studentId);
                students.add(studentDetails);
            }
            return students;
        }catch(SQLException se){
            logger.error(se.getMessage());
        }catch(Exception e){
            logger.error(e.getMessage());
        }finally{
            try{
                if(prep_stmt!=null)
                    prep_stmt.close();
            }catch(SQLException se2){
                logger.error(se2.getMessage());
            }
        }
        return new ArrayList<PersonalDetails>();
    }

    @Override
    public void giveGrades(String studentid, String courseId, String grade) throws InvalidGradeException {

    }
}

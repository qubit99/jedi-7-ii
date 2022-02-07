package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SqlQueriesConstants;
import com.crs.flipkart.exception.*;
import com.crs.flipkart.utils.DBUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;
import org.apache.log4j.Logger;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDaoOperation implements ProfessorDaoInterface {

    private static Logger logger = Logger.getLogger(ProfessorDaoOperation.class);

    public ProfessorDaoOperation() {
    }


    @Override
    public List<Course> getTeachingCourses(String profId)  {
        Connection conn = null;
        PreparedStatement prep_stmt = null;
        try {
            conn = DBUtils.getConnection();
            String raw_stmt = SqlQueriesConstants.GET_TEACHING_COURSES;
            prep_stmt = conn.prepareStatement(raw_stmt);
            prep_stmt.setString(1, profId);
            ResultSet result = prep_stmt.executeQuery();
            List<Course> courseList = new ArrayList<>();
            while (result.next()) {
                courseList.add(new Course(result.getString(1), result.getString(2), result.getString(3)));
            }
            return courseList;
        } catch (SQLException se) {
            logger.error(se.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (prep_stmt != null)
                    prep_stmt.close();
            } catch (SQLException se2) {
                logger.error(se2.getMessage());
            }
        }

        return new ArrayList<>();
    }

    @Override
    public List<Pair<String,String>> getEnrolledStudents(String courseId)  {
        Connection conn = null;
        PreparedStatement prep_stmt = null;
        try {
            conn = DBUtils.getConnection();
            String raw_stmt = SqlQueriesConstants.GET_ENROLL_STUDENTS;
            prep_stmt = conn.prepareStatement(raw_stmt);
            prep_stmt.setString(1, courseId);
            ResultSet result = prep_stmt.executeQuery();
            List<Pair<String,String>> students = new ArrayList<>();
            while (result.next()) {
                String studentId = result.getString(1);
                String rollNo = result.getString(2);
                UserDaoInterface userDao = new UserDaoOperation();
                PersonalDetails studentDetails = userDao.getPersonalDetails(studentId);
                students.add(new Pair<>(studentDetails.getName(), rollNo));
            }
            return students;
        } catch (SQLException se) {
            logger.error(se.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (prep_stmt != null)
                    prep_stmt.close();
            } catch (SQLException se2) {
                logger.error(se2.getMessage());
            }
        }
        return new ArrayList<>();
    }

    @Override
    public Boolean giveGrades(String studentid, String profId, String courseId, String grade)  {

        Connection conn = null;
        PreparedStatement prep_stmt = null;
        try {
            conn = DBUtils.getConnection();
            List<Course> courseList = getTeachingCourses(profId);
            List<Pair<String,String>> students = getEnrolledStudents(courseId);
            ArrayList<String> ids  = new ArrayList<>();
            courseList.forEach(course -> ids.add(course.getCourseId()));
            if(!ids.contains(courseId))
                throw new CourseNotAllotedException();
            ids.clear();
            students.forEach(student -> ids.add(student.getValue()));
            System.out.println(students.toString());
            if(!ids.contains(studentid))
                throw new StudentNotEnrolledException();

            String raw_stmt = "UPDATE SEMESTERREGISTRATION SET GRADE = ? WHERE CID =? AND ROLLNO = ?";
            prep_stmt = conn.prepareStatement(raw_stmt);
            prep_stmt.setString(1, grade);
            prep_stmt.setString(2, courseId);
            prep_stmt.setString(3, studentid);
            int status = prep_stmt.executeUpdate();
            if (status <= 0)
                throw new GradesNotUpdatedException();
            return true;
        } catch (SQLException | GradesNotUpdatedException | CourseNotAllotedException | StudentNotEnrolledException e ) {
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (prep_stmt != null)
                    prep_stmt.close();
            } catch (SQLException se2) {
                logger.error(se2.getMessage());
            }
        }
        return false;
    }

    @Override
    public Boolean selectTeachingCourses(String profId, String courseId){
        Connection conn = null;
        PreparedStatement prep_stmt = null;
        try {
            conn = DBUtils.getConnection();
            String raw_stmt = "UPDATE COURSE SET PROFESSORID = ? WHERE CID =? ";
            prep_stmt = conn.prepareStatement(raw_stmt);
            prep_stmt.setString(1, profId);
            prep_stmt.setString(2, courseId);
            int status = prep_stmt.executeUpdate();
            if (status <= 0)
                throw new SQLException();
            return true;
        } catch (SQLException se) {
            logger.error(se.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Course> getAvailableCourses() {
        Connection conn = null;
        PreparedStatement prep_stmt = null;
        ArrayList<Course> courses = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            String raw_stmt = "SELECT * FROM COURSE WHERE PROFESSORID IS NULL";
            prep_stmt = conn.prepareStatement(raw_stmt);
            ResultSet resultSet = prep_stmt.executeQuery();
            while(resultSet.next())
                courses.add(new Course(resultSet.getString(1),resultSet.getString(2),new String("NA")));
        } catch (SQLException se) {
            logger.error(se.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (prep_stmt != null)
                    prep_stmt.close();
            } catch (SQLException se2) {
                logger.error(se2.getMessage());
            }
        }
        return courses;
    }


}





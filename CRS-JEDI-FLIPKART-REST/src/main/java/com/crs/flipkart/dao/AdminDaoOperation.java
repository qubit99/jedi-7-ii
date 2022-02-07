package com.crs.flipkart.dao;

import com.crs.flipkart.bean.PersonalDetails;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SqlQueriesConstants;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.exception.*;
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

    UserDaoOperation userDaoOperation = new UserDaoOperation();

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
    public List<Professor> viewAllProfessors() {
        statement = null;
        List<Professor> professorList = new ArrayList<>();
        try {

            String sql = SqlQueriesConstants.VIEW_PROFESSOR_QUERY;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Professor professor = new Professor();
                professor.setUserId(resultSet.getString(1));
                professor.setDepartment(resultSet.getString(2));
                //if Personal Details for given userId exists, we add them in object
                PersonalDetails pd = userDaoOperation.getPersonalDetails(professor.getUserId());

                if(pd!=null){
                    professor.setPd(pd);
                }
                professorList.add(professor);
            }

            logger.info(professorList.size() + " professors in college");

        }catch(SQLException se) {

            logger.error(se.getMessage());

        }
        return professorList;
    }

    @Override
    public List<Student> viewAllStudents(int flag) {
        statement = null;
        List<Student> studentList = new ArrayList<>();
        try {

            String sql = SqlQueriesConstants.VIEW_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setInt(1,flag);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Student student = new Student();
                student.setUserId(resultSet.getString("USERID"));
                student.setRollNo(resultSet.getString("ROLLNO"));
                student.setDepartment(resultSet.getString("DEPARTMENT"));
                //if Personal Details for given userId exists, we add them in object
                PersonalDetails pd = userDaoOperation.getPersonalDetails(student.getUserId());

                if(pd!=null){
                    student.setPd(pd);
                }
                studentList.add(student);
            }

            logger.info(studentList.size() + " students in college");

        }catch(SQLException se) {

            logger.error(se.getMessage());

        }
        return studentList;
    }

    @Override
    public boolean addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException {
        statement = null;
        try {
            String sql1 = SqlQueriesConstants.ADD_USER_QUERY;
            String sql2 = SqlQueriesConstants.ADD_PROFESSOR_QUERY;
            String sql3 = SqlQueriesConstants.INSERT_PERSONALDETAILS_QUERY;

            statement = connection.prepareStatement(sql1);
            statement.setString(1,professor.getUserId());
            statement.setString(2,professor.getPassword());
            statement.setString(3,professor.getRole());
            int status = statement.executeUpdate();
            if(status <= 0)
                throw new UserIdAlreadyInUseException();

            statement = connection.prepareStatement(sql2);
            statement.setString(1,professor.getUserId());
            statement.setString(2,professor.getDepartment());
            status = statement.executeUpdate();
            if(status<=0)
                throw new ProfessorNotAddedException();

            statement = connection.prepareStatement(sql3);
            statement.setString(1,professor.getPd().getName());
            statement.setString(2,professor.getPd().getPhoneNo());
            statement.setString(3,professor.getPd().getAddress());
            statement.setString(4,professor.getUserId());
            status = statement.executeUpdate();
            if(status<=0)
                throw  new SQLException();
            else
                return true;

        } catch (SQLException se){
            logger.error(se.getMessage());
        }
        return false;
    }



    @Override
    public Boolean addCourse(Course course) {
        statement = null;
        try {
            String sql1 = SqlQueriesConstants.ADD_COURSE_QUERY;

            statement = connection.prepareStatement(sql1);
            statement.setString(1,course.getCourseId());
            statement.setString(2,course.getCourseName());
            int status = statement.executeUpdate();
            if(status <= 0)
                throw new CourseIdAlreadyInUseException(course.getCourseId());
            else
                logger.info("Course added successfully");
                return true;

        } catch (SQLException | CourseIdAlreadyInUseException se){
            logger.error(se.getMessage());
        }
        return false;
    }

    public Boolean approveStudentRegistration(String rollNo) {
        statement = null;
        try {
            String sql = SqlQueriesConstants.APPROVE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1,rollNo);
            int status = statement.executeUpdate();
            if(status<=0)
                throw new SQLException();
            else
                return true;
        } catch (SQLException se){
            logger.info(se.getMessage());
        }
        return false;
    }

    @Override
    public Boolean removeProfessor(int professorId) {
        statement = null;
        try {
            String sql = SqlQueriesConstants.DELETE_USER_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setInt(1,professorId);
            int status = statement.executeUpdate();
            if(status<=0)
                throw new SQLException();
            else
                return true;
        } catch (SQLException se){
            logger.error(se.getMessage());
        }
        return false;
    }
}

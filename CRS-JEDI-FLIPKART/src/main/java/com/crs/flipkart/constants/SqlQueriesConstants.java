package com.crs.flipkart.constants;

public class SqlQueriesConstants {

    //ADMIN Queries
    public static final String VIEW_COURSE_QUERY = "select C.CID, C.COURSENAME, P.NAME " +
                                                    "from Course C JOIN PERSONALDETAILS P " +
                                                    "ON C.PROFESSORID = P.USERID";

    //USER Queries
    public static final String VERIFY_CREDENTIALS_QUERY = "SELECT * FROM USER WHERE userId = ?";
    public static final String GET_ROLE_QUERY = "SELECT * FROM USER WHERE userId = ?";
    public static final String UPDATE_PASSWORD_QUERY = "UPDATE USER SET PASSWORD = ? WHERE userID = ?";

    //PROFESSOR Queries
    public static final String GET_TEACHING_COURSES = "SELECT * FROM Course WHERE professorid=?";
    public static final String GET_ENROLL_STUDENTS = "SELECT studentid FROM registration WHERE courseid=?";
}

package com.crs.flipkart.constants;

public class SqlQueriesConstants {

    //ADMIN Queries
    public static final String VIEW_COURSE_QUERY = "select C.CID, C.COURSENAME, P.NAME " +
                                                    "from Course C JOIN PERSONALDETAILS P " +
                                                    "ON C.PROFESSORID = P.USERID";
    public static final String VIEW_PROFESSOR_QUERY = "select * from professor";
    public static final String VIEW_STUDENT_QUERY = "select * from student";
    public static final String ADD_PROFESSOR_QUERY = "INSERT INTO PROFESSOR VALUES(?,?)";
    public static final String ADD_COURSE_QUERY = "insert into `jedi`.`course` (`CID`,`COURSENAME`) values(?,?)";

    //USER Queries
    public static final String VERIFY_CREDENTIALS_QUERY = "SELECT * FROM USER WHERE userId = ?";
    public static final String GET_ROLE_QUERY = "SELECT * FROM USER WHERE userId = ?";
    public static final String UPDATE_PASSWORD_QUERY = "UPDATE USER SET PASSWORD = ? WHERE userID = ?";
    public static final String GET_PERSONALDETAILS_QUERY = "SELECT * FROM PERSONALDETAILS WHERE userId = ?";
    public static final String ADD_USER_QUERY = "INSERT INTO USER VALUES(? , ? , ?)";
    public static final String INSERT_PERSONALDETAILS_QUERY = "INSERT INTO PERSONALDETAILS VALUES(?,?,?,?)";

    //PROFESSOR Queries
    public static final String GET_TEACHING_COURSES = "SELECT * FROM Course WHERE professorid=?";
    public static final String GET_ENROLL_STUDENTS = "SELECT userid FROM student WHERE rollno IN (SELECT rollno FROM semesterregistration WHERE cid=?)";
}

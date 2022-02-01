package com.crs.flipkart.application.constants;

public class SqlQueriesConstants {

    //ADMIN Queries
    public static final String VIEW_COURSE_QUERY = "select C.CID, C.COURSENAME, P.NAME " +
                                                    "from Course C JOIN PERSONALDETAILS P " +
                                                    "ON C.PROFESSORID = P.USERID";
    public static final String VERIFY_CREDENTIALS_QUERY = "SELECT * FROM USER WHERE userId = ?";
    public static final String GET_ROLE_QUERY = "SELECT * FROM USER WHERE userId = ?";
}

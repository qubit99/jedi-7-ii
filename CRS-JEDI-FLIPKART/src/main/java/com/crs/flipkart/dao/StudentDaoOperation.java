package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SqlQueriesConstants;
import com.crs.flipkart.exception.AddCourseUnsuccessfulException;
import com.crs.flipkart.exception.CourseRemovalUnsuccessfulException;
import com.crs.flipkart.exception.*;
import com.crs.flipkart.utils.DBUtils;
import javafx.util.Pair;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentDaoOperation implements StudentDaoInterface {

    Connection conn = DBUtils.getConnection();
    private static Logger logger = Logger.getLogger(StudentDaoOperation.class);

    /**
     *
     * @param st
     */
    public Boolean registerStudent(Student st) throws RegistrationUnsuccessfulException ,StudentIdAlreadyInUseException ,UserIdAlreadyInUseException {

        try {

            String sql = SqlQueriesConstants.ADD_USER_QUERY;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, st.getUserId());
            stmt.setString(2, st.getPassword());
            stmt.setString(3, st.getRole());
            int status = stmt.executeUpdate();
            if (status <= 0)
                throw new UserIdAlreadyInUseException();


            sql = "INSERT INTO STUDENT VALUES(?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, st.getUserId());
            stmt.setString(2, st.getRollNo());
            stmt.setString(3, st.getDepartment());
            stmt.setInt(4, 0);
            status = stmt.executeUpdate();
            System.out.println(status);

            if (status <= 0)
                throw new StudentIdAlreadyInUseException();



            sql = SqlQueriesConstants.INSERT_PERSONALDETAILS_QUERY;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, st.getPd().getName());
            stmt.setString(2, st.getPd().getPhoneNo());
            stmt.setString(3, st.getPd().getAddress());
            stmt.setString(4, st.getUserId());
            status = stmt.executeUpdate();
            System.out.println(status);

            if (status <= 0)
                throw new RegistrationUnsuccessfulException();

            return true;
        } catch (SQLException  e) {
            logger.error(e.getMessage());
        }
        return false;
    }


    /**
     *
     * @param rollNo
     * @param courseIds
     */
    public Boolean registerForCourses(String rollNo, ArrayList<String> courseIds) throws SemesterRegistrationUnsuccessfulException{
        String sql = "INSERT INTO SEMESTERREGISTRATION VALUES(?,?,?,?),(?,?,?,?),(?,?,?,?) ,(?,?,?,?) ,(?,?,?,?) ,(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            for (int i = 0; i < 6; i++) {
                stmt.setString(4 * i + 1, rollNo);
                stmt.setString(4 * i + 2, courseIds.get(i));
                stmt.setInt(4 * i + 3, 1);
                stmt.setString(4 * i + 4, "NA");
            }
            int status = stmt.executeUpdate();
            if (status <= 0)
                throw new SemesterRegistrationUnsuccessfulException();
            return true;
        } catch (SQLException  e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    /**
     *
     * @return
     */
    public ArrayList<Course> getAllCourses() {
        String sql = "SELECT  * FROM COURSE";
        ArrayList<Course> courses = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                courses.add(new Course(rs.getString(1), rs.getString(2), rs.getString(3)));
        } catch (SQLException  e) {
            logger.error(e.getMessage());
        } catch (Exception  e) {
            logger.error(e.getMessage());
        }
        return courses;
    }


    /**
     *
     * @param rollNo
     * @return
     */
    public ArrayList<Pair<String,String>> getEnrolledCourses(String rollNo){
        String sql = "SELECT ROLLNO , COURSE.CID , COURSE.COURSENAME, GRADE FROM SEMESTERREGISTRATION INNER JOIN COURSE ON COURSE.CID =SEMESTERREGISTRATION.CID WHERE ROLLNO = ?";
        ArrayList<Pair<String, String>> enrolledCourses = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, rollNo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                enrolledCourses.add(new Pair<>(rs.getString(2), rs.getString(3)));
        } catch (SQLException  e) {
            logger.error(e.getMessage());
        } catch (Exception  e) {
            logger.error(e.getMessage());
        }
        return enrolledCourses;
    }


    /**
     *
     * @param rollNo
     * @param courseId
     */
    public Boolean addCourse(String rollNo,String courseId) throws AddCourseUnsuccessfulException {
        String sql = "INSERT INTO SEMESTERREGISTRATION VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, rollNo);
            stmt.setString(2, courseId);
            stmt.setInt(3, 1);
            stmt.setString(4, "NA");

            int status = stmt.executeUpdate();
            if (status <= 0)
                throw new AddCourseUnsuccessfulException();
            return true;
        } catch (SQLException  e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    /**
     *
     * @param rollNo
     * @param courseId
     */
    public Boolean removeCourse(String rollNo, String courseId) throws CourseRemovalUnsuccessfulException{
        String sql = "DELETE FROM SEMESTERREGISTRATION WHERE ROLLNO = ? AND CID = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, rollNo);
            stmt.setString(2, courseId);
            int status = stmt.executeUpdate();
            if (status <= 0)
                throw new CourseRemovalUnsuccessfulException();
            return true;
        } catch (SQLException  e) {
            logger.error(e.getMessage());
        }
        return false;
    }


    /**
     *
     * @param rollNo
     * @return
     */
    public ArrayList<Pair<String,String>> getGradeCard(String rollNo) {
        String sql1 = "SELECT  COURSE.COURSENAME, GRADE FROM SEMESTERREGISTRATION INNER JOIN COURSE ON COURSE.CID =SEMESTERREGISTRATION.CID WHERE ROLLNO = ?";
        String sql2 = "SELECT * FROM GRADECARD WHERE ROLLNO = ?";
        ArrayList<Pair<String, String>> gradeCard = new ArrayList<Pair<String, String>>();

        try {
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            PreparedStatement stmt2 = conn.prepareStatement(sql2);


            stmt1.setString(1, rollNo);
            stmt2.setString(1, rollNo);

            ResultSet rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                gradeCard.add(new Pair<String, String>(rs1.getString(1), rs1.getString(2)));
            }
            ResultSet rs2 = stmt2.executeQuery();
            while (rs2.next()) {
                gradeCard.add(new Pair<>("SEMESTER", Integer.toString(rs2.getInt(3))));
                gradeCard.add(new Pair<>("CGPA", rs2.getString(2)));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return gradeCard;
    }

    public String getRollNo(String userId) {
        String sql = "SELECT ROLLNO FROM STUDENT WHERE USERID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                return rs.getString(1);
            else
                throw new SQLException();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public ArrayList<Notification> getNotifications(String rollNo) {
        String sql = "SELECT * FROM NOTIFICATION WHERE ROLLNO = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,rollNo);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Notification> notifications = new ArrayList<Notification>();
            while (rs.next())
                notifications.add(new Notification(rs.getString(2), rs.getString(3), rs.getString(1)));
            return notifications;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public String payFees(String rollNo) throws FeesPaymentUnsuccessfulException {
        Scanner sc = new Scanner(System.in);
        String paymentMode;
        System.out.println("Press 1: For UPI PAYMENT");
        System.out.println("Press 2 :For NET BANKING");
        int choice = sc.nextInt();
        if (choice == 1)
            paymentMode = new String("UPI PAYMENT");
        else if (choice == 2)
            paymentMode = new String("NET BANKING");
        else
            throw new FeesPaymentUnsuccessfulException();
        System.out.println("Enter the amount");
        int amount = sc.nextInt();
        String transactionID = ("TN").concat(Long.toString(100000000 + (long) (Math.random() * (999999999 - 100000000))));
        String sql = "INSERT INTO PAYMENT VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, transactionID);
            stmt.setString(2, paymentMode);
            stmt.setInt(3, amount);
            stmt.setString(4, "SUCCESSFUL");
            stmt.setString(5, rollNo);
            int status = stmt.executeUpdate();
            if (status <= 0)
                throw new FeesPaymentUnsuccessfulException();
            return transactionID;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public String updateNotification(String rollNo, String message) throws NotificationUpdateUnsuccessfulException {
        String notificationID = ("NN").concat(Long.toString(100000000 + (long) (Math.random() * (999999999 - 100000000))));
        String sql = "INSERT INTO NOTIFICATION VALUES (?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, notificationID);
            stmt.setString(2, rollNo);
            stmt.setString(3, message);
            int status = stmt.executeUpdate();
            if (status <= 0)
                throw new SQLException();
            return notificationID;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new NotificationUpdateUnsuccessfulException();
        }
    }
}
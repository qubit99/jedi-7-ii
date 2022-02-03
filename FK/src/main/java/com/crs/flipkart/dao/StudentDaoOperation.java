package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Notification;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SqlQueriesConstants;
import com.crs.flipkart.exception.AddCourseUnsuccessful;
import com.crs.flipkart.exception.CourseRemovalUnsuccessful;
import com.crs.flipkart.exception.RegistrationUnsuccessful;
import com.crs.flipkart.exception.SemesterRegistrationUnsuccessful;
import com.crs.flipkart.exception.*;
import com.crs.flipkart.utils.DBUtils;
import javafx.util.Pair;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentDaoOperation implements StudentDaoInterface {

    Connection conn = DBUtils.getConnection();

    /**
     *
     * @param st
     */
    public void registerStudent(Student st) {

        String sql = SqlQueriesConstants.ADD_USER_QUERY;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, st.getUserId());
            stmt.setString(2, st.getPassword());
            stmt.setString(3, st.getRole());
            int status = stmt.executeUpdate();
            if (status <= 0)
                throw new RegistrationUnsuccessful();


            sql = "INSERT INTO STUDENT VALUES(?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, st.getUserId());
            stmt.setString(2, st.getRollNo());
            stmt.setString(3, st.getDepartment());
            stmt.setString(4, "0");
            status = stmt.executeUpdate();
            System.out.println(status);

            if (status <= 0)
                throw new RegistrationUnsuccessful();



            sql = SqlQueriesConstants.INSERT_PERSONALDETAILS_QUERY;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, st.getPd().getName());
            stmt.setString(2, st.getPd().getPhoneNo());
            stmt.setString(3, st.getPd().getAddress());
            stmt.setString(4, st.getUserId());
            status = stmt.executeUpdate();
            System.out.println(status);

            if (status <= 0)
                throw new RegistrationUnsuccessful();

            System.out.println("Registration is done successfully");
            System.out.println("Admin approval is pending");

        } catch (SQLException | RegistrationUnsuccessful e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     *
     * @param rollNo
     * @param courseIds
     */
    public void registerForCourses(String rollNo, ArrayList<String> courseIds){
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
                throw new SemesterRegistrationUnsuccessful();
            System.out.println("Your Semester Registration was done successfully");
        } catch (SQLException | SemesterRegistrationUnsuccessful e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Course> getAllCourses() {
        String sql = "SELECT  * FROM COURSE";
        ArrayList<Course> courses = new ArrayList<Course>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                courses.add(new Course(rs.getString(2), rs.getString(1), rs.getString(3)));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
        ArrayList<Pair<String, String>> enrolledCourses = new ArrayList<Pair<String, String>>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, rollNo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                enrolledCourses.add(new Pair<String, String>(rs.getString(2), rs.getString(3)));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return enrolledCourses;
    }


    /**
     *
     * @param rollNo
     * @param courseId
     */
    public void addCourse(String rollNo,String courseId){
        String sql = "INSERT INTO SEMESTERREGISTRATION VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, rollNo);
            stmt.setString(2, courseId);
            stmt.setInt(3, 1);
            stmt.setString(4, "NA");

            int status = stmt.executeUpdate();
            if (status <= 0)
                throw new AddCourseUnsuccessful();
            System.out.println("Your Course with courseId " + courseId + " was added successfully ");
        } catch (SQLException | AddCourseUnsuccessful e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param rollNo
     * @param courseId
     */
    public void removeCourse(String rollNo, String courseId) {
        String sql = "DELETE FROM SEMESTERREGISTRATION WHERE ROLLNO = ? AND CID = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, rollNo);
            stmt.setString(2, courseId);
            int status = stmt.executeUpdate();
            if (status <= 0)
                throw new CourseRemovalUnsuccessful();
            System.out.println("Course with courseId:" + courseId + " was removed successfully");

        } catch (SQLException | CourseRemovalUnsuccessful e) {
            System.out.println(e.getMessage());
        }
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
                gradeCard.add(new Pair<String, String>("SEMESTER", Integer.toString(rs2.getInt(3))));
                gradeCard.add(new Pair<String, String>("CGPA", rs2.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeCard;
    }

    public String getRollNo(String userId) {
        String sql = "SELECT ROLLNO FROM STUDENT WHERE USERID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                return rs.getString(1);
        } catch (SQLException e) {
            e.getMessage();
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
            e.getMessage();
        }
        return null;
    }

    public void payFees(String rollNo) throws FeesPaymentUnsuccessfulException {
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
            System.out.println("Fees Payment was successful");
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            String message = new String("Fees Payment with transactionID:" + transactionID + " is done successfully on DATE:" + date.toString() + " and TIME:" + time.toString());
            System.out.println(message);
            updateNotification(rollNo, message);
            System.out.println("Notification of Fees updated successfully");
        } catch (SQLException e) {
            e.getMessage();
        } catch (NotificationUpdateUnsuccessfulException e) {
            System.out.println("Notification of Fees::NOT UPDATED");
        }
    }

    public void updateNotification(String rollNo, String message) throws NotificationUpdateUnsuccessfulException {
        String notificationID = ("NN").concat(Long.toString(100000000 + (long) (Math.random() * (999999999 - 100000000))));
        String sql = "INSERT INTO NOTIFICATION VALUES (?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, notificationID);
            stmt.setString(2, rollNo);
            stmt.setString(3, message);
            int status = stmt.executeUpdate();
            if (status <= 0)
                throw new NotificationUpdateUnsuccessfulException();
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
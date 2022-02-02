package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.AddCourseUnsuccessful;
import com.crs.flipkart.exception.CourseRemovalUnsuccessful;
import com.crs.flipkart.exception.RegistrationUnsuccessful;
import com.crs.flipkart.exception.SemesterRegistrationUnsuccessful;
import com.crs.flipkart.utils.DBUtils;
import javafx.util.Pair;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoOperation {

    Connection conn = DBUtils.getConnection();
    public void registerStudent(Student st) {

        String sql = "INSERT INTO USER VALUES(? , ? , ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,st.getUserId());
            stmt.setString(2,st.getPassword());
            stmt.setString(3,st.getRole());
            int status = stmt.executeUpdate();
            if(status <= 0)
                throw new RegistrationUnsuccessful();


            sql = "INSERT INTO STUDENT VALUES(?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,st.getUserId());
            stmt.setString(2,st.getRollNo());
            stmt.setString(3,st.getDepartment());
            stmt.setString(4,"0");
            status = stmt.executeUpdate();
            System.out.println(status);

            if(status <= 0)
                throw new RegistrationUnsuccessful();



            sql = "INSERT INTO PERSONALDETAILS VALUES(?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,st.getPd().getName());
            stmt.setString(2,st.getPd().getPhoneNo());
            stmt.setString(3,st.getPd().getAddress());
            stmt.setString(4,st.getUserId());
            status = stmt.executeUpdate();
            System.out.println(status);

            if(status <= 0)
                throw new RegistrationUnsuccessful();

            System.out.println("Registration is done successfully");
            System.out.println("Admin approval is pending");

        }
        catch (SQLException | RegistrationUnsuccessful e) {
            System.out.println(e.getMessage());
        }
    }

    public void registerForCourses(String rollNo, ArrayList<String> courseIds){
        String sql = "INSERT INTO SEMESTERREGISTRATION VALUES(?,?,?,?),(?,?,?,?),(?,?,?,?) ,(?,?,?,?) ,(?,?,?,?) ,(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            for (int i=0;i<6;i++){
                stmt.setString(4*i+1,rollNo);
                stmt.setString(4*i+2,courseIds.get(i));
                stmt.setInt(4*i+3,1);
                stmt.setString(4*i+4,"NA");
            }
            int status = stmt.executeUpdate();
            if(status<=0)
                throw new SemesterRegistrationUnsuccessful();
            System.out.println("Your Semester Registration was done successfully");
        } catch (SQLException | SemesterRegistrationUnsuccessful e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Course> getAllCourses() {
        String sql = "SELECT DISTINCT CID,COURSENAME FROM COURSE";
        ArrayList<Course> courses = new ArrayList<Course>();
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
                courses.add(new Course(rs.getString(2),rs.getString(1),rs.getString(3)));
        }
        catch (SQLException  e) {
            System.out.println(e.getMessage());
        }
        return courses;
    }

    public ArrayList<Pair<String,String>> getEnrolledCourses(String rollNo){
        String sql = "SELECT ROLLNO , COURSE.CID , COURSE.COURSENAME, GRADE FROM SEMESTERREGISTRATION INNER JOIN COURSE ON COURSE.CID =SEMESTERREGISTRATION.CID WHERE ROLLNO = ?";
        ArrayList<Pair<String,String>> enrolledCourses = new ArrayList<Pair<String,String>>();

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,rollNo);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Course ID : Course Name");
            while(rs.next())
                enrolledCourses.add(new Pair<String,String>(rs.getString(2),rs.getString(3)));
        }
        catch (SQLException  e) {
            System.out.println(e.getMessage());
        }
        return enrolledCourses;
    }


    public void addCourse(String rollNo,String courseId){
        String sql = "INSERT INTO SEMESTERREGISTRATION VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,rollNo);
            stmt.setString(2,courseId);
            stmt.setInt(3,1);
            stmt.setString(4,"NA");

            int status = stmt.executeUpdate();
            if(status<=0)
                throw new AddCourseUnsuccessful();
            System.out.println("Your Course with courseId "+ courseId + " was added successfully ");
        } catch (SQLException | AddCourseUnsuccessful e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeCourse(String rollNo, String courseId) {
        String sql = "DELETE FROM SEMESTERREGISTRATION WHERE ROLLNO = ? AND CID = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,rollNo);
            stmt.setString(2,courseId);
            int status = stmt.executeUpdate();
            if(status<=0)
                throw new CourseRemovalUnsuccessful();
            System.out.println("Course with courseId:"+courseId+" was removed successfully");

        } catch (SQLException | CourseRemovalUnsuccessful e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Pair<String,String>> getGradeCard(String rollNo) {

        String sql1 = "SELECT * FROM GRADECARD WHERE ROLLNO = ?";
        String sql2 = "SELECT  COURSE.COURSENAME, GRADE FROM SEMESTERREGISTRATION INNER JOIN COURSE ON COURSE.CID =SEMESTERREGISTRATION.CID WHERE ROLLNO = ?";

        try {
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            PreparedStatement stmt2 = conn.prepareStatement(sql2);

            stmt1.setString(1,rollNo);
            stmt2.setString(1,rollNo);

            ResultSet rs1 = stmt1.executeQuery();
            ResultSet rs2 = stmt1.executeQuery();
            ArrayList<Pair<String,String>> gradeCard = new ArrayList<Pair<String,String>>();

            while(rs2.next())
                gradeCard.add(new Pair<String,String>(rs2.getString(3),rs2.getString(4)));
            while(rs1.next()) {
                gradeCard.add(new Pair<String,String>("SEMESTER " , Integer.toString(rs1.getInt(3))));
                gradeCard.add(new Pair<String,String>("CGPA",rs1.getString(2)));
            }
            return gradeCard;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
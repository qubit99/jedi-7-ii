package com.crs.flipkart.bean;

public class Grade {
    private String rollNo;
    private String profId;
    private String courseId;
    private String grade;




    public Grade(String rollNo, String profId, String courseId, String grade) {
        this.rollNo = rollNo;
        this.profId = profId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public Grade() {
    }



    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "rollNo='" + rollNo + '\'' +
                ", profId='" + profId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}

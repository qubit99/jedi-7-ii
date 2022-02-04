package com.crs.flipkart.bean;

import java.util.Objects;

public class Student extends User {

    private PersonalDetails pd;
    private String rollNo;
    private String department;
    private String yearOfJoining;

    /**
     *
     * @param userId
     * @param password
     * @param role
     * @param pd
     * @param rollNo
     * @param department
     * @param yearOfJoining
     */
    public Student(String userId, String password, String role, PersonalDetails pd, String rollNo, String department, String yearOfJoining) {
        super(userId, password, role);
        this.pd = pd;
        this.rollNo = rollNo;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
    }

    public Student() {

    }

    /**
     *
     * @return
     */
    public String getRollNo() {
        return rollNo;
    }

    /**
     *
     * @param rollNo
     */
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    /**
     *
     * @return
     */
    public String getDepartment() {
        return department;
    }

    /**
     *
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     *
     * @return
     */
    public String getYearOfJoining() {
        return yearOfJoining;
    }

    /**
     *
     * @param yearOfJoining
     */
    public void setYearOfJoining(String yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    /**
     *
     * @return
     */
    public PersonalDetails getPd() {
        return pd;
    }

    /**
     *
     * @param pd
     */
    public void setPd(PersonalDetails pd) {
        this.pd = pd;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(pd, student.pd) && Objects.equals(rollNo, student.rollNo) && Objects.equals(department, student.department) && Objects.equals(yearOfJoining, student.yearOfJoining);
    }


    @Override
    public int hashCode() {
        return Objects.hash(pd, rollNo, department, yearOfJoining);
    }
}

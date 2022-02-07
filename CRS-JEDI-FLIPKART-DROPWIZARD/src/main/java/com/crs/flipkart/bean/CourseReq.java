package com.crs.flipkart.bean;

import java.util.Objects;

public class CourseReq {
    private String rollNo;
    private String cID;

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public CourseReq(String rollNo, String cID) {
        this.rollNo = rollNo;
        this.cID = cID;
    }

    public CourseReq() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseReq courseReq = (CourseReq) o;
        return Objects.equals(rollNo, courseReq.rollNo) && Objects.equals(cID, courseReq.cID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, cID);
    }

    @Override
    public String toString() {
        return "CourseReq{" +
                "rollNo='" + rollNo + '\'' +
                ", cID='" + cID + '\'' +
                '}';
    }
}
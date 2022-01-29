package com.crs.flipkart.bean;

public class Notification {

    private String studentId;
    private String message;
    private String extras;

    /**
     *
     * @param studentId
     * @param message
     * @param extras
     */
    public Notification(String studentId, String message, String extras) {
        super();
        this.studentId = studentId;
        this.message = message;
        this.extras = extras;
    }

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getExtras() {
        return extras;
    }
    public void setExtras(String extras) {
        this.extras = extras;
    }
}
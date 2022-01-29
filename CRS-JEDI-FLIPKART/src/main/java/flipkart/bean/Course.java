package flipkart.bean;

public class Course {

    private String courseName;
    private String courseId;
    private String instructor;

    public Course(String courseId, String courseName, String instructor) {
        super();
        this.courseName = courseName;
        this.courseId = courseId;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
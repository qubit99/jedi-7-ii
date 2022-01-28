package flipkart.bean;

public class Student extends User {

    private String rollNo;
    private String department;
    private String yearOfJoining;


    public Student(String name, String userId, String password, String role, String rollNo, String department, String yearOfJoining) {
        super(name, userId, password, role);
        this.rollNo = rollNo;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(String yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }
}

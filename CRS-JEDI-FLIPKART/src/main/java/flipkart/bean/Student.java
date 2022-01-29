package flipkart.bean;

public class Student extends User {

    private PersonalDetails pd;
    private String rollNo;
    private String department;
    private String yearOfJoining;

    public Student(String userId, String password, String role, PersonalDetails pd, String rollNo, String department, String yearOfJoining) {
        super(userId, password, role);
        this.pd = pd;
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

    public PersonalDetails getPd() {
        return pd;
    }

    public void setPd(PersonalDetails pd) {
        this.pd = pd;
    }
}

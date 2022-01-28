package flipkart.bean;

import java.util.List;

public class Professor extends User{

    private String department;
    private String designation;

    public Professor(String name, String userId, String password, String role, String department, String designation) {
        super(name, userId, password, role);
        this.department = department;
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

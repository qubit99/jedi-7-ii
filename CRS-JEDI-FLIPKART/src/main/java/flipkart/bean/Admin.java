package flipkart.bean;

public class Admin extends User {

    private PersonalDetails pd;

    public Admin(String userId, String password, String role, PersonalDetails pd) {
        super(userId, password, role);
        this.pd = pd;
    }
}

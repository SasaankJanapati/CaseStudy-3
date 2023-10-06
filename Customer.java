import java.util.*;

public class Customer {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String userName;
    private String password;
    private ArrayList<Policy> policies;

    Customer() {
    }
    /*
     * Customer(String name, String phoneNumber, String email, String userName,
     * String password) {
     * this.name = name;
     * this.setPhoneNumber(phoneNumber);
     * this.email = email;
     * this.userName = userName;
     * this.password = password;
     * }
     */

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

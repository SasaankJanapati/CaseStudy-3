import java.util.*;

public class Customer {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String userName;
    private String password;
    private ArrayList<Policy> policies;

    Customer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        this.name = sc.next();
        System.out.println("Enter your name");
        this.phoneNumber = sc.next();
        System.out.println("Enter your name");
        this.email = sc.next();
        System.out.println("Enter your name");
        this.address = sc.next();
        System.out.println("Enter your name");
        this.userName = sc.next();
        System.out.println("Enter your name");
        this.password = sc.next();
    }

    protected void addPolicy(Policy policy){
        policies.add(policy);
    }

    public String getName() { //later change it to id
        return name;
    }
}

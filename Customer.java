import java.util.*;

public class Customer {
    static Scanner sc=new Scanner(System.in);
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String userName;
    private String password;
    private ArrayList<Policy> policies;
    private ArrayList<Claim> claims;

    // Customer(){}
    Customer(String name, String phoneNumber, String email, String userName, String password) {
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
        this.email = email;
        this.setUserName(userName);
        this.setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    Customer(){}
    /*{
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
    }*/

    protected void addPolicy(Policy policy) {
        policies.add(policy);
    }

    protected void addClaim(Claim claim){
        claims.add(claim);
    }

    protected void createNewClaim(){
        Scanner sc = new Scanner(System.in);
        String policyId = sc.next();
        for (Policy policy : policies) {
            if(policy.getId().compareTo(policyId) != 0){
                System.out.println("Policy id not found");
            }else{
                Claim claim = new Claim(policyId);
                Agent agent = new Agent();
                agent.addClaim(claim);
            }
        }
    }

    protected static boolean userNameExistence(int t,String s,ArrayList<Customer> Cu){
        Main Mn=new Main();
        for (Customer c : Cu) {
            if (c.getUserName().equals(s)) {
                String u = s;
                System.out.println("\t\tCustomer Username : " + u);
                System.out.print("\t\tEnter your password : ");
                s = sc.next();
                if (c.getPassword().equals(s)) {
                    System.out.println("\t\tWelcome " + c.getName());

                } else {
                    System.out.println("\t\tYou have entered wrong password");
                    return userNameExistence(t,s, Cu);
                }
            }else{
                System.out.println("\t\tYou have entered wrong Customer username");
                Mn.mainFunction(t, Cu);
                return true;
            }
        }
        return true;
    }

}

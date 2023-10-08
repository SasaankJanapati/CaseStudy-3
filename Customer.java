import java.util.*;

public class Customer {
    static Main2 Mn=new Main2();
    static Scanner sc=new Scanner(System.in);
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String userName;
    private String password;
    private ArrayList<Policy> policies;
    private ArrayList<Claim> claims;

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

    Customer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        this.name = sc.next();
        System.out.println("Enter your phone number");
        this.phoneNumber = sc.next();
        System.out.println("Enter your email");
        this.email = sc.next();
        System.out.println("Enter your address");
        this.address = sc.next();
        System.out.println("Enter your user name");
        this.userName = sc.next();
        System.out.println("Enter your password");
        this.password = sc.next();
    }

    protected void addPolicy(Policy policy) {
        policies.add(policy);
    }

    protected void addClaim(Claim claim) {
        claims.add(claim);
    }

    protected void createNewClaim() {
        Scanner sc = new Scanner(System.in);
        String policyId = sc.next();
        for (Policy policy : policies) {
            if (policy.getId().compareTo(policyId) != 0) {
                System.out.println("Policy id not found");
            } else {
                Claim claim = new Claim(policyId);
                new Agent(null,null,null,null).addClaim(claim);
            }
        }
    }
    protected void displayPolicies(){
        System.out.println("Your policies");
        for (Policy policy : policies) {
            System.out.println(policy.getId());
        }
        boolean isValid = false;
        while(!isValid){
            System.out.println("Choose a Policy Id");
            Scanner sc = new Scanner(System.in);
            String policyId = sc.next();
            for (Policy policy : policies) {
                if(policy.getId().compareTo(policyId) == 0){
                    policy.displayPolicy();
                    isValid = true;
                }
            }
            if(!isValid){
                System.out.println("Invalid Policy Id");
            }
        }
    }
    protected void displayClaims(){
        System.out.println("Your claims");
        for (Claim claim : claims) {
            System.out.println(claim.getId());
        }
        boolean isValid = false;
        while(!isValid){
            System.out.println("Choose a Claim Id");
            Scanner sc = new Scanner(System.in);
            String claimId = sc.next();
            for (Claim claim : claims) {
                if(claim.getId().compareTo(claimId) == 0){
                    claim.displayClaim();
                    isValid = true;
                }
            }
            if(!isValid){
                System.out.println("Invalid Claim Id");
            }
        }
    }
}

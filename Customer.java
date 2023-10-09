import java.util.*;

public class Customer {

    static InsuranceManagement Management = new InsuranceManagement();
    static Scanner sc = new Scanner(System.in);
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String userName;
    private String password;
    private boolean isBlocked = false;

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    private ArrayList<Policy> policies;
    private ArrayList<Claim> claims;

    Customer(String name, String phoneNumber, String email, String address, String userName, String password) {
        this.policies = new ArrayList<Policy>();
        this.claims = new ArrayList<Claim>();
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
        this.email = email;
        this.address = address;
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

    Customer() {
        this.policies = new ArrayList<Policy>();
        this.claims = new ArrayList<Claim>();
        System.out.println("Enter the Customer name");
        this.name = sc.next();
        System.out.println("Enter the Customer phone number");
        this.phoneNumber = sc.next();
        System.out.println("Enter the Customer email id");
        this.email = sc.next();
        System.out.println("Enter the Customer address");
        this.address = sc.next();
        System.out.println("Enter the Customer user name");
        this.userName = sc.next();
        System.out.println("Enter the Customer password");
        this.password = sc.next();
    }

    protected void addPolicy(Policy policy) {
        this.policies.add(policy);
    }

    protected void addClaim(Claim claim) {
        claims.add(claim);
    }

    protected Claim createNewClaim(Customer Cu, Database database) throws InterruptedException {
        Scanner sc=new Scanner(System.in);
        displayPoliciesId(Cu, database);
        System.out.print("\n\t\tPlease Enter your policy ID : ");
        String policyId = sc.nextLine();

        for (Policy policy : policies) {
            if (policy.getId().compareTo(policyId) != 0) {
                System.out.println("\n\t\t! Policy id not found\n\t\tPress 1 to go to Main Menu");
                int t=sc.nextInt();
                if (t==1) {
                    InsuranceManagement.customerPortalDisplay(Cu, database);
                    return null;
                }
            } else {
                Claim claim = new Claim(policyId);
                return claim;
            }
        }
        return null;
    }

    protected void displayPoliciesId(Customer Cu, Database database) throws InterruptedException {
        InsuranceManagement Management = new InsuranceManagement();
        System.out.print("\n\t\tYour policies : ");
        for (Policy policy : policies) {
            System.out.println("\t\t" + policy.getId());
        }
        return;
    }

    protected void displayPolicies(Customer Cu, Database database) throws InterruptedException {
        
        System.out.print("\n\t\tYour policies : ");
        for (Policy policy : policies) {
            System.out.println("\t\t" + policy.getId());
        }
        System.out.println("Do you want to see the details of your policies\tpress 1\nTo go to Main Menu\t\tpress 2");
        int t = sc.nextInt();
        if (t == 1) {
            boolean isValid = false;
            while (!isValid) {
                System.out.println("Choose a Policy Id");
                Scanner sc = new Scanner(System.in);
                String policyId = sc.next();
                for (Policy policy : policies) {
                    if (policy.getId().compareTo(policyId) == 0) {
                        policy.displayPolicy();
                        isValid = true;
                    }
                }
                if (!isValid) {
                    System.out.println("Invalid Policy Id");
                    System.out.println("");
                }
            }
            System.out.print("\t\tPress 1 to go to main menu :");
            int x = sc.nextInt();
            InsuranceManagement.customerPortalDisplay(Cu, database);
            return;
        } else {
            InsuranceManagement.customerPortalDisplay(Cu, database);
            return;
        }
    }

    protected void displayClaims(Customer cu,Database database)throws InterruptedException {
        System.out.println("Your claims");
        for (Claim claim : claims) {
            System.out.println(claim.getId());
        }
        if (claims.size() == 0) {
            System.out.println("You have 0 Claims");
           Management.customerPortalDisplay(cu,database);
           return;
        }
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Choose a Claim Id");
            Scanner sc = new Scanner(System.in);
            String claimId = sc.next();
            for (Claim claim : claims) {
                if (claim.getId().compareTo(claimId) == 0) {
                    claim.displayClaim();
                    isValid = true;
                }
            }
            if (!isValid) {
                System.out.println("Invalid Claim Id");
            }
        }
    }

}

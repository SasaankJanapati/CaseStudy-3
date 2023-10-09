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

    public boolean isBlocked() {// if customer types wrong password more number he gets blocked
        return isBlocked;
    }

    public void setBlocked(boolean isBlocked) {// setter for isBlocked
        this.isBlocked = isBlocked;
    }

    private ArrayList<Policy> policies;// arrayList to contain policies and claims of customer
    private ArrayList<Claim> claims;

    // parametrised constructor for customer
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

    // getter and setter of name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // setter for phonenumber
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // getter and setter for username
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // constructor for customer (it is used when agent adds policy for new customer)
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

    // adds newly created policies of customer to policies arraylist
    protected void addPolicy(Policy policy) {
        this.policies.add(policy);
    }

    // adds newly created claims of customer to claims arraylist
    protected void addClaim(Claim claim) {
        claims.add(claim);
    }

    // below method enables customer to create new claims and add them to database
    // and claims by customer
    protected Claim createNewClaim(Customer customer, Database database) throws InterruptedException {// exception to
                                                                                                      // delay time
        Scanner sc = new Scanner(System.in);
        displayPoliciesId(customer, database);
        System.out.print("\n\t\tPlease Enter your policy ID : ");
        String policyId = sc.nextLine();
        // takes policy id to which he wanted to claim and checks with policies he have
        // and gives corresponding outputs returns the claim created
        for (Policy policy : policies) {
            if (policy.getId().compareTo(policyId) != 0) {
                System.out.println("\n\t\t! Policy id not found\n\t\tPress 1 to go to Main Menu");
                int t = sc.nextInt();
                if (t == 1) {
                    InsuranceManagement.customerPortalDisplay(customer, database);
                    return null;
                }
            } else {
                Claim claim = new Claim(policyId);
                return claim;
            }
        }
        return null;
    }

    // displays the policiesId's which customer have so there is no use print all
    // policies clearly
    protected void displayPoliciesId(Customer customer, Database database) throws InterruptedException {
        InsuranceManagement Management = new InsuranceManagement();
        System.out.print("\n\t\tYour policies : ");
        for (Policy policy : policies) {
            System.out.println("\t\t" + policy.getId());
        }
        return;
    }

    // prints policies id and prints the complete details of choosen policy if it
    // exists(customerPortalDisplay takes us back to customer page)
    protected void displayPolicies(Customer customer, Database database) throws InterruptedException {

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
            InsuranceManagement.customerPortalDisplay(customer, database);
            return;
        } else {
            InsuranceManagement.customerPortalDisplay(customer, database);
            return;
        }
    }

    // prints claims id and prints the complete details of choosen claims if it
    // exists(customerPortalDisplay takes us back to customer page)
    protected void displayClaims(Customer customer, Database database) throws InterruptedException {
        System.out.println("Your claims");
        for (Claim claim : claims) {
            System.out.println(claim.getId());
        }
        if (claims.size() == 0) {
            System.out.println("You have 0 Claims");
            Management.customerPortalDisplay(customer, database);
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

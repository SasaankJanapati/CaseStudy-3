import java.util.Scanner;

public class Agent extends Database {
    private String name;
    private String id;
    private String userName;
    private String password;

    Agent(String name,String id,String userName,String password){
        this.name = name;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.addAgent(this);
    }

    protected void createNewPolicy() {
        Customer customer = new Customer();
        Policy policy = new Policy();
        customer.addPolicy(policy);
        this.addPolicy(policy);
    }

    protected void createNewPolicy(String name) {
        Customer customer = this.searchCustomer(name);
        if (customer == null) {
            System.out.println("Customer not found");
        } else {
            Policy policy = new Policy();
            customer.addPolicy(policy);
            this.addPolicy(policy);
        }
    }

    protected void createNewClaim(Claim claim) {
        this.addClaim(claim);
    }
    protected void updatePolicy(){
        this.displayPolicyIdWithLapseDate();
        System.out.println("Select Policy Id to update:");
        Scanner sc = new Scanner(System.in);
        String policyId = sc.next();
        Policy policy = this.searchPolicy(policyId);
        if (policy==null){
            System.out.println("Policy does not exist");
        }
        else{
            boolean validChoice = false;
            while(!validChoice){
                System.out.println("Did the customer Pay?(y/n) ");
                String ans =sc.next();
                ans.toLowerCase();
                if(ans.compareTo("y")==0){
                    this.financialSummaryAdder("customer with policy id "+policyId+" paid "+policy.getPremiumAmount());
                    System.out.println("Enter new Lapse Date :");
                    String newLapseDate=sc.next();
                    policy.setLapseDate(newLapseDate);
                    validChoice = true;
                }
                else if (ans.compareTo("n")==0){
                    policy.setIsActive(false);
                    validChoice = true;
                }
                else{
                    System.out.println("Invalid Choice");
                }
            }
            
        }
    }
}

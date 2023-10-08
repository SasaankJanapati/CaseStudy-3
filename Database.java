import java.util.*;
public class Database extends Report{
    private ArrayList<Adjuster> adjusters;
    private ArrayList<Agent> agents;
    private ArrayList<Customer> customers;
    private ArrayList<Policy> policies;
    private ArrayList<Claim> claims;
    private String fiancialSummary;

    protected void addPolicy(Policy policy){
        policies.add(policy);
    }
    protected void addCustomer(Customer customer){
        customers.add(customer);
    }
    protected void addClaim(Claim claim){
        claims.add(claim);
    }
    protected void addAdjuster(Adjuster adjuster){
        adjusters.add(adjuster);
    }
    protected void addAgent(Agent agent){
        agents.add(agent);
    }
    
    protected Customer searchCustomer(String name){
        for (Customer customer : customers) {
            if(customer.getName().compareTo(name) == 0){
                return customer;
            }
        }
        return null;
    }
    protected Policy searchPolicy(String policyId){
        for (Policy policy : policies) {
            if(policy.getId().compareTo(policyId)==0){
                return policy;
            }
        }
        return null;
    }
    protected Claim searchClaims(String claimId){
        for (Claim claim : claims) {
            if(claim.getId().compareTo(claimId)==0){
                return claim;
            }
        }
        return null;
    }
    protected void displayPolicyIdWithLapseDate(){
        System.out.println("Available Policies by ID with Lapse Date:");
        for (Policy policy : policies) {
            System.out.println(policy.getId()+" "+policy.getLapseDate());
        }
    }
    protected void displayPendingClaims(){
        System.out.println("Pending Claim ids");
        for (Claim claim : claims) {
            if (claim.getStatus().compareTo("pending")==0){
                System.out.println(claim.getId());
            }
        }
    }
    protected void displayPolicyReport(){
       for (Policy policy : policies) {
        policy.displayPolicy();
        System.out.println();
       } 
    }
    protected void displayClaimReport(){
       for (Claim claim : claims) {
        claim.displayClaim();
        System.out.println();
       } 
    }
    protected void financialSummaryAdder(String newTransaction){
        this.fiancialSummary = this.fiancialSummary+newTransaction+'\n';
    }
}

import java.util.*;
public class Claim {
    private String id;
    private String policyId;
    private String status;
    private String dateOfIncident;
    private String description;
    private double claimAmount;

    Claim(String policyId){
        this.policyId = policyId;
        Scanner sc = new Scanner(System.in);
        this.id = UUID.randomUUID().toString().substring(0, 7);
        System.out.println("Enter the Date of incident: ");
        this.dateOfIncident = sc.next();
        System.out.println("Give a brief description: ");
        this.description = sc.nextLine();
        System.out.println("Enter requested claim amount: ");
        this.claimAmount = sc.nextDouble();
        this.status = "pending";
    }
    protected String getStatus() {
        return status;
    }
    protected String getId() {
        return id;
    }
    protected String getPolicyId() {
        return policyId;
    }
    protected void setStatus(String status) {
        this.status = status;
    }
    public double getClaimAmount() {
        return claimAmount;
    }
    protected void displayClaim(){
        System.out.println("Claim id : "+this.id);
        System.out.println("Policy id : "+this.policyId);
        System.out.println("Date of Incident : "+this.dateOfIncident);
        System.out.println("Description : "+this.description);
        System.out.println("Claim amount requested : "+this.claimAmount);
    }
}

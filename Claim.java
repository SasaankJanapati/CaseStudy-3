import java.util.*;
public class Claim {
    private String id;
    private String policyId;
    private String dateOfIncident;
    private String description;
    private double claimAmount;

    Claim(String policyId){
        this.policyId = policyId;
        Scanner sc = new Scanner(System.in);
        this.id = UUID.randomUUID().toString().substring(0, 7);
        
        this.dateOfIncident = sc.next();
        this.description = sc.nextLine();
        this.claimAmount = sc.nextDouble();
    }
}

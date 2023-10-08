import java.util.Scanner;

public class Adjuster extends Database{
    private String name;
    private String id;
    private String userName;
    private String password;
    
    Adjuster(String name,String id,String userName,String password){
        this.name = name;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.addAdjuster(this);
    }

    protected void processClaim(){
        this.displayPendingClaims();
        System.out.println("Select Claim id to process");
        Scanner sc = new Scanner(System.in);
        String claimId = sc.next();
        Claim claim = this.searchClaims(claimId);
        if (claim==null){
            System.out.println("Claim id does not exist");
        }
        else{
            System.out.println("Policy Details");
            Policy policy = this.searchPolicy(claim.getPolicyId());
            policy.displayPolicy();
            System.out.println("Claim Details");
            claim.displayClaim();
            boolean validChoice = false;
            while(!validChoice){
                System.out.println("Approve(y) or reject(n)");
                String choice = sc.next();
                if (choice.compareTo("y")==0){
                    claim.setStatus("approved");
                    System.out.println("You have approved the claim");
                    this.financialSummaryAdder(claim.getPolicyId()+" claimed "+claim.getClaimAmount());
                    validChoice = true;
                }
                else if (choice.compareTo("n")==0){
                    claim.setStatus("rejected");
                    System.out.println("You have rejected the claim");
                    validChoice = true;
                }
                else{
                    System.out.println("Invalid choice");
                }
            }
        }
    }
}
import java.util.Scanner;

public class Adjuster extends Database {

  private String name;
  private String id;
  private String userName;
  private String password;
  private boolean isBlocked = false;
    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }
    public String getPassword() {
      return password;
    }
    public String getUserName() {
      return userName;
    }
    public String getName() {
      return name;
    }
  Adjuster(String name,String id,String userName,String password,Database database)
  {
    this.name = name;
    this.id = id;
    this.userName = userName;
    this.password = password;
    database.addAdjuster(this);
  }

  protected void processClaim(Database db) {
    db.displayPendingClaims();
    System.out.println("Select Claim id to process");
    Scanner sc = new Scanner(System.in);
    String claimId = sc.next();
    Claim claim = db.searchClaims(claimId);
    if (claim == null) {
      System.out.println("Claim id does not exist");
    } else {
      System.out.println("Policy Details");
      Policy policy = db.searchPolicy(claim.getPolicyId());
      policy.displayPolicy();
      System.out.println("Claim Details");
      claim.displayClaim();
      boolean validChoice = false;
      while (!validChoice) {
        System.out.println("Approve(y) or reject(n)");
        String choice = sc.next();
        if (choice.compareTo("y") == 0) {
          claim.setStatus("approved");
          System.out.println("You have approved the claim");
          db.financialSummaryAdder(
              claim.getPolicyId() + " claimed " + claim.getClaimAmount()
            );
          validChoice = true;
        } else if (choice.compareTo("n") == 0) {
          claim.setStatus("rejected");
          System.out.println("You have rejected the claim");
          validChoice = true;
        } else {
          System.out.println("Invalid choice");
        }
      }
    }
  }
}

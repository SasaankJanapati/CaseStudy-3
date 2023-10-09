package InsuranceManagement;
import java.util.Scanner;


//The adjuster inherits the non-private methods of the Database class
public class Adjuster extends Database {
//private attributes of an adjuster
  private String name;
  private String id;
  private String userName;
  private String password;
// the account gets blocked when the adjuster tries to log in more than three times
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
//parameterized constructor of adjuster object
  public Adjuster(String name, String id, String userName, String password, Database database) {
    this.name = name;
    this.id = id;
    this.userName = userName;
    this.password = password;
// whenever an adjuster object is created it will added 
    database.addAdjuster(this);
  }
/*
The following method is implemented by the adjuster to approve or reject the pending classes
We take the database as an argument in the function
We then use a method of the database object to display te currently pending claims to the adjuster
If there are no pending claims then we return
Otherwise we take the claim id to process as an input
If the adjuster enters an invalid claim id which does not exist in the database, we print the same
Else we print the respective policy and claim details
Finally the adjsuter changes the claim status
The report of claim amount credited is added to the financial summaries
*/
  protected void processClaim(Database database) {
    Scanner sc = new Scanner(System.in);
    int status = database.displayPendingClaims();
    if (status == -1) {
      System.out.println("No pending claims to process");
      return;
    }
    System.out.println("Select Claim id to process");
    String claimId = sc.next();
    Claim claim = database.searchClaims(claimId);
    if (claim == null) {
      System.out.println("Claim id does not exist");
    } else {
      System.out.println("Policy Details");
      Policy policy = database.searchPolicy(claim.getPolicyId());
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
          database.financialSummaryAdder(
              claim.getPolicyId() + " claimed " + claim.getClaimAmount());
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

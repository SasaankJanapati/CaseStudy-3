import java.util.ArrayList;
import java.util.Scanner;

public class Agent extends Database {

  private String name;
  private String id;
  private String userName;
  private String password;
  private boolean isBlocked = false;

  Agent(
    String name,
    String id,
    String userName,
    String password,
    Database database
  ) {
    this.name = name;
    this.id = id;
    this.userName = userName;
    this.password = password;
    database.addAgent(this);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isBlocked() {
    return isBlocked;
  }

  public void setBlocked(boolean isBlocked) {
    this.isBlocked = isBlocked;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  protected void createNewPolicy(Database database) {
    Customer customer = new Customer();
    Policy policy = new Policy();
    customer.addPolicy(policy);
    this.addPolicy(policy);
    database.addCustomer(customer);
  }

  protected void createNewPolicy(String name, Database database) {
    Customer customer = this.searchCustomer(name);
    if (customer == null) {
      System.out.println("Customer not found");
    } else {
      Policy policy = new Policy();
      customer.addPolicy(policy);
      database.addPolicy(policy);
    }
  }

  protected void createNewClaim(Claim claim) {
    this.addClaim(claim);
  }

  protected void updatePolicy() {
    this.displayPolicyIdWithLapseDate();
    System.out.println("Select Policy Id to update:");
    Scanner sc = new Scanner(System.in);
    String policyId = sc.next();
    Policy policy = this.searchPolicy(policyId);
    if (policy == null) {
      System.out.println("Policy does not exist");
    } else {
      boolean validChoice = false;
      while (!validChoice) {
        System.out.println("Did the customer Pay?(y/n) ");
        String ans = sc.next();
        ans.toLowerCase();
        if (ans.compareTo("y") == 0) {
          this.financialSummaryAdder(
              "customer with policy id " +
              policyId +
              " paid " +
              policy.getPremiumAmount()
            );
          System.out.println("Enter new Lapse Date :");
          String newLapseDate = sc.next();
          policy.setLapseDate(newLapseDate);
          validChoice = true;
        } else if (ans.compareTo("n") == 0) {
          policy.setIsActive(false);
          validChoice = true;
        } else {
          System.out.println("Invalid Choice");
        }
      }
    }
  }
}

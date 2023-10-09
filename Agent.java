import java.util.ArrayList;
import java.util.Scanner;

public class Agent extends Database {
static Scanner sc=new Scanner(System.in);
  static InsuranceManagement Management = new InsuranceManagement();
  private String name;
  private String id;
  private String userName;
  private String password;
  private boolean isBlocked = false;

  Agent( String name, String id, String userName, String password, Database database ) {
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

  //Policy for a new customer 
  protected void createNewPolicy(Database database) {
    Customer customer = new Customer();
    Policy policy = new Policy();
    customer.addPolicy(policy);
    this.addPolicy(policy);
    database.addCustomer(customer);
  }

  //Predefined Policy
  protected void createNewPolicy(Customer c1,Database database){
    Policy policy =new Policy(true,"1 Jan 2050","car",1000000,10000,10);
    c1.addPolicy(policy);
    database.addPolicy(policy);
  }

  //This is for exisiting customer 
  protected void createNewPolicy(String userName, Database database) {
    Customer customer = database.searchCustomer(userName);
    if (customer == null) {
      System.out.println("Customer not found");
    } else {
      Policy policy = new Policy();
      customer.addPolicy(policy);
      database.addPolicy(policy);
    }
  }

  protected void createNewClaim(Claim claim,Database database) {
    database.addClaim(claim);
  }

  protected void updatePolicy(Database db,Agent Ag) throws InterruptedException {
    db.displayPolicyIdWithLapseDate();
    System.out.println("Select Policy Id to update:");
    Scanner sc = new Scanner(System.in);
    String policyId = sc.next();
    Policy policy = db.searchPolicy(policyId);
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
          sc.nextLine();
          System.out.println("Enter new Lapse Date :");
          String newLapseDate = sc.nextLine();
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
    System.out.println("Press 1 to go to Main Menu");
    int a=sc.nextInt();
    Management.agentPortalDisplay(Ag);
    Management.agentMainMenu(Ag,3,db);
    return;
  }
}

package InsuranceManagement;
import java.util.Scanner;

/*
 * Agent is implemented as a class, extends the database class so the 
 * class can use all the database methods to modify the database 
 * Agent can add customrs, create new policy and update policy
 * 
 * Inheritence is implemented
 */
public class Agent extends Database {
/*
 * Scanner is being used by the agent in all functions
 * Instead of passing scanner to each and every method as required
 * We are making a static scanner object that can be used by the agents 
 * 
 * We understand that for large scale implementation this would cause 
 * a problem as there will be only one scanner created for all agents
 * 
 * In this case study as concurrent access isn't possible it's not a issue,
 * If the application is to be scaled up, then a better alternative is needed 
 */
static Scanner sc=new Scanner(System.in);
  static InsuranceManagement management = new InsuranceManagement();
  /*
   * All of the data about the agent is kept private for confidentiality
   * implementing encapsulation
   */
  private String name;
  private String id;
  private String userName;
  private String password;
  private boolean isBlocked = false;

  /*
   * Parameterised constructor to create agents to be added to the database
   * This constructor will be used by the company , in order to simulate agents,
   * We are creating agents to show functionality
   */
  public Agent( String name, String id, String userName, String password, Database database ) {
    this.name = name;
    this.id = id;
    this.userName = userName;
    this.password = password;
    database.addAgent(this);
  }
  /*
   * Getters and Setters to get and set private attributes 
   * Implementing Encapsulation
   */
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

  /*
   * Create new policy is a overloaded method
   * If a new customer approaches the Agent, the first method is used
   * If a existing customer approaches the Agent, the second method is used
   * If we know the userId of the customer third method is used
   * If the customer object is defined, second method is used
   */
  // Overloaded method 1
  protected void createNewPolicy(Database database) {
    Customer customer = new Customer();
    Policy policy = new Policy();
    customer.addPolicy(policy);
    this.addPolicy(policy);
    database.addCustomer(customer);
  }

  // Overloaded method 2
  public void createNewPolicy(Customer c1,Database database){
    Policy policy =new Policy(true,"1 Jan 2050","car",1000000,10000,10);
    c1.addPolicy(policy);
    database.addPolicy(policy);
  }

  // Overloaded method 3
  protected void createNewPolicy(String userName, Database database) {
    try{
      Customer customer = database.searchCustomer(userName);
      Policy policy = new Policy();
      customer.addPolicy(policy);
      database.addPolicy(policy);
    }
    catch(CustomerNotFoundException exception){
      System.out.println("Please try again");
    }
    
  }
  /*
   * The customer should not have access to the database
   * Therefore the customer will make a claim which in the real world 
   * he will give to any agent he can find
   * The agent then adds the data to the database
   * 
   * In this way the database is never made accessible to the customer
   */
  protected void createNewClaim(Claim claim,Database database) {
    database.addClaim(claim);
  }
  /*
   * The agent can update the policy by changing the lapse date if the customer has paid 
   * Lapse date refers to the next last date for payment
   * if the customer defaulted, the agent can deactivate the policy 
   */
  protected void updatePolicy(Database database,Agent agent) throws InterruptedException {
    database.displayPolicyIdWithLapseDate();
    System.out.println("Select Policy Id to update:");
    Scanner sc = new Scanner(System.in);
    String policyId = sc.next();
    Policy policy = database.searchPolicy(policyId);
    
    if (policy == null) {
      System.out.println("Policy does not exist");
    } 
    else {
      /*
       * As long as there is a valid input
       * We will keep on asking for input
       */
      boolean validChoice = false;
      while (!validChoice) {
        System.out.println("Did the customer Pay?(y/n) ");
        String ans = sc.next();
        ans.toLowerCase();
        if (ans.compareTo("y") == 0) {
          this.financialSummaryAdder("customer with policy id " +policyId +" paid " +policy.getPremiumAmount());
          sc.nextLine();
          System.out.println("Enter new Lapse Date :");
          String newLapseDate = sc.nextLine();
          policy.setLapseDate(newLapseDate);
          validChoice = true;
        } 
        else if (ans.compareTo("n") == 0) {
          policy.setIsActive(false);
          validChoice = true;
        } 
        else {
          System.out.println("Invalid Choice");
        }
      }
    }
    /*
     * As there is only one option, we aren't checking 
     */
    System.out.println("Press 1 to go to Main Menu");
    int a=sc.nextInt();
    InsuranceManagement.agentPortalDisplay(agent);
    management.agentMainMenu(agent,3,database);
    return;
  }
}

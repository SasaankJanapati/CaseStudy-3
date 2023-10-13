import java.util.*;
// This is tje database class which contains all thge data realted to costumers,agents,adjusters,policies,financial statementse etc.
// In this class we implemented encapsulation by using protected methods,variables and private methods,variables
// Here we are using inheritence here by extending the report class to database 
// Here we are uisng exceprtion handeling to make to make some dilays in the output generation
public class Database extends Report {
// Here we are using Static Scanner to use the scanner in all the methods across the classes 
  static Scanner sc = new Scanner(System.in);
// Here we are using this Static method for delaying the code
  static void timeOut(int t) throws InterruptedException {
    Thread.sleep(t);
    System.out.print(".");
    Thread.sleep(t);
    System.out.print(".");
    Thread.sleep(t);
  }
// Here are we are Using private access modifier to to make sure that they are not accessed outside the class scope(Encapsulation).
  private ArrayList<Adjuster> adjusters;
  private ArrayList<Agent> agents;
  private ArrayList<Customer> customers;
  private ArrayList<Policy> policies;
  private ArrayList<Claim> claims;
  private String financialSummary;
// This is a constructor which is used to initialize all the arraylists and variables .
  Database() {
    this.adjusters = new ArrayList<Adjuster>();
    this.agents = new ArrayList<Agent>();
    this.customers = new ArrayList<Customer>();
    this.policies = new ArrayList<Policy>();
    this.claims = new ArrayList<Claim>();
    this.financialSummary = "";
  }
// This method is used to add polices to policies array list.
  protected void addPolicy(Policy policy) {
    policies.add(policy);
  }
// This method is used to add customers to customers array list.
  protected void addCustomer(Customer customer) {
    customers.add(customer);
  }
// This method is used to add claim to claims array list.
  protected void addClaim(Claim claim) {
    claims.add(claim);
  }
// This method is used to add adjusters to adjuster array list.
  protected void addAdjuster(Adjuster adjuster) {
    adjusters.add(adjuster);
  }
// This method is used to add agents to agent  array list.
  protected void addAgent(Agent agent) {
    agents.add(agent);
  }
// This method is used to search whether the given customer user name is in the existing customers
  protected Customer searchCustomer(String name) {
    for (Customer customer : customers) {
      if (customer.getUserName().compareTo(name) == 0) {
        return customer;
      }
    }
    return null;
  }
// This method is used to search whether the given agent user name is in the existing users
  protected Agent searchAgent(String name) {
    for (Agent agent : agents) {
      if (agent.getUserName().compareTo(name) == 0) {
        return agent;
      }
    }
    return null;
  }
// This method is used to search whether the given adjuster user name is in the existing adjusters
  protected Adjuster searchAdjuster(String name) {
    for (Adjuster adjuster : adjusters) {
      if (adjuster.getUserName().compareTo(name) == 0) {
        return adjuster;

      }
    }
    // System.out.println("hi");
    return null;
  }
// This method is used to whether the given passward is correct or not for customer
  protected boolean passwordVerification(Customer costumer, int count)
      throws InterruptedException {
    System.out.print("\t\tPlease Enter you Password : ");

    String password = sc.next();
    if (!password.equals(costumer.getPassword())) {
      if (count >= 1) {
        System.out.print("\033[H\033[2J");
        System.out.println("\t\tWelcome to IIT INUSRANCE");
        System.out.println(
            "\t\t!!!You have entered an incorrect password\n\tYou have " +
                count +
                " attempts after which your account will be blocked for 24 hours");
        return passwordVerification(costumer, count -= 1);
      } else {
        int t = 4;
        while (t > 0) {
          System.out.print("\033[H\033[2J");
          System.out.println(
              "\t\tWelcome to IIT INUSRANCE\n\n\tCustomer UserName : " +
              costumer.getUserName());
          System.out.print( "\t\t!!!Incorrect Password Entered many times\n\t\tYour account is blocked for 24hrs\n\t\tPlease approach the Bank Manager for enguiry\n\t\tThe Screen will return to Main Menu in \' "     +     t +     " \' sec\n\t\t\t\t.");
          timeOut(300);
          t--;
        }
        costumer.setBlocked(true);
        // InsuranceManagement.mainFunction();
        return false;
      }
    }
    return true;
  }
// This method is used to whether the given passward is correct or not for agents
  protected boolean passwordVerification(Agent agent, int count)
      throws InterruptedException {
    System.out.print("\t\tPlease Enter you Password : ");

    String password = sc.next();
    if (!password.equals(agent.getPassword())) {
      if (count >= 1) {
        System.out.print("\033[H\033[2J");
        System.out.println("\t\tWelcome to IIT INUSRANCE");
        System.out.println(
            "\t\t!!!You have entered an incorrect password\n\tYou have " +
                count +
                " attempts after which your account will be blocked for 24 hours");
        return passwordVerification(agent, count -= 1);
      } else {
        // t=countdown time
        int t = 4;
        while (t > 0) {
          System.out.print("\033[H\033[2J");
          System.out.println(
              "\t\tWelcome to IIT INUSRANCE\n\n\tCustomer UserName : " +
              agent.getUserName());
          System.out.print("\t\t!!!Incorrect Password Entered many times\n\t\tYour account is blocked for 24hrs\n\t\tPlease approach the Bank Manager for enguiry\n\t\tThe Screen will return to Main Menu in \' "    +    t +    " \' sec\n\t\t\t\t.");
          timeOut(500);
          t--;
        }
        agent.setBlocked(true);
        // InsuranceManagement.mainFunction();
        return false;
      }
    }
    return true;
  }
// This method is used to whether the given passward is correct or not for adjuster
  protected boolean passwordVerification(Adjuster adjuster, int count)
      throws InterruptedException {
    System.out.print("\t\tPlease Enter you Password : ");

    String password = sc.next();
    if (!password.equals(adjuster.getPassword())) {
      if (count >= 1) {
        System.out.print("\033[H\033[2J");
        System.out.println("\t\tWelcome to IIT INUSRANCE");
        System.out.println( "\t\t!!!You have entered an incorrect password\n\tYou have " +     count +     " attempts after which your account will be blocked for 24 hours");
        return passwordVerification(adjuster, count -= 1);
      } else {
        int t = 4;
        while (t > 0) {
          System.out.print("\033[H\033[2J");
          System.out.println("\t\tWelcome to IIT INUSRANCE\n\n\tAdjuster UserName : " +adjuster.getUserName());System.out.print(    "\t\t!!!Incorrect Password Entered many times\n\t\tYour account is blocked for 24hrs\n\t\tPlease approach the Bank Manager for enguiry\n\t\tThe Screen will return to Main Menu in \' "        +        t +        " \' sec\n\t\t\t\t.");
          timeOut(500);
          t--;
        }
        adjuster.setBlocked(true);
        // InsuranceManagement.mainFunction();
        return false;
      }
    }
    return true;
  }
// This method is used to check if the the given policy is existing or not
  protected Policy searchPolicy (String policyId) throws PolicyNotFoundException{
    for (Policy policy : policies) {
      if (policy.getId().compareTo(policyId) == 0) {
        return policy;
      }
    }
    throw new PolicyNotFoundException();
  }
// This method is used to check if the the given claim is existing or not
  protected Claim searchClaims(String claimId) throws ClaimNotFoundException{
    for (Claim claim : claims) {
      if (claim.getId().compareTo(claimId) == 0) {
        return claim;
      }
    }
    throw new ClaimNotFoundException();
  }
// This method is used to display the polocy id with lapse date
  protected void displayPolicyIdWithLapseDate() {
    System.out.println("Available Policies by ID with Lapse Date:");
    for (Policy policy : policies) {
      System.out.println(policy.getId() + " " + policy.getLapseDate());
    }
  }
// This method is used to display the pending claims
  protected int displayPendingClaims() {
    System.out.println("Pending Claim ids");
    boolean isEmpty = true;
    for (Claim claim : claims) {
      if (claim.getStatus().compareTo("pending") == 0) {
        System.out.println(claim.getId());
        isEmpty = false;
      }
    }
    if (isEmpty) {
      System.out.println("No Pending Claims");
      return -1;
    }
    return 0;
  }
// this methios is used to display the policy reports
  protected void displayPolicyReport() {
    for (Policy policy : policies) {
      policy.displayPolicy();
      System.out.println();
    }
  }
// this method is used to dispaly the claim reports
  protected void displayClaimReport() {
    for (Claim claim : claims) {
      claim.displayClaim();
      System.out.println();
    }
  }
// This method is used to add compute financial summary
  protected void financialSummaryAdder(String newTransaction) {
    this.financialSummary = this.financialSummary + newTransaction + '\n';
  }
// This method is used to print the financial summary report
  protected void printFinancialSummary() {
    System.out.println("Financial Summary\n" + financialSummary);
  }
}

import java.util.*;

public class Database extends Report {

  static Scanner sc = new Scanner(System.in);

  static void timeOut(int t) throws InterruptedException {
    Thread.sleep(t);
    System.out.print(".");
    Thread.sleep(t);
    System.out.print(".");
    Thread.sleep(t);
  }

  private ArrayList<Adjuster> adjusters;
  private ArrayList<Agent> agents;
  private ArrayList<Customer> customers;
  private ArrayList<Policy> policies;
  private ArrayList<Claim> claims;
  private String fiancialSummary;
  Database() {
    this.adjusters = new ArrayList<Adjuster>();
    this.agents = new ArrayList<Agent>();
    this.customers = new ArrayList<Customer>();
    this.policies = new ArrayList<Policy>();
    this.claims = new ArrayList<Claim>();
  }

  protected void addPolicy(Policy policy) {
    policies.add(policy);
  }

  protected void addCustomer(Customer customer) {
    customers.add(customer);
  }

  protected void addClaim(Claim claim) {
    claims.add(claim);
  }

  protected void addAdjuster(Adjuster adjuster) {
    adjusters.add(adjuster);
  }

  protected void addAgent(Agent agent) {
    agents.add(agent);
  }

  protected Customer searchCustomer(String name){
    for (Customer customer : customers) {
      if (customer.getUserName().compareTo(name) == 0) {
        return customer;
      }
    }
    return null;
  }

  protected Agent searchAgent(String name) {
    for (Agent agent : agents) {
      if (agent.getUserName().compareTo(name) == 0) {
        return agent;
      }
    }
    return null;
  }
  protected Adjuster searchAdjuster(String name) {
    for (Adjuster adjuster : adjusters) {
      if (adjuster.getUserName().compareTo(name) == 0) {
        //System.out.println("hi");
        return adjuster;
        
      }
    }
   // System.out.println("hi");
    return null;
  }
  protected boolean passwordVerification(Customer Cu, int count)
    throws InterruptedException {
    System.out.print("\t\tPlease Enter you Password : ");

    String password = sc.next();
    if (!password.equals(Cu.getPassword())) {
      if (count >= 1) {
        System.out.print("\033[H\033[2J");
        System.out.println("\t\tWelcome to IIT INUSRANCE");
        System.out.println(
          "\t\t!!!You have entered an incorrect password\n\tYou have " +
          count +
          " attempts after which your account will be blocked for 24 hours"
        );
        return passwordVerification(Cu, count -= 1);
      } else {
        // t=countdown time
        int t = 4;
        while (t > 0) {
          System.out.print("\033[H\033[2J");
          System.out.println(
            "\t\tWelcome to IIT INUSRANCE\n\n\tCustomer UserName : " +
            Cu.getUserName()
          );
          System.out.print(
            "\t\t!!!Incorrect Password Entered many times\n\t\tYour account is blocked for 24hrs\n\t\tPlease approach the Bank Manager for enguiry\n\t\tThe Screen will return to Main Menu in \' " +
            t +
            " \' sec\n\t\t\t\t."
          );
          timeOut(300);
          t--;
        }
        Cu.setBlocked(true);
        //InsuranceManagement.mainFunction();
        return false;
      }
    }
    return true;
  }

  protected boolean passwordVerification(Agent Ag, int count)
    throws InterruptedException {
    System.out.print("\t\tPlease Enter you Password : ");

    String password = sc.next();
    if (!password.equals(Ag.getPassword())) {
      if (count >= 1) {
        System.out.print("\033[H\033[2J");
        System.out.println("\t\tWelcome to IIT INUSRANCE");
        System.out.println(
          "\t\t!!!You have entered an incorrect password\n\tYou have " +
          count +
          " attempts after which your account will be blocked for 24 hours"
        );
        return passwordVerification(Ag, count -= 1);
      } else {
        // t=countdown time
        int t = 4;
        while (t > 0) {
          System.out.print("\033[H\033[2J");
          System.out.println(
            "\t\tWelcome to IIT INUSRANCE\n\n\tCustomer UserName : " +
            Ag.getUserName()
          );
          System.out.print(
            "\t\t!!!Incorrect Password Entered many times\n\t\tYour account is blocked for 24hrs\n\t\tPlease approach the Bank Manager for enguiry\n\t\tThe Screen will return to Main Menu in \' " +
            t +
            " \' sec\n\t\t\t\t."
          );
          timeOut(500);
          t--;
        }
        Ag.setBlocked(true);
        //InsuranceManagement.mainFunction();
        return false;
      }
    }
    return true;
  }
  protected boolean passwordVerification(Adjuster Ad, int count)
  throws InterruptedException {
  System.out.print("\t\tPlease Enter you Password : ");

  String password = sc.next();
  if (!password.equals(Ad.getPassword())) {
    if (count >= 1) {
      System.out.print("\033[H\033[2J");
      System.out.println("\t\tWelcome to IIT INUSRANCE");
      System.out.println(
        "\t\t!!!You have entered an incorrect password\n\tYou have " +
        count +
        " attempts after which your account will be blocked for 24 hours"
      );
      return passwordVerification(Ad, count -= 1);
    } else {
      // t=countdown time
      int t = 4;
      while (t > 0) {
        System.out.print("\033[H\033[2J");
        System.out.println(
          "\t\tWelcome to IIT INUSRANCE\n\n\tAdjuster UserName : " +
          Ad.getUserName()
        );
        System.out.print(
          "\t\t!!!Incorrect Password Entered many times\n\t\tYour account is blocked for 24hrs\n\t\tPlease approach the Bank Manager for enguiry\n\t\tThe Screen will return to Main Menu in \' " +
          t +
          " \' sec\n\t\t\t\t."
        );
        timeOut(500);
        t--;
      }
      Ad.setBlocked(true);
      //InsuranceManagement.mainFunction();
      return false;
    }
  }
  return true;
}

  protected Policy searchPolicy(String policyId) {
    for (Policy policy : policies) {
      if (policy.getId().compareTo(policyId) == 0) {
        return policy;
      }
    }
    return null;
  }

  protected Claim searchClaims(String claimId) {
    for (Claim claim : claims) {
      if (claim.getId().compareTo(claimId) == 0) {
        return claim;
      }
    }
    return null;
  }

  protected void displayPolicyIdWithLapseDate() {
    System.out.println("Available Policies by ID with Lapse Date:");
    for (Policy policy : policies) {
      System.out.println(policy.getId() + " " + policy.getLapseDate());
    }
  }

  protected void displayPendingClaims() {
    System.out.println("Pending Claim ids");
    for (Claim claim : claims) {
      if (claim.getStatus().compareTo("pending") == 0) {
        System.out.println(claim.getId());
      }
    }
  }

  protected void displayPolicyReport() {
    for (Policy policy : policies) {
      policy.displayPolicy();
      System.out.println();
    }
  }

  protected void displayClaimReport() {
    for (Claim claim : claims) {
      claim.displayClaim();
      System.out.println();
    }
  }

  protected void financialSummaryAdder(String newTransaction) {
    this.fiancialSummary = this.fiancialSummary + newTransaction + '\n';
  }
}

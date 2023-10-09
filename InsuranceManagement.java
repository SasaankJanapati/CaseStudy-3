import java.util.*;

public class InsuranceManagement extends Database {
static InsuranceManagement Management=new InsuranceManagement();
  static Scanner sc = new Scanner(System.in);

  //Initial Display
  static void welcomeDisplay() {
    System.out.print("\033[H\033[2J");
    System.out.println(
      "\t\tWelcome to IIT INUSRANCE\n\n\tThorugh which account type you want to enter : \n\t\tCustomer \tPress 1\n\t\tAgent\t\tPress 2\n\t\tAdjuster\tPress 3"
    );
  }

  static void LoginDisplay(String name) {
    System.out.print("\033[H\033[2J");
    System.out.print("\t\tWelcome to IIT INUSRANCE\n\n\t\tEnter your " + name + " Username : ");
  }

  static void customerPortalDisplay(Customer Cu,Database database) throws InterruptedException {
    System.out.print("\033[H\033[2J");
    System.out.println("\t\tIIT INUSRANCE\n\n\tWelcome " +Cu.getName() +"\n\tWhat do you want to do : \n\t\tDisplay Policies\t\tPress 1\n\t\tDisplay Claims\t\t\tPress 2\n\t\tCreate a new Claim\t\tPress 3\n\t\tLogout\t\t\t\tPress 4");
    customerMainMenu(Cu,2,database);
  }

  static void agentPortalDisplay(Agent Ag) {
    System.out.print("\033[H\033[2J");
    System.out.println("\t\tIIT INUSRANCE\n\n\tWelcome Agent " +Ag.getName() +"\n\tWhat do you want to do : \n\t\tCreate a new Claim\t\tPress 1\n\t\tCreate a new Policy\t\t\tPress 2\n\t\tUpdate a Policy\t\tPress 3\n\t\tLogout\t\t\t\tPress 4");
  }

  private static void customerMainMenu(Customer customer,int count,Database db) throws InterruptedException{
    int t = sc.nextInt();
        switch (t) {
          case 1:
            customer.displayPolicies(customer,db);
            break;
          case 2:
            customer.displayClaims();
            break;
          case 3:
            db.addClaim(customer.createNewClaim());
            break;
          case 4:
            Management.mainFunction(db);
            break;
        }
    return;
  }

  private void Customer(int count,Database db) throws InterruptedException {
    String s = sc.next();
    Customer customer = db.searchCustomer(s);
    if (customer != null) {
      if (db.passwordVerification(customer, 3)) {
        customerPortalDisplay(customer,db);
        customerMainMenu(customer, count, db);
      } else {
        mainFunction(db);
        return;
      }
    } else {
      if (count > 0) {
        System.out.println("\t\tYou have entered an invalid Customer Username\n\n\t\tIf you want to exit\t\t\t\t\t\t Press 1\n\t\tIf you want to enter your Customer Username again\t\t press 2 ");
        int t = sc.nextInt();
        if (t == 1) {
          mainFunction(db);
          return;
        } else {
          LoginDisplay("Customer");
          Customer(count -= 1,db);
          return;
        }
      } else {
        int t = 3;
        while (t > 0) {
          System.out.print("\033[H\033[2J");
          System.out.print("\t\tIncorrect Customer Username entered many times\n\t\tThe Screen will return to Main Menu in \' " +t +" \' sec\n\t\t\t\t.");
          timeOut(300);
          t--;
        }
        mainFunction(db);
        return;
      }
    }
  }

  private void Agent( Database db,int count) throws InterruptedException {
    String name = sc.next();
    Agent agent = db.searchAgent(name);
    if (agent != null) {
      if (db.passwordVerification(agent, 3)) {
        agentPortalDisplay(agent);
        int t = sc.nextInt();
        switch (t) {
          case 1:
            //agent.createNewClaim();
            break;
          case 2:
            agent.createNewPolicy(db);
            break;
          case 3:
            agent.updatePolicy();
            break;
          case 4:
            mainFunction(db);
            break;
        }
      } else {
        mainFunction(db);
        return;
      }
    } else {
      if (count > 0) {
        System.out.println("\t\tYou have entered an invalid Agent Username\n\n\t\tIf you want to exit\t\t\t\t\t\t Press 1\n\t\tIf you want to enter your Customer Username again\t\t press 2 ");
        int t = sc.nextInt();
        if (t == 1) {
          mainFunction(db);
          return;
        } else {
          LoginDisplay("Agent");
          Agent(db,count -= 1);
          return;
        }
      } else {
        int t = 3;
        while (t > 0) {
          System.out.print("\033[H\033[2J");
          System.out.print("\t\tIncorrect Agent Username entered many times\n\t\tThe Screen will return to Main Menu in \' " +t +" \' sec\n\t\t\t\t.");
          timeOut(300);
          t--;
        }
        mainFunction(db);
        return;
      }
    }
  }

  public void mainFunction(Database db) throws InterruptedException {
    welcomeDisplay();
    int t = sc.nextInt();
    if (t == 1) {
      LoginDisplay("Customer");
      Customer( 2,db);
    }
    if (t == 2) {
      LoginDisplay("Agent");
      Agent(db,2);
    }
  }
}

import java.util.*;

public class InsuranceManagement extends Database {
  static InsuranceManagement Management = new InsuranceManagement();
  static Scanner sc = new Scanner(System.in);

  // Initial Display
  static void welcomeDisplay() {
    // System.out.print("\033[H\033[2J");
    System.out.println(
        "\t\tWelcome to IIT INUSRANCE\n\n\tThorugh which account type you want to enter : \n\t\tCustomer \tPress 1\n\t\tAgent\t\tPress 2\n\t\tAdjuster\tPress 3\n\t\tReport\tPress 4");
  }

  static void LoginDisplay(String name) {
    // System.out.print("\033[H\033[2J");
    System.out.print("\t\tWelcome to IIT INUSRANCE\n\n\t\tEnter your " + name + " Username : ");
  }

  static void customerPortalDisplay(Customer Cu, Database database) throws InterruptedException {
    // System.out.print("\033[H\033[2J");
    System.out.println("\t\tIIT INUSRANCE\n\n\tWelcome " + Cu.getName()
        + "\n\tWhat do you want to do : \n\t\tDisplay Policies\t\tPress 1\n\t\tDisplay Claims\t\t\tPress 2\n\t\tCreate a new Claim\t\tPress 3\n\t\tLogout\t\t\t\tPress 4");
    customerMainMenu(Cu, 2, database);
  }

  static void agentPortalDisplay(Agent Ag) {
    // System.out.print("\033[H\033[2J");
    System.out.println("\t\tIIT INUSRANCE\n\n\tWelcome Agent " + Ag.getName()
        + "\n\tWhat do you want to do : \n\t\tCreate a new Policy\t\tPress 1\n\t\tUpdate a Policy\t\t\tPress 2\n\t\tLogout\t\t\t\tPress 3");
  }

  static void adjusterPortalDisplay(Adjuster adjuster) {
    // System.out.print("\033[H\033[2J");
    System.out.println("\t\tIIT INUSRANCE\n\n\tWelcome Adjuster " + adjuster.getName()
        + "\n\tWhat do you want to do : \n\t\tProcess Claims\t\t\tPress 1\n\t\tLogout\t\t\t\tPress 2");
  }

  private static void customerMainMenu(Customer customer, int count, Database db) throws InterruptedException {
    int t = sc.nextInt();
    switch (t) {
      case 1:
        customer.displayPolicies(customer, db);
        break;
      case 2:
        customer.displayClaims(customer, db);
        break;
      case 3:
        db.addClaim(customer.createNewClaim(customer, db));
        System.out.println("Your claim has been created\n\t\tPress 1 to go to main menu");
        t = sc.nextInt();
        customerPortalDisplay(customer, db);
        break;
      case 4:
        Management.mainFunction(db);
        break;
    }
    return;
  }

  protected void agentMainMenu(Agent agent, int count, Database db) throws InterruptedException {
    int t = sc.nextInt();
    switch (t) {
      case 1:
        System.out.println(
            "\n\t If you want to creat a new policy for an exisiting customer\tPress 1\n\tIf Want to create a new customer\t\tPress 2");
        t = sc.nextInt();
        if (t == 2) {
          agent.createNewPolicy(db); // For a new Customer
          System.out.println("New Customer crated and a policy is created");
          agentPortalDisplay(agent);
          agentMainMenu(agent, count, db);
          break;
        } else {
          System.out.print("\t\tEnter the Customer Name :");
          String name = sc.next();
          agent.createNewPolicy(name, db);
          // System.out.println("A New Policy has been created for cusomter : "+name);
          agentPortalDisplay(agent);
          agentMainMenu(agent, count, db);
          break;
        }
      case 2:
        agent.updatePolicy(db, agent);
        break;
      case 3:
        Management.mainFunction(db);
        break;
    }
    return;
  }

  private void Customer(int count, Database db) throws InterruptedException {
    String s = sc.next();
    Customer customer = db.searchCustomer(s);
    if (customer != null) {
      if (db.passwordVerification(customer, 3)) {
        customerPortalDisplay(customer, db);
        customerMainMenu(customer, count, db);
      } else {
        mainFunction(db);
        return;
      }
    } else {
      if (count > 0) {
        System.out.println(
            "\t\tYou have entered an invalid Customer Username\n\n\t\tIf you want to exit\t\t\t\t\t\t Press 1\n\t\tIf you want to enter your Customer Username again\t\t press 2 ");
        int t = sc.nextInt();
        if (t == 1) {
          mainFunction(db);
          return;
        } else {
          LoginDisplay("Customer");
          Customer(count -= 1, db);
          return;
        }
      } else {
        int t = 3;
        while (t > 0) {
          System.out.print("\033[H\033[2J");
          System.out.print(
              "\t\tIncorrect Customer Username entered many times\n\t\tThe Screen will return to Main Menu in \' " + t
                  + " \' sec\n\t\t\t\t.");
          timeOut(300);
          t--;
        }
        mainFunction(db);
        return;
      }
    }
  }

  private void Agent(Database db, int count)
      throws InterruptedException {
    String name = sc.next();
    Agent agent = db.searchAgent(name);
    if (agent != null) {
      if (db.passwordVerification(agent, 3)) {
        agentPortalDisplay(agent);
        agentMainMenu(agent, 3, db);
      } else {
        mainFunction(db);
        return;
      }
    } else {
      if (count > 0) {
        System.out.println(
            "\t\tYou have entered an invalid Agent Username\n\n\t\tIf you want to exit\t\t\t\t\t\t Press 1\n\t\tIf you want to enter your Customer Username again\t\t press 2 ");
        int t = sc.nextInt();
        if (t == 1) {
          mainFunction(db);
          return;
        } else {
          LoginDisplay("Agent");
          Agent(db, count -= 1);
          return;
        }
      } else {
        int t = 3;
        while (t > 0) {
          System.out.print("\033[H\033[2J");
          System.out
              .print("\t\tIncorrect Agent Username entered many times\n\t\tThe Screen will return to Main Menu in \' "
                  + t + " \' sec\n\t\t\t\t.");
          timeOut(300);
          t--;
        }
        mainFunction(db);
        return;
      }
    }
  }

  protected void adjusterMainMenu(Adjuster adjuster, int count, Database db) throws InterruptedException {
    int t = sc.nextInt();
    switch (t) {
      case 1:
        adjuster.processClaim(db);
        adjusterPortalDisplay(adjuster);
        Adjuster(db, count);
        break;
      case 2:
        Management.mainFunction(db);
        break;
    }
    return;
  }

  protected void Adjuster(Database db, int count) throws InterruptedException {
    String name = sc.next();
    Adjuster adjuster = db.searchAdjuster(name);
    if (adjuster != null) {
      if (db.passwordVerification(adjuster, 3)) {
        adjusterPortalDisplay(adjuster);
        adjusterMainMenu(adjuster, count, db);
        return;
      } else {
        Management.mainFunction(db);
        return;
      }
    } else {
      if (count > 0) {
        System.out.println(
            "\t\tYou have entered an invalid Adjuster Username\n\n\t\tIf you want to exit\t\t\t\t\t\t Press 1\n\t\tIf you want to enter your Adjuster Username again\t\t press 2 ");
        int t = sc.nextInt();
        if (t == 1) {
          Management.mainFunction(db);
          return;
        } else {
          LoginDisplay("Adjuster");
          Agent(db, count -= 1);
          return;
        }
      } else {
        int t = 3;
        while (t > 0) {
          System.out.print("\033[H\033[2J");
          System.out.print(
              "\t\tIncorrect Adjuster Username entered many times\n\t\tThe Screen will return to Main Menu in \' " + t
                  + " \' sec\n\t\t\t\t.");
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
      Customer(2, db);
    }
    if (t == 2) {
      LoginDisplay("Agent");
      Agent(db, 2);
    }
    if (t == 3) {
      LoginDisplay("Adjuster");
      Adjuster(db, 2);
    }
    if (t == 4) {
      db.printFinancialSummary();
      mainFunction(db);
    }
  }
}

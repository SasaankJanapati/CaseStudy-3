import java.util.*;

/*
 * Inheritance is used by the InsuranceManagement class to inherit the methods of Database.
 * This class connects all the other importnt classes like Agent,customer and adjusters.
 */

public class InsuranceManagement extends Database {

  //Here Statics object creation is done to Access all the public methods in this class
  static InsuranceManagement Management = new InsuranceManagement();

  //Static scanner is created for input in every methods for global scope
  static Scanner sc = new Scanner(System.in);

  //Customer main menu 
  private void customerMainMenu(Customer customer, int count, Database database) throws InterruptedException {
    int t = sc.nextInt();
    switch (t) {
      case 1:
        customer.displayPolicies(customer, database);   // Displays the policies of Customers 
        break;
      case 2:
        customer.displayClaims(customer, database);     // Displays the Claims of Customers 
        break;
      case 3:
        database.addClaim(customer.createNewClaim(customer, database));     // Creates new Claims of Customers 
        System.out.println("Your claim has been created\n\t\tPress 1 to go to main menu");
        t = sc.nextInt();
        customerPortalDisplay(customer, database);        // Again returns The Customer Portal
        break;
      case 4:
        Management.mainFunction(database);            // Goes back to the Main Function
        break;
    }
    return;
  }

  //Agent main menu 
  protected void agentMainMenu(Agent agent, int count, Database database) throws InterruptedException {
    int t = sc.nextInt();
    switch (t) {
      case 1:
        System.out.println(
            "\n\t If you want to creat a new policy for an exisiting customer\tPress 1\n\tIf Want to create a new customer\t\tPress 2");
        t = sc.nextInt();
        if (t == 2) {
          agent.createNewPolicy(database);           //A new policy is created by the Agent for a new customer
          System.out.println("New Customer crated and a policy is created");
          agentPortalDisplay(agent);
          agentMainMenu(agent, count, database);
          break;
        } else {        //A new policy is created by the Agent for an exisiting customer
          System.out.print("\t\tEnter the Customer Name :");
          String name = sc.next();
          agent.createNewPolicy(name, database);
          agentPortalDisplay(agent);
          agentMainMenu(agent, count, database);
          break;
        }
      case 2:
        agent.updatePolicy(database, agent);        // Updates the Policy of the customer
        break;
      case 3:
        Management.mainFunction(database);        //Returs to the Main Function
        break;
    }
    return;
  }

  //Adjuster main menu
  protected void adjusterMainMenu(Adjuster adjuster, int count, Database database) throws InterruptedException {
    int t = sc.nextInt();
    switch (t) {
      case 1:                                     // Adjuster claims Processes
        adjuster.processClaim(database);
        adjusterPortalDisplay(adjuster);
        Adjuster(database, count);
        break;
      case 2:
        Management.mainFunction(database);        //Returns to the Main Function
        break;
    }
    return;
  }

  //Customer main method containing customers methods. It is made private to restrict its access outside the class
  private void Customer(int count, Database database) throws InterruptedException {
    String s = sc.next();
    Customer customer = database.searchCustomer(s);       // Searches customer in the Database
    if (customer != null) {
      if (database.passwordVerification(customer, 3)) {     // Verifies the Password of the Customer
        customerPortalDisplay(customer, database);                
        customerMainMenu(customer, count, database);
      } else {
        mainFunction(database);                     
        return;
      }
    } else {
      if (count > 0) {
        System.out.println("\t\tYou have entered an invalid Customer Username\n\n\t\tIf you want to exit\t\t\t\t\t\t Press 1\n\t\tIf you want to enter your Customer Username again\t\t press 2 ");
        int t = sc.nextInt();
        if (t == 1) {   
          mainFunction(database);                 // Returns to the Main Function 
          return;
        } else {
          loginDisplay("Customer");           //Returns to the Login page of Customer
          Customer(count -= 1, database);
          return;
        }
      } else {
        int t = 3;
        while (t > 0) {           //Warning of Many Incorrect attempts
          System.out.print("\t\tIncorrect Customer Username entered many times\n\t\tThe Screen will return to Main Menu in \' " + t+ " \' sec\n\t\t\t\t.");
          timeOut(300);
          t--;
        }
        mainFunction(database);
        return;
      }
    }
  }

  //Agent main method containing agents methods It is made private to restrict its access outside the class
  private void Agent(Database database, int count)
      throws InterruptedException {
    String name = sc.next();
    Agent agent = database.searchAgent(name);                     //Searches the Agent in the database
    if (agent != null) {
      if (database.passwordVerification(agent, 3)) {        //Password verification for Agent
        agentPortalDisplay(agent);
        agentMainMenu(agent, 3, database);                  //Goes to the main menu of Agent
      } else {
        mainFunction(database);
        return;
      }
    } else {
      if (count > 0) {
        System.out.println("\t\tYou have entered an invalid Agent Username\n\n\t\tIf you want to exit\t\t\t\t\t\t Press 1\n\t\tIf you want to enter your Customer Username again\t\t press 2 ");
        int t = sc.nextInt();
        if (t == 1) {
          mainFunction(database);
          return;
        } else {
          loginDisplay("Agent");          // Login display of Agent
          Agent(database, count -= 1);
          return;
        }
      } else {
        int t = 3;
        while (t > 0) {
          System.out.print("\t\tIncorrect Agent Username entered many times\n\t\tThe Screen will return to Main Menu in \' "+ t + " \' sec\n\t\t\t\t.");
          timeOut(300);       //For delaying the program
          t--;
        }
        mainFunction(database);
        return;
      }
    }
  }

  //Adjuster main method containing agents methods It is made private to restrict its access outside the class
  private void Adjuster(Database database, int count) throws InterruptedException {
    String name = sc.next();
    Adjuster adjuster = database.searchAdjuster(name);          //Searches the Adjuster in the database
    if (adjuster != null) {
      if (database.passwordVerification(adjuster, 3)) {   //Password Verificatio of the Adjuster
        adjusterPortalDisplay(adjuster);
        adjusterMainMenu(adjuster, count, database);            //Adjuster Main Menu
        return;
      } else {
        Management.mainFunction(database);
        return;
      }
    } else {
      if (count > 0) {
        System.out.println("\t\tYou have entered an invalid Adjuster Username\n\n\t\tIf you want to exit\t\t\t\t\t\t Press 1\n\t\tIf you want to enter your Adjuster Username again\t\t press 2 ");
        int t = sc.nextInt();
        if (t == 1) {
          Management.mainFunction(database);
          return;
        } else {
          loginDisplay("Adjuster");
          Agent(database, count -= 1);
          return;
        }
      } else {
        int t = 3;
        while (t > 0) {
          System.out.print("\033[H\033[2J");
          System.out.print(
              "\t\tIncorrect Adjuster Username entered many times\n\t\tThe Screen will return to Main Menu in \' " + t
                  + " \' sec\n\t\t\t\t.");
          timeOut(300);       //For delaying the program
          t--;
        }
        mainFunction(database);
        return;
      }
    }
  }

  //Main Display Of Inusrance Page made static so that it can be called without object Creation
  static void welcomeDisplay() {
    // System.out.print("\033[H\033[2J");
    System.out.println(
        "\t\tWelcome to IIT INSURANCE\n\n\tThorugh which account type you want to enter : \n\t\tCustomer \tPress 1\n\t\tAgent\t\tPress 2\n\t\tAdjuster\tPress 3\n\t\tReport\t\tPress 4");
  }
  
  //Login Display made static so that it can be called without object Creation
  static void loginDisplay(String name) {
    System.out.print("\t\tWelcome to IIT INSURANCE\n\n\t\tEnter your " + name + " Username : ");
  }
  
  //Customer Portal made static so that it can be called without object Creation
  static void customerPortalDisplay(Customer customer, Database database) throws InterruptedException {
    System.out.println("\t\tIIT INSURANCE\n\n\tWelcome " + customer.getName()+ "\n\tWhat do you want to do : \n\t\tDisplay Policies\t\tPress 1\n\t\tDisplay Claims\t\t\tPress 2\n\t\tCreate a new Claim\t\tPress 3\n\t\tLogout\t\t\t\tPress 4");
    Management.customerMainMenu(customer, 2, database);
  }

  //Agent Portal made static so that it can be called without object Creation
  static void agentPortalDisplay(Agent agent) {
  System.out.println("\t\tIIT INSURANCE\n\n\tWelcome Agent " + agent.getName()+ "\n\tWhat do you want to do : \n\t\tCreate a new Policy\t\tPress 1\n\t\tUpdate a Policy\t\t\tPress 2\n\t\tLogout\t\t\t\tPress 3");
  }

  //Adjuster Portal made static so that it can be called without object Creation
  static void adjusterPortalDisplay(Adjuster adjuster) {
    System.out.println("\t\tIIT INSURANCE\n\n\tWelcome Adjuster " + adjuster.getName()+ "\n\tWhat do you want to do : \n\t\tProcess Claims\t\t\tPress 1\n\t\tLogout\t\t\t\tPress 2");
  }

  //This is the Main Fuction which is called in the Main Class
  public void mainFunction(Database database) throws InterruptedException {
    welcomeDisplay();
    int t = sc.nextInt();
    if (t == 1) {
      loginDisplay("Customer");
      Customer(2, database);
    }
    if (t == 2) {
      loginDisplay("Agent");
      Agent(database, 2);
    }
    if (t == 3) {
      loginDisplay("Adjuster");
      Adjuster(database, 2);
    }
    if (t == 4) {
      database.printFinancialSummary();
      mainFunction(database);
    }
  }
}

/*
 * Pre Defined : Customers username : ak11        password : akilesh
 *                         username : mo11        password : mokshith
 *                         username : so11        password : sonith
 *                         username : sh11        password : shivadarshan
 * 
 * Pre Defined : Agents    username : agent       password : agent
 * 
 * Pre Defined : Adjusters username : ra11        password : ram
 * 
 * 
 */

import InsuranceManagement.*;
import java.util.*;

public class Main {

  static Scanner sc = new Scanner(System.in);

  // Predefined Users for Test case, we used static keyword just to add test data
  // not used any more than that!
  static void preDefined(Database database) {
    Customer customer1 = new Customer("Akilesh", "1234567899", "ak@gmaill.com", "India", "ak11", "akilesh");
    Customer customer2 = new Customer("Mokshith", "1230567899", "mo@gmaill.com", "India", "mo11", "mokshith");
    Customer customer3 = new Customer("Sonith", "1234547899", "so@gmaill.com", "India", "so11", "sonith");
    Customer customer4 = new Customer("Shivadarshan", "2234567899", "sh@gmaill.com", "India", "sh11", "shivadarshan");
    Customer customer5 = new Customer("Sasaank", "1234767899", "sa@gmaill.com", "India", "sa11", "sasaank");
    database.addCustomer(customer1);
    database.addCustomer(customer2);
    database.addCustomer(customer3);
    database.addCustomer(customer4);
    database.addCustomer(customer5);
    Agent agent = new Agent("A", "123", "agent", "agent", database);
    database.addAgent(agent);
    agent.createNewPolicy(customer1, database);
    agent.createNewPolicy(customer2, database);
    agent.createNewPolicy(customer3, database);
    agent.createNewPolicy(customer4, database);
    agent.createNewPolicy(customer5, database);
    Adjuster adjuster = new Adjuster("Ram", "11223344", "ra11", "ram", database);
    database.addAdjuster(adjuster);
  }

  public static void main(String[] args) throws InterruptedException {
    Database database = new Database();
    ArrayList<Customer> customer = new ArrayList<Customer>();
    ArrayList<Agent> agent = new ArrayList<Agent>();
    ArrayList<Adjuster> adjuster = new ArrayList<Adjuster>();

    preDefined(database);
    InsuranceManagement insuranceManagement = new InsuranceManagement();
    insuranceManagement.mainFunction(database);
  }
}

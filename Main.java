import java.util.*;

public class Main {

  static Scanner sc = new Scanner(System.in);

    // Predefined Users for Test case
    static void preDefined(Database Db) {
        Customer c1 = new Customer("Akilesh", "1234567899", "ak@gmaill.com","India", "ak11", "akilesh");
        Customer c2 = new Customer("Mokshith", "1230567899", "mo@gmaill.com","India", "mo11", "mokshith");
        Customer c3 = new Customer("Sonith", "1234547899", "so@gmaill.com","India", "so11", "sonith");
        Customer c4 = new Customer("Shivadarshan", "2234567899", "sh@gmaill.com","India", "sh11", "shivadarshan");
        Customer c5 = new Customer("Sasaank", "1234767899", "sa@gmaill.com","India" ,"sa11", "sasaank");
        Db.addCustomer(c1);
        Db.addCustomer(c2);
        Db.addCustomer(c3);
        Db.addCustomer(c4);
        Db.addCustomer(c5);
       Agent agent=new Agent("A", "123", "agent", "agent", Db);
       Db.addAgent(agent);
       agent.createNewPolicy(c1,Db);
       agent.createNewPolicy(c2,Db);
       agent.createNewPolicy(c3,Db);
       agent.createNewPolicy(c4,Db);
       agent.createNewPolicy(c5,Db);
    }


    public static void main(String[] args) throws InterruptedException {
        Database Db=new Database();
        ArrayList<Customer> Cu = new ArrayList<Customer>();
        ArrayList<Agent> Ag = new ArrayList<Agent>();
        ArrayList<Adjuster> Ad = new ArrayList<Adjuster>();
        
        preDefined(Db);
        InsuranceManagement Im=new InsuranceManagement();
        Im.mainFunction(Db);
        //System.out.println(Cu.ge);
    }
}

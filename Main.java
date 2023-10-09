import java.util.*;

public class Main {

  static Scanner sc = new Scanner(System.in);

    // Predefined Users for Test case
    static void preDefined(Database Db) {
        Db.addCustomer(new Customer("Akilesh", "1234567899", "ak@gmaill.com","India", "ak11", "akilesh"));
        Db.addCustomer(new Customer("Mokshith", "1230567899", "mo@gmaill.com","India", "mo11", "mokshith"));
        Db.addCustomer(new Customer("Sonith", "1234547899", "so@gmaill.com","India", "so11", "sonith"));
        Db.addCustomer(new Customer("Shivadarshan", "2234567899", "sh@gmaill.com","India", "sh11", "shivadarshan"));
        Db.addCustomer(new Customer("Sasaank", "1234767899", "sa@gmaill.com","India" ,"sa11", "sasaank"));
        
    }

    public static void main(String[] args) throws InterruptedException {
        Database Db=new Database();
        /*ArrayList<Customer> Cu = new ArrayList<Customer>();
        ArrayList<Agent> Ag = new ArrayList<Agent>();
        ArrayList<Adjuster> Ad = new ArrayList<Adjuster>();*/
        
        preDefined(Db);
        InsuranceManagement Im=new InsuranceManagement();
        Im.mainFunction(Db);
    }
}

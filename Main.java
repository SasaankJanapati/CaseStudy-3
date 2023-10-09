import java.util.*;

public class Main{
    static Scanner sc=new Scanner(System.in);

    // Predefined Users for Test case
    static void preDefined(ArrayList<Customer> Cu) {
        Cu.add(new Customer("Akilesh", "1234567899", "ak@gmaill.com","India", "ak11", "akilesh"));
        Cu.add(new Customer("Mokshith", "1230567899", "mo@gmaill.com","India", "mo11", "mokshith"));
        Cu.add(new Customer("Sonith", "1234547899", "so@gmaill.com","India", "so11", "sonith"));
        Cu.add(new Customer("Shivadarshan", "2234567899", "sh@gmaill.com","India", "sh11", "shivadarshan"));
        Cu.add(new Customer("Sasaank", "1234767899", "sa@gmaill.com","India" ,"sa11", "sasaank"));
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Customer> Cu = new ArrayList<Customer>();
        ArrayList<Agent> Ag = new ArrayList<Agent>();
        ArrayList<Adjuster> Ad = new ArrayList<Adjuster>();
        InsuranceManagement Im=new InsuranceManagement();
        System.out.println("Hi");
        preDefined(Cu);
        Im.mainFunction(Cu,Ag,Ad);
        //System.out.println(Cu.ge);
    }
}
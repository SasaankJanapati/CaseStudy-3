import java.util.*;
import java.util.concurrent.atomic.AtomicMarkableReference;

class Main {
    static Scanner sc = new Scanner(System.in);

    static void preDefined(ArrayList<Customer> Cu) {
        Cu.add(new Customer("Akilesh", "1234567899", "ak@gmaill.com", "ak11", "akilesh"));
        Cu.add(new Customer("Mokshith", "1230567899", "mo@gmaill.com", "mo11", "mokshith"));
        Cu.add(new Customer("Sonith", "1234547899", "so@gmaill.com", "so11", "sonith"));
        Cu.add(new Customer("Shivadarshan", "2234567899", "sh@gmaill.com", "sh11", "shivadarshan"));
        Cu.add(new Customer("Sasaank", "1234767899", "sa@gmaill.com", "sa11", "sasaank"));
    }

    static void mainFunction(int t, ArrayList<Customer> Cu) {
        if (t == 1) {
            System.out.print("\t\t\tIIT INSURANCE\n\n\t\tWelcome to Costumer Info Portal\n\t\tEnter your username : ");
            String s = sc.next();
            for (Customer c : Cu) {
                if (c.getUserName().equals(s)) {
                    String u = s;
                    System.out.println("\t\tCustomer Username : " + u);
                    System.out.print("\t\tEnter your password : ");
                    s = sc.next();
                    if (c.getPassword().equals(s)) {
                        System.out.println("\t\tWelcome " + c.getName());
                    } else {
                        System.out.println("\t\tYou have entered wrong password");
                    }
                } else {
                    System.out.println("\t\tYou have entered wrong Customer username");
                    mainFunction(t, Cu);
                    return;
                }
            }
        } else if (t == 2) {
            System.out.print("\t\t\tIIT INSURANCE\n\n\t\tWelcome to Agent Info Portal\n\t\tEnter your username : ");
            String s = sc.next();
            for (Customer c : Cu) {
                if (c.getUserName().equals(s)) {
                    String u = s;
                    System.out.println("\t\tAgent Username : " + u);
                    System.out.print("\t\tEnter your password : ");
                    s = sc.next();
                    if (c.getPassword().equals(s)) {
                        System.out.println("\t\tWelcome Agent " + c.getName());
                    } else {
                        System.out.println("\t\tYou have entered wrong password");
                    }
                } else {
                    System.out.println("\t\tYou have entered wrong Agent username");
                    mainFunction(t, Cu);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Customer> Cu = new ArrayList<Customer>();
        ArrayList<Agent> Ag = new ArrayList<Agent>();
        preDefined(Cu);
        String s = "";
        System.out.println("\t\tWelcome to IIT INUSRANCE\n\t\tRole\n\t\tCustomer \tPress 1\n\t\tAgent\t\tPress 2");
        int t = sc.nextInt();
        mainFunction(t, Cu);

    }
}
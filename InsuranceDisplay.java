import java.util.*;

public class InsuranceDisplay {
    public void welcomeDisplay1(){
        System.out.print("\033[H\033[2J");
        System.out.println("\t\tWelcome to IIT INUSRANCE\n\n\t\tRole\n\t\tCustomer \tPress 1\n\t\tAgent\t\tPress 2");
    }
    public void customerDisplay(){
        System.out.print("\033[H\033[2J");
        System.out.print("\t\t\tIIT INSURANCE\n\n\t\tWelcome to Costumer Info Portal\n\n\t\tEnter your username : ");
    }
}

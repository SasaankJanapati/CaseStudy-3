import java.util.*;
import java.util.concurrent.atomic.AtomicMarkableReference;

class Main {

    /*
     * static void preDefined(Customer[] Cu) {
     * Cu[0]=new Customer("Akilesh", "1234567899", "ak@gmaill.com","ak11",
     * "akilesh");
     * Cu[1]=new Customer("Mokshith", "1230567899", "mo@gmaill.com","mo11",
     * "mokshith");
     * Cu[2]=new Customer("Sonith", "1234547899", "so@gmaill.com","so11", "sonith");
     * Cu[3]=new Customer("Shivadarshan", "2234567899", "sh@gmaill.com","sh11",
     * "shivadarshan");
     * Cu[4]=new Customer("Sasaank", "1234767899", "sa@gmaill.com","sa11",
     * "sasaank");
     * }
     */

    public static void main(String[] args) {
        Customer[] Cu = new Customer[10];
        Agent[] Ag = new Agent[2];
        for (int i = 0; i < 10; i++) {
            Cu[i] = new Customer();
        }
        Cu[1].setPhoneNumber("12345");
        // preDefined(Cu);
        System.out.println(Cu[1].getPhoneNumber());
    }
}
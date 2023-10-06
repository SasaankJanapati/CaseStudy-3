import java.util.*;
public class Database {
    private ArrayList<Customer> customers;
    private ArrayList<Policy> policies;
    private ArrayList<Claim> claims;

    protected void addPolicy(Policy policy){
        policies.add(policy);
    }
    protected void addCustomer(Customer customer){
        customers.add(customer);
    }

    protected Customer searchCustomer(String name){
        for (Customer customer : customers) {
            if(customer.getName().compareTo(name) == 0){
                return customer;
            }
        }
        return null;
    }
}

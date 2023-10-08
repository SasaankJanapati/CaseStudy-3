public class Agent extends Database {
    private String name;
    private String id;
    private String phoneNumber;

    Agent(String name, String id, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    protected void createNewPolicy() {
        Customer customer = new Customer();
        Policy policy = new Policy();
        customer.addPolicy(policy);
        this.addPolicy(policy);
    }

    protected void createNewPolicy(String name) {
        Customer customer = this.searchCustomer(name);
        if (customer == null) {
            System.out.println("Customer not found");
        } else {
            Policy policy = new Policy();
            customer.addPolicy(policy);
            this.addPolicy(policy);
        }
    }

    protected void createNewClaim(Claim claim) {
        this.addClaim(claim);
    }
}

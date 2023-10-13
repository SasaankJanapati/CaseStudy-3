package InsuranceManagement;

public class CustomerNotFoundException extends Exception {
    CustomerNotFoundException(){
        super("Customer Does not exist");
    }
}

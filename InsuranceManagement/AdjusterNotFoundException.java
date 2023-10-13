package InsuranceManagement;

public class AdjusterNotFoundException extends Exception {
    AdjusterNotFoundException(){
        super("Adjuster not found");
    }
}

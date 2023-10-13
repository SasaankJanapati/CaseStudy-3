public class ClaimNotFoundException extends Exception{
    ClaimNotFoundException(){
        super("No such claim exists with the given id");
    }
}

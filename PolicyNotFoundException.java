public class PolicyNotFoundException extends Exception{
    PolicyNotFoundException(){
        super("No such policy exists with the given id");
    }
}

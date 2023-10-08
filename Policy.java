import java.util.*;

public class Policy {
    private boolean isActive;
    private boolean isLapsed;
    private String type;
    private String id;
    private double premiumAmount;
    private double coverage;
    private double period;

    Policy(){
        this.isActive = true;
        this.isLapsed = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type");
        this.type = sc.next();
        System.out.println("Enter the type");
        this.id = UUID.randomUUID().toString().substring(0, 7);
        System.out.println("Enter the type");
        this.premiumAmount = sc.nextDouble();
        System.out.println("Enter the type");
        this.coverage = sc.nextDouble();
        System.out.println("Enter the type");
        this.period = sc.nextDouble();
    }

    protected String getId() {
        return id;
    }
}

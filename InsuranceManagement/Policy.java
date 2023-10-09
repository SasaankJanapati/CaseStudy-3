package InsuranceManagement;
import java.util.*;

public class Policy {
//private attributes of a policy
    private boolean isActive;
    private String lapseDate;
    private String type;
    private String id;
    private double premiumAmount;
    private double coverage;
    private double period;
//A parameterized constructor to pre define some policies
    Policy(boolean isActive,String lapseDate,String type,double premiumAmount,double coverage,double period){
        this.isActive=isActive;
        this.lapseDate=lapseDate;
        this.type=type;
        this.id = UUID.randomUUID().toString().substring(0, 7);
        this.premiumAmount=premiumAmount;
        this.coverage=coverage;
        this.period=period;
        this.premiumAmount=premiumAmount;
    }
//A non-parameterized constructor to create a new policy
    Policy(){
        this.isActive = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type");
        this.type = sc.next();
        this.id = UUID.randomUUID().toString().substring(0, 7);
        System.out.println("Enter the premiun amount");
        this.premiumAmount = sc.nextDouble();
        System.out.println("Enter the coverage");
        this.coverage = sc.nextDouble();
        System.out.println("Enter the period");
        this.period = sc.nextDouble();
    }
//Getters and Setters
    protected String getId() {
        return id;
    }
    protected void setCoverage(double coverage) {
        this.coverage = coverage;
    }
    protected boolean getIsActive(){
        return this.isActive;
    }
    protected void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    protected String getLapseDate() {
        return lapseDate;
    }
    protected void setLapseDate(String lapseDate) {
        this.lapseDate = lapseDate;
    }
    public double getPremiumAmount() {
        return premiumAmount;
    }
//The following method displays the policy
    protected void displayPolicy(){
        System.out.println("Policy Active : "+this.isActive);
        System.out.println("Policy Type : "+this.type);
        System.out.println("Premium Amount : "+this.premiumAmount);
        System.out.println("Lapse Date: "+this.lapseDate);
        System.out.println("Coverage : "+this.coverage);
        System.out.println("Policy Peroid : "+this.period);
    }
    
}

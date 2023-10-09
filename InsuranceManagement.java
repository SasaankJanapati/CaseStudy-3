import java.util.*;

public class InsuranceManagement extends Database{

    Database Db=new Database();
    static Scanner sc=new Scanner(System.in);
    

    //Initial Display
    static void welcomeDisplay(){
        System.out.print("\033[H\033[2J");
        System.out.println("\t\tWelcome to IIT INUSRANCE\n\n\tThorugh which account type you want to enter : \n\t\tCustomer \tPress 1\n\t\tAgent\t\tPress 2\n\t\tAdjuster\tPress 3");
    }
    static void LoginDisplay(String name){
        System.out.print("\033[H\033[2J");
        System.out.print("\t\tWelcome to IIT INUSRANCE\n\n\t\tEnter your "+name+" Username : ");
    }
    static void customerPortalDisplay(Customer Cu){
        System.out.print("\033[H\033[2J");
        System.out.println("\t\tIIT INUSRANCE\n\n\tWelcome "+Cu.getName()+"\n\tWhat do you want to do : \n\t\tCreate a new Claim\t\tPress 1\n\t\tDisplay Claims\t\t\tPress 2\n\t\tDisplay Policies\t\tPress 3\n\t\tLogout\t\t\t\tPress 4");
    }
    static void agentPortalDisplay(Agent Ag){
        System.out.print("\033[H\033[2J");
        System.out.println("\t\tIIT INUSRANCE\n\n\tWelcome Agent "+Ag.getName()+"\n\tWhat do you want to do : \n\t\tCreate a new Claim\t\tPress 1\n\t\tCreate a new Policy\t\t\tPress 2\n\t\tUpdate a Policy\t\tPress 3\n\t\tLogout\t\t\t\tPress 4");
    }

    private void Customer(ArrayList<Customer> Cu,ArrayList<Agent> Ag,ArrayList<Adjuster> Ad,int count) throws InterruptedException{
        String s=sc.next();
        Customer customer=this.searchCustomer(s,Cu);
        if(customer!=null){
            if(this.passwordVerification(customer, 3)){
                customerPortalDisplay(customer);
                int t=sc.nextInt();
                switch(t){
                    case 1:
                        customer.createNewClaim();
                        break;
                    case 2:
                        customer.displayClaims();
                        break;
                    case 3:
                        customer.displayPolicies();
                        break;
                    case 4:
                        mainFunction(Cu,Ag,Ad);
                        break;
                }
            }else{
                mainFunction(Cu,Ag,Ad);
                return;
            }
        }else{
            if(count>0){
                System.out.println("\t\tYou have entered an invalid Customer Username\n\n\t\tIf you want to exit\t\t\t\t\t\t Press 1\n\t\tIf you want to enter your Customer Username again\t\t press 2 ");
                int t=sc.nextInt();
                if(t==1){mainFunction(Cu, Ag, Ad);return;}
                else{LoginDisplay("Customer");
                    Customer(Cu,Ag,Ad,count-=1);return;}
            }else{
                int t=3;
                while(t>0){
                    System.out.print("\033[H\033[2J");
                    System.out.print("\t\tIncorrect Customer Username entered many times\n\t\tThe Screen will return to Main Menu in \' "+t+" \' sec\n\t\t\t\t.");
                    timeOut(300);
                    t--;
                }
                mainFunction(Cu, Ag, Ad);
                return;
            }
        }
    }

    private void Agent(ArrayList<Customer> Cu,ArrayList<Agent> Ag,ArrayList<Adjuster> Ad,int count) throws InterruptedException{
       String name=sc.next();
        Agent agent=searchAgent(name,Ag);
        if(agent!=null){
            if(this.passwordVerification(agent, 3)){
                agentPortalDisplay(agent);
                int t=sc.nextInt();
                switch(t){
                    case 1:
                        //agent.createNewClaim();
                        break;
                    case 2:
                        agent.createNewPolicy();
                        break;
                    case 3:
                        agent.updatePolicy();
                        break;
                    case 4:
                        mainFunction(Cu,Ag,Ad);
                        break;
                }
            }else{
                mainFunction(Cu,Ag,Ad);
                return;
            }
        }else{
            if(count>0){
                System.out.println("\t\tYou have entered an invalid Agent Username\n\n\t\tIf you want to exit\t\t\t\t\t\t Press 1\n\t\tIf you want to enter your Customer Username again\t\t press 2 ");
                int t=sc.nextInt();
                if(t==1){mainFunction(Cu, Ag, Ad);return;}
                else{LoginDisplay("Agent");
                    Agent(Cu,Ag,Ad,count-=1);return;}
            }else{
                int t=3;
                while(t>0){
                    System.out.print("\033[H\033[2J");
                    System.out.print("\t\tIncorrect Agent Username entered many times\n\t\tThe Screen will return to Main Menu in \' "+t+" \' sec\n\t\t\t\t.");
                    timeOut(300);
                    t--;
                }
                mainFunction(Cu, Ag, Ad);
                return;
            }
        }
    }

    public void mainFunction(ArrayList<Customer> Cu,ArrayList<Agent> Ag,ArrayList<Adjuster> Ad) throws InterruptedException{
        welcomeDisplay();
        int t=sc.nextInt();
        if(t==1){
            LoginDisplay("Customer");
            Customer(Cu,Ag,Ad,2);
        }
        if(t==2){
            LoginDisplay("Agent");
            Agent(Cu,Ag,Ad,2);
        }
    }

}

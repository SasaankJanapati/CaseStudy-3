package InsuranceManagement;
//Report is an abstract class which is extended by the Database class
/*
It has three main methods
Displaying the Policies
Displaying the Claims
Displaying the financial summaries
*/
abstract class Report{
    abstract void displayPolicyReport();
    abstract void displayClaimReport();
    abstract void financialSummaryAdder(String transaction);
}
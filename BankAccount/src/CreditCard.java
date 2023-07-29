public class CreditCard extends Card implements Transactions {
    private double creditLimit;
    private double interestRate;

    CreditCard(int startYear, int endYear, Owner owner, double creditLimit, double interestRate){
        super(startYear, endYear, owner);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.owner = owner;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double Cash) {
        if(Cash > 0) {
            System.out.println("Total Balance:" + (creditLimit = creditLimit + Cash));
        }else{
            System.out.println("Amount For Deposit Must Be > 0");
        }
    }

    @Override
    public void withdraw(double Cash) {
        if(Cash <= creditLimit){
            System.out.println("Total Balance After Withdraw is: " + (creditLimit -= Cash + interestRate));
        }else{
            System.out.println("Transaction failure: Not Enough Cash...");
        }
    }

    @Override
    public void purchase(double Purchase) {
        if(creditLimit >= Purchase){
            System.out.println("Total Balance After Purchase:" + (creditLimit -= Purchase + interestRate ));
        }else{
            System.out.println("Transaction failure: Not Enough Cash...");
        }
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "StartYear=" + getStartYear() +
                ", EndYear=" + getEndYear() +
                ", creditLimit=" + creditLimit +
                ", interestRate=" + interestRate +
                ", " + owner +
                '}';
    }
}

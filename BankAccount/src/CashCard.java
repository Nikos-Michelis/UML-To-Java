public class CashCard extends Card implements Transactions {
    private double withDrawLimit;
    private double purchaseLimit;
    private double balance;

    CashCard(int startYear, int endYear, Owner owner, double withDrawLimit, double purchaseLimit, double balance){
        super(startYear, endYear, owner);
        this.withDrawLimit = withDrawLimit;
        this.purchaseLimit = purchaseLimit;
        this.balance = balance;
        this.owner = owner;//init owner object inside to constructor
    }

    public double getWithDrawLimit() {
        return withDrawLimit;
    }

    public void setWithDrawLimit(double withDrawLimit) {
        this.withDrawLimit = withDrawLimit;
    }

    public double getPurchaseLimit() {
        return purchaseLimit;
    }

    public void setPurchaseLimit(double purchaseLimit) {
        this.purchaseLimit = purchaseLimit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double Cash) {
        if(Cash > 0) {
            System.out.println("Total Balance:" + (balance = balance + Cash));
        }else{
            System.out.println("Amount For Deposit Must Be > 0");
        }
    }

    @Override
    public void withdraw(double Cash) {
        if(balance >= Cash && Cash <= withDrawLimit){
            System.out.println("Total Balance After Withdraw is: " + (balance = balance - Cash) + " And Withdraw limit for your Card is: " + (withDrawLimit = withDrawLimit - Cash));
        }else{
            System.out.println("Transaction failure: Not Enough Cash for withdraw or you have exceeded the withdraw Limit...");
        }
    }

    @Override
    public void purchase(double Purchase) {
        if(balance >= Purchase && Purchase <= purchaseLimit){
            System.out.println("Total Balance After Purchase:" + (balance = balance - Purchase) + " And Purchase limit for your Card is: " + (purchaseLimit = purchaseLimit - Purchase));
        }else{
            System.out.println("Transaction failure: Not Enough Cash for payment or you have exceeded the purchase limit...");
        }
    }

    @Override
    public String toString() {
        return "CashCard{" +
                "StartYear=" + getStartYear() +
                ", EndYear=" + getEndYear() +
                ", withDrawLimit=" + withDrawLimit +
                ", purchaseLimit=" + purchaseLimit +
                ", balance=" + balance +
                "," + owner +
                '}';
    }
}

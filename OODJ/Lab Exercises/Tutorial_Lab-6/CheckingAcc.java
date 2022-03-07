public class CheckingAcc extends Accounts {
    public double overdraftLimit;

    public CheckingAcc(int acno, double bal, double rate, double limit) {
        super(acno, bal, rate);
        overdraftLimit = limit;
    }

    public void withdraw(double amount) {
        double bal;
        bal = getBalance();
        if ((amount > bal)  && (amount - bal) <= overdraftLimit || (amount < bal)){
            super.withdraw(amount);
            System.out.println("Withdraw Allowed......");
        }
        else {
            System.out.println("Withdraw NOt allowed!");
        }
    }
}
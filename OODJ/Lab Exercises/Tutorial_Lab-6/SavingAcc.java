/**
 * SavingAcc
 */
public class SavingAcc extends Accounts{

    public SavingAcc(int acno, double bal, double rate) {
        super(acno, bal, rate);
    }

    public void withdraw(double amount){
        if (amount <= getBalance()) {
            super.withdraw(amount);            
        }
        else {
            System.out.println("Withdraw NOT Allowed!");
        }
    }
}
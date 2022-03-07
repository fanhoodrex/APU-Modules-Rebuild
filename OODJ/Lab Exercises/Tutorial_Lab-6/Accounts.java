public class Accounts {
    private int accountNumber;
    private double balance, annualInterestRate;

    Accounts(int acno, double bal, double rate){ //Constructor
        accountNumber = acno;
        balance = bal;
        annualInterestRate = rate;
    }
    public void deposit(double amount){
        balance = balance + amount;
    }

    public void withdraw(double amount){
        balance = balance - amount;
    }

    public double getBalance() {
        return balance;
    }
}
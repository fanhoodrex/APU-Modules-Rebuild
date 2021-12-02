import java.util.Scanner;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account() {
        this.id = 1222;
        this.balance = 20000;
        this.annualInterestRate = 0.045;
    }

    // get method
    public int getID() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    // set method
    public void setId() {
        this.id = id;
    }

    public void setBalance(double bal) {
        this.balance = bal;
    }

    public void setAnnualInterestRate(double rate) {
        this.annualInterestRate = rate;
    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate/12;
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Amount is successfully withdrawn.");
        } else {
            System.out.println("Sorry, not enough balance...");  
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account acc1 = new Account();
        acc1.setId(1222);
        System.out.println("This ID is " + acc1.getID());
    }
}
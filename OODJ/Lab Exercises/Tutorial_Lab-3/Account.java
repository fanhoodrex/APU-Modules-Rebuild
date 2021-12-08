public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double bal, double rate) { // Constructor
        this.id = id;
        this.balance = bal;
        this.annualInterestRate = rate;
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
    public void setId(int id) {
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
    /*
    1.	Write a class named Account to model accounts. Write a test program to test the Account class.
    In the client program, create an Account object with an account ID of 1222, a balance of 20000, and an annual interest rate of 4.5%.
    Use the withdraw method to withdraw $2500, use the deposit method to deposit $3000, and print the balance and the monthly interest. 
    */
    public static void main(String[] args) {
        Account acc = new Account(1222,20000,0.045);
        System.out.println("id:" + acc.getID() + " Balance:" + acc.getBalance() + " Annual Interest Rate:" + acc.getAnnualInterestRate());
        System.out.println("After withdrawal...");
        acc.withdraw(2500);
        System.out.println("id:" + acc.getID() + " Balance:" + acc.getBalance() + " Annual Interest Rate:" + acc.getAnnualInterestRate());
        System.out.println("After Deposit...");
        acc.deposit(3000);
        System.out.println("id:" + acc.getID() + " Balance:" + acc.getBalance() + " Annual Interest Rate:" + acc.getAnnualInterestRate());
    }
}
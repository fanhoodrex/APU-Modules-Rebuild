public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account() {
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
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

    public static void main(String[] args) {
        Account acc = new Account();
        System.out.println("id:" + acc.getID() + " Balance:" + acc.getBalance() + " Annual Interest Rate:" + acc.getAnnualInterestRate());
        acc.setId(1222);
        acc.setBalance(20000);
        acc.setAnnualInterestRate(0.045);
        System.out.println("id:" + acc.getID() + " Balance:" + acc.getBalance() + " Annual Interest Rate:" + acc.getAnnualInterestRate());
        System.out.println("After withdrawal...");
        acc.withdraw(2500);
        System.out.println("id:" + acc.getID() + " Balance:" + acc.getBalance() + " Annual Interest Rate:" + acc.getAnnualInterestRate());
        System.out.println("After Deposit...");
        acc.deposit(3000);
        System.out.println("id:" + acc.getID() + " Balance:" + acc.getBalance() + " Annual Interest Rate:" + acc.getAnnualInterestRate());
    }
}
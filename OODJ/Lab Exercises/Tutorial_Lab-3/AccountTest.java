public class AccountTest {
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
public class testAccounts {
    public static void main(String[] args) {
        CheckingAcc cAcc = new CheckingAcc(100, 1000, 10, 50);
        cAcc.withdraw(1050);
        SavingAcc sAcc = new SavingAcc(101,1000,10);
        sAcc.withdraw(1001);
    }
}
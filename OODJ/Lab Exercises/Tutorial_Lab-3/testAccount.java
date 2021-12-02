import java.util.Scanner;

public class testAccount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account acc1 = new Account();
        acc1.setId(1222);
        System.out.println("This ID is " + acc1.getID());
}
import java.util.Scanner;

public class Exercise11 {
    /*
    11.	Write a program that reads in investment amount, annual interest rate, and number of years, and displays the future investment value using the following formula.
    futureInvestmentVal = investmentAmount x (1 + monthlyInterestRate) numberOfYears*12
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ans = "Yes";
        do {
            System.out.print("Do u want to continue (Yes/No):");
            ans = input.nextLine();
        } while (ans.equals("Yes"));
    }
}
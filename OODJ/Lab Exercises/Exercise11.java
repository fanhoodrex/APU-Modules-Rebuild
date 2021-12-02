import java.util.Scanner;

public class Exercise11 {
    /*
    11.	Write a program that reads in investment amount, annual interest rate, and number of years, and displays the future investment value using the following formula.
    futureInvestmentVal = investmentAmount x (1 + monthlyInterestRate) x numberOfYears*12
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double investmentAmount = input.nextFloat();
        System.out.print("Enter annual interest rate: ");
        double annualInterestRate = input.nextFloat();
        System.out.print("Enter number of years: ");
        int numberOfYears = input.nextInt();

        double futureInvestmentVal = investmentAmount * Math.pow(1 + annualInterestRate / 12, numberOfYears);
        futureInvestmentVal = Math.round(futureInvestmentVal * 100) / 100;

        System.out.print("Future investment value is: " + futureInvestmentVal);
    }
}
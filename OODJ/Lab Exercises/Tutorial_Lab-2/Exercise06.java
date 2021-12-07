import java.util.Scanner;

public class Exercise06 {
    /*
    6.	Write a program that prompts the user to enter the month and year, and displays the number of days in the month.
    For example, January is 31 days, February is 28 days, March is 31 and etc.
    */
    public static void main(String[] args) {
        int days = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter month in number: ");
        int month = scan.nextInt();
        System.out.print("Enter year: ");
        int year = scan.nextInt();
        
        if (year % 400 == 0 || (year % 100 != 0 & year % 4 == 0)) { // if year is leap year
            System.out.println(year + " is leap year");
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                days = 31;
            }
            else if (month == 4 || month == 6 || month == 9 || month == 11) {
                days = 30;
            }
            else if (month == 2) {
                days = 29;
            } 
        } else { // if year is common year
            System.out.println(year + " is common year");
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                days = 31;
            }
            else if (month == 4 || month == 6 || month == 9 || month == 11) {
                days = 30;
            }
            else if (month == 2) {
                days = 28;
            } 
        }
        System.out.println("The number of days in the month is " + days);
    }
}
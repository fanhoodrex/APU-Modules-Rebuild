import java.util.Scanner;

public class Exercise03 {
    /*
    3.Write a program that reads an integer between 0 and 1000 and adds all the digits in the integer.
    For example, if an integer is 943, the sum of all its digit is 16.
    */
    public static void main(String[] args) {
        int sum = 0;
        Scanner readObject = new Scanner(System.in);
        System.out.print("Please enter the integer between 0 and 1000:");
        int num = readObject.nextInt();
        while (num > 0){ // while loop to iterate and sum up the digits
            sum += num % 10;
            num = num / 10;
        }
        System.out.println("the sum of all its digit is " + sum);
    }
}
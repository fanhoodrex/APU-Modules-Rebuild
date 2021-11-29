import java.util.Scanner;

public class EXERCISE3 {
    /*
    3.Write a program that reads an integer between 0 and 1000 and adds all the digits in the integer.
    For example, if an integer is 943, the sum of all its digit is 16.

    use loop logic below to complete the exercise3 

    sum = 0
    num = 567
    while num > 0
        id = sum % 10
        sum += id
        num = num / 10
    */
    public static void main(String[] args) {
        Scanner readObject = new Scanner(System.in);
        System.out.print("Please enter the Fahrenheit value:");
        double Fahrenheit = readObject.nextDouble();
        double Celsius = Fahrenheit - 32 * 5 / 9;
        System.out.println("The Celsius value is " + Celsius);
    }
}

import java.util.Scanner;

public class EXERCISE1 {
    /*
    1.Write a program that reads a Fahrenheit degree in double, then converts it to Celsius and displays the result on the console. The formula for the conversion is as follows: 
    celsius = Fahrenheit – 32 * 5 / 9
    */
    public static void main(String[] args) {
        Scanner readObject = new Scanner(System.in);
        System.out.print("Please enter the Fahrenheit value:");
        double Fahrenheit = readObject.nextDouble();
        double Celsius = Fahrenheit - 32 * 5 / 9;
        System.out.println("The Celsius value is " + Celsius);
    }
}
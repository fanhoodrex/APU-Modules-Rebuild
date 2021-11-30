import java.util.Scanner;

public class EXERCISE5 {
    /*
    5.Write a program that receives an ASCII code (an integer between 0 and 128) and displays its character.
    For example, if the user enters 97, the program displays character ‘a’.
    */
    public static void main(String[] args) {
        Scanner readObject = new Scanner(System.in);
        System.out.print("Please enter an integer between 0 and 128:");
        int num = readObject.nextInt();
        char ASCII = (char) num; // Java Type Casting
        System.out.println("The ASCII code for " + num + " is " + ASCII);
    }
}

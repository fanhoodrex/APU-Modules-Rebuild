import java.util.Scanner;

public class Exercise4 {
    // 4.Write a program that converts an uppercase letter to a lowercase letter.
    public static void main(String[] args) {
        Scanner readObject = new Scanner(System.in);
        System.out.print("Please enter the uppercase letter:");
        String letter = readObject.nextLine();
        System.out.println("The lowercase letter: " + letter.toLowerCase());
    }
}

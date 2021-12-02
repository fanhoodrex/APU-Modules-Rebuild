import java.util.Scanner;

public class Exercise10 {
    /*
    10. Use do-while construct, write a program that prompts the users to continue the program execution.
    “Yes” to continue the program and “No” to terminate the program.
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
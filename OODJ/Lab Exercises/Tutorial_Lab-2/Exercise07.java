import java.util.Scanner;

public class Exercise07 {
    /*
    7. Write a program that prompts the user to enter assignment marks and displays the grade of the keyed in marks.
    The grading table is as follows:
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter assignment marks: ");
        int grade = scan.nextInt();
        if (grade > 0 &&  grade < 40) {
            System.out.println("F");
        } else if (grade > 41 &&  grade < 49) {
            System.out.println("F+");
        } else if (grade >= 50 &&  grade < 54) {
            System.out.println("D");
        } else if (grade >= 55 &&  grade < 64) {
            System.out.println("C");
        } else if (grade >= 65 &&  grade < 69) {
            System.out.println("B");
        } else if (grade >= 70 &&  grade < 74) {
            System.out.println("B+");
        } else if (grade >= 75 &&  grade < 79) {
            System.out.println("A");
        } else if (grade >= 80 &&  grade <= 100) {
            System.out.println("A+");
        }
    }
}

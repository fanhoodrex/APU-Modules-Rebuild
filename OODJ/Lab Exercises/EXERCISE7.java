import java.util.Scanner;

public class EXERCISE7 {
    /* 7.Write a program that prompts the user to enter assignment marks and displays the grade of the keyed in marks.*/
    public static void main(String[] args) {
        Scanner readObject = new Scanner(System.in);
        System.out.println("Pls enter the assignment marks");
        int marks = readObject.nextInt();
        if (0 < marks < 40) {
            System.out.println("F > Fail");
          }
          else if (41 < marks < 49) {
            System.out.println("F+ > Marginal Fail");
          } 
          else if (50 < marks < 54){
            System.out.println("D > Pass");
          }
          else if (55 < marks < 64){
            System.out.println("D+ > Pass");
          }
          else if (65 < marks < 69){
            System.out.println("B > Credit");
          }
          else if (70 < marks <74){
            System.out.println("B+ > Credit");
          }
          else if (75 < marks <79){
            System.out.println("A > Distinction");
          }
          else if (80 < marks < 100){
            System.out.println("A+ > Distinction");
          } else{
              System.out.println("invalid input");
          }
    }
}
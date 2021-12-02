import java.util.Scanner;

public class Exercise02 {
    /*
    2. Write a program that reads in the radius and length of a cylinder and computes volume using the following formulas:
    area = radius * radius * PI
    volume = area * length
    */
    public static void main(String[] args) {
        Scanner readObject = new Scanner(System.in);
        System.out.print("Please enter the Radius:");
        double Radius = readObject.nextDouble();
        System.out.print("Please enter the length:");
        double Length = readObject.nextDouble();
        double Area = 3.142 * Radius * Radius;
        double volume = Area * Length;
        System.out.println("The volume is " + volume);
    }
}
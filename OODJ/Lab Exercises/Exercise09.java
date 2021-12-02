public class EXERCISE9 {
    /*
    9. Suppose that the tuition of a university is RM10000 this year and this tuition fee increases 5% every year.
    Write a program that uses a loop to compute the tuition in ten years.
    */
    public static void main(String[] args) {
        float fee = 10000;
        for (int i = 1; i <= 10; i++) {
            fee *= 1.05;
        }
    System.out.println("Fees after 10 years would be " + Math.round(fee));
    }
}
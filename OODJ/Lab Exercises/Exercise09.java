public class EXERCISE9 {
    public static void main(String[] args) {
        float fee = 10000;
        for (int i = 1; i <= 10; i++) {
            fee *= 1.05;
        }
    System.out.println("Fees after 10 years would be " + Math.round(fee));
    }
}
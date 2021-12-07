public class Exercise08 {
    /*
    8. Write a program that sum up all the values in double typed of an array.
    The array capacity is 100. You are required to use for-each construct (enhanced for).
     */
    public static void main(String[] args) {
        double[] array = new double[100]; // array size of 100

        for (int i = 0; i < 100; i++) {
            array[i] = (double) Math.round(Math.random());// fill the array with 100 random number
        }

        double sum = 0;
        for (double element : array){ // for-each construct (enhanced for)
            sum += element;
        }

        System.out.println("Sum of all 100 double values is: " + Math.round(sum));
    }
}
public class testRectangle {
    /*
    Write a client program to test the class Rectangle. In the client program, create two Rectangle objects.
    Assign width 5 and height 50 each of the objects.
    Assign colour yellow. Display the properties of both objects and their areas.
     */
    public static void main(String[] args) {
        Rectangle rectg1 = new Rectangle(5,50,"Yellow");
        Rectangle rectg2 = new Rectangle(5,50,"Yellow");

        System.out.println(rectg1.getWidth());
        System.out.println(rectg1.getHeight());
        System.out.println(rectg1.getColor());
        System.out.println(rectg1.findArea());
        
        System.out.println(rectg2.getWidth());
        System.out.println(rectg2.getHeight());
        System.out.println(rectg2.getColor());
        System.out.println(rectg2.findArea());
    }
}

public class Rectangle {
    private double width;
    private double height;
    private static String color;
    
    public Rectangle(double width, double height, String color){
        this.width = width;
        this.height = height;
        Rectangle.color = color;
    }

    public double getwidth() {
        return this.width;
    }
    public void setWidth(double width) {
        this.width = width;        
    }

    public double getHeight() {
        return this.height; 
    }
    public void setHeight(double height){
        this.height = height;
    }

    public String getColor() {
        return Rectangle.color;
    }
    public void setColor(String color){
        Rectangle.color = color;
    }

    public double findArea() {
        return this.width * this.height;
    }
    public double findPerimeter() {
        return this.width * 2 + this.height * 2;
    }
    /*
    Write a client program to test the class Rectangle. In the client program, create two Rectangle objects.
    Assign width 5 and height 50 each of the objects. 
    Assign colour yellow. Display the properties of both objects and their areas.
     */
    public static void main(String[] args) {
        Rectangle rectg1 = new Rectangle(5,50,"Yellow");
        System.out.println("The width is: " + rectg1.getwidth());
        System.out.println("The height is: " + rectg1.getHeight());
        System.out.println("The color is: " + rectg1.getColor());
        System.out.println("The area is: " + rectg1.findArea());
    }
}
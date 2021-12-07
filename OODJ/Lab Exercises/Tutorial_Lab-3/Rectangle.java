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
}
public class Fan {
    public int speed;
    public double radius;
    public String color;
    public boolean on; 

    public Fan(int speed, double radius, String color, boolean trueFalse) {
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.on = trueFalse;
    }

    public void accessor() {
        
    }
    /*
    Write a client program to test the Fan class. In the client program, create a Fan object.
    Assign maximum speed, radius 10, color yellow, and turn it on. Display the object by invoking its toString object.
    */
    public static void main(String[] args) {
        Fan fanObj = new Fan(3,10,"Yellow",true);
        // Display the object by invoking its toString object.
    }
}

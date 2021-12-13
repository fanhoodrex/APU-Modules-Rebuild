import java.util.GregorianCalendar;

public class Time {
    private final int hour;
    private final int minute;
    private final int second;

    public Time(){
        GregorianCalendar calendar = new GregorianCalendar();
        this.hour = calendar.get(GregorianCalendar.HOUR);
        this.minute = calendar.get(GregorianCalendar.MINUTE);
        this.second = calendar.get(GregorianCalendar.SECOND);
    }
    public int getHour() { return this.hour; }
    public int getMinute() { return this.minute; }
    public int getSecond() { return this.second; }
    
    /*
    Write a client program to test the Time class.
    In the client program, create a Time object and display hour, minute and second using the get methods.
    */
    public static void main(String[] args) {
        Time now = new Time();
        System.out.println("Current hour:" + now.getHour());
        System.out.println("Current minute:" + now.getMinute());
        System.out.println("Current second:" + now.getSecond());
    }
}
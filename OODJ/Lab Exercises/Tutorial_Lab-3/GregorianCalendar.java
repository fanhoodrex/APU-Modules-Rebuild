import java.util.GregorianCalendar;

public class GregorianCalendar {
    /*
    Write a program to test GregorianCalendar class to display the current year, month and day.
     */
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        System.out.println("Current Year:" + calendar.get(GregorianCalendar.YEAR));
        System.out.println("Current Month:" + calendar.get(GregorianCalendar.MONTH));
        System.out.println("Current Month:" + calendar.get(GregorianCalendar.DAY_OF_MONTH));
    }
}
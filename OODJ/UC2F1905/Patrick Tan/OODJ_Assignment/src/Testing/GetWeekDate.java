/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Patrick Tan
 */
public class GetWeekDate {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println("Date " + c.getTime());
        c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        System.out.println("Date " + c.getTime());
    }
}

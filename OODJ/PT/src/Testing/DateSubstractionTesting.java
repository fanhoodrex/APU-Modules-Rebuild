package Testing;

import Classes.CustomCalendarHandler;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateSubstractionTesting {
    
    public static void main(String[] args){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date,date2;
        try {
            date2 = dateFormat.parse("2019-07-12");
            date = dateFormat.parse(dateFormat.format(new Date()));
            int left = (int)CustomCalendarHandler.calculateDifferenceInDays(date,date2,Locale.ENGLISH);
            System.out.println(left);
        } catch (ParseException ex) {
            Logger.getLogger(DateSubstractionTesting.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
}

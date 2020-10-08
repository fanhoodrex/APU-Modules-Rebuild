package Testing;

import static Classes.CustomCalendarHandler.weeksInCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTesting {
    public static void main(String[] args){
        weeksInCalendar(YearMonth.now()).forEach((x) -> {
            String[] sDte = x.toString().split("\\-");
            Calendar cal2 = Calendar.getInstance();
       cal2.set(Calendar.YEAR, Integer.valueOf(sDte[0]));
cal2.set(Calendar.MONTH, Integer.valueOf(sDte[1])-1);
cal2.set(Calendar.DAY_OF_MONTH, Integer.valueOf(sDte[2]));
 String[] days = new String[5];
DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int delta = -cal2.get(GregorianCalendar.DAY_OF_WEEK) + 2;
    cal2.add(Calendar.DAY_OF_MONTH, delta );
    for (int i = 0; i < 5; i++)
    {
        days[i] = dateFormat.format(cal2.getTime());
        cal2.add(Calendar.DAY_OF_MONTH, 1);
    }
    System.out.println(Arrays.toString(days));
        });

}
}

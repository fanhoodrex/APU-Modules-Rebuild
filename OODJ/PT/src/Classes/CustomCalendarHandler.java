package Classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class CustomCalendarHandler {
    public static Calendar toCalendar(Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    public static long calculateDifferenceInDays(Date start, Date end, Locale locale) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long startTime = cal.getTimeInMillis();
        cal.setTime(end);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long endTime = cal.getTimeInMillis();
        // calculate the offset if one of the dates is in summer time and the other one in winter time
        TimeZone timezone = cal.getTimeZone();
        int offsetStart = timezone.getOffset(startTime);
        int offsetEnd = timezone.getOffset(endTime);
        int offset = offsetEnd - offsetStart;
        return TimeUnit.MILLISECONDS.toDays(endTime - startTime + offset);
    }
    public static List<LocalDate> weeksInCalendar(YearMonth month) {
        List<LocalDate> firstDaysOfWeeks = new ArrayList<>();
        for (LocalDate day = firstDayOfCalendar(month); stillInCalendar(month, day); day = day
            .plusWeeks(1)) {
          firstDaysOfWeeks.add(day);
        }
        return firstDaysOfWeeks;
    }
    
    private static LocalDate firstDayOfCalendar(YearMonth month) {
        DayOfWeek FIRST_DAY_OF_WEEK = DayOfWeek.MONDAY;
        return month.atDay(1).with(FIRST_DAY_OF_WEEK);
    }

    private static boolean stillInCalendar(YearMonth yearMonth, LocalDate day) {
        return !day.isAfter(yearMonth.atEndOfMonth());
    }
    public static int validateDate(String dte) throws ParseException{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date tdy,dynamic_dte;
        dynamic_dte = dateFormat.parse(dte);
        tdy = dateFormat.parse(dateFormat.format(new Date()));
        int left = (int)CustomCalendarHandler.calculateDifferenceInDays(tdy,dynamic_dte,Locale.ENGLISH);
        return left;
    }
    public static List<Date> getDatesBetween(Date startDate, Date endDate) {
        List<Date> datesInRange = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);
        while (calendar.before(endCalendar)) {
            Date result = calendar.getTime();
            datesInRange.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        return datesInRange;
    }
    public static ArrayList<String> getPrintAllWeekDay(String InitialDate) throws ParseException{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        ArrayList<String> Days = new ArrayList();
        Date date = dateFormat.parse(InitialDate);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        for(Date x : getDatesBetween(new SimpleDateFormat("yyyy-MM-dd").parse(InitialDate), new SimpleDateFormat("yyyy-MM-dd").parse(dateFormat.format(c.getTime())))){
           Days.add(dateFormat.format(x));
        }
        return Days;
    }
    public static ArrayList<String> getThisAndNextWeekAllWeekDay() throws ParseException{
        Date d = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<String> WeeksArray = new ArrayList();
        ArrayList<String> AllDateArray = new ArrayList();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        WeeksArray.add(dateFormat.format(c.getTime()));
        c.add(Calendar.DATE, 7);
        WeeksArray.add(dateFormat.format(c.getTime()));
        for(String Week : WeeksArray){
            for (String Dates : getPrintAllWeekDay(Week)){
                AllDateArray.add(Dates);
            }
        }
        return AllDateArray;
    }
}

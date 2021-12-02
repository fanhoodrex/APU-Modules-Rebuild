
package Testing;

import Classes.CustomCalendarHandler;
import static Classes.CustomCalendarHandler.getDatesBetween;
import static Classes.CustomCalendarHandler.weeksInCalendar;
import Classes.FileController;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetDateRange {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static void getAvailableTime(){
        weeksInCalendar(YearMonth.now()).forEach((y) -> {
            ArrayList<String> ValidDate = new ArrayList();
            Calendar c = Calendar.getInstance();
            Date date;
            try {
                date = dateFormat.parse(y.toString());
                c.setTime(date);
                c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                System.out.println();
                System.out.println("Start Date:" + y.toString() +" | End Date:" + dateFormat.format(c.getTime()));
                Date C_date1= new SimpleDateFormat("yyyy-MM-dd").parse(y.toString());  
                Date C_date2= new SimpleDateFormat("yyyy-MM-dd").parse(dateFormat.format(c.getTime()));  
                for(Date x : getDatesBetween(C_date1, C_date2)){
                    boolean exist = false;
                    File f = new File("DATA/Consultation/" + dateFormat.format(x) + ".txt");
                    if (f.exists()){
                        int[] PKs = {0};
                        String[] Vals = {"LECT0006"};
                        ArrayList<String> rFile = FileController.ReadFile(f, PKs, Vals);
                        if (rFile.size() > 0){
                            exist = true;
                        }
                    }
                    if (exist == true){
                        ValidDate.add(dateFormat.format(x));
                    }
                }
                for(String l : ValidDate){
                    System.out.println(l);
                }
            System.out.println("--");
            } catch (ParseException ex) {
                Logger.getLogger(GetDateRange.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GetDateRange.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        });
    }
    public static void getAvailableWeek(){
        File directory = new File("DATA/Consultation");
        String[] files = directory.list();
        weeksInCalendar(YearMonth.now()).forEach((y) -> {
            ArrayList<String> ValidDate = new ArrayList();
            Calendar c = Calendar.getInstance();
            Date date;
            try {
                date = dateFormat.parse(y.toString());
                c.setTime(date);
                c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                System.out.println();
                System.out.println("Start Date:" + y.toString() +" | End Date:" + dateFormat.format(c.getTime()));
                Date C_date1= new SimpleDateFormat("yyyy-MM-dd").parse(y.toString());  
                Date C_date2= new SimpleDateFormat("yyyy-MM-dd").parse(dateFormat.format(c.getTime()));  
                boolean exist = false;
                for(Date x : getDatesBetween(C_date1, C_date2)){
                    File f = new File("DATA/Consultation/" + dateFormat.format(x) + ".txt");
                    if (f.exists()){
                        int[] PKs = {0};
                        String[] Vals = {"LECT0006"};
                        ArrayList<String> rFile = FileController.ReadFile(f, PKs, Vals);
                        if (rFile.size() > 0){
                            exist = true;
                        }
                    }
                }
                if (exist == true){
                    System.out.println(y.toString());
               }
            System.out.println("--");
            } catch (ParseException ex) {
                Logger.getLogger(GetDateRange.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GetDateRange.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        });
    }
    public static void getPrintAllWeekDay(String InitialDate) throws ParseException{
        Calendar c = Calendar.getInstance();
        Date date = dateFormat.parse(InitialDate);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        for(Date x : getDatesBetween(new SimpleDateFormat("yyyy-MM-dd").parse(InitialDate), new SimpleDateFormat("yyyy-MM-dd").parse(dateFormat.format(c.getTime())))){
            System.out.println(dateFormat.format(x));
        }
    }
    public static void getThisNextWeekAllWeekDay() throws ParseException{
        Date d = new Date();
        ArrayList<String> WeeksArray = new ArrayList();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        WeeksArray.add(dateFormat.format(c.getTime()));
        //System.out.println(dateFormat.format(c.getTime()));
        c.add(Calendar.DATE, 7);
        WeeksArray.add(dateFormat.format(c.getTime()));
        //System.out.println(dateFormat.format(c.getTime()));
        for(String Week : WeeksArray){
            getPrintAllWeekDay(Week);
        }
        
    }
    public static void main(String[] args){
        try {
            //        try {
            //getAvailableTime();
            //getAvailableWeek();
            //getPrintAllWeekDay("2019-07-22");
            getThisNextWeekAllWeekDay();
//        Date date1,date2;
//
//        
//        try {
//            date2 = dateFormat.parse("2019-07-22");
//            date1 = dateFormat.parse("2019-07-26");
//            for(Date x : getDatesBetweenUsingJava7(date2, date1)){
//                System.out.println(x);
//            }
//        } catch (ParseException ex) {
//            Logger.getLogger(GetDateRange.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        } catch (ParseException ex) {
//            Logger.getLogger(GetDateRange.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (ParseException ex) {
            Logger.getLogger(GetDateRange.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

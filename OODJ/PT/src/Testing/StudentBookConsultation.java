/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import static Classes.Consultation.saveConsultation;
import Exception.UnauthorizationException;
import Classes.Consultation;
import Classes.Lecturer;
import Exception.PrimaryKeyNotFoundException;
import Classes.Slot;
import Classes.Student;
import Classes.Venue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patrick Tan
 */
public class StudentBookConsultation {
    public static void main(String[] args){
        Student std = new Student("STD0005");
        List<Consultation> StudentConsultationInfo = new ArrayList();
        try {
            String[] times = {"10:30","12:30"};
            String[] res = {"Assignment","Tutorial"};
            for (int i =0;i<2;i++){
                Consultation cl = new Consultation(new Student("STD0005"),new Lecturer("LECT0002"), new Slot(times[i]), new Venue("B-06-01"),"2019-07-01");
                cl.BookConsultation(res[i]);
                StudentConsultationInfo.add(cl);
            }
            Consultation cl = new Consultation(new Student("STD0005"),new Lecturer("LECT0002"), new Slot("10:30"), new Venue("B-06-01"),"2019-07-01");
            cl.CancelConsultation(std.getUserID());
            StudentConsultationInfo.add(cl);
            std.setConsultationList(StudentConsultationInfo);
            System.out.println(saveConsultation(std.getConsultationList()));
        } catch (FileNotFoundException | UnauthorizationException | PrimaryKeyNotFoundException ex) {
            System.out.println("We have some error atm!");
        }
        catch (IOException ex) {
                Logger.getLogger(StudentBookConsultation.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}

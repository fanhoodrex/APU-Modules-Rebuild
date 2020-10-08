package Testing;

import static Classes.Consultation.saveConsultation;
import Exception.UnauthorizationException;
import Classes.Consultation;
import Classes.Lecturer;
import Exception.PrimaryKeyNotFoundException;
import Classes.Slot;
import Classes.Venue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecturerCreateConsultation {
    public static void main(String[] args) throws IOException{
        Lecturer lect = new Lecturer("LECT0002");
        Consultation cl = new Consultation(new Lecturer("LECT0002"),new Slot("12:00"),new Venue("B-07-02"),"2019-07-22");
        List<Consultation> x = new ArrayList();
        try {
            cl.CreateConsultation();
            System.out.println(cl);
            x.add(cl);
            lect.setConsultationList(x);
            //saveConsultation(lect.getConsultationList());
            System.out.println(saveConsultation(lect.getConsultationList()));
        } catch (FileNotFoundException | UnauthorizationException | PrimaryKeyNotFoundException ex) {
            System.out.println("Llalala");
        }
        
    }
}

package Testing;

import java.io.FileNotFoundException;
import Classes.Consultation;
import Classes.Lecturer;
import java.io.IOException;

public class viewConsultationList {
    public static void main(String[] args){
        Consultation cl = new Consultation(new Lecturer("LECT0002"));
        try {
            for (String x : cl.getConsultationList("")){
                System.out.println(x);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File is not found!");
        } catch (IOException ex) {
            System.out.println("IO is not ready");
        }
    }
}
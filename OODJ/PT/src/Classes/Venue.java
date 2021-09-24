package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Venue{
    private String vn;
    private Lecturer lecturer;
    private ArrayList<String> DefinedVenue;
    public Venue(String loc){
        setAllocatedVenue(loc);
    }
    public Venue(Lecturer lecturer){
        this.DefinedVenue = new ArrayList();
        this.lecturer = lecturer;
    }
    private void setAllocatedVenue(String vn){
        this.vn = vn;
    }
    public void setDefinedVenue(String DefinedVenue){
        this.DefinedVenue.add(DefinedVenue);
    }
    public String getAllocatedVenue(){
        return vn;
    }
    private ArrayList<String> getDefinedVenue(){
        return DefinedVenue;
    }
    public boolean saveDefinedVenue() throws IOException{
       File f = new File("DATA/Venues/" + lecturer.getUserID() + "-Venue.txt");
       if (!f.exists()){
          f.createNewFile();
       }
       return  FileController.reWriteFile(f,getDefinedVenue());
    }
    public ArrayList<String> getDefaultVenues() throws FileNotFoundException, IOException{
        ArrayList<String> defaultVenueList = FileController.ReadFile(new File("DATA/Default/ConsultationVenue(Default).txt"));
        return defaultVenueList;
    }
    public ArrayList<String> getUserDefinedVenues() throws FileNotFoundException, IOException{
        File f = new File("DATA/Venues/" + lecturer.getUserID() + "-Venue.txt");
        ArrayList<String> venueList = new ArrayList();
        if (f.exists()){
            venueList = FileController.ReadFile(f);
        }
        return venueList;
    }
}

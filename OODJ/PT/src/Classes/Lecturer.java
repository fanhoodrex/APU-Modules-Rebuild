package Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import util.Func;

public class Lecturer extends User {
    private String specialized;
    List<Consultation> Consultation;
   public Lecturer(){
        setRole("Lecturer");
    }
   
   public Lecturer(String UserID){
        setUserID(UserID);
        setRole("Lecturer");
    }
   
   public Lecturer(String username, String password){
        super(username, password);
        setRole("Lecturer");
    }

    public void setConsultationList(List<Consultation> Consultation){
        this.Consultation = Consultation;
    }
    
    /*Encapsulation*/
    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    public String getSpecialized() {
        return specialized;
    }
    
    public List<Consultation> getConsultationList() {
        return Consultation;
    }
    
    public static String getNameFromID(String userID) throws IOException{
        int[] PKs = {0};
        String[] Vals = {userID};
        String val = null;
        ArrayList<String> FileContent = FileController.ReadFile(new File("DATA/Lecturer.txt"),PKs,Vals);
        for (String Content : FileContent){
            String[] s_Line = Content.split("\\|\\|");
            val = s_Line[3];
        }
        return val;
    }
        
    @Override
    public boolean InitializeProfile() throws Exception{
        boolean success = false;
        int[] PKs ={0};
        String[] Vals = {getUserID()};
        ArrayList <String> lectProfile = FileController.ReadFile(new File("DATA/" + getRole() + ".txt"), PKs, Vals);
        for(String i : lectProfile){
            String profile = i;
            String[] Profile = profile.split("\\|\\|");
            setUsername(Profile[1]);
            setPassword(Profile[2]);
            setName(Profile[3]);
            setContactno(Profile[4]);
            setEmail(Profile[5]);
            setSpecialized(Profile[6]);
	    setGender(Profile[7]);
            success = true;
        }
        return success;
    }
    
    @Override
    public boolean UpdateProfile() throws IOException{
        int[] WherePKs ={0};
        String[] WherePKVals = {getUserID()};
        int[] UpdatePKs = {3,4,5,6,7};
        String[] UpdatePKVals ={getName(), getContactno(), getEmail(), getSpecialized(), getGender()};
        boolean x = FileController.UpdateFile(new File("DATA/" + getRole() + ".txt"), WherePKs, WherePKVals, UpdatePKs, UpdatePKVals);
        return x;
    }

    @Override
    public boolean register() throws IOException{
        ArrayList<String> LecReg = new ArrayList(); 
        LecReg.add(Func.generateID(getRole()));
        LecReg.add(getUsername());
        LecReg.add(getPassword());
        LecReg.add(getName());
        LecReg.add(getContactno());
        LecReg.add(getEmail());
        LecReg.add(getSpecialized());        
	LecReg.add(getGender());
        ArrayList<String>pLecReg = new ArrayList();
        pLecReg.add(FileController.ConstructArray(LecReg));
        return FileController.WriteFile(new File("DATA/" + getRole() + ".txt"),pLecReg );
        }
}

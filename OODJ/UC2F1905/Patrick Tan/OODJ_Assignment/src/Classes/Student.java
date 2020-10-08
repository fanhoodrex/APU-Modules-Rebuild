package Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import util.Func;

public class Student extends User {
    private String intakeCode;
    List<Consultation> Consultation;
    
   public Student(){
        setRole("Student");
    }
    public Student(String UserID){
        setUserID(UserID);
        setRole("Student");
    }
   public Student(String username, String password){
        super(username, password);
        setRole("Student");
    }

    public void setConsultationList(List<Consultation> Consultation){
        this.Consultation = Consultation;
    }
    /*Encapsulation*/
    public void setIntakeCode(String intakeCode) {
        this.intakeCode = intakeCode;
    }

    public String getIntakeCode() {
        return intakeCode;
    }
    
    public List<Consultation> getConsultationList() {
        return Consultation;
    }
    
    public ArrayList<String> getLecList() throws Exception{
        ArrayList <String> lecList = FileController.ReadFile(new File("DATA/Lecturer.txt"));
        ArrayList <String> List = new ArrayList();
        int i = 0;
            for(String list : lecList){
                String[] leclist = list.split("\\|\\|");
                String userid = leclist[0];
                String name = leclist[3];
                if (i > 0){
                    List.add(userid + " | " + name);
                }
                i++;
            }
        return List;
    }
    
    public static String getNameFromID(String userID) throws IOException{
        int[] PKs = {0};
        String[] Vals = {userID};
        String val = null;
        ArrayList<String> FileContent = FileController.ReadFile(new File("DATA/Student.txt"),PKs,Vals);
        for (String Content : FileContent){
            String[] s_Line = Content.split("\\|\\|");
            val = s_Line[3];
        }
        return val;
    }
    
    public String getNameFormat() throws Exception{
        int[] PKs ={0};
        String[] Vals = {getUserID()};
        ArrayList <String> stdInfo = FileController.ReadFile(new File("DATA/Lecturer.txt"), PKs, Vals);
        String idnamelist = null;
        for(String i : stdInfo){
            String info = i;
            String[] Info = info.split("\\|\\|");
            String id = Info[0];
            String name = Info[3];
            idnamelist = id +" | "+ name;
        }
        return idnamelist;
    }

    @Override
    public boolean InitializeProfile() throws Exception{
        boolean success = false;
        int[] PKs ={0};
        String[] Vals = {getUserID()};
        ArrayList <String> stdProfile = FileController.ReadFile(new File("DATA/" + getRole() + ".txt"), PKs, Vals);
        for(String i : stdProfile){
            String profile = i;
            String[] Profile = profile.split("\\|\\|");
            setUsername(Profile[1]);
            setPassword(Profile[2]);
            setName(Profile[3]);
            setContactno(Profile[4]);
            setEmail(Profile[5]);
            setIntakeCode(Profile[6]);
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
        String[] UpdatePKVals ={getName(), getContactno(), getEmail(), getIntakeCode(), getGender()};
        boolean x = FileController.UpdateFile(new File("DATA/" + getRole() + ".txt"), WherePKs, WherePKVals, UpdatePKs, UpdatePKVals);
        return x;
    }

    @Override
   public boolean register() throws IOException{
        ArrayList<String> StdReg = new ArrayList();
        StdReg.add(Func.generateID(getRole()));
        StdReg.add(getUsername());
        StdReg.add(getPassword());
        StdReg.add(getName());
        StdReg.add(getContactno());
        StdReg.add(getEmail());
        StdReg.add(getIntakeCode());
	StdReg.add(getGender());
        ArrayList<String> pStdReg = new ArrayList();
        pStdReg.add(FileController.ConstructArray(StdReg));
       return FileController.WriteFile(new File("DATA/" + getRole() + ".txt"),pStdReg );
    }
}

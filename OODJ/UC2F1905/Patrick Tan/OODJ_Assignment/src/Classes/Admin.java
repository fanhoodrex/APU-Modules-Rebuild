package Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Admin extends User{
    public Admin(){
        setRole("Admin");
    }
    
    public Admin(String username, String password){
        super(username, password);
        setRole("Admin");
    }
    
    @Override
    public boolean register() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean InitializeProfile() throws Exception {
        boolean success = false;
        int[] PKs ={0};
        String[] Vals = {getUserID()};
        ArrayList <String> stdProfile = FileController.ReadFile(new File("DATA\\" + getRole() + ".txt"), PKs, Vals);
        for(String i : stdProfile){
            String profile = i;
            String[] Profile = profile.split("\\|\\|");
            setUsername(Profile[1]);
            setName(Profile[3]);
            setContactno(Profile[4]);
            setEmail(Profile[5]);
            setGender(Profile[6]);
            success = true;
        }
        return success;
    }
    @Override
    public boolean UpdateProfile() throws IOException{
        int[] WherePKs ={0};
        String[] WherePKVals = {getUserID()};
        int[] UpdatePKs = {3,4,5,6};
        String[] UpdatePKVals ={getName(), getContactno(), getEmail(), getGender()};
        boolean x = FileController.UpdateFile(new File("DATA\\" + getRole() + ".txt"), WherePKs, WherePKVals, UpdatePKs, UpdatePKVals);
        return x;
    }
    
}

package Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import util.Func;

abstract class User{
    private String username, password, role, name, contactno, email, gender, userID;
    ArrayList<String> error_msg = new ArrayList();
    /*Constructer*/
    public User(){
        setRole(role);
    }
    public User(String username, String password){
        setUsername(username);
        setPassword(password);
        setRole(role);
    }
    
    public abstract boolean register() throws IOException;
    public abstract boolean InitializeProfile() throws Exception;
    public abstract boolean UpdateProfile() throws IOException;
    public void setRole(String role){
        this.role = role;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setUserID(String userID){
        this.userID = userID;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setErrorMsg(String error){
        error_msg.add(error);
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getContactno() {
        return contactno;
    }

    public String getEmail() {
        return email;
    }
    
    public String getGender() {
        return gender;
    }
    
    public ArrayList<String> getErrormsg(){
            return error_msg;
    }
    
    public String getRole(){
        return role;
    }
    
    public void getTxtName(){
       Func.generateID(getRole());
    }
    
    public boolean checkUniqueusername()throws Exception{
        boolean success = false;
        int[] PKs = {1,2};
        String[] Vals = {getUsername(), getPassword()};
            ArrayList <String> checkUN = FileController.ReadFile(new File("DATA/" + getRole() + ".txt"), PKs, Vals);
            if (checkUN.isEmpty()){
                success = true;
            }
        return success;
    }
    
    public void validateUsername(){
        String regex="^[A-Za-z][A-Za-z0-9]{7,14}$";
        if(!(getUsername().matches(regex))){
            setErrorMsg("The length of the username should be 8 to 15, the initial value must be an alphabet, the subsequent value can be alphabets or number but special character is not allowed!");
        }
    }
    
    public void validatePassword(){
        if(!(getPassword().length()>=10)){
            setErrorMsg("Password is invalid! Please fill in the password more than or equal to 10 characters!");
        }
    }
    private boolean ContactNoValidator(String phoneNo) {
	if (phoneNo.matches("\\d{10}")) return true;
	else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
	else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
	else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
	else return false;
    }
    public void validateContactNo(){
        if (!ContactNoValidator(getContactno())){
            setErrorMsg("Contact Number is invalid! Your contact number should only have 10 digit long!");
        }
    }
    
    public void validateEmail(){
        if(!getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            setErrorMsg("Email is invalid!\nPlease provide a valid email address with an appropriate format!!");
        }
    }
    
    public void clearErroMsg(){
        error_msg.clear();
    }
    public boolean login() throws Exception{
        boolean success = false;
        int[] PKs = {1,2};
        String[] Vals = {getUsername(), getPassword()};
            ArrayList <String> uLogin = FileController.ReadFile(new File("DATA/" + getRole() + ".txt"), PKs, Vals);
            if (uLogin.size() == 1){
                success = true;
                uLogin.stream().map((usrInfos) -> usrInfos.split("\\|\\|")).forEachOrdered((usrInfo) -> {
                    setUserID(usrInfo[0]);
            });
                
            }
        return success;
    }
     
}


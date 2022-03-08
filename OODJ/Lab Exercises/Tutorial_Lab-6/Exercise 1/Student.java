/**
 * Student
 */
public class Student extends Person {
    private String status;

    public Student(String name, String address, int PhoneNo, String email, String status){
        super(name, address, PhoneNo, email, officename, salaryamount, datehired);
        this.status = status;
    }

    public enum Status {
        FRESHMAN, SOPHOMORE, JUNIOR, SENIOR;
    } 
    
    public String toString(){
        return "Class:Student \nName: " + name;
    }
}
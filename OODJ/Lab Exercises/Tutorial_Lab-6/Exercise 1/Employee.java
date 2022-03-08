/**
 * Employee
 */
public class Employee extends Person{
    private String office;
    private double salary;
    private String date_hired;

    public Employee(String name, String address, int phoneNo, String email, String officename, double salaryamount, String datehired){
        super(name, address, phoneNo, email);
        this.office = officename;
        this.salary = salaryamount;
        this.date_hired = datehired;
    }

    public String toString() {
        return "Class: Employee \nName: " + name;
    }    
}
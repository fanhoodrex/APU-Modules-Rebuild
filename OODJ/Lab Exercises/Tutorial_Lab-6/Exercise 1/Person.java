/**
 * Person
 */
public class Person {
    protected String name;
    protected String address;
    protected int phone_number;
    protected String email;

    public Person(String name, String address, int PhoneNo, String email){
        this.name = name;
        this.address = address;
        this.phone_number = PhoneNo;
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phone_number + "\nEmail: " + email; 
    }
}
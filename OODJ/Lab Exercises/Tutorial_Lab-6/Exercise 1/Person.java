/**
 * Person
 */
public class Person {
    protected String name;
    protected String address;
    protected String telno;
    protected String email;

    @Override
    public String toString() {
        return "Employee:" + this.name;
    }
}
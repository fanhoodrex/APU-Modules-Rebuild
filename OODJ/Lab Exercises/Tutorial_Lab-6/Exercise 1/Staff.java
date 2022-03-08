public class Staff extends Employee{
    protected String title;

    @Override
    public String toString() {
        return "Staff:" + super.name;
    }
}
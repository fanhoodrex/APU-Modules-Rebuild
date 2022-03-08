public class Faculty extends Employee{
    private int officeHour;
    private int rank;

    @override
    public String toString(){
        return "Faculty:" + super.name;
    }
}
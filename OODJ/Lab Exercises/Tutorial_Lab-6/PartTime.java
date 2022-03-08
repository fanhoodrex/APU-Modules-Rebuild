public class PartTime extends Staff {
    private int hourWorked;

    public void calcSalary() {
        super.salary = hourWorked * 1.5;
    }
}
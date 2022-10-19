package LessonEight;

public class FullTimeEmployee extends Employee {
    private static final String EMPLOYEE_TYPE = "FTE";

    public FullTimeEmployee() {
        super(50000);
    }

    public FullTimeEmployee(int salary) {
        super(salary);
    }

    public static String getEmployeeType() {
        return EMPLOYEE_TYPE;
    }

}

package LessonEight;

public class ContractEmployee extends Employee {
    private static final String EMPLOYEE_TYPE = "CON";

    public ContractEmployee() {
        super(40000);
    }

    public ContractEmployee(int salary) {
        super(salary);
    }

    public static String getEmployeeType() {
        return EMPLOYEE_TYPE;
    }
}

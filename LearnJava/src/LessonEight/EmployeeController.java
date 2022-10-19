package LessonEight;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {

    public static List<Employee> generateEmployeeList(int totalEmployee, String employeeType) {
        List<Employee> employeeList = new ArrayList<>();
        if (employeeType.equals(FullTimeEmployee.getEmployeeType())) {
            for (int index = 0; index < totalEmployee; index++) {
                employeeList.add(new FullTimeEmployee());
            }
        } else if (employeeType.equals(ContractEmployee.getEmployeeType())) {
            for (int index = 0; index < totalEmployee; index++) {
                employeeList.add(new ContractEmployee());
            }
        } else {
            // Do nothing
        }
        return employeeList;
    }

    public static int calculateSalary(List<Employee> employeeList) {
        int totalSalary = 0;
        for (Employee employee : employeeList) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }
}

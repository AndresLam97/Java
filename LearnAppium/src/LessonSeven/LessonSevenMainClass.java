package LessonSeven;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LessonSevenMainClass {

    public static void main(String[] args) {
        int totalFTE;
        int totalCon;
        List<Employee> fteEmployeeList;
        List<Employee> conEmployeeList;
        System.out.printf("Enter the total of full time employee: ");
        totalFTE = new Scanner(System.in).nextInt();
        System.out.printf("Enter the total of contract employee: ");
        totalCon = new Scanner(System.in).nextInt();

        fteEmployeeList = generateEmployeeList(totalFTE, "fte");
        conEmployeeList = generateEmployeeList(totalCon, "con");

        System.out.printf("The total salary of full time employee is %d. \n", calculateSalary(fteEmployeeList));
        System.out.printf("The total salary of contract employee is %d. \n ", calculateSalary(conEmployeeList));
    }


    static List<Employee> generateEmployeeList(int totalEmployee, String employeeId) {
        List<Employee> employeeList = new ArrayList<>();
        if (employeeId.toUpperCase().equals("FTE")) {
            for (int index = 0; index < totalEmployee; index++) {
                employeeList.add(new Employee("FTE"));
            }
        }
        if (employeeId.toUpperCase().equals("CON")) {
            for (int index = 0; index < totalEmployee; index++) {
                employeeList.add(new Employee("CON"));
            }
        }
        return employeeList;
    }

    static int calculateSalary(List<Employee> employeeList) {
        int totalSalary = 0;
        for (Employee em : employeeList) {
            totalSalary += em.getSalary();
        }
        return totalSalary;
    }
}

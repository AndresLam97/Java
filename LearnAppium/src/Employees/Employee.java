package Employees;

public class Employee {

    private int salary;
    private String id;

    public Employee() {
        id = "";
        salary = 0;
    }

    public Employee(String id) {
        if (id.toUpperCase().equals("FTE")) {
            this.salary = 50000;
        }
        if (id.toUpperCase().equals("CON")) {
            this.salary = 40000;
        }
    }

    public Employee(int salary, String id) {
        this.salary = salary;
        this.id = id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}

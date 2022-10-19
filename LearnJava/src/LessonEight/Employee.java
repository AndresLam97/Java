package LessonEight;

public class Employee {
    private int salary;

    public Employee()
    {
        this.salary = 0;
    }

    public Employee(int salary)
    {
        this.salary = salary;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

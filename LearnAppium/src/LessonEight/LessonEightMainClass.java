package LessonEight;

import java.util.*;

public class LessonEightMainClass {
    public static void main(String[] args) {
        LessonEightMainClass lessonEight = new LessonEightMainClass();
        lessonEight.init();
    }


    public void init() {
        boolean key = true;
        while (key) {
            System.out.println("===== MENU =====");
            System.out.println("1. Lab 8.1");
            System.out.println("2. Lab 8.2");
            System.out.println("3. Exit");
            System.out.printf("Enter your option: ");
            int userOption = new Scanner(System.in).nextInt();

            switch (userOption) {
                case 1:
                    lab81();
                    break;
                case 2:
                    lab82();
                    break;
                case 3:
                    key = false;
                    break;
                default:
                    System.out.println("You entered a number other than 1-3, please retry again");
            }
            System.out.println("");
        }
    }

    public void lab81() {
        int totalFTE;
        int totalCon;
        List<Employee> fteEmployeeList;
        List<Employee> conEmployeeList;
        System.out.printf("Enter the total of full time employee: ");
        totalFTE = new Scanner(System.in).nextInt();
        System.out.printf("Enter the total of contract employee: ");
        totalCon = new Scanner(System.in).nextInt();

        fteEmployeeList = EmployeeController.generateEmployeeList(totalFTE, FullTimeEmployee.getEmployeeType());
        conEmployeeList = EmployeeController.generateEmployeeList(totalCon, ContractEmployee.getEmployeeType());

        System.out.printf("The total salary of full time employee is %d. \n", EmployeeController.calculateSalary(fteEmployeeList));
        System.out.printf("The total salary of contract employee is %d. \n ", EmployeeController.calculateSalary(conEmployeeList));
    }

    public void lab82() {
        int totalHorse;
        int totalTiger;
        int totalDog;
        List<Animal> animalList;
        HashMap<String, Integer> totalList;
        System.out.printf("Enter the total of horse: ");
        totalHorse = new Scanner(System.in).nextInt();
        System.out.printf("Enter the total of tiger: ");
        totalTiger = new Scanner(System.in).nextInt();
        System.out.printf("Enter the total of dog: ");
        totalDog = new Scanner(System.in).nextInt();
        totalList = new HashMap<>();
        totalList.put("HORSE", totalHorse);
        totalList.put("TIGER", totalTiger);
        totalList.put("DOG", totalDog);

        animalList = AnimalController.generateAnimal(totalList);

        AnimalController.raceCompetition(animalList);

    }


}

package LessonFive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LessonFiveMainClass {

    public static void main(String[] args) {
        LessonFiveMainClass lessonFive = new LessonFiveMainClass();
        lessonFive.menu();
    }

    void menu() {
        boolean exitOption = true;
        List<Integer> numberList = new ArrayList<>();
        while (exitOption) {
            int userOption;
            System.out.println("===== MENU =====");
            System.out.println("1. Add number into ArrayList.");
            System.out.println("2. Print numbers.");
            System.out.println("3. Get maximum number.");
            System.out.println("4. Get minimum number.");
            System.out.println("5. Find the index of number");
            System.out.println("6. Exit program.");
            userOption = new Scanner(System.in).nextInt();

            switch (userOption) {
                case 1:
                    addNumber(numberList);
                    break;
                case 2:
                    printNumbers(numberList);
                    break;
                case 3:
                    getMaximumNumber(numberList);
                    break;
                case 4:
                    getMinimumNumber(numberList);
                    break;
                case 5:
                    findTheIndexOfNumber(numberList);
                    break;
                case 6:
                    exitOption = false;
                    break;
                default:
                    System.out.println("You entered a number other than 1-6, please retry again");
            }
        }
    }

    void addNumber(List<Integer> numberList) {
        int totalNumber;
        System.out.print("Enter the total of number which want to add: ");
        totalNumber = new Scanner(System.in).nextInt();
        for (int index = 0; index < totalNumber; index++) {
            int elementNumber;
            System.out.printf("Enter a number: ");
            elementNumber = new Scanner(System.in).nextInt();
            numberList.add(elementNumber);
        }
    }

    void printNumbers(List<Integer> numberList) {
        if (numberList.isEmpty()) {
            System.out.printf("There is nothing to print because the list is empty, please add number then retry again!\n");
        } else if (numberList.size() == 1) {
            System.out.printf("All number of list: %d\n", numberList.get(0));
        } else {
            System.out.printf("All numbers of list: ");
            for (Integer integer : numberList) {
                System.out.printf("%d ", integer);
            }
            System.out.printf("\n");
        }
    }

    void getMaximumNumber(List<Integer> numberList) {
        // Check list empty or not
        if (numberList.isEmpty()) {
            System.out.printf("There is nothing to get because the list is empty, please add number then retry again!\n");
            return;
        }
        int maxNumber = numberList.get(0);
        for (int index = 1; index < numberList.size(); index++) {
            if (numberList.get(index) > maxNumber) {
                maxNumber = numberList.get(index);
            }
        }
        System.out.printf("The maximum number in list is number %d.\n", maxNumber);
    }

    void getMinimumNumber(List<Integer> numberList) {
        // Check list empty or not
        if (numberList.isEmpty()) {
            System.out.printf("There is nothing to get because the list is empty, please add number then retry again!\n");
            return;
        }
        int minNumber = numberList.get(0);
        for (int index = 1; index < numberList.size(); index++) {
            if (numberList.get(index) < minNumber) {
                minNumber = numberList.get(index);
            }
        }
        System.out.printf("The minimum number in list is number %d.\n", minNumber);

    }

    void findTheIndexOfNumber(List<Integer> numberList) {
        // Check list empty or not
        if (numberList.isEmpty()) {
            System.out.printf("There is nothing to find because the list is empty, please add number then retry again!\n");
            return;
        }
        int keyNumber;
        List<Integer> indexList = new ArrayList<>();
        System.out.printf("Enter the number which want to find index: ");
        keyNumber = new Scanner(System.in).nextInt();
        for (int index = 0; index < numberList.size(); index++) {
            if (numberList.get(index) == keyNumber) {
                indexList.add(index);
            }
        }

        if (indexList.isEmpty()) {
            System.out.printf("There is no number %d in list!\n", keyNumber);
        } else if (indexList.size() == 1) {
            System.out.printf("The number %d is in the index %d of list\n", keyNumber, indexList.get(0));
        } else {
            System.out.printf("The number %d is in the indexes ", keyNumber);
            for (Integer integer : indexList) {
                System.out.printf("%d ", integer);
            }
            System.out.printf("of list.\n");
        }
    }

}

package LessonNine;

import java.util.Scanner;

public class LessonNineMainClass {
    public static void main(String[] args) {
        LessonNineMainClass lessonNine = new LessonNineMainClass();
        lessonNine.init();
    }

    void init() {
        boolean keyValue = true;
        while (keyValue) {
            System.out.println("========================================================================");
            System.out.println("1. Lab 9 with auto generate animals.");
            System.out.println("2. Lab 9 with manual generate animals.");
            System.out.println("3. Exit program.");
            System.out.print("Enter your option: ");
            int userOption = new Scanner(System.in).nextInt();

            switch (userOption) {
                case 1 -> AnimalController.lab9WithAuto();
                case 2 -> AnimalController.lab9WithManual();
                case 3 -> keyValue = false;
                default -> System.out.println("You entered a number other than 1-3, please retry again");
            }

            System.out.println("");
        }
    }


}

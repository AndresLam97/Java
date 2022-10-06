package LessonTen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LessonTenView {

    public static void Lab10()
    {
        List<Animal> animalList = new ArrayList<>();
        boolean keyValue = true;
        while(keyValue) {
            System.out.println("========================= Lab 10 =========================");
            System.out.println("1. Auto generate animals.");
            System.out.println("2. Add your animal (if the animal you want is not on the list). ");
            System.out.println("3. Check the animal list.");
            System.out.println("4. Check the animal supported by program.");
            System.out.println("5. Go to the race competition.");
            System.out.println("6. Exit");
            System.out.print("Enter your option: ");
            int userOption = new Scanner(System.in).nextInt();
            switch(userOption)
            {
                case 1:
                    //animalList.addAll(AnimalController.generateAnimal());
                    break;
                case 2:
                    animalList.addAll(AnimalController.addAnimal(animalList));
                    break;
                case 3:
                    AnimalController.checkAnimalList(animalList);
                    break;
                case 4:
                    AnimalController.getAnimalListSupportByProgram();;
                    break;
                case 5:
                    AnimalController.raceCompetition(animalList);
                    break;
                case 6:
                    keyValue = false;
                    break;
                default:
                    System.out.println("Please enter the number from 1 to 6.");
            }
            System.out.println("");
        }


    }


}

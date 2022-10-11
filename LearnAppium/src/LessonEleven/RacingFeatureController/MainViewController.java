package LessonEleven.RacingFeatureController;

import LessonEleven.AnimalAbilities.AnimalAbilities;
import LessonTen.Animal;
import LessonTen.AnimalController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainViewController {

    public static void init()
    {
        List<AnimalAbilities> animalList = new ArrayList<>();
        boolean keyValue = true;
        while(keyValue) {
            System.out.println("========================= Lab 11 =========================");
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
                    animalList.addAll(RacingCompetitionController.generateAnimal());
                    break;
                case 2:
                    animalList.addAll(RacingCompetitionController.addAnimal(animalList));
                    break;
                case 3:
                    RacingCompetitionController.checkAnimalList(animalList);
                    break;
                case 4:
                    RacingCompetitionController.getAnimalListSupportByProgram();;
                    break;
                case 5:
                    RacingCompetitionController.raceCompetition(animalList);
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

package LessonEleven.RacingFeatureController;

import LessonEleven.AnimalAbility.*;
import LessonEleven.Animals.UserDefineAnimal;
import LessonEleven.Utils.*;
import java.security.SecureRandom;
import java.util.*;

public class RacingCompetitionController {

    private static final Map<String, Integer> supportedAnimalList = AnimalGeneralInformation.getSupportedAnimalList();

    // Service method use for case number 1 in MainViewController
    public static List<AnimalAbilities> generateAnimal() {
        List<AnimalAbilities> animalList = new ArrayList<>();
        int totalAnimal = RacingFeatureUtils.inputNumberOfAnimal();
        Map<String, Integer> animalCountList = new HashMap<>();
        for (int index = 0; index < totalAnimal; index++) {
            animalList.add(RacingFeatureUtils.createAnimal(animalCountList, new SecureRandom().nextInt(supportedAnimalList.size())));
        }
        System.out.println("Generate animals successfully");
        return animalList;
    }

    // Service method use for case number 2 in MainViewController
    public static List<AnimalAbilities> addAnimal(List<AnimalAbilities> currentAnimalList) {
        List<AnimalAbilities> addAnimalList = new ArrayList<>();
        int totalAnimal = RacingFeatureUtils.inputNumberOfAnimal();
        List<String> animalNameList = RacingFeatureUtils.getAnimalNameList(currentAnimalList);
        for (int index = 0; index < totalAnimal; index++) {
            String animalName = RacingFeatureUtils.createAnimalName(animalNameList);
            int animalSpeed = RacingFeatureUtils.createAnimalSpeed();
            int animalAbility = RacingFeatureUtils.createAnimalAbility();
            switch (animalAbility) {
                case 1:
                    addAnimalList.add(new UserDefineAnimal(animalName, animalSpeed, true, false, false));
                    animalNameList.add(animalName);
                    break;
                case 2:
                    addAnimalList.add(new UserDefineAnimal(animalName, animalSpeed, false, true, false));
                    animalNameList.add(animalName);
                    break;
                case 3:
                    addAnimalList.add(new UserDefineAnimal(animalName, animalSpeed, false, false, true));
                    animalNameList.add(animalName);
                    break;
                case 4:
                    addAnimalList.add(new UserDefineAnimal(animalName, animalSpeed, true, true, false));
                    animalNameList.add(animalName);
                    break;
                case 5:
                    addAnimalList.add(new UserDefineAnimal(animalName, animalSpeed, true, false, true));
                    animalNameList.add(animalName);
                    break;
                case 6:
                    addAnimalList.add(new UserDefineAnimal(animalName, animalSpeed, false, true, true));
                    animalNameList.add(animalName);
                    break;
                case 7:
                    addAnimalList.add(new UserDefineAnimal(animalName, animalSpeed, true, true, true));
                    animalNameList.add(animalName);
                    break;
            }
        }
        System.out.println("Add animal(s) successfully.");
        return addAnimalList;
    }

    // Service method use for case number 3 in MainViewController
    public static void checkAnimalList(List<AnimalAbilities> animalList) {
        if (animalList.isEmpty()) {
            System.out.println("There is no any animal in the list. Please add an animal then retry again!");
            return;
        } else {
            System.out.println("The list has " + animalList.size() + " animal(s) include: ");
            for (AnimalAbilities animal : animalList) {
                System.out.println(animal.getInformation());
            }
        }
    }

    // Service method use for case number 4 in MainViewController
    public static void getAnimalListSupportByProgram() {
        Set<String> programSupportedAnimal = supportedAnimalList.keySet();
        for (String s : programSupportedAnimal) {
            System.out.println(s);
        }
    }

    // Service method use for case number 5 in MainViewController
    public static void raceCompetition(List<AnimalAbilities> animalList) {
        if (animalList.isEmpty()) {
            System.out.println("There is no any animal in the list. Please add an animal then retry again!");
            return;
        }
        List<String> competitionAllowType = RacingFeatureUtils.getTypeForSignUp();
        List<AnimalAbilities> newAnimalList = RacingFeatureUtils.createSignUpReport(animalList, competitionAllowType);
        if (newAnimalList.isEmpty()) {
            System.out.println("There is no any eligible animal for this race, please retry again!");
            return;
        }
        newAnimalList.sort((a1, a2) -> a1.move() > a2.move() ? -1 : 1);
        System.out.println("====================== THE RACE COMPETITION BEGIN ======================");
        for (int index = 0; index < newAnimalList.size(); index++) {
            if (index == 0) {
                System.out.printf("The winner is %s, with speed: %d km/h\n"
                        , newAnimalList.get(index).getName(), newAnimalList.get(index).move());
            } else {
                System.out.printf("The position number %d is %s, with speed: %d km/h\n"
                        , (index + 1), newAnimalList.get(index).getName(), newAnimalList.get(index).move());
            }
        }
    }

    // Service method use for case number 6 in MainViewController
    public static void clearTheAnimalList(List<AnimalAbilities> animalList) {
        if (animalList.isEmpty()) {
            System.out.println("There is no any animal in the list. Please add an animal then retry again!");
            return;
        } else {
            System.out.println("Clear the animal list successfully");
            animalList.clear();
        }
    }

}

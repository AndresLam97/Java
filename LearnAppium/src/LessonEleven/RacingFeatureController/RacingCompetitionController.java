package LessonEleven.RacingFeatureController;

import LessonEleven.AnimalAbilities.*;
import LessonEleven.Animals.MarineAnimals.*;
import LessonEleven.Animals.AerialAnimals.*;
import LessonEleven.Animals.LandAnimals.*;
import LessonEleven.Animals.UserDefineAnimal;
import java.security.SecureRandom;
import java.util.*;

public class RacingCompetitionController {

    private static Map<String, Integer> supportedAnimalList = AnimalGeneralInformation.getSupportedAnimalList();

    // Service method use for case number 1 in MainViewController
    public static List<AnimalAbilities> generateAnimal() {
        List<AnimalAbilities> animalList = new ArrayList<>();
        int totalAnimal = inputNumberOfAnimal();
        Map<String, Integer> animalCountList = new HashMap<>();
        for (int index = 0; index < totalAnimal; index++) {
            animalList.add(createAnimal(animalCountList, new SecureRandom().nextInt(supportedAnimalList.size())));
        }
        System.out.println("Generate animals successfully");
        return animalList;
    }

    // Service method use for case number 2 in MainViewController
    public static List<AnimalAbilities> addAnimal(List<AnimalAbilities> currentAnimalList) {
        List<AnimalAbilities> addAnimalList = new ArrayList<>();
        int totalAnimal = inputNumberOfAnimal();
        List<String> animalNameList = getAnimalNameList(currentAnimalList);
        for (int index = 0; index < totalAnimal; index++) {
            String animalName = createAnimalName(animalNameList);
            int animalSpeed = createAnimalSpeed();
            int animalAbility = createAnimalAbility();
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
        int competitionAllowType = getTypeForSignUp();
        List<AnimalAbilities> newAnimalList = createSignUpReport(animalList, competitionAllowType);
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

    // Support method use to get animal type inputted by user
    private static int getTypeForSignUp() {
        boolean keyValue = true;
        while (keyValue) {
            System.out.println("Enter the animal type for the competition: ");
            System.out.println("1. Run able.");
            System.out.println("2. Fly able.");
            System.out.println("3. Swim able.");
            System.out.println("4. Run and fly able.");
            System.out.println("5. Run and swim able.");
            System.out.println("6. Fly and swim able");
            System.out.println("7. All");
            System.out.print("Enter your option: ");
            int userOption = new Scanner(System.in).nextInt();
            switch (userOption) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                default:
                    System.out.println("Please enter the number from 1 to 7");
            }
        }
        return 7;
    }

    // Support method use to create an sign up report
    // and display eligible/not eligible animal for the race competition
    private static List<AnimalAbilities> createSignUpReport(List<AnimalAbilities> fullAnimalList, int eligibleAbilityNumber) {
        List<AnimalAbilities> eligibleAnimalList = new ArrayList<>();
        List<AnimalAbilities> notEligibleAnimalList = new ArrayList<>();

        System.out.println("============================ SIGN UP REPORT ============================");
        System.out.println("========================================================================");
        System.out.println("The eligible animal(s):");
        for (AnimalAbilities animal : fullAnimalList) {
            if (eligibleList.contains(animal.getTYPE())) {
                eligibleAnimalList.add(animal);
                System.out.println(animal.getName());
            } else {
                notEligibleAnimalList.add(animal);
            }
        }
        System.out.println("");
        System.out.println("========================================================================");
        System.out.println("The not eligible animal(s):");
        for (AnimalAbilities animal : notEligibleAnimalList) {
            System.out.println(animal.getName());
        }
        System.out.println("");
        return eligibleAnimalList;
    }

    // Support method use to create multiple animals
    // with data is defined by user
    private static AnimalAbilities createAnimal(Map<String, Integer> animalCountList, int number) {
        switch (number) {
            case 0:
                return new Mouse(checkAndGetAnimalName(animalCountList, "Mouse"));
            case 1:
                return new Cat(checkAndGetAnimalName(animalCountList, "Cat"));
            case 2:
                return new Dog(checkAndGetAnimalName(animalCountList, "Dog"));
            case 3:
                return new Tiger(checkAndGetAnimalName(animalCountList, "Tiger"));
            case 4:
                return new Lion(checkAndGetAnimalName(animalCountList, "Lion"));
            case 5:
                return new Bear(checkAndGetAnimalName(animalCountList, "Bear"));
            case 6:
                return new Pig(checkAndGetAnimalName(animalCountList, "Pig"));
            case 7:
                return new Goat(checkAndGetAnimalName(animalCountList, "Goat"));
            case 8:
                return new Fox(checkAndGetAnimalName(animalCountList, "Fox"));
            case 9:
                return new Cow(checkAndGetAnimalName(animalCountList, "Cow"));
            case 10:
                return new Horse(checkAndGetAnimalName(animalCountList, "Horse"));
            case 11:
                return new Rabbit(checkAndGetAnimalName(animalCountList, "Rabbit"));
            case 12:
                return new Snake(checkAndGetAnimalName(animalCountList, "Snake"));
            case 13:
                return new Eagle(checkAndGetAnimalName(animalCountList, "Eagle"));
            case 14:
                return new Falcon(checkAndGetAnimalName(animalCountList, "Falcon"));
            case 15:
                return new Owl(checkAndGetAnimalName(animalCountList, "Owl"));
            case 16:
                return new DelphinusDelphis(checkAndGetAnimalName(animalCountList, "Delphinus Delphis"));
            case 17:
                return new KillerWhale(checkAndGetAnimalName(animalCountList, "Killer Whale"));
            case 18:
                return new WhiteShark(checkAndGetAnimalName(animalCountList, "White Shark"));
            default:
                return new UserDefineAnimal("Undefined", 0, false, false, false);
        }
    }

    // Support method use to check the current animal's name on list
    // then create a new name (use for the createAnimal service method)
    private static String checkAndGetAnimalName(Map<String, Integer> animalCountList, String name) {
        Set<String> keySet = animalCountList.keySet();
        if (keySet.contains(name)) {
            int currentValue = animalCountList.get(name);
            animalCountList.put(name, currentValue + 1);
            return name + " " + (currentValue + 1);
        } else {
            animalCountList.put(name, 1);
            return name + " " + 1;
        }
    }

    // Support method use to get the total of animals inputted by user
    private static int inputNumberOfAnimal() {
        int totalOfAnimal = 0;
        do {
            System.out.print("Enter total of animal(s): ");
            totalOfAnimal = new Scanner(System.in).nextInt();
            if (totalOfAnimal <= 0) {
                System.out.println("Please enter at least one animal.");
            }
        } while (totalOfAnimal <= 0);
        return totalOfAnimal;
    }

    // Support method use to get the available animal's name on list
    private static List<String> getAnimalNameList(List<AnimalAbilities> animalList) {
        List<String> animalNameList = new ArrayList<>();
        animalList.stream().forEach(e -> animalNameList.add(e.getName()));
        return animalNameList;
    }

    // Support method use to create the animal's name inputted by user
    private static String createAnimalName(List<String> availableAnimalName) {
        String animalName;
        do {
            System.out.print("Enter the animal's name: ");
            animalName = new Scanner(System.in).nextLine();
            if (availableAnimalName.contains(animalName)) {
                System.out.println("The animal name is existed, please use the another one.");
                continue;
            }
            break;
        } while (true);
        return animalName;
    }

    // Support method use to create the animal's speed inputted by user
    private static int createAnimalSpeed() {
        int animalSpeed;
        do {
            System.out.print("Enter the animal's speed: ");
            animalSpeed = new Scanner(System.in).nextInt();
            if (animalSpeed < 0) {
                System.out.println("Please enter the positive value.");
                continue;
            }
            break;
        } while (true);
        return animalSpeed;
    }

    // Support method use to create the animal's ability inputted by user
    private static int createAnimalAbility() {
        boolean keyValue = true;
        while (keyValue) {
            System.out.println("Select the animal ability: ");
            System.out.println("1. Run able.");
            System.out.println("2. Fly able.");
            System.out.println("3. Swim able.");
            System.out.println("4. Run and fly able.");
            System.out.println("5. Run and swim able.");
            System.out.println("6. Fly and swim able.");
            System.out.println("7. All");
            System.out.print("Enter your option: ");
            int userOption = new Scanner(System.in).nextInt();
            switch (userOption) {
                case 1:
                    return AnimalGeneralInformation.RUN_ABLE;
                case 2:
                    return AnimalGeneralInformation.FLY_ABLE;
                case 3:
                    return AnimalGeneralInformation.SWIM_ABLE;
                case 4:
                    return AnimalGeneralInformation.RUN_FLY_ABLE;
                case 5:
                    return AnimalGeneralInformation.RUN_SWIM_ABLE;
                case 6:
                    return AnimalGeneralInformation.FLY_SWIM_ABLE;
                case 7:
                    return AnimalGeneralInformation.ALL;
                default:
                    System.out.println("Please enter the number from 1 to 7");
            }
        }
        return AnimalGeneralInformation.ALL;
    }

    // Support method use to check the animal's ability
    private static boolean checkAbility(LandAbilities animal,int eligibleAbilityNumber)
    {
        switch(eligibleAbilityNumber)
        {
            case 1:
                if(animal.)
        }
    }


}

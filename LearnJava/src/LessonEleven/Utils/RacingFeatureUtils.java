package LessonEleven.Utils;

import LessonEleven.AnimalAbility.*;
import LessonEleven.Animals.AerialAnimals.*;
import LessonEleven.Animals.LandAnimals.*;
import LessonEleven.Animals.MarineAnimals.*;
import LessonEleven.Animals.UserDefineAnimal;
import LessonEleven.RacingFeatureController.AnimalGeneralInformation;

import java.util.*;

public class RacingFeatureUtils {
    public static List<String> getTypeForSignUp() {
        while (true) {
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
                    return new ArrayList<>(Arrays.asList("run"));
                case 2:
                    return new ArrayList<>(Arrays.asList("fly"));
                case 3:
                    return new ArrayList<>(Arrays.asList("swim"));
                case 4:
                    return new ArrayList<>(Arrays.asList("run", "fly"));
                case 5:
                    return new ArrayList<>(Arrays.asList("run", "swim"));
                case 6:
                    return new ArrayList<>(Arrays.asList("fly", "swim"));
                case 7:
                    return new ArrayList<>(Arrays.asList("run", "fly", "swim"));
                default:
                    System.out.println("Please enter the number from 1 to 7");
            }
        }
    }

    public static List<AnimalAbilities> createSignUpReport(List<AnimalAbilities> fullAnimalList, List<String> eligibleAbilityList) {
        List<AnimalAbilities> eligibleAnimalList = new ArrayList<>();
        List<AnimalAbilities> notEligibleAnimalList = new ArrayList<>();

        System.out.println("============================ SIGN UP REPORT ============================");
        System.out.println("========================================================================");
        System.out.println("The eligible animal(s):");
        for (AnimalAbilities animal : fullAnimalList) {
            if (validateAnimalAbility(animal.getAbilitiesList(), eligibleAbilityList)) {
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

    public static AnimalAbilities createAnimal(Map<String, Integer> animalCountList, int number) {
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

    public static String checkAndGetAnimalName(Map<String, Integer> animalCountList, String name) {
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

    public static int inputNumberOfAnimal() {
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

    public static List<String> getAnimalNameList(List<AnimalAbilities> animalList) {
        List<String> animalNameList = new ArrayList<>();
        animalList.forEach(e -> animalNameList.add(e.getName()));
        return animalNameList;
    }

    public static String createAnimalName(List<String> availableAnimalName) {
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

    public static int createAnimalSpeed() {
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

    public static int createAnimalAbility() {
        while (true) {
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
    }

    public static boolean validateAnimalAbility(List<String> animalAbilityList, List<String> eligibleAbilityList) {
        for (String s : animalAbilityList) {
            if (eligibleAbilityList.contains(s)) {
                return true;
            }
        }
        return false;
    }
}

package LessonTen;

import LessonTen.LandAnimals.*;
import LessonTen.AerialAnimals.*;
import LessonTen.MarineAnimals.*;

import java.security.SecureRandom;
import java.util.*;

public class AnimalController {

    private static Map<String, Integer> supportedAnimalList = SupportedAnimalList.getSupportedAnimalList();

    public static List<Animal> generateAnimal() {
        List<Animal> animalList = new ArrayList<>();
        int totalAnimal = inputNumberOfAnimal();
        Map<String, Integer> animalCountList = new HashMap<>();
        for (int index = 0; index < totalAnimal; index++) {
            animalList.add(createAnimal(animalCountList, new SecureRandom().nextInt(supportedAnimalList.size())));
        }
        System.out.println("Generate animals successfully");
        return animalList;
    }

    public static List<Animal> addAnimal(List<Animal> currentAnimalList) {
        List<Animal> addAnimalList = new ArrayList<>();
        int totalAnimal = inputNumberOfAnimal();
        List<String> animalNameList = getAnimalNameList(currentAnimalList);
        for (int index = 0; index < totalAnimal; index++) {
            String animalName;
            do {
                System.out.print("Enter the animal's name: ");
                animalName = new Scanner(System.in).nextLine();
                if (animalNameList.contains(animalName)) {
                    System.out.println("The animal name is existed, please use the another one.");
                    continue;
                }
                break;
            } while (true);
            System.out.print("Enter the animal's speed: ");
            int animalSpeed = new Scanner(System.in).nextInt();
            int animalType = 0;
            do {
                System.out.println("What is the type of this animal: (1) Aerial (2) Land (3) Marine");
                animalType = new Scanner(System.in).nextInt();
                if ((animalType > 3) || (animalType <= 0)) {
                    System.out.println("Please enter the number from 1 to 3.");
                }
            } while (animalType > 3 || animalType <= 0);

            switch (animalType) {
                case 1:
                    addAnimalList.add(new UserDefineAnimal(animalName, animalSpeed, "aerial"));
                    animalNameList.add(animalName);
                    break;
                case 2:
                    addAnimalList.add(new UserDefineAnimal(animalName, animalSpeed, "land"));
                    animalNameList.add(animalName);
                    break;
                case 3:
                    addAnimalList.add(new UserDefineAnimal(animalName, animalSpeed, "marine"));
                    animalNameList.add(animalName);
                    break;
            }
        }
        System.out.println("Add animal(s) successfully.");
        return addAnimalList;
    }

    public static void checkAnimalList(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            System.out.println("There is no any animal in the list. Please add an animal then retry again!");
            return;
        } else {
            System.out.println("The list has " + animalList.size() + " animal(s) include: ");
            for (Animal animal : animalList) {
                System.out.println(animal.toString());
            }
        }
    }

    public static void getAnimalListSupportByProgram() {
        Set<String> programSupportedAnimal = supportedAnimalList.keySet();
        for (String s : programSupportedAnimal) {
            System.out.println(s);
        }
    }

    public static void raceCompetition(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            System.out.println("There is no any animal in the list. Please add an animal then retry again!");
            return;
        }
        List<String> competitionAllowType = getTypeForSignUp();
        List<Animal> newAnimalList = createSignUpReport(animalList, competitionAllowType);
        if (newAnimalList.isEmpty()) {
            System.out.println("There is no any eligible animal for this race, please retry again!");
            return;
        }
        newAnimalList.sort((a1, a2) -> a1.getSpeed() > a2.getSpeed() ? -1 : 1);
        System.out.println("====================== THE RACE COMPETITION BEGIN ======================");
        for (int index = 0; index < newAnimalList.size(); index++) {
            if (index == 0) {
                System.out.printf("The winner is %s, with speed: %d km/h\n"
                        , newAnimalList.get(index).getName(), newAnimalList.get(index).getSpeed());
            } else {
                System.out.printf("The position number %d is %s, with speed: %d km/h\n"
                        , (index + 1), newAnimalList.get(index).getName(), newAnimalList.get(index).getSpeed());
            }
        }
    }

    private static List<String> getTypeForSignUp() {
        boolean keyValue = true;
        while (keyValue) {
            System.out.println("Enter the animal type for the competition: ");
            System.out.println("1. Land");
            System.out.println("2. Aerial");
            System.out.println("3. Marine");
            System.out.println("4. Land and Aerial");
            System.out.println("5. Land and Marine");
            System.out.println("6. Aerial and Marine");
            System.out.println("7. All");
            System.out.print("Enter your option: ");
            int userOption = new Scanner(System.in).nextInt();
            switch (userOption) {
                case 1:
                    return Arrays.asList("land");
                case 2:
                    return Arrays.asList("aerial");
                case 3:
                    return Arrays.asList("marine");
                case 4:
                    return Arrays.asList("land", "aerial");
                case 5:
                    return Arrays.asList("land", "marine");
                case 6:
                    return Arrays.asList("aerial", "marine");
                case 7:
                    return Arrays.asList("land", "aerial", "marine");
                default:
                    System.out.println("Please enter the number from 1 to 7");
            }
        }
        return new ArrayList<>();
    }

    private static List<Animal> createSignUpReport(List<Animal> fullAnimalList, List<String> eligibleList) {
        List<Animal> eligibleAnimalList = new ArrayList<>();
        List<Animal> notEligibleAnimalList = new ArrayList<>();

        System.out.println("============================ SIGN UP REPORT ============================");
        System.out.println("========================================================================");
        System.out.println("The eligible animal(s):");
        for (Animal animal : fullAnimalList) {
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
        for (Animal animal : notEligibleAnimalList) {
            System.out.println(animal.getName());
        }
        System.out.println("");
        return eligibleAnimalList;
    }

    private static Animal createAnimal(Map<String, Integer> animalCountList, int number) {
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
                return new UserDefineAnimal("Undefined", 0, "No Type");
        }
    }

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

    private static List<String> getAnimalNameList(List<Animal> animalList) {
        List<String> animalNameList = new ArrayList<>();
        animalList.stream().forEach(e -> animalNameList.add(e.getName()));
        return animalNameList;
    }

}

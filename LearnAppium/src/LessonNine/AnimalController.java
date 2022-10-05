package LessonNine;

import java.security.SecureRandom;
import java.util.*;

import static LessonNine.Animal.AnimalBuilder;

public class AnimalController {

    private static String[] animalNameList = {"Mouse", "Cat", "Dog", "Tiger", "Lion",
            "Bear", "Pig", "Goat", "Fox", "Cow",
            "Horse", "Rabbit", "Eagle", "Falcon", "Owl", "Snake"};

    public static List<Animal> generateAnimalList() {
        // Init variables
        int totalAnimal;
        Map<String, Integer> animalCountList = new HashMap<>();
        List<Animal> animalList = new ArrayList<>();

        // Get user input
        System.out.printf("Enter the total of animal: ");
        totalAnimal = new Scanner(System.in).nextInt();

        // Auto generate animal
        for (int index = 0; index < totalAnimal; index++) {
            AnimalBuilder animalBuilder = new AnimalBuilder();
            String animalName = getAnimalName(new SecureRandom().nextInt(animalNameList.length));
            int animalSpeed = getAnimalSpeed(animalName);
            boolean flyAbleAnimal = getFlyAbleKey(animalName);
            if (animalCountList.containsKey(animalName)) {
                int newCountNumber = animalCountList.get(animalName) + 1;
                animalList.add(
                        new Animal(animalBuilder
                                .setName(animalName + " " + newCountNumber)
                                .setSpeed(animalSpeed)
                                .setFlyAble(flyAbleAnimal))
                );
                animalCountList.put(animalName, newCountNumber);
            } else {
                animalList.add(
                        new Animal(animalBuilder
                                .setName(animalName + " " + 1)
                                .setSpeed(animalSpeed)
                                .setFlyAble(flyAbleAnimal))
                );
                animalCountList.put(animalName, 1);
            }
        }
        return animalList;
    }

    public static void raceCompetition(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            System.out.println("There is no any animal for this race, please retry again!");
            return;
        }
        List<Animal> eligibleAnimalList = createSignUpReport(animalList);
        if (eligibleAnimalList.isEmpty()) {
            System.out.println("There is no any eligible animal for this race, please retry again!");
            return;
        }
        Collections.sort(eligibleAnimalList, (a1, a2) -> a1.getSpeed() > a2.getSpeed() ? -1 : 1);
        System.out.println("====================== THE RACE COMPETITION BEGIN ======================");
        for (int index = 0; index < eligibleAnimalList.size(); index++) {
            if (index == 0) {
                System.out.printf("The winner is %s, with speed: %d km/h\n"
                        , eligibleAnimalList.get(index).getName(), eligibleAnimalList.get(index).getSpeed());
            } else {
                System.out.printf("The position number %d is %s, with speed: %d km/h\n"
                        , (index + 1), eligibleAnimalList.get(index).getName(), eligibleAnimalList.get(index).getSpeed());
            }
        }
    }

    private static String getAnimalName(int randomNumber) {
        return animalNameList[randomNumber];
    }

    private static int getAnimalSpeed(String animalName) {
        switch (animalName.toLowerCase()) {
            case "mouse":
                return new SecureRandom().nextInt(AnimalMaxSpeed.MOUSE + 1);
            case "cat":
                return new SecureRandom().nextInt(AnimalMaxSpeed.CAT + 1);
            case "dog":
                return new SecureRandom().nextInt(AnimalMaxSpeed.DOG + 1);
            case "tiger":
                return new SecureRandom().nextInt(AnimalMaxSpeed.TIGER + 1);
            case "lion":
                return new SecureRandom().nextInt(AnimalMaxSpeed.LION + 1);
            case "bear":
                return new SecureRandom().nextInt(AnimalMaxSpeed.BEAR + 1);
            case "pig":
                return new SecureRandom().nextInt(AnimalMaxSpeed.PIG + 1);
            case "goat":
                return new SecureRandom().nextInt(AnimalMaxSpeed.GOAT + 1);
            case "fox":
                return new SecureRandom().nextInt(AnimalMaxSpeed.FOX + 1);
            case "cow":
                return new SecureRandom().nextInt(AnimalMaxSpeed.COW + 1);
            case "horse":
                return new SecureRandom().nextInt(AnimalMaxSpeed.HORSE + 1);
            case "rabbit":
                return new SecureRandom().nextInt(AnimalMaxSpeed.RABBIT + 1);
            case "eagle":
                return new SecureRandom().nextInt(AnimalMaxSpeed.EAGLE + 1);
            case "falcon":
                return new SecureRandom().nextInt(AnimalMaxSpeed.FALCON + 1);
            case "owl":
                return new SecureRandom().nextInt(AnimalMaxSpeed.OWL + 1);
            case "snake":
                return new SecureRandom().nextInt(AnimalMaxSpeed.SNAKE + 1);
            default:
                return 0;
        }
    }

    private static boolean getFlyAbleKey(String animalName) {
        switch (animalName.toLowerCase()) {
            case "eagle":
            case "falcon":
            case "owl":
                return true;
            default:
                return false;
        }
    }

    private static List<Animal> createSignUpReport(List<Animal> fullAnimalList) {
        // Init variables
        List<Animal> eligibleAnimalList = new ArrayList<>();
        List<Animal> notEligibleAnimalList = new ArrayList<>();

        // Display data
        System.out.println("============================ SIGN UP REPORT ============================");
        System.out.println("========================================================================");
        System.out.println("The eligible animal(s):");
        for (int index = 0; index < fullAnimalList.size(); index++) {
            if (fullAnimalList.get(index).isFlyAble()) {
                notEligibleAnimalList.add(fullAnimalList.get(index));
            } else {
                eligibleAnimalList.add(fullAnimalList.get(index));
                System.out.println(fullAnimalList.get(index).getName());
            }
        }
        System.out.println("");
        System.out.println("========================================================================");
        System.out.println("The not eligible animal(s):");
        for (int index = 0; index < notEligibleAnimalList.size(); index++) {
            System.out.println(notEligibleAnimalList.get(index).getName());
        }
        System.out.println("");
        return eligibleAnimalList;
    }

}

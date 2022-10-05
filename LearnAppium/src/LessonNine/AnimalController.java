package LessonNine;

import java.security.SecureRandom;
import java.util.*;

import static LessonNine.Animal.AnimalBuilder;

public class AnimalController {

    private static Map<String, Integer> animalDefaultList = AnimalData.getDefaultAnimalData();

    public static void lab9WithAuto() {
        List<Animal> animalList = generateAnimalListAuto();
        raceCompetition(animalList);
    }

    public static void lab9WithManual() {
        List<Animal> animalList = generateAnimalListManual();
        raceCompetition(animalList);
    }

    private static List<Animal> generateAnimalListAuto() {
        // Init variables
        int totalAnimal;
        Map<String, Integer> animalCountList = new HashMap<>();
        List<Animal> animalList = new ArrayList<>();
        animalDefaultList = AnimalData.getDefaultAnimalData();

        // Get user input
        totalAnimal = getTotalAnimal();

        // Auto generate animal
        for (int index = 0; index < totalAnimal; index++) {
            AnimalBuilder animalBuilder = new AnimalBuilder();
            String animalName = getAnimalName(new SecureRandom().nextInt(animalDefaultList.size()));
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

    private static List<Animal> generateAnimalListManual() {
        // Init variables
        int totalAnimal;
        List<Animal> animalList = new ArrayList<>();
        // Get user input
        totalAnimal = getTotalAnimal();

        for (int index = 0; index < totalAnimal; index++) {
            String animalName;
            int animalSpeed;
            int flyAbleKey;
            AnimalBuilder animalBuilder = new AnimalBuilder();
            System.out.printf("Enter information for animal %d:\n", (index + 1));
            System.out.print("Enter animal's name: ");
            animalName = new Scanner(System.in).nextLine();
            System.out.print("Enter animal's speed: ");
            animalSpeed = new Scanner(System.in).nextInt();
            System.out.print("Can this animal fly: \n");
            System.out.print("- Can fly = not 0\n");
            System.out.print("- Cannot fly = 0\n");
            System.out.print("Enter animal fly able option: ");
            flyAbleKey = new Scanner(System.in).nextInt();
            if (flyAbleKey != 0) {
                animalList.add(new Animal(animalBuilder.setName(animalName).setSpeed(animalSpeed).setFlyAble(true)));
            } else {
                animalList.add(new Animal(animalBuilder.setName(animalName).setSpeed(animalSpeed).setFlyAble(false)));
            }
            System.out.println("");
        }
        return animalList;
    }

    private static int getTotalAnimal() {
        int totalAnimal;
        while (true) {
            System.out.print("Enter the total of animal: ");
            totalAnimal = new Scanner(System.in).nextInt();

            if (totalAnimal < 1) {
                System.out.println("Please enter at least one animal for this race competition!");
            } else {
                break;
            }
        }
        return totalAnimal;
    }

    private static String getAnimalName(int randomNumber) {
        Object[] list = animalDefaultList.keySet().toArray();
        return list[randomNumber].toString();
    }

    private static int getAnimalSpeed(String animalName) {
        return new SecureRandom().nextInt(animalDefaultList.get(animalName) + 1);
    }

    private static boolean getFlyAbleKey(String animalName) {
        return switch (animalName.toLowerCase()) {
            case "eagle", "falcon", "owl" -> true;
            default -> false;
        };
    }

    private static List<Animal> createSignUpReport(List<Animal> fullAnimalList) {
        // Init variables
        List<Animal> eligibleAnimalList = new ArrayList<>();
        List<Animal> notEligibleAnimalList = new ArrayList<>();

        // Display data
        System.out.println("============================ SIGN UP REPORT ============================");
        System.out.println("========================================================================");
        System.out.println("The eligible animal(s):");
        for (Animal animal : fullAnimalList) {
            if (animal.isFlyAble()) {
                notEligibleAnimalList.add(animal);
            } else {
                eligibleAnimalList.add(animal);
                System.out.println(animal.getName());
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

    private static void raceCompetition(List<Animal> animalList) {
        List<Animal> eligibleAnimalList = createSignUpReport(animalList);
        if (eligibleAnimalList.isEmpty()) {
            System.out.println("There is no any eligible animal for this race, please retry again!");
            return;
        }

        eligibleAnimalList.sort((a1, a2) -> a1.getSpeed() > a2.getSpeed() ? -1 : 0);
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


}

package LessonEight;

import java.util.*;

public class AnimalController {

    public static List<Animal> generateAnimal(HashMap<String, Integer> totalAnimal) {
        List<Animal> animalList = new ArrayList<>();
        for (int horseIndex = 0; horseIndex < totalAnimal.get("HORSE"); horseIndex++) {
            animalList.add(new Horse("Horse " + (horseIndex + 1)));
        }
        for (int tigerIndex = 0; tigerIndex < totalAnimal.get("TIGER"); tigerIndex++) {
            animalList.add(new Tiger("Tiger " + (tigerIndex + 1)));
        }
        for (int dogIndex = 0; dogIndex < totalAnimal.get("DOG"); dogIndex++) {
            animalList.add(new Dog("Dog " + (dogIndex + 1)));
        }
        return animalList;
    }

    public static void raceCompetition(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            System.out.println("There is no any animal for this race, please retry again!");
            return;
        }
        Collections.sort(animalList, (a1, a2) -> a1.getSpeed() > a2.getSpeed() ? -1 : 1);
        for (int index = 0; index < animalList.size(); index++) {
            if (index == 0) {
                System.out.printf("The winner is %s, with speed: %d km/h\n"
                        , animalList.get(index).getAnimalName(), animalList.get(index).getSpeed());
            } else {
                System.out.printf("The position number %d is %s, with speed: %d km/h\n"
                        , (index + 1), animalList.get(index).getAnimalName(), animalList.get(index).getSpeed());
            }
        }
    }
}

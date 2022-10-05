package LessonNine;

import java.security.SecureRandom;
import java.util.List;

public class LessonNineMainClass {
    public static void main(String[] args) {
        List<Animal> animalList = AnimalController.generateAnimalList();
        AnimalController.raceCompetition(animalList);
    }
}

package LessonEight;

import java.security.SecureRandom;

public class Horse extends Animal {

    public Horse(String animalName) {
        super.setSpeed(new SecureRandom().nextInt(76));
        super.setAnimalName(animalName);
    }


}

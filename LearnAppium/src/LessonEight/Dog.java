package LessonEight;

import java.security.SecureRandom;

public class Dog extends Animal{

    public Dog(String animalName) {
        super.setSpeed(new SecureRandom().nextInt(61));
        super.setAnimalName(animalName);
    }

}

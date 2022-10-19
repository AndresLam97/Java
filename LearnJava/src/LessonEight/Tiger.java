package LessonEight;

import java.security.SecureRandom;

public class Tiger extends Animal{

    public Tiger(String animalName) {
        super.setSpeed(new SecureRandom().nextInt(101));
        super.setAnimalName(animalName);
    }



}

package LessonTen.LandAnimals;

import LessonTen.Animal;

import java.security.SecureRandom;

public class Tiger extends Animal {

    private final String ANIMAL_TYPE = "land";

    public Tiger(String animalName)
    {
        super(animalName,new SecureRandom().nextInt(66));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public String getTYPE() {
        return this.ANIMAL_TYPE;
    }
}

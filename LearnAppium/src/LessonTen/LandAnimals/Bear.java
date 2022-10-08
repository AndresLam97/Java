package LessonTen.LandAnimals;

import LessonTen.Animal;

import java.security.SecureRandom;

public class Bear extends Animal {
    private final String ANIMAL_TYPE = "land";

    public Bear(String animalName)
    {
        super(animalName,new SecureRandom().nextInt(57));
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
